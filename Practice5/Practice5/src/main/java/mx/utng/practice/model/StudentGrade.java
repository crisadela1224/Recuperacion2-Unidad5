package mx.utng.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="studentGrades")
public class StudentGrade {
	@Id @GeneratedValue
	private Long id;
	@Column
	private String courseId;
	@Column
	private String studentId ;
	@Column
	private String grade ;
	
	public StudentGrade(String courseId, String studentId, String grade){
		super();
		this.courseId=courseId;
		this.studentId=studentId;
		this.grade=grade;

	}

	public StudentGrade(){
		this("","","");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "StudentGrade [id=" + id + ", courseId=" + courseId + ", studentId=" + studentId + ", grade=" + grade
				+ "]";
	}
	
}
