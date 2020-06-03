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
            MainWindow.textAreaWindow.append("���������� �������� ����! \n");
            JOptionPane.showMessageDialog(null, "������������ ������!");
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
                    MainWindow.textAreaWindow.append("�������� ���� � ������ "+name+" � �" + fileId + "\n");
                    MainWindow.textAreaWindow.append("�������� ������:" + freeMemory + "\n");
                    return;
                }
            }
        }
    }   
    
    public void DeleteFile(int id) {
        if (Files.get(id) == null) {
            MainWindow.textAreaWindow.append("������� ����� �� ���������! \n");
            JOptionPane.showMessageDialog(null, "������� ����� �� ���������!");
            return;
        } else {
            freeMemory = freeMemory + Files.get(id).fileSize();
            removeNodes(id);
            MainWindow.textAreaWindow.append("����� ���� � ������ "+MainWindow.textId.getName()+" � � " + MainWindow.textId.getText() + "\n");
        }
        MainWindow.textAreaWindow.append("�������� ������:" + freeMemory + "\n");

    }

    public void ChoiceFile(int id) {
        if (Files.get(id) == null) {
            MainWindow.textAreaWindow.append("������� ����� �� ���������! \n");
            JOptionPane.showMessageDialog(null, "������� ����� �� ���������!");
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
