package gameSystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//���Ե��˽�����У�ѡ�����Ĺ���
public class MatchTest1 {
	public static void main(String[] args) {
		
		GameSystem gameSystem = new GameSystem();
		gameSystem.generatePlayerData(100000);
		gameSystem.generatePlayerData(10000, 2);
		
		long startTime=System.currentTimeMillis();
		//��ӵ������
		gameSystem.addToQueue(3000);	//queue 10
		
		gameSystem.addToQueue(6100);	//queue 20
		gameSystem.addToQueue(6100);	gameSystem.addToQueue(6100);	gameSystem.addToQueue(6100);
		gameSystem.addToQueue(6100);	gameSystem.addToQueue(6100);	gameSystem.addToQueue(6100);
		gameSystem.addToQueue(6100);	gameSystem.addToQueue(6100);	gameSystem.addToQueue(6100);
		
		gameSystem.addToQueue(300);		//queue 1
		//��Ӷ������
		gameSystem.addToQueue(6008,6010); 	gameSystem.addToQueue(6008,6010);	gameSystem.addToQueue(6008,6010);
		gameSystem.addToQueue(6008,6010); 	gameSystem.addToQueue(6008,6010);	gameSystem.addToQueue(6008,6010);
		gameSystem.addToQueue(6008,6010); 	gameSystem.addToQueue(6008,6010);	
		gameSystem.addToQueue(100,700); 	gameSystem.addToQueue(200,600); 	gameSystem.addToQueue(300,500);
		gameSystem.addToQueue(400,400);		gameSystem.addToQueue(100,700); 	gameSystem.addToQueue(100,700);
		gameSystem.addToQueue(100,700); 	gameSystem.addToQueue(100,700);

		
		gameSystem.match();
		long endTime=System.currentTimeMillis();
		System.out.println("runtime = "+(endTime-startTime)+" ms");
		watchTeam();
		watchTeam2();
		watchTeam3();
		System.out.println("end");;
	}
	
	
	
	public static void watchTeam(){
		File file = new File("C:/Users/Seolen/Desktop/Test2","test001.txt");
		try{
			FileOutputStream out = new FileOutputStream(file);	
			int teamSize = GameSystem.team0.size();
			out.write(("team 0 :\t team size is: "+teamSize+"\r\n").getBytes());
			for (int i=0;i<teamSize;++i){
				out.write(("Team "+i+"\t").getBytes());
				for (int j=0; j<5;++j){
					out.write((GameSystem.team0.get(i).getRedTeam()[j]+"   ").getBytes());
				}
				out.write(("\r\n\t").getBytes());
				for (int j=0; j<5;++j){
					out.write((GameSystem.team0.get(i).getBlueTeam()[j]+"   ").getBytes());
				}
				out.write("\r\n".getBytes());
			}
			
			out.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void watchTeam2(){
		File file = new File("C:/Users/Seolen/Desktop/Test2","test002.txt");
		try{
			FileOutputStream out = new FileOutputStream(file);	
			int teamSize = GameSystem.team1.size();
			out.write(("team 1 :\t team size is: "+teamSize+"\r\n").getBytes());
			for (int i=0;i<teamSize;++i){
				out.write(("Team "+i+"\t").getBytes());
				for (int j=0; j<5;++j){
					out.write((GameSystem.team1.get(i).getRedTeam()[j]+"   ").getBytes());
				}
				out.write(("\r\n\t").getBytes());
				for (int j=0; j<5;++j){
					out.write((GameSystem.team1.get(i).getBlueTeam()[j]+"   ").getBytes());
				}
				out.write("\r\n".getBytes());
			}
			
			out.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void watchTeam3(){
		File file = new File("C:/Users/Seolen/Desktop/Test2","test003.txt");
		try{
			FileOutputStream out = new FileOutputStream(file);	
			int teamSize = GameSystem.team20.size();
			out.write(("team 20 :\t team size is: "+teamSize+"\r\n").getBytes());
			for (int i=0;i<teamSize;++i){
				out.write(("Team "+i+"\t").getBytes());
				for (int j=0; j<5;++j){
					out.write((GameSystem.team20.get(i).getRedTeam()[j]+"   ").getBytes());
				}
				out.write(("\r\n\t").getBytes());
				for (int j=0; j<5;++j){
					out.write((GameSystem.team20.get(i).getBlueTeam()[j]+"   ").getBytes());
				}
				out.write("\r\n".getBytes());
			}
			
			out.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
