package es.uvigo.esei.aed1.activity7;

import es.uvigo.esei.aed1.activity7.hospital.Doctor;
import es.uvigo.esei.aed1.activity7.hospital.Hospital;
import es.uvigo.esei.aed1.activity7.hospital.Patient;
import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static es.uvigo.esei.aed1.activity7.Activity7.*;
import static es.uvigo.esei.aed1.activity7.IsEqualToList.equalToList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Activity7Test {

    private List<Integer> list1, list2;
    private Hospital hospital;

    @BeforeEach
    public void setUp() {
        list1 = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            list1.addLast(i);
        }

        list2 = new LinkedList<>();
        for (int i = 10; i >= 1; i--) {
            list2.addLast(i);
        }

        Patient patient1 = new Patient(1);
        Patient patient2 = new Patient(2);
        Patient patient3 = new Patient(3);
        Patient patient4 = new Patient(4);

        Doctor doctor1 = new Doctor(1);
        Doctor doctor2 = new Doctor(2);

        hospital = new Hospital("CHUO");
        doctor1.addPatient(patient1);
        doctor2.addPatient(patient2);
        doctor2.addPatient(patient3);
        doctor2.addPatient(patient4);
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
    }

    private static <T> List<T> arrayToList(T... array) {
        List<T> toRet = new LinkedList<>();
        for (T value : array) {
            toRet.addLast(value);
        }
        return toRet;
    }


    /**
     * Test of getHigherThan method, of class Activity7.
     */
    @Test
    public void testGetHigherThanNullList() {
        List list = null;
        int number = 5;

        assertThrows(NullPointerException.class, () -> {
            getHigherThan(list, number);
        });
    }

    @Test
    public void testGetHigherThan5() {
        List<Integer> expected = arrayToList(6, 7, 8, 9, 10);

        int num = 5;
        List<Integer> result = getHigherThan(list1, num);

        assertThat(result, is(equalToList(expected)));
    }

    @Test
    public void testGetHigherThan10() {
        List<Integer> expected = new LinkedList<>();
        int num = 10;

        List<Integer> result = getHigherThan(list1, num);

        assertThat(result, is(equalToList(expected)));
    }

    /**
     * Test of invert method, of class Activity7.
     */
    @Test
    public void testInvertNull() {
        final List list = null;

        assertThrows(NullPointerException.class, () -> {
            invert(list);
        });
    }

    @Test
    public void testInvertEmpty() {
        List<Integer> expected = new LinkedList<>();
        List<Integer> result = invert(new LinkedList<>());

        assertThat(result, is(equalToList(expected)));
    }

    @Test
    public void testInvert() {
        List<Integer> expected = list2;
        List<Integer> result = invert(list1);

        assertThat(result, is(equalToList(expected)));
    }

    /**
     * Test of allValuesAppearancesAreEqual method, of class Activity7.
     */
    @Test
    public void testAllValuesAppearancesAreEqualNull() {
        List list = null;

        assertThrows(NullPointerException.class, () -> {
            allValuesAppearancesAreEqual(list);
        });
    }

    @Test
    public void testAllValuesAppearancesAreEqualTrue() {

        assertThat(allValuesAppearancesAreEqual(list1), is(true));
    }

    @Test
    public void testAllValuesAppearancesAreEqualFalse() {
        list1.addLast(3);

        assertThat(allValuesAppearancesAreEqual(list1), is(false));
    }

    /**
     * Test of isAscendingOrder method, of class Activity7.
     */
    @Test
    public void testIsAscendingOrderNull() {

        List list = null;

        assertThrows(NullPointerException.class, () -> {
            isAscendingOrder(list);
        });
    }

    @Test
    public void testIsAscendingOrderTrue() {

        assertThat(isAscendingOrder(list1), is(true));
    }

    @Test
    public void testIsAscendingOrderFalse() {

        assertThat(isAscendingOrder(list2), is(false));
    }

    /**
     * Test of buildListWithRepeatedValues method, of class Activity7.
     */
    @Test
    public void testbuildListWithRepeatedValuesNull() {

        List list = null;

        assertThrows(NullPointerException.class, () -> {
            buildListWithRepeatedValues(list);
        });
    }

    @Test
    public void testbuildListWithRepeatedValues0() {
        List<Integer> expected = new LinkedList<>();
        List<Integer> result = buildListWithRepeatedValues(list1);

        assertThat(result, is(equalToList(expected)));
    }

    @Test
    public void testbuildListWithRepeatedValues2() {
        List<Integer> list = arrayToList(5, 2, 7, 2, 5, 5, 1);
        List<Integer> expected = arrayToList(5, 2);
        List<Integer> result = buildListWithRepeatedValues(list);

        assertThat(result, is(equalToList(expected)));
    }

    /**
     * Test of buildSummaryList method, of class Activity7.
     */
    @Test
    public void testBuildSummaryListNull() {
        List list1 = null;
        List list2 = null;

        assertThrows(NullPointerException.class, () -> {
            buildSummaryList(list1, list2);
        });
    }

    @Test
    public void testBuildGetSummaryList() {
        List<Integer> list1 = arrayToList(1, 2, 1, 3, 4, 2);
        List<Integer> list2 = arrayToList(6, 1, 3, 2, 6, 7);

        List<Terna<Integer>> expected = arrayToList(
                new Terna<>(1, 2, 1),
                new Terna<>(2, 2, 1),
                new Terna<>(3, 1, 1),
                new Terna<>(4, 1, 0),
                new Terna<>(6, 0, 2),
                new Terna<>(7, 0, 1)
        );
        List<Terna<Integer>> result = buildSummaryList(list1, list2);

        assertThat(result, is(equalToList(expected)));
    }

    /**
     * Test of countValuesEqualSumPreceding method, of class Activity7.
     */
    @Test
    public void testCountValuesEqualSumPrecedingNull() {
        List list = null;

        assertThrows(NullPointerException.class, () -> {
            countValuesEqualSumPreceding(list);
        });
    }

    @Test
    public void testCountValuesEqualSumPreceding2() {
        List<Integer> list = arrayToList(3, -2, 4, 5, -4, 6);

        assertThat(countValuesEqualSumPreceding(list), is(2));
    }

    @Test
    public void testCountValuesEqualSumPreceding3() {
        List<Integer> list = arrayToList(-3, 2, -1, -2, 4, 0);

        assertThat(countValuesEqualSumPreceding(list), is(3));
    }

    /**
     * Test of printLots method, of class Activity7.
     */
    @Test
    public void testPrintLotsNull() {
        List list = null;
        List index = null;

        assertThrows(NullPointerException.class, () -> {
            printLots(list, index);
        });
    }

    @Test
    public void testPrintLots3() {
        List<Integer> list = arrayToList(3, 2, 5, -5, 1, 6, 12);
        List<Integer> index = arrayToList(1, 4, 5);
        List<Integer> expected = arrayToList(3, -5, 1);

        List<Integer> result = printLots(list, index);

        assertThat(result, is(equalToList(expected)));
    }

    @Test
    public void testPrintLots4() {
        List<Integer> list = arrayToList(4, 6, 0, 2, 7, 1);
        List<Integer> index = arrayToList(2, 5, 6, 7);
        List<Integer> expected = arrayToList(6, 7, 1);

        List<Integer> result = printLots(list, index);

        assertThat(result, is(equalToList(expected)));
    }

    /**
     * Test of duplicateValues method, of class Activity7.
     */
    @Test
    public void testDuplicateValuesNull() {
        List list = null;

        assertThrows(NullPointerException.class, () -> {
            duplicateValues(list);
        });
    }

    @Test
    public void testDuplicateValues5() {
        List<Integer> result = arrayToList(2, 7, 1, 4, 5);
        List<Integer> expected = arrayToList(4, 14, 2, 8, 10);

        duplicateValues(result);

        assertThat(result, is(equalToList(expected)));
    }

    @Test
    public void testDuplicateValues6() {
        List<Integer> result = arrayToList(-1, 5, 3, 0, 2, 8);
        List<Integer> expected = arrayToList(-2, 10, 6, 0, 4, 16);

        duplicateValues(result);

        assertThat(result, is(equalToList(expected)));
    }

    /**
     * Test of getMorePatients method, of class ExHospital.
     */
    @Test
    public void testGetMorePatients() {
        Integer expResult = 2;
        Integer result = getMorePatients(hospital);

        assertEquals(expResult, result);
    }

}
