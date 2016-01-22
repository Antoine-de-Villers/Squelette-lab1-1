/******************************************************
Cours:  LOG121
Projet: Laboratoire #1
Nom du fichier: CommBase.java
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

import java.beans.PropertyChangeListener;
import java.io.*;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Base d'une communication via un fil d'exécution parallèle.
 */
public class CommBase {

	private final int DELAI = 1000;
	@SuppressWarnings("rawtypes")
	private SwingWorker threadComm =null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
	private boolean isReady = false;
	private Socket socket;
	private BufferedReader reader;
	private BufferedWriter writer;
	private InputStream inS;
	private OutputStream outS;
	private String info = null;
	private int port=0;
	private String hostname=null;


	/**
	 * Constructeur
	 */
	public CommBase(){
	}

	/**
	 * D�finir le r�cepteur de l'information re�ue dans la communication avec le serveur
	 * @param listener sera alerté lors de l'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}

	/**
	 * Démarre la communication
	 */
	public void start(){
		creerCommunication();
	}
	
	public void readyComm(){
		try{
		socket = new Socket(hostname,port);
		outS = socket.getOutputStream();
		inS= socket.getInputStream();
		reader = new BufferedReader(new InputStreamReader(inS));
		writer = new BufferedWriter(new OutputStreamWriter(outS));
		isReady=true;
		}catch(ConnectException e){
			JOptionPane.showMessageDialog(null, "La connection n'a pas pu �tre �tablie", "Error",
					JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Arrête la communication
	 */
	public void stop(){
		if(threadComm!=null)
			threadComm.cancel(true); 
		isActif = false;
	}
	
	public void stopComm(){
		stop();
			try {
				writer.write("END\n");
				writer.flush();
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		port=0;
		hostname=null;
		isReady= false;
	}

	public void variablesSocket(int portNum, String host){
		port = portNum;
		hostname = host;
	}

	/**
	 * Créer le nécessaire pour la communication avec le serveur
	 */
	protected void creerCommunication(){
		// Crée un fil d'exécusion parallèle au fil courant,
		threadComm = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				System.out.println("Le fils d'execution parallele est lance");
				while(true){
					Thread.sleep(DELAI);
					// C'EST DANS CETTE BOUCLE QU'ON COMMUNIQUE AVEC LE SERVEUR
					try{
						writer.write("GET\n");
						writer.flush();
						reader.readLine(); //skip la ligne command>
						info=reader.readLine();
					}catch(SocketException e){
						isReady=false;
						firePropertyChange("CONNECTION INTERROMPUE",null,null);
						JOptionPane.showMessageDialog(null, "La connection a �t� perdue", "Error",
								JOptionPane.ERROR_MESSAGE);
						writer.write("END\n");
						writer.flush();
						socket.close();	
					}
					catch(Exception e){
						e.printStackTrace();
						writer.write("END\n");
						writer.flush();
						socket.close();
						isReady=false;
					}
					//La méthode suivante alerte l'observateur 
					System.out.println(info);
					if(listener!=null)
						firePropertyChange("ENVOIE", null, (Object) info); 
				}
				//return null;
			}
		};
		if(listener!=null)
			threadComm.addPropertyChangeListener(listener); // La méthode "propertyChange" de ApplicationFormes sera donc appelée lorsque le SwinkWorker invoquera la méthode "firePropertyChanger" 		
		threadComm.execute(); // Lance le fil d'exécution parallèle.
		isActif = true;
		}

	/**
	 * @return si le fil d'exécution parallèle est actif
	 */
	public boolean isActif(){
		if (isReady==false){
			isActif=false;
		}
		return isActif;
	}
	public boolean isReady(){
		return isReady;
	}
}
