package lab4_nodes;
import java.util.ArrayList;

public class Memory {
	public static ArrayList<Node> nodes;
    public static int count = 128;

    public Memory() {
        nodes = new ArrayList<Node>();
        for (int i = 0; i < count; i++) {
            nodes.add(i, new Node(-1));
        }
    }
}
