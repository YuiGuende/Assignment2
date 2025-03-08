package Book;

import model.Node;

public class searchByBcode {
    public Book searchByBcode(Node root, String bcode) {
        return searchRec(root, bcode);
    }

    private Book searchRec(Node root, String bcode) {
        if (root == null) return null;
        if (root.data instanceof Book && ((Book) root.data).bcode.equals(bcode)) {
            return (Book) root.data;
        }
        if (bcode.compareTo(((Book) root.data).bcode) < 0) {
            return searchRec(root.left, bcode);
        }
        return searchRec(root.right, bcode);
    }
}
