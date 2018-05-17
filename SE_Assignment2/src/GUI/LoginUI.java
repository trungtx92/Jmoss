package GUI;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import imageProcess.ImagePro;
import soundProcess.SoundPro;

public class LoginUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImagePro imaPro = new ImagePro();
	JPanel pnLogin = new JPanel();
	JButton btLogin = new JButton("Login");
	JButton btExit = new JButton("Exit");
	JLabel lbUsername = new JLabel("Username:");
	JLabel lbPassword = new JLabel("Password:");
	JTextField tfUsername = new JTextField();
	JPasswordField tfPassword = new JPasswordField();
	
	public LoginUI() {
		setFrame();
		this.setSize(400, 300);
		this.setLocation(400, 100);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	public void setFrame() {
		this.setLayout(new CardLayout());
		pnLogin.setLayout(null);
		lbUsername.setSize(100, 30);
		lbUsername.setLocation(30, 50);
		lbPassword.setSize(100, 30);
		lbPassword.setLocation(30, 100);
		tfUsername.setSize(200, 30);
		tfUsername.setLocation(lbUsername.getX() + lbUsername.getWidth(), lbUsername.getY());
		tfPassword.setSize(200, 30);
		tfPassword.setLocation(lbPassword.getX() + lbPassword.getWidth(), lbPassword.getY());
		btLogin.setSize(90, 35);
		btLogin.setLocation(tfPassword.getX(), tfPassword.getY() + 50);
		btExit.setSize(90, 35);
		btExit.setLocation(btLogin.getX() + btLogin.getWidth() + 30, btLogin.getY());
		
		lbUsername.setIcon(imaPro.iUsername);
		lbPassword.setIcon(imaPro.iPassword);
		btLogin.setIcon(imaPro.iLogin);
		btExit.setIcon(imaPro.iExit);
		
		btLogin.addActionListener(this);
		btExit.addActionListener(this);
		
		pnLogin.add(lbUsername);
		pnLogin.add(lbPassword);
		pnLogin.add(tfUsername);
		pnLogin.add(tfPassword);
		pnLogin.add(btLogin);
		pnLogin.add(btExit);
		this.add(pnLogin);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btLogin) {
			process.Login log = new process.Login();
			if(log.login(tfUsername.getText(), tfPassword.getText()) == true) {
				this.dispose();
				tfUsername.setText("");
				tfPassword.setText("");
				new MainMenuGUI();
			}
			else {
				JOptionPane.showMessageDialog(null, "login false!");
				tfUsername.setText("");
				tfPassword.setText("");
			}
		}
		if(e.getSource() == btExit) {
			new SoundPro().playwav("sound/beep.wav");
			System.exit(0);
		}
	}
	
}











