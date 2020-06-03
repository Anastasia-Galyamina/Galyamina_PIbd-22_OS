package lab4_nodes;

public class Node {
	
	private int nodeId;
    private boolean selectFlag;
    private Node node;

    public Node(int nodeId) {
        this.nodeId = nodeId;
    }

    public void setNode(int knotId) {
        node = new Node(knotId);
    }

    public int getId() {
        return nodeId;
    }

    public Node nextNode() {
        return node;
    }

    public boolean getSelectFlag() {
        return selectFlag;
    }

    public void setSelectFlag(boolean selectFlag) {
        this.selectFlag = selectFlag;
    }
}
