package au.com.anuj.persistance;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
public class AbstractPersistenceEntity<T extends Serializable> implements Serializable, Persistable<T> {

	protected static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	@Column(name = "OBJ_ID")
	protected T id;
	
	@Getter
	@Setter
	@CreatedDate
	@Column(name = "OBJ_CREATE_TS")
	protected Instant createTime;
	
	@Getter
	@Setter
	@LastModifiedDate
	@Column(name = "OBJ_MODIFY_TS")
	protected Instant modifiedTime;
	
	@Getter
	@Setter
	@CreatedBy
	@Column(name = "OBJ_CREATED_BY")
	protected String createdBy;
	
	@Getter
	@Setter
	@LastModifiedBy
	@Column(name = "OBJ_MODIFIED_BY")
	protected String modifiedBy;
	
	@Getter
	@Setter
	@Version
	@Column(name = "OBJ_VERSION")
	protected Long version;
	
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	@Column(name = "OBJ_STATUS_CD")
	protected EntityStatus status;

	public T getId() {
		return this.id;
	}

	@Override
	public boolean isNew() {
		return (null == this.getId()) ? true : false;
	}
}
