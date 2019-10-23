import model.apartment.Apartment;
import model.apartment.Room;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Room room = Room.build(null,5);
        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        Apartment apartment = Apartment.build(rooms);
        System.out.println();

    }
}
