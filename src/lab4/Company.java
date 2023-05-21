package lab4;

import java.util.*;

public class Company {
    private String name;
    private Map<String, Worker> teamCoordinators;
    private Map<String, List<Worker>> teamGroup;


    public Company(String name, List<Worker> workers){
        this.name=name;
        teamCoordinators=new HashMap<>();
        teamGroup=new HashMap<>();
        teamGroup.put("Unsorted", workers);
    }

    public String getName() {
        return name;
    }

    public Map<String, Worker> getTeamCoordinators() {
        return teamCoordinators;
    }

    public Map<String, List<Worker>> getTeamGroup() {
        return teamGroup;
    }
    public boolean createNewTeam(String team, Worker teamCoordinator){
        if(teamCoordinators.containsKey(team)) return false;
        teamCoordinators.put(team,teamCoordinator);
        return true;
    }
    public void addWorkerToTeam(String oldTeam, String newTeam, String id){
        for(Worker w:teamGroup.get(oldTeam)){
            if(w.getId().equals(id)){
                teamGroup.get(oldTeam).remove(w);
                if(teamGroup.containsKey(newTeam)) teamGroup.get(newTeam).add(w);
                else{
                    List<Worker> list=new ArrayList<>();
                    list.add(w);
                    teamGroup.put(newTeam,list);}
            }
            break;
        }
    }
    public void reviseTeam(String teamName){
        Worker coordinator=teamCoordinators.get(teamName);
        Worker temp=teamCoordinators.get(teamName);
        for(Worker w:teamGroup.get(teamName)){
            if(w.getYearOfExperience()>coordinator.getYearOfExperience()){
                coordinator=w;

            }
        }
        teamCoordinators.replace(teamName,coordinator);
        teamGroup.get(teamName).remove(coordinator);
        teamGroup.get(teamName).add(temp);
    }
}
