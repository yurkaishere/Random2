import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Randomizer {
    private final List<Student> students = new ArrayList<>();

    /** Let's rock this joint */
    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        createListOfStudents();
        Collections.shuffle(students);

        if (students.size() == 0) {
            System.out.println("<< Список пуст >>");
        }

        for (int i = 0; i < students.size() - 1; i++) {

            Student firstStudent = students.get(i);
            Student nextStudent = students.get(i + 1);

            System.out.println("> задаёт вопрос: " + firstStudent);
            System.out.println("> отвечает: " + nextStudent);

            System.out.print("Сколько балов начисляем для " + firstStudent.getLastName() + ": ");
            firstStudent.setScore(Integer.parseInt(bufferedReader.readLine()));

            System.out.print("Сколько балов начисляем для " + nextStudent.getLastName() + ": ");
            nextStudent.setScore(Integer.parseInt(bufferedReader.readLine()));

            System.out.println("---------------------------------------------------");
            System.out.println("Нажмите любую кнопку для продолжения (0 - выход)...");
            System.out.print("---------------------------------------------------");
            String s = bufferedReader.readLine();

            if (i == students.size() - 2) {
                System.out.println("Больше никого нет");
            }

            if (s.equals("0")) {
                break;
            }
        }

        showResults();
    }

    /** Create list of Numbers */
    public void createListOfStudents() {
        students.add(new Student(1, 1, "Ананьев", "Максим", 0));
        students.add(new Student(2, 1, "Симонов", "Юрий", 0));
        students.add(new Student(3, 1, "Полтараков", "Егор", 0));
        students.add(new Student(4, 1, "Деревяго", "Роман", 0));
    }

    public void showResults() {
        Collections.sort(students);
        System.out.println(AsciiTable.getTable(students, Arrays.asList(
                new Column().with(planet -> Integer.toString(planet.getId())),
                new Column().header("Group").with(planet -> Integer.toString(planet.getGroupId())),
                new Column().header("Last name").with(Student::getLastName),
                new Column().header("First name").with(Student::getFirstName),
                new Column().header("Score").with(planet -> Integer.toString(planet.getScore())))));
    }

}
