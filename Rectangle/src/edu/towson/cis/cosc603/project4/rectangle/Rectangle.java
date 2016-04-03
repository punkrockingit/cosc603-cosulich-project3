package edu.towson.cis.cosc603.project4.rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class Rectangle.
 */
public class Rectangle {
	
	/** The p2. */
	private Point p1, p2;
	
	/**
	 * Instantiates a new rectangle.
	 *
	 * @param p1 the p1
	 * @param p2 the p2
	 */
	Rectangle(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/**
	* This calculates the area of a rectangle and returns it as a double.
	   * @return area of rectangle
	   */
	   public Double getArea() {
		    // To hold the absolute width value.
			double width;
			// To hold the absolute height value. 
			double height;
			// To hold the area value.
			double area;
			
			width = Math.abs(p2.x - p1.x);
			height = Math.abs(p2.y - p1.y);
			area = width * height;
			return area;
	   }
	   
	   /**
	   * This calculates the diagonal of a rectangle and returns it as a double.
	   * @return diagonal of rectangle
	   */
	   public Double getDiagonal() {
			// To hold the squared width value of the rectangle.
			double widthSquared;
			// To hold the squared height value of the rectangle. 
			double heightSquared;
			
			widthSquared = Math.pow((p2.x - p1.x), 2);
			heightSquared = Math.pow((p2.y - p1.y), 2);
			
			// To hold the diagonal value of the rectangle.
			double diagonal;
			diagonal = Math.sqrt(widthSquared + heightSquared);
			
			return diagonal;
	   }

}
