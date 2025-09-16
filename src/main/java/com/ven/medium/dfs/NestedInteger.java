package com.ven.medium.dfs;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {


    private Integer value;
    private List<NestedInteger> list;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
        this.list = new ArrayList<>();
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        this.value = value;
    }

    // Return
    public boolean isInteger() {
        return value != null;
    }

    // Returns the single integer that this NestedInteger holds.
    public Integer getInteger() {
        return value;
    }

    // Sets this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        this.value = value;
        this.list = null; // clear the list if previously set
    }

    // Sets this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        if (list == null) {
            list = new ArrayList<>();
            value = null; // clear the value if previously set
        }
        list.add(ni);
    }

    // Returns the nested list that this NestedInteger holds.
    public List<NestedInteger> getList() {
        return list;
    }

}
