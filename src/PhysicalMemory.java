import java.util.ArrayList;

public class PhysicalMemory {
	private int sizeDisc = 1020;
	private int sizeSector = 4;
	private int sizePaintSectors;
	private int[] place;
	private int startSelectedFile;
	private ArrayList<Record> table= new ArrayList<Record>();
	
	public PhysicalMemory() {		
		this.sizePaintSectors = (int) Math.sqrt(Double.parseDouble(sizeDisc/sizeSector+""));
		place = new int[sizeDisc/sizeSector];	
	}	
	public int findFirstFreeCluster()
	{
		for (int i = 0; i < place.length; i++)
			if(place[i] == 0)
				return i;
		return -1;
	}	
	
	public ArrayList<Integer> getFileClusters(File file)
	{
		ArrayList<Integer> list= new ArrayList<Integer>();
		int start = file.getStartInMem();		
		while(place[start] != -1)
		{
			list.add(start);
			start = place[start];
		}
		list.add(start);
		return list;
	}

	public int allocateMemoryForFile(File file) {
		table.add(new Record(file, findFirstFreeCluster()));
		int size = file.getSize();
		int countSectors=size/sizeSector;
		int startNewFile = -1;
		int prevSector = 0;
		if(size%sizeSector>0)
			countSectors++;
		for (int i = 0; i < place.length; i++) {
			if(place[i]==0 && startNewFile == -1) {
				place[i] = -1;
				startNewFile = i;
				prevSector = i;	
				countSectors--;
				file.setStartInMem(startNewFile);
			} else if (place[i]==0) {
				place[prevSector]=i;
				prevSector = i;
				place[i]=-1;
				countSectors--;
			}
			if (countSectors==0)
				break;
		}
		return startNewFile;	
	}
	
	public void clearMemory(File file) {
		
		ArrayList<Integer> list = getFileClusters(file);
		System.out.print("Îñâîáîäèëè êëàñòåðû: ");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(i);
			place[i] = 0;
		}
		System.out.println();
		
		for (Record cellTable : table) {
			if(file == cellTable.getFile()) {
				table.remove(cellTable);
				break;
			}
		}		
	}	

	public int getStartSelectedFile() {
		return startSelectedFile;
	}

	public void setStartSelectedFile(int startSelectedFile) {
		this.startSelectedFile = startSelectedFile;
	}


	public int getSizeDisc() {
		return sizeDisc;
	}	

	public int getSizeSector() {
		return sizeSector;
	}

	public int getSizePaintSectors() {
		return sizePaintSectors;
	}


	public void setSizePaintSectors(int sizePaintSectors) {
		this.sizePaintSectors = sizePaintSectors;
	}


	public int[] getPlace() {
		return place;
	}


	public void setPlace(int[] place) {
		this.place = place;
	}


	public ArrayList<Record> getTables() {
		return table;
	}


	public void setTables(ArrayList<Record> tables) {
		this.table = tables;
	}
	
	public int getCell(int i) {
		return place[i];
	}

}
