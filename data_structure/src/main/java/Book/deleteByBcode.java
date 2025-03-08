package Book;
public deleteByCode {
public void deleteByBcode(String bcode) {
    root = deleteRec(root, bcode);
}

private Node deleteRec(Node root, String bcode) {
    if (root == null) return null;
    if (bcode.compareTo(root.data.bcode) < 0)
        root.left = deleteRec(root.left, bcode);
    else if (bcode.compareTo(root.data.bcode) > 0)
        root.right = deleteRec(root.right, bcode);
    else {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        Node minNode = findMin(root.right);
        root.data = minNode.data; // Copy dữ liệu
        root.right = deleteRec(root.right, minNode.data.bcode); // Xóa nút gốc ban đầu
    }
    return root;
}

private Node findMin(Node root) {
    while (root.left != null) root = root.left;
    return root;
    }
}

