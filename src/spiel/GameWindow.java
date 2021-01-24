package spiel;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
	public GameWindow() {

		JPanel testPanel = new JPanel();
		// Erzeugung eines neuen JPanel-Objekt
		testPanel.setPreferredSize(new Dimension(1200, 800));
		// Pixelgroeße des Spielfensters (1200 Pixel x 800 Pixel)
		registerWindowListener();
		createMenu();

		add(testPanel); // JFrame wird das JPanel-Objekt testPanel hinzugefügt
		pack(); //grafische korrekte Darstellung

		setTitle("PacMan"); // Titel
		setLocation(165, 15); // Positionen der Fensterecken
		setResizable(false); // Spielfenster kann dadurch nicht vom Benutzer geaendert werden

		setVisible(true); // Spielfeld wird visualisiert

	}

	private void createMenu() {			// 1.Methode : wir erzeugen eine Menueleiste und fuegen 3 Menues hinzu
		
		JMenuBar menuBar = new JMenuBar();			// Objekt vom Typ JMenuBar wird erstellt
		this.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu ("File");		// 3 Menue Objekte werden erstellt
		JMenu gameMenu = new JMenu ("Game");
		JMenu prefMenu = new JMenu ("Preferences");
		JMenu helpMenu = new JMenu ("Help");
		
	menuBar.add(fileMenu);
	menuBar.add(gameMenu);
	menuBar.add(prefMenu);
	menuBar.add(helpMenu);
	
	addFileMenuItems(fileMenu);
		
	}
	
	private void addFileMenuItems(JMenu fileMenu) {			// 2.Methode: wir fuegen einem Menue einen Eintrag hinzu
		
		JMenuItem quitItem = new JMenuItem ("Quit");
		fileMenu.add(quitItem);
		quitItem.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		});
	}



	private void registerWindowListener() {
		addWindowListener (new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			public void windowDeactivated(WindowEvent e) {
				// hier werden wir später unser Spiel pausieren
			}
			public void windowActivated(WindowEvent e) {
				// hier werden wir später unser Spiel fortsetzen
			}
		});
	}
}