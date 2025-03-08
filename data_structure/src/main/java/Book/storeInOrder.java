package Book;

import java.util.ArrayList;
import java.util.List;
import model.Node;

public class storeInOrder {
private List<Book> storeInOrder(Node root, List<Book> list) {
    if (root == null) return list;
    storeInOrder(root.left, list);
    list.add((Book) root.data);
    storeInOrder(root.right, list);
    return list;
}

public void balanceTree(Node root) {
    List<Book> books = storeInOrder(root, new ArrayList<>());
    root = buildBalancedTree(books, 0, books.size() - 1);
}

private Node buildBalancedTree(List<Book> books, int start, int end) {
    if (start > end) return null;
    int mid = (start + end) / 2;
    Node node = new Node((Comparable) books.get(mid));
    node.left = buildBalancedTree(books, start, mid - 1);
    node.right = buildBalancedTree(books, mid + 1, end);
    return node;
    }
}
