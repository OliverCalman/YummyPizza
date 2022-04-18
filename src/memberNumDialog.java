// created by Oliver Calman 14155966 for 32555 Fundamentals of Software Development, 2021

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class memberNumDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5403210532024849029L;
	private final JPanel contentPanel = new JPanel();
	private JTextField memberNumberDisplay;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			memberNumDialog dialog = new memberNumDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationByPlatform(true);
			dialog.setAlwaysOnTop(true);
		    dialog.setVisible(true);
		    } catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public memberNumDialog() {
		setTitle("Membership Created");
		setAlwaysOnTop(true);
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 450, 219);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//takes name from createMemberShipUI and presents in string
		JLabel lblNewLabel = new JLabel("The membership for " + customer.getName());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 30, 414, 14);
		contentPanel.add(lblNewLabel);
		
		//displays the new member number on screen. text field is used to enable copying.
		memberNumberDisplay = new JTextField();
		memberNumberDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		memberNumberDisplay.setText(membership.getMemberNumber());
		memberNumberDisplay.setFont(new Font("Tahoma", Font.BOLD, 15));
		memberNumberDisplay.setEditable(false);
		memberNumberDisplay.setBounds(129, 70, 176, 36);
		contentPanel.add(memberNumberDisplay);
		memberNumberDisplay.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(" has been created with member number:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(33, 45, 368, 14);
		contentPanel.add(lblNewLabel_1);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					    setVisible(false);
					    dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
