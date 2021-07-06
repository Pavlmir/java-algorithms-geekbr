package lesson6;

public class Tree {
    private Node root;

    private Node insertRecursive(Node current, Person person) {
        if (current == null) {
            return new Node(person);
        }

        if (person.getId() < current.person.getId()) {
            current.leftChild = insertRecursive(current.leftChild, person);
        } else if (person.getId() > current.person.getId()) {
            current.rightChild = insertRecursive(current.rightChild, person);
        } else {
            current.person = person;
        }
        return current;
    }

    public void insert(Person person) {
        root = insertRecursive(root, person);
    }

    private Node findRecursive(Node current, int id) {
        if (current == null) {
            return null;
        }
        if (id == current.person.getId()) {
            return current;
        } else if (id < current.person.getId()) {
            current.leftChild = findRecursive(current.leftChild, id);
        } else {
            current.rightChild = findRecursive(current.rightChild, id);
        }
        return current;
    }

    public Node find(int id) {
        return findRecursive(root, id);
    }

    private Node minRecursive(Node current) {
        if (current == null) {
            return null;
        }
        if (current.leftChild == null) {
            return current;
        } else {
            current = minRecursive(current.leftChild);
        }
        return current;
    }

    public Node min() {
        return minRecursive(root);
    }

    private Node maxRecursive(Node current) {
        if (current == null) {
            return null;
        }
        if (current.rightChild == null) {
            return current;
        } else {
            current = maxRecursive(current.rightChild);
        }
        return current;
    }

    public Node max() {
        return maxRecursive(root);
    }

    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.leftChild);
            node.display();
            traverseInOrder(node.rightChild);
        }
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traversePreOrder(Node node) {
        if (node != null) {
            node.display();
            traversePreOrder(node.leftChild);
            traversePreOrder(node.rightChild);
        }
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void copyTreeRecursion(Node node) {
        if (node != null) {
            this.insert(node.person);
            copyTreeRecursion(node.leftChild);
            copyTreeRecursion(node.rightChild);
        }
    }

    public void copyTree(Tree thatTree) {
        copyTreeRecursion(thatTree.root);
    }


    private void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.leftChild);
            traversePostOrder(node.rightChild);
            node.display();
        }
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private Node deleteRecursive(Node current, int id) {
        if (current == null) {
            return null;
        }
        if (id == current.person.getId()) {
            if (current.leftChild == null && current.rightChild == null) {
                return null;
            } else if (current.leftChild == null) {
                return current.rightChild;
            } else if (current.rightChild == null) {
                return current.leftChild;
            } else {
                Node successor = minRecursive(current.rightChild);
                current.person = successor.person;
                current.rightChild = deleteRecursive(current.rightChild, successor.person.getId());
                return current;
            }
        } else if (id < current.person.getId()) {
            current.leftChild = deleteRecursive(current.leftChild, id);
            return current;
        } else {
            current.rightChild = deleteRecursive(current.rightChild, id);
            return current;
        }
    }

    public void delete(int id) {
        deleteRecursive(root, id);
    }

}