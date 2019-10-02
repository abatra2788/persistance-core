package au.com.anuj.persistance.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import au.com.anuj.persistance.AbstractPersistenceEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="ROLES")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Role extends AbstractPersistenceEntity<Long> implements GrantedAuthority {

	private static final long serialVersionUID = 1947176906203635274L;
	
	@Column(name="ROL_NAME")
	@Getter
	@Setter
	private String roleName;
	
	@Override
	public String getAuthority() {
		return this.roleName;
	}

}
