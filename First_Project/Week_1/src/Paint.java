import java.util.Scanner;


public class Paint {

	public static void main(String[] args)
	{
		int userinput = 0;
		/** the user's area to paint in metres squared **/
		int cMax, aJoe, dPaint; 
		/** the number of cans of paint required **/
		int cMaxMod, aJoeMod, dPaintMod;
		/** used with modulus function to round up the number of cans required**/
		double cMaxVal, aJoeVal, dPaintVal;
		/** cost of cans **/
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("Please enter the size of the room you would like to paint (in metres squared)");
		userinput = scanner.nextInt();
		scanner.close();
		/** asks for the user to unput the size of the area they are painting and recieves the value **/
		
		cMax = userinput / 200;
		cMaxMod = userinput % 200;
		aJoe = userinput / 225;
		aJoeMod = userinput % 125;
		dPaint = userinput / 200;
		dPaintMod = userinput % 200;
		/** calculates the number of cans required to paint the area (with rounding errors) **/
		
		if(cMaxMod > 0){
			cMax++;
		}
		if(aJoeMod > 0){
			aJoe++;
		}
		if(dPaintMod > 0){
			dPaint++;
		}
		/** rounds up can count if necessary **/
		
		cMaxVal = cMax * 19.99;
		aJoeVal = aJoe * 17.99;
		dPaintVal = dPaint * 25;
		/** calculates price **/
		
		if(cMaxVal < aJoeVal && cMaxVal < dPaintVal){
			System.out.println("Please purchase "+ cMax +" tins of CheapoMax");
		}
		if(aJoeVal < cMaxVal && aJoeVal < dPaintVal){
			System.out.println("Please purchase "+ aJoe +" tins of AverageJoes");
		}
		if(dPaintVal < cMaxVal && dPaintVal < aJoeVal){
			System.out.println("Please purchase "+ dPaint +" tins of DuluxourousPaints");
		}
		/** output telling user how much of a specific brand to purchase **/
	}
}
