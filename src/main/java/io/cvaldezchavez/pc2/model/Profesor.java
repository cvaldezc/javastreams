package io.cvaldezchavez.pc2.model;


public class Profesor implements Comparable<Profesor>{
	
	private Integer id;
	private String firstName;
	private String lastName;
	private double salary;
	private int age;
	
	public Profesor() {}
	
	public Profesor(int id) {
		this.id = id;
	}
	
	public Profesor(int id, String firstname, String lastname, double salary, int age) {
		this.id = id;
		this.firstName = firstname;
		this.lastName = lastname;
		this.salary = salary;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Profesor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
		        + ", age=" + age + "]";
	}

	public String toTextArea() {
		return id + "\t" + firstName + "\t" + lastName + "\t" + salary + "\t" + age + "\n";
	}
	
	public String toSalaryBruto() {
		return id + "\t" + firstName + "\t" + lastName + "\t" + salary + "\t" + age ;
	}
	
	public String toWriting() {
		return id + "," + firstName + "," + lastName + "," + salary + "," + age + "\r\n";
	}

	@Override
	public int compareTo(Profesor o) {
		return id.compareTo(o.getId());
	}
	
}
