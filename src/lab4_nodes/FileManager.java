package lab4_nodes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileManager {
	public ArrayList<File> Files = new ArrayList<File>();
    private int chsize;
    int fileId;    
    private int freeMemory = Memory.count;
    private ArrayList<Node> nodes = new ArrayList<Node>();;

    public void CreateFile(int size, String name) {
        chsize = 0;
        fileId = Files.size();
        if (size > freeMemory) {
            MainWindow.textAreaWindow.append("Невозможно добавить файл! \n");
            JOptionPane.showMessageDialog(null, "Недостаточно памяти!");
            return;
        }
        else {
            File file = new File(fileId, size);
            for (int i = 0; i <= Memory.count; i++) {
                if (size > chsize) {
                    if (Memory.nodes.get(i).getId() != -1) {
                        while (Memory.nodes.get(i).getId() != -1) {
                            i++;
                        }
                    }
                    int fileId = file.getId();
                    addNode(Memory.nodes.get(i), fileId);
                    freeMemory--;
                    chsize++;
                }
                if (size == chsize) {
                    Files.add(fileId, file);
                    MainWindow.textAreaWindow.append("Добавлен файл с именем "+name+" с №" + fileId + "\n");
                    MainWindow.textAreaWindow.append("Свободно памяти:" + freeMemory + "\n");
                    return;
                }
            }
        }
    }   
    
    public void DeleteFile(int id) {
        if (Files.get(id) == null) {
            MainWindow.textAreaWindow.append("Данного файла не сущетвует! \n");
            JOptionPane.showMessageDialog(null, "Данного файла не сущетвует!");
            return;
        } else {
            freeMemory = freeMemory + Files.get(id).fileSize();
            removeNodes(id);
            MainWindow.textAreaWindow.append("Удалён файл с именем "+MainWindow.textId.getName()+" с № " + MainWindow.textId.getText() + "\n");
        }
        MainWindow.textAreaWindow.append("Свободно памяти:" + freeMemory + "\n");

    }

    public void ChoiceFile(int id) {
        if (Files.get(id) == null) {
            MainWindow.textAreaWindow.append("Данного файла не сущетвует! \n");
            JOptionPane.showMessageDialog(null, "Данного файла не сущетвует!");
            return;
        } else {
            for (int i=0; i<nodes.size(); i++) {
                Node node= nodes.get(i);
                node.setSelectFlag(true);
            }
        }
    }

    public void cancelChoiceFile() {
        for(int j=0; j<nodes.size(); j++) {
            nodes.get(j).setSelectFlag(false);
        }
    }
    public void addNode(Node node, int fileid) {
        nodes.add(node);
    }

    public void removeNodes(int fileId) {
        for(int i=0; i<nodes.size(); i++) {
            if (nodes.get(i).getId() == fileId) {
                nodes.get(i).setNode(-1);
            }
        }
        nodes.clear();
    }
}
