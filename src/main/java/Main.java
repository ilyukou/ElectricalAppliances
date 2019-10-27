import database.Database;
import database.DatabseSwitcher;
import model.apartment.Apartment;
import model.apartment.Room;

import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        Database database = DatabseSwitcher.getDatabase("json");

        System.out.println();
        Controller controller = new Controller();

        Apartment apartment = controller.createApartment();

        System.out.println(apartment.getPowerInRooms());

        Apartment apar = database.getApartment();
        System.out.println();

    }
}
