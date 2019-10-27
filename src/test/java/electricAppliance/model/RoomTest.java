package electricAppliance.model;

import electricAppliance.Creater;
import electricAppliance.model.exception.NotEnoughFreeSocketsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    private Room room;

    @BeforeEach
    void setUp() {
        room = Creater.createApartment().getRooms().get(0);
    }

    @Test
    void setRoomType_whenRoomTypeIsNull() {
        Room r = (Room) room.clone();
        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            r.setRoomType(null);
        });
    }

    @Test
    void setRoomType_whenRoomTypeIsNotNull() {
        Room r = (Room) room.clone();
        r.setRoomType(RoomType.LivingRoom);

        assertEquals(r.getRoomType(),RoomType.LivingRoom);
    }

    @Test
    void isFreeSocketsExist_whenSocketsIsNotExist() {
        Room r = (Room) room.clone();
        List<ElectricAppliance> electricAppliances = Arrays.asList(
                Mockito.mock(ElectricAppliance.class),
                Mockito.mock(ElectricAppliance.class),
                Mockito.mock(ElectricAppliance.class)

        );

        r.setNumberOfSoket(2);

        Assertions.assertThrows(NotEnoughFreeSocketsException.class , () -> {
            r.setElectricAppliances(electricAppliances);
        });
    }

    @Test
    void isFreeSocketsExist_whenSocketsIsExist() {


        List<ElectricAppliance> electricAppliances = new ArrayList<>();

        electricAppliances.add(Mockito.mock(ElectricAppliance.class));
        electricAppliances.add(Mockito.mock(ElectricAppliance.class));

        try {
            Room room = new Room(electricAppliances,3, RoomType.LivingRoom);
        } catch (NotEnoughFreeSocketsException notEnoughFreeSocketsException) {
            notEnoughFreeSocketsException.printStackTrace();
        }

        assertTrue(room.isFreeSocketsExist());
    }


    @Test
    void getPowerInSokets() {
        Room r = (Room) room.clone();
        assertEquals(1200,r.getPowerInSokets());
    }

    @Test
    void addElectricalAppliances_whenNumberOfSocketEnough() {

        List<ElectricAppliance> electricAppliances = new ArrayList<>();

        electricAppliances.add(Mockito.mock(ElectricAppliance.class));


        try {
            Room r = new Room(electricAppliances,2,RoomType.LivingRoom);
            r.addElectricalAppliances(Mockito.mock(ElectricAppliance.class));

            assertEquals(2,r.getElectricAppliances().size());
        } catch (NotEnoughFreeSocketsException notEnoughFreeSocketsException) {
            notEnoughFreeSocketsException.printStackTrace();
            assertTrue(false);
        }


    }

    @Test
    void addElectricalAppliances_whenNumberOfSocketNotEnough() {
        Room r = (Room) room.clone();
        r.setNumberOfSoket(2);

        Assertions.assertThrows(NotEnoughFreeSocketsException.class , () -> {
            r.addElectricalAppliances(Mockito.mock(ElectricAppliance.class));
            r.addElectricalAppliances(Mockito.mock(ElectricAppliance.class));
            r.addElectricalAppliances(Mockito.mock(ElectricAppliance.class));
        });

    }

    @Test
    void setElectricAppliances_whenSocketsIsNotExist() {

        List<ElectricAppliance> electricAppliances = new ArrayList<>();
        electricAppliances.add(Mockito.mock(ElectricAppliance.class));
        electricAppliances.add(Mockito.mock(ElectricAppliance.class));
        electricAppliances.add(Mockito.mock(ElectricAppliance.class));

        Assertions.assertThrows(NotEnoughFreeSocketsException.class , () -> {
            Room room = new Room(electricAppliances,2,RoomType.LivingRoom);
        });
    }

    @Test
    void setElectricAppliances_whenSocketsIsExist() {
        List<ElectricAppliance> electricAppliances = new ArrayList<>();
        electricAppliances.add(Mockito.mock(ElectricAppliance.class));
        electricAppliances.add(Mockito.mock(ElectricAppliance.class));
        electricAppliances.add(Mockito.mock(ElectricAppliance.class));



        Assertions.assertThrows(NotEnoughFreeSocketsException.class , () -> {
            Room room = new Room(electricAppliances,2,RoomType.LivingRoom);
        });

    }

    @Test
    void setNumberOfSoket_whenNumberValidate() {
        List<ElectricAppliance> electricAppliances = new ArrayList<>();
        electricAppliances.add(Mockito.mock(ElectricAppliance.class));


        Room r = null;
        try {
            r = new Room(electricAppliances,3, RoomType.LivingRoom);
            r.setNumberOfSoket(5);
        } catch (NotEnoughFreeSocketsException notEnoughFreeSocketsException) {
            notEnoughFreeSocketsException.printStackTrace();
        }

        assertEquals(5,r.getNumberOfSoket());



    }

    @Test
    void setNumberOfSoket_whenNumberUnValidate() {
        List<ElectricAppliance> electricAppliances = new ArrayList<>();
        electricAppliances.add(Mockito.mock(ElectricAppliance.class));

        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            Room r = new Room(electricAppliances,3, RoomType.LivingRoom);
            r.setNumberOfSoket(-12);
        });

    }

    @Test
    void testClone() {
        Room r = (Room) room.clone();
        r.setNumberOfSoket(r.getNumberOfSoket()+1);

        assertEquals(room.getNumberOfSoket()+1,r.getNumberOfSoket());
    }
}