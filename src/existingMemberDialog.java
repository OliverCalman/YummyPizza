/*
 * existing member UI
 * Created by Oliver Calman 14155966 for 32555 Fundamentals of Software Development, 2021
 * controller to allow users to update or delete a member if they attempt to create a new membership for the same person
 */


import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;

public class existingMemberDialog extends JDialog {

	private static final long serialVersionUID = 4249258925820685310L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					existingMemberDialog dialog = new existingMemberDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public existingMemberDialog() {
		setTitle("Member already exists");
		setAlwaysOnTop(true);
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(150, 150, 450, 228);
		getContentPane().setLayout(null);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    setVisible(false);
				    dispose();
			}
		});
		cancelButton.setBounds(38, 134, 89, 23);
		getContentPane().add(cancelButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					databaseController.deleteMember();
				    System.out.println("Member "+ membership.getMemberNumber() +" has been deleted.");
				    databaseController.setMsgText("Member "+ membership.getMemberNumber() +" has been deleted.");
					new genericConfirmationDialog().setVisible(true);
				} catch (Exception e1) {
				    System.out.println("Unable to delete member due to error.");
					e1.printStackTrace();
				}
			    setVisible(false);
			    dispose();
				
			}
		});
		deleteButton.setBounds(172, 134, 89, 23);
		getContentPane().add(deleteButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					databaseController.updateMemberDetails();
				    System.out.println("Member "+ membership.getMemberNumber() +" has been updated.");
				    databaseController.setMsgText("Member "+ membership.getMemberNumber() +" has been updated with the details supplied.");
					new genericConfirmationDialog().setVisible(true);
				} catch (Exception e1) {
				    System.out.println("Unable to update member due to error.");
					e1.printStackTrace();
				}
			    setVisible(false);
			    dispose();
			}
		});
		updateButton.setBounds(306, 134, 89, 23);
		getContentPane().add(updateButton);
		
		JTextArea txtrAMembershipAlready = new JTextArea();
		txtrAMembershipAlready.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrAMembershipAlready.setText("A membership already exists for "+ customer.getName() +". The existing member number is "+ membership.getMemberNumber() +".\r\nWould you like to update their details using the information supplied, or delete the existing membership?");
		txtrAMembershipAlready.setWrapStyleWord(true);
		txtrAMembershipAlready.setEditable(false);
		txtrAMembershipAlready.setLineWrap(true);
		txtrAMembershipAlready.setBounds(21, 22, 377, 90);
		getContentPane().add(txtrAMembershipAlready);

	}
}
