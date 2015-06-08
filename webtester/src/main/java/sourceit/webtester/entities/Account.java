package sourceit.webtester.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table (name = "account")
public class Account implements Comparable<Account>{
	
	@Id
	@SequenceGenerator (name = "ACCOUNT_SEQ_GEN", sequenceName="account_seq")
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_SEQ_GEN")	
	@Column (name = "id_account", unique = true, nullable = false)
	private long id;
	
	@Column (unique = true, nullable = false, length = 30)
	private String login;
	
	@Column (nullable = false, length = 50)
	private String password;
	
	@Column (unique = true, nullable = false, length = 2147483647)
	private String email;
	
	@Column (name = "first_name", nullable = false, length = 30)
	private String firstName;
	
	@Column (name = "last_name", nullable = false, length = 30)
	private String lastName;
	
	@Column (name = "middle_name", nullable = false, length = 30)
	private String middleName;
	
	@Column (nullable = false)
	private Timestamp created;
	
	@Column 
	private Timestamp updated;
	
	@Column (nullable = false)
	private Boolean active;
	
	@Column (name = "email_verified", nullable = false)
	private Boolean emailVerified;
	
	@OneToMany(mappedBy="account")
	private List<AccountRole> accountRoles;
	
	//bi-directional many-to-one association to PassedTest
	@OneToMany(mappedBy="account", fetch=FetchType.LAZY)
	private List<PassedTest> passedTests;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="account", fetch=FetchType.LAZY)
		private List<Test> tests;
	
	public Account(){		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public List<AccountRole> getAccountRoles() {
		return accountRoles;
	}
	
	public void setAccountRoles(List<AccountRole> accountRoles) {
		this.accountRoles = accountRoles;
	}

	public List<PassedTest> getPassedTests() {
		return passedTests;
	}


	public void setPassedTests(List<PassedTest> passedTests) {
		this.passedTests = passedTests;
	}


	public List<Test> getTests() {
		return tests;
	}


	public void setTests(List<Test> tests) {
		this.tests = tests;
	}


	@Override
	public int hashCode () {
		return new HashCodeBuilder().append(getId()).toHashCode();
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
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo (Account o) {
		Object o1 = getId();
		Object o2 = o != null ? o.getId() : null;
		return new CompareToBuilder().append(o1, o2).toComparison();
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	

}
