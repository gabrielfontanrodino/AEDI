package es.uvigo.esei.aed1.activity5;

import es.uvigo.esei.aed1.tads.stack.LinkedStack;
import es.uvigo.esei.aed1.tads.stack.Stack;


public class Activity5 {

    //Exercise 1
    public static String reverseWords(String text) {
        Stack<Character> list = new LinkedStack<>();
        StringBuilder sb = new StringBuilder();

        String[] words = text.split(" ");

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                list.push(word.charAt(i));
            }
            while (!list.isEmpty()) {
                sb.append(list.pop());
            }

            if (!words[words.length - 1].equals(word)) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    //Exercise 2 i
    public static <T> boolean equalStacks(Stack<T> stack1, Stack<T> stack2) throws NullPointerException {
        if (stack1 == null || stack2 == null) {
            throw new NullPointerException("One of the stacks is null");
        }

        while (!stack1.isEmpty() || !stack2.isEmpty()) { //Will throw NullPointerException if any of the stacks is null
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }

    //Exercise 2 ii
    public static <T> Stack<T> copy(Stack<T> stack) throws NullPointerException {
        if (stack == null) {
            throw new NullPointerException("The stack is null");
        }

        Stack<T> newStack = new LinkedStack<>();
        Stack<T> auxStack = new LinkedStack<>();

        while (!stack.isEmpty()) {
            auxStack.push(stack.pop());
        }

        while (!auxStack.isEmpty()) {
            T value = auxStack.pop();
            stack.push(value); //IMPORTANTE PORQUE SI NO, SE MODIFICA EL STACK ORIGINAL Y QUEDA VACÍO
            newStack.push(value);
        }

        return newStack;
    }

    //Exercise 3
    public static String fromBase10ToBase2(int numberBase10) {
        Stack<Integer> stack = new LinkedStack<>();
        StringBuilder sb = new StringBuilder();

        //1. Hacemos la división entera del número por 2 y vamos guardamos el resto hasta que el número sea 0 (es decir, hasta que no haya más dígitos)
        while (numberBase10 != 0) {
            //Obtenemos el resto
            int remainder = numberBase10 % 2;
            //Lo añadimos al stack
            stack.push(remainder);
            //Dividimos el número entre 2
            numberBase10 /= 2;
        }


        //Como el número se ha guardado al revés, lo sacamos del stack y ya lo tenemos en el orden correcto
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    //Exercise 4
    public static int getNumDiamonds(String sand) {
        int diamonds = 0;
        char caracter;
        Stack<Character> stack = new LinkedStack<>();

        for (int i = 0; i < sand.length(); i++) {
            caracter = sand.charAt(i);

            switch (caracter) {
                case '<' -> stack.push(sand.charAt(i));
                case '>' -> {
                    if (!stack.isEmpty() && stack.pop() == '<') {
                        diamonds++;
                    }
                }
            }
        }

        return diamonds;
    }

    //Exercise 5
    public static String codifyMessage(String message) {
        Stack<Character> stack = new LinkedStack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char caracter = message.charAt(i);

            // Si el carácter no es una vocal, se apila para invertir su orden más adelante
            if (!isVowel(caracter)) {
                stack.push(caracter);
            } else {
                // Si se encuentra una vocal, se desapilan (e invierten) los caracteres acumulados
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                // Se añade la vocal o el espacio directamente al resultado
                sb.append(caracter);
            }
        }

        // Si quedan caracteres no vocales sin procesar al final, se vacía la pila
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static <T> T unstackAnItem(Stack<T> stack, int index) throws NullPointerException, IllegalArgumentException {
        if (stack == null) {
            throw new NullPointerException("The stack is null");
        }

        if (stack.isEmpty()) {
            throw new IllegalArgumentException("The stack is empty");
        }

        // Verificamos que el índice sea válido (entre 1 y el tamaño de la pila)
        if (index < 1 || index > stack.size()) {
            throw new IllegalArgumentException("Index out of bounds: must be between 1 and " + stack.size());
        }

        // Pila auxiliar para almacenar temporalmente los elementos
        Stack<T> auxStack = new LinkedStack<>();
        T itemToReturn;

        // Desapilamos elementos hasta llegar al índice deseado
        // Recordar que 1 es el tope de la pila, así que necesitamos desapilar (index-1) elementos
        for (int i = 1; i < index; i++) {
            auxStack.push(stack.pop());
        }

        // Extraemos el elemento deseado
        itemToReturn = stack.pop();

        // Volvemos a apilar los elementos que sacamos temporalmente
        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }


        return itemToReturn;
    }

    //Exercice 7
    public static boolean isWellParentized(String mathExpression) {
        Stack<Character> stack = new LinkedStack<>();

        for (int i = 0; i < mathExpression.length(); i++) {
            char c = mathExpression.charAt(i);

            switch (c) {
                // Si es algún carácter de apertura, se añade al stack
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;

                // Si es de cierre, se verifica si hay coincidencia con el del tope
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) return false;
                    char open = stack.pop();
                    if (!isMatchingPair(open, c)) return false;
                    break;

                // Si no es alguno de los anteriores, se ignora
                default:
                    break;
            }
        }

        // Si la pila está vacía, todos los paréntesis están balanceados
        return stack.isEmpty();
    }


