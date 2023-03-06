package model;

import datastr.MyArrayList;
import java.io.*;

public class mainService {

	public static void main(String[] args) throws IOException {
		
			MyArrayList vards = new MyArrayList();
			
			MyArrayList test = new MyArrayList();
			
			FileReader fr = new FileReader("G:\\PROFILE\\Desktop\\test.txt");
			
			int i = 0;
			
			while ((i = fr.read()) != -1) {
				 
	            // Print all the content of a file
	            System.out.print((char)i);
			}
			
			System.out.println();
			boolean a = vards.isEmpty();
			
			System.out.println(a);
			
			vards.add('s');
			vards.add('a');
			vards.add('a');
			vards.add('b');
			try {
				vards.add('c', 2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			vards.print();
			
			vards.clear();
			
			vards.print();
		}

}


