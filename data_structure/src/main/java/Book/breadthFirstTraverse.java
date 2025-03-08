package Book;

import java.util.LinkedList;
import java.util.Queue;
import model.Node;

public class breadthFirstTraverse {
    public void breadthFirstTraverse(Node root) {
    if (root == null) return;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        Node current = queue.poll();
        System.out.println(current.data);
        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
    }
}
}
