package org.supportclasses;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class DateDynamic {
	public static String  email() {
		
		Random r= new Random();
		System.out.println(r);
			int nextInt = r.nextInt(1000);
			System.out.println(nextInt);
			String email="test"+nextInt+"@gmail.com";
			System.out.println(email);
		return email;
		

	}
	
	public static String name() {
//		String name = "a-s-d-f-g";
//		 System.out.println(name);
//		 String trim = name.replace("-", "");
//		 System.out.println(trim);
		 String name = UUID.randomUUID().toString();
		 System.out.println(name);
		  String rname = name.replace("-", "");
		 System.out.println(rname);
		return rname;
		

	}
	
	public static void main(String[] args) {
	
		DateDynamic.email();
		DateDynamic.name();
	}

}
