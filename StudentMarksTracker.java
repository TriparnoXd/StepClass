class Student {
    String name;
    int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }
}

public class StudentMarksTracker {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("Alice", new int[]{85, 90, 78});
        students[1] = new Student("Bob", new int[]{92, 88, 95});
        students[2] = new Student("Charlie", new int[]{75, 80, 82});

        Student topStudent = students[0];
        double highestAverage = students[0].calculateAverage();

        for (int i = 1; i < students.length; i++) {
            double currentAverage = students[i].calculateAverage();
            if (currentAverage > highestAverage) {
                highestAverage = currentAverage;
                topStudent = students[i];
            }
        }

        System.out.println("Student with the highest average marks: " + topStudent.name);
        System.out.println("Highest average marks: " + highestAverage);
    }
}