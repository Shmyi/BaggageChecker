/*
 * Student Name: Yi Chen
 * Lab Professor: Amal Ibrahim
 * Due Date: July 28, 2024
 * Modified: July 16, 2024
 * Description: This program allows use to enter the information of the baggage such as dimensions which includes height,
 * width, length and the weight of to check if the baggage meet the requirement which established by the airline.
 * After checking each baggage, the program will ask user if they wish to continue,
 * the program will exist and output summary information only if user input “No”.   
 */
public class BaggageLauncher {
	public static void main (String[] args) {
		//declaration and default value
		int height = 0, width = 0, length = 0;
		double weight = 0.0;
		String ifContinue = null;
		int i = 0;
		int overSizeCount = 0;
		double overSizeWeight = 0.0;
		double sumWeight = 0.0;

		//do-while loop for user input data
		do {
			height = InputData.validateInt("Enter the height: ");
			width = InputData.validateInt("Enter the width: ");
			length = InputData.validateInt("Enter the length: ");
			weight = InputData.validateDouble("Enter the weight: ");
		//create instance baggage object	
			Baggage baggage = new Baggage(height, width, length, weight); 
		//output report 
			System.out.println(baggage.creatReport());
		//user input if continue and make string not case sensitive
			ifContinue = InputData.validateString("\nDo you wish to continue?  Enter 'No' to quit,"
				+ " anything else to continue: ");
			if (BaggageChecker.sumDimensionsExceedsMax(baggage)) {
				overSizeCount++;
				overSizeWeight += weight;
			}
			//counter of baggage
			i++;
			//sum of baggage weight
			sumWeight += weight;
		}//end do
		//stop loop if user input = no
		while (!ifContinue.equalsIgnoreCase("No")); 
		//output total num of bags and total weight
		System.out.println("The total number of valid bags entered was: "+ (i-overSizeCount));
		System.out.printf("The total weight entered was: %.1f \n",(sumWeight-overSizeWeight) );
		System.out.println("The program has terminated.\nProgram by Yi Chen");		
	}
}
