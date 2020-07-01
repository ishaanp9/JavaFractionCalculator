// Ishaan Puri
// AP Computer Science
// Period 2
// Fraction Calc

import java.math.BigInteger;
import java.util.Scanner;

public class FracCalc
{

    public static String expression1;
    public static String operator;
    public static String expression2;
    public static BigInteger firstToken; // without ending of number is  expression1 
    public static BigInteger firstToken2;// with ending of number 2 is expression2
    public static BigInteger secondToken;
    public static BigInteger secondToken2;
    public static BigInteger thirdToken;
    public static BigInteger thirdToken2;
    public static BigInteger numerator;
    public static BigInteger denomenator; 
  

    public static void main (String []args) 
    {
        System.out.println ("Welcome to my Fraction Calculator");
        inputUser();
        converttoFractions(expression1,operator,expression2);

    }

        
        
    public static void inputUser() 
    {
        Scanner scan = new Scanner(System.in);
        System.out.print ("Enter: ");
        String expression1 = scan.next();

        while (!expression1.equals("quit"))
        // While the program is not quit, it will run.
        {

            if (expression1.equals("help")) 
            {
                System.out.println ();
                System.out.println ("You have asked for help, here are some intructions for operating the calculator");
                System.out.println("Addition: '+' (Ex: 'a + b') or  4 + 5 = 9");
                System.out.println("Subtraction: '-' (Ex: 'a - b' ) or 10 - 6 = 4");
                System.out.println("Multiplication: '*' (Ex: 'a * b' ) or 10 * 5 = 50");
                System.out.println("Division: '/' (Ex: 'a / b' ) 10 / 5 = 2");
                System.out.println("Exponents: '^' (Ex: 'a ^ b' ) or 2 ^ 2 = 4");
                System.out.println("Improper Fractions: 10/3, 6/5");
                System.out.println("Mixed Numbers: 3_1/3,1_ 1/5");
                System.out.println("Exponents: 3 ^ 2 = 9");
                System.out.println("Mod: 5 % 3 = 1 rem 2");
                System.out.println ("Type in quit if you want to exit calculator");
                // Intructions for user, if help is selected

            } 
            else 
            {
                operator = scan.next();
                expression2 = scan.next();
                converttoFractions(expression1, operator, expression2);       
               
                // echos input given
            }
            System.out.print("Enter: ");
            expression1 = scan.next();
        }

        System.exit(0);  // exits the while

    }

    public static void converttoFractions(String expression1, String operator, String expression2){
        //get string variables from fractions

        //testing fraction 1 to get int values
        if(expression1.contains("_")){ //testing for mixed number
            firstToken = new BigInteger(expression1.substring(0,expression1.indexOf("_")));
            // finds the first token in front of the _
            secondToken = new BigInteger(expression1.substring(expression1.indexOf("_")+1,expression1.indexOf("/")));
            // this is the numerator of the first expression.
            thirdToken = new BigInteger(expression1.substring(expression1.indexOf("/")+1));
            // denomenator
            if (firstToken.compareTo(BigInteger.ZERO) == -1)
            // this if statement helps convert negative mixed number to improper
            {
                secondToken = (firstToken.multiply(thirdToken)).subtract(secondToken);       
            }
            else
            {
                secondToken = (firstToken.multiply(thirdToken)).add(secondToken); 
            }    
            System.out.print(secondToken+"/" + thirdToken + " " + operator + " ");     
        } else if(expression1.contains("/")) { //testing for fraction
            secondToken = new BigInteger(expression1.substring(0,expression1.indexOf("/")));
            thirdToken = new BigInteger(expression1.substring(expression1.indexOf("/")+1));
            System.out.print(secondToken+"/" + thirdToken + " " + operator + " " );
            // This code is a little exsessive but it helps set me up later during the math methods
        } else {//testing for whole number
            firstToken=new BigInteger(expression1.substring(0));   
            secondToken = firstToken;     
            thirdToken = BigInteger.ONE;

            System.out.print(secondToken + "/" + thirdToken + " " + operator + " " );
            // setting tokens helps later in math methods.
        }

        //testing fraction 2 to get int values 
        if(expression2.contains("_")){ //mixed fraction
            firstToken2 = new BigInteger(expression2.substring(0,expression2.indexOf("_")));
            // finds the first token in front of the _
            secondToken2 = new BigInteger(expression2.substring(expression2.indexOf("_")+1,expression2.indexOf("/")));
            // this is the numerator of the second expression.
            thirdToken2 = new BigInteger(expression2.substring(expression2.indexOf("/")+1));
            // denomenator
            if (firstToken2.compareTo(BigInteger.ZERO) == -1)
            // tests for negative number
            {
                secondToken2 = (firstToken2.multiply(thirdToken2)).subtract(secondToken2);       
            }
            else
            {
                secondToken2 = (firstToken2.multiply(thirdToken2)).add(secondToken2); 
            }    
            System.out.println(secondToken2 + "/" + thirdToken2);
        } else if(expression2.contains("/")) { // fraction
            secondToken2=new BigInteger(expression2.substring(0,expression2.indexOf("/")));
            thirdToken2=new BigInteger(expression2.substring(expression2.indexOf("/")+1));
            System.out.println(secondToken2+"/" + thirdToken2 + " =");
        } else { //whole number 
            firstToken2 = new BigInteger(expression2.substring(0));
            secondToken2 = firstToken2;
            thirdToken2 = BigInteger.ONE;
            System.out.println(secondToken2 + "/" + thirdToken2 + " =");
        }
       
        

        mathProcessor(secondToken,thirdToken,secondToken2,thirdToken2,operator);

    }

