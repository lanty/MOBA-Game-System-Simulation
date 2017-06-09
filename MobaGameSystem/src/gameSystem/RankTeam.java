package gameSystem;


public class RankTeam {
	private int teamId;
	private Player[] redTeam = new Player[5];
	private Player[] blueTeam = new Player[5];
	
	public RankTeam(int id, Player[] playerGroup) {
		this.teamId = id;
		for (int i=0;i<5;++i){
			redTeam[i] = new Player();
			blueTeam[i] = new Player();
		}
		for (int i=0;i<5;++i){
			redTeam[i] = playerGroup[i];
			blueTeam[i] = playerGroup[i+5];
		}
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public Player[] getRedTeam() {
		return redTeam;
	}

	public void setRedTeam(Player[] redTeam) {
		this.redTeam = redTeam;
	}

	public Player[] getBlueTeam() {
		return blueTeam;
	}

	public void setBlueTeam(Player[] blueTeam) {
		this.blueTeam = blueTeam;
	}
	
	//add here
	public void setFirstPlayer(Player player){
		this.redTeam[0] = player;
	}
}
