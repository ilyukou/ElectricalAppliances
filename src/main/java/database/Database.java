package database;

import model.apartment.Apartment;
import model.apartment.Room;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;

public interface Database<T> {

    // how can i know what's object i need ?
    Apartment getApartment() throws IOException;

    void setObject(T t) throws IOException;
}
