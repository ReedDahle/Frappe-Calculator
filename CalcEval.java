/*
 *code by Reed Dahle
 *last updated 01-31-2019 @ 21:44
 *My dad works at oracle so if you steal my code without attributing me I can have you banned kid
 */
package calcUI;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalcEval 
{
	public double Calculate(String input) throws ScriptException
	{
		ScriptEngineManager mgr = new ScriptEngineManager();		//my favorite part of java is programming things that I don't know how it works or how to implement it correctly
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");	//is this a Java "Script" engine or a JavaScript engine?
	    try
	    {
	    	return ((double)engine.eval(input));					//first we try casting our answer to a double
	    }
	    catch(ClassCastException ex)
		{
	    	return(Double.valueOf((int)engine.eval(input)));		//if that doesn't work well force it into a double
		}															//why can't we just have a single non primitive number object that can contain a decimal, negative sign, or scientific notation? My computer has like 16 gigs of ram... we don't need the wasted space
	}
	/*
	public String addExp(String currentValue)                      //yeah just pretend this junk isn't here. like don't even read it
	{
		String newValue = "";
		boolean numDone = false;
		boolean parenthDone = false;
		int endNumIndex = 0;
		int openParenthCounter = 0;
		int closedParenthCounter = 0;
		char testChar;
		if (currentValue.charAt(currentValue.length()-1) == ')')
		{
			for (int i = 1; parenthDone == false; i++)
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
		else
		{
			for (int i = 1; numDone == false; i++)
			{
				testChar = (currentValue.charAt(currentValue.length()-i));
				if ((testChar != '1')&&(testChar != '2')&&(testChar != '3')&&(testChar != '4')&&(testChar != '5')&&(testChar != '6')&&(testChar != '7')&&(testChar != '8')&&(testChar != '9')&&(testChar != '0')&&(testChar != '.'))
				{
					numDone = true;
					endNumIndex = (currentValue.length()-i+1);
				}
				if((currentValue.length()-i) == 0)
				{
					numDone = true;
					endNumIndex = (currentValue.length()-i);
				}
			}
		}
		newValue = "Math.pow(" + currentValue.substring(endNumIndex) + ",";
		currentValue = currentValue.substring(0, endNumIndex);
		newValue = currentValue + newValue;
		return newValue;
	}
	*/
}
