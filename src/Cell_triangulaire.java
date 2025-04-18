import java.awt.*;

public class Cell_triangulaire extends Cell{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int down;
	public Cell_triangulaire(int row, int col, int val_col, int val_ligne, int down) {
		super(row , col);
		this.down = down;
		this.val_col = val_col;
		this.val_ligne = val_ligne;
		this.est_master = true;
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setPaint(Color.YELLOW);
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setPaint(Color.black);
		g2.setFont(new Font("Serif", Font.BOLD, 15));
		g2.drawLine(0, 0, this.getWidth(), this.getHeight());
		g2.drawString(Integer.toString(val_col),getWidth()/2 - 20,getHeight()/2+ 20);
		g2.drawString(Integer.toString(val_ligne),getWidth()/2+20,getHeight()/2);
			
		}
	}
	

