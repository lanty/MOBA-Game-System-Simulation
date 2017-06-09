package gameSystem;

import java.util.Vector;



public class Player {
	
	private int id;
	private int score;
	private int trend;		//-1:"descending" or 1: "ascending" or 0:stable
	public Vector<Player> vector;
	
	private int leastScore;	//组队时最低的那个分数
	
	public int getLeastScore() {
		return leastScore;
	}
	public void setLeastScore(int leastScore) {
		this.leastScore = leastScore;
	}
	public int teamId;
	
	public Player() {
	}
	public Player(int id, int score, int trend){
		this.id = id;
		this.score = score;
		this.trend = trend;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTrend() {
		return trend;
	}
	public void setTrend(int trend) {
		this.trend = trend;
	}
	
	
}
