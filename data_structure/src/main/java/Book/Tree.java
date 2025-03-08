/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Book;

/**
 *
 * @author LEGION
 * @param <T>
 */
public class Tree<T extends Comparable<T>> {

    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void insert(T data) {
        root = insert(data, root);
    }

    private Node<T> insert(T data, Node<T> node) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(insert(data, node.getRightChild()));
        } else {
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }
    
    public boolean search(T data) {
        return search(root, data);
    }

    private boolean search(Node<T> node, T data) {
        if (node == null) {
            return false;
        }
        if (data.compareTo(node.getData()) < 0) {
            return search(node.getLeftChild(), data);
        } else if (data.compareTo(node.getData()) > 0) {
            return search(node.getRightChild(), data);
        } else {
            return true;
        }
    }

    public void delete(T data) {
        root = delete(root, data);
    }

    private Node<T> delete(Node<T> node, T data) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(node.getLeftChild(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(node.getRightChild(), data));
        } else {
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }
            Node<T> temp = findMin(node.getRightChild());
            node.setData(temp.getData());
            node.setRightChild(delete(node.getRightChild(), temp.getData()));
        }
        updateHeight(node);
        return applyRotation(node);
    }

    private Node<T> findMin(Node<T> node) {
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node;
    }

    private void updateHeight(Node<T> node) {
        int height = Math.max(
                height(node.getLeftChild()),
                height(node.getRightChild())
        );
        node.setHeight(height + 1);
    }

    private int height(Node<T> node) {
        return node == null ? 0 : node.getHeight();
    }

    private Node<T> applyRotation(Node<T> node) {
        int balance = balance(node);

        if (balance > 1) {//left heavy
            if (balance(node.getLeftChild()) < 0) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            return rotateRight(node);
        }
        if (balance < -1) {// right heavy
            if (balance(node.getRightChild()) > 0) {
                node.setRightChild(rotateRight(node.getRightChild()));
            }
            return rotateLeft(node);
        }

        return node;
    }

    private int balance(Node<T> node) {
        return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightNode = node.getRightChild();
        Node<T> centerNode = rightNode.getLeftChild();
        rightNode.setLeftChild(node);
        node.setRightChild(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;

    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftNode = node.getLeftChild();
        Node<T> centerNode = leftNode.getRightChild();
        leftNode.setRightChild(node);
        node.setLeftChild(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    public void inOrderTraversal() {
        inOrderTraversalHelper(root);
    }

    private void inOrderTraversalHelper(Node<T> node) {
        if (node == null) {
            return;
        }
        inOrderTraversalHelper(node.getLeftChild());
        visit(node);
        inOrderTraversalHelper(node.getRightChild());
    }

    private void visit(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
    }
}
