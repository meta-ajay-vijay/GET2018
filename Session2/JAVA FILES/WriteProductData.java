package dbmsWriteFile;

import java.io.FileWriter;

public class WriteProductData {
	public static void main(String a[]){
        try{    
            FileWriter fw=new FileWriter("D:\\DBMS_FILES\\product_data.txt");    
            
            for(int i = 1; i<=101; i++){
            int quantity = 0;
            if(i%2==0){
            	quantity = 10;
            }else{
            	quantity = 20;
            }
            	
            fw.write(i+"\t"+"A"+i+"\t"+"B"+i+"\t"+i*10+"\t"+quantity+"\t"+"hey xyz "+ i + "\r\n");
            }
            fw.close();    
           }catch(Exception e){System.out.println(e);}    
           System.out.println("Success...");    
      }  
}
