import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner sc = new Scanner(System.in);
    School school = new School();
    static Classroom[] classrooms;
    static Student[] students = new Student[2];


    public static void main(String[] args) {

        howMuchClass();
        while (true) {
            menu();
            System.out.print("Prosesi secin: ");
            int proses = sc.nextInt();
            sc.nextLine();

            switch (proses) {
                case 1:
                    showAllClass();
                    break;
                case 2:
                    showAllTeacher();
                    break;
                case 3:
                    showAllStudent();
                    break;
                case 4:
                    getClassIdShowStudent();
                    break;
                case 5:
                    addTeacher();
                    break;
                case 6:
                    addStudent();
                    break;
                case 7:
                    addClass();
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("1 -Butun Sinifleri gor.");
        System.out.println("2 -Butun Mellimleri gor.");
        System.out.println("3 -Butun Telebeleri gor.");
        System.out.println("4 -ClassId-ye gore sinifdeki telebeleri gor.");
        System.out.println("5 -Sinife mellim elave et.");
        System.out.println("6 -Sinife telebe elave et.");
        System.out.println("7 -Mektebe sinif elave et.");
    }

    public static void howMuchClass() {
        System.out.print("Nece eded sinif elave edilsin: ");
        int classCount = sc.nextInt();
        classrooms = new Classroom[classCount];
    }

    public static void addClass() {
        System.out.print("Sinifin adini daxil edin: ");
        String className = sc.nextLine();
        boolean check = true;
        int classNo = 0;
        while (check) {
            System.out.print("Sinifin Nomresini daxil edin: ");
            classNo = sc.nextInt();
            for (Classroom classroom : classrooms) {
                if (classroom != null && classNo == classroom.uniqueNo) {
                    check = true;
                    break;
                } else
                    check = false;
            }
        }
        Classroom classroom = new Classroom(className, classNo);
        boolean check1 = true;
        for (int i = 0; i < classrooms.length; i++) {
            if (classrooms[i] == null) {
                classrooms[i] = classroom;
                check1 = false;
                break;
            }
        }
        if (check1) {
            Classroom[] newClassroom = new Classroom[classrooms.length * 2];
            for (int i = 0; i < classrooms.length; i++) {
                newClassroom[i] = classrooms[i];
            }
            newClassroom[classrooms.length] = classroom;
            classrooms = newClassroom;
        }
    }

    public static void addTeacher() {

        System.out.print("Mellimi elave edeceyiniz sinifin No daxil edin: ");
        int sinifNo = sc.nextInt();
        sc.nextLine();
        for (Classroom classroom : classrooms) {
            if (sinifNo == classroom.uniqueNo) {

                System.out.print("Mellimin adini elave edin: ");
                String teacherName = sc.nextLine();
                System.out.print("Mellimin soyadini elave edin: ");
                String teacherSurname = sc.nextLine();
                System.out.print("Mellimin yasini elave edin: ");
                int teacherAge = sc.nextInt();
                System.out.print("Mellimin maasini elave edin: ");
                int teacherSalary = sc.nextInt();

                Teacher teacher = new Teacher(teacherName, teacherSurname, teacherAge, teacherSalary);
                classroom.teacher = teacher;
            }
        }
    }

    public static void addStudent() {

        System.out.print("Telebeni elave edeceyiniz sinifin No daxil edin: ");
        int sinifNo = sc.nextInt();
        sc.nextLine();
        for (Classroom classroom : classrooms) {
            if (classroom != null && sinifNo == classroom.uniqueNo) {
                System.out.print("Telebenin adini daxil edin: ");
                String studentName = sc.nextLine();
                System.out.print("Telebenin soyadini daxil edin: ");
                String studentSurname = sc.nextLine();
                System.out.print("Telebenin yasini daxil edin: ");
                int studentAge = sc.nextInt();
                System.out.print("Telebenin balini daxil edin: ");
                int studentPoint = sc.nextInt();

                Student student = new Student(studentName, studentSurname, studentAge, studentPoint);

                boolean check4 = true;
                for (int i = 0; i < students.length; i++) {
                    if (students[i] == null) {
                        students[i] = student;
                        check4 = false;
                        break;
                    }
                }
                if (check4) {
                    Student[] newStudent = new Student[students.length * 2];
                    for (int i = 0; i < students.length; i++) {
                        newStudent[i] = students[i];
                    }
                    newStudent[students.length] = student;
                    students = newStudent;

                }
            }
        }
    }

    public static void showAllClass() {
        for (Classroom classroom : classrooms) {
            if (classroom != null) {
                System.out.println(classroom.toString());
            }
        }
    }

    public static void showAllTeacher() {
        for (Classroom classroom : classrooms) {
            if (classroom != null && classroom.teacher != null) {
                System.out.println(classroom.teacher.toString());
            }
        }
    }

    public static void showAllStudent() {
        for (Student student : students) {
            if (student != null) {
                System.out.println(student.toString());
            }
        }
    }

    public static void getClassIdShowStudent() {
        System.out.print("Sinif No daxil edin: ");
        int sinifNo = sc.nextInt();
        for (Classroom classroom : classrooms) {
            if (classroom != null && sinifNo == classroom.uniqueNo) {
                for (Student student : students) {
                    if (student != null) {
                        System.out.println(student.toString());
                    }
                }
            } else
                System.out.println("Sinif tapilmadi.");
        }
    }
}