package Bouton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import Fenetre.Fenetre;
import Type.TypeBouton;

public class BoutonGenerique extends JButton implements ActionListener{
	private static final long serialVersionUID = 1L;
	private final Fenetre fenetre;
	private final TypeBouton type;
	private JLabel label2;

	
	public BoutonGenerique(Fenetre fenetre, TypeBouton type) {
		super();
		this.fenetre = fenetre;
		this.type = type;
		setVisible(true);
		setBackground(new Color(206,206,255));
		
		addActionListener(this);
		switch(type) {
			case COMMENCER:
				setText("Commencer");
				setPreferredSize(new Dimension(105, 50));
				break;
			case RECOMMENCER:
				setPreferredSize(new Dimension(150, 75));
				setLayout(new GridBagLayout());
				GridBagConstraints c = new GridBagConstraints();
				c.anchor = GridBagConstraints.CENTER;
				c.weighty = 1.0;
				c.gridy = 0;
				add(new JLabel("Perdu !"), c);
				c.weighty = 1.0;
				c.gridy = 1;
				add(label2 = new JLabel("Score : 0:0:0"), c);
				c.weighty = 1.0;
				c.gridy = 2;
				add(new JLabel("Recommencer ?"), c);
				break;
			case REPRENDRE:
				setText("Reprendre");
				setPreferredSize(new Dimension(95, 50));
				break;
			case OK:
				setText("OK");
				break;
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		switch(type) {
		case RECOMMENCER:
			fenetre.reinitialiser();
		case COMMENCER:
		case REPRENDRE:
			fenetre.resume();
			break;
		case OK:
			fenetre.fermerFenetreDifficulte();
			break;
		}
	}
	
	public void actualiser() {
		switch(type) {
		case RECOMMENCER:
			GridBagConstraints c = new GridBagConstraints();
			c.anchor = GridBagConstraints.CENTER;
			c.weighty = 1.0;
			c.gridy = 1;
			remove(label2);
			label2 = new JLabel("Score : " + fenetre.getTemps());
			add(label2, c);
			revalidate();
			repaint();
			break;
		default:
			break;
	
		}
	}

}
