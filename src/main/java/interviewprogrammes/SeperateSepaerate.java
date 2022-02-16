package interviewprogrammes;

import java.util.Scanner;

public class SeperateSepaerate {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
         System.out.println("Enter the string");
         String original=sc.nextLine();
         char ch[]=original.toCharArray();
         String aplha=" ";
   	  String digi=" ";
   	  String special=" ";
         for(Character deepak:ch) {
       	
       	  if(deepak.isAlphabetic(deepak)==true) {
       		  aplha=aplha+deepak;
       		 
       	  }
       	  else if(deepak.isDigit(deepak)==true){
       		  digi=digi+deepak;
       	    
       	  }
       	  else
       		  special=special+deepak;
       		
         }
         System.out.println("String of digit is: "+digi);
         System.out.println("Alpahbrtiacal string is "+aplha);
         System.out.println("Special chracters are:"+special);
	}

}
