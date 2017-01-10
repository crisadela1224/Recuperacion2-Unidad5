package mx.utng.practice.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="schools")
public class School {
	@Id @GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private String direction;
	
	public School(String name, String direction){
		super();
		this.name=name;
		this.direction=direction;

	}

	public School(){
		this("","");
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((direction == null) ? 0 : direction.hashCode());
					return result;
				

		}
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass()!= obj.getClass())
			return false;
		
		School other =(School)obj;
		if(id == null){
			if(other.id !=null)
				return false;
		}else if(!id.equals(other.id))
			return false;
		if(name == null){
			if(other.name != null)
				return false;
		}else if(!name.equals(other.name))
			return false;
		
		
		if(direction == null){
			if(other.direction != null)
				return false;
		}else if(!direction.equals(other.direction))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", direction=" + direction + "]";
	}
	
	
}
