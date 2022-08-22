package com.example.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long Id;
	private String FirstName;
	private String LastName;
	private String Address;
	private String Gender;
	
	public Person() {}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Address, FirstName, Gender, Id, LastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(Address, other.Address) && Objects.equals(FirstName, other.FirstName)
				&& Objects.equals(Gender, other.Gender) && Objects.equals(Id, other.Id)
				&& Objects.equals(LastName, other.LastName);
	}
	
	
}
