package employee;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class TestEmployee {

    public int[] showForNaturalOrder(List<Employee> empList) {
        int sortedlist[] = new int[empList.size()];

        Iterator<Employee> iterate = empList.iterator();
        int i = 0;
        while (iterate.hasNext()) {
            Employee emp = iterate.next();
            sortedlist[i] = emp.getEmpid();
            i++;
        }
        return sortedlist;
    }

    @Test
    public void testNaturalOrderSort() {
        List<Employee> empList = new ArrayList<Employee>();

        Employee emp1 = new Employee(10, "b");
        Employee emp2 = new Employee(9, "a");
        Employee emp3 = new Employee(8, "b");
        Employee emp4 = new Employee(7, "a");
        Employee emp5 = new Employee(6, "b");
        Employee emp6 = new Employee(5, "a");

        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        empList.add(emp5);
        empList.add(emp6);

        Collections.sort(empList);
        int empid[] = showForNaturalOrder(empList);

        assertArrayEquals(new int[] { 5, 6, 7, 8, 9, 10 }, empid);
    }

    @Test
    public void testNaturalOrderSort2() {
        List<Employee> empList1 = new ArrayList<Employee>();

        Employee emp1 = new Employee(11, "b");
        Employee emp2 = new Employee(12, "a");
        Employee emp3 = new Employee(13, "b");
        Employee emp4 = new Employee(14, "a");
        Employee emp5 = new Employee(15, "b");

        empList1.add(emp1);
        empList1.add(emp2);
        empList1.add(emp3);
        empList1.add(emp4);
        empList1.add(emp5);

        Collections.sort(empList1);
        int empid[] = showForNaturalOrder(empList1);

        assertArrayEquals(new int[] { 11, 12, 13, 14, 15 }, empid);
    }

}
