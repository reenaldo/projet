import java.util.Random;


public   class Solver {

	//solver pour le kakuru
	public void solv_kakuru(Grille g) {
		Random random = new Random();
		boolean exist = true;
		int nb1 = 0;  
		int i = 0, j = 0,k, col_tmp, col_tmp2;
		while (i <g.row) {
			j = 0;
			while (j < g.col) {
				if (g.grill[i][j].est_master) {
					int somme_ligne = g.grill[i][j].val_ligne; 
					int somme_col = g.grill[i][j].val_col;
					if (somme_col == -1) {
						somme_col = 0;
						k = i +1;
						while (k!=g.row) {
							if (g.grill[k][j].est_master) break;
							while (exist) {
								nb1 = random.nextInt(9)+1;
								col_tmp = j+1;
								col_tmp2 = j-1;
								exist = false;
								while (!exist && col_tmp!=g.row) {
									if (g.grill[k][col_tmp].est_master) break;
									if (((Cell_white)g.grill[k][col_tmp]).valeur == nb1) exist = true;
									col_tmp++;	
								}
								while (!exist && col_tmp2!=-1) {
									if (g.grill[k][col_tmp2].est_master) break;
									if (((Cell_white)g.grill[k][col_tmp2]).valeur == nb1) exist = true;
									col_tmp2 = col_tmp2-1;	
								}
								int tmp = k;
								while (tmp != i) {
									if (((Cell_white)g.grill[tmp][j]).valeur == nb1) exist =true;
									tmp = tmp-1;
								}
							}
							if (((Cell_white)g.grill[k][j]).valeur == 0) ((Cell_white)g.grill[k][j]).valeur = nb1;
							somme_col +=  ((Cell_white)g.grill[k][j]).valeur; 
							exist = true;
							k++;
						}
						g.grill[i][j].val_col = somme_col;
						g.solution[i][j].val_col = somme_col;
						
					}
					if (somme_ligne == -1) {
						somme_ligne = 0;
						k = j +1;
						while (k!=g.row) {
							if (g.grill[i][k].est_master) break;
							while (exist == true) {
								nb1 = random.nextInt(9)+1;
								col_tmp = i+1;
								col_tmp2 = i-1;
								exist = false;
								while (!exist && col_tmp!=g.row) {
									if (g.grill[col_tmp][k].est_master) break;
									if (((Cell_white)g.grill[col_tmp][k]).valeur == nb1) exist = true;
									col_tmp++;	
								}
								while (!exist && col_tmp2!=-1) {
									if (g.grill[col_tmp2][k].est_master) break;
									if (((Cell_white)g.grill[col_tmp2][k]).valeur == nb1) exist = true;
									col_tmp2 = col_tmp2 -1;	
								}
								
							}
							if (((Cell_white)g.grill[i][k]).valeur == 0) ((Cell_white)g.grill[i][k]).valeur = nb1;
							somme_ligne += ((Cell_white)g.grill[i][k]).valeur; 
							exist = true;
							k++;
						}
						g.grill[i][j].val_ligne = somme_ligne;
						g.solution[i][j].val_ligne = somme_ligne;
					}
				}
				j++;
			}
			i++;
		}
}
	
	public boolean check_kakuru(Grille g) {
		int i = 0, j = 0,k, somme;
		while (i < g.row) {
			j = 0;
			while (j< g.col) {
				if (g.solution[i][j].est_master) {
					int somme_ligne = g.solution[i][j].val_ligne;
					int somme_col = g.solution[i][j].val_col;
					if (somme_ligne != 0) {
						k = j+1;// recuperer la position ligne
						// boucle d'arret : tant que on a pas atteint les bordures
						//et tant que on rencentre pas une cellule triangulaire
						somme = 0;
						while (k!=g.row) {	
							if (g.grill[i][k].est_master) break;
							somme += ((Cell_white)g.solution[i][k]).valeur;
							k++;
						}
						if (somme != somme_ligne) return false;
					}
					
					if (somme_col != 0) {
						k = i+1;// recuperer la position ligne
						// boucle d'arret : tant que on a pas atteint les bordures
						//et tant que on rencentre pas une cellule triangulaire
						somme = 0;
						while (k!=g.row) {
							if (g.solution[k][j].est_master)  break;
							somme += ((Cell_white)g.solution[k][j]).valeur;
							k++;
						}
						if (somme != somme_col) return false;
						
				}
			}
				j++;
		}
			i++;
	}

	return true;
	}
	
}

