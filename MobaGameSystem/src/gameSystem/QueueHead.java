package gameSystem;
import java.util.Vector;

//QueueHead是各个队列的头对象，其中有队列的各种信息：所有id，当前匹配情况等
public class QueueHead {
	private Vector<Player> currentQueue;
	private int currentNotMatched = 0;
	public QueueHead(){}
	public Vector<Player> getCurrentQueue() {
		return currentQueue;
	}
	public void setCurrentQueue(Vector<Player> currentQueue) {
		this.currentQueue = currentQueue;
	}
	public int getCurrentNotMatched() {
		return currentNotMatched;
	}
	public void setCurrentNotMatched(int currentNotMatched) {
		this.currentNotMatched = currentNotMatched;
	}
	
	private boolean hasDouble = false;
	private boolean hasThree = false;
	private boolean hasFour = false;
	private boolean hasFive = false;
	private Vector<Player> doubleQueue;	
	private Vector<Player> threeQueue;	
	private Vector<Player> fourQueue;	
	private Vector<Player> fiveQueue;
	public boolean isHasDouble() {
		return hasDouble;
	}
	public void setHasDouble(boolean hasDouble) {
		this.hasDouble = hasDouble;
	}
	public boolean isHasThree() {
		return hasThree;
	}
	public void setHasThree(boolean hasThree) {
		this.hasThree = hasThree;
	}
	public boolean isHasFour() {
		return hasFour;
	}
	public void setHasFour(boolean hasFour) {
		this.hasFour = hasFour;
	}
	public boolean isHasFive() {
		return hasFive;
	}
	public void setHasFive(boolean hasFive) {
		this.hasFive = hasFive;
	}
	public Vector<Player> getDoubleQueue() {
		return doubleQueue;
	}
	public void setDoubleQueue(Vector<Player> doubleQueue) {
		this.doubleQueue = doubleQueue;
	}
	public Vector<Player> getThreeQueue() {
		return threeQueue;
	}
	public void setThreeQueue(Vector<Player> threeQueue) {
		this.threeQueue = threeQueue;
	}
	public Vector<Player> getFourQueue() {
		return fourQueue;
	}
	public void setFourQueue(Vector<Player> fourQueue) {
		this.fourQueue = fourQueue;
	}
	public Vector<Player> getFiveQueue() {
		return fiveQueue;
	}
	public void setFiveQueue(Vector<Player> fiveQueue) {
		this.fiveQueue = fiveQueue;
	}
	
	
}
