package com.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandom {
    public static class RandomizedSet {
        ArrayList<Integer> arr;
        HashMap<Integer, Integer> map;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            arr = new ArrayList<>();
            map = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.get(val) != null){
                return false;
            }
            int i = arr.size();
            arr.add(val);
            map.put(val,i);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            Integer index = map.get(val);
            if(map.get(val) == null){
                return false;
            }
            if(arr.size() == 1){
                map.remove(val);
                arr.remove(index);
                return true;
            }
            map.remove(val);
            int size = arr.size();
            Integer last = arr.get(size-1);
            Collections.swap(arr, index,  size-1);

            // Remove last element (This is O(1))
            arr.remove(size-1);

            // Update hash table for new index of last element
            map.put(last, index);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random rand = new Random();
            int index = rand.nextInt(arr.size());
            return arr.get(index);
        }
    }
//["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
//        [[],[1],[2],[2],[],[1],[2],[]]
    public static void main(String args[]){
        RandomizedSet rand = new RandomizedSet();
        System.out.println(rand.remove(0));
        System.out.println(rand.remove(0));
        System.out.println(rand.insert(0));
        System.out.println(rand.getRandom());
        System.out.println(rand.remove(0));
        System.out.println(rand.insert(0));
        //System.out.println(rand.getRandom());
    }
}
