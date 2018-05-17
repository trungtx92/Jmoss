package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import process.Booking;
import process.Movie;
import process.MovieSession;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.io.*;
import java.util.List;

public class MovieGUI extends JFrame {
    ArrayList<Movie> movies = new ArrayList<Movie>();
    ArrayList<Booking> bookings = new ArrayList<Booking>();
    BufferedReader input = null;
    //containers
    JDialog login = new JDialog();
    JDialog main = new JDialog();
    JDialog view = new JDialog();
    JDialog booking = new JDialog();
    JDialog search = new JDialog();

    //main containers
    JPanel mainButtonPanel = new JPanel();

    JButton btnView = new JButton("View"), btnBooking = new JButton("Booking"), btnSearch = new JButton("Search");
    JButton btnQuit = new JButton("Quit");

    //search containers
    JPanel searchPanelInput = new JPanel();
    JPanel searchPanelDisplay = new JPanel();
    JPanel searchPanelButtons = new JPanel();

    JLabel SearchInfo = new JLabel("Enter any one of the following: ");
    JLabel lblSFilm = new JLabel("Film"), lblSCinema = new JLabel("Cinema"), lblSEmail = new JLabel("Email");
    JTextField txtSCinema = new JTextField(10), txtSFilm = new JTextField(20), txtSEmail = new JTextField(20);
    JButton btnFindFilm = new JButton("Search by Film"), btnClearSearch = new JButton("Clear");
    JButton btnFindEmail = new JButton("Search by Email"), btnFindCinema = new JButton("Search by Cinema");
    JTextArea jtaSearch = new JTextArea(10, 20);

    //view containers
    JPanel viewPanelInput = new JPanel();
    JPanel viewPanelDisplay = new JPanel();
    JPanel viewPanelButtons = new JPanel();
    //components
    JTextArea jtaView = new JTextArea(50, 30);
    JButton btnViewAll = new JButton("View All Movies");

    //booking containers
    JPanel bookingPanelInput = new JPanel();
    JPanel bookingPanelDisplay = new JPanel();
    JPanel bookingPanelButtons = new JPanel();

    JTextArea jtaBooking = new JTextArea(10, 20);
    JLabel lblName = new JLabel("Name"), lblEmail = new JLabel("Email"), lblPhone = new JLabel("Phone");
    JLabel lblCinema = new JLabel("Cinema"), lblFilm = new JLabel("Film"), lblTime = new JLabel("Time");
    JTextField txtName = new JTextField(30), txtEmail = new JTextField(20), txtTick = new JTextField(10);
    JTextField txtCinema = new JTextField(20), txtFilm = new JTextField(30), txtTime = new JTextField(10);

    JButton btnSaveBooking = new JButton("Save Booking");
    JButton btnRetrieveBooking = new JButton("Retrieve Booking"), btnClearPanel = new JButton("Clear panel");

    JButton btnAdd = new JButton("Add"), btnList = new JButton("List"), btnSave = new JButton("Save");
    JButton btnClear = new JButton("Clear"), btnRead = new JButton("Read Movies");

    JTextArea jtaList = new JTextArea(10, 20);

    //login containers
    JPanel loginPanelInput = new JPanel();
    JPanel loginPanelDisplay = new JPanel();
    JPanel loginPanelButtons = new JPanel();

    JLabel lblUser = new JLabel("Username"), lblPass = new JLabel("Password");
    JTextField txtUser = new JTextField(10), txtPass = new JTextField(10);
    JButton btnLogin = new JButton("Login"), btnRegister = new JButton("Register");
    JTextArea jtaLogin = new JTextArea(10, 10);

