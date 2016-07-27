import java.util.*;

public class DefineStars {

	public static void main(String[] args)
	{
		String star = "*";
		int userinput = 0;
		Scanner scanner = new Scanner (System.in);
		System.out.println("Please enter the number of lines you would like to print");
		userinput = scanner.nextInt();
		scanner.close();
		userinput = userinput++;
		for (int i= 0; i < userinput; i++){
			System.out.println(star);
			star = star + "*";
			
		}
	}
}
