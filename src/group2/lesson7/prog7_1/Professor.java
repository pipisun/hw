package group2.lesson7.prog7_1;

import java.time.LocalDate;

public class Professor extends DeptEmployee {
	private int numberOfPublications;
	
	public int getNumberOfPublications() {
		return numberOfPublications;
	}

	public void setNumberOfPublications(int numberOfPublications) {
		this.numberOfPublications = numberOfPublications;
	}

	Professor(String name, double salary, LocalDate hireDate, int numberOfPublications) {
		super(name, salary, hireDate);
		this.numberOfPublications = numberOfPublications;
	}
}
