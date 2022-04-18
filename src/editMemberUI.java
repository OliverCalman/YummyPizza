// created by Oliver Calman 14155966 for 32555 Fundamentals of Software Development, 2021

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;

import com.toedter.calendar.JDateChooser;


public class editMemberUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7920649008560290690L;
	private JPanel contentPane;
	private JTextField fieldCustName;
	private JTextField fieldPhone;
	private JTextField fieldAddressLine1;
	private JTextField fieldAddressLine2;
	private JTextField fieldSuburb;
	private JTextField fieldPostCode;
	private JTextField fieldEmail;

	//catches current date
	java.util.Date date = new java.util.Date();  
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editMemberUI frame = new editMemberUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public editMemberUI() {
		setTitle("Edit Member Details");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblNewLabel = new JLabel("Edit Member Details");
		lblNewLabel.setBounds(106, 11, 222, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Use this form to edit a members contact information.");
		lblNewLabel_1.setBounds(10, 44, 414, 14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(327, 69, -261, 2);
		contentPane.add(separator);;
		
		fieldCustName = new JTextField();
		fieldCustName.setBounds(64, 98, 283, 22);
		contentPane.add(fieldCustName);
		fieldCustName.setText(customer.getName());
		fieldCustName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Name");
		lblNewLabel_2.setBounds(64, 82, 122, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date of Birth");
		lblNewLabel_3.setBounds(64, 141, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JDateChooser dateOfBirthChooser = new JDateChooser();
		dateOfBirthChooser.setBounds(64, 156, 102, 20);
		if (customer.getDateOfBirth() != null) {
		dateOfBirthChooser.setDate(new java.util.Date(customer.getDateOfBirth().getTime()));
		}
		dateOfBirthChooser.setMaxSelectableDate(date);
		contentPane.add(dateOfBirthChooser);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setBounds(236, 141, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox<gender> choiceGender = new JComboBox<gender>(gender.values());
		choiceGender.setFont(new Font("Tahoma", Font.PLAIN, 11));
		choiceGender.setBackground(SystemColor.text);
		choiceGender.setBounds(236, 156, 86, 20);
		choiceGender.setSelectedItem(customer.getGender());
		contentPane.add(choiceGender);
		
		fieldPhone = new JTextField();
		fieldPhone.setBackground(SystemColor.text);
		fieldPhone.setBounds(64, 216, 139, 20);
		fieldPhone.setText(customer.getPhoneNumber());
		contentPane.add(fieldPhone);
		fieldPhone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Phone Number");
		lblNewLabel_5.setBounds(64, 200, 122, 14);
		contentPane.add(lblNewLabel_5);
		
		fieldAddressLine1 = new JTextField();
		fieldAddressLine1.setBounds(64, 335, 286, 20);
		fieldAddressLine1.setText(address.getAddressLine1());
		contentPane.add(fieldAddressLine1);
		fieldAddressLine1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Address Line 1");
		lblNewLabel_6.setBounds(64, 319, 182, 14);
		contentPane.add(lblNewLabel_6);
		
		fieldAddressLine2 = new JTextField();
		fieldAddressLine2.setColumns(10);
		fieldAddressLine2.setText(address.getAddressLine2());
		fieldAddressLine2.setBounds(64, 392, 286, 20);
		contentPane.add(fieldAddressLine2);
		
		JLabel lblNewLabel_6_1 = new JLabel("Address Line 2");
		lblNewLabel_6_1.setBounds(64, 377, 182, 14);
		contentPane.add(lblNewLabel_6_1);
		
		fieldSuburb = new JTextField();
		fieldSuburb.setBounds(64, 446, 197, 20);
		fieldSuburb.setText(address.getSuburb());
		contentPane.add(fieldSuburb);
		fieldSuburb.setColumns(10);
		
		fieldPostCode = new JTextField();
		fieldPostCode.setBounds(181, 508, 86, 20);
		
		fieldPostCode.setText(String.valueOf(address.getPostCode()));
		contentPane.add(fieldPostCode);
		fieldPostCode.setColumns(10);
		
		JComboBox<state> choiceState = new JComboBox<state>(state.values());
		choiceState.setBackground(SystemColor.text);
		choiceState.setSelectedItem(address.getState());
		choiceState.setBounds(64, 508, 67, 20);
		contentPane.add(choiceState);
		
		JLabel lblNewLabel_7 = new JLabel("Suburb");
		lblNewLabel_7.setBounds(64, 432, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("State");
		lblNewLabel_8.setBounds(64, 493, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Post Code");
		lblNewLabel_9.setBounds(181, 493, 80, 14);
		contentPane.add(lblNewLabel_9);
		
		fieldEmail = new JTextField();
		fieldEmail.setBounds(64, 272, 286, 20);
		fieldEmail.setText(customer.getEmailAddress());
		contentPane.add(fieldEmail);
		fieldEmail.setColumns(10);
		
		JLabel emailAddressLabel = new JLabel("Email Address");
		emailAddressLabel.setBounds(64, 257, 122, 14);
		contentPane.add(emailAddressLabel);
		
		//create membership button
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sets variables for customer, address, and membership objects
				customer.setName(fieldCustName.getText());
				
				java.util.Date utildob = dateOfBirthChooser.getDate();
		        java.sql.Date sqldob = new java.sql.Date(utildob.getTime());
				customer.setDateOfBirth(sqldob);
				
				customer.setGender((gender) choiceGender.getSelectedItem());
				customer.setPhoneNumber(fieldPhone.getText());
				customer.setEmailAddress(fieldEmail.getText());

				address.setAddressLine1(fieldAddressLine1.getText());
				address.setAddressLine2(fieldAddressLine2.getText()); 
				address.setSuburb(fieldSuburb.getText()); 
				address.setState((state) choiceState.getSelectedItem());
				
				if (fieldPostCode.getText() != null) {
				address.setPostCode(fieldPostCode.getText());
				}
				
				try {
					databaseController.updateMemberDetails();
				    System.out.println("Member "+ membership.getMemberNumber() +" has been updated.");
				    databaseController.setMsgText("Member "+ membership.getMemberNumber() +" has been updated with the details supplied.");
					new genericConfirmationDialog().setVisible(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			    setVisible(false);
			    dispose();
				
			}
		});
		btnConfirm.setForeground(Color.BLACK);
		btnConfirm.setBackground(UIManager.getColor("Button.background"));
		btnConfirm.setBounds(128, 589, 177, 37);
		contentPane.add(btnConfirm);
		

		
	}

}
