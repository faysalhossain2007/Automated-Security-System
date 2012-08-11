package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.InfoQueries;

public class LogInView extends JFrame {

	/**
	 * faysal
	 */
	private static final long serialVersionUID = 3238505063965559438L;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField passwordTextField;
	private static InfoQueries infoQueries;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInView frame = new LogInView();
					frame.setVisible(true);
					infoQueries = new InfoQueries();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(142, 74, 86, 20);
		panel.add(nameTextField);
		nameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(142, 124, 86, 20);
		panel.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				infoQueries.addPerson(
						nameTextField.getText(), passwordTextField.getText());
			}
		});
		btnSignup.setBounds(282, 73, 89, 23);
		panel.add(btnSignup);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			boolean	results = infoQueries.getPeopleByUsername(nameTextField.getText(),passwordTextField.getText());
			if(results==true)System.out.print("yes");
			else System.out.print("No");
			}
		});
		btnLogIn.setBounds(282, 123, 89, 23);
		panel.add(btnLogIn);
	}
}
