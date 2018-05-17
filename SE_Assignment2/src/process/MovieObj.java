package process;

public class MovieObj {
	private String _movieName;
	private String _director;
	private String _releasedDate;
	private int _runningTime;
	
	public MovieObj(String movieName, String director, String releasedDate, int runningTime) {
		_movieName = movieName;
		_director = director;
		_releasedDate = releasedDate;
		_runningTime = runningTime;
	}
	
	public String getMovieName() {
		return _movieName;
	}
	public void setMovieName(String movieName) {
		this._movieName = movieName;
	}
	public String getDirector() {
		return _director;
	}
	public void setDirector(String director) {
		this._director = director;
	}
	public String getReleasedDate() {
		return _releasedDate;
	}
	public void setReleasedDate(String releasedDate) {
		this._releasedDate = releasedDate;
	}
	public int getRunningTime() {
		return _runningTime;
	}
	public void setRunningTime(int runningTime) {
		this._runningTime = runningTime;
	}
}
