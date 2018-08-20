package roleANDUserWalaPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RoleUser {
	
	public static void main(String args[])
	{
		 try {
		        
	 File file = new File("C:\\Users\\User33\\Desktop\\StoreFront Data\\role_user.txt");
     if (!file.exists()) {
        file.createNewFile();
     } 
     FileWriter fw = new FileWriter(file.getAbsoluteFile());
     BufferedWriter bw = new BufferedWriter(fw);
     int j=1;
     bw.write((j)+"\t"+(j++)+"\t"+(1));
     bw.newLine();
     bw.write((j)+"\t"+(j++)+"\t"+(2));
     bw.newLine();
     bw.write((j)+"\t"+(j++)+"\t"+(2));
     bw.newLine();
     bw.write((j)+"\t"+(j++)+"\t"+(2));
     bw.newLine();
     bw.write((j)+"\t"+(j++)+"\t"+(2));
     bw.newLine();
     bw.write((j)+"\t"+(j++)+"\t"+(2));
     bw.newLine();
     bw.write((j)+"\t"+(j++)+"\t"+(2));
     bw.newLine();
     bw.write((j)+"\t"+(j++)+"\t"+(2));
     bw.newLine();
     bw.write((j)+"\t"+(j++)+"\t"+(2));
     bw.newLine();
     bw.write((j)+"\t"+(j++)+"\t"+(2));
     bw.newLine();
     bw.write((j)+"\t"+(j++)+"\t"+(2));
     bw.newLine();
     bw.write((j)+"\t"+(j++)+"\t"+(2));
     bw.newLine();
     
     bw.close();
     System.out.println("Role User Data written succesfully");
	}
 catch (IOException e) {
     e.printStackTrace();
  } 
}
}
