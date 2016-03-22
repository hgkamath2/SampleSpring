package com.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO) //AUTO, SEQUENCE or IDENTITY
	int userId;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;
	
	@Column(name="email_addr")
	String emailAddr;
	
	@Column(name="age")
	int age;

	public User()
	{
		
	}
	
	public User(String firstName, String lastName, String emailAddr, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddr = emailAddr;
		this.age = age;
	}

	public void userCopy(User temp)
	{
		age = temp.age;
		firstName = temp.firstName;
		lastName = temp.lastName;
		emailAddr = temp.emailAddr;
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddr="
				+ emailAddr + ", age=" + age + "]";
	}

}
