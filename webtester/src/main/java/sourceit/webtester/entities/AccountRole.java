package sourceit.webtester.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table (name = "account_role")
public class AccountRole implements Comparable<AccountRole>{
	@Id
	@SequenceGenerator (name = "ACCOUNTROLE_SEQ_GEN", sequenceName = "ACCOUNT_ROLE_SEQ" )
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "ACCOUNTROLE_SEQ_GEN")
	@Column (name = "id_account_role", unique = true, nullable = false)
	long idAccountRole;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn (name = "id_account", nullable = false)
	private Account account;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn (name = "id_role", nullable = false)
	private Role role;
	
	public AccountRole() {
	}

	public Long getIdAccountRole() {
		return idAccountRole;
	}

	public void setIdAccountRole(long idAccountRole) {
		this.idAccountRole = idAccountRole;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	@Override
	public int hashCode () {
		return new HashCodeBuilder().append(getIdAccountRole()).toHashCode();
	}

	@Override
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Account)) {
			return false;
		}
		Account other = (Account) obj;
		if (getIdAccountRole() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getIdAccountRole().equals(other.getId())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo (AccountRole o) {
		Object o1 = getIdAccountRole();
		Object o2 = o != null ? o.getIdAccountRole() : null;
		return new CompareToBuilder().append(o1, o2).toComparison();
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	

}
