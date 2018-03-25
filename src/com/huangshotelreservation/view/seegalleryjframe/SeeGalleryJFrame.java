package com.huangshotelreservation.view.seegalleryjframe;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.huangshotelreservation.model.domain.Room;

/**
 * 
 * @author Zhijie Huang
 * 
 * UI will take the city and room information from the previous page
 * and display an image. Since displaying an image is a more advanced
 * method in Swing. It is hard to incorporate it into a week.
 *
 */
public class SeeGalleryJFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3454668569198348148L;

	private SeeGalleryJFrameController seeGalleryJFrameController;

	private JTextField jTextFieldRoom;

	private JButton jButtonOkay;

	private JMenuBar jMenuBar;

	private JMenu jFileMenu;

	private JMenu jDataMenu;

	private JMenuItem jFileMenuItem;

	private JPanel jPanel1;

	private JMenuItem jDatabaseMenuItem;

	private JLabel jLabelImageDescription1;

	private JLabel jLabelImageDescription2;
	
	private JLabel jLabelImageDescription3;

	private JButton jButtonCancel;

	private Room room;
	
	/**
	 * Create a new window for display gallery
	 */
	public SeeGalleryJFrame() {
		initComponents();
		
		seeGalleryJFrameController = new SeeGalleryJFrameController(this);
		pack();
		this.setSize(600,650);
		this.setVisible(true);
	}

	/**
	 * This method is called from within the construtor to initialize 
	 * the form.
	 */
	private void initComponents() {
		jMenuBar = new javax.swing.JMenuBar();
		setJMenuBar(jMenuBar);
		jFileMenu = new javax.swing.JMenu();
		jDataMenu = new javax.swing.JMenu();
		jFileMenuItem = new javax.swing.JMenuItem();
		jDatabaseMenuItem = new javax.swing.JMenuItem();
		jPanel1 = new javax.swing.JPanel();
		jLabelImageDescription1 = new javax.swing.JLabel();
		jLabelImageDescription2 = new javax.swing.JLabel();
		jLabelImageDescription3 = new javax.swing.JLabel();
		jButtonOkay = new javax.swing.JButton();
		jButtonCancel = new javax.swing.JButton();
		jTextFieldRoom = new javax.swing.JTextField();
		 
		
		jMenuBar.setNextFocusableComponent(jFileMenu);
		jMenuBar.setOpaque(false);

		jFileMenu.setText("File");
		jFileMenu.setFont(new java.awt.Font("Comic Sans MS", 1, 11));

		jDataMenu.setText("Data");
		jDataMenu.setFont(new java.awt.Font("Comic Sans MS", 1, 11));

		jFileMenuItem.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jFileMenuItem.setText("Open From File...");
		jDataMenu.add(jFileMenuItem);

		jDatabaseMenuItem.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jDatabaseMenuItem.setText("Open from database...");
		jDatabaseMenuItem.setActionCommand("Open from Database...");
		jDataMenu.add(jDatabaseMenuItem);


		jFileMenu.add(jDataMenu);

		jMenuBar.add(jFileMenu);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("See Gallery Service");
		setFont(new java.awt.Font("Comic Sans MS", 0, 10)); 
		getContentPane().setLayout(null);

		jPanel1.setBackground(new java.awt.Color(244,233,66));
		jPanel1.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel1.setLayout(null);

		jLabelImageDescription1.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
		jLabelImageDescription1.setText("Room description:");
		jPanel1.add(jLabelImageDescription1);
		jLabelImageDescription1.setBounds(200, 10, 200, 50);
		
		jLabelImageDescription2.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
		jLabelImageDescription2.setText("Luxury Queen Bed ");
		jPanel1.add(jLabelImageDescription2);
		jLabelImageDescription2.setBounds(200, 70, 200, 50);

		jButtonOkay.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
		jButtonOkay.setText("Ok");
		jPanel1.add(jButtonOkay);
		jButtonOkay.setBounds(150, 500, 80, 25);

		jTextFieldRoom.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
		jTextFieldRoom.setText("Queen");
		jPanel1.add(jTextFieldRoom);
		jTextFieldRoom.setBounds(130, 140, 120, 20);
		
		jButtonCancel.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
		jButtonCancel.setText("Cancel");
		jPanel1.add(jButtonCancel);
		jButtonCancel.setBounds(350, 500, 80, 25);
		
		getContentPane().add(jPanel1);
		jPanel1.setBounds(0, 0, 600, 650);
	}
	
	public ArrayList<Room> getSelectedData(){
		ArrayList<Room> availableRoom = new ArrayList<Room>(2);
		String roomString = jTextFieldRoom.getText();
		if(roomString == "Queen")
			room = Room.QUEEN;
		
		availableRoom.add(room);
		return availableRoom;
	}
	
    /**
     * 
     * @return jFileMenuItem
     */
    public javax.swing.JMenuItem getFileMenuItem()
    {
        return jFileMenuItem;
    }
    
    /**
     * 
     * @return jButtonOkay
     */
    public javax.swing.JButton getOkayButton()
    {
        return jButtonOkay;
    }

    /**
     * 
     * @return jButtonCancel
     */
     public javax.swing.JButton getCancelButton()
    {
        return jButtonCancel;
    }
	
	 
	 public static void main(String args[]) {
		 java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                SeeGalleryJFrame secJFrame = new SeeGalleryJFrame();
	            }
	        });
	 }
}
