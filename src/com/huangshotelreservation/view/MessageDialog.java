package com.huangshotelreservation.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * This is a messageDialog.java
 * This is inside the com.huangshotelreservation.view package.
 * @author Zhijie Huang
 *
 */

public class MessageDialog extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3886030982866254189L;
	JButton okbutton = new JButton("Okay");
	JLabel jlabel = new JLabel();
	
	public MessageDialog(String title,String message) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle(title);
		jlabel.setText(message);
		jInit();
		okbutton.addActionListener(this);
		
	}

	/**
	 * Initialize component
	 */
	private void jInit() {
		jlabel.setBounds(new Rectangle(100, 15, 400, 40));
		okbutton.setBounds(new Rectangle(114, 70, 68, 23));
		this.getContentPane().add(jlabel);
		this.getContentPane().add(okbutton);
		getContentPane().setLayout(null);
		setSize(500,200);
	}

	/**
	 * Close the dialog on a okay button
	 * 
	 * @param actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == okbutton) {
			dispose();
		}
	}


}
