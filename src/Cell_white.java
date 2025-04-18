import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Cell_white extends Cell implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int valeur;
	JTextField text;
	public Cell_white(int row, int col) {
		super(row, col);
		this.est_white = true;
		this.val_col = -1;
		this.val_ligne = -1;
		text = new JTextField(15);
		text.setBounds(45, 25, 30, 50);
		setLayout(null);
		text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		text.setFont(new Font("Serif", Font.BOLD, 20));
		text.setEditable(true);
		text.setPreferredSize(new Dimension(20,20));
		add(text);
		text.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) { 
		text.setDocument(new LimitJTextField(1));
		// TODO Auto-generated method stub
		int n = e.getKeyChar();
		String c = "0" + e.getKeyChar();
		if (!Character.isDigit(n)) e.consume();
		else this.valeur = Integer.parseInt(c);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}



