package process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookingPro {
	public List<Booking> arr = new ArrayList<Booking>();
	public List<Booking> arrSearch = new ArrayList<Booking>();
	PrintWriter writer = null;
	public BookingPro() {
		loadDataMovie();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookingPro bookingPro = new BookingPro();
		for(Booking booking: bookingPro.arr ) {
			System.out.println("Cinema: " + booking.getCinema());
			System.out.println("film: " + booking.getFilm());
			System.out.println("time: " + booking.getTime());
			System.out.println("name: " + booking.getName());
			System.out.println("email: " + booking.getEmail());
			System.out.println("suburn: " + booking.getSuburb());
			System.out.println("number: " + booking.getTickNo());
			System.out.println("------------------------------");
		}
	}
	public void loadDataMovie() {
		String line;
		String str[];
		BufferedReader input = null;
//		for(booking booking: arr) {
//			arr.remove(booking);
//		}
		try {
			input = new BufferedReader(new FileReader("document/booking.txt"));
			line = input.readLine();
			System.out.println(line);
			Booking booking = null;
			while(line != null) {
				
				str = line.split("-");
				
				try {
					booking = new Booking(str[0], str[1], str[2], str[3], str[4], str[5], Integer.parseInt(str[6]));
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("ArrayIndexOutOfBoundsException!");
				}catch(NumberFormatException e) {
//					continue;
					System.out.println("NumberFormatException!");
				}
			
				arr.add(booking);
				line = input.readLine();
				System.out.println(line);
			}
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void saveDataBooking(List<Booking> arr) {
		String str;
		try {
			writer = new PrintWriter("document/movieSession.txt");
			for(Booking booking: arr) {
				str = booking.toString();
				writer.println(str);
			}
			
		}catch(IOException e) {
			System.err.println("Error to create file!");
		}
		writer.close();
	}
	public List<Booking> searchBooking(String str){
		Pattern pattern = Pattern.compile(".*"+str+".*");
		Matcher matcher;
		for(Booking booking: arrSearch) {
			arrSearch.remove(booking);
		}
		for(Booking booking: arr) {
			matcher = pattern.matcher(booking.getEmail());
			if(matcher.matches() == true) {
				arrSearch.add(booking);
			}
		}
		return arrSearch;
	}
	public List<Booking> deleteBooking(String cinema, String movie, String email){
		for(Booking booking: arr) {
			if(cinema.equals(booking.getCinema()) && movie.equals(booking.getFilm()) && email.equals(booking.getEmail())) {
				arr.remove(booking);
			}
		}
		return arr;
	}
}





