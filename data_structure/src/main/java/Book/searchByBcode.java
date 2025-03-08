package Book;
public class searchByBcode {
public Book searchByBcode(String bcode) {
    return searchRec(root, bcode);
}

private Book searchRec(Node root, String bcode) {
    if (root == null) return null;
    if (root.data.bcode.equals(bcode)) return root.data;
    if (bcode.compareTo(root.data.bcode) < 0)
        return searchRec(root.left, bcode);
    return searchRec(root.right, bcode);
    }
}