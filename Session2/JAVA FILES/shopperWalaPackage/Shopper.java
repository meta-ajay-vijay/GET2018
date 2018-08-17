package shopperWalaPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Shopper {
		 public static void main(String[] args) {
		      try {
		         
		         File file = new File("C:\\Users\\User33\\Desktop\\StoreFront Data\\shopperData.txt");
		         if (!file.exists()) {
		            file.createNewFile();
		         } 
		         FileWriter fw = new FileWriter(file.getAbsoluteFile());
		         BufferedWriter bw = new BufferedWriter(fw);
		         int j=1;
		         bw.write((j++)+"\t"+(j+1));
		         bw.newLine();
		         bw.write((j++)+"\t"+(j+1));
		         bw.newLine();
		         bw.write((j++)+"\t"+(j+1));
		         bw.newLine();
		         bw.write((j++)+"\t"+(j+1));
		         bw.newLine();
		         bw.write((j++)+"\t"+(j+1));
		         bw.newLine();
		         bw.write((j++)+"\t"+(j+1));
		         bw.newLine();
		         bw.write((j++)+"\t"+(j+1));
		         bw.newLine();
		         bw.write((j++)+"\t"+(j+1));
		         bw.newLine();
		         bw.write((j++)+"\t"+(j+1));
		         bw.newLine();
		         bw.write((j++)+"\t"+(j+1));
		         bw.newLine();
		         bw.write((j++)+"\t"+(j+1));
		         bw.newLine();
		         bw.write((j++)+"\t"+(j+1));
		         bw.newLine();
		         
		         bw.close();
		         System.out.println("shopper Data written succesfully");
		      } catch (IOException e) {
		         e.printStackTrace();
		      } 
		   } 

	}
