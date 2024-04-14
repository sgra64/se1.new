package numbers;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


/**
 * JUnit 5 test class of Numbers class, sum_pen() method.
 * 
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Numbers_2_sum_positive_even_Tests {

    /*
     * test object is an instance of the Numbers class
     */
    private static Numbers testObj;


    /**
     * Static setup method executed once for all tests. Creates
     * the test object.
     * 
     * @throws Exception is creation of test object fails
     */
    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        testObj = Numbers.createNumbersInstance();
    }

    @Test
    @Order(200)
    void test200_sum_positive_even_numbers_regular() {
        assertEquals(12, testObj.sum_pen(NumbersImpl.numbers));
    }

    @Test
    @Order(201)
    void test201_sum_positive_even_numbers_regular() {
        assertEquals(38, testObj.sum_pen(NumbersImpl.numb_1));
    }

    @Test
    @Order(202)
    void test202_sum_positive_even_numbers_regular() {
        assertEquals(6492, testObj.sum_pen(NumbersImpl.numb_2));
    }

    @Test
    @Order(203)
    void test203_sum_positive_even_numbers_regular() {
        assertEquals(80012, testObj.sum_pen(NumbersImpl.numb_3));
    }
}