package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import mx.utng.practice.model.MemberShip;
import mx.utng.practice.model.School;
import mx.utng.practice.repository.MemberShipRepository;



@Named
@ViewScoped
public class MemberShipController {
	@Autowired
	private MemberShipRepository memberShipRepository;
	private MemberShip memberShip= new MemberShip();
	private List<MemberShip> memberShips;
	private boolean editMode = false;
	
	@PostConstruct
	public void init(){
		setMemberShips(memberShipRepository.findAll());
	}

	public MemberShipRepository getMemberShipRepository() {
		return memberShipRepository;
	}

	public void setMemberShipRepository(MemberShipRepository memberShipRepository) {
		this.memberShipRepository = memberShipRepository;
	}

	public MemberShip getMemberShip() {
		return memberShip;
	}

	public void setMemberShip(MemberShip memberShip) {
		this.memberShip = memberShip;
	}

	public List<MemberShip> getMemberShips() {
		return memberShips;
	}

	public void setMemberShips(List<MemberShip> memberShips) {
		this.memberShips = memberShips;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
	public void save(){
		memberShipRepository.save(memberShip);
		if(!editMode){
			getMemberShips().add(memberShip);
		}
		memberShip= new MemberShip();
		setEditMode(false);
	}
	public void delete(MemberShip memberShip){
		memberShipRepository.delete(memberShip);
		memberShips.remove(memberShip);
	}
	public void update(MemberShip memberShip){
		setMemberShip(memberShip);
		setEditMode(true);
	}
	public void cancel(){
		memberShip= new MemberShip();
		setEditMode(false);
	}
}
