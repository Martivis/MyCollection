package org.MyList;

import java.util.Collection;

public interface MyReadonlyList<TData> extends Collection<TData> {
    TData getByIndex(int index);
}
