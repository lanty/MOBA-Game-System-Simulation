package gameSystem;

public class RankTest1 {
	public static void main(String[] args) {
		UpdateScore updateScore = new UpdateScore();
		updateScore.generateRankTeam();
		
		Player player = new Player(4000,3000,0); 
		for (int i=0;i<100;++i)
			player = updateScore.eloProcess(player);
		System.out.println(player.getScore());
	}
}
