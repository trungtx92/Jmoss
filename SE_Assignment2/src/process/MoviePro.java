package process;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoviePro {
	public List<MovieSession> arr = new ArrayList<MovieSession>();
	public List<MovieSession> arrSearch = new ArrayList<MovieSession>();
	BufferedReader input = null;
	public MoviePro() {
		loadDataMovie();
	}
	public void loadDataMovie() {
		String line;
		String str[];
//		for(mvSession mvSession: arr) {
//			arr.remove(mvSession);
//		}
		try {
			input = new BufferedReader(new FileReader("document/movieSession.txt"));
			line = input.readLine();
			MovieSession mvSession = null;
			while(line != null) {
//				System.out.println(line);
				str = line.split("-");
				
				try {
					mvSession = new MovieSession(str[0], str[1], str[2], str[3], Integer.parseInt(str[4]));
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("ArrayIndexOutOfBoundsException!");
				}catch(NumberFormatException e) {
					System.out.println("NumberFormatException!");
				}
			
				arr.add(mvSession);
				line = input.readLine();
			}
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public List<MovieSession> searchMovie(String str){
		Pattern pattern = Pattern.compile(".*"+str+".*");
		Matcher matcher;
		for(MovieSession mvSession: arrSearch) {
			arrSearch.remove(mvSession);
		}
		for(MovieSession mvSession: arr) {
			matcher = pattern.matcher(mvSession.getMovieName());
			if(matcher.matches() == true) {
				arrSearch.add(mvSession);
			}
		}
		return arrSearch;
	}
	
	public List<MovieSession> searchCinema(String str){
		Pattern pattern = Pattern.compile(".*"+str+".*");
		Matcher matcher;
		for(MovieSession mvSession: arrSearch) {
			arrSearch.remove(mvSession);
		}
		for(MovieSession mvSession: arr) {
			matcher = pattern.matcher(mvSession.getCinema());
			if(matcher.matches() == true) {
				arrSearch.add(mvSession);
			}
		}
		return arrSearch;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoviePro moviePro = new MoviePro();
		for(MovieSession movie:moviePro.arr ) {
			System.out.println(movie.getCinema());
			System.out.println(movie.getMovieName());
			System.out.println(movie.getTime());
			System.out.println(movie.getDate());
			System.out.println(movie.getRemainSeatNum());
		}
	}
	
}
