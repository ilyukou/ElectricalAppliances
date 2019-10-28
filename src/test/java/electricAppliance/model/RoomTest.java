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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoomTest {
    private Room room;

    @BeforeEach
    void setUp() {
        room = Creater.createApartment().getRooms().get(0);
    }

    @Test
    void setRoomType_whenRoomTypeIsNull() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> room.setRoomType(null)
        );
    }

    @Test
    void setRoomType_whenRoomTypeIsNotNull() {

        room.setRoomType(RoomType.LivingRoom);

        assertEquals(room.getRoomType(), RoomType.LivingRoom);
    }

    @Test
    void isFreeSocketsExist_whenSocketsIsNotExist() {

        List<ElectricAppliance> electricAppliances = Arrays.asList(
                Mockito.mock(ElectricAppliance.class),
                Mockito.mock(ElectricAppliance.class),
                Mockito.mock(ElectricAppliance.class)
        );

        room.setNumberOfSockets(2);

        Assertions.assertThrows(
                NotEnoughFreeSocketsException.class,
                () -> room.setElectricAppliances(electricAppliances)
        );
    }

    @Test
    void isFreeSocketsExist_whenSocketsIsExist() {


        List<ElectricAppliance> electricAppliances = Arrays.asList(
                Mockito.mock(ElectricAppliance.class),
                Mockito.mock(ElectricAppliance.class)
        );

        try {
            Room room = new Room(electricAppliances, 3, RoomType.LivingRoom);
        } catch (NotEnoughFreeSocketsException notEnoughFreeSocketsException) {
            notEnoughFreeSocketsException.printStackTrace();
        }

        assertTrue(room.isFreeSocketsExist());
    }


    @Test
    void getPowerInSokets() {
        assertEquals(1200, room.getPowerInSokets());
    }

    @Test
    void addElectricalAppliances_whenNumberOfSocketEnough() {

        List<ElectricAppliance> electricAppliances = new ArrayList<>();

        electricAppliances.add(Mockito.mock(ElectricAppliance.class));


        try {
            Room r = new Room(electricAppliances, 2, RoomType.LivingRoom);
            r.addElectricalAppliances(Mockito.mock(ElectricAppliance.class));

            assertEquals(2, r.getElectricAppliances().size());
        } catch (NotEnoughFreeSocketsException notEnoughFreeSocketsException) {
            notEnoughFreeSocketsException.printStackTrace();
            assertTrue(false);
        }


    }

    @Test
    void addElectricalAppliances_whenNumberOfSocketNotEnough() {
        room.setNumberOfSockets(2);

        Assertions.assertThrows(
                NotEnoughFreeSocketsException.class,
                () -> {
                    room.addElectricalAppliances(Mockito.mock(ElectricAppliance.class));
                    room.addElectricalAppliances(Mockito.mock(ElectricAppliance.class));
                    room.addElectricalAppliances(Mockito.mock(ElectricAppliance.class));
                });

    }

    @Test
    void setElectricAppliances_whenSocketsIsNotExist() {

        List<ElectricAppliance> electricAppliances = Arrays.asList(
                Mockito.mock(ElectricAppliance.class),
                Mockito.mock(ElectricAppliance.class),
                Mockito.mock(ElectricAppliance.class)
        );

        Assertions.assertThrows(
                NotEnoughFreeSocketsException.class,
                () -> {
                    Room room = new Room(electricAppliances, 2, RoomType.LivingRoom);
                });
    }

    @Test
    void setElectricAppliances_whenSocketsIsExist() {
        List<ElectricAppliance> electricAppliances = Arrays.asList(
                Mockito.mock(ElectricAppliance.class),
                Mockito.mock(ElectricAppliance.class),
                Mockito.mock(ElectricAppliance.class)
        );

        Room room = null;
        try {
            room = new Room(electricAppliances, 4, RoomType.LivingRoom);

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(3, room.getElectricAppliances().size());
    }

    @Test
    void setNumberOfSoket_whenNumberValidate() {
        List<ElectricAppliance> electricAppliances = Arrays.asList(
                Mockito.mock(ElectricAppliance.class)
        );

        Room r = null;
        try {
            r = new Room(electricAppliances, 3, RoomType.LivingRoom);
            r.setNumberOfSockets(5);
        } catch (NotEnoughFreeSocketsException notEnoughFreeSocketsException) {
            notEnoughFreeSocketsException.printStackTrace();
        }

        assertEquals(5, r.getNumberOfSockets());


    }

    @Test
    void setNumberOfSoket_whenNumberUnValidate() {
        List<ElectricAppliance> electricAppliances = new ArrayList<>();
        electricAppliances.add(Mockito.mock(ElectricAppliance.class));

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Room r = new Room(electricAppliances, 3, RoomType.LivingRoom);
                    r.setNumberOfSockets(-12);
                });

    }
}