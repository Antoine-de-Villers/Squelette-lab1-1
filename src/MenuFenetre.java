/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: MenuFenetre.java
Date créé: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
 *@author Antoine de Villers
 *@author �tienne Rousseau
2016-01-28 Version finale
 *******************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 * Crée le menu de la fenêtre de l'applicationé
 */
public class MenuFenetre extends JMenuBar {

	private static final long serialVersionUID = 1536336192561843187L;
	private static final int MENU_FICHIER_QUITTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_FICHIER_QUITTER_TOUCHE_RACC = KeyEvent.VK_Q;
	private static final int MENU_FICHIER_OBTENIRFORME_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_FICHIER_OBTENIRFORME_TOUCHE_RACC = KeyEvent.VK_Q;
	private static final int MENU_SERVEUR_CONNECTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_SERVEUR_CONNECTER_TOUCHE_RACC = KeyEvent.VK_C;
	private static final int MENU_SERVEUR_DECONNECTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_SERVEUR_DECONNECTER_TOUCHE_RACC = KeyEvent.VK_D;
	private static final String MENU_FICHIER_TITRE = "app.frame.menus.file.title",
			MENU_FICHIER_QUITTER = "app.frame.menus.file.exit",
			MENU_FICHIER_OBTENIRFORME = "app.frame.menus.file.getForme",
			MENU_ORDRE_TITRE = "app.frame.menus.order.title",
			MENU_AIDE_TITRE = "app.frame.menus.help.title", MENU_AIDE_PROPOS = "app.frame.menus.help.about",
			MENU_SERVEUR_TITRE = "app.frame.menus.server.title",
			MENU_SERVEUR_CONNECTER = "app.frame.menus.server.connect",
	        MENU_SERVEUR_DECONNECTER = "app.frame.menus.server.disconnect";

	private static final String MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about";

	private JMenuItem arreterMenuItem, demarrerMenuItem, arreterCommMenuItem, demarrerCommMenuItem;
	private static final int DELAI_QUITTER_MSEC = 200;
	private static String[] parts;
	private static String port = null;
	private static String hostName = null;
	private static int portNum;

	CommBase comm; // Pour activer/désactiver la communication avec le serveur

	/**
	 * Constructeur
	 */
	public MenuFenetre(CommBase comm) {
		this.comm = comm;
		addMenuFichier();
		addMenuOrdre();
		addMenuServeur();
		addMenuAide();
		rafraichirMenus();
	}
    /**
     * Cr�e le menu Serveur
     */
	private void addMenuServeur() {
		JMenu menu = creerMenu(MENU_SERVEUR_TITRE, new String[] { MENU_SERVEUR_CONNECTER, MENU_SERVEUR_DECONNECTER });
		demarrerCommMenuItem = menu.getItem(0);
		demarrerCommMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = (String) JOptionPane.showInputDialog(null,
						"Quel est le nom d'h�te et le port du serveur de formes?", "localhost:10000");
				SeparerHostPortServeur(s);
				rafraichirMenus();
			}
		});
		demarrerCommMenuItem.setAccelerator(
				KeyStroke.getKeyStroke(MENU_SERVEUR_CONNECTER_TOUCHE_RACC, MENU_SERVEUR_CONNECTER_TOUCHE_MASK));
		arreterCommMenuItem = menu.getItem(1);
		arreterCommMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.stopComm();
				rafraichirMenus();
			}
		});
		arreterCommMenuItem.setAccelerator(
				KeyStroke.getKeyStroke(MENU_SERVEUR_DECONNECTER_TOUCHE_RACC, MENU_SERVEUR_DECONNECTER_TOUCHE_MASK));
		add(menu);
	}

	private void addMenuOrdre(){
	JMenu menu = creerMenu(MENU_ORDRE_TITRE, new String[]{});	
	JRadioButtonMenuItem sequenceCroissante = new JRadioButtonMenuItem("Sequence croissante");
	JRadioButtonMenuItem sequenceDecroissante = new JRadioButtonMenuItem("Sequence decroissante");
	JRadioButtonMenuItem aireCroissante = new JRadioButtonMenuItem("Aire croissante");
	JRadioButtonMenuItem aireDecroissante = new JRadioButtonMenuItem("Aire decroissante");
	JRadioButtonMenuItem forme = new JRadioButtonMenuItem("Formes");
	JRadioButtonMenuItem formeInverse = new JRadioButtonMenuItem("Formes inversees");
	JRadioButtonMenuItem distance = new JRadioButtonMenuItem("Distance maximale entre deux points");
	ButtonGroup group = new ButtonGroup();
	group.add(sequenceCroissante);
	group.add(sequenceDecroissante);
	group.add(aireCroissante);
	group.add(aireDecroissante);
	group.add(forme);
	group.add(formeInverse);
	group.add(distance);
	menu.add(sequenceCroissante);
	menu.add(sequenceDecroissante);
	menu.add(aireCroissante);
	menu.add(aireDecroissante);
	menu.add(forme);
	menu.add(formeInverse);
	menu.add(distance);
	}
	
	
	/**
	 * Menu Serveur
	 * 
	 * @param s = Le nom d'h�te et le port du serveur de formes
	 */
	private void SeparerHostPortServeur(String s) {
		try {
			parts = s.split(":");
			hostName = parts[0];
			port = parts[1];
			portNum = Integer.parseInt(port);
			comm.readyComm();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Le port doit �tre un nombre", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Vous devez s�parer le hostname et le numero de port par :", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		comm.variablesSocket(portNum, hostName);
	}

		/**
	 * Créer le menu "File".
	 */
	protected void addMenuFichier() {
		JMenu menu = creerMenu(MENU_FICHIER_TITRE, new String[] { MENU_FICHIER_QUITTER, MENU_FICHIER_OBTENIRFORME });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.stopComm();
				try {
					Thread.sleep(DELAI_QUITTER_MSEC);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		menu.getItem(0).setAccelerator(
				KeyStroke.getKeyStroke(MENU_FICHIER_QUITTER_TOUCHE_RACC, MENU_FICHIER_QUITTER_TOUCHE_MASK));
		add(menu);
	}

	/**
	 * Créer le menu "Help".
	 */
	private void addMenuAide() {
		JMenu menu = creerMenu(MENU_AIDE_TITRE, new String[] { MENU_AIDE_PROPOS });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, LangueConfig.getResource(MESSAGE_DIALOGUE_A_PROPOS),
						LangueConfig.getResource(MENU_AIDE_PROPOS), JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(menu);
	}

	
	/**
	 * Activer ou désactiver les items du menu selon la sélection.
	 */
	public void rafraichirMenus() {
		demarrerMenuItem.setEnabled(!comm.isActif()&&comm.isReady());
		arreterMenuItem.setEnabled(comm.isActif()&&comm.isReady());
		demarrerCommMenuItem.setEnabled(!comm.isReady());
		arreterCommMenuItem.setEnabled(comm.isReady());

	}
	
	/**
	 * Créer un élément de menu à partir d'un champs principal et ses
	 * éléments
	 * 
	 * @param titleKey
	 *            champs principal
	 * @param itemKeys
	 *            éléments
	 * @return le menu
	 */
	private static JMenu creerMenu(String titleKey, String[] itemKeys) {
		JMenu menu = new JMenu(LangueConfig.getResource(titleKey));
		for (int i = 0; i < itemKeys.length; ++i) {
			menu.add(new JMenuItem(LangueConfig.getResource(itemKeys[i])));
		}
		return menu;
	}
}
