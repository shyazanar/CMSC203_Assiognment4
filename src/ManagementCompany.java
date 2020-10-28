

public class ManagementCompany {
	private String name;
	private String taxID;
	private Property[] properties;
	private double mgmFeePer;
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	
	/**
	 * No-Arg Constructor that creates a ManagementCompany object using empty strings and a default Plot. 
	 * "properties" array is initialized here as well.
	 */
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0.0;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	/**
	 * Constructor Creates a ManagementCompany object using the passed information. 
	 * Mgmt Co plot is initialized to default Plot. 
	 * "properties" array is initialized here as well.
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	/**
	 * Constructor Creates a ManagementCompany object using the passed information. 
	 * "properties" array is initialized here as well.
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(x, y, width, depth);
	}

	/**
	 * Copy Constructor creates a ManagementCompany object using another ManagementCompany object. 
	 * "properties" array is initialized here as well.
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.getName();
		this.taxID = otherCompany.getTaxID();
		this.mgmFeePer = otherCompany.getMgmFeePer();
		this.plot = new Plot(otherCompany.getPlot());
		this.properties = new Property[MAX_PROPERTY];
		for (int i=0; i<otherCompany.getProperties().length; i++) {
			if (otherCompany.getProperties()[i] != null) {
				this.properties[i] = new Property(otherCompany.getProperties()[i]);
			}
		}
	}
	
	/**
	 * Adds the property object to the "properties" array.
	 * @param property - a property object
	 * @return Returns either 
	 * -1 if the array is full, 
	 * -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, or 
	 * the index in the array where the property was added successfully.
	 */
	public int addProperty(Property property) {
		if (property == null) {
			return -2;
		}
		if (!this.plot.encompasses(property.getPlot())) {
			return -3;
		}
		for (int i=0; i<this.properties.length; i++) {
			if (this.properties[i] != null) {
				if (this.properties[i].getPlot().overlaps(property.getPlot())) {
					return -4;
				}
			} else {
				this.properties[i] = new Property(property);
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Creates a property object and adds it to the "properties" array, in a default plot.
	 * @param name - property name
	 * @param city - location of the property
	 * @param rent - monthly rent
	 * @param owner - owner of the property
	 * @return Returns either 
	 * -1 if the array is full, 
	 * -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, or 
	 * the index in the array where the property was added successfully.
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		Property property = new Property(name, city, rent, owner);
		if (!this.plot.encompasses(property.getPlot())) {
			return -3;
		}
		for (int i=0; i<this.properties.length; i++) {
			if (this.properties[i] != null) {
				if (this.properties[i].getPlot().overlaps(property.getPlot())) {
					return -4;
				}
			} else {
				this.properties[i] = property;
				return i;
			}
		}
		return -1;
	}

	/**
	 * Creates a property object and adds it to the "properties" array.
	 * @param
	 * name - property name
	 * city - location of the property
	 * rent - monthly rent
	 * owner - owner of the property
	 * x - x location of upper left corner of property's plot
	 * y - y location of upper left corner of property's plot
	 * width - width of the property's plot
	 * depth - depth of the property's plot
	 * @return Returns either 
	 * -1 if the array is full, 
	 * -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, or 
	 * the index in the array where the property was added successfully.
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		if (!this.plot.encompasses(property.getPlot())) {
			return -3;
		}
		for (int i=0; i<this.properties.length; i++) {
			if (this.properties[i] != null) {
				if (this.properties[i].getPlot().overlaps(property.getPlot())) {
					return -4;
				}
			} else {
				this.properties[i] = property;
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * This method accesses each "Property" object within the array "properties" and sums up the property rent and returns the total amount.
	 * @return total rent
	 */
	public double totalRent() {
		double result = 0.0;
		for (int i=0; i<this.properties.length; i++) {
			if (this.properties[i] != null) {
				result += this.properties[i].getRentAmount();
			}
		} 
		return result;
	}
	
	/**
	 * This method finds the property with the maximum rent amount and returns its toString result. 
	 * NOTE: For simplicity assume that each "Property" object's rent amount is different.
	 * @return double, the maximum rent amount
	 */
	public String maxRentProp() {
		return displayPropertyAtIndex(maxRentPropertyIndex());
	}
	
	/**
	 * This method finds the index of the property with the maximum rent amount. 
	 * NOTE: For simplicity assume that each "Property" object's rent amount is different.
	 * @return int , the index of the property with the maximum rent amount
	 */
	private int maxRentPropertyIndex() {
		double maxrent = 0.0;
		int maxindex = 0;
		for (int i=0; i<this.properties.length; i++) {
			if (this.properties[i] != null) {
				if (this.properties[i].getRentAmount() > maxrent) {
					maxrent = this.properties[i].getRentAmount();
					maxindex = i;
				}
			}
		}
		return maxindex;
	}

	/**
	 * Displays the information of the property at index i
	 * @param i - The index of the property within the array "properties"
	 * @return information of the property at index i
	 */
	private String displayPropertyAtIndex(int i) {
		return this.getProperties()[i].toString();
	}
	
	public String getName() {
		return name;
	}

	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	@Override
	public String toString() {
		String result = "";
		result += "List of the properties for " + name + ", taxID: " + taxID + "\n";
		result += "_____________________________________________________________\n";
		for (int i=0; i<this.properties.length; i++) {
			if (this.properties[i] != null) {
				result += displayPropertyAtIndex(i) + "\n";
			}
		}
		result += "_____________________________________________________________\n";
		result += "total management Fee: " + this.mgmFeePer * totalRent() / 100.0;
		return result;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public Property[] getProperties() {
		return properties;
	}

	public void setProperties(Property[] properties) {
		this.properties = properties;
	}

	public double getMgmFeePer() {
		return mgmFeePer;
	}

	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}


}
