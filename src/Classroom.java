public class Classroom {
    public String className;
    public int uniqueNo;
    public Teacher teacher;
    public Student[] students;

    public Classroom(String className, int uniqueNo) {
        this.className = className;
        this.uniqueNo = uniqueNo;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "className='" + className + '\'' +
                ", uniqueNo=" + uniqueNo +
                '}';
    }
}
