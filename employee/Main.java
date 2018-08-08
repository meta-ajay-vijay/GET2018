package employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import myUtility.Utility;

//Temporary main Function to check the console
public class Main {

    static List<Employee> employeeList = new ArrayList<Employee>();
    static Scanner scan = new Scanner(System.in);
    public static void show() {
        Iterator<Employee> iterate = employeeList.iterator();

        while (iterate.hasNext()) {
            Employee emp = iterate.next();

            System.out.println("Unique ID : " + emp.getEmpid() + "   Name : "
                    + emp.getName());
            System.out.println();

        }
    }

    public static void main(String args[]) {
    	System.out.println("How many employees you want to add?");
    	int numberOfEmployees = Utility.isPositiveInt();
    	
    	for(int index = 0; index < numberOfEmployees; index++) {
    		System.out.println("Enter the id of Employee");
    		int idOfEmployee = Utility.isValidEmployee(employeeList);
    		System.out.println("Enter the name of the employee");
    		String nameOfEmployee = scan.nextLine().toUpperCase();
    		Employee employeeObject = new Employee(idOfEmployee, nameOfEmployee);
    		employeeList.add(employeeObject);
    	}
        
    	System.out.println("Natural Order Sort : ");
        Collections.sort(employeeList);
        show();

        System.out.println("Sort by Name : ");
        Collections.sort(employeeList, new SortByDefinedOrder());
        show();
    }
}
