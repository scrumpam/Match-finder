package my.finder.dmcs;

public class Match {
	
	private int id;
	private String rep1;
	private String rep2;
	private String date;
	private String score;
	private String stadium;

	
	public Match(int id, String rep1, String rep2, String date, String score,
			String stadium) {
		super();
		this.id = id;
		this.rep1 = rep1;
		this.rep2 = rep2;
		this.date = date;
		this.score = score;
		this.stadium = stadium;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the rep1
	 */
	public String getRep1() {
		return rep1;
	}
	/**
	 * @param rep1 the rep1 to set
	 */
	public void setRep1(String rep1) {
		this.rep1 = rep1;
	}
	/**
	 * @return the rep2
	 */
	public String getRep2() {
		return rep2;
	}
	/**
	 * @param rep2 the rep2 to set
	 */
	public void setRep2(String rep2) {
		this.rep2 = rep2;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the score
	 */
	public String getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		this.score = score;
	}
	/**
	 * @return the stadium
	 */
	public String getStadium() {
		return stadium;
	}
	/**
	 * @param stadium the stadium to set
	 */
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	
}
