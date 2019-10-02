package au.com.anuj.persistance.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import au.com.anuj.persistance.AbstractPersistenceEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ADDRESSES", indexes= {
		@Index(name="IDX_OBJ_STATUS", columnList = "OBJ_STATUS_CD"),
		@Index(name="IDX_ADD_CUSTOMER_ID", columnList = "ADD_CUSTOMER_ID"),
		@Index(name="IDX_ADD_CITY", columnList = "ADD_CITY"),
		@Index(name="IDX_ADD_STATE", columnList = "ADD_STATE"),
		@Index(name="IDX_ADD_CITY", columnList = "ADD_CITY"),
		@Index(name="IDX_ADD_COUNTRY_ID", columnList = "ADD_COUNTRY_ID")
	})
public class Address extends AbstractPersistenceEntity<Long> {

	private static final long serialVersionUID = 8808223648135201452L;

	@Column(name = "ADD_FULL_NAME")
	@Getter
	@Setter
	protected String fullName;

	@Column(name = "ADD_FIRST_NAME")
	@Getter
	@Setter
	protected String firstName;

	@Column(name = "ADD_LAST_NAME")
	@Getter
	@Setter
	protected String lastName;

	@Column(name = "ADD_COMPANY_NAME")
	@Getter
	@Setter
	protected String companyName;

	@Column(name = "ADD_LINE1", nullable = false)
	@Getter
	@Setter
	protected String addressLine1;

	@Column(name = "ADD_LINE2")
	@Getter
	@Setter
	protected String addressLine2;

	@Column(name = "ADD_LINE3")
	@Getter
	@Setter
	protected String addressLine3;

	@Column(name = "ADD_CITY", nullable = false)
	@Getter
	@Setter
	protected String city;

	@ManyToOne(cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE }, targetEntity = State.class)
	@JoinColumn(name = "ADD_STATE")
	@Getter
	@Setter
	protected State state;

	@ManyToOne(cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE }, targetEntity = Country.class)
	@JoinColumn(name = "ADD_COUNTRY_ID")
	@Getter
	@Setter
	protected Country country;

	@Column(name = "ADD_POSTAL_CODE")
	@Getter
	@Setter
	protected String postalCode;

	@ManyToOne(targetEntity = Phone.class, cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "ADD_PHONE_PRIMARY_ID")
	@Getter
	@Setter
	protected Phone phonePrimary;

	@ManyToOne(targetEntity = Phone.class, cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "ADD_PHONE_SECONDARY_ID")
	@Getter
	@Setter
	protected Phone phoneSecondary;

	@ManyToOne(targetEntity = Phone.class, cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.REFRESH })
	@JoinColumn(name = "ADD_PHONE_FAX_ID")
	@Getter
	@Setter
	protected Phone phoneFax;

	@Column(name = "ADD_IS_DEFAULT")
	@Getter
	@Setter
	protected boolean isDefault = false;

	@Column(name = "ADD_IS_BUSINESS")
	@Getter
	@Setter
	protected boolean isBusiness = false;

	@Column(name = "ADD_IS_STREET")
	@Getter
	@Setter
	protected boolean isStreet = false;

	@Column(name = "ADD_IS_MAILING")
	@Getter
	@Setter
	protected boolean isMailing = false;

	@JoinColumn(name = "ADD_CUSTOMER_ID")
	@OneToOne
	@Getter
	@Setter
	protected Customer customer;

	
}
