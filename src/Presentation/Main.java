package Presentation;

import Service.StudentManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;
        String choose_menu = null;
        boolean exit = false;
        StudentManager studentManager = new StudentManager();
        int studentId;

        // SHOW LOG IN
        showLogin();
        while (true) {
            choose = new Scanner(System.in).nextLine();
            switch (choose) {
                case "1":
                    showMenu();
                    while (true) {
                        choose_menu = scanner.nextLine();
                        switch (choose_menu) {
                            case "1":
                                studentManager.add();
                                break;
                            case "2":
                                studentId = studentManager.inputId();
                                studentManager.edit(studentId);
                                break;
                            case "3":
                                studentId = studentManager.inputId();
                                studentManager.delete(studentId);
                                break;
                            case "4":
                                studentManager.sortStudentByGPA();
                                break;
                            case "5":
                                studentManager.sortStudentByName();
                                break;
                            case "6":
                                studentManager.show();
                                break;
                            case "7":
                                studentManager.findStudentByName();
                                break;
                            case "0":
                                showLogin();
                                break;
                            default:
                                System.out.println("invalid! please choose action in below menu:");
                                break;
                        }
                        if (choose_menu.equals("0")) {
                            break;
                        }
                        // show menu
                        showMenu();
                    }
                    break;
                case "2":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                break;
            }
        }
    }

    /**
     * create menu
     */
    private static void showMenu() {
        System.out.println("-----------MENU------------");
        System.out.println("1. Add student.");
        System.out.println("2. Edit student by ID.");
        System.out.println("3. Delete student by ID.");
        System.out.println("4. Sort student by Gpa.");
        System.out.println("5. Sort student by Name.");
        System.out.println("6. Show student.");
        System.out.println("7. Find student by Name.");
        System.out.println("0. Log out.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }

    /*
     * create login
     */
    private static void showLogin() {
        System.out.println("-----------LOGIN------------");
        System.out.println("1. LOG IN.");
        System.out.println("2. EXIT.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
}
