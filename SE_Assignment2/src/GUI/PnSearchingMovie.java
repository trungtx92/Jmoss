package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import imageProcess.ImagePro;
import process.MovieSession;
import process.MoviePro;

public class PnSearchingMovie extends JPanel implements ActionListener {
	JTextField tfMvName = new JTextField();
	JButton btSearch = new JButton("Search");
	JTable tbMvName = new JTable();
	JRadioButton rbCinema = new JRadioButton("Cinema");
	JRadioButton rbMovie = new JRadioButton("Movie");
	ButtonGroup bgSearch = new ButtonGroup();
	JScrollPane spMovie = new JScrollPane();
	int _tfMvNameWidth = 150;
	int _tfMvNameHeight = 35;
	int _tfMvNameX = 50;
	int _tfMvNameY = 50;
	int _btMvNameWidth = 100;
	int _btMvNameHeight = 35;
	TableModel dataModel = null;
	MoviePro moviePro = new MoviePro();
	
	public PnSearchingMovie() {
		setPanel();
	}
	
	public void setPanel() {
		this.setLayout(null);
		tfMvName.setSize(_tfMvNameWidth, _tfMvNameHeight);
		tfMvName.setLocation(_tfMvNameX, _tfMvNameY);
		btSearch.setSize(_btMvNameWidth, _btMvNameHeight);
		btSearch.setLocation(_tfMvNameWidth + _tfMvNameX, _tfMvNameY);
		btSearch.setIcon(new ImagePro().iSearch);
		rbCinema.setSelected(true);
		rbCinema.setSize(150, 30);
		rbCinema.setLocation(tfMvName.getX(), tfMvName.getX() + tfMvName.getHeight());
		rbMovie.setSize(150, 30);
		rbMovie.setLocation(tfMvName.getX(), rbCinema.getY() + 30);
		bgSearch.add(rbCinema);
		bgSearch.add(rbMovie);
		spMovie.setSize(450, 350);
		spMovie.setLocation(50, 150);
		spMovie.getViewport().add(tbMvName);
		loadDataTable(new MoviePro().arr);
		btSearch.addActionListener(this);
		
		this.add(rbCinema);
		this.add(rbMovie);
		this.add(tfMvName);
		this.add(btSearch);
		this.add(spMovie);
	}
	
	
	private Object[] loadColumnsName() {
		return new String[]{"Cinema","Movie Name", "Time", "Date","Number of seats"};
	}
	private Object[][] loadRowsData(List<MovieSession> arr) {
		Object[][] obj = new Object[arr.size()][5];
		int j = 0;
		for(int i = 0; i < arr.size(); i++) {
			j++;
			System.out.println(j);
			obj[i][0] = arr.get(i).getCinema();
			obj[i][1] = arr.get(i).getMovieName();
			obj[i][2] = arr.get(i).getTime();
			obj[i][3] = arr.get(i).getDate();
			obj[i][4] = Integer.toString(arr.get(i).getRemainSeatNum());
		}
		return obj;
	}
	public void loadDataTable(List<MovieSession> arr) {
		dataModel = new DefaultTableModel(loadRowsData(arr), loadColumnsName());
		tbMvName.setModel(dataModel);
	}
	public void searchingMovie(String str) {
		MoviePro moviePro = new MoviePro();
		if(rbCinema.isSelected()) {
			loadDataTable(moviePro.searchCinema(str));
		}
		if(rbMovie.isSelected()) {
			loadDataTable(moviePro.searchMovie(str));
		}
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btSearch) {
			searchingMovie(tfMvName.getText());
		}
	}
}
