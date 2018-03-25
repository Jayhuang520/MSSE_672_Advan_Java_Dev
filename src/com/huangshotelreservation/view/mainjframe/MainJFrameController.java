package com.huangshotelreservation.view.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.huangshotelreservation.view.MessageDialog;
import com.huangshotelreservation.view.Utils;
import com.huangshotelreservation.view.seegalleryjframe.SeeGalleryJFrame;
import org.apache.log4j.Logger;

public class MainJFrameController implements ActionListener{

    static Logger log = Logger.getLogger("com.huangshotelreservation");
	private MainJFrame mainJFrame;

	//empty constructor to avoid error with empty parameter
	public MainJFrameController() {
	}
	
	/**
	 * Copy constructor
	 * @param mainJFrame
	 */
	public MainJFrameController(MainJFrame mainJFrame) {
		this.mainJFrame = mainJFrame;
		mainJFrame.getFileMenuItem().addActionListener(this);
		mainJFrame.getDatabaseMenuItem().addActionListener(this);
		
		//Center the frame
		Utils.centerWindow(mainJFrame);
		mainJFrame.setVisible(true);
	}

	/**
	 * @See java.awt.event.ActionListener for details.
	 */
	  public void actionPerformed(ActionEvent event) 
	  {

	    log.info("Inside MainJFrameController::actionPerformed");
	    
	    if (event.getSource().equals(mainJFrame.getFileMenuItem()))
	      menuFileOpen_actionPerformed(event);
	    else if (event.getSource().equals(mainJFrame.getDatabaseMenuItem()))
	      actionPerformed(event);
	    else if (event.getSource().equals(mainJFrame.getGetReserveRoomButton()))
	      getReserveRoom_actionPerformed(event);
	    else if (event.getSource().equals(mainJFrame.getSeeGalleryButton()))
	      getSeeGallery_actionPerformed(event);
	  }

	/**
	 * Process to reserve room.
	 * This is not implemented yet.
	 * @param event
	 */
	private void getReserveRoom_actionPerformed(ActionEvent event) {
		  log.info("Inside MainJFrameController");
		  MessageDialog dlg = new MessageDialog( "Reserve Room", "Not Implemented Yet!");    
		  Utils.centerWindow(dlg);
		  dlg.setModal(true);
		  dlg.show();
		  return;  
	}


	/**
	 * Process to see the gallery of the room type entered.
	 * @param event
	 */
	private void getSeeGallery_actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		SeeGalleryJFrame seeGalleryJFrame = new SeeGalleryJFrame();
	}


	/**
	 * processes File Menu | Data | Open from File action
	 * TO-DO: Not implemented.
	 * @param actionEvent
	 */
	void menuFileOpen_actionPerformed(ActionEvent actionEvent) 
	  {
	   /*
	    * This would call another controller to import data
	    * from a database.  
	    */
	    MessageDialog dlg = new MessageDialog( "File Open", " Read comments in callback code");    
	    Utils.centerWindow(dlg);
	    dlg.setModal(true);
	    dlg.show();

	      return;  
	  } //end of the menuFileOpen_actionPerformed
	
	 /**
	   * Processes File Menu | Data | Open from Database menu click action
	   * TO-DO: not implemented.
	   * @param actionEvent ActionEvent
	   */
	  void menuReadDB_actionPerformed (ActionEvent actionEvent) 
	  {
	    MessageDialog dlg = new MessageDialog( "File Open", " Read comments in callback code");    
	    Utils.centerWindow(dlg);
	    dlg.setModal(true);
	    dlg.show();

	      return;  
	  } //end menuReadDB_actionPerformed

}
