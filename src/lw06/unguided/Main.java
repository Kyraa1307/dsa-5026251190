package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        String[] numbers = read.nextLine().split(" ");
        int target = Integer.parseInt(read.nextLine().trim());

        BinarySearchTree tree = new BinarySearchTree();
        for(String number : numbers){
            tree.insert(Integer.parseInt(number));
        }

        System.out.print("Preorder : ");
        tree.preOrder();
        System.out.print("Inorder : ");
        tree.inOrder();
        System.out.print("Postorder : ");
        tree.postOrder();
        System.out.println("Search " + target + " : " + tree.search(target));
        System.out.println("Minimum : " + tree.findMin());
        System.out.println("Maximum : " + tree.findMax());

        read.close();
    }
}