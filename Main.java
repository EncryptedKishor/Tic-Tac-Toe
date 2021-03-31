package com.tictactoe.kishor;

import java.util.*;

public class Main {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[] [] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-','+', '-'},
                {' ', '|', ' ','|', ' '},
                {'-', '+', '-','+', '-'},
                {' ', '|', ' ','|', ' '}};

        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9):");
            int playerPosition = scan.nextInt();
//        System.out.println(position);
            placePiece(gameBoard, playerPosition,"Player");

            Random rand= new Random();
            int cpuPosition = rand.nextInt(9) + 1;
            placePiece(gameBoard, cpuPosition,"CPU");

            printGameBoard(gameBoard);
            String result = checkWinner();
            System.out.println(result);
        }

    }
    public static void printGameBoard(char[] [] gameBoard) {
        for(char[] row : gameBoard) {
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void placePiece(char[][] gameBoard, int position, String user) {
        char symbol = ' ';
        if(user.equals("Player")) {
            symbol = 'X';
            playerPositions.add(position);
        } else if(user.equals("CPU")) {
            symbol = '0';
            cpuPositions.add(position);
        }
        switch(position) {
            case 1:
                gameBoard [0][0] = symbol;
                break;
            case 2:
                gameBoard [0][2] = symbol;
                break;
            case 3:
                gameBoard [0][4] = symbol;
                break;
            case 4:
                gameBoard [2][0] = symbol;
                break;
            case 5:
                gameBoard [2][2] = symbol;
                break;
            case 6:
                gameBoard [2][4] = symbol;
                break;
            case 7:
                gameBoard [4][0] = symbol;
                break;
            case 8:
                gameBoard [4][2] = symbol;
                break;
            case 9:
                gameBoard [4][4] = symbol;
                break;
            default:
                break;
        }
    }
    public static String checkWinner() {
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(botRow);
        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(rightCol);
        winningConditions.add(cross1);
        winningConditions.add(cross2);

        for(List l : winningConditions) {
            if(playerPositions.containsAll(l)) {
                return "Congratulation you won!";
            }
            else if(playerPositions.containsAll(l)) {
                return "CPU Wins!";
            }
            else if(playerPositions.size()+ cpuPositions.size() == 9) {
                return "CAT";
            }
        }
        return "";
    }
}
