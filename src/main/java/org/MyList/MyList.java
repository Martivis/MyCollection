package org.MyList;

public interface MyList extends MyReadonlyList {
    void insert(int value, int index);
    void erase(int index);
    int find(Object o);
}