    private static boolean isMatchingPair(char open, char close) {
        return switch (open) {
            case '(' -> close == ')';
            case '[' -> close == ']';
            case '{' -> close == '}';
            default -> false;
        };
    }

    //Exercise 8
    public static String addDigits(int number) {
        Stack<Integer> newStack = new LinkedStack<>();
        int tmp;
        int sum = 0;
        while (number != 0) {
            tmp = number % 10;
            newStack.push(tmp);
            number /= 10;
        }

        StringBuilder sb = new StringBuilder();

        while (!newStack.isEmpty()) {
            int value = newStack.pop();
            sum += value;
            sb.append(value);

            if (!newStack.isEmpty()) {
                sb.append(" + ");
            }
        }

        sb.append(" = ");
        sb.append(sum);

        return sb.toString();
    }

    //Exercise 9
    public static String removeCharDuplicated(String text) {
        if (text == null || text.isEmpty() || text.length() == 1) {
            return text; // Casos base: texto vacío o con un solo carácter
        }

        // Creamos una pila para ir almacenando los caracteres
        Stack<Character> stack = new LinkedStack<>();

        // Procesamos el texto para eliminar duplicados adyacentes una primera vez
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            // Si la pila no está vacía y el carácter actual coincide con el tope de la pila,
            // eliminamos el duplicado sacando el elemento de la pila
            if (!stack.isEmpty() && stack.top() == current) {
                stack.pop();
            } else {
                // Si no es un duplicado, lo añadimos a la pila
                stack.push(current);
            }
        }

        // Construimos un String a partir de la pila resultante
        StringBuilder sb = new StringBuilder();
        Stack<Character> tempStack = new LinkedStack<>();

        // Invertimos la pila para mantener el orden original de los caracteres
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        // Construimos el String resultado
        while (!tempStack.isEmpty()) {
            sb.append(tempStack.pop());
        }

        String result = sb.toString();

        // Si el resultado es igual al texto original, significa que ya no hay más duplicados
        // adyacentes por eliminar y podemos retornar
        if (result.equals(text)) {
            return result;
        } else {
            // Si el resultado es diferente, aplicamos la eliminación recursivamente
            // para eliminar nuevos duplicados adyacentes que puedan haberse formado
            return removeCharDuplicated(result);
        }
    }

    //Exercise 10
    public static <T> void replaceValues(Stack<T> stack, T newValue, T oldValue) throws NullPointerException {
        if (stack == null) {
            throw new NullPointerException("The stack is null");
        }

        Stack<T> auxStack = new LinkedStack<>();

        while (!stack.isEmpty()) {
            T value = stack.pop();
            if (value.equals(oldValue)) {
                auxStack.push(newValue);
            } else {
                auxStack.push(value);
            }
        }

        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
    }

    public static <T> void pushValuesLimited(Stack<T> stack, T value) throws NullPointerException {
        // Verificar si stack es null
        if (stack == null) {
            throw new NullPointerException("La pila no puede ser null");
        }

        // Verificar si value es null (esto podría ser redundante si stack.push() ya verifica esto)
        if (value == null) {
            throw new NullPointerException("El valor a insertar no puede ser null");
        }

        // Tamaño máximo de la pila limitada
        final int MAX_SIZE = 10;

        // Si la pila ya tiene MAX_SIZE elementos, debemos eliminar el elemento más antiguo
        if (stack.size() >= MAX_SIZE) {
            // Para eliminar el elemento más antiguo (el del fondo), necesitamos
            // extraer todos los elementos excepto el último, almacenarlos temporalmente,
            // y luego volver a insertarlos

            // Pila auxiliar para almacenar temporalmente los elementos
            Stack<T> tempStack = new LinkedStack<>();

            // Extraer todos los elementos excepto el último (más antiguo)
            // y guardarlos en la pila temporal
            for (int i = 0; i < MAX_SIZE - 1; i++) {
                tempStack.push(stack.pop());
            }

            // Descartar el elemento más antiguo
            stack.pop();

            // Devolver los elementos a la pila original en el orden correcto
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
        }

        // Finalmente, insertamos el nuevo valor
        stack.push(value);
    }

}
