
public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	/**
	 * No-arg Constructor, creates a Plot with x=0, y=0, width=1, depth=1
	 */
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}

	/**
	 * Copy Constructor, creates a new Plot using the information of the Plot passed to it.
	 * @param p - a Plot object
	 */
	public Plot(Plot p) {
		this.x = p.getX();
		this.y = p.getY();
		this.width = p.getWidth();
		this.depth = p.getDepth();
	}
	
	/**
	 * Parameterized constructor
	 * @param x - horizontal coordinate of upper left corner
	 * @param y - vertical coordinate of upper left corner
	 * @param width - horizontal size
	 * @param depth - vertical size
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * Determines if this plot overlaps the parameter
	 * @param p - another plot
	 * @return Returns true if this plot overlaps the parameter, false otherwise
	 */
	public boolean overlaps(Plot p) {
		if (p.getX() >= this.x+this.width || p.getX()+p.getWidth() <= this.x || p.getY() >= this.y+this.depth || p.getY()+p.getDepth() <= this.y) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Determines if this plot encompasses the parameter
	 * @param p - another plot
	 * @return Returns true if this plot encompasses the parameter, false otherwise
	 */
	public boolean encompasses(Plot p) {
		if (p.getX() >= this.x && p.getY() >= this.y && p.getX()+p.getWidth() <= this.x+this.width && p.getY()+p.getDepth() <= this.y+this.depth) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 */
	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}

	/**
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

}
