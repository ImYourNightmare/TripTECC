package com.structures.tree;

import java.util.Comparator;

class Composition implements Comparator<Integer>
{
   public int compare(Integer x, Integer y)
   {
        return y-x;
   }
}