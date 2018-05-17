package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import imageProcess.ImagePro;
import process.Booking;
import process.BookingPro;
import process.MoviePro;
import process.MovieSession;

public class BookingSearchGUI extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField tfBooking = new JTextField();
	JButton btSearch = new JButton("Search");
	JButton btCancle = new JButton("");
	JButton btDelete = new JButton("Delete");
	JTable tbBooking = new JTable();
	JScrollPane spBooking = new JScrollPane();
	int _tfBookingWidth = 150;
	int _tfBookingHeight = 35;
	int _tfBookingX = 50;
	int _tfBookingY = 50;
	int _btSearchWidth = 100;
	int _btSearchHeight = 35;
	int _btCancleWidth = 80;
	int _btCancleHeight = 50;
	int _btCancleX = 510;
	int _btCancleY = _tfBookingY;
	int _btDeleteX = 400;
	int _btDeleteY = _tfBookingY;
	TableModel dataModel = null;
	public BookingSearchGUI() {
		setFrame();
	}
	
	public void setFrame() {
		this.setLayout(null);
		tfBooking.setSize(_tfBookingWidth, _tfBookingHeight);
		tfBooking.setLocation(_tfBookingX, _tfBookingY);
		btSearch.setSize(_btSearchWidth, _btSearchHeight);
		btSearch.setLocation(_tfBookingWidth + _tfBookingX, _tfBookingY);
		btCancle.setSize(_btCancleWidth, _btCancleHeight);
		btCancle.setLocation(_btCancleX, _btCancleY);
		btCancle.setIcon(new ImagePro().iCancel);
		btSearch.setIcon(new ImagePro().iSearch);
		btDelete.setBounds(_btDeleteX, _btDeleteY, _btCancleWidth, _btCancleHeight);
		spBooking.setSize(550, 450);
		spBooking.setLocation(50, 120);
		spBooking.getViewport().add(tbBooking);
		loadDataTable(new BookingPro().arr);
		btSearch.addActionListener(this);
		btCancle.addActionListener(this);
		tbBooking.addMouseListener(this);
		btDelete.addActionListener(this);
	
		this.setSize(650, 700);
		this.setLocation(300, 50);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(tfBooking);
		this.add(btSearch);
		this.add(spBooking);
		this.add(btCancle);
		this.add(btDelete);
		this.setVisible(true);
	}
	
	private Object[] loadColumnsName() {
		return new String[]{"Cinema","Movie Name", "Time", "Customer","Customer Email", "Suburn", "ticket Number"};
	}
	
	private Object[][] loadRowsData(List<Booking> arr) {
		Object[][] obj = new Object[arr.size()][7];
		int j = 0;
		for(int i = 0; i < arr.size(); i++) {
			j++;
			System.out.println(j);
			obj[i][0] = arr.get(i).getCinema();
			obj[i][1] = arr.get(i).getFilm();
			obj[i][2] = arr.get(i).getTime();
			obj[i][3] = arr.get(i).getName();
			obj[i][4] = arr.get(i).getEmail();
			obj[i][5] = arr.get(i).getSuburb();
			obj[i][6] = Integer.toString(arr.get(i).getTickNo());
//			System.out.println(obj[i][0]);
		}
		return obj;
	}
	public void loadDataTable(List<Booking> arr) {
		dataModel = new DefaultTableModel(loadRowsData(arr), loadColumnsName());
		tbBooking.setModel(dataModel);
	}
	public void searchingBooking(String str) {
		
		loadDataTable(new BookingPro().searchBooking(str));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btSearch) {
			searchingBooking(tfBooking.getText());
		}
		if(e.getSource() == btCancle) {
			this.dispose();
			new MovieGUI();
		}
		
	}
	public static void main(String args[]) {
		new BookingSearchGUI();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("hihihhihi");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
