package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Security extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Security dialog = new Security();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Security() {
		setBackground(Color.WHITE);
		setTitle("Xác nhận mật khẩu");
		setBounds(100, 100, 314, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("User name : ");
			lblNewLabel.setBounds(40, 66, 80, 16);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel txtPassword = new JLabel("Password  : ");
		txtPassword.setBounds(40, 111, 80, 16);
		contentPanel.add(txtPassword);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(132, 61, 164, 26);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel textAnnounce = new JLabel("Nhập tài khoản riêng của bạn để truy cập");
		textAnnounce.setHorizontalAlignment(SwingConstants.CENTER);
		textAnnounce.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textAnnounce.setBounds(6, 9, 302, 35);
		contentPanel.add(textAnnounce);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(131, 106, 165, 26);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Chấp nhận quyền truy cập. 
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
