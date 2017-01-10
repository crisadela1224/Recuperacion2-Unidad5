package mx.utng.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="memberships")
public class MemberShip {
	@Id @GeneratedValue
	private Long id;
	@Column
	private String lastrenewaldate;
	@Column
	private String membersince;
	@Column
	private String membershiptype;
	@Column
	private String primarymember;
	
	public MemberShip(String lastrenewaldate,String membersince, String membershiptype,String primarymember){
		super();
		this.lastrenewaldate=lastrenewaldate;
		this.membersince=membersince;
		this.membershiptype=membershiptype;
		this.primarymember=primarymember;

	}
	public MemberShip(){
		this("","","","");
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLastrenewaldate() {
		return lastrenewaldate;
	}
	public void setLastrenewaldate(String lastrenewaldate) {
		this.lastrenewaldate = lastrenewaldate;
	}
	public String getMembersince() {
		return membersince;
	}
	public void setMembersince(String membersince) {
		this.membersince = membersince;
	}
	public String getMembershiptype() {
		return membershiptype;
	}
	public void setMembershiptype(String membershiptype) {
		this.membershiptype = membershiptype;
	}
	public String getPrimarymember() {
		return primarymember;
	}
	public void setPrimarymember(String primarymember) {
		this.primarymember = primarymember;
	}
	@Override
	public String toString() {
		return "MemberShip [id=" + id + ", lastrenewaldate=" + lastrenewaldate + ", membersince=" + membersince
				+ ", membershiptype=" + membershiptype + ", primarymember=" + primarymember + "]";
	}

	
}
