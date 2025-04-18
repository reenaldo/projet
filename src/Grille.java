import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Grille extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Solver sol = new Solver();
	Cell grill[][];
	Cell solution[][];
	int row, col;
	public Grille (int row, int col) {
		super(new GridLayout(row,col, 2, 2));
		this.row = row;
		this.col = col;
		grill = new Cell[row][col];
		solution = new Cell[row][col];
		Random random = new Random();
		int nb1, nb2;
		//genrer un nombre aleatoire d cellule triangulaire
		int nb_cel_master = (15*row*col)/100 -1;
		int k = 0;
		while (k<nb_cel_master) {
			nb1 = random.nextInt(row-1)+1;
			nb2 = random.nextInt(row-1)+1;
			if (grill[nb1][nb2] == null) {
					grill[nb1][nb2] = new Cell_triangulaire(nb1,nb2, -1,-1, 2);
					solution[nb1][nb2] = new Cell_triangulaire(nb1,nb2, -1,-1, 2);
					k++;
					}
		}
		grill[0][0] = new Cell_black(0,0);
		grill[row-1][0] = new Cell_black(row-1,0);
		solution[0][0] = new Cell_black(0,0);
		solution[row-1][0] = new Cell_black(row-1,0);
		for (int j = 1; j<col; j++) {
			grill[0][j] = new Cell_triangulaire(0, j, -1,0, 0); 
			solution[0][j] = new Cell_triangulaire(0, j, -1,0, 0);
			if (grill[1][j] != null) grill[0][j] = new Cell_black(0,j);
			if (solution[1][j] != null) solution[0][j] = new Cell_black(0,j);
		}
		for (int i = 1; i<row; i++) {
			grill[i][0] = new Cell_triangulaire(i, 0, 0,-1, 1);
			if (grill[i][1] != null) grill[i][0] = new Cell_black(i,0);
			solution[i][0] = new Cell_triangulaire(i, 0, 0,-1, 1);
			if (grill[i][1] != null) solution[i][0] = new Cell_black(i,0);
		}
		for (int i = 0; i<row; i++) {
			for (int j =0; j<col; j++) {
				if (grill[i][j] == null) {
					grill[i][j] = new Cell_white(i, j);
					solution[i][j] = new Cell_white(i, j);
					//((Cell_white)grill[i][j]).valeur = 3;	
				}	
			}
		}
		sol.solv_kakuru(this);
		for (int i = 0; i<row; i++) {
			for (int j =0; j<row; j++) {
				if (grill[i][j].est_white)  ((Cell_white)grill[i][j]).text.setText(Integer.toString(((Cell_white)grill[i][j]).valeur));
			}
		}
		
	}
	
	
	//methodes
	public void paint_grille() {
		for (int i = 0; i<row; i++) {
			for (int j =0; j<col; j++) {
				if (grill[i][j].est_white) {
					((Cell_white)solution[i][j]).valeur = ((Cell_white)grill[i][j]).valeur;
					((Cell_white)solution[i][j]).text.setText(Integer.toString(((Cell_white)grill[i][j]).valeur));
				}
			}
		}
	}
	
	public void paint_without_solution() {
		for (int i = 0; i<row; i++) {
			for (int j =0; j<col; j++) {
				add(solution[i][j]);
			}
		}
	}
}























	


