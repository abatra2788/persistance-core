package au.com.anuj.persistance.models;

import java.time.Instant;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import au.com.anuj.persistance.AbstractPersistenceEntity;
import au.com.anuj.persistance.EntityStatus;
import au.com.anuj.persistance.UserAccountStatus;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User extends AbstractPersistenceEntity<Long> implements UserDetails {

	private static final long serialVersionUID = 6110778304013905954L;
	
	@Column(name="USR_FIRST_NM", nullable=false)
	@Getter
	@Setter
	protected String firstName;
	
	@Column(name="USR_MIDDLE_NM")
	@Getter
	@Setter
	protected String middleName;
	
	@Column(name="USR_LAST_NM", nullable=false)
	@Getter
	@Setter
	protected String lastName;
	
	@Column(name="USR_EMAIL", unique=true, nullable=false)
	@Getter
	@Setter
	protected String email;
	
	@Column(name="USR_USER_NAME", unique=true, nullable=false)
	@Getter
	@Setter
	protected String username;
	
	@Column(name="USR_HOME_PHONE")
	@Getter
	@Setter
	protected Phone homePhone;
	
	@Column(name="USR_BUS_PHONE")
	@Getter
	@Setter
	protected Phone busPhone;
	
	@Column(name="USR_PASSWORD")
	@Getter
	@Setter
	protected String password;
	
	@Column(name="USR_PASSWORD_CHNG_RQD")
	@Getter
	@Setter
	protected Boolean passwordChangeRequired = Boolean.valueOf(false);
	
	@Column(name="USR_REGISTERED")
	@Getter
	@Setter
	protected Boolean registered = Boolean.valueOf(false);

	@Column(name="USR_PWD_CHANGE_DT")
	@Getter
	@Setter
	protected Instant passwordChangedDate = Instant.now();
	
	@Column(name="USR_FAILED_LOGIN_ATTEMPTS")
	@Getter
	@Setter
	protected int failedLoginAttempts;
	
	@Column(name="USR_LAST_FAILED_LOGIN_DT")
	@Getter
	@Setter
	protected Instant lastLoginFailedAttempt = Instant.now();

	@Column(name="USR_LAST_LOGIN_DT")
	@Getter
	@Setter
	protected Instant lastSuccessfulLogin = Instant.now();
	
	@Column(name="USR_ACC_STATUS_CD")
	@Getter
	@Setter
	protected UserAccountStatus accountStatus;

	@OneToMany(targetEntity = Role.class, cascade = { javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.REFRESH })
	@Getter
	@Setter
	protected Set<Role> roles;

	@SuppressWarnings("unchecked")
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = CollectionUtils.arrayToList(roles.toArray());
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return (null != this.accountStatus) ? ((this.accountStatus == UserAccountStatus.PASSWORD_EXPIRED) ? Boolean.TRUE : Boolean.FALSE): Boolean.TRUE;
	}

	@Override
	public boolean isAccountNonLocked() {
		return (null != this.accountStatus) ? ((this.accountStatus == UserAccountStatus.LOCKED) ? Boolean.FALSE : Boolean.TRUE): Boolean.FALSE;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return (null != this.accountStatus) ? ((this.accountStatus == UserAccountStatus.PASSWORD_EXPIRED) ? Boolean.FALSE : Boolean.TRUE): Boolean.FALSE;
	}

	@Override
	public boolean isEnabled() {
		return (null != this.accountStatus) ? ((this.accountStatus == UserAccountStatus.ACTIVE && this.status == EntityStatus.ACTIVE) ? Boolean.FALSE : Boolean.TRUE): Boolean.FALSE;
	}
	
	
}
