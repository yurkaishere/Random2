public class Student implements Comparable<Student> {
    private int id;
    private int groupId;
    private String lastName;
    private String firstName;
    private int score;

    public Student(int id, int groupId, String lastName, String firstName, int score) {
        this.id = id;
        this.groupId = groupId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + getLastName() + " " + getFirstName() + " из команды №" + groupId;
    }

    @Override
    public int compareTo(Student other) {
        return this.id - other.id;
    }
}
