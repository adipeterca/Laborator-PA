package Game;

import java.util.*;

public final class GameManager {

    private final int numberOfTokens;
    private final int n;
    private final double minScore, maxScore;
    private int availableTokens;
    private final Token[] gameTable;
    private final List<Player> playerList;

    boolean isGameFinished;

    public GameManager(int numberOfTokens, int n, double minScore, double maxScore) {
        this.numberOfTokens = numberOfTokens;
        this.n = n;
        this.minScore = minScore;
        this.maxScore = maxScore;
        this.availableTokens = numberOfTokens;
        this.gameTable = new Token[numberOfTokens];
        this.playerList = new LinkedList<>();
    }

    public void start() {
        createTable();

        System.out.println("----------------- Game started! -----------------");

        // Create threads
        Thread[] threadList = new Thread[playerList.size()];
        for (int i = 0; i < threadList.length; i++) {
            threadList[i] = new Thread(playerList.get(i));
        }

        // Run each player
        for (Thread thread : threadList) {
            thread.start();
        }

        while (!isGameFinished) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("----------------------------------------------\n\n");

        System.out.println("------------------- Scores -------------------");
        // Display the scores
        for (Player p : playerList) {
            p.printScore();
        }
        System.out.println("----------------------------------------------\n\n");
    }

    public void addPlayer(Player p) {
        if (!playerList.contains(p)) {
            playerList.add(p);
        }
        else {
            System.out.println("Cannot insert the same player twice.");
        }
    }

    /**
     * Creates the table for the game by assigning each token two numbers between 1 and n, alongside a score between minScore and maxScore.
     */
    private void createTable() {
        isGameFinished = false;
        int firstValue, secondValue;

        for (int i = 0; i < numberOfTokens; i++) {
            do {
                firstValue = (int)(Math.random() * (n - 1) + 1);
                secondValue = (int)(Math.random() * (n - 1) + 1);
            } while (firstValue == secondValue);

            gameTable[i] = new Token(firstValue, secondValue, Math.random() * (maxScore - minScore) + minScore);
        }
        printTable();
    }

    /**
     * Public function that returns the first available token. If no tokens are available, the function marks the game as finished.
     * @return an available token from the game board.
     */
    public Token getFirstAvailableToken() {
        if (availableTokens == 0) {
            // Stop the game and print the scores.
            isGameFinished = true;
            return null;
        }
        for (int i = 0; i < numberOfTokens; i++) {
            if (gameTable[i].isAvailable()) {
                gameTable[i].markAsUnavailable();
                availableTokens--;
                return gameTable[i];
            }
        }
        return null;
    }

    public boolean isGameFinished() {
        return isGameFinished;
    }

    private void printTable() {
        System.out.println("----------------- Game table -----------------");
        for (Token t : gameTable) {
            System.out.println(t);
        }
        System.out.println("----------------------------------------------\n\n");
    }
}
