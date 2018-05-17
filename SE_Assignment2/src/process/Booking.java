package process;

import java.io.*;

import GUI.MovieGUI;

public class Booking implements Serializable{
    private String cinema, film, name, email;
    private String   suburb;
    private int tickNo;
    private String time;

    public Booking(String cinema, String film, String time, String name, String email, String suburb, int tickNo){
        this.cinema = cinema;
        this.film = film;
        this.time = time;
        this.name = name;
        this.email = email;
        this.suburb = suburb;
        this.tickNo = tickNo;
    }
    public String toString(){
        return cinema + "-" + film + "-" + time + "-" + name + "-" + email + "-" + suburb + "-" + tickNo;
    }
    public static void main(String[] args){
        new MovieGUI();
    }
    //set and get methods to be implemented

    public String getEmail(){
        return email;
    }
	public String getFilm() {
		return film;
	}
	public void setFilm(String film) {
		this.film = film;
	}
	public String getCinema() {
		return cinema;
	}
	public void setCinema(String cinema) {
		this.cinema = cinema;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	public int getTickNo() {
		return tickNo;
	}
	public void setTickNo(int tickNo) {
		this.tickNo = tickNo;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

    
}
