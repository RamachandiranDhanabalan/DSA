package com.learning.dsa.arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	static List<Integer> topRow = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
	static List<Integer> midRow = new ArrayList<Integer>(Arrays.asList(4, 5, 6));
	static List<Integer> bottomRow = new ArrayList<Integer>(Arrays.asList(7, 8, 9));
	static List<Integer> topCol = new ArrayList<Integer>(Arrays.asList(1, 4, 7));
	static List<Integer> midCol = new ArrayList<Integer>(Arrays.asList(2, 5, 8));
	static List<Integer> bottomCol = new ArrayList<Integer>(Arrays.asList(3, 6, 9));
	static List<Integer> cross1 = new ArrayList<Integer>(Arrays.asList(1, 5, 9));
	static List<Integer> cross2 = new ArrayList<Integer>(Arrays.asList(3, 5, 7));

	static List<Integer> playerList = new ArrayList<Integer>();
	static List<Integer> cpuList = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// char[][] gameBoard = new char[][] { { ' ', '|', ' ', '|', ' ' }, { '-', '+',
		// '-', '+', '-' },
		// { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ',
		// '|', ' ' } };
		char[][] gameBoard = new char[][] { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		displayGameBoard(gameBoard);

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter placement (1-9)");
			int playerPos = sc.nextInt();
			while (playerList.contains(playerPos) || cpuList.contains(playerPos)) {
				System.out.println("Position already occupied, Please enter new position");
				playerPos = sc.nextInt();
			}
			fillGameBoard(gameBoard, playerPos, "Player");
			playerList.add(playerPos);
			String result = checkWinner(gameBoard);
			if (result != null) {
				System.out.println(result);
				break;
			}

			Random r = new Random();
			int cpuPos = r.nextInt(10);
			while (playerList.contains(cpuPos) || cpuList.contains(cpuPos)) {
				cpuPos = r.nextInt(10);
			}
			fillGameBoard(gameBoard, cpuPos, "CPU");
			cpuList.add(cpuPos);

			if (result != null) {
				System.out.println(result);
				break;
			}

			displayGameBoard(gameBoard);
		}
	}

	public static void displayGameBoard(char[][] gameBoard) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(gameBoard[i][j]);
				if (j < 2)
					System.out.print("|");
			}
			System.out.println();
			if (i < 2)
				System.out.println("-+-+-");
		}

	}

	public static void fillGameBoard(char[][] gameBoard, int pos, String user) {

		char symbol = ' ';
		if (user.equalsIgnoreCase("Player")) {
			symbol = 'X';
		} else if (user.equalsIgnoreCase("CPU")) {
			symbol = 'O';
		}

		switch (pos) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][1] = symbol;
			break;
		case 3:
			gameBoard[0][2] = symbol;
			break;
		case 4:
			gameBoard[1][0] = symbol;
			break;
		case 5:
			gameBoard[1][1] = symbol;
			break;
		case 6:
			gameBoard[1][2] = symbol;
			break;
		case 7:
			gameBoard[2][0] = symbol;
			break;
		case 8:
			gameBoard[2][1] = symbol;
			break;
		case 9:
			gameBoard[2][2] = symbol;
			break;
		default:
			break;
		}
	}

	public static String checkWinner(char[][] gameBoard) {
		List<List<Integer>> winConditions = new ArrayList<List<Integer>>();
		winConditions.add(topRow);
		winConditions.add(midRow);
		winConditions.add(bottomRow);
		winConditions.add(topCol);
		winConditions.add(midCol);
		winConditions.add(bottomCol);
		winConditions.add(cross1);
		winConditions.add(cross2);

		for (List<Integer> l : winConditions) {
			if (playerList.containsAll(l)) {
				return "Player Won!";
			} else if (cpuList.containsAll(l)) {
				return "CPU Won!";
			} else if (playerList.size() + cpuList.size() == 9) {
				return "Draw!";
			}
		}

		return null;
	}
}
