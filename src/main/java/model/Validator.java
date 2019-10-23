package model;

import java.awt.*;
import java.util.Comparator;

public class Validator {
    public static <T> boolean validate(T value, T min, T max, Comparator<T> comparator){
        return ( comparator.compare(value, min) >= 0 )
                && ( comparator.compare(value, max) <= 0 );
    }

    public static <T> boolean validate(T value, T min, Comparator<T> comparator){
        return comparator.compare(value, min) >= 0;
    }

    public static <T> boolean isNull(T t){
        return t == null;
    }

    public static <T> boolean isNotNull(T t){
        return !isNull(t);
    }


}
