package Book;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class inOrdertoFile {
public void inOrdertoFile(String filename) throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
    inOrderToFileRec(root, bw);
    bw.close();
}

private void inOrderToFileRec(Node root, BufferedWriter bw) throws IOException {
    if (root != null) {
        inOrderToFileRec(root.left, bw);
        bw.write(root.data.toString() + "\n");
        inOrderToFileRec(root.right, bw);
        }
    }
}
