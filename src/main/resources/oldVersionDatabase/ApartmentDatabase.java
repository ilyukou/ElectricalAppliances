package database;

import model.apartment.Apartment;

import java.io.IOException;

//public interface ApartmentDatabase {
    Apartment getApartments() throws IOException;
    void setApartments(Apartment apartment) throws IOException;
}
