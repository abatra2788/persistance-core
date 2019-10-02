package au.com.anuj.persistance.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import au.com.anuj.persistance.AbstractPersistenceEntity;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="COUNTRIES")
public class Country extends AbstractPersistenceEntity<Long> {

	private static final long serialVersionUID = -6203248922415461241L;
	
	@Column(name="CNT_ISO2_CD", nullable=false, unique=true)
	protected String iso2Code;
	
	@Column(name="CNT_ISO3_CD", nullable=false, unique=true)
	protected String iso3Code;
	
	@Column(name="CNT_NAME", nullable=false)
	protected String name;

	@Column(name="CNT_PH_CODE", nullable=false)
	protected String coutryPhoneCode;
	
	public String getIso2Code() {
		return iso2Code;
	}

	public void setIso2Code(String iso2Code) {
		this.iso2Code = iso2Code;
	}

	public String getIso3Code() {
		return iso3Code;
	}

	public void setIso3Code(String iso3Code) {
		this.iso3Code = iso3Code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoutryPhoneCode() {
		return coutryPhoneCode;
	}

	public void setCoutryPhoneCode(String coutryPhoneCode) {
		this.coutryPhoneCode = coutryPhoneCode;
	}

}
