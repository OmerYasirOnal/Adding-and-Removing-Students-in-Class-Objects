import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Creating class
        System.out.print("What do you want to member's number: ");
        Course s = new Course("BP1");
        System.out.println();


        int studentNumber = s.getNbrStudent();

        System.out.println("Create your class:");
        System.out.println("Enter you want student's name to add: ");

        for (int i = 0; i <= studentNumber; i++) {
            s.AddStudent();
        }

        System.out.println("Adding successful");
        System.out.println();
        System.out.println("Your Class");
        s.printStudents();

        int askRemove;

        System.out.println("Is there anyone you want to remove or add?");
        System.out.println();

        do {
        //Loop to edit class

            System.out.print("For remove : 1, For add : 2, For exit : 3 = ");
            askRemove = sc.nextInt();

            if (askRemove == 1) {
                s.removeStudent();
            } else if(askRemove == 2){
                s.AddStudent();
            }

            System.out.println();
            System.out.print("After the remove your class: ");
            s.printStudents();

        } while (askRemove != 3);

    }


}

class Course {
    Scanner sc = new Scanner(System.in);
    public String lessonName;
    public int nbrStudent = sc.nextInt();
    public String[] studentList;


    public int getNbrStudent() {
        return nbrStudent;
    }


    public Course(String lessonName) {
        this.lessonName = lessonName;
        this.studentList = new String[1];
    }


    public void AddStudent() {
        String name1 = sc.nextLine();
        boolean is_available = false;

        for (int idx = 0; idx < this.studentList.length; idx++) {
            if (this.studentList[idx] == null) {
                this.studentList[idx] = name1;
                is_available = true;
            }
        }
        if (!is_available) {

            String[] temp = new String[studentList.length + 1];
            for (int idx = 0; idx < studentList.length; idx++) {
                if (studentList[idx] != null) {
                    temp[idx] = studentList[idx];
                }
            }
            temp[studentList.length] = name1;
            studentList = temp;

        }
    }

    public void removeStudent() {
        System.out.print("Enter you want student to remove: ");
        String name1 = sc.nextLine();
        int idx = findIndex(name1);

        if (idx != -1) {
            studentList[idx] = null;
        }
    }

    private int findIndex(String name1) {
        for (int idx = 0; idx < studentList.length; idx++) {
            if (studentList[idx] != null & Objects.equals(studentList[idx], name1)) {
                return idx;
            }
        }
        return -1;
    }

    public void printStudents() {
        for (int idx = 0; idx < studentList.length; idx++) {
            if (studentList[idx] != null) {
                System.out.println(studentList[idx]);
            }
        }

    }

}
