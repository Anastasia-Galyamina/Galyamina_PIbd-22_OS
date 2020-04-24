import java.util.ArrayList;
import java.util.Random;

public class Main {		
	
	public static void main(String[] args) {		
		Random rnd = new Random();
		int pages[] = new int[32];    // массив виртуальных страниц процесса, к которым он обращается 
		ArrayList<Record> Table = new ArrayList<>(); //таблица соответствия виртуальных адресов процесса и физических
		for(int i = 0; i < 32; i++) {
			pages[i] = rnd.nextInt(32);
			Table.add(new Record(i));
		}		
		
		MemoryManager manager = new MemoryManager();	
		
        for(int i = 0; i < pages.length; i++){ // проходим по всем виртуальным страницам процесса
        	manager.implementPage(pages[i], Table);//обрабатывает каждую страницу
        	System.out.println("обращение к адресу " + pages[i]);
	    	  
        }	

	}
}

