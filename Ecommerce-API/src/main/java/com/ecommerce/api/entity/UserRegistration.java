package com.ecommerce.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserRegistration {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String email;

	    @Column(nullable = false)
	    private String password;

	    @Column(name = "mobile_no", nullable = false, unique = true)
	    private String mobileNo;

	    @Column(name = "first_name", nullable = false)
	    private String firstName;

	    @Column(name = "last_name", nullable = false)
	    private String lastName;

	    @Column(nullable = false)
	    private String gender;

	    
	    public UserRegistration() {
	    	
	    }
	    
	    public UserRegistration(String email, String password, String mobileNo,
                String firstName, String lastName, String gender) {
				  this.email = email;
				  this.password = password;
				  this.mobileNo = mobileNo;
				  this.firstName = firstName;
				  this.lastName = lastName;
				  this.gender = gender;
				}
	    
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
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

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}
	    
	    
	    
	
	
}
