package task3;

public class Student {
	private String name;
    private String rollnumber;
    private String grade;
    
    public Student(String name, String rollnumber, String grade) {
        this.name = name;
        this.rollnumber = rollnumber;
        this.grade = grade;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
    
   
}
