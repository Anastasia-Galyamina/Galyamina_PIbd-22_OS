import java.util.ArrayList;

public class PhysicalMemory {
	private int sizeDisc = 1020;
	private int sizeSector = 4;
	private int sizePaintSectors;
	private int[] place;
	private int startSelectedFile;
	private ArrayList<Record> tables= new ArrayList<Record>();
	
	public PhysicalMemory() {		
		this.sizePaintSectors = (int) Math.sqrt(Double.parseDouble(sizeDisc/sizeSector+""));
		place = new int[sizeDisc/sizeSector];	
	}	

	public int allocateMemoryForFile(File file) {
		tables.add(new Record(file,file.getStartInMem()));
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
		
		for (Record cellTable : tables) {
			if(file == cellTable.getFile()) {
				tables.remove(cellTable);
				break;
			}
		}
		int target = file.getStartInMem();
		if(place[target]!=-1) {
			clearMemory(place[target]);
		}
		place[target] = 0;
		startSelectedFile = -1;
	}

	private void clearMemory(int i) {
		if(place[i]!=-1) {
			clearMemory(place[i]);
		}
		place[i] = 0;
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
		return tables;
	}


	public void setTables(ArrayList<Record> tables) {
		this.tables = tables;
	}
	
	public int getCell(int i) {
		return place[i];
	}

}
