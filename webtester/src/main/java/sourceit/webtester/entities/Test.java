package sourceit.webtester.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


@Entity
@Table(name="test")
public class Test implements Comparable<Test> {
	@Id
	@SequenceGenerator(name="TEST_SEQ_GEN", sequenceName="test_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEST_SEQ_GEN")
	@Column(name="id_test", unique=true, nullable=false)
	private long idTest;	
	
	@Column(nullable=false, length = 2147483647)
	private String title;
	
	@Column(nullable=false)
	private Timestamp created;
	
	@Column
	private Timestamp updated;
	
	@Column(nullable=false)
	private Boolean active;	

	@Column(length=2147483647)
	private String description;

	@Column(name="period_per_question", nullable=false)
	private Integer periodPerQuestion;
	
	@OneToMany(mappedBy="test")
	@OrderBy("created")
	private List<Question> questions;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_account", nullable=false)
	private Account account;
	
	public Test() {
	}

	public Long getIdTest() {
		return idTest;
	}

	public void setIdTest(long idTest) {
		this.idTest = idTest;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPeriodPerQuestion() {
		return periodPerQuestion;
	}

	public void setPeriodPerQuestion(Integer periodPerQuestion) {
		this.periodPerQuestion = periodPerQuestion;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	

	@Override
	public int hashCode () {
		return new HashCodeBuilder().append(getIdTest()).toHashCode();
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
		if (getIdTest() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getIdTest().equals(other.getId())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo (Test o) {
		Object o1 = getIdTest();
		Object o2 = o != null ? o.getIdTest() : null;
		return new CompareToBuilder().append(o1, o2).toComparison();
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	
}
