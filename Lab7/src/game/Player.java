package game;

import java.util.LinkedList;
import java.util.List;

public final class Player implements Runnable {
    private final String name;

    private final GameManager gameManager;

    private final List<Token> tokenList;

    public Player(String name, GameManager gameManager) {
        this.name = name;
        this.gameManager = gameManager;
        tokenList = new LinkedList<>();
    }

    @Override
    public void run() {
        while (!gameManager.isGameFinished()) {
            // Lock the game
            synchronized (gameManager)
            {
                getTokenFromBoard();
            }
            try {
                // Sleep between 100ms and 300ms
                Thread.sleep((long) (Math.random() * 200 + 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void getTokenFromBoard() {
        Token t = gameManager.getFirstAvailableToken();
        if (t != null) {
            tokenList.add(t);
            System.out.println("Player " + name + " extracted token (" + t.getFirstNumber() + ", " + t.getSecondNumber() + ")");
        }
        else {
            System.out.println("Player " + name + " extracted a null token");
        }
    }

    public void printScore() {
        System.out.println("Player " + name + " finished! List count : " + tokenList.size());
    }

}
