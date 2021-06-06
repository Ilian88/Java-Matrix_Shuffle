
import javax.print.DocFlavor;
import javax.swing.plaf.IconUIResource;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;

import static java.util.Collections.singleton;
import static java.util.Collections.swap;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

        String line;

        while (!"END".equals(line = scanner.nextLine())) {
            String[] commands = line.split(" ");
            String command = commands[0];

            if (command.equals("swap") && commands.length == 5) {
                int row1 = Integer.parseInt(commands[1]);
                int col1 = Integer.parseInt(commands[2]);
                int row2 = Integer.parseInt(commands[3]);
                int col2 = Integer.parseInt(commands[4]);
                if (row1 < matrix.length && col1 < matrix[row1].length && row2 < matrix.length && col2 < matrix[row1].length) {
                    swapMatrix(matrix, row1, col1, row2, col2);
                    printMatrix(matrix);
                }else {
                    System.out.println("Invalid input!");
                }
            }
            else {
                System.out.println("Invalid input!");
            }
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();

        }
    }

    private static String[][] swapMatrix(String[][] matrix, int row1, int col1, int row2, int col2) {

        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;

        return matrix;
    }
}