package exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {

    private List<Integer> list;
    private static int SIZE = 10;
    PrintWriter out;

    public ListOfNumbers() {
        list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
    }

    public void writeList() throws IOException {
        // The FileWriter constructor throws IOException, which must be caught.
        out = new PrintWriter(new FileWriter("OutFile.txt"));
        int error;
        for (int i = 0; i < SIZE; i++) {
            // The get(int) method throws IndexOutOfBoundsException, which must be caught.
            out.println("Value at: " + i + " = " + list.get(i));
            if (i == 5) error = 1 / (5 - i);
        }
        out.close();
    }

    public static void main(String[] args) {

        ListOfNumbers listOfNumbers = null;
        try {
            listOfNumbers = new ListOfNumbers();
            listOfNumbers.writeList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // The finally block always executes when the try block exits.
            // This ensures that the finally block is executed even if an unexpected exception occurs.
            listOfNumbers.out.close();
            System.out.println("Finally block");
        }
    }
}