/*
 * Student Name: Yi Chen
 * Lab Professor: Amal Ibrahim
 * Due Date: July 28, 2024
 * Modified: July 16, 2024
 * Description: This class include methods for checking the baggage information 
 */
public class BaggageChecker {
	
//declare constant values	
	public static final int MAX_CARRYON_DIMENSION = 36;
	public static final int MAX_SUM_DIMENSIONS = 192;
	public static final double MAX_REGULAR_WEIGHT = 22.0 ;
	public static final double SURCHARGE_PER_KG = 3.00;
	
/*get value from call baggage method
 * returns true if the baggage object passed has a weight 
 *greater than the maximum permissible regular weight of 22.0 kg
 */
	public static boolean allowedWeightIsMoreThanMax(Baggage baggage) {
		return (baggage.getWeight() > MAX_REGULAR_WEIGHT);
	}
/* get value from call baggage method
 * use the baggage object’s weight to return a SURCHARGE_PER_KG 
 *of $3.00 for each kg above the MAX_REGULAR_WEIGHT
 * */
	public static double calculateWeightSurcharge(Baggage baggage) {
		if (allowedWeightIsMoreThanMax(baggage)) {
		return ((baggage.getWeight() - MAX_REGULAR_WEIGHT) * SURCHARGE_PER_KG);
		}
		return 0.0;
	}	
/*get value from call baggage method
 *returns true if the length, width, and height are each less than 36 cm
 */ 
	public static boolean canBeUsedAsACarryOn(Baggage baggage) {
		return (baggage.getHeight() < MAX_CARRYON_DIMENSION && 
			baggage.getWidth() < MAX_CARRYON_DIMENSION && 
			baggage.getLength() <MAX_CARRYON_DIMENSION);
	}
/*get value from call baggage method
 *returns true if the sum of the object’s dimensions is greater than this value—implying
 *the baggage will not fit in the plane’s baggage compartment
 */	
	public static boolean sumDimensionsExceedsMax(Baggage baggage) {
		return (baggage.getHeight()+baggage.getWidth()+baggage.getLength() > MAX_SUM_DIMENSIONS);
		}
	}
