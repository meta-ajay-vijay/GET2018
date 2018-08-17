package dbmsWriteFile;

import java.io.FileWriter;

public class WriteProductCategory {
	public static void main(String a[]) {
		try {
			FileWriter fw = new FileWriter("D:\\DBMS_FILES\\product_category.txt");

			int catId=1;
			for (int i = 1; i <= 101; i++) {
				
				if(i%2==0){
					continue;
				}

				
				int count = 0;
				while(true){
				if(count == 3){
					break;
				}
					
				fw.write(i+"\t"+i+"\t"+catId+"\r\n");
				catId++;
				
				count++;
				}
			}
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Success...");
	}
}
