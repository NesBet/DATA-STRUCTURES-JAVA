public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private double GPA;

    public Student(String first, String last, double gradeAverage) {
        firstName = first;
        lastName = last;
        GPA = gradeAverage;
    }

    public int compareTo(Student otherStudent) {
        int GPACompare = Double.compare(otherStudent.GPA, GPA);
        if (GPACompare != 0) {
            return GPACompare;
        }
        int lastNameCompare = lastName.compareTo(otherStudent.lastName);
        if (lastNameCompare != 0) {
            return lastNameCompare;
        }
        return firstName.compareTo(otherStudent.firstName);
    }

    public String toString() {
        return String.format("%.2f", GPA) + " " + lastName + ", " + firstName;
    }
}

