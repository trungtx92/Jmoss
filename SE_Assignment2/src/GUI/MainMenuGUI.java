package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import imageProcess.ImagePro;

public class MainMenuGUI extends JFrame implements ActionListener {
//	JPanel pnMainPanel = new JPanel();
	int _height = 800;
	int _weight = 600;
	int _x = 400;
	int _y = 100;
	int _btnX = 120;
	int _btnY = 40;
	int _pnContentX = 650;
	int _pnDashBoardX = 150;
	
	
	ImagePro imaPro = new ImagePro();
	JPanel pnDashBoard = new JPanel();
	JPanel pnContent = new JPanel();
	
	JButton btShowList = new JButton("List Movie");
	JButton btSearchMovie = new JButton("Search");
	JButton btBooking = new JButton("Booking");
	JButton btCancel = new JButton("Cancel");
	JLabel lbContentBackground = new JLabel();
	public MainMenuGUI() {
		setFrame();
		this.setSize(_height, _weight);
		this.setLocation(_x, _y);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setFrame() {
		this.setLayout(null);
		pnDashBoard.setLayout(null);
		pnContent.setLayout(new CardLayout());
		pnDashBoard.setSize(_pnDashBoardX, _height);
		pnDashBoard.setLocation(0, 0);
		pnContent.setSize(_pnContentX, _height);
		pnContent.setLocation(_pnDashBoardX, 0);
		btCancel.setSize(_btnX, _btnY);
		btShowList.setSize(_btnX, _btnY);
		btSearchMovie.setSize(_btnX, _btnY);
		btBooking.setSize(_btnX, _btnY);
		
		btShowList.setLocation(5, 30);
		btSearchMovie.setLocation(5, btShowList.getY() + btShowList.getHeight() + 20);
		btBooking.setLocation(5, btSearchMovie.getY() + btSearchMovie.getHeight() + 20);
		btCancel.setLocation(5, btBooking.getY() + btBooking.getHeight() + 20);
		

		btShowList.setIcon(imaPro.iList);
		btSearchMovie.setIcon(imaPro.iSearch);
		btBooking.setIcon(imaPro.iBooking);
		btCancel.setIcon(imaPro.iCancel);
		lbContentBackground.setIcon(imaPro.iMovieContent);
		
		pnDashBoard.add(btShowList);
		pnDashBoard.add(btSearchMovie);
		pnDashBoard.add(btBooking);
		pnDashBoard.add(btCancel);
		pnContent.add(lbContentBackground);
		btSearchMovie.addActionListener(this);
		btBooking.addActionListener(this);
		btCancel.addActionListener(this);
		this.add(pnDashBoard);
		this.add(pnContent);
//		this.add(pnMainPanel);
	}
	public static void main(String args[]) {
		MainMenuGUI mg = new MainMenuGUI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btSearchMovie) {
			pnContent.removeAll();
			pnContent.add(new PnSearchingMovie());
			pnContent.repaint();
			pnContent.revalidate();
		}
		if(e.getSource() == btBooking) {
			this.dispose();
			new MovieGUI();
		}
		if(e.getSource() == btCancel) {
			this.dispose();
			new LoginUI();
		}
	}
}
