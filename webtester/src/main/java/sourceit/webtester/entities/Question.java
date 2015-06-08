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
@Table (name = "question")
public class Question implements Comparable<Question>{
	
	@Id
	@SequenceGenerator (name = "QUESTION_SEQ_GEN", sequenceName = "question_seq")
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "QUESTION_SEQ_GEN")
	@Column(name = "id_question", unique = true, nullable = false)
	private long idQuestion;
	
	@Column(nullable = false, length = 2147483647)
	private String name;
	
	@Column(nullable=false)
	private Boolean active;

	@Column(nullable=false)
	private Timestamp created;	

	@Column
	private Timestamp updated;
	
	@OneToMany(mappedBy="question")
	@OrderBy("idAnswer")
	private List<Answer> answers;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_test", nullable = false)
	private Test test;
	
	public Question(){		
	}

	public Long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	

	@Override
	public int hashCode () {
		return new HashCodeBuilder().append(getIdQuestion()).toHashCode();
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
		if (getIdQuestion() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getIdQuestion().equals(other.getId())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo (Question o) {
		Object o1 = getIdQuestion();
		Object o2 = o != null ? o.getIdQuestion() : null;
		return new CompareToBuilder().append(o1, o2).toComparison();
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
