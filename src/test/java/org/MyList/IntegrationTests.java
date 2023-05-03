package org.MyList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTests {
    @Test
    void Find_Test() {
        // arrange
        var list = new MyListImpl();
        var value = 5;

        var expected = 4;

        // act
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(value);

        var actual = list.find(value);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void ContainsTest_true() {
        // arrange
        var list = new MyListImpl();
        var value = 3;

        var expected = true;

        // act
        list.add(1);
        list.add(2);
        list.add(value);
        list.add(4);
        list.add(5);

        var actual = list.contains(value);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void ContainsTest_false() {
        // arrange
        var list = new MyListImpl();
        var value = 6;

        var expected = false;

        // act
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        var actual = list.contains(value);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void ContainsTest_ZeroValue() {
        // arrange
        var list = new MyListImpl();
        var value = 0;

        var expected = false;

        // act
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        var actual = list.contains(value);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void RetainsAllTest() {
        // arrange
        var list = new MyListImpl();
        var source = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };
        var filter = new ArrayList<Integer>() {
            {
                add(1);
                add(3);
                add(5);
                add(6);
            }
        };

        var expectedIsChanged = true;
        var expectedArray = new Object[] { 1, 3, 5 };

        // act
        list.addAll(source);
        var actualIsChanged = list.retainAll(filter);
        var actualArray = list.toArray();

        // assert
        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedIsChanged, actualIsChanged);
    }

    @Test
    void RemoveAllTest() {
        // arrange
        var list = new MyListImpl();
        var source = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };
        var filter = new ArrayList<Integer>() {
            {
                add(1);
                add(3);
                add(5);
                add(6);
            }
        };

        var expectedIsChanged = true;
        var expectedArray = new Object[] { 2, 4 };

        // act
        list.addAll(source);
        var actualIsChanged = list.removeAll(filter);
        var actualArray = list.toArray();

        // assert
        assertArrayEquals(expectedArray, actualArray);
        assertEquals(expectedIsChanged, actualIsChanged);
    }
}
