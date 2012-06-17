package dmcs.matchfinder.model;

public class Stadium {
	
	
	private int id;
	private String name;
	private String address;
	
	
	public Stadium(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	

}
