package org.MyList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EraseTests {
    @Test
    void erase_IndexOutOfBounds_ThrowsException() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(4);

        var array = new int[] { 1, 2, 3, 0 };
        setFieldValue(list, "array", array);

        var elementsCount = 3;
        setFieldValue(list, "elementsCount", elementsCount);

        var index = 3;

        // act
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.erase(index);
        });

        // assert
        var expectedArray = new int[] { 1, 2, 3, 0 };
        var actualArray = (int[])getFieldValue(list, "array");

        var expectedElementsCount = 3;
        var actualElementsCount = getFieldValue(list, "elementsCount");

        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedElementsCount, actualElementsCount);
    }

    @Test
    void erase_NegativeIndex_ThrowsException() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(4);

        var array = new int[] { 1, 2, 3, 0 };
        setFieldValue(list, "array", array);

        var elementsCount = 3;
        setFieldValue(list, "elementsCount", elementsCount);

        var index = -1;

        // act
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.erase(index);
        });

        // assert
        var expectedArray = new int[] { 1, 2, 3, 0 };
        var actualArray = (int[])getFieldValue(list, "array");

        var expectedElementsCount = 3;
        var actualElementsCount = getFieldValue(list, "elementsCount");

        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedElementsCount, actualElementsCount);
    }

    @Test
    void erase_EndIndex() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(4);

        var array = new int[] { 1, 2, 3, 0 };
        setFieldValue(list, "array", array);

        var elementsCount = 3;
        setFieldValue(list, "elementsCount", elementsCount);

        var index = 2;

        // act
        list.erase(index);

        // assert
        var expectedArray = new int[] { 1, 2, 3, 0 };
        var actualArray = (int[])getFieldValue(list, "array");

        var expectedElementsCount = 2;
        var actualElementsCount = getFieldValue(list, "elementsCount");

        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedElementsCount, actualElementsCount);
    }

    @Test
    void erase_MiddleIndex() throws NoSuchFieldException, IllegalAccessException {
        // assert
        var list = new MyListImpl(4);

        var array = new int[] { 1, 2, 3, 0 };
        setFieldValue(list, "array", array);

        var elementsCount = 3;
        setFieldValue(list, "elementsCount", elementsCount);

        var index = 1;

        // act
        list.erase(index);

        // assert
        var expectedArray = new int[] { 1, 3, 3, 0 };
        var actualArray = (int[])getFieldValue(list, "array");

        var expectedElementsCount = 2;
        var actualElementsCount = getFieldValue(list, "elementsCount");

        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedElementsCount, actualElementsCount);
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
