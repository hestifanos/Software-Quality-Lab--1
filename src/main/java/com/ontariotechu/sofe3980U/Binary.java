package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				number="0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any
		// uncomment the following code

		if(this.number=="") { // replace empty strings with a single zero
			this.number="0";
		}

    }
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}



	public Binary or(Binary operand) {
		// Find the maximum length of the two binary numbers
		int maxLength = Math.max(this.number.length(), operand.number.length());


		String binaryOr1 = padWithLeadingZeros(this.number, maxLength);
		String binaryOr2 = padWithLeadingZeros(operand.number, maxLength);

		StringBuilder result = new StringBuilder();

		// Perform bitwise OR operation
		for (int i = 0; i < maxLength; i++) {
			char char1 = binaryOr1.charAt(i);
			char char2 = binaryOr2.charAt(i);

			//Appending the variable result with 0 or 1 according to the condition.
			result.append((char1 == '1' || char2 == '1') ? '1' : '0');
		}

		return new Binary(result.toString());
	}


	// A private method that pad with leading zeros.
	private String padWithLeadingZeros(String binary, int length) {
		StringBuilder paddedBinary = new StringBuilder(binary);

		while (paddedBinary.length() < length) {
			paddedBinary.insert(0, '0');
		}

		return paddedBinary.toString();
	}




	public Binary and(Binary operand) {


		//getting the max length of the two binary numbers.
		int maxLength = Math.max(this.number.length(), operand.number.length());


		// Putting 0s to the left of the string in order to the strings have the same length,
		// if one of them is less in length.
		String binaryAnd1 = padWithLeadingZeros(this.number, maxLength);
		String binaryAnd2 = padWithLeadingZeros(operand.number, maxLength);

		StringBuilder result = new StringBuilder();


		//Assigning current values of the bit strings to char1 and char2.
		for (int i = 0; i < maxLength; i++) {
			char char1 = binaryAnd1.charAt(i);
			char char2 = binaryAnd2.charAt(i);

			//Appending the variable result with 0 or 1 according to the condition.
			result.append((char1 == '1' && char2 == '1') ? '1' : '0');
		}

		return new Binary(result.toString());
	}


	// Defining a multiplication method that multiplies the 2 numbers.
	public Binary multiply(Binary operand) {
		// Convert binary strings to integer values for multiplication
		int num1 = Integer.parseInt(this.number, 2);
		int num2 = Integer.parseInt(operand.number, 2);

		// Calculate the product
		int product = num1 * num2;

		// Convert the product back to binary string
		String resultBinary = Integer.toBinaryString(product);

		return new Binary(resultBinary);
	}





}	
