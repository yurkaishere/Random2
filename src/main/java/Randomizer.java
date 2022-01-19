import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Randomizer {
    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    /** Let's rock this joint */
    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Input first number: ");
        int firstNumber = Integer.parseInt(bufferedReader.readLine());
        System.out.print("Input second number: ");
        int lastNumber = Integer.parseInt(bufferedReader.readLine());
        createListOfNumbers(firstNumber, lastNumber);

        while (true) {
            if (getNumbers().size() == 0) {
                System.out.println("<< There are no more numbers >>");
                break;
            }

            System.out.print("<< " + getRandomNumber() + " >>" + "\n" +
                    "Press any key to continue (0 - exit)...");
            String s = bufferedReader.readLine();

            if (s.equals("0")) {
                break;
            }
        }
    }

    /** Create list of Numbers */
    public void createListOfNumbers(int firstNumber, int lastNumber) {
        int size = lastNumber - firstNumber + 1; // size includes last element that's why we increase it on 1
        for (int i = 0; i < size; i++) {
            numbers.add(firstNumber++); // filling list with elements
        }
    }

    /** Get random number from List and remove this number to exclude repeat */
    public int getRandomNumber() {
        Collections.shuffle(numbers); // shuffle List
        int result = numbers.get(0);
        numbers.remove(0);
        return result;
    }

}
