// created by Oliver Calman 14155966 for 32555 Fundamentals of Software Development, 2021

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class genericConfirmationDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5467323270282367130L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					genericConfirmationDialog dialog = new genericConfirmationDialog();
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
	public genericConfirmationDialog() {
		setTitle("Operation Success");
		setAlwaysOnTop(true);
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(200, 200, 450, 228);
		getContentPane().setLayout(null);
		
		JButton okClose = new JButton("OK");
		okClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    setVisible(false);
			    dispose();
			}
		});
		okClose.setBounds(367, 155, 57, 23);
		getContentPane().add(okClose);
		
		JTextArea msgTxtArea = new JTextArea();
		msgTxtArea.setWrapStyleWord(true);
		msgTxtArea.setLineWrap(true);
		msgTxtArea.setEditable(false);
		msgTxtArea.setText(databaseController.getMsgText());
		msgTxtArea.setBounds(32, 25, 370, 102);
		getContentPane().add(msgTxtArea);

	}
}
