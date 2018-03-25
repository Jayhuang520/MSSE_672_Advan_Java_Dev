package com.huangshotelreservation.view.reserveroom;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.huangshotelreservation.model.domain.ReserveRoom;
import com.huangshotelreservation.model.domain.Room;

public class ReserveRoomJFrame extends JInternalFrame{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7395136156991936650L;
	private ReserveRoomJFrameController reserveRoomJFrameController;
	private JMenuBar jMenuBar;
	private JMenu jFileMenu;
	private JMenuItem jFileMenuItem;
	private JMenu jDataMenu;
	private JMenuItem jDatabaseMenuItem;
	private JPanel jPanel1;
	private JButton jButtonOkay;
	private JTextField jTextFieldRoomType;
	private JButton jButtonCancel;
	private JLabel jLabelRoomType;
	private JLabel jLabelRoomRate;
	private JTextField jTextFieldRoomRate;
	private JLabel jLabelDuration;
	private JLabel jLabelCheckinTime;
	private JTextField jTextFieldDuration;
	private JLabel jLabelCheckoutTime;
	private JTextField jTextFieldCheckinTime;
	private JTextField jTextFieldCheckoutTime;
	private JLabel jLabelComplementaryService;
	private JLabel jLabelComplementaryServiceDesr1;
	private JLabel jLabelComplementaryServiceDesr2;

	public ReserveRoomJFrame() {
		
		initiComponents();
		
		reserveRoomJFrameController = new ReserveRoomJFrameController(this);
		pack();
		this.setSize(600,650);
		this.setVisible(true);
	}
	

	private void initiComponents() {
		jMenuBar = new javax.swing.JMenuBar();
		setJMenuBar(jMenuBar);
		jFileMenu = new javax.swing.JMenu();
		jDataMenu = new javax.swing.JMenu();
		jFileMenuItem = new javax.swing.JMenuItem();
		jDatabaseMenuItem = new javax.swing.JMenuItem();
		jPanel1 = new javax.swing.JPanel();
		jButtonOkay = new javax.swing.JButton();
		jButtonCancel = new javax.swing.JButton();
		jLabelRoomType = new javax.swing.JLabel();
		jTextFieldRoomType = new javax.swing.JTextField();
		jLabelRoomRate = new javax.swing.JLabel();
		jTextFieldRoomRate = new javax.swing.JTextField();
		jLabelDuration = new javax.swing.JLabel();
		jTextFieldDuration = new javax.swing.JTextField();
		jLabelCheckinTime = new javax.swing.JLabel();
		jTextFieldCheckinTime = new javax.swing.JTextField();
		jLabelCheckoutTime = new javax.swing.JLabel();
		jTextFieldCheckoutTime = new javax.swing.JTextField();
		jLabelComplementaryService = new javax.swing.JLabel();
		jLabelComplementaryServiceDesr1 = new javax.swing.JLabel();
		jLabelComplementaryServiceDesr2 = new javax.swing.JLabel();
		
		/*
		 * Add all the menu bars
		 */
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
		setTitle("Reserve Room Service");
		setFont(new java.awt.Font("Comic Sans MS", 0, 10)); 
		getContentPane().setLayout(null);

		jPanel1.setBackground(new java.awt.Color(244,233,66));
		jPanel1.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel1.setLayout(null);

		/*
		 * Add all the display field and jtext
		 */
		
		jLabelRoomType.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
		jLabelRoomType.setText("Room type:");
		jPanel1.add(jLabelRoomType);
		jLabelRoomType.setBounds(10, 10, 80, 30);
		
		jTextFieldRoomType.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
		jTextFieldRoomType.setText("Queen");
		jPanel1.add(jTextFieldRoomType);
		jTextFieldRoomType.setBounds(90, 10, 80, 30);
		

		jLabelRoomRate.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
		jLabelRoomRate.setText("Room Rate:");
		jPanel1.add(jLabelRoomRate);
		jLabelRoomRate.setBounds(310, 10, 80, 30);
		
		jTextFieldRoomRate.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
		jTextFieldRoomRate.setText("1000");
		jPanel1.add(jTextFieldRoomRate);
		jTextFieldRoomRate.setBounds(410, 10, 80, 30);
		
		jLabelDuration.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
		jLabelDuration.setText("Duration:");
		jPanel1.add(jLabelDuration);
		jLabelDuration.setBounds(10, 40, 80, 30);
		
		jTextFieldDuration.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
		jTextFieldDuration.setText("1");
		jPanel1.add(jTextFieldDuration);
		jTextFieldDuration.setBounds(90, 40, 80, 30);
		
		jLabelCheckinTime.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
		jLabelCheckinTime.setText("Checkin time:");
		jPanel1.add(jLabelCheckinTime);
		jLabelCheckinTime.setBounds(310, 40, 100, 30);
		
		jTextFieldCheckinTime.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
		jTextFieldCheckinTime.setText("1/1/2018");
		jPanel1.add(jTextFieldCheckinTime);
		jTextFieldCheckinTime.setBounds(410, 40, 80, 30);
		
		jLabelCheckoutTime.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
		jLabelCheckoutTime.setText("Checkout time:");
		jPanel1.add(jLabelCheckoutTime);
		jLabelCheckoutTime.setBounds(310, 70, 120, 30);
		
		jTextFieldCheckoutTime.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
		jTextFieldCheckoutTime.setText("1/2/2018");
		jPanel1.add(jTextFieldCheckoutTime);
		jTextFieldCheckoutTime.setBounds(410, 70, 80, 30);
		
		jLabelComplementaryService.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
		jLabelComplementaryService.setText("Complementary service:");
		jPanel1.add(jLabelComplementaryService);
		jLabelComplementaryService.setBounds(10, 130, 300, 30);
		
		jLabelComplementaryServiceDesr1.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
		jLabelComplementaryServiceDesr1.setText("Free wifi,free breakfast,free coffee"
				+ "free massage");
		jPanel1.add(jLabelComplementaryServiceDesr1);
		jLabelComplementaryServiceDesr1.setBounds(10, 160, 590, 30);
		
		jLabelComplementaryServiceDesr2.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
		jLabelComplementaryServiceDesr2.setText("Wifi password: Welcome2Huangs");
		jPanel1.add(jLabelComplementaryServiceDesr2);
		jLabelComplementaryServiceDesr2.setBounds(10, 190, 590, 30);
		/*
		 * okay and cancel button
		 */
		
		jButtonOkay.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
		jButtonOkay.setText("Ok");
		jPanel1.add(jButtonOkay);
		jButtonOkay.setBounds(150, 500, 80, 30);

		jButtonCancel.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
		jButtonCancel.setText("Cancel");
		jPanel1.add(jButtonCancel);
		jButtonCancel.setBounds(350, 500, 80, 30);
		
		getContentPane().add(jPanel1);
		jPanel1.setBounds(0, 0, 600, 650);

		
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
	            	ReserveRoomJFrame thirdJFrame = new ReserveRoomJFrame();
	            }
	        });
	 }


	public static ReserveRoom getSelectedData() {
		ReserveRoom reserveRoom = new ReserveRoom(true,1,1,1,1,Room.SINGLE);
		reserveRoom.toString();
		return reserveRoom;
	}

}
