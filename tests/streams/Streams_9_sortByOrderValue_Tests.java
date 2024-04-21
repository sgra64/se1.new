package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Streams_9_sortByOrderValue_Tests {

    /*
     * tested object is an instance of the Numbers class
     */
    private static Streams testedObj;


    /**
     * Static setup method executed once for all tests. Creates
     * the test object.
     * 
     * @throws Exception is creation of test object fails
     */
    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        testedObj = Streams.createStreamsInstance();
    }

    @Test
    @Order(900)
    void test900_sortByOrderValue_regular() {
        //
        var expected = List.of(4, 6, 5, 3, 1, 0, 2).stream()
            .map(i -> Streams.orders.get(i))
            .collect(Collectors.toList());
        //
        var actual = testedObj.sortOrdersByValue(Streams.orders);
        //
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test
    @Order(901)
    void test901_sortByOrderValue_regular() {
        //
        var extendedOrders = new ArrayList<Streams.Order>(Streams.orders);
        extendedOrders.addAll(List.of(
            new Streams.Order("Teller", 4,  649),   // [7]:  4x  649 = 2596
            new Streams.Order("Glas",  12,  249)    // [8]: 12x  249 = 2988
        ));
        //
        var expected = List.of(4, 6, 5, 8, 7, 3, 1, 0, 2).stream()
            .map(i -> extendedOrders.get(i))
            .collect(Collectors.toList());
        //
        var actual = testedObj.sortOrdersByValue(extendedOrders);
        //
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test
    @Order(910)
    void test910_sortByOrderValue_emptyOrders() {
        //
        var emptyOrders = new ArrayList<Streams.Order>();
        long actual = testedObj.calculateValue(emptyOrders);
        assertEquals(0L, actual);
    }

    @Test
    @Order(990)
    void test990_sortByOrderValue_irregular_orders_Null() {
        //
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            testedObj.calculateValue(null);    // throw exception if orders arg is null
        });
        assertEquals("orders argument is null.", thrown.getMessage());
    }
}