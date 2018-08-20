package categoryWalaPackage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class categoryData {
	   public static void main(String[] args) {
	      try {
	         String category1 = "1\tFashion\t0\n";
	         String category2 = "2\tElectronics\t0\n";
	         String category3 = "3\tMedicines\t0\n";
	         String category4 = "4\tSports\t0\n";
	         String category5 = "5\tGames\t0\n";
	         String category6 = "6\tToys\t0\n";
	         String category7 = "7\tWatches\t1\n";
	         String category8 = "8\tClothes\t1\n";
	         String category9 = "9\tShoes\t1\n";
	         String category10 = "10\tMobiles\t2\n";
	         String category11 = "11\tWashing Machines\t2\n";
	         String category12 = "12\tLG TV\t2\n";
	         String category13 = "13\tShirts\t8\n";
	         String category14 = "14\tJeans\t8\n";
	         String category15 = "15\tCricket\t4\n";
	         
	         File file = new File("C:\\Users\\User33\\Desktop\\StoreFront Data\\categoryData.txt");
	         if (!file.exists()) {
	            file.createNewFile();
	         } 
	         FileWriter fw = new FileWriter(file.getAbsoluteFile());
	         BufferedWriter bw = new BufferedWriter(fw);
	         bw.write(category1);
	         bw.newLine();
	         bw.write(category2);
	         bw.newLine();
	         bw.write(category3);
	         bw.newLine();
	         bw.write(category4);
	         bw.newLine();
	         bw.write(category5);
	         bw.newLine();
	         bw.write(category6);
	         bw.newLine();
	         bw.write(category7);
	         bw.newLine();
	         bw.write(category8);
	         bw.newLine();
	         bw.write(category9);
	         bw.newLine();
	         bw.write(category10);
	         bw.newLine();
	         bw.write(category11);
	         bw.newLine();
	         bw.write(category12);
	         bw.newLine();
	         bw.write(category13);
	         bw.newLine();
	         bw.write(category14);
	         bw.newLine();
	         bw.write(category15);
	         
	         bw.close();
	         
	         System.out.println("category Data written succesfully");
	      } catch (IOException e) {
	         e.printStackTrace();
	      } 
	   } 
	}
