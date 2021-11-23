package jevi;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class InpFiles extends Thread {
	String fn ;
	Vector<String> v1 = new Vector<String>(1);
	public InpFiles(String n) {
		fn=n+".txt" ;
	}
	public void run(){
		Scanner sc = new Scanner(System.in) ;
		try {
				String token = "" ;
				sc = new Scanner(new File(fn));
			    while(sc.hasNext()){
			        token = sc.next();
			        v1.add(token);
			    }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		display();
	    //System.out.println(v1);
	}
	public void display()
	{
		for (int i = 0; i < v1.size(); i++)
            System.out.print(v1.get(i) + " ");
	
	}
}
