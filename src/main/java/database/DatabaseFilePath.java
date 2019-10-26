package database;

import model.apartment.Apartment;
import model.apartment.Room;
import model.apartment.RoomType;

import java.util.List;

final class DatabaseFilePath {
    private static final String DATABASE_FOLDER_URI = "src/main/resources/database/";
    private static final String APARTMENT_FILE_URI = DATABASE_FOLDER_URI + "apartments.json";
    private static final String ROOM_FILE_URI = DATABASE_FOLDER_URI + "room.json";

    private static final String KITCHEN_ROOM_FILE_URI = DATABASE_FOLDER_URI + "kitchenRoom.json";
    private static final String LIVING_ROOM_FILE_URI = DATABASE_FOLDER_URI + "homeRoom.json";
    private static final String SPORT_ROOM_FILE_URI = DATABASE_FOLDER_URI + "sportRoom.json";

    public static String getFileUriForObject(Object o){

        if(o instanceof Apartment){
            return getApartmentFileUri();
        }else if(o instanceof Room){

            Room room = (Room) o;
            if(room.getRoomType() == RoomType.LivingRoom){
                return getLivingRoomFileUri();

            }else if(room.getRoomType() == RoomType.Kitchen){
                return getKitchenRoomFileUri();

            }else if(room.getRoomType() == RoomType.Sport){
                return getSportRoomFileUri();
            }

            return getRoomFileUri();
        }else {
            return null;
        }
    }

    public static String getDatabaseFolderUri() {
        return DATABASE_FOLDER_URI;
    }

    public static String getApartmentFileUri() {
        return APARTMENT_FILE_URI;
    }

    public static String getRoomFileUri() {
        return ROOM_FILE_URI;
    }

    public static String getKitchenRoomFileUri() {
        return KITCHEN_ROOM_FILE_URI;
    }

    public static String getLivingRoomFileUri() {
        return LIVING_ROOM_FILE_URI;
    }

    public static String getSportRoomFileUri() {
        return SPORT_ROOM_FILE_URI;
    }
}

