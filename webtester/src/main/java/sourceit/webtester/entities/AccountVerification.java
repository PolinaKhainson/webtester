package sourceit.webtester.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name="account_verification")
public class AccountVerification implements Comparable<AccountVerification>{
	@Id
	@SequenceGenerator(name = "ACCOUNT_VERIFICATION_SEQ_GEN", sequenceName = "account_verification_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ACCOUNT_VERIFICATION_SEQ_GEN")
	@Column(name="id_account", unique=true, nullable=false)
	private long idAccount;
	
	@Column(nullable=false, length = 2147483647)
	private String code;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_account", nullable=false, insertable=false, updatable=false)
	private Account account;
	
	public AccountVerification() {
		
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(long idAccount) {
		this.idAccount = idAccount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	

	@Override
	public int hashCode () {
		return new HashCodeBuilder().append(getIdAccount()).toHashCode();
	}

	@Override
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AccountVerification)) {
			return false;
		}
		AccountVerification other = (AccountVerification) obj;
		if (getIdAccount() == null) {
			if (other.getIdAccount() != null) {
				return false;
			}
		} else if (!getIdAccount().equals(other.getIdAccount())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo (AccountVerification o) {
		Object o1 = getIdAccount();
		Object o2 = o != null ? o.getIdAccount() : null;
		return new CompareToBuilder().append(o1, o2).toComparison();
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	
}
