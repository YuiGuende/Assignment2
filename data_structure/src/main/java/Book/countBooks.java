package Book;

import model.Node;

public class countBooks {
    Node root;
public int countBooks() {
    return countRec(root);
}

private int countRec(Node root) {
    if (root == null) return 0;
    return 1 + countRec(root.left) + countRec(root.right);
    }
}

