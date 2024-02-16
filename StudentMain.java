package task3;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Save data to a file");
            System.out.println("6. Load data from a file");
            System.out.println("7. Exit");

            System.out.print("Enter your choice (1-7): ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student roll number: ");
                    String rollNumber = sc.nextLine();
                    System.out.print("Enter student grade: ");
                    String grade = sc.nextLine();
                    if (!name.isEmpty() && !rollNumber.isEmpty() && !grade.isEmpty()) {
                        sms.addStudent(new Student(name, rollNumber, grade));
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("All fields are required.");
                    }
                    break;

                case "2":
                    System.out.print("Enter student roll number to remove: ");
                    String removeRollNumber = sc.nextLine();
                    if (!removeRollNumber.isEmpty()) {
                        sms.removeStudent(removeRollNumber);
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Roll number is required.");
                    }
                    break;

                case "3":
                    System.out.print("Enter student roll number to search: ");
                    String searchRollNumber = sc.nextLine();
                    if (!searchRollNumber.isEmpty()) {
                        Student foundStudent = sms.searchStudent(searchRollNumber);
                        if (foundStudent != null) {
                            System.out.println("Student found - Name: " + foundStudent.getName() +
                                    ", Roll Number: " + foundStudent.getRollnumber() +
                                    ", Grade: " + foundStudent.getGrade());
                        } else {
                            System.out.println("Student not found.");
                        }
                    } else {
                        System.out.println("Roll number is required.");
                    }
                    break;

                case "4":
                    sms.displayAllStudents();
                    break;

                case "5":
                    System.out.print("Enter the filename to save data: ");
                    String saveFileName = sc.nextLine();
                    sms.saveToFile(saveFileName);
                    System.out.println("Data saved successfully.");
                    break;

                case "6":
                    System.out.print("Enter the filename to load data: ");
                    String loadFileName = sc.nextLine();
                    sms.loadFromFile(loadFileName);
                    System.out.println("Data loaded successfully.");
                    break;

                case "7":
                    System.out.println("Exiting the Student Management System.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }

	

}
