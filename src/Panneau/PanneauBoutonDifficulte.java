package Panneau;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import Bouton.BoutonDifficulte;
import Fenetre.Fenetre;
import Type.TypeDifficulte;


public class PanneauBoutonDifficulte extends JPanel{
	private static final long serialVersionUID = 1L;
	private final BoutonDifficulte boutonFacile;
	private final BoutonDifficulte boutonNormal;
	private final BoutonDifficulte boutonDifficile;
	private final BoutonDifficulte boutonPersonnalisee;
	
	public PanneauBoutonDifficulte(Fenetre fenetre, FenetreDifficulte fenetreDifficulte) {
		super();
		setVisible(true);
		setPreferredSize(new Dimension(fenetreDifficulte.getLargeur()*2/3, fenetreDifficulte.getHauteur()*2/3));
		//setBackground(new Color(206,206,255));
		//setLayout(new GridLayout(2,1));
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		add(boutonFacile = new BoutonDifficulte(fenetre, TypeDifficulte.FACILE), c);
		c.gridx = 1;
		c.gridy = 0;
		add(boutonNormal = new BoutonDifficulte(fenetre, TypeDifficulte.NORMAL),c);
		c.gridx = 2;
		c.gridy = 0;
		add(boutonDifficile = new BoutonDifficulte(fenetre, TypeDifficulte.DIFFICILE), c);
		c.gridx = 1;
		c.gridy = 1;
		add(boutonPersonnalisee = new BoutonDifficulte(fenetre, TypeDifficulte.PERSONNALISEE), c);
		ButtonGroup bG = new ButtonGroup();
	    bG.add(boutonFacile);
	    bG.add(boutonNormal);
	    bG.add(boutonDifficile);
	    bG.add(boutonPersonnalisee);
	}
	
}
