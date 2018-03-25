package com.huangshotelreservation.view;

import javax.swing.UIManager;

import com.huangshotelreservation.view.mainjframe.MainJFrame;
import com.huangshotelreservation.view.mainjframe.MainJFrameController;

public class ViewDriver {
	
	//Instruction to run the Driver:
	//The property file location is in:MSSE670_Java_Software_Development\config\application.properties
	//The property file has to be passed in as an argument in order to successsfully lauch the seegalleryjframe
	//Example location:-DpropLocation=D:\Git_Repository\MSSE670_Java_Software_Development\config\application.properties
	
	public ViewDriver()
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Follows Model-View-Controller(MVC) approach
		// Create view class
		MainJFrame mainFrame = new MainJFrame();
		
		//Create controller class and set the view
		MainJFrameController mainJFrameController = 
				new MainJFrameController(mainFrame);
	}
	
	public static void main(String[] args) {
		new ViewDriver();
	}
	
}
