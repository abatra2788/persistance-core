package au.com.anuj.persistance.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import au.com.anuj.persistance.AbstractPersistenceEntity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "STATES")
public class State extends AbstractPersistenceEntity<Long> {

	private static final long serialVersionUID = 7050699623663880512L;

	@Column(name = "STT_CODE", unique=true, nullable=false)
	protected String code;
	
	@Column(name = "STT_NAME", nullable = false)
	protected String name;
	
	@ManyToOne(cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE }, targetEntity = Country.class)
	@JoinColumn(name = "STT_COUNTRY")
	protected Country country;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
