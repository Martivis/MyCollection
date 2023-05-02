package org.MyList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTests {

    @Test
    void add_OneValue() throws NoSuchFieldException, IllegalAccessException {
        // arrange
        var list = new MyListImpl();
        var value = 3;

        // act
        list.add(value);

        // assert
        var expected = new int[] { value, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        var actual = getArray(list);
        assertArrayEquals(expected, actual);
    }

    @Test
    void add_SeveralValues() throws NoSuchFieldException, IllegalAccessException {
        // arrange
        var list = new MyListImpl();

        // act
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }

        // assert
        var expected = new int[] { 0, 1, 2, 0, 0, 0, 0, 0, 0, 0 };
        var actual = getArray(list);
        assertArrayEquals(expected, actual);
    }

    @Test
    void add_NearOverflow() throws NoSuchFieldException, IllegalAccessException {
        // arrange
        var list = new MyListImpl();

        // act
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // assert
        var expected = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        var actual = getArray(list);
        assertArrayEquals(expected, actual);
    }

    @Test
    void add_Overflow() throws NoSuchFieldException, IllegalAccessException {
        // arrange
        var list = new MyListImpl();

        // act
        for (int i = 0; i < 12; i++) {
            list.add(i);
        }

        // assert
        var expected = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 0, 0 };
        var actual = getArray(list);
        assertArrayEquals(expected, actual);
    }

    int[] getArray(MyListImpl list) throws NoSuchFieldException, IllegalAccessException {
        var arrayField = MyListImpl.class.getDeclaredField("array");
        arrayField.setAccessible(true);
        return (int[])arrayField.get(list);
    }

}