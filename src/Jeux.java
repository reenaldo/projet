import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;





class Jeux extends JFrame implements ItemListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Solver sol = new Solver();
	String [] levels = {"facile", "moyen", "difficile"};
	JComboBox<?> boite;
	JPanel panel = new JPanel();
	static int  deg;
	Container c;
	Grille g;
	JButton b1, b2, b3, b4;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Jeux(int deg) {
		Jeux.deg = deg;
		setTitle("kakuru");
		
	    
	     
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setSize(120*deg, 120*deg);
	     c = getContentPane();
	     	c.setLayout(new BorderLayout());
	     	panel.setBackground(Color.LIGHT_GRAY);
			ButtonGroup gr = new ButtonGroup();
			b1 = new JButton("solve");
			b1.addActionListener(this);
			gr.add(b1);
			panel.add(b1);
			b2 = new JButton("Checker");
			b2.addActionListener(this);
			gr.add(b2);
			panel.add(b2);
			b3 = new JButton("Hint");
			b3.addActionListener(this);
			gr.add(b3);
			panel.add(b3);
			
			b4 = new JButton("Nouvelle grille");
			b4.addActionListener(this);
			gr.add(b4);
			panel.add(b4);
			
			boite = new JComboBox(levels);
			boite.addItemListener(this);
			panel.add(boite);
			//add(panel);
			c.add("North",panel);
	     
	     
	     
	     g = new Grille(deg, deg);
	     g.paint_without_solution();
	     c.add(g);
	     
	     
	     
		
		
		
		
	}
	@Override
	public void itemStateChanged(ItemEvent i) {
		int choix = boite.getSelectedIndex();
		switch(choix) {
		case 0:
			deg = 5;
			setSize(120*deg, 120*deg);
			c.remove(g);
			g = new Grille(deg, deg);
			g.paint_without_solution();
			c.add(g);
			
			break;
		case 1:
			deg = 7;
			setSize(120*deg, 120*deg);
			c.remove(g);
			g = new Grille(deg, deg);
			g.paint_without_solution();
			c.add(g);
			break;
		case 2:
			deg = 9;
			setSize(120*deg, 120*deg);
			c.remove(g);
			g = new Grille(deg, deg);
			g.paint_without_solution();
			c.add(g);
			
			break;
		}
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			setSize(120*deg, 120*deg);
			c.remove(g);
			//g = new Grille(deg, deg);
			g.paint_grille();
			c.add(g);
			
		}
		
		if (e.getSource() == b2) {
			//sol.check_kakuru(g);
			JFrame jFrame = new JFrame();
			boolean control = sol.check_kakuru(g);
	        if (control) JOptionPane.showMessageDialog(jFrame, "BRAVO, bien joué ! BIG UP");
	        else JOptionPane.showMessageDialog(jFrame, "OUPS, perdu ! Vous pouvez toujours tenter votre chance, LETS GO");
			
		}
		if (e.getSource() == b3) {
			int nb1 = 0,nb2 = 0;
			Random random = new Random();
			boolean tst = false;
			while (!tst) {
				nb1 = random.nextInt(g.row-1)+1;
				nb2 = random.nextInt(g.row-1)+1;
				if ((g.solution[nb1-1][nb2-1]).est_white) tst = true;
			}
			c.remove(g);
			((Cell_white)g.solution[nb1-1][nb2-1]).valeur = ((Cell_white)g.grill[nb1-1][nb2-1]).valeur; 
			((Cell_white)g.solution[nb1-1][nb2-1]).text.setText(Integer.toString(((Cell_white)g.grill[nb1-1][nb2-1]).valeur));
			g.paint_without_solution();
			c.add(g);
		}
		
		if (e.getSource() == b4) {
			setSize(120*deg, 120*deg);
			c.remove(g);
			g = new Grille(deg, deg);
			g.paint_without_solution();
			c.add(g);
			c.repaint();
			c.validate();
			
		}
		
	}
	     
	}


