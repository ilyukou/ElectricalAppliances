package model;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;

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

    public static boolean isNotEmpty(String s){
        return StringUtils.isNotEmpty(s);
    }
    public static boolean isEmpty(String s){
        return StringUtils.isEmpty(s);
    }

    public static <T> boolean isValidList(List<T> t){
        return ( Validator.isNotNull(t) ) && ( t.size() > 0 );
    }
}
