import java.util.ArrayList;
import java.util.Random;

public class Process {
	Random rand = new Random();

	private ArrayList<Thread> Threads;

	private String description = "Процесс ";
	private int maxTime;
	private int currentTime;		
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
		if (Threads.size() > 0)
			return false;
		return true;
	}	

	public String getDescription() {
		return description;
	}

	public boolean HaveTime() {
		if (maxTime > currentTime) {
			return true;
		} else {
			return false;
		}
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


