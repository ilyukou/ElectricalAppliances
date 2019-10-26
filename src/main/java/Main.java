import database.Database;
import database.DatabseSwitcher;
import model.apartment.Apartment;
import model.apartment.Room;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        Database database = DatabseSwitcher.getDatabase("json");

        Controller controller = new Controller();

        Apartment apartment = controller.createApartment();

        System.out.println(apartment.getPowerInRooms());

        database.setObject(apartment);

        for (Room room : apartment.getRooms()){
            database.setObject(room);
        }

    }
}
