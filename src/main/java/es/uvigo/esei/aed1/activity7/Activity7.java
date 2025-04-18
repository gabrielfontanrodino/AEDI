package es.uvigo.esei.aed1.activity7;

import es.uvigo.esei.aed1.activity7.hospital.Doctor;
import es.uvigo.esei.aed1.activity7.hospital.Hospital;
import java.util.Iterator;
import es.uvigo.esei.aed1.tads.list.IteratorList;
import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;

public class Activity7 {

    //Donde se vea un for each, se puede usar un Iterator con "hasNext" y "next", etc...

    // Exercise 1: Devuelve una lista con elementos mayores que threshold
    public static List<Integer> getHigherThan(List<Integer> listToFilter, int threshold) throws NullPointerException {
        if (listToFilter == null) {
            throw new NullPointerException();
        }

        List<Integer> result = new LinkedList<>();

        //Por cada valor de la lista a filtrar...
        for (Integer value : listToFilter) {
            //Si el valor es mayor que el umbral, lo añadimos a la lista "result"
            if (value > threshold) {
                result.addLast(value);
            }
        }

        return result;
    }

    // Exercise 2: Invierte una lista
    public static <T> List<T> invert(List<T> list) throws NullPointerException {
        if (list == null) {
            throw new NullPointerException();
        }

        List<T> result = new LinkedList<>();

        for (T element : list) {
            result.addFirst(element);
        }

        return result;
    }

    // Exercise 3: Contar apariciones de un valor
    private static <T> int countValueAppearances(List<T> list, T referenceValue) {
        int count = 0;

        // Iteramos por la lista y usamos equals para comparar si el valor es igual al de referencia
        // No usamos "==" porque puede que sean objetos distintos

        for (T value : list) {
            if (value.equals(referenceValue)) {
                count++;
            }
        }

        return count;
    }

    // Exercise 3: Comprueba si todos los valores aparecen el mismo número de veces
    public static <T> boolean allValuesAppearancesAreEqual(List<T> list) throws NullPointerException {
        if (list == null) {
            throw new NullPointerException();
        }

        if (list.isEmpty()) {
            return true;
        }

        // Guardamos los elementos ya comprobados para no repetir
        List<T> alreadyProcessed = new LinkedList<>();
        Iterator<T> it = list.iterator();

        // Cogemoss el primer valor como referencia
        T firstValue = it.next();
        int referenceCount = countValueAppearances(list, firstValue);
        alreadyProcessed.addLast(firstValue);

        // Reiniciamos el iterador
        it = list.iterator();

        while (it.hasNext()) {
            T value = it.next();

            // Si el valor ya fue procesado, lo saltamos
            boolean processed = alreadyProcessed(alreadyProcessed, value);

            if (!processed) {
                int count = countValueAppearances(list, value);
                if (count != referenceCount) {
                    return false;
                }
                alreadyProcessed.addLast(value);
            }
        }

        return true;
    }

