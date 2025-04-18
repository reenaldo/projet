import java.awt.*;


public class Cell_black extends Cell {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5798367529154398962L;

	public Cell_black(int posx, int posy) {
		super(posx, posy);
		this.est_master = false;
		setBackground(Color.decode("#000000"));
        setLayout(new GridBagLayout());
	}
		
	}

