

import java.util.Scanner;


public class BillyFracCalc {
	

	

	

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);

			boolean getInput = true;
			// greets the user
			System.out.println("Welcome to FracCalc");
			boolean a = true;
			String firstValue = "";

			while (getInput) {
				// asks the user to input
				System.out.print("Enter : ");
				String input = scan.nextLine();

				// if you type in quit it ends the program
				if (input.contains("quit")) {
					System.out.println("Thank you");
					getInput = false;
					// if you type in help you go to the help menu
				} else if (input.contains("help")) {
					help();
				} else {
					Scanner scanParser = new Scanner(input);
					firstValue = scanParser.next();
					while(scanParser.hasNext() )
					{
						
						// scans the operator and the next value
						String operator = scanParser.next();
						String secondValue = scanParser.next();
						// runs the math method
						String valueOne = converter(firstValue);
						// prints the operator
		
						// does the math method
						String valueTwo = converter(secondValue);
						String equation = valueOne + " " + operator + " " + valueTwo;
						//If you divide by 0 then it restarts the loop;
						if(equation.contains("/ 0"))
						{
							System.out.println("Cannot divide by 0");
						}
						else {
							
							firstValue = math(valueOne, valueTwo, operator);
						}
						
					}
					String answer = reducer(firstValue);
					System.out.println(input + " = " + answer);
					scanParser.close();
				}
			}
		}

		public static String reducer(String answer) {
			
			String numerator = answer.substring(0, answer.indexOf("/"));
			int num = Integer.parseInt(numerator);
			String denominator = answer.substring(answer.indexOf("/") + 1);
			int den = Integer.parseInt(denominator);
			int numer = 0;
			int denom = 0;
			for(int i = 1; i < num; i++)
			{
				if((num % i == 0) && (den % i == 0))
				{
					numer = num / i;
					denom = den / i;
				}
			}
			String reduced = numer + "/" + denom;
			return reduced;
		}

		public static String math(String firstValue, String secondValue, String operator) {
			
			String firstNumerator = firstValue.substring(0,firstValue.indexOf("/"));
			int numeratorOne = Integer.parseInt(firstNumerator);
			String firstDenominator = firstValue.substring(firstValue.indexOf("/") + 1);
			int denominatorOne = Integer.parseInt(firstDenominator);
			String secondNumerator = secondValue.substring(0, secondValue.indexOf("/"));
			int numeratorTwo = Integer.parseInt(secondNumerator);
			String secondDenominator = secondValue.substring(secondValue.indexOf("/") + 1);
			int denominatorTwo = Integer.parseInt(secondDenominator);
			int gCF = denominatorOne * denominatorTwo;
			int numerOne = numeratorOne * denominatorTwo;
			int numerTwo = numeratorTwo * denominatorOne;
			int finalNumer = 0;
			
			if(operator.contains("+"))
			{
				finalNumer = numerOne + numerTwo;
				
				
			}
			else if(operator.contains("-"))
			{
				finalNumer = numerOne - numerTwo;
				
				
				
			}
			else if(operator.contains("*"))
			{
				finalNumer = numerOne * numerTwo;
				
			}
			else if(operator.contains("/"))
			{
				finalNumer = numerOne;
				gCF = numerTwo;
				

			}
			
			
			String answer = (finalNumer + "/" + gCF);
			return answer;
		}

		
		

		// This method gives you help
		public static void help() {

			System.out.println("Welcome to the help screen.\nIf you want us to echo something, type it in.\nTo end the program, type quit.");

		}

		// converts mixed number to fraction
		public static String mixedNumberConverter(String a) {
			int underline = 0;
			// checks the string length
			int stringLength = a.length();

			// find
			for (int i = 0; i < stringLength; i++) {
				if (a.charAt(i) == ('_')) {

					underline = i;
				}
			}

			String wholeNumber = a.substring(0, underline);
			int whole = Integer.parseInt(wholeNumber);
			int slash = 0;

			for (int i = 0; i < stringLength; i++) {
				if (a.charAt(i) == ('/')) {

					slash = i;
				}
			}
			// breaks up the numerator
			String numerator = a.substring(underline + 1, slash);

			int numNumerator = Integer.parseInt(numerator);

			String denominator = a.substring(slash + 1, stringLength);
			int numDenominator = Integer.parseInt(denominator);

			if(a.contains("-"))
			{
				numNumerator = numNumerator / -1;
			}
			String mixedNumber = whole * numDenominator + numNumerator + "/" + denominator;


			return mixedNumber;
		}

		public static String converter(String firstValue) {
			String converted;
			if (firstValue.contains("_")) {
				converted = mixedNumberConverter(firstValue);
				// System.out.print(" " + operator + " ");
				// mixedNumberConverter(secondValue);
				// System.out.println();

			} else if (firstValue.contains("/")) {
				converted = firstValue;

			} else {
				int wholeNumber = Integer.parseInt(firstValue);
				converted = wholeNumber + "/1";

			}
			return converted;

		}

	}






