package model;

import datastr.MyArrayList;
import datastr.SortingType;

import java.io.*;

public class mainService {

	public static void main(String[] args) throws IOException {
		
			MyArrayList vards = new MyArrayList();
			
			MyArrayList test = new MyArrayList();
			
			FileReader fr = new FileReader("G:\\PROFILE\\Desktop\\test.txt");
			
			try {
				
				int i = 0;
				
				char newEl = ' ';
				
				while ((i = fr.read()) != -1) {
					
					newEl = (char)i;
		            // Print all the content of a file
					if (Character.isLetter(newEl)){
						test.add((char)i);;
					}
		            
				}
				
				test.print();
				System.out.println();
				boolean a = vards.isEmpty();
				
				System.out.println(a);
				
				vards.add('s');
				vards.add('a');
				vards.add('a');
				vards.add('b');
				
				vards.add('c', 2);
				
				System.out.println(vards.getIndex(2));
				
				System.out.println(vards.getNext('a'));
				
				System.out.println(vards.sort(SortingType.ASC));
				
				vards.print();
				vards.delete(1);
				vards.print();
				
				vards.clear();
				vards.add('a');
				vards.print();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			

		}

}


