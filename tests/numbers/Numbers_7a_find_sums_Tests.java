package numbers;

import java.util.Collection;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import numbers.Numbers.Pair;


/**
 * JUnit 5 test class of Numbers class, findSums() method.
 * 
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Numbers_7a_find_sums_Tests {

    /*
     * tested object is an instance of the Numbers class
     */
    private static Numbers testedObj;


    /**
     * Static setup method executed once for all tests. Creates
     * the test object.
     * 
     * @throws Exception is creation of test object fails
     */
    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        testedObj = Numbers.createNumbersInstance();
    }

    @Test
    @Order(700)
    void test700_find_sums_regular() {
        Collection<Pair> actual = testedObj.findSums(NumbersImpl.numb_1, 10);
        int[][] expected = {{8, 2}};
        assertTrue(Matchers.matchIgnoreOrder(expected, actual));
    }

    @Test
    @Order(701)
    void test701_find_sums_regular() {
        Collection<Pair> actual = testedObj.findSums(NumbersImpl.numb_1, 12);
        int[][] expected = {{10, 2}, {4, 8}, {7, 5}};   // also matches: {{8, 4}, {10, 2}, {7, 5}};
        assertTrue(Matchers.matchIgnoreOrder(expected, actual));
    }

    @Test
    @Order(702)
    void test702_find_sums_regular() {
        Collection<Pair>  actual = testedObj.findSums(NumbersImpl.numb_1, 15);
        int[][] expected = {{5, 10}, {7, 8}};
        assertTrue(Matchers.matchIgnoreOrder(expected, actual));
    }

    @Test
    @Order(703)
    void test703_find_sums_regular() {
        Collection<Pair>  actual = testedObj.findSums(NumbersImpl.numb_1, 150);
        int[][] expected = {};  // no solution
        assertTrue(Matchers.matchIgnoreOrder(expected, actual));
    }

    @Test
    @Order(704)
    void test704_find_sums_regular() {
        Collection<Pair> actual = testedObj.findSums(NumbersImpl.numb_2, 663);
        int[][] expected = {{636, 27}};
        assertTrue(Matchers.matchIgnoreOrder(expected, actual));
    }

    @Test
    @Order(705)
    void test705_find_sums_regular() {
        Collection<Pair> actual = testedObj.findSums(NumbersImpl.numb_3, 961);
        int[][] expected = {{521, 440}, {498, 463}};
        assertTrue(Matchers.matchIgnoreOrder(expected, actual));
    }

    @Test
    @Order(706)
    void test706_find_sums_regular() {
        Collection<Pair> actual = testedObj.findSums(NumbersImpl.numb_3, 2286);
        int[][] expected = {};  // no solution
        assertTrue(Matchers.matchIgnoreOrder(expected, actual));
    }
}