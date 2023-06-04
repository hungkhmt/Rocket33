package assignment_03;

import java.util.Comparator;
import java.util.Objects;

public class Department {
	byte id;
	String name;
	
	
	
	public byte getId() {
		return id;
	}



	public void setId(byte id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public int hashCode() {
		return Objects.hash(name);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(name, other.name);
	}


	

	@Override
	public String toString() {
		return "Department Id: " + id + ", Department name: " + name;
	}

}

class sortByFirstName implements Comparator<Department> {

	@Override
	public int compare(Department o1, Department o2) {
		// TODO Auto-generated method stub
		if (o1 == null) {
			return -1;
		}

		if (o2 == null) {
			return 1;
		}

		return 1 * o1.name.compareTo(o2.name);
	}
	
}

class sortByLastName implements Comparator<Department> {

	@Override
	public int compare(Department o1, Department o2) {
		// TODO Auto-generated method stub
		if (o1 == null) {
			return -1;
		}

		if (o2 == null) {
			return 1;
		}
		
		String[] tmp1 = o1.getName().split(" ");
		String[] tmp2 = o2.getName().split(" ");
		tmp1[tmp1.length-1].toUpperCase();
		tmp2[tmp2.length-1].toUpperCase();
		
		return 1 * tmp1[tmp1.length-1].toUpperCase().compareTo(tmp2[tmp2.length-1].toUpperCase());
	}
	
}

