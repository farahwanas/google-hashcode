import java.util.ArrayList;

public class Simulation {
	public ArrayList<Contributors> contributors;
	public ArrayList<Project> projects;
	public int numOfContrs;
	public int numOfProjs;
	public int currentDay;
	
	public Simulation() {
		this.contributors = new ArrayList<Contributors>();
		this.projects = new ArrayList<Project>();
		numOfContrs = 0;
		numOfProjs = 0;
		currentDay=0;
	}
}
