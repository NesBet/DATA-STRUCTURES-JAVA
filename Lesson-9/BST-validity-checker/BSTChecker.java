import java.util.ArrayList;

public class BSTChecker {
    public static Node checkBSTValidity(Node rootNode) {
        return findViolatingNode(rootNode, null, null);
    }

    private static Node findViolatingNode(Node node, Node minNode, Node maxNode) {
        if (node == null) {
            return null;
        }

        if ((minNode != null && node.key <= minNode.key) || (maxNode != null && node.key >= maxNode.key)) {
            return node;
        }

        Node violatingNode = findViolatingNode(node.left, minNode, node);
        if (violatingNode != null) {
            return violatingNode;
        }

        violatingNode = findViolatingNode(node.right, node, maxNode);
        if (violatingNode != null) {
            return violatingNode;
        }

        violatingNode = findViolatingAncestor(node.left, node);
        if (violatingNode != null) {
            return violatingNode;
        }

        violatingNode = findViolatingAncestor(node.right, node);
        if (violatingNode != null) {
            return violatingNode;
        }

        return null;
    }

    private static Node findViolatingAncestor(Node node, Node ancestor) {
        if (node == null) {
            return null;
        }

        if (node == ancestor) {
            return node;
        }

        Node violatingNode = findViolatingAncestor(node.left, ancestor);
        if (violatingNode != null) {
            return violatingNode;
        }

        return findViolatingAncestor(node.right, ancestor);
    }

    public static void main(String[] args) {
        String input = "(10, (5, None, None), (15, None, None))";
        Node root = Node.parse(input);

        Node violatingNode = checkBSTValidity(root);

        if (violatingNode != null) {
            System.out.println("Violation at node with key: " + violatingNode.key);
        } else {
            System.out.println("No violation");
        }
    }
}
