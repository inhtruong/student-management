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
    private List<Student> studentList = new ArrayList<>();
    private StudentWRFile studentWRFile;

    public StudentManager() {
        studentWRFile = new StudentWRFile();
//        studentList = studentWRFile.readFile();
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

        Student student = new Student(id, name, age, address, mathSroce, phySroce, chemSroce, gpa);
        studentList.add(student);
        studentWRFile.writeFile(studentList);
    }

    public void edit(int id) {
        boolean isExisted = false;
        int SIZE = studentList.size();

        for (int i = 0; i < SIZE; i++) {
            if (studentList.get(i).getId() == id) {
                isExisted = true;
                printStudent(studentList.get(i));

                int idStu = studentList.get(i).getId();
                String name = inputName();
                int age = inputAge();
                String address = inputAddress();
                double mathSroce = inputMathSroce();
                double phySroce = inputPhysicSroce();
                double chemSroce = inputChemistrySroce();
                double gpa = (mathSroce + phySroce + chemSroce) / 3;

                Student student = new Student(idStu, name, age, address, mathSroce, phySroce, chemSroce, gpa);

                studentList.get(i).setName(student.getName());
                studentList.get(i).setAge(student.getAge());
                studentList.get(i).setAddress(student.getAddress());
                studentList.get(i).setMathScore(student.getMathScore());
                studentList.get(i).setPhysicScore(student.getPhysicScore());
                studentList.get(i).setChemistryScore(student.getChemistryScore());
                studentList.get(i).setGpa(student.getGpa());
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
        studentList = studentWRFile.readFile();
        int SIZE = studentList.size();

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
                try {
                    for (int i = 0; i < SIZE; i++) {
                        if (studentList.get(i).getId() > student.getId()) {
                            studentList.get(i).setId(studentList.get(i).getId() - 1);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    e.getMessage();
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
        List<Student> studentByNameList;
        studentByNameList = studentWRFile.readFile();
        Collections.sort(studentByNameList, new SortStudentByName());
        showStudent(studentByNameList);
//        Collections.sort(studentList, new SortStudentByName());
    }


    public void sortStudentByGPA() {
        List<Student> studentByGPAList;
        studentByGPAList = studentWRFile.readFile();
        Collections.sort(studentByGPAList, new SortStudentByGPA());
        showStudent(studentByGPAList);
        //        Collections.sort(studentList, new SortStudentByGPA());
    }

    public void findStudentByName() {
        int SIZE = studentList.size();

        System.out.print("Sreach Name: ");
        String nameStudent = scan.nextLine();

        System.out.println("Result: ");
        for (int i = 0; i < SIZE; i++) {
            if (studentList.get(i).getName().equalsIgnoreCase(nameStudent)){
                printStudent(studentList.get(i));
            }
        }
    }

    public void show() {
        studentList = studentWRFile.readFile();
        showStudent(studentList);
    }

    public int inputId() {
        System.out.print("Input student ID: ");
        String id = scan.nextLine();

        while (!checkId(id)) {
            System.out.println("Student ID does not match. Please re-enter!!");
            System.out.print("Input student ID: ");
            id = scan.nextLine();
        }
        return Integer.parseInt(id);
    }

    private String inputName() {
        System.out.print("Input student name (vd: Truong Dat):  ");
        String name = scan.nextLine();

        while (!checkNameStudent(name)) {
            System.out.println("Student name does not match. Please re-enter!!");
            System.out.print("Input student name (vd: Truong Dat): ");
            name = scan.nextLine();
        }
        return name;
    }


    private String inputAddress() {
        System.out.print("Input student address (vd: 29 Duong Van An): ");
        String address = scan.nextLine();

        while (!checkAddressStudent(address)) {
            System.out.println("Student address does not match. Please re-enter!!");
            System.out.print("Input student address (vd: 29 Duong Van An): ");
            address = scan.nextLine();
        }
        return address;
    }

    private int inputAge() {
        System.out.print("Input student age (0 to 200 years old) : ");
        String age = scan.nextLine();

        while (!checkAgeStudent(age)) {
            System.out.println("Student age does not match. Please re-enter!!");
            System.out.print("Input student age (0 to 200 years old) : ");
            age = scan.nextLine();
        }
        return Integer.parseInt(age);
    }

    private double inputMathSroce() {
        System.out.print("Input student math sroce (vd: 7.5): ");
        String mathSroce = scan.nextLine();

        while (!checkSroceStudent(mathSroce)) {
            System.out.println("Student math sroce does not match. Please re-enter!!");
            System.out.print("Input student math sroce (vd: 7.5): ");
            mathSroce = scan.nextLine();
        }
        convertInt(mathSroce);
        return Double.parseDouble(mathSroce);
    }

    private double inputPhysicSroce() {
        System.out.print("Input student physic score (vd: 7.5): ");
        String phyScore = scan.nextLine();

        while (!checkSroceStudent(phyScore)) {
            System.out.println("Student physic score does not match. Please re-enter!!");
            System.out.print("Input student physic score (vd: 7.5): ");
            phyScore = scan.nextLine();
        }
        convertInt(phyScore);
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
        convertInt(chemSroce);
        return Double.parseDouble(chemSroce);
    }

//    private double calculatorGPA() {
//        return (mathScore + inputPhysicSroce() + inputChemistrySroce()) / 3;
//    }

    private static void printStudent(Student student) {
        System.out.format("%5d | ", student.getId());
        System.out.format("%20s | ", student.getName());
        System.out.format("%5d | ", student.getAge());
        System.out.format("%20s | ", student.getAddress());
        System.out.format("%10.1f |", student.getMathScore());
        System.out.format("%10.1f |", student.getPhysicScore());
        System.out.format("%10.1f |", student.getChemistryScore());
        System.out.format("%10.1f%n", student.getGpa());
    }

    private void showStudent (List<Student> studentList) {
        try {
            for (Student student : studentList) {
                printStudent(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //setter and getter
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
