import Game.GameManager;
import Game.Player;

import java.awt.*;
import java.util.Scanner;

public class Main {
    private static GameManager gameManager;
    public static void main(String[] args) {
        setupGame();
        startGame();
    }

    public static void setupGame() {
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

    public static void startGame() {
        gameManager.start();
    }

}
