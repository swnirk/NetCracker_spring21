public class Tree {

    private Node root;
    public Tree () {
        root = null;
    }

    //Find node by his value
    public Node findNodeByValue(int value) {
        Node node = root;
        while (node.getValue() != value) {
            if (value < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    //Insert elements in tree
    public void insertNode(int value) {
        Node newNode = new Node();
        newNode.setValue(value);
        if (root == null) {
            root = newNode;
        }
        //If root isn't empty
        else {
            Node node = root;
            Node parentNode;
            while (true) {
                parentNode = node;
                if(value == node.getValue()) {
                    return;
                }
                else  if (value < node.getValue()) {
                    node = node.getLeftChild();
                    if (node == null){
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                }
                else {
                    node = node.getRightChild();
                    if (node == null) {
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    //Delete node
    public boolean deleteNode(int value) {

        Node node = root;
        Node parentNode = root;
        boolean isLeftChild = true;
        while (node.getValue() != value) {
            parentNode = node;
            if (value < node.getValue()) {
                isLeftChild = true;
                node = node.getLeftChild();
            }
            else {
                isLeftChild = false;
                node = node.getRightChild();
            }
            if (node == null)
                return false;
        }

        //Delete note without children
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            if (node == root)
                root = null;
            else if (isLeftChild)
                parentNode.setLeftChild(null);
            else
                parentNode.setRightChild(null);
        }

        //If node hasn't right kid
        else if (node.getRightChild() == null) {
            if (node == root)
                root = node.getLeftChild();
            else if (isLeftChild)
                parentNode.setLeftChild(node.getLeftChild());
            else
                parentNode.setRightChild(node.getLeftChild());
        }

        //If node hasn't left kid
        else if (node.getLeftChild() == null) {
            if (node == root)
                root = node.getRightChild();
            else if (isLeftChild)
                parentNode.setLeftChild(node.getRightChild());
            else
                parentNode.setRightChild(node.getRightChild());
        }

        //If node has both kid
        else {
            Node heir = receiveHeir(node); // find change for deleted node
            if (node == root)
                root = heir;
            else if (isLeftChild)
                parentNode.setLeftChild(heir);
            else
                parentNode.setRightChild(heir);
        }
        return true;
    }

    //Returns a node with the next value after the passed argument
    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRightChild();
        while (currentNode != null)
        {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeftChild();
        }
        if (heirNode != node.getRightChild()){
            parentNode.setLeftChild(heirNode.getRightChild());
            heirNode.setRightChild(node.getRightChild());
        }
        return heirNode;
    }

    // Right tree's order
    public void preOrder(Node node) {

        if(node == null) return;
        Node currentNode = new Node();
        System.out.println(currentNode.getValue());
        preOrder(currentNode.getLeftChild());
        preOrder(currentNode.getRightChild());
    }

    // Back tree's order
    public void postOrder(Node node) {

        if(node == null) return;
        Node currentNode = new Node();
        postOrder(currentNode.getLeftChild());
        postOrder(currentNode.getRightChild());
        System.out.println(currentNode.getValue());
    }

    // Center tree's order
    public void inOrder(Node node) {

        if (node == null) return;
        Node currentNode = new Node();
        inOrder(currentNode.getLeftChild());
        System.out.println(currentNode.getValue());
        inOrder(currentNode.getRightChild());
    }

    // Find depth of tree
    int Depth(Node node) {
        if (node == null) return (-1);

         else {
            int leftDepth = Depth(node.getLeftChild());
            int rightDepth = Depth(node.getRightChild());

            if (leftDepth > rightDepth ) return (leftDepth + 1);
            else return (rightDepth + 1);
        }
    }

}
