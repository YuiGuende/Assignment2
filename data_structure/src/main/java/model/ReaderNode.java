package model;
public class ReaderNode {
    Reader data;
    ReaderNode next;
    public ReaderNode(Reader data) {
        this.data = data;
        this.next = null;
    }
}
