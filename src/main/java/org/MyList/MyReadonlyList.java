package org.MyList;

import java.util.Collection;

public interface MyReadonlyList extends Collection {
    int getByIndex(int index);
    int capacity();
}
