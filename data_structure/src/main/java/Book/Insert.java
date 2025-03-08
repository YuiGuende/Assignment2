package Book;
public class Insert {
public void insert(Book book) {
    root = insertRec(root, book);
}

private Node insertRec(Node root, Book book) {
    if (root == null) return new Node(book);
    if (book.bcode.compareTo(root.data.bcode) < 0)
        root.left = insertRec(root.left, book);
    else if (book.bcode.compareTo(root.data.bcode) > 0)
        root.right = insertRec(root.right, book);
    return root;
}
}