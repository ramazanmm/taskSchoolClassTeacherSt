public class Teacher extends Human{
    public int salary;

    public Teacher(String name, String surname, int age, int salary) {
        super(name, surname, age);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
