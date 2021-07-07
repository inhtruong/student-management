package Data;

import Modal.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentWRFile {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String STUDENT_FILE_NAME = "src\\Data\\student.csv";

    public static void writeFile(List<Student> studentList) {
        File f = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            f = new File(STUDENT_FILE_NAME);

            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);

            for(Student student : studentList) {
                bw.append(String.valueOf(student.getId()));
                bw.append(COMMA_DELIMITER);
                bw.append(student.getName());
                bw.append(COMMA_DELIMITER);
                bw.append(String.valueOf(student.getAge()));
                bw.append(COMMA_DELIMITER);
                bw.append(student.getAddress());
                bw.append(COMMA_DELIMITER);
                bw.append(String.valueOf(student.getMathScore()));
                bw.append(COMMA_DELIMITER);
                bw.append(String.valueOf(student.getPhysicScore()));
                bw.append(COMMA_DELIMITER);
                bw.append(String.valueOf(student.getChemistryScore()));
                bw.append(COMMA_DELIMITER);
                bw.append(String.valueOf(String.format("%,1f",student.getGpa())));
                bw.append(NEW_LINE_SEPARATOR);

            }
            System.out.println("CSV file was created successfully!!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public static List<Student> readFile() {
        List<Student> studentList = new ArrayList<>();
        File f = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            String line;
            f = new File(STUDENT_FILE_NAME);
            if (!f.exists()) {
                writeFile(studentList);
            } else {
                System.out.println("File already exists.");
            }

            fr = new FileReader(f);
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {

                String[] student = line.split(COMMA_DELIMITER);
                Student student1 = new Student();
                student1.setId(Integer.parseInt(student[0]));
                student1.setName(student[1]);
                student1.setAge(Integer.parseInt(student[2]));
                student1.setAddress(student[3]);
                student1.setMathScore(Double.parseDouble(student[4]));
                student1.setPhysicScore(Double.parseDouble(student[5]));
                student1.setChemistryScore(Double.parseDouble(student[6]));
                student1.setGpa(Double.parseDouble(student[7]));
                studentList.add(student1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }

        return studentList;
    }

//    private static List<String> parseCsvLine(String csvLine) {
//        List<String> studentList = new ArrayList<String>();
//
//        if (csvLine != null) {
//            String[] splitData = csvLine.split(COMMA_DELIMITER);
//            for (int i = 0; i < splitData.length; i++) {
//
//            }
//        }
//        return studentList;
//    }

//    private static void printStudent(List<Student> studentList) {
//        System.out.println("Modal.Student [id=" + studentList.get(0) +
//                                    ", name='" + studentList.get(1) + '\'' +
//                                    ", age=" + studentList.get(2) +
//                                    ", address='" + studentList.get(3) + '\'' +
//                                    ", gpa=" + studentList.get(4) +
//                            "]");
//    }
}
