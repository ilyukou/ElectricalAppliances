package electricAppliance.model;

import electricAppliance.Creater;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentTest {
    private Apartment setUpApartment;

    @BeforeEach
    void setUp() {
        setUpApartment = Creater.createApartment();
    }

    @Test
    void setRooms_whenRoomsIsValidList() {
       Room room = Mockito.mock(Room.class);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        rooms.add(room);

        Apartment apartment = new Apartment(rooms);

        assertEquals(2,apartment.getRooms().size());
    }

    @Test
    void setRooms_whenRoomsIsNotValidList() {
        Room room = Mockito.mock(Room.class);

        List<Room> rooms = null;



        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            Apartment apartment = new Apartment(rooms);
        });
    }

    @Test
    void addRooms_whenRoomsIsNotNull() {
        Apartment apartment = (Apartment) setUpApartment.clone();
        Room room = Mockito.mock(Room.class);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        rooms.add(room);

        apartment.addRooms(rooms);

        assertEquals(setUpApartment.getRooms().size()+2,apartment.getRooms().size());
    }
    @Test
    void addRooms_whenRoomsIsNull() {
        Apartment apartment = (Apartment) setUpApartment.clone();

        List<Room> rooms = null;

        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            apartment.addRooms(rooms);
        });
    }

    @Test
    void addRoom_whenRoomIsNotNull() {
        Apartment apartment = (Apartment) setUpApartment.clone();
        Room room = Mockito.mock(Room.class);

        apartment.addRoom(room);
        assertEquals(setUpApartment.getRooms().size()+1,apartment.getRooms().size());
    }

    @Test
    void addRoom_whenRoomIsNull() {
        Apartment apartment = (Apartment) setUpApartment.clone();
        Room room = null;



        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            apartment.addRoom(room);
        });
    }

    @Test
    void getPowerInRooms() {
        Apartment apartment = (Apartment) setUpApartment.clone();
        assertEquals(4520,apartment.getPowerInRooms());
    }

    @Test
    void getAllElectricAppliance() {
        Apartment apartment = (Apartment) setUpApartment.clone();
        assertEquals(12,apartment.getAllElectricAppliance().size());
    }

    @Test
    void searchElectricApplianceByPower_whenFound() {
        Apartment apartment = (Apartment) setUpApartment.clone();

        ElectricAppliance electricAppliance =
                apartment.searchElectricApplianceByPower(apartment.getAllElectricAppliance(),480,520);

        assertTrue(electricAppliance.getPower() == 500
                && electricAppliance.getName().equals("TreadGym"));
    }

    @Test
    void searchElectricApplianceByPower_whenNotFound() {
        Apartment apartment = (Apartment) setUpApartment.clone();

        Assertions.assertThrows(NullPointerException.class , () -> {
            ElectricAppliance electricAppliance =
                    apartment.searchElectricApplianceByPower(apartment.getAllElectricAppliance(),1,2);
            electricAppliance.getPower();
        });
    }

    @Test
    void sortElectricApplianceByPower() {
        Apartment apartment = (Apartment) setUpApartment.clone();

        List<ElectricAppliance> sortedList = apartment
                .sortElectricApplianceByPower(apartment.getAllElectricAppliance());

        boolean actual = true;

        for (int i=1; i<sortedList.size(); i++){
            if(sortedList.get(i).getPower() < sortedList.get(i-1).getPower()){
                actual = false;
            }
        }
        assertTrue(actual);
    }

    @Test
    void testClone() {

        int expected = setUpApartment.getRooms().size();

        Apartment cloneApartment = (Apartment) setUpApartment.clone();

        cloneApartment.addRooms(cloneApartment.getRooms());

        assertNotEquals(setUpApartment.getRooms().size(),cloneApartment.getRooms().size());
    }
}