import java.util.ArrayList;
import java.util.List;

/**
 * CS2010 (Hilary Term) - Assignment 3
 * 
 * Self Divisible Numbers
 * 
 * Self divisible numbers are those, that satisfy the following property:
 * 		a) All the 9 digits in the number are different, i.e. each of the 9 digits 1..9 is used once.
 * 		b) The number denoted by the first k-digits is divisible by k (i.e. the first k-digits are a multiple of k)
 *  
 *  	Consider the number 723654981; 
 *  	We have:   1|7,  2|72, 3|723, 4|7236, 5|72365, 6|723654  [read  a|b  as â€œa divides bâ€ or â€œb is a multiple of aâ€ ] 
 *  	but 7 does not divide  7236549. So this number does not satisfy property b).
 *  
 * Create a Java program that generates all 9-digit numbers.
 * 
 * 1) Implement all methods described bellow - like in HT assignment 1, calculate the values in the constructor
 * 2) Implement tests, which sufficiently cover your code
 *  
 * @author:
 * 
 */ 

public class SelfDivisibleNumbers {
	private List<Integer> solutions = new ArrayList<Integer>();
	public SelfDivisibleNumbers() { 
		 solutions = getSelfDivisibleNumbers();
	}
	

	/**
	 * Method to produce a number corresponding to first k digits of the digits array
	 * @param digits
	 * @param k number of digits to construct the result from
	 * @return number
	 */
	int temp11 =0;
	public int getFirstKDigitNumber(int[] digits, int k) {
		temp11=0;
		for(int i=0; i <k; i++){
			temp11 *= 10;
			temp11 +=digits[i];
			
		}
		return temp11;
	}

	/**
	 * Method to check if the specified number is divisible by the divisor
	 * @param number
	 * @param divisor
	 * @return true if number is divisible by the divisor
	 */
	public boolean isDivisible(int number, int divisor) {
		if((number % divisor) ==0 ){
			return true;
		}
		return false;

	}
	/**
	 * Method to return a list containing all self divisible numbers found
	 * @return 9-digit self divisible numbers
	 */
	public List<Integer> getSelfDivisibleNumbers() {
		 List<Integer> solutions2 = new ArrayList<Integer>();
		int [] digit = {0,0,0,0,0,0,0,0,0};
		int temp =0;
		int second = 0;
		int fourth =0;
		int temporary =0;
		loop:
			for(int counter=123456789; counter <987654321; counter+=90){
					fourth = counter;
					if((((fourth/=10)%8)==0)){
						temp =counter;
						second = counter;
						if( (((fourth/=10)%7)==0) && (((fourth/=10)%6)==0) && (((fourth/=10)%5)==0) && (((fourth/=10)%4)==0) && (((fourth/=10)%3)==0) && (((fourth/=10)%2)==0)){
							int[] check = {1,2,3,4,5,6,7,8,9};
							for(int k=8;k>-1;k--){
								temporary = temp % 10;
								if((k==4 && temporary !=5) || temporary ==0 ){
									continue loop;
								}
								if(check[temporary-1]!=0){
									check[temporary-1]=0;
								}
								else{ 
									continue loop;
								}
								digit[k] =temporary;
								temp/=10;
							}
						
							solutions2.add(second);
						}
					}
				
			}
		return solutions2;
	}

	/**
	 * Method to return the number of self divisible numbers found
	 * @return number of 9-digit self divisible numbers
	 */
	public int getNumberOfSelfDivisibleNumbers() {
		int temper = solutions.size();
		System.out.println("hello");
		return temper;
	}
}