package Book;
public class storeInOrder {
private List<Book> storeInOrder(Node root, List<Book> list) {
    if (root == null) return list;
    storeInOrder(root.left, list);
    list.add(root.data);
    storeInOrder(root.right, list);
    return list;
}

public void balanceTree() {
    List<Book> books = storeInOrder(root, new ArrayList<>());
    root = buildBalancedTree(books, 0, books.size() - 1);
}

private Node buildBalancedTree(List<Book> books, int start, int end) {
    if (start > end) return null;
    int mid = (start + end) / 2;
    Node node = new Node(books.get(mid));
    node.left = buildBalancedTree(books, start, mid - 1);
    node.right = buildBalancedTree(books, mid + 1, end);
    return node;
    }
}
