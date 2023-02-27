package model;

import datastr.MyArrayList;

public class mainService {

	public static void main(String[] args) {
		
			MyArrayList vards = new MyArrayList();

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


