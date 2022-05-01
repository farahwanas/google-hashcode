import java.util.ArrayList;

public class Project {
    public String name;
    public int duration;
    public int score;
    public int bestBefore;
    public ArrayList<Role> roles;
    public boolean done;
    public int numOfRoles;

    public Project(String name, int duration, int score, int bestBefore, int numOfRoles) {
        this.name = name;
        this.duration = duration;
        this.score = score;
        this.bestBefore = bestBefore;
        this.roles = new ArrayList<Role>();
        this.done = false;
        this.numOfRoles = numOfRoles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(int bestBefore) {
        this.bestBefore = bestBefore;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

}