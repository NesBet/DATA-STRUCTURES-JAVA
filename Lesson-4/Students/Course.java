public class Course implements Comparable<Course> {
    private String department;
    private Integer number;

    public Course(String dept, Integer num) {
        department = dept;
        number = num;
    }

    public int compareTo(Course otherCourse) {
        int departmentCompare = department.compareTo(otherCourse.department);
        if (departmentCompare != 0) {
            return departmentCompare;
        }
        return number.compareTo(otherCourse.number);
    }

    public String toString() {
        return department + " " + number;
    }
}
