package process;

public class Movie {
	private String cinema;
	private String movieName;
	private String time;
	private String date;
	private int remainSeatNum;
	
	public Movie(String cinema, String movieName, String time, String date, int remainSeatNum) {
		this.cinema = cinema;
		this.movieName = movieName;
		this.time = time;
		this.date = date;
		this.remainSeatNum = remainSeatNum;
	}
	public String toString(){
	    return cinema + ",  " + movieName + ",  " + time;
	  }
	public String getCinema() {
		return cinema;
	}
	public void setCinema(String cinema) {
		this.cinema = cinema;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getRemainSeatNum() {
		return remainSeatNum;
	}
	public void setRemainSeatNum(int remainSeatNum) {
		this.remainSeatNum = remainSeatNum;
	}
}
