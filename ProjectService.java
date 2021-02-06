package employeeproject;
import java.util.ArrayList;
import java.util.Scanner;
public class ProjectService
{
	    private static Scanner scanner=new Scanner(System.in);
	    private static ArrayList<Project> projects=new ArrayList<>();
	    private static ArrayList<Employee> employees=new ArrayList<>();
	    
	    /*public static void main(String[] args) {
	    while (true) {
	         int usersChoice=askUsersChoice();
	         processUserChoice(usersChoice);
	    }
	    }*/
	 
	   public static void askUsersChoice(){
		   while(true)
			  {
		    System.out.println("1.Create Project");
	        System.out.println("2.Update Project");
	        System.out.println("3.Delete Project");
	        System.out.println("4.List Project");
	        System.out.println("5.Go to Employee");
	        System.out.println("6.To Check employees in Project");
	        System.out.println("Choose Your Choice");
	        processUserChoice(scanner.nextInt());
			  }
	    }
	    
	    static void processUserChoice(int userChoice){
	        switch (userChoice){
	            case 1:
	                final Project project=createProject();
	                projects.add(project);
	                break;
	            case 2:
	                System.out.println("Which Project Needs to Update? Give me the ID:");
	                updateProject(scanner.nextInt());
	                break;
	            case 3:
	                System.out.println("Enter Project to delete! Give the Id");
	                deleteProject(scanner.nextInt());
	                break;
	            case 4:
	                listProject();
	                break;
	            case 5:
	            	EmployeeService.askUsersChoice();
	            	break;
	            case 6:
	                 listFlow();
	            	break;
	        }
	    }
	
		//------------CreateProject--------------------
	    public static Project createProject(){
	        System.out.println("Provide Employee details!");
	        final String name=takeName();
	        final String technology=takeTechnology();
	        final String duration=takeDuration();
	        Project project=creatingProjectObject(name,technology,duration);
	        project.displayProjectdetails();
	        return project;
	    }
	    public static int identifier=1;
	    public static Project creatingProjectObject(String name,String technology, String duration) {
	        return new Project(name,technology,duration,identifier++);
	    }
	    public static String takeName(){
	        System.out.print("ProjectName : ");
	        final String name=scanner.next();
	        if (!isNameValid(name)) {
	            return takeName();
	        }
	        else {
	            return name;
	        }
	    }
	    public static boolean isNameValid(String name){
	        final boolean matches=name.matches("[a-zA-Z]*$");
	        if(!matches) {
	            System.out.println("Looks like Invalid");
	        }
	       return matches;
	    }
	    public static String takeTechnology(){
	        System.out.print("Technology  : ");
	        return scanner.next();
	    }
	    public static String takeDuration(){
	        System.out.print("Duration : ");
	        return scanner.next();
	    }
	    //------------End CreateProject----------------
	    //------------UpdateProject--------------------
	    public static void updateProject(int Id) {
	        boolean isProjectFound=false;
	        for (int i=0;i<projects.size();i++)
	        {
	            isProjectFound= projects.get(i).getProjectId()==(Id);
	                if(isProjectFound){
	                    System.out.println("Enter updated info with id: "+Id);
	                    final String name=takeName();
	                    final String technology=takeTechnology();
	                    final String duration=takeDuration();
	                    projects.get(i).update(name,technology,duration);
	                    break;
	                }
	            if (!isProjectFound)
	                System.out.println("Employee Not Exist to Update!");
	        }
	    }
	    //---------------EndUpdateProject-----------------
	    //----------------DeleteProject----------------
	    public static void deleteProject(int projectId) {
	        for (int i=0;i<projects.size();i++){
	            if(projects.get(i).getProjectId()==projectId){
	                projects.remove(i);
	                System.out.println("Employee with id: "+projectId+" is deleted");
	            }
	        }
	    }
	    //-----------------EndDeleteProject---------------
	    //-----------------ListProject--------------------
	    
	    public static void listProject() {
	        for (Project e:projects) {
	        	System.out.println("-------------------------------------------");
	            e.displayProjectdetails();
	            System.out.println("-------------------------------------------");
	        }   
	    }
	    //---------------EndListEmployee------------------
	    public static void listFlow() {
	        for (Employee e:employees) {
	          e.displayEmployeedetails();
	            
	        }   
	}
}



