import java.text.DecimalFormat;
import java.util.*;

class Grades{
	public float gradeOfStudent=0;
	public String nameOfStudent="";
	
	/**
	 * Constructor of class Grade
	 * @param name
	 * @param grade
	 */
	public Grades(String name,float grade)
	{
		gradeOfStudent=grade;
		nameOfStudent=name;
	}
}


class Marksheet{
	public ArrayList <Grades> marksheet = new ArrayList<Grades> ();
	
	/**
	 * Calculates average of student list
	 * @return
	 */
	public float averageOfAll()
	{
	 float sum = 0;
	 for(int i=0;i<marksheet.size();i++)	
	 {
		sum = sum + marksheet.get(i).gradeOfStudent; 
	 }
	 return sum;
	}
	
	/**
	 * Calculates maximum of student list
	 * @return
	 */
	public float maximumOfAll()
	{
	 float max = -1;
	 for(int i=0;i<marksheet.size();i++)	
	 {
		if(marksheet.get(i).gradeOfStudent > max)
			max = marksheet.get(i).gradeOfStudent;
	 }
	 return max;
	}
	
	/**
	 * Calculates minimum of student list
	 * @return
	 */
	public float minimumOfAll()
	{
		float min = marksheet.get(0).gradeOfStudent;
		 for(int i=1;i<marksheet.size();i++)	
		 {
			if(marksheet.get(i).gradeOfStudent < min)
				min = marksheet.get(i).gradeOfStudent;
		 }
		 return min;
	}
	
	/**
	 * Calculates percetage of student list
	 * @return
	 */
	public float percetageOfPassedStudents()
	{
		 float sum = 0;
		 for(int i=0;i<marksheet.size();i++)	
		 {
			if( marksheet.get(i).gradeOfStudent > 40)
			{sum++;
			}
		 }
		 return (float)(sum/marksheet.size())*100;
		 
		
	}
	
	
	public void operation (int userAction)
	{
		float result=0;
		
		switch(userAction)
		{
		case 1:
			result = averageOfAll();
			break;
				
		case 2:
			result = maximumOfAll();
			break;

		case 3:
			result = minimumOfAll();
			break;
			
		case 4:
			result = percetageOfPassedStudents();
			break;
		}
	   if(userAction<5)
		{DecimalFormat df = new DecimalFormat();
	    df.setMinimumFractionDigits(2);
	    df.setMaximumFractionDigits(2);
	    
		System.out.println("Answer : " +df.format(result));
		}
	}
	
	public static void main(String args[])
	{
		Marksheet report = new Marksheet();
		Scanner scan = new Scanner(System.in);
		Scanner scanFull = new Scanner(System.in);
		System.out.println("Enter the number of students whose combined Marksheet is to be printed");
		int totalStudents =0;
		boolean flag = false;
		do{
			try{
			flag =false;
			totalStudents = scan.nextInt();
			if(totalStudents<0)
			{
				totalStudents =  - totalStudents;
			}
		}catch(Exception e)
			{
			flag = true;
			System.out.println("Please enter a valid numerical value of the size Integer greater than zero ");
			scan.next();
			}	
		}while(flag);
		System.out.println("Total number of Students are  " +totalStudents);
		System.out.println("Enter the Names and Marks of students");
		String name="";
		float grade=0;
		for(int i=0; i<totalStudents;i++)
		{
			name="";
			grade=0;
			try{
				System.out.println("Enter the name");
				name = scanFull.nextLine();
				if (name!=null)
				 		{
						 for(int j=0;j<name.length();j++)
						 {
							 if(name.charAt(j)<'A' || (name.charAt(j)>'Z') && (name.charAt(j)<'a') && name.charAt(j)>'z' )
								 	{
								 		throw new NullPointerException("Not Valid Name");
								 	}
						 }
				 		}
				else{
						throw new NullPointerException("Not Valid Name");
					}
				
				System.out.println("Enter the grade");
				if(scan.hasNextInt())
				{
					grade = scan.nextInt();
					if(grade<0 || grade>100)
					{
						throw new Exception("");	
					}
				}
				else
				{
					throw new Exception("");
				}
			   }
			catch(NullPointerException e)
			{
				   System.out.println("Name Not Real");
				   scanFull.next();
			}
			catch(Exception e)
			{
				   System.out.println("MissMatchException, Please enter a valid number between 0 to 100");
				   scan.next();
			}
				Grades gradeStudent = new Grades(name,grade);
				report.marksheet.add(gradeStudent);
		}
		int userAction=0;
		do{
			System.out.println("\t 1. Average of Grades ");
			System.out.println("\t 2. maximum Grades ");
			System.out.println("\t 3. minimum Grades ");
			System.out.println("\t 4. % of passed students ");
			System.out.println("\t 5. Exit ");
			
			try
			{
				if(scan.hasNext())
					{
					userAction=scan.nextInt();
					if(userAction < 1 || userAction >5)
						throw new Exception ();
					}
				else{
					throw new Exception ();
				}
			}catch(Exception e)
			{
				System.out.println("Enter the correct option");
				scan.next();
			}
			report.operation(userAction);
		}while(userAction!=5);
	}
}
