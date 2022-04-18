// created by Oliver Calman 14155966 for 32555 Fundamentals of Software Development, 2021

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;


public class mainMenuUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8204344931210226390L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenuUI frame = new mainMenuUI();
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
	public mainMenuUI() {
		setTitle("Yummy Pizza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 553, 298);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//yummy pizza logo
		JLabel pizzaLogo = new JLabel("");
		pizzaLogo.setIcon(new ImageIcon(mainMenuUI.class.getResource("/resources/pizzaLogo.png")));
		pizzaLogo.setBounds(10, 46, 220, 199);
		contentPane.add(pizzaLogo);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(245, 56, 269, 178);
		
		JComponent panel1 = makeTextPanel("Orders");
		tabbedPane.addTab("Orders", null, panel1, "Orders");

		JComponent panel2 = makeTextPanel("Bookings");
		tabbedPane.addTab("Bookings", null, panel2, "Bookings");

		JComponent panel3 = makeTextPanel("Memberships");
		tabbedPane.addTab("Memberships", null, panel3, "Memberships");
		
		contentPane.add(tabbedPane);
		
		JButton btnNewOrder = new JButton("New Order");
		btnNewOrder.setBounds(52, 38, 160, 23);
		panel1.add(btnNewOrder);
		
		JButton btnManageOrders = new JButton("Manage Orders");
		btnManageOrders.setBounds(52, 92, 160, 23);
		panel1.add(btnManageOrders);
		
		JButton btnCreateBooking = new JButton("Create Booking");
		btnCreateBooking.setBounds(52, 38, 160, 23);
		panel2.add(btnCreateBooking);
		
		JButton btnManageBookings = new JButton("Manage Bookings");
		btnManageBookings.setBounds(52, 92, 160, 23);
		panel2.add(btnManageBookings);
		
		JButton createMembershipButton = new JButton("Create Membership");
		createMembershipButton.setBounds(52, 38, 160, 23);
		panel3.add(createMembershipButton);
		createMembershipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new createMembershipUI().setVisible(true);
			}
		});
		
		JButton manageMembershipsButton = new JButton("Manage Memberships");
		manageMembershipsButton.setBounds(52, 92, 160, 23);
		panel3.add(manageMembershipsButton);
		manageMembershipsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new manageMembershipUI().setVisible(true);
			}
		});
		
		JLabel lbTitleLabel = new JLabel("Yummy Pizza Store System");
		lbTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbTitleLabel.setBounds(69, 11, 399, 24);
		contentPane.add(lbTitleLabel);
		
	}

	//protected JComponent for the above tabbed pane text panels - sets base schema for the panels
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        panel.setBorder(null);
        panel.setBackground(Color.WHITE);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(null);
        panel.add(filler);
        return panel;
    }
}
