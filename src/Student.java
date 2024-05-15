public class Student extends Human{
    public int point;

    public Student(String name, String surname, int age, int point) {
        super(name, surname, age);
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" +
                "point=" + point +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