    // Exercise 4: Comprueba si una lista está en orden ascendente
    public static <T extends Comparable<T>> boolean isAscendingOrder(List<T> list) throws NullPointerException {
        if (list == null) {
            throw new NullPointerException();
        }

        if (list.isEmpty() || list.size() == 1) {
            return true;
        }

        Iterator<T> it = list.iterator();
        T previous = it.next();

        while (it.hasNext()) {
            T current = it.next();
            if (previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }

        return true;
    }

    // Exercise 5: Construye una lista con valores repetidos
    public static <T> List<T> buildListWithRepeatedValues(List<T> list) throws NullPointerException {
        if (list == null) {
            throw new NullPointerException();
        }

        List<T> result = new LinkedList<>();
        List<T> alreadyProcessed = new LinkedList<>();

        for (T value : list) {
            // Verificamos si ya hemos añadido este valor a la lista de resultados
            boolean alreadyInResult = false;

            for (T t : result) {
                if (t.equals(value)) {
                    alreadyInResult = true;
                    break;
                }
            }

            if (!alreadyInResult) {
                // Verificamos si ya hemos procesado este valor
                boolean processed = alreadyProcessed(alreadyProcessed, value);

                if (!processed) {
                    // Contamos ocurrencias
                    int count = countValueAppearances(list, value);
                    if (count > 1) {
                        result.addLast(value);
                    }
                    alreadyProcessed.addLast(value);
                }
            }
        }

        return result;
    }

    // Exercise 6: Verifica si una terna con el valor especificado existe en la lista
    private static <T> boolean countTuplesWithAValue(List<Terna<T>> list, T value) {

        for (Terna<T> terna : list) {
            if (terna.getValue().equals(value)) {
                return true;
            }
        }

        return false;
    }

    // Exercise 6: Construye una lista resumen
    public static <T> List<Terna<T>> buildSummaryList(List<T> list1, List<T> list2) throws NullPointerException {
        if (list1 == null || list2 == null) {
            throw new NullPointerException();
        }

        List<Terna<T>> result = new LinkedList<>();
        List<T> processedValues = new LinkedList<>();

        // Procesamos los valores de list1
        for (T value : list1) {
            // Verificamos si ya hemos procesado este valor
            boolean processed = alreadyProcessed(processedValues, value);

            if (!processed) {
                int count1 = countValueAppearances(list1, value);
                int count2 = countValueAppearances(list2, value);
                result.addLast(new Terna<>(value, count1, count2));
                processedValues.addLast(value);
            }
        }

        // Procesamos los valores de list2 que no están en list1
        for (T value : list2) {
            // Verificamos si ya hemos procesado este valor
            boolean processed = alreadyProcessed(processedValues, value);

            if (!processed) {
                int count1 = 0; // No está en list1
                int count2 = countValueAppearances(list2, value);
                result.addLast(new Terna<>(value, count1, count2));
                processedValues.addLast(value);
            }
        }

        return result;
    }

    // Exercise 7: Cuenta valores iguales a la suma de los precedentes
    public static int countValuesEqualSumPreceding(List<Integer> list) throws NullPointerException {
        if (list == null) {
            throw new NullPointerException();
        }

        if (list.isEmpty()) {
            return 0;
        }

        int count = 0;
        int sum = 0;

        for (Integer current : list) {
            if (current == sum) {
                count++;
            }
            sum += current;
        }

        return count;
    }

    // Exercise 8: Devuelve elementos de las posiciones especificadas
    public static <T> List<T> printLots(List<T> list, List<Integer> index) throws NullPointerException {
        if (list == null || index == null) {
            throw new NullPointerException();
        }

        List<T> result = new LinkedList<>();

        for (int position : index) {
            Iterator<T> listIt = list.iterator();
            int currentPos = 1;

            while (listIt.hasNext() && currentPos <= position) {
                T value = listIt.next();
                if (currentPos == position) {
                    result.addLast(value);
                    break;
                }
                currentPos++;
            }
        }

        return result;
    }

    // Exercise 9: Duplica los valores de una lista
    public static void duplicateValues(List<Integer> list) throws NullPointerException {
        if (list == null) {
            throw new NullPointerException();
        }

        IteratorList<Integer> it = list.iteratorList();

        while (it.hasNext()) {
            Integer value = it.next();
            it.setPrevious(value * 2);
        }
    }

    // Exercise 10: Devuelve el médico con más pacientes
    //CHUO: Complejo Hospitalario Universitario de Ourense
    public static Integer getMorePatients(Hospital chuo) {
        if (chuo == null || chuo.getDoctors() == null || chuo.getDoctors().isEmpty()) {
            return null;
        }

        int maxPatients = -1;
        Integer doctorNumber = null;

        for (Doctor doctor : chuo.getDoctors()) {
            int patientCount = doctor.getPatients().size();

            if (patientCount >= maxPatients) {
                maxPatients = patientCount;
                doctorNumber = doctor.getNumero();
            }
        }

        return doctorNumber;
    }

    private static <T> boolean alreadyProcessed(List<T> list, T item) {
        for (T processedValue : list) {
            if (processedValue.equals(item)) {
                return true;
            }
        }
        return false;
    }
}