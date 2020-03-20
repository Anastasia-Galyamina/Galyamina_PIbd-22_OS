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
			System.out.println("����� ������� ������ 1");
			return;
		}
		while (!Processes.isEmpty()) {
			int sizeProcesses = Processes.size();
			for (int i = 0; i < sizeProcesses; i++) {
				if (Processes.get(i).HaveTime()) {
					if (!Processes.get(i).isEmpty()) {
						Processes.get(i).implementThreads();
					} else {
						System.out.println("��� ������ " + Processes.get(i).getDescription() + "  ���������");
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
		System.out.println("��� �������� ���������");
	}

	private static void getInfo() {
		for (int i = 0; i < Processes.size(); i++) {
			System.out.println(Processes.get(i).getDescription() + " �������: " + Processes.get(i).getCount());
		}
		
		System.out.println();
	}

	private static void createProcess() {		
	
		for (int i = 0; i < rand.nextInt(5) + 3; i++) {
			Processes.add(new Process("" + i, quant, Priority.values()[rand.nextInt(3)]));
		}
	}
}

