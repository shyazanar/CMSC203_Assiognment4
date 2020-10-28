
public class Property {
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**
	 * No-arg Constructor, creates a new object with default values of empty strings, 0 for rent amount, and default Plot
	 */
	public Property() {
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0.0;
		this.plot = new Plot();
	}
	
	/**
	 *
	 */
	public String toString() {
		String result = "";
		result += "Property Name: " + propertyName + "\n";
		result += "\tLocated in " + city + "\n";
		result += "\tBelonging to: " + owner + "\n";
		result += "\tRent Amount: " + rentAmount + "\n";
		
		return result;
	}

	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param p - a Property object
	 */
	public Property(Property p) {
		this.city = p.getCity();
		this.owner = p.getOwner();
		this.propertyName = p.getPropertyName();
		this.rentAmount = p.getRentAmount();
		this.plot = new Plot(p.getPlot());
	}
	
	/**
	 * Constructor, Parameterized constructor with no Plot information (uses default Plot where x,y are set to 0, width and depth set to 1)
	 * @param propertyName - property name
	 * @param city - city where the property is located
	 * @param rentAmount - rent amount
	 * @param owner - the owner's name
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.plot = new Plot();
	}
	
	/**
	 * Constructor, Parameterized constructor
	 * @param propertyName - property name
	 * @param city - city where the property is located
	 * @param rentAmount - rent amount
	 * @param owner - the owner's name
	 * @param x - the x-value of the property's plot
	 * @param y - the y-value of the property's plot
	 * @param width - the horizontal size of the property's plot
	 * @param depth - the vertical size of the property's plot
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.plot = new Plot(x, y, width, depth);
	}

	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * @param propertyName
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * @return
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * @param rentAmount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	/**
	 * @return
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * @param plot
	 */
	public void setPlot(Plot plot) {
		this.plot = plot;
	}

}
