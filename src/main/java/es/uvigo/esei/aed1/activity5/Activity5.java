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
        return null;
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
        return null;
    }

    //Exercise 6
    public static <T> T unstackAnItem(Stack<T> stack, int index) throws NullPointerException, IllegalArgumentException {
        return null;
    }

    //Exercice 7
    public static boolean isWellParentized(String mathExpression) {
        return true;
    }

    //Exercise 8
    public static String addDigits(int number) {
        Stack<Integer> newStack = new LinkedStack<>();
        int tmp = 0;
        int sum =0;
        while(number != 0) {
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
        return null;
    }

    //Exercise 10
    public static <T> void replaceValues(Stack<T> stack, T newValue, T oldValue) throws NullPointerException {

    }

    //Exercise 11
    public static <T> void pushValuesLimited(Stack<T> stack, T value) throws NullPointerException {

    }

}
