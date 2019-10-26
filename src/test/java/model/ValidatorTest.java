package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
    }

    // Test for Validator.validate(T value, T min, T max, Comparator<T> comparator);
    @Test
    void validateWithMinAndMaxRange_whenNumberInRange() {
        boolean actual = Validator.validate(10, 0, 11, Integer::compareTo);
        assertTrue(actual);
    }

    // number out of min range
    @Test
    void validateWithMinAndMaxRange_whenNumberOutOfMinRange() {
        boolean actual = Validator.validate(1, 2, 7, Integer::compareTo);
        assertFalse(actual);
    }

    // number out of max range
    @Test
    void validateWithMinAndMaxRange_whenNumberOutOfMaxRange() {
        boolean actual = Validator.validate(10, 0, 7, Integer::compareTo);
        assertFalse(actual);
    }

    // Test for Validator.validate(T value, T min, Comparator<T> comparator);
    @Test
    void validateWithMinRange_whenNumberInRange() {
        boolean actual = Validator.validate(10, 1, Integer::compareTo);
        assertTrue(actual);
    }

    // number out of min range
    @Test
    void validateWithMinRange_whenNumberOutOfMinRange() {
        boolean actual = Validator.validate(1, 10, Integer::compareTo);
        assertFalse(actual);
    }

    // Validate.isNull();
    @Test
    void isNull_whenObjectIsNull() {
        boolean actual = Validator.isNull(null);
        assertTrue(actual);
    }

    @Test
    void isNull_whenObjectIsNotNull() {
        String string = "test";
        boolean actual = Validator.isNull(string);
        assertFalse(actual);
    }

    // Validate.isNotNull();
    @Test
    void isNotNull_whenObjectIsNull() {
        boolean actual = Validator.isNotNull(null);
        assertFalse(actual);
    }

    @Test
    void isNotNull_whenObjectNotNull() {
        String string = "test";
        boolean actual = Validator.isNotNull(string);
        assertTrue(actual);
    }

    // Validator.isValidList();
    @Test
    void isValidList_whenListIsNull() {
        List<Object> list = null;
        assertFalse(Validator.isValidList(list));
    }

    @Test
    void isValidList_whenListIsEmpty() {
        List<String> list = new ArrayList<>();
        assertFalse(Validator.isValidList(list));
    }

    @Test
    void isValidList_whenListIsValid() {
        List<String> list = new ArrayList<>();
        list.add("test");

        assertTrue(Validator.isValidList(list));
    }
}