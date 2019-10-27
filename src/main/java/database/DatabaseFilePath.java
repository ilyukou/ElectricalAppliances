package database;

import model.apartment.Apartment;
import model.apartment.Room;
import model.apartment.RoomType;

import java.util.ArrayList;
import java.util.List;

final class DatabaseFilePath {
    private static final String DATABASE_FOLDER_URI = "src/main/resources/database/";
    private static final String APARTMENT_FILE_URI = DATABASE_FOLDER_URI + "apartments.json";
    private static final String ROOM_FILE_URI = DATABASE_FOLDER_URI + "rooms.json";

    public static String getFileUriForObject(Object o) {

        if (o instanceof Apartment) {
            return getApartmentFileUri();

        } else if (o instanceof Room ) {

            return getRoomFileUri();


        } else {
            return null;
        }
    }
    public static String getFileUriForObject(String objectName){

        if(objectName.equals(Apartment.class.getName())){
            return getApartmentFileUri();

        }else if((objectName.equals(Room.class.getName()))){
            return getRoomFileUri();
        }else {
            return null;
        }
    }

    public static String getApartmentFileUri() {
        return APARTMENT_FILE_URI;
    }

    public static String getRoomFileUri() {
        return ROOM_FILE_URI;
    }

}

