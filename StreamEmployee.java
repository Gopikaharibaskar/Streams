package StreamRecordExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

record Employee(String name,int age,String dept) {}
    
	public class StreamEmployee {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		List<Employee> emplist=new ArrayList<>();
		System.out.println("enter no. of Employees:");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Details:");
			System.out.println("Enter EmpName:");
			String name=sc.next();
			System.out.println("Enter Age:");
			int age=sc.nextInt();
			System.out.println("Enter department:");
			String dept=sc.next();
			emplist.add(new Employee(name,age,dept));
		}
		
		System.out.println("enter department to filter:");
		String userdept=sc.next();
		List<Employee> newlist = emplist.stream()
				.filter(emp->emp.dept().equalsIgnoreCase(userdept))
				.collect(Collectors.toList());
		System.out.println("Employees in "+userdept+" department:");
		if(newlist.isEmpty())
		{
			System.out.println("No employees found");
		}
		else
		{
			newlist.forEach(System.out::println);
		}
		
		
		
		
		

	}

}
