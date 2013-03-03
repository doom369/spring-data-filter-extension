package com.cogniance.filter.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Sample role class.
 *
 */
@Entity
public class Role extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -1493758275967636295L;

	@Column(unique = true)
	private String rolename;

	/**
	 * Returns the rolename.
	 * 
	 * @return
	 */
	public String getRolename() {

		return rolename;
	}

	/**
	 * @param rolename the rolename to set
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
