import java.util.ArrayList;
import java.util.Random;

public class Main {
	private static ArrayList<Process> Processes = new ArrayList<Process>();
	private static Random rand = new Random();
	private static int quant = 10;

	public static void main(String[] args) {
		createProcess();
		getInfo();
		Implement();
	}

	private static void Implement() {
		if (quant < 1) {
			System.out.println("Квант времени меньше 1");
			return;
		}
		while (!Processes.isEmpty()) {
			int sizeProcesses = Processes.size();
			for (int i = 0; i < sizeProcesses; i++) {
				if (Processes.get(i).HaveTime()) {
					if (!Processes.get(i).isEmpty()) {
						Processes.get(i).implementThreads();
					} else {
						System.out.println("Все потоки " + Processes.get(i).getDescription() + "  выполнены");
						Processes.remove(i);
						sizeProcesses = Processes.size();
						i--;
					}
				} else {
					Processes.remove(i);
					sizeProcesses = Processes.size();
					i--;
				}
			}
		}
		System.out.println("Все процессы выполнены");
	}

	private static void getInfo() {
		for (int i = 0; i < Processes.size(); i++) {
			System.out.println(Processes.get(i).getDescription() + " Потоков: " + Processes.get(i).getCount());
		}
		
		System.out.println();
	}

	private static void createProcess() {		
	
		for (int i = 0; i < rand.nextInt(5) + 3; i++) {
			Processes.add(new Process("" + i, quant, Priority.values()[rand.nextInt(3)]));
		}
		public void implementThreads() {
		if (!(maxTime > 0)) {
			System.out.println("Выделенный квант времени меньше 1");
			System.exit(0);
		}
		System.out.println();
		System.out.println(getDescription() + "  Время макс: " + maxTime);		
		int currentThreadsCount = Threads.size();	
			
		for (int curThreadNum = 0; curThreadNum < currentThreadsCount; curThreadNum++) {			
			Thread thread = Threads.get(curThreadNum);			
			while (thread.needTime()) {
					if(thread.haveTime()) {
						thread.executeThread();		
						currentTime++;
					}
					else {
						System.out.println("Максимальное время " + getDescription() + " истекло");						
						break;
					}
				}				
				System.out.println(thread.getDescription() + " завершен");				
				Threads.remove(curThreadNum);
				currentThreadsCount --;
		}
	}
}

