package userWalaPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class User {
	 public static void main(String[] args) {
	      try {
	         String user1 =  "\tsankalp.7vyas@gmail.com\tSankalp\tVyas\t1995-11-07\trajusrivastav\n";
	         String user2 =  "\tvijay.dinanath.chouhan@gmail.com\tVijay\tChouhan\t1995-11-07\trajusrivastav\n";
	         String user3 =  "\tsunny.deol@gmail.com\tSunny\tDeol\t1995-11-07\trajusrivastav\n";
	         String user4 =  "\tvirat.kohli@gmail.com\tVirat\tKohli\t1995-11-07\trajusrivastav\n";
	         String user5 =  "\trajesh.yadav@gmail.com\tRajesh\tYadav\t1995-11-07\trajusrivastav\n";
	         String user6 =  "\tkrishin.gupta@gmail.com\tKrishin\tGupta\t1995-11-07\trajusrivastav\n";
	         String user7 =  "\tsrishti.acharya@gmail.com\tSrishti\tAcharya\t1995-11-07\trajusrivastav\n";
	         String user8 =  "\tsunil.shetty@gmail.com\tSunil\tShetty\t1995-11-07\trajusrivastav\n";
	         String user9 =  "\tsukanya.sharma@gmail.com\tSukanya\tSharma\t1995-11-07\trajusrivastav\n";
	         String user10 = "\tsarvesh.saransh@gmail.com\tSarvesh\tSaransh\t1995-11-07\trajusrivastav\n";
	         String user11 = "\tvijay.Malya@gmail.com\tVijay\tMalya\t1995-11-07\trajusrivastav\n";
	         String user12 = "\tadinath.vyas@gmail.com\tAdinath\tVyas\t1995-11-07\trajusrivastav\n";
	         String user13 = "\tganja.cocaine@gmail.com\tUtkarsh\tMundra\t1995-11-07\trajusrivastav\n";
	         String user14 = "\trockstar.srk@gmail.com\tAjay\tVijay\t1995-11-07\trajusrivastav\n";
	         String user15 = "\tamitabh.bacchan@gmail.com\tAmitabh\tBacchan\t1995-11-07\trajusrivastav\n";
	         
	         File file = new File("C:\\Users\\User33\\Desktop\\StoreFront Data\\userData.txt");
	         if (!file.exists()) {
	            file.createNewFile();
	         } 
	         FileWriter fw = new FileWriter(file.getAbsoluteFile());
	         BufferedWriter bw = new BufferedWriter(fw);
	         int j=1;
	         bw.write((j++)+user1);
	         bw.newLine();
	         bw.write((j++)+user2);
	         bw.newLine();
	         bw.write((j++)+user3);
	         bw.newLine();
	         bw.write((j++)+user4);
	         bw.newLine();
	         bw.write((j++)+user5);
	         bw.newLine();
	         bw.write((j++)+user6);
	         bw.newLine();
	         bw.write((j++)+user7);
	         bw.newLine();
	         bw.write((j++)+user8);
	         bw.newLine();
	         bw.write((j++)+user9);
	         bw.newLine();
	         bw.write((j++)+user10);
	         bw.newLine();
	         bw.write((j++)+user11);
	         bw.newLine();
	         bw.write((j++)+user12);
	         bw.newLine();
	         bw.write((j++)+user13);
	         bw.newLine();
	         bw.write((j++)+user14);
	         bw.newLine();
	         bw.write((j++)+user15);
	         bw.newLine();
	         bw.close();
	         
	         System.out.println("user Data written succesfully");
	      } catch (IOException e) {
	         e.printStackTrace();
	      } 
	   } 

}
