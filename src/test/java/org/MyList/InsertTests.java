package org.MyList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InsertTests {
    @Test
    void insert_IndexGreaterThanCount_ThrowsException() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(2);
        var value = 5;
        var index = 1;

        // act
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insert(value, index);
        });

        // assert
        var expected = new int[] { 0, 0 };
        int[] actual = getFieldValue(list, "array");

        assertArrayEquals(expected, actual);
    }

    @Test
    void insert_NegativeIndex_ThrowsException() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(2);
        var value = 5;
        var index = -1;

        // act
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insert(value, index);
        });

        // assert
        var expected = new int[] { 0, 0 };
        int[] actual = getFieldValue(list, "array");

        assertArrayEquals(expected, actual);
    }

    @Test
    void insert_EmptyList() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(2);
        var value = 5;
        var index = 0;

        // act
        list.insert(value, index);

        // assert
        var expected = new int[] { 5, 0 };
        int[] actual = getFieldValue(list, "array");

        assertArrayEquals(expected, actual);
    }

    @Test
    void insert_EndIndex() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(2);

        var array = new int[] { 5, 0 };
        setFieldValue(list, "array", array);

        var elementsCount = 1;
        setFieldValue(list, "elementsCount", elementsCount);

        var value = 3;
        var index = 1;

        // act
        list.insert(value, index);

        // assert
        var expected = new int[] { 5, 3 };
        int[] actual = getFieldValue(list, "array");

        assertArrayEquals(expected, actual);
    }

    @Test
    void insert_ZeroIndex() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(3);

        var array = new int[] { 5, 1, 0 };
        setFieldValue(list, "array", array);

        var elementsCount = 2;
        setFieldValue(list, "elementsCount", elementsCount);

        var value = 3;
        var index = 0;

        // act
        list.insert(value, index);

        // assert
        var expected = new int[] { 3, 5, 1 };
        int[] actual = getFieldValue(list, "array");

        assertArrayEquals(expected, actual);
    }

    @Test
    void insert_MiddleIndex() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(3);

        var array = new int[] { 5, 1, 0 };
        setFieldValue(list, "array", array);

        var elementsCount = 2;
        setFieldValue(list, "elementsCount", elementsCount);

        var value = 3;
        var index = 1;

        // act
        list.insert(value, index);

        // assert
        var expected = new int[] { 5, 3, 1 };
        int[] actual = getFieldValue(list, "array");

        assertArrayEquals(expected, actual);
    }

    @Test
    void insert_Overflow() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(3);

        var array = new int[] { 5, 1, 7 };
        setFieldValue(list, "array", array);

        var elementsCount = 3;
        setFieldValue(list, "elementsCount", elementsCount);

        var value = 3;
        var index = 1;

        // act
        list.insert(value, index);

        // assert
        var expected = new int[] { 5, 3, 1, 7 };
        int[] actual = getFieldValue(list, "array");

        assertArrayEquals(expected, actual);
    }

    <TData> TData getFieldValue(MyListImpl list, String field) throws NoSuchFieldException, IllegalAccessException {
        var arrayField = MyListImpl.class.getDeclaredField(field);
        arrayField.setAccessible(true);
        return (TData)arrayField.get(list);
    }

    <TData> void setFieldValue(MyListImpl list, String field, TData value)
            throws NoSuchFieldException, IllegalAccessException {
        var arrayField = MyListImpl.class.getDeclaredField(field);
        arrayField.setAccessible(true);
        arrayField.set(list, value);
    }
}
