/******************************************************
Cours:  LOG121
Projet: Laboratoire #1
Nom du fichier: FenetrePrincipale.java
Date créé: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
 *@author Antoine de Villers
 *@author �tienne Rousseau
2016-01-22 Version finale
 *******************************************************/  

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

/**
 * Cette classe représente la fenêtre principale de l'application 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener{

	private static final long serialVersionUID = -1210804336046370508L;
	FenetreFormes fenetreFormes;

	/**
	 * Constructeur
	 */
	public FenetrePrincipale(CommBase comm){

		MenuFenetre menu = new MenuFenetre(comm);
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH); 
		this.fenetreFormes = new FenetreFormes();
		this.add(fenetreFormes, BorderLayout.CENTER); // Ajoute la fenêtre de forme à la fenètre principale
		this.pack(); // Ajuste la dimension de la fenêtre principale selon celle de ses composants
		this.setVisible(true); // Rend la fenêtre principale visible.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //... à réviser selon le comportement que vous désirez ...
	}

	// Appelé lorsque le sujet lance "firePropertyChanger"
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

		if(arg0.getPropertyName().equals("ENVOIE-TEST")){
			fenetreFormes.creerFormes((String) arg0.getNewValue());
		}
	}
}
