package nestedList;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import nestedList.NestedListOfIntegers;
import myUtility.Utility;

/**
 * @author Ajay
 *
 */
public class NestedListMain {
	public static final String jsonFilePath = "F:\\Eclipse\\Data Structure\\src\\nestedList\\inputData.json";

	public static void main(String[] args) {
		NestedListOfIntegers nestedlist = new NestedListOfIntegers();
		List<Object> nestedListOfIntegers = new LinkedList<Object>();
		try {
			Object object = new JSONParser().parse(new FileReader(jsonFilePath));
			JSONObject inputJsonObject = (JSONObject) object;
			JSONArray jsonArrayOfInputList = (JSONArray) inputJsonObject.get("inputData");
			nestedListOfIntegers = nestedlist.createNestedList(nestedListOfIntegers, jsonArrayOfInputList);
			nestedlist.listOfIntegersFinal = nestedListOfIntegers;
			System.out.println("Nested list");
			nestedlist.printNestedList(nestedlist.listOfIntegersFinal);

			System.out.println("\nSum of nested list");
			System.out.println(nestedlist.sumOfAllIntegersInList(nestedlist.listOfIntegersFinal));

			System.out.println("Largest element of nested list");
			System.out.println(nestedlist.largestIntegerInList(nestedlist.listOfIntegersFinal));

			System.out.println("Integer 1 in list? ");
			System.out.println(nestedlist.findIntegerInList(nestedlist.listOfIntegersFinal, 1));

			System.out.println("Integer 5 in list? ");
			System.out.println(nestedlist.findIntegerInList(nestedlist.listOfIntegersFinal, 5));

			System.out.println("Integer 10 in list? ");
			System.out.println(nestedlist.findIntegerInList(nestedlist.listOfIntegersFinal, 10));

			System.out.println("Integer 15 in list? ");
			System.out.println(nestedlist.findIntegerInList(nestedlist.listOfIntegersFinal, 15));

			System.out.println("Integer 20 in list? ");
			System.out.println(nestedlist.findIntegerInList(nestedlist.listOfIntegersFinal, 20));

			System.out.println("Integer 25 in list? ");
			System.out.println(nestedlist.findIntegerInList(nestedlist.listOfIntegersFinal, 25));

			System.out.println("Integer 17 in list? ");
			System.out.println(nestedlist.findIntegerInList(nestedlist.listOfIntegersFinal, 17));

			String position = new String("T");
			if (Utility.isValidPosition(nestedlist.listOfIntegersFinal, position)) {
				System.out.println("Valid");
			} else {
				System.out.println("Invalid position");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
