package au.com.anuj.persistance.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "CUSTOMERS")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9201284172636634855L;

	@Column(name="USR_ADDRESS")
	@Getter
	@Setter
	protected Address address;
	
	@OneToMany(targetEntity = Address.class, cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.REFRESH })
	@Getter
	@Setter
	protected Set<Address> addresses;
	
	@OneToMany(targetEntity = Device.class, cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.REFRESH })
	@Getter
	@Setter
	protected Set<Device> devices;
}
