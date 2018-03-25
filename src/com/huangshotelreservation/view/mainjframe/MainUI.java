package com.huangshotelreservation.view.mainjframe;

import com.huangshotelreservation.view.Log4JInit;
import javax.swing.*;

import com.huangshotelreservation.view.mainjframe.MainJFrame;
import com.huangshotelreservation.view.mainjframe.MainJFrameController;
import com.huangshotelreservation.view.reserveroom.ReserveRoomJFrame;
import com.huangshotelreservation.view.seegalleryjframe.SeeGalleryJFrame;

import java.awt.event.*;
import org.apache.log4j.Logger;

public class MainUI extends JFrame{
    static Logger log = Logger.getLogger("com.huangshotelreservation");
	/**
	 * 
	 */
	private static final long serialVersionUID = 5871278508985861628L;
		
	JDesktopPane jDesktopPane = new JDesktopPane();



	private JMenuItem seeGalleryItem;

	private JMenuItem reserveRoomItem;
	public MainUI() {
            
		super("Huangs Hotel Reservation");
		getContentPane().add(jDesktopPane);
		
		//Follows Model-View-Controller(MVC) approach
		// Create view class
		MainJFrame mainFrame = new MainJFrame();
		
		//Create controller class and set the view
		MainJFrameController mainJFrameController = 
				new MainJFrameController(mainFrame);
		
		mainFrame.setBounds(0,0,600,600);
		mainFrame.setSize(600,600);
		mainFrame.setVisible(true);
		jDesktopPane.add(mainFrame);
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(650,750);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuBar.setOpaque(true);
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('X');
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);

		JMenu actionMenu = new JMenu("Action");
		
		seeGalleryItem = new JMenuItem("See Gallery");
		seeGalleryItem.setMnemonic('A');
		seeGalleryItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jDesktopPane.getAllFrames().length == 0) {
					SeeGalleryJFrame seegalleryUI = new SeeGalleryJFrame();
					seegalleryUI.setBounds(0,0,600,600);
					seegalleryUI.setSize(600,600);
					seegalleryUI.setVisible(true);
					jDesktopPane.add(seegalleryUI);
				}else {
					jDesktopPane.remove(0);
					SeeGalleryJFrame seegalleryUI = new SeeGalleryJFrame();
					seegalleryUI.setBounds(0,0,600,600);
					seegalleryUI.setSize(600,600);
					seegalleryUI.setVisible(true);
					jDesktopPane.add(seegalleryUI);
				}
				
			}
		});
		actionMenu.add(seeGalleryItem);
		menuBar.add(actionMenu);
		
		JMenuItem reserveRoomItem = new JMenuItem("Reserve Room");
		reserveRoomItem.setMnemonic('A');
		reserveRoomItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jDesktopPane.getAllFrames().length == 0) {
					ReserveRoomJFrame reserveroomUI = new ReserveRoomJFrame();
					reserveroomUI.setBounds(0,0,600,600);
					reserveroomUI.setSize(600,600);
					reserveroomUI.setVisible(true);
					jDesktopPane.add(reserveroomUI);
				}else {
					jDesktopPane.remove(0);
					ReserveRoomJFrame reserveroomUI = new ReserveRoomJFrame();
					reserveroomUI.setBounds(0,0,600,600);
					reserveroomUI.setSize(600,600);
					reserveroomUI.setVisible(true);
					jDesktopPane.add(reserveroomUI);
				}
			}
		});
		actionMenu.add(reserveRoomItem);
		menuBar.add(actionMenu);
		
		setVisible(true);
		
		log.info("Enter the main screen of the Huangs"
				+ "Reservation System");
		
	}
	
	
	/**
	 * 
	 * @returns seeGalleryItem
	 */
	public javax.swing.JMenuItem getSeeGalleryItem(){
		return seeGalleryItem;
	}
	
	/**
	 * 
	 * @returns seeGalleryItem
	 */
	public javax.swing.JMenuItem getReserveRoomItem(){
		return reserveRoomItem;
	}
	
	public static void main(String [] args) {
		new MainUI();
                Log4JInit.initializeLog4J();
	}

}