    public static void mathProcessor(BigInteger firstToken,BigInteger firstToken2,BigInteger secondToken,BigInteger secondToken2, String operator) // setting parameters which are my tokens
    {
        if (operator.equals("+"))
        {
            System.out.println(add(firstToken,firstToken2,secondToken,secondToken2));
            System.out.println();
            // detects addition
        }
        else if (operator.equals("-"))
        {
           System.out.println(subtract(firstToken,firstToken2,secondToken,secondToken2));
           System.out.println();
           // detects subtraction
        }
        else if (operator.equals("*"))
        {
          System.out.println(multiplication(firstToken,firstToken2,secondToken,secondToken2));
          System.out.println();
          // detects multiplication
        }
        else if (operator.equals("/"))
        {
          System.out.println(division(firstToken,firstToken2,secondToken,secondToken2));
          System.out.println();
          // detects division
        }
        else if (operator.equals("^"))
        {
          System.out.println(exponents(firstToken,firstToken2,secondToken,secondToken2));
          System.out.println();
          // detects exponents 
        }
        else if (operator.equals("%"))
        {
          System.out.println(modulus(firstToken,firstToken2,secondToken,secondToken2));
          System.out.println();
          // detects modulus
        }
        else 
        {
            System.out.println("Error, please enter valid input");
            System.out.println();
            // if none of these are giving, the computer will say that it is invalid
        }
    }    

    public static String add(BigInteger firstToken, BigInteger firstToken2,BigInteger secondToken,BigInteger secondToken2)
    {
        BigInteger denomenator = lcm(firstToken2 , secondToken2);
        BigInteger numerator = (denomenator.multiply(firstToken)).divide(firstToken2);
        BigInteger numerator2 = (denomenator.multiply(secondToken)).divide(secondToken2);
        // formula for addtion, which includes cross multiplication as a means of simplifying and adding
        String reduced = reduce(numerator.add(numerator2),denomenator);
        return reduced;
    }


    public static BigInteger gcd( BigInteger a , BigInteger b)// gcd method with parameters a and b which are only used to help find the remainder
    {
        if (b.compareTo(BigInteger.ZERO) ==0)
        {
            return a; // checks if b is 0, if it is returns a, cannot mod by 0
        }

        BigInteger remainder = a.mod(b);  // else gives a remainder
        return gcd(b,remainder); // added abs because i wanted to make sure the gcd coundnt be negative
        // recursion, calling method within itself
    }

    public static BigInteger lcm(BigInteger c, BigInteger d)
    {
    	return (c.multiply(d)).divide(gcd(c,d));
        // in order to find the simplified fractions we need to find greatest common denomentator, whihc is helped by lcm
    }
    
    public static String subtract(BigInteger firstToken, BigInteger firstToken2, BigInteger secondToken, BigInteger secondToken2)
    {
        BigInteger denomenator = lcm(firstToken2 , secondToken2);
        BigInteger numerator = (denomenator.multiply(firstToken)).divide(firstToken2);
        BigInteger numerator2 = (denomenator.multiply(secondToken)).divide(secondToken2);
        String reduced = reduce(numerator.subtract(numerator2),denomenator).toString();
        return reduced;
        // subtraction is used by finding lcm, similar to addition and subtracting instead of adding
    }
    
    public static String multiplication(BigInteger firstToken, BigInteger firstToken2, BigInteger secondToken, BigInteger secondToken2)
    {
    	
    	BigInteger numerator = firstToken.multiply(secondToken);
        BigInteger denomenator = firstToken2.multiply(secondToken2);
        // return numerator + "/" + denomenator;
        String reduced = reduce(numerator,denomenator).toString();
        return reduced;
        // reduced fraction is returned, and multiplication method simply multiplies numerators and denomenators
    }
    
    public static String division(BigInteger firstToken, BigInteger firstToken2, BigInteger secondToken, BigInteger secondToken2)
    {
       
    	BigInteger numerator = firstToken.multiply(secondToken2);
        BigInteger denomenator = firstToken.multiply(secondToken);
        
        if (denomenator.compareTo(BigInteger.ZERO) == 0 || numerator.compareTo(BigInteger.ZERO) == 0)
        {
     	   return "Cannot divide by zero";
     	   
     	   // if numerator or denomenator is zero, it will display this message
        }
        String reduced = reduce(numerator,denomenator).toString(); 
     	   return reduced;
             
    }
    
    public static String exponents(BigInteger firstToken, BigInteger firstToken2, BigInteger secondToken, BigInteger secondToken2)
    {

    	BigInteger multiplytimes = secondToken.divide(secondToken2);
        
        BigInteger numerator = (firstToken.pow(multiplytimes.intValue()));
        BigInteger denomenator = (firstToken2.pow(multiplytimes.intValue()));
        
        return numerator + "/" + denomenator;
        
       
    }
    
    public static String modulus(BigInteger firstToken, BigInteger firstToken2, BigInteger secondToken, BigInteger secondToken2)
    {
    	BBigInteger mod = (firstToken.mod(secondToken));
    	BigInteger notRemainder = (firstToken.divide(secondToken));
    	return notRemainder + " your remainder is " + mod;
    }
    
    public static String reduce(BigInteger num , BigInteger den)
    {
    	BigInteger gcf = gcd(num , den);
    	BigInteger num1 = num .divide(gcf);
    	BigInteger den1 = den .divide(gcf);
    	return num1 + "/" + den1;
    }
   
    
}