import javax.swing.*;
import java.awt.*;


public class Cell extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	int posx, posy;
	boolean est_master = false;
	boolean est_white = false;
	int val_col, val_ligne;
	public Cell(int posx, int posy) {
		this.posx = posx;
		this.posy = posy;
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}
}
