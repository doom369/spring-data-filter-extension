package com.cogniance.filter.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Sample user class.
 *
 */
@Entity
public class User extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -2952735933715107252L;

	@Column(unique = true)
	private String username;

	private String firstname;
	private String lastname;

    @OneToOne(cascade = CascadeType.ALL)
    private RoleUserPersonalInfo personalInfo;

    @ManyToMany
    private Set<Role> roles = new HashSet<Role>();

	/**
	 * Returns the username.
	 * 
	 * @return
	 */
	public String getUsername() {

		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

    public RoleUserPersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(RoleUserPersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
