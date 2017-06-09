package gameSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class UpdateScore {
	public ArrayList<RankTeam> rankTeam = new ArrayList<>();
	private int idCount=0;
	private Player[][] playerPool = new Player[21][10];
	private int teamPoolCount=3000;
	
	
	
	public Player eloProcess(Player testPlayer){
		//将其加入对应的队伍
		int corr = testPlayer.getScore()>6000?20:testPlayer.getScore()/300;
		rankTeam.get(corr).setFirstPlayer(testPlayer);
		int average1=0,average2=0 ;
		for (Player p:rankTeam.get(corr).getRedTeam()){
			average1 += p.getScore();
		}
		average1 /= 5;
		for (Player p:rankTeam.get(corr).getBlueTeam()){
			average2 += p.getScore();
		}
		average2 /= 5;
		//判断胜负，更新结果
		int isWin = 0;
		switch (testPlayer.getTrend()) {
		case 1:
			if (Math.random()<0.75)
				isWin = 1;
			break;
		case 0:
			if (Math.random()<0.5)
				isWin = 1;
			break;
		case -1:
			if (Math.random()<0.25)
				isWin = 1;
			break;
		default:
			break;
		}
		
		int k = 100;	//elo算法中k值
		double Ea = 1/(1+Math.pow(10, (average2-average1)/400));
		testPlayer.setScore((int)(testPlayer.getScore()+k*(isWin-Ea)));
		
		return testPlayer;
		
	}
	
	public void generateRankTeam(){
		initTeamPool();
		for (int i=0;i<21;++i){
			RankTeam rankT = new RankTeam(i, playerPool[i]);
			rankTeam.add(rankT);
		}		
		
		//测试rankTeam的分布
		File file = new File("C:/Users/Seolen/Desktop","rankTeam.txt");
		try{
			FileOutputStream out = new FileOutputStream(file);
			out.write("Rank Team Level: \r\n".getBytes());
			for (int i=0;i<rankTeam.size();++i){
				out.write(("level "+i+" ").getBytes());
				for (Player player: rankTeam.get(i).getRedTeam()){
					out.write((player.getId()+"--").getBytes());
					out.write((player.getScore()+"    ").getBytes());
				}
				out.write("\r\n\t".getBytes());
				for (Player player: rankTeam.get(i).getBlueTeam()){
					out.write((player.getId()+"--").getBytes());
					out.write((player.getScore()+"    ").getBytes());
				}
				out.write("\r\n".getBytes());
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void initTeamPool(){
		for (int i=0;i<21;++i){
			Player player1 = new Player(teamPoolCount++,(int)(i*300+Math.round(Math.random()*299)),0);
			Player player2 = new Player(teamPoolCount++,(int)(i*300+Math.round(Math.random()*299)),0);
			Player player3 = new Player(teamPoolCount++,(int)(i*300+Math.round(Math.random()*299)),0);
			Player player4 = new Player(teamPoolCount++,(int)(i*300+Math.round(Math.random()*299)),0);
			Player player5 = new Player(teamPoolCount++,(int)(i*300+Math.round(Math.random()*299)),0);
			Player player6 = new Player(teamPoolCount++,(int)(i*300+Math.round(Math.random()*299)),0);
			Player player7 = new Player(teamPoolCount++,(int)(i*300+Math.round(Math.random()*299)),0);
			Player player8 = new Player(teamPoolCount++,(int)(i*300+Math.round(Math.random()*299)),0);
			Player player9 = new Player(teamPoolCount++,(int)(i*300+Math.round(Math.random()*299)),0);
			Player player10 = new Player(teamPoolCount++,(int)(i*300+Math.round(Math.random()*299)),0);
			playerPool[i] = new Player[10];
			playerPool[i][0] = new Player();	playerPool[i][4] = new Player();	playerPool[i][7] = new Player();
			playerPool[i][1] = new Player();	playerPool[i][5] = new Player();	playerPool[i][8] = new Player();
			playerPool[i][2] = new Player();	playerPool[i][6] = new Player();	playerPool[i][9] = new Player();
			playerPool[i][3] = new Player();
			playerPool[i][0] = player1;		playerPool[i][1] = player2;		playerPool[i][2] = player3;
			playerPool[i][3] = player4;		playerPool[i][4] = player5;
			playerPool[i][5] = player6;		playerPool[i][7] = player8;		playerPool[i][9] = player10;
			playerPool[i][6] = player7;		playerPool[i][8] = player9;
		}
	}
}
