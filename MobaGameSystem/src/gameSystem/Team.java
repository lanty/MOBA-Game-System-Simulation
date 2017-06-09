package gameSystem;

public class Team {
	private int[] redTeam = new int[5];
	private int[] blueTeam = new int[5];
	public int[] getRedTeam() {
		return redTeam;
	}
	public void setRedTeam(int[] redTeam) {
		if (redTeam.length>5)
			System.out.println("Exception: Team size is out of Bound (Max 5)");
		for (int i=0;i<redTeam.length;++i){
			this.redTeam[i] = redTeam[i];
		}
	}
	public int[] getBlueTeam() {
		return blueTeam;
	}
	public void setBlueTeam(int[] blueTeam) {
		if (blueTeam.length>5)
			System.out.println("Exception: Team size is out of Bound (Max 5)");
		for (int i=0;i<blueTeam.length;++i){
			this.blueTeam[i] = blueTeam[i];
		}
	}
	
	
}
