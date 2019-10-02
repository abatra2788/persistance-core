package au.com.anuj.persistance.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import au.com.anuj.persistance.AbstractPersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "USER_DEVICES")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Device extends AbstractPersistenceEntity<Long> {

	private static final long serialVersionUID = 6491982637656660205L;
	
	@Column(name="UDV_ID", nullable=false)
	@Getter
	@Setter
	private String deviceId;
	
	@Column(name="UDV_USER_AGENT", nullable=false)
	@Getter
	@Setter
	private String userAgent;
	
	

}
