package task3;
import java.io.*;
import java.util.*;
public class StudentManagementSystem {
	 private List<Student> students;
	 public StudentManagementSystem() {
	        this.students = new ArrayList<>();
	    }

	    public void addStudent(Student student) {
	        students.add(student);
	    }

	    public void removeStudent(String rollNumber) {
	        students.removeIf(student -> student.getRollnumber().equals(rollNumber));
	    }

	    public Student searchStudent(String rollNumber) {
	        for (Student student : students) {
	            if (student.getRollnumber().equals(rollNumber)) {
	                return student;
	            }
	        }
	        return null;
	    }

	    public void displayAllStudents() {
	        for (Student student : students) {
	            System.out.println("Name: " + student.getName() + ", Roll Number: " + student.getRollnumber() + ", Grade: " + student.getGrade());
	        }
	    }
	    
	    public void saveToFile(String task3) {
	        try (PrintWriter writer = new PrintWriter(new FileWriter(task3))) {
	            for (Student student : students) {
	                writer.println(student.getName() + "," + student.getRollnumber() + "," + student.getGrade());
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public void loadFromFile(String task3) {
	        students.clear();
	        try (BufferedReader reader = new BufferedReader(new FileReader(task3))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 3) {
	                    students.add(new Student(parts[0], parts[1], parts[2]));
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
