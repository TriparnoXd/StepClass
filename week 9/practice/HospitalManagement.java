<<<<<<< HEAD
class Hospital {
    private String name;

    public Hospital(String name) {
        this.name = name;
    }

    public class Department {
        private String deptName;

        public Department(String deptName) {
            this.deptName = deptName;
        }

        public void displayInfo() {
            System.out.println("Hospital: " + name + ", Department: " + deptName);
        }
    }

    public Department createDepartment(String deptName) {
        return new Department(deptName);
    }}

public class HospitalManagement {
    public static void main(String[] args) {
        Hospital h1 = new Hospital("CityCare Hospital");
        Hospital.Department d1 = h1.createDepartment("Cardiology");
        Hospital.Department d2 = h1.createDepartment("Neurology");
        d1.displayInfo();
        d2.displayInfo();
    }
=======
class Hospital {
    private String name;

    public Hospital(String name) {
        this.name = name;
    }

    public class Department {
        private String deptName;

        public Department(String deptName) {
            this.deptName = deptName;
        }

        public void displayInfo() {
            System.out.println("Hospital: " + name + ", Department: " + deptName);
        }
    }

    public Department createDepartment(String deptName) {
        return new Department(deptName);
    }}

public class HospitalManagement {
    public static void main(String[] args) {
        Hospital h1 = new Hospital("CityCare Hospital");
        Hospital.Department d1 = h1.createDepartment("Cardiology");
        Hospital.Department d2 = h1.createDepartment("Neurology");
        d1.displayInfo();
        d2.displayInfo();
    }
>>>>>>> 6d63c2f52c06b2d053d3b67fb5bd230721991e48
}