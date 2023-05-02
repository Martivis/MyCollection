package org.MyList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InsertTests {
    @Test
    void insert_IndexGreaterThanCount_ThrowsException() {
        // assert
        var list = new MyListImpl(2);
        var value = 5;
        var index = 1;

        // act
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insert(value, index);
        });

        // assert
        var expectedMessage = "Index out of range";
        var actualMessage = ex.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void insert_NegativeIndex_ThrowsException() {
        // assert
        var list = new MyListImpl(2);
        var value = 5;
        var index = -1;

        // act
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insert(value, index);
        });

        // assert
        var expectedMessage = "Index out of range";
        var actualMessage = ex.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
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
        var actual = getArray(list);

        assertArrayEquals(expected, actual);
    }

    @Test
    void insert_EndIndex() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(2);

        var array = new int[] { 5, 0 };
        setArray(list, array);

        var elementsCount = 1;
        setElementsCount(list, elementsCount);

        var value = 3;
        var index = 1;

        // act
        list.insert(value, index);

        // assert
        var expected = new int[] { 5, 3 };
        var actual = getArray(list);

        assertArrayEquals(expected, actual);
    }

    @Test
    void insert_ZeroIndex() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(3);

        var array = new int[] { 5, 1, 0 };
        setArray(list, array);

        var elementsCount = 2;
        setElementsCount(list, elementsCount);

        var value = 3;
        var index = 0;

        // act
        list.insert(value, index);

        // assert
        var expected = new int[] { 3, 5, 1 };
        var actual = getArray(list);

        assertArrayEquals(expected, actual);
    }

    @Test
    void insert_MiddleIndex() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(3);

        var array = new int[] { 5, 1, 0 };
        setArray(list, array);

        var elementsCount = 2;
        setElementsCount(list, elementsCount);

        var value = 3;
        var index = 1;

        // act
        list.insert(value, index);

        // assert
        var expected = new int[] { 5, 3, 1 };
        var actual = getArray(list);

        assertArrayEquals(expected, actual);
    }

    @Test
    void insert_Overflow() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(3);

        var array = new int[] { 5, 1, 7 };
        setArray(list, array);

        var elementsCount = 3;
        setElementsCount(list, elementsCount);

        var value = 3;
        var index = 1;

        // act
        list.insert(value, index);

        // assert
        var expected = new int[] { 5, 3, 1, 7 };
        var actual = getArray(list);

        assertArrayEquals(expected, actual);
    }

    int[] getArray(MyListImpl list) throws NoSuchFieldException, IllegalAccessException {
        var arrayField = MyListImpl.class.getDeclaredField("array");
        arrayField.setAccessible(true);
        return (int[])arrayField.get(list);
    }

    void setArray(MyListImpl list, int[] array) throws NoSuchFieldException, IllegalAccessException {
        var arrayField = MyListImpl.class.getDeclaredField("array");
        arrayField.setAccessible(true);
        arrayField.set(list, array);
    }

    void setElementsCount(MyListImpl list, int value) throws NoSuchFieldException, IllegalAccessException {
        var arrayField = MyListImpl.class.getDeclaredField("elementsCount");
        arrayField.setAccessible(true);
        arrayField.set(list, value);
    }
}
