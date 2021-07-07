package Service;

import Data.StudentWRFile;
import Modal.Student;
import Service.CheckRegex;
import Service.SortStudentByGPA;
import Service.SortStudentByName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static Service.CheckRegex.*;

public class StudentManager {
    public static Scanner scan = new Scanner(System.in);
    private static List<Student> studentList = new ArrayList<>();
    private static int SIZE = studentList.size();
    private StudentWRFile studentWRFile;

    public StudentManager() {
        studentWRFile = new StudentWRFile();
        studentList = studentWRFile.readFile();
    }

    public void add() {
        int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
        System.out.println("student id = " + id);
        String name = inputName();
        int age = inputAge();
        String address = inputAddress();
        double mathSroce = inputMathSroce();
        double phySroce = inputPhysicSroce();
        double chemSroce = inputChemistrySroce();
        double gpa = (mathSroce + phySroce + chemSroce) / 3;

        Student student = new Student(id, name, age, address, gpa);
        studentList.add(student);
        studentWRFile.writeFile(studentList);
    }

    public void edit(int id) {
        boolean isExisted = false;
        for (int i = 0; i < SIZE; i++) {
            if (studentList.get(i).getId() == (id)) {
                isExisted = true;
                printStudent(studentList.get(i));
                studentList.get(i).setName(inputName());
                studentList.get(i).setAge(inputAge());
                studentList.get(i).setAddress(inputAddress());
                studentList.get(i).setMathScore(inputMathSroce());
                studentList.get(i).setPhysicScore(inputPhysicSroce());
                studentList.get(i).setChemistryScore(inputChemistrySroce());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            studentWRFile.writeFile(studentList);
        }
    }

    public void delete(int id) {
        Student student = null;

        for (int i = 0; i < SIZE; i++) {
            if (studentList.get(i).getId() == id) {
                System.out.println("The student you want to remove from the list");
                printStudent(studentList.get(i));
                student = studentList.get(i);
                break;
            }
        }

        if (student != null) {
            System.out.println("You do not regret it? Yes or No.");
            String access = scan.next();

            if (access.contentEquals("Yes")) {
                studentList.remove(student);
                System.out.println("Successful Delete!!");
                for (int i = 0; i < SIZE; i++) {
                    if (studentList.get(i).getId() > student.getId()) {
                        studentList.get(i).setId(studentList.get(i).getId() - 1);
                    }
                }
                studentWRFile.writeFile(studentList);
            } else {
                System.out.println("Failed Delete!!");
            }
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }

    public void sortStudentByName() {
        Collections.sort(studentList, new SortStudentByName());
    }


    public void sortStudentByGPA() {
        Collections.sort(studentList, new SortStudentByGPA());
    }

    public void findStudentByName() {
        Student student = null;
        String nameStudent = scan.nextLine();
        for (int i = 0; i < SIZE; i++) {
            if (studentList.get(i).getName().equalsIgnoreCase(nameStudent)){
                printStudent(studentList.get(i));
            }
        }
    }


    public void show() {
        try {
            studentList = studentWRFile.readFile();
            for (Student student : studentList) {
                printStudent(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int inputId() {
        System.out.print("Input student id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scan.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }

    private String inputName() {
        System.out.print("Input student name: ");
        String name = scan.nextLine();
        while (!checkNameStudent(name)) {
            System.out.println("Student name does not match. Please re-enter!!");
            System.out.print("Input student name: ");
            name = scan.nextLine();
        }
        return name;
    }


    private String inputAddress() {
        System.out.print("Input student address: ");
        String address = scan.nextLine();
        while (!checkAddressStudent(address)) {
            System.out.println("Student address does not match. Please re-enter!!");
            System.out.print("Input student address: ");
            address = scan.nextLine();
        }
        return address;
    }

    private int inputAge() {
        System.out.print("Input student age: ");
        String age = scan.nextLine();
        while (!checkAgeStudent(age)) {
            System.out.println("Student age does not match. Please re-enter!!");
            System.out.print("Input student age: ");
            age = scan.nextLine();
        }
        return Integer.parseInt(age);
    }

    private double inputMathSroce() {
        System.out.print("Input student math sroce: ");
        String mathSroce = scan.nextLine();
        while (!checkSroceStudent(mathSroce)) {
            System.out.println("Student math sroce does not match. Please re-enter!!");
            System.out.print("Input student math sroce: ");
            mathSroce = scan.nextLine();
        }
        return Double.parseDouble(mathSroce);
    }

    private double inputPhysicSroce() {
        System.out.print("Input student physic score: ");
        String phyScore = scan.nextLine();
        while (!checkSroceStudent(phyScore)) {
            System.out.println("Student physic score does not match. Please re-enter!!");
            System.out.print("Input student physic score: ");
            phyScore = scan.nextLine();
        }
        return Double.parseDouble(phyScore);
    }

    private double inputChemistrySroce() {
        System.out.print("Input student chemistry sroce: ");
        String chemSroce = scan.nextLine();
        while (!checkSroceStudent(chemSroce)) {
            System.out.println("Student chemistry sroce does not match. Please re-enter!!");
            System.out.print("Input student chemistry sroce: ");
            chemSroce = scan.nextLine();
        }
        return Double.parseDouble(chemSroce);
    }

    private static void printStudent(Student student) {
        System.out.format("%5d | ", student.getId());
        System.out.format("%20s | ", student.getName());
        System.out.format("%5d | ", student.getAge());
        System.out.format("%20s | ", student.getAddress());
        System.out.format("%10.1f%n", student.getGpa());
    }

    //setter and getter
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