    public MovieGUI() {
        //create main GUI
        main.add(mainButtonPanel, BorderLayout.CENTER);
        main.setLocation(300, 100);
        mainButtonPanel.setLayout(new GridLayout(4, 1, 10, 10));

        mainButtonPanel.add(btnView);
        mainButtonPanel.add(btnBooking);
        mainButtonPanel.add(btnSearch);
        mainButtonPanel.add(btnQuit);

        main.setVisible(true);
        main.setTitle("Menu");
        main.setSize(500, 600);
        main.setDefaultCloseOperation(HIDE_ON_CLOSE);

        //create view GUI
        view.add(viewPanelInput, BorderLayout.NORTH);
        view.add(viewPanelDisplay, BorderLayout.CENTER);
        view.add(viewPanelButtons, BorderLayout.SOUTH);

        viewPanelInput.setLayout(new GridLayout(3, 2, 10, 10));

        viewPanelButtons.add(btnViewAll);

        viewPanelDisplay.add(jtaView);
        jtaView.setBorder(new TitledBorder("List of movies"));

        view.setTitle("View Movies");
        view.setSize(1000, 450);
        view.setVisible(false);
        view.setDefaultCloseOperation(HIDE_ON_CLOSE);

        //create booking GUI
        booking.add(bookingPanelInput, BorderLayout.NORTH);
        booking.add(bookingPanelDisplay, BorderLayout.CENTER);
        booking.add(bookingPanelButtons, BorderLayout.SOUTH);

        bookingPanelInput.setLayout(new GridLayout(3, 2, 10, 10));

        bookingPanelInput.add(lblCinema);
        bookingPanelInput.add(txtCinema);
        bookingPanelInput.add(lblFilm);
        bookingPanelInput.add(txtFilm);
        bookingPanelInput.add(lblTime);
        bookingPanelInput.add(txtTime);
        bookingPanelInput.add(lblName);
        bookingPanelInput.add(txtName);
        bookingPanelInput.add(lblPhone);
        bookingPanelInput.add(txtTick);
        bookingPanelInput.add(lblEmail);
        bookingPanelInput.add(txtEmail);

        bookingPanelDisplay.add(jtaBooking);
        jtaBooking.setBorder(new TitledBorder("List of bookings"));

        bookingPanelButtons.add(btnSaveBooking);
        bookingPanelButtons.add(btnRetrieveBooking);
        bookingPanelButtons.add(btnClearPanel);

        booking.setTitle("Bookings");
        booking.setSize(800, 500);
        booking.setVisible(false);
        booking.setDefaultCloseOperation(HIDE_ON_CLOSE);

        //create search GUI
        search.add(searchPanelInput, BorderLayout.NORTH);
        search.add(searchPanelDisplay, BorderLayout.CENTER);
        search.add(searchPanelButtons, BorderLayout.SOUTH);

        searchPanelInput.setSize(400, 400);
        searchPanelInput.setLayout(new GridLayout(2, 3, 20, 20));

        searchPanelInput.add(SearchInfo);
        searchPanelInput.add(lblSCinema);
        searchPanelInput.add(txtSCinema);
        searchPanelInput.add(lblSFilm);
        searchPanelInput.add(txtSFilm);
        searchPanelInput.add(lblSEmail);
        searchPanelInput.add(txtSEmail);

        searchPanelDisplay.add(jtaSearch);
        jtaSearch.setBorder(new TitledBorder("Results"));

        searchPanelButtons.add(btnFindCinema);
        searchPanelButtons.add(btnFindFilm);
        searchPanelButtons.add(btnFindEmail);
        searchPanelButtons.add(btnClearSearch);

        search.setTitle("Search");
        search.setSize(600, 600);
        search.setVisible(false);
        search.setDefaultCloseOperation(HIDE_ON_CLOSE);

        //create login GUI
        login.add(loginPanelInput, BorderLayout.CENTER);
        login.add(loginPanelDisplay, BorderLayout.WEST);
        login.add(loginPanelButtons, BorderLayout.SOUTH);

        loginPanelInput.setLayout(new GridLayout(3, 2, 10, 10));

        loginPanelInput.add(lblUser);
        loginPanelInput.add(txtUser);
        loginPanelInput.add(lblPass);
        loginPanelInput.add(txtPass);

        loginPanelButtons.add(btnLogin);
        loginPanelButtons.add(btnRegister);

        loginPanelDisplay.add(jtaLogin);
        jtaLogin.setBorder(new TitledBorder("Messages"));

        login.setTitle("Login");
        login.setSize(600, 600);
        login.setAlwaysOnTop(true);
        login.setVisible(false);


        //register the action listener
        ButtonHandler bh = new ButtonHandler(main);
        btnAdd.addActionListener(bh);
        btnList.addActionListener(bh);
        btnClear.addActionListener(bh);
        btnSave.addActionListener(bh);
        btnRead.addActionListener(bh);

        btnViewAll.addActionListener(bh);

        btnLogin.addActionListener(bh);
        btnRegister.addActionListener(bh);

        btnView.addActionListener(bh);
        btnBooking.addActionListener(bh);
        btnSearch.addActionListener(bh);
        btnQuit.addActionListener(bh);

        btnSaveBooking.addActionListener(bh);
        btnRetrieveBooking.addActionListener(bh);
        btnClearPanel.addActionListener(bh);

        btnFindEmail.addActionListener(bh);
        btnFindCinema.addActionListener(bh);
        btnFindFilm.addActionListener(bh);
        btnClearSearch.addActionListener(bh);
//        login.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.main.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//        search.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        view.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        booking.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void saveMovie() {
        try {
            FileOutputStream fos = new FileOutputStream("document/movie.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Movie m : movies) {
                oos.writeObject(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveMovieTxt() {
    		FileWriter writer = null;

		try {
			writer = new FileWriter("document/movieSession.txt");
			for (Movie m : movies) {
				writer.write(m.toString());
            }
			writer.close();// flushes the stream.

		} catch (IOException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
    }
    public void readMovie() {
        movies.clear();
        try {
            FileInputStream fis = new FileInputStream("document/movie.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                Object obj = ois.readObject();
                Movie m = (Movie) obj;
                movies.add(m);
            }
        } catch (EOFException eof) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readMovieTxt() {
        movies.clear();
        String line;
		String str[];
		try {
			input = new BufferedReader(new FileReader("document/movieSession.txt"));
			line = input.readLine();
			Movie mvSession = null;
			while(line != null) {
//				System.out.println(line);
				str = line.split("-");
				
				try {
					mvSession = new Movie(str[0], str[1], str[2], str[3], Integer.parseInt(str[4]));
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("ArrayIndexOutOfBoundsException!");
				}catch(NumberFormatException e) {
					System.out.println("NumberFormatException!");
				}
			
				movies.add(mvSession);
				line = input.readLine();
			}
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    public void saveBooking() {
        try {
            FileOutputStream fos = new FileOutputStream("document/booking.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Booking b : bookings) {
                oos.writeObject(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveBookingTxt() {
    		FileWriter writer = null;

		try {
			writer = new FileWriter("document/booking.txt");
			for (Booking b : bookings) {
				writer.write(b.toString());
            }
			writer.close();// flushes the stream.

		} catch (IOException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
    }

    public void readBooking(){
        bookings.clear();
        try {
            FileInputStream fis = new FileInputStream("document/booking.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                Object obj = ois.readObject();
                Booking b = (Booking) obj;
                bookings.add(b);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }	
    public void readBookingTxt(){
        bookings.clear();
        String line;
		String str[];
//		for(mvSession mvSession: arr) {
//			arr.remove(mvSession);
//		}
		try {
			input = new BufferedReader(new FileReader("document/booking.txt"));
			line = input.readLine();
			Booking booking = null;
			while(line != null) {
//				System.out.println(line);
				str = line.split("-");
				
				try {
					booking = new Booking(str[0], str[1], str[2], str[3], str[4], str[5], Integer.parseInt(str[6]));
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("ArrayIndexOutOfBoundsException!");
				}catch(NumberFormatException e) {
					System.out.println("NumberFormatException!");
				}
			
				bookings.add(booking);
				line = input.readLine();
			}
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void addBooking() {
        String cinema = txtCinema.getText();
        String film = txtFilm.getText();
        String time = txtTime.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        int tickNo = Integer.parseInt(txtTick.getText());
        String suburb = "";

        bookings.add(new Booking(cinema, film, time, name, email, suburb, tickNo));

        //clear the text fields
        txtCinema.setText("");
        txtFilm.setText("");
        txtTime.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtTick.setText("");
    }

    public void findMovieByCinema() {
        for (Movie m : movies) {
            System.out.printf("Retrieved cinema: %s\n", m.getCinema());

            if (m.getCinema().equals(txtSCinema.getText())) {
                System.out.printf("Result is: %s\n", m.toString());
            } else {
                System.out.println("No Result");
            }
        }
    }

    public void findMovieByFilm() {
        for (Movie m : movies) {
            System.out.printf("Retrieved film: %s\n", m.getMovieName());

            if (m.getMovieName().equals(txtSFilm.getText())) {
                System.out.printf("Result is: %s\n", m.toString());
            } else {
                System.out.println("No Result");
            }
        }
    }
        public void findBookingByEmail () {
            for (Booking b : bookings) {
                System.out.printf("Retrieved email: %s\n", b.getEmail());

                if (b.getEmail().equals(txtSEmail.getText())) {
                    System.out.printf("Result is: %s\n", b.toString());
                } else {
                    System.out.println("No Result");
                }
            }
        }

    public void RegisterUser() throws IOException{
        String username = txtUser.getText();
        String password = txtPass.getText();

        String account = "\n"+username+"-"+password+"\n";

        BufferedWriter writer = new BufferedWriter(new FileWriter("document/login.txt",true));
        writer.append(account);
        writer.close();

        jtaLogin.setText("Registered -- Welcome: "+ username+"\n");
    }
    public void LoginUser(){
        String username2 = txtUser.getText();
        String password2 = txtPass.getText();

        login(username2,password2);
    }

    public void login(String user, String pass){
        List<String> list;
        list = isList("document/login.txt");

        if(isRegistered(list,user,pass)){
            jtaLogin.setText("Successful Login!!!");
            login.setVisible(false);
            main.setVisible(true);
        }
        else
            jtaLogin.setText("Wrong userID or password!!!");
    }

    public Boolean isRegistered(List<String> list, String username, String password){
        boolean isCheck = false;
        String[] res;
        for(String line : list){
            res = line.split("-");
            if(res[0].equals(username) && res[1].equals(password)){
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }
    public static List<String> isList(String filename){
        List<String> list = new ArrayList<String>();

        File file = new File(filename);
        if(file.exists()){
            try {
                list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }


    public static void main(String[] args){

        new MovieGUI();
    }

    class ButtonHandler implements ActionListener{
    		JDialog main;
    		public ButtonHandler(JDialog main) {
    			this.main = main;
    		}
        public void actionPerformed(ActionEvent e){
            //main buttons
            if(e.getSource() == btnView){
                view.setVisible(true);
            }
            if(e.getSource() == btnBooking){
                booking.setVisible(true);
            }
            if(e.getSource() == btnSearch){
//                search.setVisible(true);
            		search.dispose();
            		main.dispose();
            		new BookingSearchGUI();
            }
            if(e.getSource() == btnQuit){
                main.dispose();
                new MainMenuGUI();
//            		System.exit(0);
                
            }
            //view buttons
            if(e.getSource() == btnAdd){
                //read the data
                String cinema = txtCinema.getText();
                String film = txtFilm.getText();
                String time = txtTime.getText();

                movies.add(new Movie(cinema, film, time, "", 0));

                //clear the text fields
                txtCinema.setText("");
                txtFilm.setText("");
                txtTime.setText("");
            }
            if(e.getSource() == btnList){
                jtaList.setText("");
                for(Movie m: movies){
                    jtaList.append("   "+ m.toString()+ "\n");
                }
            }
            if(e.getSource() == btnClear){
                jtaList.setText("");
            }
            if(e.getSource() == btnSave){
                saveMovie();
            }
            if(e.getSource() == btnRead){
                readMovie();
                jtaList.setText("");
                for(Movie m: movies){
                    jtaList.append("   "+ m.toString()+ "\n");
                }
            }
            if(e.getSource() == btnViewAll) {
                readMovieTxt();
                jtaSearch.setText("");
                for (Movie m : movies) {
                    jtaView.append("   " + m.toString() + "\n");
                }
            }
            //login buttons
            if(e.getSource() == btnLogin){
                LoginUser();
                txtUser.setText("");
                txtPass.setText("");
            }
            if(e.getSource() == btnRegister) {
                try {
                    RegisterUser();
                    txtUser.setText("");
                    txtPass.setText("");
                } catch (IOException ioe) {
                    //Handle Exception
                }
            }
            //booking buttons
            if(e.getSource() == btnSaveBooking){
                addBooking();
                saveBooking();
            }
            if(e.getSource() == btnRetrieveBooking) {
                readBookingTxt();
                jtaBooking.setText("");
                for (Booking b : bookings) {
                    jtaBooking.append(" " + b.toString() + "\n");
                }
            }
            if(e.getSource() == btnClearPanel){
                jtaBooking.setText("");
            }
            if(e.getSource() == btnFindCinema){
                findMovieByCinema();
            }
            if(e.getSource() == btnFindFilm){
                findMovieByFilm();
            }
            if(e.getSource() == btnFindEmail){
                findBookingByEmail();
            }
            if(e.getSource() == btnClearSearch){
                jtaSearch.setText("");
            }

        }
    }//end of class ButtonHandler

}//end of class 
