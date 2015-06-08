package sourceit.webtester.entities;

import java.sql.Timestamp;

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
@Table (name = "passed_test")
public class PassedTest implements Comparable<PassedTest>{
	
	@Id
	@SequenceGenerator (name = "PASSED_TEST_SEQ_GEN", sequenceName = "passed_test_seq")
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "PASSED_TEST_SEQ_GEN")
	@Column (name = "id_passed_tets")
	private long idPassedTest;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "id_account", nullable = false)
	private Account account;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "id_test", nullable = false)
	private Test test;
	
	@Column (nullable = false)
	private Timestamp created;
	
	public PassedTest(){		
	}

	public Long getIdPassedTest() {
		return idPassedTest;
	}

	public void setIdPassedTest(long idPassedTest) {
		this.idPassedTest = idPassedTest;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}
	

	@Override
	public int hashCode () {
		return new HashCodeBuilder().append(getIdPassedTest()).toHashCode();
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
		if (getIdPassedTest() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getIdPassedTest().equals(other.getId())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo (PassedTest o) {
		Object o1 = getIdPassedTest();
		Object o2 = o != null ? o.getIdPassedTest() : null;
		return new CompareToBuilder().append(o1, o2).toComparison();
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	

}
