package com.huangshotelreservation.view.mainjframe;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Build a welcome screen for the HuangsReservationSystem application
 * Customer can choose to Check Room avaialbility or choose to 
 * see Gallery of the hotel room.
 * 
 * @author Zhijie Huang
 *
 */

public class MainJFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2759001629018657278L;
	private JMenuBar jMenuBar;
	private JMenu jFileMenu;
	private JMenu jDataMenu;
	private JMenuItem jFileMenuItem;
	private JMenuItem jDatabaseMenuItem;
	private JPanel jPanel1;
	private JButton jButtonReserveRoom;
	private JButton jButtonSeeGallery;
	private JLabel jLabelHuangsHotel;
	private JLabel jLabelWelcomeTo;
	private JLabel jLabelCity;
	private JLabel jLabelRoom;
	private JLabel jLabelComplementaryService;
	private JLabel jLabelFreeService;
	private JTextField jTextFieldCity;
	private JTextField jTextFieldRoom;

	public MainJFrame() {
		initUIComponents();

		this.setSize(600,650);
		this.setVisible(true);
	}

	/**
	 * Please note that the date will not be available in this page
	 * The date will be available in the reserved room tab.
	 */
	private void initUIComponents() {
		jMenuBar = new javax.swing.JMenuBar();
		setJMenuBar(jMenuBar);
		jFileMenu = new javax.swing.JMenu();
		jDataMenu = new javax.swing.JMenu();
		jFileMenuItem = new javax.swing.JMenuItem();
		jDatabaseMenuItem = new javax.swing.JMenuItem();
		jPanel1 = new javax.swing.JPanel();
		jLabelWelcomeTo = new javax.swing.JLabel();
		jLabelHuangsHotel = new javax.swing.JLabel();
		jLabelCity = new javax.swing.JLabel();
		jTextFieldCity = new javax.swing.JTextField();
		jLabelRoom = new javax.swing.JLabel();
		jTextFieldRoom = new javax.swing.JTextField();
		jLabelComplementaryService = new javax.swing.JLabel();
		jLabelFreeService = new javax.swing.JLabel();


		jMenuBar.setOpaque(true);

		jFileMenu.setText("File");
		jFileMenu.setFont(new java.awt.Font("Comic Sans MS", 1, 11));

		jDataMenu.setText("Data");
		jDataMenu.setFont(new java.awt.Font("Comic Sans MS", 1, 11));

		jFileMenu.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jFileMenuItem.setText("Open from File:");

		jDatabaseMenuItem.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jDatabaseMenuItem.setText("Open from database...");
		jDatabaseMenuItem.setActionCommand("Open from Database...");
		jDataMenu.add(jDatabaseMenuItem);

		jFileMenu.add(jDataMenu);

		jMenuBar.add(jFileMenu);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Huangs Hotel Reservation System");
		setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		getContentPane().setLayout(null);

		//FYI: Huang in chinese means yellow
		jPanel1.setBackground(new java.awt.Color(244,233,66));
		jPanel1.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel1.setLayout(null);

		jLabelWelcomeTo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
		jLabelWelcomeTo.setText("Welcome to:");
		jPanel1.add(jLabelWelcomeTo);
		jLabelWelcomeTo.setBounds(200, 10, 200, 50);

		jLabelHuangsHotel.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
		jLabelHuangsHotel.setText("Huangs Hotel Reservation System");
		jPanel1.add(jLabelHuangsHotel);
		jLabelHuangsHotel.setBounds(150, 60, 500, 50);

		jLabelCity.setFont(new java.awt.Font("Comic Sans MS", 1, 15));
		jLabelCity.setText("City:");
		jPanel1.add(jLabelCity);
		jLabelCity.setBounds(100, 120, 50, 25);
		
		jTextFieldCity.setFont(new java.awt.Font("Comic Sans MS", 0, 11));
		jTextFieldCity.setText("Denver");
		jPanel1.add(jTextFieldCity);
		jTextFieldCity.setBounds(210, 120, 90, 22);

		jLabelRoom.setFont(new java.awt.Font("Comic Sans MS", 1, 15));
		jLabelRoom.setText("Room type:");
		jPanel1.add(jLabelRoom);
		jLabelRoom.setBounds(100, 160, 100, 25);
		
		jTextFieldRoom.setFont(new java.awt.Font("Comic Sans MS", 0, 11));
		jTextFieldRoom.setText("Queen");
		jPanel1.add(jTextFieldRoom);
		jTextFieldRoom.setBounds(210, 160, 90, 22);

		jLabelComplementaryService.setFont(new java.awt.Font("Comic Sans MS", 1, 15));
		jLabelComplementaryService.setText("Complementary Services:");
		jPanel1.add(jLabelComplementaryService);
		jLabelComplementaryService.setBounds(100, 200, 200, 25);

		jLabelFreeService.setFont(new java.awt.Font("Comic Sans MS", 1, 15));
		jLabelFreeService.setText("Free wifi,free breakfast,free coffee and free massage");
		jPanel1.add(jLabelFreeService);
		jLabelFreeService.setBounds(100, 240, 600, 25);


		getContentPane().add(jPanel1);
		jPanel1.setBounds(0, 0, 600, 600);
	}

	
	/**
	 * Returns jFileMenuItem
	 * For future implementation
	 */
	public javax.swing.JMenuItem getFileMenuItem()
	{
		return jFileMenuItem;
	}
	
    /**
     * Returns jDatabaseMenuItem
     * For future implementation
     */
    public javax.swing.JMenuItem getDatabaseMenuItem()
    {
        return jDatabaseMenuItem;
    }    

    /**
     * 
     * @return jButtonReserveRoom
     */
    public javax.swing.JButton getGetReserveRoomButton()
    {
        return jButtonReserveRoom;
    }
    
    /**
     * 
     * @return jButtonReserveRoom
     */
    public javax.swing.JButton getSeeGalleryButton()
    {
        return jButtonSeeGallery;
    }   
    
	private void jButtonGetjButtonReserveRoomActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainJFrame MainJFrame = new MainJFrame();
               
            }
        });
    }

}
