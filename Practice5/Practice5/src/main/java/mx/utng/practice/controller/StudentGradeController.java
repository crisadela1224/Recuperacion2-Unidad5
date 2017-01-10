package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;


import mx.utng.practice.model.StudentGrade;

import mx.utng.practice.repository.StudentGradeRepository;

@Named
@ViewScoped
public class StudentGradeController {
	@Autowired
	private StudentGradeRepository studentGradeRepository;
	private StudentGrade studentGrade= new StudentGrade();
	private List<StudentGrade> studentGrades;
	private boolean editMode = false;
	
	@PostConstruct
	public void init(){
		setStudentGrades(studentGradeRepository.findAll());
	}

	public StudentGradeRepository getStudentGradeRepository() {
		return studentGradeRepository;
	}

	public void setStudentGradeRepository(StudentGradeRepository studentGradeRepository) {
		this.studentGradeRepository = studentGradeRepository;
	}

	public StudentGrade getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(StudentGrade studentGrade) {
		this.studentGrade = studentGrade;
	}

	public List<StudentGrade> getStudentGrades() {
		return studentGrades;
	}

	public void setStudentGrades(List<StudentGrade> studentGrades) {
		this.studentGrades = studentGrades;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
	public void save(){
		studentGradeRepository.save(studentGrade);
		if(!editMode){
			getStudentGrades().add(studentGrade);
		}
		studentGrade= new StudentGrade();
		setEditMode(false);
	}
	public void delete(StudentGrade studentGrade){
		studentGradeRepository.delete(studentGrade);
		studentGrades.remove(studentGrade);
	}
	public void update(StudentGrade studentGrade){
		setStudentGrade(studentGrade);
		setEditMode(true);
	}
	public void cancel(){
		studentGrade= new StudentGrade();
		setEditMode(false);
	}
	
}
