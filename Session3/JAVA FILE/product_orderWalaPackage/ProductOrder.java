package product_orderWalaPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProductOrder {
	
	public static void main(String args[])
	{
	String order_product1 =  "\t2018-12-11\t\\N\t0\t'Order Placed'\n";
    String order_product2 =  "\t2018-4-11\t2018-4-21\t1\t'Delivered'\n";
    String order_product3 =  "\t2018-3-11\t2018-3-21\t1\t'Delivered'\n";
    String order_product4 =  "\t2018-12-11\t\\N\t0\t'Order Placed'\n";
    String order_product5 =  "\t2018-7-11\t\\N\t0\t'Shipped'\n";
    String order_product6 =  "\t2018-6-11\t2018-6-12\t1\t'Delivered'\n";
    String order_product7 =  "\t2018-5-11\t2018-5-11\t1\t'Delivered'\n";
    
    try {
        
        File file = new File("C:\\Users\\User33\\Desktop\\StoreFront Data\\productOrder.txt");
        if (!file.exists()) {
           file.createNewFile();
        } 
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        int j=1;
        for(int k=0;j<75;j++)
        {
        	for(int i = 0;i<25;++i)
        	{
        	bw.write(++k+"\t"+(j)+"\t"+(i+1)+order_product1);
        	bw.newLine();
        	bw.write(++k+"\t"+(j+1)+"\t"+(++i)+order_product1);
        	bw.newLine();
        	bw.write(++k+"\t"+(j+1)+"\t"+(++i)+order_product2);
        	bw.newLine();
        	bw.write(++k+"\t"+(j+1)+"\t"+(++i)+order_product3);
        	bw.newLine();
        	bw.write(++k+"\t"+(j+1)+"\t"+(++i)+order_product4);
        	bw.newLine();
        	bw.write(++k+"\t"+(j+1)+"\t"+(++i)+order_product5);
        	bw.newLine();
        	bw.write(++k+"\t"+(++j)+"\t"+(i+1)+order_product6);
        	bw.newLine();
        	bw.write(++k+"\t"+(j++)+"\t"+(++i)+order_product7);
        	bw.newLine();
        	bw.write(++k+"\t"+(j++)+"\t"+(++i)+order_product1);
        	bw.newLine();
        	
        	}
        	for(int i = 75;i<90;++i)
        	{
        	bw.write(++k+"\t"+(j+1)+"\t"+(i+1)+order_product2);
        	bw.newLine();
        	
        	bw.write(++k+"\t"+(j+1)+"\t"+(++i)+order_product7);
        	bw.newLine();
        	
        	bw.write(++k+"\t"+(j+1)+"\t"+(++i)+order_product1);
        	bw.newLine();
        	
        	bw.write(++k+"\t"+(j+1)+"\t"+(++i)+order_product2);
        	bw.newLine();
        	
        	bw.write(++k+"\t"+(j+1)+"\t"+(++i)+order_product1);
        	bw.newLine();
        	
        	bw.write(++k+"\t"+(j+1)+"\t"+(++i)+order_product3);
        	bw.newLine();
        	
        	bw.write(++k+"\t"+(j++)+"\t"+(i+1)+order_product1);
        	bw.newLine();
        	
        	bw.write(++k+"\t"+(j++)+"\t"+(++i)+order_product1);
        	bw.newLine();
        	
        	bw.write(++k+"\t"+(j++)+"\t"+(++i)+order_product4);
        	bw.newLine();
        	}
        }
        bw.close();
        System.out.println("Order Product Data written succesfully");
	}
    catch (IOException e) {
        e.printStackTrace();
     } 
}
}
