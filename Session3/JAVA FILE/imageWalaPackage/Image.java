package imageWalaPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Image {
	public static void main(String args[])
	{
	String image_url =  "\thttp://imagedrivegoogle/";
    String image_name =  "\tImage";
    
    
    try {
        
        File file = new File("C:\\Users\\User33\\Desktop\\StoreFront Data\\image_data.txt");
        if (!file.exists()) {
           file.createNewFile();
        } 
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        int j=1;
        for(int k=1;k<500 && j<101;j++)
        {
        	if(j%6 == 0)
        	{
        		continue;
        	}
        	bw.write(k+image_url+k+image_name+k+"\t"+j);
        	bw.newLine();
        	k++;
        	if(j%5 == 0)
        	{
        		bw.write(k+image_url+k+image_name+k+"\t"+j);
            	bw.newLine();
        		k++;
        	}
        	if(j%7 ==0)
        	{
        		bw.write(k+image_url+k+image_name+k+"\t"+j);
            	bw.newLine();
        		k++;
        		bw.write(k+image_url+k+image_name+k+"\t"+j);
            	bw.newLine();
        		k++;
        	}
        }
        bw.close();
        System.out.println("Image Data written succesfully");
	}
    catch (IOException e) {
        e.printStackTrace();
     } 
}
}
