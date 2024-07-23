/*
 * Student Name: Yi Chen
 * Lab Professor: Amal Ibrahim
 * Due Date: July 28, 2024
 * Modified: July 16, 2024
 * Description: This class is for create a baggage object and the report for output
 */
public class Baggage {
	//declarations
	private int height;
	private int width;
	private int length;
	private double weight;
	//declaration of constant values
	public static final int DEFAULT_HEIGHT = 65;
	public static final int DEFAULT_WIDTH = 25;
	public static final int DEFAULT_LENGTH = 10;
	public static final double DEFAULT_WEIGHT = 10.0;
	
	//no args constructor chained to the default value
	public Baggage() {
		this(DEFAULT_HEIGHT, DEFAULT_WIDTH, DEFAULT_LENGTH, DEFAULT_WEIGHT);
	}
	// 4 args constructor
	public Baggage(int height, int width, int length, double weight) {
		this.height = height;
		this.width = width;
		this.length = length;
		this.weight = weight;
	//getters and setters
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	// toString method
	public String creatReport() {
		//default
		String report = "";
		//return report if the baggage is oversize
		if (BaggageChecker.sumDimensionsExceedsMax(this)) {
			report = "This bag is oversize; it is not acceptable";
			//returns report if the baggage can be as carry on
		}
		else {
			report = String.format("This bag has length %d cm, width %d cm, height %d cm, and weight %.1f kg",
					length, height, width, weight );
			if (BaggageChecker.canBeUsedAsACarryOn(this)) {
				report = report + "\nThis bag can be used as a carry on.";
			}
			    //returns report if the baggage passed has a weight greater than the maximum 
				//permissible regular weight of 22.0 kg
				//if not pass return surcharge
			if (BaggageChecker.allowedWeightIsMoreThanMax(this)) {
					double surcharge = BaggageChecker.calculateWeightSurcharge(this);
					report = report + String.format("\nThis bag is overweight; it exceeds the allowed weight of 22.0 kg. "
							+ "A surcharge of $%.2f applies.",surcharge);
				}
			}
//				report = report + "\nThis bag can not be used as a carry on.";
		return report;
	}
}
