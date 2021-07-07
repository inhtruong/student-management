package Modal;

public class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private double mathScore, physicScore, chemistryScore, gpa;

    public Student() {

    }

    public Student(int id, String name, int age, String address, double mathScore, double physicScore, double chemistryScore) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.mathScore = mathScore;
        this.physicScore = physicScore;
        this.chemistryScore = chemistryScore;
    }

    public Student(int id, String name, int age, String address, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getPhysicScore() {
        return physicScore;
    }

    public void setPhysicScore(double physicScore) {
        this.physicScore = physicScore;
    }

    public double getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(double chemistryScore) {
        this.chemistryScore = chemistryScore;
    }

    public double getGpa() {
        return gpa ;
    }

    public void setGpa(double gpa) {
        this.gpa = (mathScore + physicScore + chemistryScore) / 3;
    }

    @Override
    public String toString() {
        return "Modal.Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
