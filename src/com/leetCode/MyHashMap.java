package com.leetCode;

/*
Design a HashMap without using any built-in hash table libraries.
To be specific, your design should include these functions:
put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 */

import java.util.ArrayList;

//using ArrayLists super slow 352ms
public class MyHashMap {

    /** Initialize your data structure here. */
    private ArrayList<Integer> keyList;
    private ArrayList<Integer> valueList;
    public MyHashMap() {
        keyList = new ArrayList<>();
        valueList = new ArrayList<>();
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(this.keyList.contains(key)){
            int index = this.keyList.indexOf(key);
            this.valueList.set(index,value);
            return;
        }
        this.keyList.add(key);
        this.valueList.add(value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = this.keyList.indexOf(key);
        return index == -1 ? -1 : this.valueList.get(index);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = this.keyList.indexOf(key);
        if(index != -1){
            this.keyList.remove(index);
            this.valueList.remove(index);
        }

    }
}

class UtilizeMyHashMap{
    public static void main(String args[]){
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));            // returns 1
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2));            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */