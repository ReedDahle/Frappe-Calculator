/*
 *code by Reed Dahle
 *last updated 01-31-2019 @ 21:44
 *My dad works at oracle so if you steal my code without attributing me I can have you banned kid
 */
package calcUI;

public class ExponentEvaluator				//this is the single worst piece of code I've ever written so I apologize in advance
{
	/*
	public static void main(String args[])						//ya ignore this one too
	{
		System.out.println(Evaluate("(Math.pow(2,2))^2"));
	}
	*/
	public static String Evaluate (String inputValue)
	{		
		
		
		
		
		String currentValue = "";
		String secondHalfValue = "";
		String newValue = "";								     //create the variable that this bad boy is gonna return
		boolean done = false;
		for (int i = 0; !done ; i++)							//find the first instance of ^ and split the string into two halves around it
		{
			if (inputValue.charAt(i) == '^')
			{
				currentValue = inputValue.substring(0, i);      //first half ( before the ^ ). I would have named it firstHalfValue but i was reusing this code 
				secondHalfValue = inputValue.substring(i+1);	//second half
				done = true;
			}
		}
		
		
		
		
		
		
		boolean numDone = false;									//this section is where we evaluate the first half and pull out what is gonna go inside the first parameter of Math.pow(a,b)
		boolean parenthDone = false;
		int endNumIndex = 0;
		int openParenthCounter = 0;
		int closedParenthCounter = 0;
		char testChar;
		if (currentValue.charAt(currentValue.length()-1) == ')')    // if the base of the exponent is in  parentheses, we run this block of code
		{
			for (int i = 1; parenthDone == false; i++)              // we walk backwards until we see the parentheses close. then we keep the index of that statement so we can extract it later
			{
				testChar = (currentValue.charAt(currentValue.length()-i));
				if (testChar == ')')
				{
					closedParenthCounter++;
				}
				if(testChar == '(')
				{
					openParenthCounter++;
				}
				if((openParenthCounter == closedParenthCounter) && (openParenthCounter != 0) && (closedParenthCounter != 0))
				{
					parenthDone = true;
					endNumIndex = (currentValue.length()-i);
				}
			}
		}
		else               										//run if the root is not in parentheses
		{                                                       //walk backwards until we see something that's not a number and keep the index for later use
			for (int i = 1; numDone == false; i++)
			{
				testChar = (currentValue.charAt(currentValue.length()-i));
				if ((testChar != '1')&&(testChar != '2')&&(testChar != '3')&&(testChar != '4')&&(testChar != '5')&&(testChar != '6')&&(testChar != '7')&&(testChar != '8')&&(testChar != '9')&&(testChar != '0')&&(testChar != '.'))
				{																	//I apologize for this line of code ^ ^ ^
					numDone = true;
					endNumIndex = (currentValue.length()-i+1);
				}
				else if((currentValue.length()-i) == 0)
				{
					numDone = true;
					endNumIndex = (currentValue.length()-i);
				}
			}
		}
		newValue = "Math.pow(" + currentValue.substring(endNumIndex) + ","; 		//shove everything from the first half together: pull out what we don't want, then insert "Math.pow(*what we do want*," in front of it
		currentValue = currentValue.substring(0, endNumIndex);
		newValue = currentValue + newValue;
		
		
		
		
		
		
		
		
		done = false;										//this is all the same deal as the previous section, but just evaluating the second half
		openParenthCounter = 0;
		closedParenthCounter = 0;
		if (secondHalfValue.charAt(0) == '(')
		{
			for (int i = 0; !done; i++)       				//obviously we need to walk forward instead of backward
			{
				if (secondHalfValue.charAt(i) == '(')
				{
					openParenthCounter++;
				}
				if (secondHalfValue.charAt(i) == ')')
				{
					closedParenthCounter++;
				}
				if ((closedParenthCounter == openParenthCounter)&&(closedParenthCounter != 0)&&(openParenthCounter != 0))
				{
					done = true;
					newValue = newValue + secondHalfValue.substring(0,i+1) + ")" + secondHalfValue.substring(i+1);
				}
			}
		}
		else
		{
			for (int i = 0; !done; i++)
			{
				testChar = (secondHalfValue.charAt(i));
				if ((testChar != '1')&&(testChar != '2')&&(testChar != '3')&&(testChar != '4')&&(testChar != '5')&&(testChar != '6')&&(testChar != '7')&&(testChar != '8')&&(testChar != '9')&&(testChar != '0')&&(testChar != '.'))
				{													//apologies again ^ ^ ^
					done = true;
					newValue = newValue + secondHalfValue.substring(0,i) + ")" + secondHalfValue.substring(i);
				}
				else if((secondHalfValue.length()-i == 1))
				{
					done = true;
					newValue = newValue + secondHalfValue.substring(0,i+1) + ")";  				//pull out what we want, then "*stuff from before* + ) + *remaining stuff*"
				}
			}
		}
		return newValue;   //yay we did it! please remember that all we've done it evaluate the first ^. we need to run this once for each appearance
	}
}
