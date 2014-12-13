package com.company.samples.algorithms;

/**
 * Created by tiblot on 12/12/2014.
 */
public class BinaryTree {

    Node root = null;

    public BinaryTree(){};


    public void insertItem(int item){
        Node addMe = new Node(item, null, null);

        if(root == null)
            root = addMe;
        else{

            // Traverse the tree, starting with root
            Node current = root;

            while(true){
                // if new item is less, move to left side
                if(item < current.data){

                    // if current has no left, we found the insert loc
                    if(current.left == null) {
                        current.left = addMe;
                        return;
                    }

                    // if current has a left, move current to left
                    current = current.left;

                }
                // if new item is greater, move to right side
                else{

                    // if the current has no right, we found the insert loc
                    if(current.right == null){
                        current.right = addMe;
                        return;
                    }

                    // if current has a right side, move current to it
                    current = current.right;

                }
            }
        }
    }

    public Node findItemIterative(int item, Node current){

        // if empty tree or root is the item, just return it or null
        if (current.data == item || current == null)
                return current;
        else{
            // root was not it
            while(current != null){
                if(current.data == item)
                    return current;

                else if(item < current.data){
                    current = current.left;
                }

                else if(item > current.data){
                    current = current.right;
                }
            }

            // if made it here, we didnt find it
            return null;
        }
    }

    public Node findItemRecursive(int item, Node current){

        System.out.println("Currently in:" + current.data);
        // if empty tree or root is the item, return it
        if(current == null || current.data == item)
            return current;

        else if(item < current.data){
            return findItemRecursive(item, current.left);
        }

        //(item > current.data)
        else{
            return findItemRecursive(item, current.right);
        }

    }

    public static void main(String [] args){
        BinaryTree bt = new BinaryTree();
        bt.insertItem(1);
        bt.insertItem(64);
        bt.insertItem(433);

        Node found = bt.findItemRecursive(4, bt.root);
        System.out.println(found.data);

        found = bt.findItemIterative(4, bt.root);
        System.out.println(found.data);
    }
}


class Node{

    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}


