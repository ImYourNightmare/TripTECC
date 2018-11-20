/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logic.structures;

/**
 *
 * @author Melina
 */
public class BinaryTree {
    BinTreeNode root;
    
    //Metodo auxiliar para annadir un elemento. 
    private BinTreeNode addRecursive(BinTreeNode current, int value) {
    if (current == null) { 
        return new BinTreeNode(value);
    }
    if (value < current.value) {
        current.left = addRecursive(current.left, value);
    } else{
        current.right = addRecursive(current.right, value);
    }
 
    return current;
    }
    
    public void add(int value) {
        root = addRecursive(root, value);
    }
    
    private boolean containsNodeRecursive(BinTreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value;
    }
    
    private BinTreeNode deleteRecursive(BinTreeNode current, int value) {
    if (current == null) {
        return null;
    }
 
    if (value == current.value) {
        // Node to delete found
        if (current.left == null && current.right == null) {
            return null;
        }
        
    } 
    if (value < current.value) {
        current.left = deleteRecursive(current.left, value);
        return current;
    }
    current.right = deleteRecursive(current.right, value);
    return current;
    }
}
