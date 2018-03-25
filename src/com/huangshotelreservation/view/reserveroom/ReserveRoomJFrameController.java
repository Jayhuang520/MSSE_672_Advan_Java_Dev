package com.huangshotelreservation.view.reserveroom;

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

public class ReserveRoomJFrameController implements ActionListener{
    static Logger log = Logger.getLogger("com.huangshotelreservation");
	private ReserveRoomJFrame reserveRoomJFrame;

	public ReserveRoomJFrameController() {
	}
	
	public ReserveRoomJFrameController(ReserveRoomJFrame reserveRoomJFrame) {
		this.reserveRoomJFrame = reserveRoomJFrame;
		
		//add all the actionListerners here
		reserveRoomJFrame.getOkayButton().addActionListener(this);
		reserveRoomJFrame.getCancelButton().addActionListener(this);
		
		Utils.centerWindow(reserveRoomJFrame);
		reserveRoomJFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		log.info("Inside ReserveRoomJFrameController:action performed");
		if(ae.getSource().equals(reserveRoomJFrame.getOkayButton())) {
			okay_actionPerformed(ae);
		}else if(ae.getSource().equals(reserveRoomJFrame.getCancelButton())) {
			cancel_actionPerformed(ae);
		}
	}

	private void cancel_actionPerformed(ActionEvent ae) {
		log.info("Customer don't want to reserve the room!");
		reserveRoomJFrame.setVisible(false);
		reserveRoomJFrame.dispose();
		
	}

	private void okay_actionPerformed(ActionEvent ae) {
		log.info("Customer wants to reserved the room!");
		ReserveRoom reserveRoom = ReserveRoomJFrame.getSelectedData();
		
		HuangsHotelReservationManager huangsHotelReservationManager = HuangsHotelReservationManager.getInstance();

		if(huangsHotelReservationManager != null) {

			ArrayList<Room> availableRoom = new ArrayList<Room>(2);
			availableRoom.add(Room.QUEEN);
			availableRoom.add(Room.DOUBLE);

			boolean action = huangsHotelReservationManager.performAction("calendarService", availableRoom, City.DENVER,Room.QUEEN,reserveRoom);
			if(action) {
				MessageDialog mdg = new MessageDialog(" Calendar service","Successfully reserve room");
				Utils.centerWindow(mdg);
				mdg.setModal(true);
				mdg.show();

				reserveRoomJFrame.setVisible(false);
				reserveRoomJFrame.dispose();
			}else {
				MessageDialog mdg = new MessageDialog( "Calendar service" , "Reserved Failed. Please try again back later!");    
				Utils.centerWindow(mdg);
				mdg.setModal(true);
				mdg.show();
			}
		}else {
			MessageDialog mdg = new MessageDialog( "HuangsHotelReservationManger failed" , "Calendar service Failed. Please try again back later!");    
			Utils.centerWindow(mdg);
			mdg.setModal(true);
			mdg.show();
		}
	}
}
