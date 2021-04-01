package game;

import java.util.Scanner;

public class GameShell {

    private GameManager gameManager;

    public GameShell() {

    }

    public void setupGame() {
        Scanner scanner = new Scanner(System.in);

        int numberOfTokens;
        int n;
        double minScore, maxScore;

        System.out.println("Hello and welcome to the TSP Game! Input the starting conditions:");
        System.out.print("Number of tokens: ");
        numberOfTokens = scanner.nextInt();

        System.out.print("The number N: ");
        n = scanner.nextInt();

        System.out.print("The minimum score for a token: ");
        minScore = scanner.nextInt();

        System.out.print("The maximum score for a token: ");
        maxScore = scanner.nextInt();

        gameManager = new GameManager(numberOfTokens, n, minScore, maxScore);

        System.out.print("Number of players: ");
        int numberOfPlayers = scanner.nextInt();
        String name;
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Player " + i + ": ");
            name = scanner.next();
            gameManager.addPlayer(new Player(name, gameManager));
        }
    }

    public void startGame() {
        gameManager.start();
    }

}
