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
public class BinTreeNode {
    int value;
    BinTreeNode left;
    BinTreeNode right;
 
    BinTreeNode(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
