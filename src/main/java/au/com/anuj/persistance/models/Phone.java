package au.com.anuj.persistance.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import au.com.anuj.persistance.AbstractPersistenceEntity;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="USER_CONTACTS")
public class Phone extends AbstractPersistenceEntity<Long> {

	private static final long serialVersionUID = -19771843409668305L;

	@Column(name = "UCN_COUNTRY_CODE")
	protected String countryCode;

	@Column(name = "UCN_PHONE_NUMBER", nullable = false)
	protected String phoneNumber;
	
	@Column(name = "UCN_EXTENSION")
	protected String extension;
	
	@Column(name = "UCN_IS_DEFAULT")
	protected boolean isDefault = false;

	@Column(name = "UCN_IS_ACTIVE")
	protected boolean isActive = true;

	@JoinColumn(name="UCN_USR_ID")
	protected User user;
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
