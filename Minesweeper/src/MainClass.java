import java.util.Scanner;

import com.java.component.Grid;
import com.java.component.common.CustomException;

public class MainClass {
//if Integer is null, then setting int with Integer will give NPE
	public static void main(String args[]) {
		Scanner ak = new Scanner(System.in);
		System.out.println("Enter the grid size");
		Integer N = Integer.parseInt(ak.nextLine());
		System.out.println("Enter the number of bombs");
		Integer B = Integer.parseInt(ak.nextLine());
		Grid grid = null;
		try {
			grid = Grid.setUpBoard(N, B);
			grid.displayBoard();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.exit(0);
		}

		while (true) {
			try {
				System.out.println("Enter the row Number");
				int row = Integer.parseInt(ak.nextLine());
				System.out.println("Enter the column Number");
				int column = Integer.parseInt(ak.nextLine());
				grid.processMove(row, column);
				grid.displayBoard();
			} catch (CustomException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
