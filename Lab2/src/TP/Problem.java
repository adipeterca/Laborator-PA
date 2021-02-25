package TP;

import java.util.ArrayList;

public class Problem {

    ArrayList<Cost> costs;
    Source[] sources;
    Destination[] destinations;

    public Problem(Source[] sourceArray, Destination[] destinationArray) {
        System.out.println("An instance of the TP was created!");
        costs = new ArrayList<Cost>();
        sources = sourceArray;
        destinations = destinationArray;
    }

    public void addCost(Source s, Destination d, Integer cost) {
        Cost temp = new Cost(s, d, cost);
        this.costs.add(temp);
    }

    public void printMatrix() {
        System.out.println("--------------------------------");

        int lines = sources.length + 2;
        int columns = destinations.length + 2;
        String[][] matrix = new String[lines][columns];

        matrix[0][0] = " ";
        matrix[0][columns - 1] = "Supply";
        matrix[lines - 1][0] = "Demand";
        matrix[lines - 1][columns - 1] = " ";

        // Map the sources names
        for (int i = 1; i < lines - 1; ++i) {
            matrix[i][0] = sources[i - 1].toString();
        }

        // Map the destinations names
        for (int i = 1; i < columns - 1; ++i) {
            matrix[0][i] = destinations[i - 1].toString();
        }

        // Map the supply
        for (int i = 1; i < lines - 1; ++i) {
            matrix[i][columns - 1] = sources[i - 1].getInitialSupply().toString();
        }

        // Map the demand
        for (int i = 1; i < columns - 1; ++i) {
            matrix[lines - 1][i] = destinations[i - 1].getDemand().toString();
        }

        // Map all the costs
        for (int i = 1; i < lines - 1; ++i) {
            for (int j = 1; j < columns - 1; ++j) {
                matrix[i][j] = getCostFromTo(sources[i - 1], destinations[j - 1]).toString();
            }
        }

        // Printing out the matrix
        for (int i = 0; i < lines; ++i) {
            for (int j = 0; j < columns; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private Integer getCostFromTo(Source from, Destination to) {
        for (int i = 0; i < costs.size(); ++i) {
            if (costs.get(i).getFrom().equals(from) && costs.get(i).getTo().equals(to)) {
                return costs.get(i).getCost();
            }
        }
        return -1;
    }


}
