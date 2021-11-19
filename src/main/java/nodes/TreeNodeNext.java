package nodes;

public class TreeNodeNext {
    public int val;
    public TreeNodeNext left;
    public TreeNodeNext right;
    public TreeNodeNext next;

    public TreeNodeNext() {
    }

    public TreeNodeNext(int _val) {
        val = _val;
    }

    public TreeNodeNext(int _val, TreeNodeNext _left, TreeNodeNext _right, TreeNodeNext _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}
