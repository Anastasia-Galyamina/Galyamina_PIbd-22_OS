import java.util.ArrayList;
import java.util.Random;

public class Process {
	Random rand = new Random();

	private ArrayList<Thread> Threads;

	private String description = "Процесс ";
	public int maxTime;
	public int currentTime;		
	private int threadMaxTime;
	
	
	public Process(String description, int maxTime, Priority priority) {

		this.description += description + " с приоритетом: " + priority.toString();		
		this.maxTime = maxTime * priority.getNum();		
		Threads = new ArrayList<Thread>();
		int threadsNumber = rand.nextInt(4) + 1;		
		threadMaxTime = this.maxTime/threadsNumber;

		for (int i = 0; i < threadsNumber; i++) {
			Threads.add(new Thread("" + i, rand.nextInt(10) + 1, threadMaxTime));
		}
	}
	
	public int getCount() {
		return Threads.size();
	}

	public boolean isEmpty() {
		return !Threads.size() > 0;
	}	

	public String getDescription() {
		return description;
	}

	public boolean HaveTime() {
		return maxTime > currentTime;
	}
	
	
}


