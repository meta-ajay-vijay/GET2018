package employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employee implements Comparable<Employee> {

    private int empid;
    private String name;
    private List<Integer> listOfempID = new ArrayList<Integer>();
    static int count[] = new int[255];

    /**
     * Constructor to initialize empid and name of employee
     * 
     * @param empid
     * @param name
     */
    public Employee(int empid, String name) {
        this.name = name;
        listOfempID.add(empid);

        if (checkDuplicateinList(listOfempID)) {
            this.empid = empid;
        } else {
            listOfempID.removeAll(listOfempID);
            throw new AssertionError("!! Duplicate !!");
        }
    }

    // getter START
    public int getEmpid() {
        return empid;
    }

    public String getName() {
        return name;
    }

    // getter END

    /**
     * Helper function to check duplicates entry in the field employee ID
     * 
     * @param emplist
     * @return true or false
     */
    boolean checkDuplicateinList(List<Integer> emplist) {

        Iterator<Integer> iterate = emplist.iterator();

        while (iterate.hasNext()) {
            int id = iterate.next();
            if (count[id] <= 0) {
                count[id]++;
                return true;
            }
        }
        return false;
    }

    /**
     * Function to compare or sort according to empid in employee class i.e,
     * natural order sort
     */
    @Override
    public int compareTo(Employee emp) {
        return this.empid - emp.empid;

    }

}
