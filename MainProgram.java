import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MainProgram {
	public Simulation sim;
	
	public void readInput(String path) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("input_data/"+path));
		String[] firstLine = br.readLine().split(" ");
		this.sim = new Simulation();
		this.sim.numOfContrs = Integer.parseInt(firstLine[0]);
		this.sim.numOfProjs = Integer.parseInt(firstLine[1]);
		String[] line;
		for(int i = 0 ; i< this.sim.numOfContrs ; i++) {
			line = br.readLine().split(" ");
//			System.out.println(line[0]+line[1]);
			Contributors currentCont = new Contributors(line[0]);
			currentCont.numOfSkills = Integer.parseInt(line[1]);
			for(int j = 0; j<currentCont.numOfSkills ; j++) {
				line = br.readLine().split(" ");
				currentCont.skills.add(new Skill(Integer.parseInt(line[1]),line[0]));
			}
			this.sim.contributors.add(currentCont);
			
		}
		for(int i = 0 ; i< this.sim.numOfProjs ; i++) {
			line = br.readLine().split(" ");
			Project currentProj = new Project(line[0], Integer.parseInt(line[1]),
														Integer.parseInt(line[2]),
														Integer.parseInt(line[3]),
														Integer.parseInt(line[4]));
			
			
			for(int j = 0; j<currentProj.numOfRoles ; j++) {
				line = br.readLine().split(" ");
				currentProj.roles.add(new Role(new Skill(Integer.parseInt(line[1]),line[0])));
			}
			this.sim.projects.add(currentProj);
			
		}
		br.close();
	}
	
	public void assignContributors() {
		int temp=this.sim.projects.size();
		
		for (int i=0;i<temp;i++) {
			Project currentProj=this.sim.projects.get(i);
			for (int j=0;j<currentProj.roles.size();j++) {
				for(int k=0;k<this.sim.contributors.size();k++) {
					for(int p=0;p<this.sim.contributors.get(k).numOfSkills;p++) {
					if( (currentProj.roles.get(j).requiredSkill.level<=this.sim.contributors.get(k).skills.get(p).level) && 
							(currentProj.roles.get(j).requiredSkill.name.equals(this.sim.contributors.get(k).skills.get(p).name)) &&
							(this.sim.contributors.get(k).available) ) {
						currentProj.roles.get(j).contributor=this.sim.contributors.get(k);
						currentProj.numOfRoles-=1;
						this.sim.contributors.get(k).available=false;
						
						
					}
					
					else if( (currentProj.roles.get(j).requiredSkill.level-1==this.sim.contributors.get(k).skills.get(p).level) && 
							(currentProj.roles.get(j).requiredSkill.name.equals(this.sim.contributors.get(k).skills.get(p).name)) &&
							(this.sim.contributors.get(k).available) ){
						
						for (int t=0;t<currentProj.roles.size()&& t!=k;t++) {
							if(currentProj.roles.get(t).contributor.skills.contains(currentProj.roles.get(j).requiredSkill)) {
								currentProj.roles.get(j).contributor=this.sim.contributors.get(k);
								currentProj.numOfRoles-=1;
								this.sim.contributors.get(k).available=false;
							}
						}
						
						
					}
					
					
					}
				}
			}
		}
		
		for (int i=0;i<temp;i++) {
			Project currentProj=this.sim.projects.get(i);
			if(currentProj.numOfRoles==0 && !currentProj.done) {
				currentProj.done=true;
				for (int j=0;j<currentProj.roles.size();j++) {
					currentProj.roles.get(j).contributor.available=true;
					Skill tempSkill=null;
					for(int k=0;k<currentProj.roles.get(j).contributor.skills.size();k++) {
						if(currentProj.roles.get(j).requiredSkill.name.equals(currentProj.roles.get(j).contributor.skills.get(k).name)) {
							tempSkill=currentProj.roles.get(j).contributor.skills.get(k);
						}
					}
					if(currentProj.roles.get(j).requiredSkill.level<=tempSkill.level) {
						tempSkill.level++;
					}

					
					
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		MainProgram m = new MainProgram();
		m.readInput("a_an_example.in.txt");
		m.assignContributors();
		int t=0;
		String s="";
		
		for(int i=0;i<m.sim.projects.size();i++) {
			if(m.sim.projects.get(i).done) {
				s+=m.sim.projects.get(i).name + " ";
				t++;
			for(int g=0;g<m.sim.projects.get(i).roles.size();g++)	{
				s+=m.sim.projects.get(i).roles.get(g).contributor.name;
			}
			}
			
			
		}
	}
	
}
