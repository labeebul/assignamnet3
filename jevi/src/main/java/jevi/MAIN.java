package jevi;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;



class Keyin {

	public static String inString() {
	    int aChar;
	    String s = "";
	    boolean finished = false;

	    while (!finished) {
	      try {
	        aChar = System.in.read();
	        if (aChar < 0 || (char) aChar == '\n')
	          finished = true;
	        else if ((char) aChar != '\r')
	          s = s + (char) aChar; // Enter into string
	      }

	      catch (java.io.IOException e) {
	        System.out.println("Input error");
	        finished = true;
	      }
	    }
	    return s;
	  }
	public static int inInt(String prompt) {
	    while (true) {
	      inputFlush();
	      printPrompt(prompt);
	      try {
	        return Integer.valueOf(inString().trim()).intValue();
	      }

	      catch (NumberFormatException e) {
	        System.out.println("Invalid input. Not an integer");
	      }
	    }
	  }
	  //*******************************
	  //   support methods
	  //*******************************
	  //Method to display the user's prompt string
	  public static void printPrompt(String prompt) {
	    System.out.print(prompt + " ");
	    System.out.flush();
	  }
	  

	  //Method to make sure no data is available in the
	  //input stream
	  public static void inputFlush() {
	    int dummy;
	    int bAvail;

	    try {
	      while ((System.in.available()) != 0)
	        dummy = System.in.read();
	    } catch (java.io.IOException e) {
	      System.out.println("Input error");
	    }
	  }
}
	  
public class MAIN extends Thread {

	private static Object[] th2;
	private static Object InpFiles;
	String fname ;
	public static BST bstmain;
	public MAIN(String n) {
		fname=n ;
	}
	public void run(){
		Scanner sc = new Scanner(System.in) ;
		fname=fname+".txt" ;
		try {
				String token = "" ;
				BST btree = new BST();
				sc = new Scanner(new File(fname));
			    while(sc.hasNext()){
			        token = sc.next();
			        btree.insert(token);
			    }
			    bstmain = btree ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("The total number of input files are " + args.length);
		for(int i=0 ; i<args.length ; i++)
		{
			System.out.println("File#" + (i+1) + " = " + args[i] + ".txt");
		}
		MAIN th1 = new MAIN(args[0]) ;
		th1.setName(args[0]);
		th1.start();
		InpFiles th2[] = new InpFiles[args.length-1];
		for(int i=1 ; i<args.length ; i++)
		{
			th2[i-1] = new InpFiles(args[i]) ;
			th2[i-1].setName(args[i]);
			th2[i-1].start();
		}
		Thread.sleep(220);
		boolean g= false;
	while(true)
	{
		 int swValue;
		 
		    // Display menu graphics
		    System.out.println("=================================");
		    System.out.println("|   Select Option   			 |");
		    System.out.println("=================================");
		    System.out.println("| Options:                       |");
		    System.out.println("|        1. Display BST          |");
		    System.out.println("|        2. Diplay Vectors       |");
		    System.out.println("|        3. Exit                 |");
		    System.out.println("=================================");
		    swValue = Keyin.inInt(" Select option: ");

		    // Switch construct
		    switch (swValue) {
		    case 1:
		      System.out.println("Option 1 selected");
		      	bstmain.displayB();
		      break;
		    case 2:
		      System.out.println("Option 2 selected");
		      for(int i=0 ; i<args.length-1 ; i++)
				{
					th2[i].display();
					System.out.println(" ");
				}
		      break;
		    case 3:
		    		g=true;
		      System.out.println("Exit selected");
		      
		      break;
		    default:
		      System.out.println("Invalid selection");
		      break; // This break is not really necessary
		    }
		    
		   if(g==true)
		   {
			   break;
		   }
	
		    
	}
		
		
		  
	}
}



