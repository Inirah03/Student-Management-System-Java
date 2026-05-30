import java.util.Scanner;
class Student {
    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name,int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
        void display() {
            System.out.println("Roll No: " + rollNo);
            System.out.println("Name: " + name);
            System.out.println("Marks: " + marks);

            if(marks >= 90)
                System.out.println("Grade: A");
            else if(marks >= 80)
                System.out.println("Grade: B");
            else if(marks >= 70)
                System.out.println("Grade: C");
            else
                System.out.println("Grade: D");
        }
    }

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[10];
        int count = 0;


        while (true) {

            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();

                    boolean exists = false;

                    for(int i = 0; i < count; i++)
                    {
                        if(students[i].rollNo == roll)
                        {
                            exists = true;
                            break;
                        }
                    }

                    if(exists)
                    {
                        System.out.println("Roll Number Already Exists!");
                    }
                    else
                    {
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Marks:");
                        int marks = sc.nextInt();

                        students[count] = new Student(roll, name,marks);
                        count++;

                        System.out.println("Student Added!");
                    }
                    break;
                case 2:

                    if (count == 0) {
                        System.out.println("No students found.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            students[i].display();
                            System.out.println();
                        }
                    }
                    break;

                case 3:

                    System.out.print("Enter Roll No to Search: ");
                    int searchRoll = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (students[i].rollNo == searchRoll) {
                            students[i].display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found");
                    }

                    break;

                case 4:

                    System.out.print("Enter Roll No to Delete: ");
                    int deleteRoll = sc.nextInt();

                    int index = -1;

                    for(int i = 0; i < count; i++)
                    {
                        if(students[i].rollNo == deleteRoll)
                        {
                            index = i;
                            break;
                        }
                    }

                    if(index == -1)
                    {
                        System.out.println("Student Not Found");
                    }
                    else
                    {
                        for(int i = index; i < count - 1; i++)
                        {
                            students[i] = students[i + 1];
                        }

                        count--;

                        System.out.println("Student Deleted Successfully");
                    }

                    break;
                case 5:

                    System.out.print("Enter Roll No to Update: ");
                    int updateRoll = sc.nextInt();

                    boolean foundUpdate = false;

                    for(int i = 0; i < count; i++)
                    {
                        if(students[i].rollNo == updateRoll)
                        {
                            sc.nextLine();

                            System.out.print("Enter New Name: ");
                            String newName = sc.nextLine();

                            students[i].name = newName;

                            System.out.println("Student Updated Successfully");

                            foundUpdate = true;
                            break;
                        }
                    }

                    if(!foundUpdate)
                    {
                        System.out.println("Student Not Found");
                    }

                    break;

                case 6:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
