package com.java.component;

/**
 * @author akshitgupta
 *
 */
public class Cell {

	Integer number = 0;
	Integer row;
	Integer column;
	boolean isBombPlaced = false;
	String cellDisplayString = DEFAULT_VALUE;
	static String DEFAULT_VALUE = "?";
	boolean isVisited = false;

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public Cell(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	public boolean isBombPlaced() {
		return isBombPlaced;
	}

	public void setBombPlaced(boolean isBombPlaced) {
		this.isBombPlaced = isBombPlaced;
	}

	public String getCellDisplayString() {
		return cellDisplayString;
	}

	public void setCellDisplayString(String cellDisplayString) {
		this.cellDisplayString = cellDisplayString;
	}

}
