package com.huangshotelreservation.view.seegalleryjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.huangshotelreservation.model.business.manager.HuangsHotelReservationManager;
import com.huangshotelreservation.model.domain.City;
import com.huangshotelreservation.model.domain.ReserveRoom;
import com.huangshotelreservation.model.domain.Room;
import com.huangshotelreservation.view.MessageDialog;
import com.huangshotelreservation.view.Utils;
import org.apache.log4j.Logger;

public class SeeGalleryJFrameController 
		implements ActionListener{
    
    static Logger log = Logger.getLogger("com.huangshotelreservation");

	private SeeGalleryJFrame seeGalleryJFrame;
	
	public SeeGalleryJFrameController() {
	}
	
	public SeeGalleryJFrameController(SeeGalleryJFrame seeGalleryJFrame) {
		this.seeGalleryJFrame = seeGalleryJFrame;
		
		//add all the actionListerns here:
		seeGalleryJFrame.getOkayButton().addActionListener(this);
		seeGalleryJFrame.getCancelButton().addActionListener(this);
		
		Utils.centerWindow(seeGalleryJFrame);
		seeGalleryJFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		log.info("Inside SeeGalleryJFrameController:action performed");
		if(ae.getSource().equals(seeGalleryJFrame.getOkayButton())) {
			okay_actionPerformed(ae);
		}else if(ae.getSource().equals(seeGalleryJFrame.getCancelButton())) {
			cancel_actionPerformed(ae);
		}
	}
	
	 /**
	   * Processes File Menu | Data | Open from File action
	   *
	   * @param actionEvent ActionEvent
	   */
	  void menuFileOpen_actionPerformed(ActionEvent actionEvent) 
	  {
		  MessageDialog dlg = new MessageDialog( "File Open", " Read comments in callback code");    
		  Utils.centerWindow(dlg);
		  dlg.setModal(true);
		  dlg.show();

	      return;  
	  } //end menuFileOpen_actionPerformed

	private void cancel_actionPerformed(ActionEvent ae) {
		log.info("Customer don't want to see the Gallery anymore!");
		seeGalleryJFrame.setVisible(false);
		seeGalleryJFrame.dispose();
	}

	private void okay_actionPerformed(ActionEvent ae) {
		log.info("Customer wants to see the Gallery of the room!");
		ArrayList<Room> availableRoom = seeGalleryJFrame.getSelectedData();
		
		HuangsHotelReservationManager huangsHotelReservationManager = HuangsHotelReservationManager.getInstance();
		
		if(huangsHotelReservationManager != null) {
			String commandString;
			ReserveRoom reserveRoom = new ReserveRoom();
			boolean action = huangsHotelReservationManager.performAction("seeGalleryService", availableRoom, City.DENVER,Room.QUEEN,reserveRoom);
			if(action) {
				MessageDialog mdg = new MessageDialog("See Gallery","Successfully see Gallery");
				Utils.centerWindow(mdg);
				mdg.setModal(true);
				mdg.show();
				
				seeGalleryJFrame.setVisible(false);
				seeGalleryJFrame.dispose();
			}else {
				 MessageDialog mdg = new MessageDialog( "See Gallery" , "See Gallery Failed. Please try again back later!");    
		         Utils.centerWindow(mdg);
		         mdg.setModal(true);
		         mdg.show();
			}
		}else {
			MessageDialog mdg = new MessageDialog( "HuangsHotelReservationManger failed" , "See Gallery Failed. Please try again back later!");    
			Utils.centerWindow(mdg);
			mdg.setModal(true);
			mdg.show();
		}
	}

	/**
	   * Processes File Menu | Data | Open from Database menu click action
	   *
	   * @param actionEvent ActionEvent
	   */
	  void menuReadDB_actionPerformed (ActionEvent actionEvent) 
	  {
	   
		/*
		 * In reality, one would call the controller - FleetRentalController to
		 *  exercise the appropriate service. See getAvailableRentals_actionPerformed
		 *  for example.
		 */  
	    MessageDialog dlg = new MessageDialog( "File Open", " Read comments in callback code");    
	    Utils.centerWindow(dlg);
	    dlg.setModal(true);
	    dlg.show();

	      return;  
	  } //end menuReadDB_actionPerformed

}//end class
