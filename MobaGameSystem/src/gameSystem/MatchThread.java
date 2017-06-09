package gameSystem;

import java.util.ArrayList;

public class MatchThread implements Runnable{
	int count = 0; 
	int doubleCount = 0;
	int i;
	public void setValueI(int ii){
		this.i = ii;
	}
	@Override
	public void run() {	
		//组队多人匹配
		if (GameSystem.playerQueue[i].isHasDouble()){
			while (doubleCount+3<GameSystem.playerQueue[i].getDoubleQueue().size()){
				int[] blueTeam = {GameSystem.playerQueue[i].getDoubleQueue().get(doubleCount).getId(),-2,GameSystem.playerQueue[i].getDoubleQueue().get(doubleCount+1).getId(),
						-2,GameSystem.playerQueue[i].getCurrentQueue().get(count++).getId()};	//-2表示这是二人组队，同上一个。
				int[] redTeam = {GameSystem.playerQueue[i].getDoubleQueue().get(doubleCount+2).getId(),-2,GameSystem.playerQueue[i].getDoubleQueue().get(doubleCount+3).getId(),
						-2,GameSystem.playerQueue[i].getCurrentQueue().get(count++).getId()};
				Team team = new Team();						
				team.setBlueTeam(blueTeam);
				team.setRedTeam(redTeam);			
				addToTeamArray(team,i);	
				doubleCount += 4;
			}
		}
		while (count+9 < GameSystem.playerQueue[i].getCurrentQueue().size()){
			int[] blueTeam = {GameSystem.playerQueue[i].getCurrentQueue().get(count).getId(),GameSystem.playerQueue[i].getCurrentQueue().get(count+1).getId(),
					GameSystem.playerQueue[i].getCurrentQueue().get(count+2).getId(),GameSystem.playerQueue[i].getCurrentQueue().get(count+3).getId(),
					GameSystem.playerQueue[i].getCurrentQueue().get(count+4).getId()};
			int[] redTeam = {GameSystem.playerQueue[i].getCurrentQueue().get(count+5).getId(),
					GameSystem.playerQueue[i].getCurrentQueue().get(count+6).getId(),GameSystem.playerQueue[i].getCurrentQueue().get(count+7).getId(),
					GameSystem.playerQueue[i].getCurrentQueue().get(count+8).getId(),GameSystem.playerQueue[i].getCurrentQueue().get(count+9).getId()};
			Team team = new Team();						
			team.setBlueTeam(blueTeam);
			team.setRedTeam(redTeam);			
			addToTeamArray(team,i);			
			count += 10;	
		}
		
		
	}
	
	public void addToTeamArray(Team t, int i){
		switch (i) {
		case 0: GameSystem.team0.add(t); break;
		case 1: GameSystem.team1.add(t); break;
		case 2: GameSystem.team2.add(t); break;
		case 3: GameSystem.team3.add(t); break;
		case 4: GameSystem.team4.add(t); break;
		case 5: GameSystem.team5.add(t); break;
		case 6: GameSystem.team6.add(t); break;
		case 7: GameSystem.team7.add(t); break;
		case 8: GameSystem.team8.add(t); break;
		case 9: GameSystem.team9.add(t); break;
		case 10: GameSystem.team10.add(t); break;
		case 11: GameSystem.team11.add(t); break;
		case 12: GameSystem.team12.add(t); break;
		case 13: GameSystem.team13.add(t); break;
		case 14: GameSystem.team14.add(t); break;
		case 15: GameSystem.team15.add(t); break;
		case 16: GameSystem.team16.add(t); break;
		case 17: GameSystem.team17.add(t); break;
		case 18: GameSystem.team18.add(t); break;
		case 19: GameSystem.team19.add(t); break;
		case 20: GameSystem.team20.add(t); break;
		default:
			break;
		}
	}
}