import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class OptionsGUI extends JFrame implements ActionListener {
	
	Options opts;
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints constraints = new GridBagConstraints();
	JPanel pane = new JPanel();
	
	JPanel lignesColPane = new JPanel(new GridLayout(2, 2, 10, 10));
	JLabel nbRowLabel = new JLabel("Nombre de lignes du tableau :");
	JTextField text1 = new JTextField("6", 2);
	JLabel nbColLabel = new JLabel("Nombre de colonnes du tableau :");
	JTextField text2 = new JTextField("7", 2);
	
        
	JPanel networkPane = new JPanel();
	JCheckBox networkOn = new JCheckBox("Jouer en reseau", false);
	ButtonGroup serveurClient = new ButtonGroup();
	JRadioButton server = new JRadioButton("Etre serveur", false);
	JRadioButton client = new JRadioButton("Etre client", true);
	JTextField ipTextField = new JTextField("IP du serveur", 15);

	JButton ok = new JButton("Ok");
	
	/** Creates a new instance of OptionsGUI for initializing an instance of Options */
	public OptionsGUI(Options opts) {
		
		super("Options de jeu");
		setSize(600, 400);
		setLocation(50, 50);
		
		pane.setLayout(gbl);
		
		// Nb de lignes, colonnes
		buildConstraints(constraints, 0, 0, 2, 1, 80, 30);
		lignesColPane.add(nbRowLabel);
		lignesColPane.add(text1);
		lignesColPane.add(nbColLabel);
		lignesColPane.add(text2);
		gbl.setConstraints(lignesColPane, constraints);
		
		pane.add(lignesColPane);
		
		
		// R�seau
		JPanel serveurClientPane = new JPanel(new BorderLayout());
		serveurClient.add(server);
		serveurClient.add(client);
		serveurClientPane.add(networkOn, "North");
		serveurClientPane.add(server, "West");
		serveurClientPane.add(client, "East");
		serveurClientPane.add(ipTextField, "South");
		networkPane.add(serveurClientPane);
		
		networkOn.addActionListener(this);
		client.addActionListener(this);
		server.addActionListener(this);
		
		buildConstraints(constraints, 0, 2, 2, 1, 0, 10);
		gbl.setConstraints(networkPane, constraints);
		
		pane.add(networkPane);
                
		// Bouton Ok
		ok.addActionListener(this);
		
		buildConstraints(constraints, 1, 3, 1, 1, 0, 10);
		gbl.setConstraints(ok, constraints);
		pane.add(ok);
		
		setNetworkOptionsEnabled(networkOn.isSelected());
		
		setContentPane(pane);
		
		setVisible(true);

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.opts = opts;

	}
	
	
	public void buildConstraints (GridBagConstraints gbc, int gx, int gy, int gw, int gh, int wx, int wy) {
		gbc.gridx = gx;			// Coordonn�es dans la "grille"
		gbc.gridy = gy;
		gbc.gridwidth = gw;		// Nombre de cellules sur lesquelles s'�tend l'objet
		gbc.gridheight = gh; 
		gbc.weightx = wx;		// "Largeur", en proportion
		gbc.weighty = wy;
	}
	
	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();
		
		if (src == ok) {
			try {
				int nbRow = Integer.parseInt(text1.getText());
				int nbCol = Integer.parseInt(text2.getText());
				if (nbRow <= 0 || nbCol <= 0)
					throw new NumberFormatException();
				if (!networkOn.isSelected() || !client.isSelected())
					opts.setSize(nbRow, nbCol, true);
				
				setVisible(false);
				
				
				if (networkOn.isSelected()) {
					if (client.isSelected())
						opts.initNetwork(false, ipTextField.getText());
					else
						opts.initNetwork(true, new String());
				}
				
			} catch (NumberFormatException e) {
				Saisie.erreurMsgOk("Erreur : le nombre de ligne et le nombre de colonnes doivent etre des entiers", "Erreur");
			}
			
		}
		
		else if (src == networkOn || src == client || src == server)
			setNetworkOptionsEnabled(networkOn.isSelected()); // enables or disables the network options
		
		
		
	}
	
	/** Makes computer options enabled or not whether the user enabled the network option or not
	 * @param b if true, makes computer options available (enabled), if false makes them disabled
	 */	
	
	/** Makes network options enabled or not whether the user enabled the network option or not
	 * @param b if true, makes network options available (enabled), if false makes them disabled
	 */	
	public void setNetworkOptionsEnabled(boolean b) {
		server.setEnabled(b);
		client.setEnabled(b);
		if (client.isSelected())
			ipTextField.setEnabled(b);
		
		
	}
	
}
