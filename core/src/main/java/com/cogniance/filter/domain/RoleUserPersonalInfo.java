package com.cogniance.filter.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Sample role class.
 *
 */
@Entity
public class RoleUserPersonalInfo extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -1493758275967636295L;

	@Column(unique = true)
	private String passportId;

    public RoleUserPersonalInfo(String passportId) {
        this.passportId = passportId;
    }

    public RoleUserPersonalInfo() {
		this(null);
	}

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }
}
