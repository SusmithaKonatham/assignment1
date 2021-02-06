package employeeproject;
public class Employee 
{
	private String employeeName;
	private Double employeeSalary;
	private int employeeAge;
	private int employeeId;
	public Employee() {
		
	}
	//constuctor
	public Employee(String employeeName, Double employeeSalary, int employeeAge, int employeeId) {
		super();
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
		this.employeeId = employeeId;
	}
	public void update(String employeeName, double salary, int age)
	{
		this.employeeName = employeeName;
		this.employeeSalary = salary;
		this.employeeAge = age;	
	}
//getemployeeid
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void displayEmployeedetails() 
	{
		System.out.println(" EmployeeName   : "+employeeName+" \n"+
						   " EmployeeSalary : "+employeeSalary+"\n"+
				           " EmployeeAge    : "+employeeAge+"\n"+
						   " EmployeeId     : "+employeeId);
		
	}
	
	
	}


