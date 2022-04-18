// created by Oliver Calman 14155966 for 32555 Fundamentals of Software Development, 2021

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;


public class manageMembershipUI extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1597922053081085441L;
	private JPanel contentPane;
	private JTextField searchField;
	private String memberDisplayTxt = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageMembershipUI frame = new manageMembershipUI();
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
	public manageMembershipUI() {
		setBackground(Color.WHITE);
		setTitle("Manage Memberships");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Memberships");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(5, 5, 424, 40);
		contentPane.add(lblNewLabel);
				
		searchField = new JTextField();
		searchField.setBounds(31, 76, 239, 23);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		JTextArea memberDisplay = new JTextArea();
		memberDisplay.setWrapStyleWord(true);
		memberDisplay.setLineWrap(true);
		memberDisplay.setEditable(false);
		memberDisplay.setBounds(31, 119, 372, 40);
		contentPane.add(memberDisplay);
		
		JButton btnEditMember = new JButton("Edit");
		btnEditMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new editMemberUI().setVisible(true);
			}
		});
		btnEditMember.setEnabled(false);
		btnEditMember.setBounds(257, 196, 89, 23);
		contentPane.add(btnEditMember);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					databaseController.deleteMember();
					databaseController.setMsgText("Member "+ membership.getMemberNumber() +" has been deleted.");
					new genericConfirmationDialog().setVisible(true);
				} catch (Exception e1) {
				    System.out.println("Unable to delete member due to error.");
					e1.printStackTrace();
				}
				databaseController.voidQuery();
					searchField.setText(" ");
					memberDisplay.setText(" ");
					btnDelete.setEnabled(false);
					btnEditMember.setEnabled(false);
			}
		});
		btnDelete.setBounds(91, 196, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				databaseController.voidQuery();			
				databaseController.setSearchParam(searchField.getText());
				
				try {
			
					databaseController.getMemberDetails();
										
					if(customer.getName() != null) {
						
						memberDisplayTxt = "Member #" + membership.getMemberNumber() + ": " + customer.getName();
						btnEditMember.setEnabled(true);
						btnDelete.setEnabled(true);
						memberDisplay.setText(memberDisplayTxt);
						
						
					}
				
					else {
						memberDisplay.setText("No results exist for your query. Check the parameters and try again.");
						btnEditMember.setEnabled(false);
						btnDelete.setEnabled(false);
					}

					
				} catch (Exception e1) {
					memberDisplay.setText("No results exist for your query. Check the parameters and try again.");
					e1.printStackTrace();
				}		
			}
		});
		btnSearch.setBounds(294, 76, 89, 23);
		contentPane.add(btnSearch);
		
		JRootPane rootPane = SwingUtilities.getRootPane(btnSearch); 
		rootPane.setDefaultButton(btnSearch);

	}
}

