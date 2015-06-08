package sourceit.webtester.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


@Entity
@Table(name="role")
public class Role implements Comparable<Role> {
	@Id
	@SequenceGenerator(name="ROLE_SEQ_GEN", sequenceName="ROLE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLE_SEQ_GEN")
	@Column(name="id_role", unique=true, nullable=false)
	long idRole;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@OneToMany(mappedBy="role")
	private List<AccountRole> accountRoles;	
	
	
	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Role)) {
			return false;
		}
		Role other = (Role) obj;
		if (getIdRole() == null) {
			if (other.getIdRole() != null) {
				return false;
			}
		} else if (!getIdRole().equals(other.getIdRole())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo (Role o) {
		Object o1 = getIdRole();
		Object o2 = o != null ? o.getIdRole() : null;
		return new CompareToBuilder().append(o1, o2).toComparison();
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
