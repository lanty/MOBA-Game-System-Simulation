package gameSystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import javax.swing.OverlayLayout;

public class GameSystem {
	public int idCount=0;
	public static QueueHead[] playerQueue = new QueueHead[21];
	public int levelNumber;	//一共多少等级
	
	public static ArrayList<Team> team0 = new ArrayList<Team>();
	public static ArrayList<Team> team1 = new ArrayList<Team>();
	public static ArrayList<Team> team2 = new ArrayList<Team>();
	public static ArrayList<Team> team3 = new ArrayList<Team>();
	public static ArrayList<Team> team4 = new ArrayList<Team>();
	public static ArrayList<Team> team5 = new ArrayList<Team>();
	public static ArrayList<Team> team6 = new ArrayList<Team>();
	public static ArrayList<Team> team7 = new ArrayList<Team>();
	public static ArrayList<Team> team8 = new ArrayList<Team>();
	public static ArrayList<Team> team9 = new ArrayList<Team>();
	public static ArrayList<Team> team10 = new ArrayList<Team>();
	public static ArrayList<Team> team11 = new ArrayList<Team>();
	public static ArrayList<Team> team12 = new ArrayList<Team>();
	public static ArrayList<Team> team13 = new ArrayList<Team>();
	public static ArrayList<Team> team14 = new ArrayList<Team>();
	public static ArrayList<Team> team15 = new ArrayList<Team>();
	public static ArrayList<Team> team16 = new ArrayList<Team>();
	public static ArrayList<Team> team17 = new ArrayList<Team>();
	public static ArrayList<Team> team18 = new ArrayList<Team>();
	public static ArrayList<Team> team19 = new ArrayList<Team>();
	public static ArrayList<Team> team20 = new ArrayList<Team>();
	
	//generate all levels of players' data
	public  void generatePlayerData(int totalPlayerNumber){
		double[] percent = generatePercentArray("dota");
		levelNumber = percent.length;
		for (int i=0;i<levelNumber;++i){
			Vector<Player> queue = new Vector();
			int number = (int)Math.floor(totalPlayerNumber/100*percent[i]);
			for (int j=0;j<number;++j,++idCount){
				queue.add(new Player(idCount, 300*i, 0));
			}
			playerQueue[i] = new QueueHead();
			playerQueue[i].setCurrentQueue(queue);			
		}
		/*
		//测试部分
		File file = new File("C:/Users/Seolen/Desktop","test001.txt");
		try{
			FileOutputStream out = new FileOutputStream(file);	
			
			for (int i=0;i<levelNumber;++i){
				out.write("player queue ".getBytes());
				out.write((i+"\r\n").getBytes());
				for (Player player: playerQueue[i].getCurrentQueue() ){
					out.write((player.getId()+"\t").getBytes());
					out.write("    ".getBytes());
				}
			}
			out.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
	}
	public  void generatePlayerData(int totalPlayerNumber, int basicPlayerNumber){	//basicPlayerNumber是多人组队的数目，如2人：2
		double[] percent = generatePercentArray("dota");
		levelNumber = percent.length;
		for (int i=0;i<levelNumber;++i){
			Vector<Player> queue = new Vector();
			int number = (int)Math.floor(totalPlayerNumber/100*percent[i]);
			for (int j=0;j<number;++j,++idCount){
				queue.add(new Player(idCount, 300*i, 0));
			}
			playerQueue[i].setDoubleQueue(queue);
			playerQueue[i].setHasDouble(true);
		}
	}
	
	//generate percent of total numbers
	public double[] generatePercentArray(String str){
		if (str.equals("dota") || str.equals("Dota")){
			double percent[] = {0.63, 0.86, 1.46,2.45,3.25,4.24,6.28,7.66,9.15,11.93
					,12.5,11.22,12.78,4.99,5.07,2.38,1.87,0.62,0.28,0.25,0.13};
			return percent;
		}
		
		return null;
	}
	
	//match teammates, add you to wait queue
	public void addToQueue(int score){
		Player player = new Player(idCount, score, 0);
		if (score > 6000){
			playerQueue[20].getCurrentQueue().add(player);
		}else{
			playerQueue[score/300].getCurrentQueue().add(player);
		}			
		idCount++;
	}

	public void addToQueue(int score, int score2){	//两人组队加入队列
		if ((score>6000 || score2 > 6000) || (score/300 == score2/300)){	//如果两人水平相同
			Player player = new Player(idCount, score, 0);
			if (score > 6000){
				playerQueue[20].getDoubleQueue().add(player);
				if (!playerQueue[20].isHasDouble())	playerQueue[20].setHasDouble(true);
			}else{
				playerQueue[score/300].getCurrentQueue().add(player);
				if (!playerQueue[score/300].isHasDouble())	playerQueue[score/300].setHasDouble(true);
			}			
			idCount++;
		}else{
			Player player = new Player(idCount, (score+score2)/2, 0);
			player.setLeastScore(score>score2?score2:score);
			playerQueue[(score+score2)/600].getCurrentQueue().add(player);
			if (!playerQueue[(score+score2)/600].isHasDouble())	playerQueue[(score+score2)/600].setHasDouble(true);
			idCount++;
		}		
		
	}
		
	//match system
	public void match(){
		Thread thread[] = new Thread[21];
		
		for(int i=0;i<21;++i){
			MatchThread matchThread = new MatchThread();
			matchThread.setValueI(i);
			thread[i] = new Thread(matchThread);
			thread[i].start();
		}
	}
}




