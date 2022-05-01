import java.util.ArrayList;

public class Contributors {
	public String name;
	public ArrayList <Skill> skills ;
	public boolean available;
	public int numOfSkills;
	
	
public Contributors(String name) {
	this.name=name;
	this.skills=new ArrayList<Skill>();
	this.available=true;
	numOfSkills = 0;
}
}
