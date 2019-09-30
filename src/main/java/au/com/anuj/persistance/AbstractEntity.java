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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor
public class AbstractEntity<T extends Serializable> {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	@Column(name = "OBJ_ID")
	private T id;
	
	@Getter
	@Setter
	@CreatedDate
	@Column(name = "OBJ_CREATE_TS")
	private Instant createTime;
	
	@Getter
	@Setter
	@LastModifiedDate
	@Column(name = "OBJ_MODIFY_TS")
	private Instant modifiedTime;
	
	@Getter
	@Setter
	@CreatedBy
	@Column(name = "OBJ_CREATED_BY")
	private String createdBy;
	
	@Getter
	@Setter
	@LastModifiedBy
	@Column(name = "OBJ_MODIFIED_BY")
	private String modifiedBy;
	
	@Getter
	@Setter
	@Version
	@Column(name = "OBJ_VERSION")
	private Long version;
	
	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	@Column(name = "OBJ_STATUS_CD")
	private EntityStatus status;
}
