package dmcs.matchfinder.model;

public class StadiumLocation {
	
	
	private String lat;
	public StadiumLocation(String lat, String lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	private String lon;

}
