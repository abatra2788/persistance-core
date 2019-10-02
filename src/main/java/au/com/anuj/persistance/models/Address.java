package au.com.anuj.persistance.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import au.com.anuj.persistance.AbstractPersistenceEntity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ADDRESSES", indexes= {
		@Index(name="IDX_OBJ_STATUS", columnList = "OBJ_STATUS"),
		//@Index(name="IDX_ADD_USER_ID", columnList = "ADD_USER_ID"),
		@Index(name="IDX_ADD_CITY", columnList = "ADD_CITY"),
		@Index(name="IDX_ADD_STATE", columnList = "ADD_STATE"),
		@Index(name="IDX_ADD_CITY", columnList = "ADD_CITY"),
		@Index(name="IDX_ADD_COUNTRY_ID", columnList = "ADD_COUNTRY_ID")
	})
public class Address extends AbstractPersistenceEntity<Long> {

	private static final long serialVersionUID = 8808223648135201452L;

	@Column(name = "ADD_FULL_NAME")
	protected String fullName;

	@Column(name = "ADD_FIRST_NAME")
	protected String firstName;

	@Column(name = "ADD_LAST_NAME")
	protected String lastName;

	@Column(name = "ADD_COMPANY_NAME")
	protected String companyName;

	@Column(name = "ADD_LINE1", nullable = false)
	protected String addressLine1;

	@Column(name = "ADD_LINE2")
	protected String addressLine2;

	@Column(name = "ADD_LINE3")
	protected String addressLine3;

	@Column(name = "ADD_CITY", nullable = false)
	protected String city;

	@ManyToOne(cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE }, targetEntity = State.class)
	@JoinColumn(name = "ADD_STATE")
	protected State state;

	@ManyToOne(cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE }, targetEntity = Country.class)
	@JoinColumn(name = "ADD_COUNTRY_ID")
	protected Country country;

	@Column(name = "ADD_POSTAL_CODE")
	protected String postalCode;

	@ManyToOne(targetEntity = Phone.class, cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "ADD_PHONE_PRIMARY_ID")
	protected Phone phonePrimary;

	@ManyToOne(targetEntity = Phone.class, cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "ADD_PHONE_SECONDARY_ID")
	protected Phone phoneSecondary;

	@ManyToOne(targetEntity = Phone.class, cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "ADD_PHONE_FAX_ID")
	protected Phone phoneFax;

	@Column(name = "ADD_IS_DEFAULT")
	protected boolean isDefault = false;

	@Column(name = "ADD_IS_BUSINESS")
	protected boolean isBusiness = false;

	@Column(name = "ADD_IS_STREET")
	protected boolean isStreet = false;

	@Column(name = "ADD_IS_MAILING")
	protected boolean isMailing = false;

	@JoinColumn(name = "ADD_USER_ID")
	protected User user;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Phone getPhonePrimary() {
		return phonePrimary;
	}

	public void setPhonePrimary(Phone phonePrimary) {
		this.phonePrimary = phonePrimary;
	}

	public Phone getPhoneSecondary() {
		return phoneSecondary;
	}

	public void setPhoneSecondary(Phone phoneSecondary) {
		this.phoneSecondary = phoneSecondary;
	}

	public Phone getPhoneFax() {
		return phoneFax;
	}

	public void setPhoneFax(Phone phoneFax) {
		this.phoneFax = phoneFax;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public boolean isBusiness() {
		return isBusiness;
	}

	public void setBusiness(boolean isBusiness) {
		this.isBusiness = isBusiness;
	}

	public boolean isStreet() {
		return isStreet;
	}

	public void setStreet(boolean isStreet) {
		this.isStreet = isStreet;
	}

	public boolean isMailing() {
		return isMailing;
	}

	public void setMailing(boolean isMailing) {
		this.isMailing = isMailing;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
