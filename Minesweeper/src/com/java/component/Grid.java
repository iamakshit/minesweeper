package com.java.component;

import com.java.component.common.CustomException;

public class Grid {

	private static Cell[][] cells;
	private static int N; // N*N grid size
	private static int B; // number of bombs

	static Grid gridInstance = null; // Anything inside static has to be static

	// Default constructor is not there once you create your own constructor
	private Grid(int N, int B) {
		Grid.cells = new Cell[N][N];
		Grid.N = N;
		Grid.B = B;
	}

	/******************************************************************/

	public static void isGameOver() {
		int remainingCellsCount = 0;
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				if (cells[i][j].getCellDisplayString() == Cell.DEFAULT_VALUE) {
					remainingCellsCount += 1;
				}
			}
		}
		if (remainingCellsCount == B) {
			System.out.println(" You won the game congrats");
			System.exit(0);
		}

	}

	/******************************************************************/

	public static Grid setUpBoard(int N, int B) throws CustomException {
		validateSetupBoardInputs(N, B);
		if (gridInstance == null) {
			gridInstance = new Grid(N, B);
			initializeCells();
		}
		return gridInstance;
	}

	/******************************************************************/

	public void resetBoard() {
		Grid.cells = new Cell[N][N];
		initializeCells();
	}

	/******************************************************************/

	public static void validateSetupBoardInputs(int N, int B) throws CustomException {
		if (B > ((N * N) / 4)) {
			throw new CustomException("Bombs should be less than the quarter of the grid size");
		}
	}

	/******************************************************************/

	public static void initializeCells() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
		placeBomb();
	}

	/******************************************************************/

	public static void placeBomb() {
		int bombCount = B;
		while (bombCount > 0) {
			int rowNumber = (int) Math.floor((Math.random()) * N);
			int columnNumber = (int) Math.floor((Math.random()) * N);
			Cell cell = cells[rowNumber][columnNumber];
			incrementCountToBomb(rowNumber, columnNumber);
			cell.isBombPlaced = true;
			bombCount -= 1;
		}

	}

	/******************************************************************/

	public static void incrementCountToBomb(int row, int column) {
		if ((row - 1) >= 0) {
			Cell cell = cells[row - 1][column];
			cell.setNumber(cell.getNumber() + 1);
		}
		if ((row + 1) < N) {
			Cell cell = cells[row + 1][column];
			cell.setNumber(cell.getNumber() + 1);
		}
		if ((column - 1) >= 0) {
			Cell cell = cells[row][column - 1];
			cell.setNumber(cell.getNumber() + 1);
		}
		if ((column + 1) < N) {
			Cell cell = cells[row][column + 1];
			cell.setNumber(cell.getNumber() + 1);
		}
	}

	/******************************************************************/

	public void processMove(int row, int column) throws CustomException {
		validateMove(row, column);
		Cell cell = cells[row][column];
		processCell(cell);
		isGameOver();
	}

	/******************************************************************/

	public void validateMove(int row, int column) throws CustomException {

		if (row >= N || row < 0 || column >= N || column < 0) {
			throw new CustomException("Wrong row input"); // An exception has to extend exception class
		}
	}

	/**
	 * @throws CustomException
	 ****************************************************************/

	public void processCell(Cell cell) throws CustomException {

		if (cell.getCellDisplayString() != Cell.DEFAULT_VALUE) {
			throw new CustomException("Cell already choosen"); // An exception has to extend exception class
		}
		if (cell.isBombPlaced) {
			processBombAction();
		}

		exposeWhiteCells(cell);

		if (cell.getNumber() > 0) {
			cell.setCellDisplayString(cell.getNumber().toString());
		}
		System.out.println(cell.getNumber());

	}

	/******************************************************************/

	public void processBombAction() {

		System.out.println("Game over !!!! ");
		displayRealBoard();
		System.exit(0);
	}

	/******************************************************************/

	public void exposeWhiteCells(Cell cell) {
		if (cell.getNumber() != 0 || cell.isVisited) {
			return;
		}
		cell.setVisited(true);
		cell.setCellDisplayString("0");
		Integer rowNumber = cell.getRow();
		Integer columnNumber = cell.getColumn();
		if ((rowNumber - 1) >= 0) {
			Cell nextCell = cells[rowNumber - 1][columnNumber];
			exposeWhiteCells(nextCell);
		}
		if ((rowNumber + 1) < N) {
			Cell nextCell = cells[rowNumber + 1][columnNumber];
			exposeWhiteCells(nextCell);
		}
		if ((columnNumber - 1) >= 0) {
			Cell nextCell = cells[rowNumber][columnNumber - 1];
			exposeWhiteCells(nextCell);
		}
		if ((columnNumber + 1) < N) {
			Cell nextCell = cells[rowNumber][columnNumber + 1];
			exposeWhiteCells(nextCell);
		}
		cell.setVisited(false);
	}

	/******************************************************************/

	public void displayBoard() {

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				System.out.print(cells[i][j].getCellDisplayString() + " ");
			}
			System.out.println();
		}
	}

	/******************************************************************/

	public void displayRealBoard() {

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				if (cells[i][j].isBombPlaced) {
					System.out.print("* ");

				} else {
					System.out.print(cells[i][j].getNumber() + " ");

				}

			}
			System.out.println();
		}
	}
}
