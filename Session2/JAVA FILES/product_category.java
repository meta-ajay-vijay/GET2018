package dbmsWriteFile;

import java.io.FileWriter;

public class product_category {
	public static void main(String a[]) {
		try {
			FileWriter fw = new FileWriter(
					"D:\\Assignments metacube\\StoreFront Complete Partially\\StoreFront Complete Partially\\StoreFront Data\\product_category.txt");

			int pid = 1;
			int index = 1;
			for (int i = 1; i <= 14; i++) {

				int count = 0;
				while (count < 7) {
					count++;
					fw.write(index + "\t" + pid + "\t" + i + "\r\n");
					index++;
					pid++;
				}
			}
			
			fw.write(99 + "\t" + 99 + "\t" + 15 + "\r\n");
			fw.write(100 + "\t" + 100 + "\t" + 15 + "\r\n");
			fw.write(101 + "\t" + 101 + "\t" + 15 + "\r\n");

			
			fw.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Success...");
}
}
