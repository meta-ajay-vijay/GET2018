package dbmsWriteFile;

import java.io.FileWriter;

public class WriteImageData {
	public static void main(String a[]) {
		try {
			FileWriter fw = new FileWriter("D:\\DBMS_FILES\\image_product.txt");

			int imageId=1;
			for (int i = 1; i <= 101; i++) {
				
				if(i%2==0){
					continue;
				}

				
				int count = 0;
				while(true){
				if(count == 3){
					break;
				}
					
				fw.write(imageId+"\t"+i+"\t"+imageId+"\r\n");
				imageId++;
				
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
