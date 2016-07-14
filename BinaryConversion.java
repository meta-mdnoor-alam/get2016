package Session1;

import java.util.Scanner;

public class BinaryConversion {
	
	//Function to convert binary to decimal
	public int getBinToDec(String bin){							
		int i=0, rem, dec=0;
		int bin1=Integer.parseInt(bin);
		while (bin1!=0) {
			rem=bin1%10;
			//Check to filter invalid binary number by the user.
			if (rem!=0 && rem!=1){
				System.out.println("Please enter a valid binary number !!!");
				System.exit(-1);;
			}
			dec=(int) (dec+(rem*Math.pow(2, i++)));
			bin1/=10;
		}
		return dec;
	}
	
	//Function to convert binary to octal value
	public int convertBinaryToOctal(int n){
		int octal; //To store final octal value
		String binary=String.valueOf(n); //Converting input binary no. to a string binary value.
		String tempOct="";
		
		//Adjusting the lenth of the binary string into triplets.
		if (binary.length()%3==1){
			binary="00"+binary;
		}else if (binary.length()%3==2) {
			binary="0"+binary;
		}
		
		//Converting each binary triplet into decimal.
		for (int i = 0; i < binary.length(); i+=3) {
			tempOct=tempOct+getBinToDec(binary.substring(i, i+3));	
		}
		
		//Converting string tempOctal to integer octal.
		octal = Integer.parseInt(tempOct); 
		
		return octal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		int input;
		System.out.print("Enter a valid binary number for octal conversion  :\t");
		input=scanner.nextInt(); //Taking input from user.
		System.out.print("\nOctal value = "+new BinaryConversion().convertBinaryToOctal(input)); //Calling function.
		scanner.close();
	}

}
