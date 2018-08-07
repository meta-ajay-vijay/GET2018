package studentCounselling;

import queue.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AllotSeat {

	Map<String, Integer> availableSeats = new HashMap<String, Integer>();
	Queue<Student> queueOfStudent = new QueueLinklist<Student>();

	/**
	 * reading student data from the choices.xlsx file and adding the whole data
	 * into the queue
	 */
	private boolean readStudent() {
		try {
			FileInputStream file = new FileInputStream(
					new File(
							"H:\\Akv\\Eclipse\\Counseling\\src\\studentCounselling\\xlsFils\\choices.xlsx"));

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				Student student = new Student();
				Cell cellOfName = cellIterator.next();
				student.setName(cellOfName.getStringCellValue());
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					student.choices.add(cell.getStringCellValue());
				}
				queueOfStudent.enqueue(student);
			}
			file.close();
			workbook.close();

		} catch (Exception e) {
			System.out.println("message:" + e.getMessage());
		}
		return true;
	}

	/**
	 * reading college seat Available data from SeatsAvailable.xlsx
	 * 
	 * @return
	 */
	private boolean readCollege() {
		try {
			FileInputStream file = new FileInputStream(
					new File(
							"H:\\Akv\\Eclipse\\Counseling\\src\\studentCounselling\\xlsFils\\SeatsAvailable.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cellOfBranch = cellIterator.next();
				String keyBranch = cellOfBranch.getStringCellValue();
				Cell cellOfAvailableSeats = cellIterator.next();
				int value = (int) cellOfAvailableSeats.getNumericCellValue();
				availableSeats.put(keyBranch, value); // adding key value pair
														// to college map
			}
			file.close();
			workbook.close();
		} catch (Exception e) {
			System.out.println();
		}
		return true;
	}

	/**
	 * checking in available seats that whether seats are available or not
	 * 
	 * @param key
	 * @return
	 */
	private boolean isSeatAvailable(String key) {
		try {
			int seat = availableSeats.get(key);
			return seat > 0 ? true : false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * updating list after allocation
	 * 
	 * @param key
	 */
	private void updateSeat(String key) {
		int seat = availableSeats.get(key);
		seat--;
		availableSeats.replace(key, seat);
	}

	/**
	 * Allotting seat to student
	 * 
	 * @return list of students
	 */
	public boolean allotSeat() {
		readCollege();
		readStudent();
		List<Student> listOfStudent = new ArrayList<Student>();
		while (!queueOfStudent.isEmpty()) {
			Student student = queueOfStudent.peek();
			List<String> choices = student.getChoices();
			boolean flag = true;
			int index = 0;
			while (flag && index <= 4) {
				String choice = choices.get(index);
				if (isSeatAvailable(choice)) {
					student.setAllottedSeat(choice);
					updateSeat(choice);
					listOfStudent.add(student);
					flag = false;
				}
				index++;
			}
			queueOfStudent.dequeue();
		}

		createUpdatedCollegeXls();
		createAlottedFile(listOfStudent);

		return listOfStudent.size()>0?true:false;
	}

/**
 * creating list for updated college list 	
 * @return
 */
	private boolean createUpdatedCollegeXls() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("AllocatedSeats");
		XSSFRow row;
		int rowid = 0;
		for (String name : availableSeats.keySet()) {
			String key = name.toString();
			String value = availableSeats.get(name).toString();
			row = sheet.createRow(rowid++);
			Cell cell1 = row.createCell(0);
			cell1.setCellValue(key);
			Cell cell2 = row.createCell(1);
			cell2.setCellValue(value);
		}
		try {
			FileOutputStream outputFile = new FileOutputStream(
					new File(
							"H:\\Akv\\Eclipse\\Counseling\\src\\studentCounselling\\xlsFils\\UpdateSeatsAvailable.xlsx"));
			workbook.write(outputFile);
			outputFile.close();
			workbook.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

/**
 * creating file which is consisting the alloted branches to each student	
 * @param studentList
 * @return
 */
	private boolean createAlottedFile(List<Student> studentList) {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("AllocatedSeats");
		XSSFRow row;

		int rowid = 0;
		for (Student s : studentList) {
			row = sheet.createRow(rowid++);
			Cell cell1 = row.createCell(0);
			cell1.setCellValue(s.getName());
			Cell cell2 = row.createCell(1);
			cell2.setCellValue(s.getAllottedSeat());
		}
		try {
			FileOutputStream outputFile = new FileOutputStream(
					new File(
							"H:\\Akv\\Eclipse\\Counseling\\src\\studentCounselling\\xlsFils\\AllotedSeats.xlsx"));
			workbook.write(outputFile);
			outputFile.close();
			workbook.close();
			System.out.println("Writesheet.xlsx written successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return true;
	}

}
