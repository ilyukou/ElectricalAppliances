package database;

import java.io.IOException;
import java.util.List;

public interface Database<T> {

    // how can i know what's object i need ?
    T getObject(T t) throws IOException;

    void setObject(T t) throws IOException;
}
