package employeeproject;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService
{
    private static Scanner scanner=new Scanner(System.in);
    private static ArrayList<Employee> employees=new ArrayList<>();
  /* public static void main(String[] args)
    {
        while (true){
            int usersChoice=askUsersChoice();
            processUserChoice(usersChoice);
        }
    }*/
  
  public static void askUsersChoice(){
	  while(true)
	  {
	  System.out.println("1.Create Emloyee");
      System.out.println("2.Update Employee");
      System.out.println("3.Delete Employee ");
      System.out.println("4.List Employee");
      System.out.println("5.Go To Project");
      System.out.println("Choose Your Choice");
      processUserChoice(scanner.nextInt());
	  }
   }
    
    
  
   public static void processUserChoice(int userChoice){
        switch (userChoice){
            case 1:
                final Employee employee=createEmployee();
                employees.add(employee);
                break;
            case 2:
                System.out.println("Which Employe Needs to Update? Give me the ID:");
                updateEmployee(scanner.nextInt());
                break;
            case 3:
                System.out.println("Enter Employee to delete! Give the Id");
                deleteEmployee(scanner.nextInt());
                break;
            case 4:
                listEmployees();
                break;
            case 5:
            	ProjectService.askUsersChoice();
            	
            	break;
            	
        }
    }
    //------------CreateEmployee--------------------
    public static Employee createEmployee(){
        System.out.println("Provide Employee details!");
        final String name=takeName();
        final double salary=takeSalary();
        final int age=takeAge();
        Employee employee=creatingEmployeeObject(name,salary,age);
        employee.displayEmployeedetails();
        return employee;
    }
    public static int identifier=1;
    public static Employee creatingEmployeeObject(String name, double salary, int age) {
        return new Employee(name,salary,age,identifier++);
    }
   
    public static String takeName(){
        System.out.print("EmployeeName: ");
        final String name=scanner.next();
        if (!isNameValid(name)) {
            return takeName();
        }
        return name;  
    }
    public static boolean isNameValid(String name){
        final boolean matches=name.matches("[a-zA-Z]*$");
        if(!matches) {
            System.out.println("Looks like Invalid");
        }
       return matches;
    
    }
    public static double takeSalary(){
        System.out.print("EmployeeSalary: ");
        return scanner.nextDouble();
    }
    public static int takeAge(){
        System.out.print("EmployeeAge: ");
        return scanner.nextInt();
    }
    //------------End CreateEmployee----------------
    //------------UpdateEmployee--------------------
    public static void updateEmployee(int empId) {
        boolean isEmployeeFound=false;
        for (int i=0;i<employees.size();i++)
        {
            isEmployeeFound= employees.get(i).getEmployeeId()==(empId);
                if(isEmployeeFound){
                    System.out.println("Enter updated info with id: "+empId);
                    final String name=takeName();
                    final double salary=takeSalary();
                    final int age=takeAge();
                    employees.get(i).update(name,salary,age);
                    break;
                }
            if (!isEmployeeFound)
                System.out.println("Employee Not Exist to Update!");
        }
    }
    //---------------EndUpdateEployee-----------------
    //----------------DeleteEmployee------------------
    public static void deleteEmployee(int employeeId) {
        for (int i=0;i<employees.size();i++){
            if(employees.get(i).getEmployeeId()==employeeId){
                employees.remove(i);
                System.out.println("Employee with id: "+employeeId+" is deleted");
            }
        }
    }
    //-----------------EndDeleteEmployee---------------
    //-----------------ListEmployee--------------------
    
    public static void listEmployees() {
        for (Employee e:employees) {
        	System.out.println("------------------------------");
            e.displayEmployeedetails();
            System.out.println("------------------------------");
        }   
    }
    //---------------EndListEmployee------------------
   
}
