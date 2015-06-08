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
@Table (name = "answer")
public class Answer implements Comparable<Answer>{
	@Id
	@SequenceGenerator (name = "ANSWER_SEQ_GEN", sequenceName = "answer_seq")
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "ANSWER_SEQ_GEN")
	@Column (name = "id_answer", unique = true, nullable = false)
	private long idAnswer;
	
	@Column (nullable = false, length = 2147483647)
	private String name;
	
	@Column (nullable = false)
	private boolean correct;
	
	@Column(nullable=false)
	private Timestamp created;

	@Column
	private Timestamp updated;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_question", nullable=false)
	private Question question;
	
	public Answer(){		
	}

	public Long getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(long idAnswer) {
		this.idAnswer = idAnswer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	

	@Override
	public int hashCode () {
		return new HashCodeBuilder().append(getIdAnswer()).toHashCode();
	}

	@Override
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Answer)) {
			return false;
		}
		Answer other = (Answer) obj;
		if (getIdAnswer() == null) {
			if (other.getIdAnswer() != null) {
				return false;
			}
		} else if (!getIdAnswer().equals(other.getIdAnswer())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo (Answer o) {
		Object o1 = getIdAnswer();
		Object o2 = o != null ? o.getIdAnswer() : null;
		return new CompareToBuilder().append(o1, o2).toComparison();
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
