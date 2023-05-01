package org.MyList;

public interface MyList<TData> extends MyReadonlyList<TData> {
    void insert(int index);
    void erase(int index);
}
