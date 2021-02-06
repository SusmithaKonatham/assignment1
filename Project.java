package employeeproject;
public class Project 
{
	private String projectName;
	private String projectTechnology;
	private String projectDuration;
	private int projectId;
	public Project(String projectName, String projectTechnology, String projectDuration, int projectId) {
		super();
		this.projectName = projectName;
		this.projectTechnology = projectTechnology;
		this.projectDuration = projectDuration;
		this.projectId = projectId;
	}
	public void update(String projectName, String technology, String duration)
	{
		this.projectName = projectName;
		this.projectTechnology = technology;
		this.projectDuration = duration;	
	}
	public int getProjectId() {
		return projectId;
	}
	public void displayProjectdetails() 
	{
		System.out.println(" ProjectName       : "+projectName+"\n"+
						   " ProjectTechnology : "+projectTechnology+"\n"+
						   " ProjectDuration   : "+projectDuration+"\n"+
						   " ProjectId         : "+projectId);
		
	}
	

}
