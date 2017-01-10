package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;


import mx.utng.practice.model.School;
import mx.utng.practice.repository.SchoolRepository;


@Named
@ViewScoped
public class SchoolController {
	@Autowired
	private SchoolRepository schoolRepository;
	private School school= new School();
	private List<School> schools;
	private boolean editMode = false;
	
	@PostConstruct
	public void init(){
		setSchools(schoolRepository.findAll());
	}
	public List<School> getSchools(){
		return schools;
	}
	public void setSchools(List<School> schools){
		this.schools=schools;
	}
	public void save(){
		schoolRepository.save(school);
		if(!editMode){
			getSchools().add(school);
		}
		school= new School();
		setEditMode(false);
	}
	public void delete(School school){
		schoolRepository.delete(school);
		schools.remove(school);
	}
	public void update(School school){
		setSchool(school);
		setEditMode(true);
	}
	public void cancel(){
		school= new School();
		setEditMode(false);
	}
	public SchoolRepository getSchoolRepository() {
		return schoolRepository;
	}
	public void setSchoolRepository(SchoolRepository schoolRepository) {
		this.schoolRepository = schoolRepository;
	}
	public boolean isEditMode() {
		return editMode;
	}
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	

}
