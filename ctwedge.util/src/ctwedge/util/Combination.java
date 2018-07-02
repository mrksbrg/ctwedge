package ctwedge.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A class representing a tuple
 * @author Marco
 *
 */
public class Combination extends HashMap<String,String> {

	public Combination(Map<? extends String, ? extends String> assignments) {
		super(assignments);
	}
	
	/** for compatibility and reuse of CitLab code */
	public Combination(List<Pair<String,String>> combs) {
		super(new HashMap<>());
		for (Pair<String,String> c : combs) {
			put(c.getFirst(), c.getSecond());
		}
	}
	
	public Combination() {}
	
	/** AB contains A  (this contains c) */
	public boolean contains(Combination c) {
		if (c.size()>size()) return false;
		for (Entry<String,String> a : c.entrySet()) {
			if (!containsKey(a.getKey()) || get(a.getKey())!=a.getValue()) return false;
		}
		return true;
	}
	
	public boolean containsParameter(String param) {
		return containsKey(param);
		//for (Assignment a : assignments) if (a.getParameter().getName().equals(param)) return true;
		//return false;
	}

	/*@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Combination)) return false;
		if (this == obj) return true;
		return equals(((Combination)obj));
//		Combination other = (Combination)obj;
//		if (assignments.size()!=other.assignments.size()) return false;
//		for (Entry<String,String> a : assignments.entrySet()) if (!other.assignments.containsKey(a.getKey()) || assignments.get(a.getKey())!=a.getValue()) return false;
//		return true;
	}*/
	
	public Set<String> getParameters() {
		return keySet();
//		List<String> params = new ArrayList<>();
//		for (Assignment a : assignments) params.add(a.getParameter().getName());
//		return params;
	}
	
//	public String getValueFor(String param) {
//		for (Assignment a : assignments) if (a.getParameter().getName().equals(param)) return a.getValue();
//		return null;
//	}
	
	
	
	// *****  UTILITIES  ******
	
	/** Removes a combination from a list of combinations. Needed because the .equals method called in
	 * the deafult implementation of .containts method of any collection, does not seem to work.
	 * @return if the combination was removed 
	 */
	public boolean removeFrom(Collection<Combination> set) {
		//for (Combination a : set) if (a.toString().equals(toString())) {set.remove(a); return true;}
		for (Combination a : set) if (a.equals(this)) {set.remove(a); return true;}
		return false;
	}
	
	public boolean isContainedIn(Collection<Combination> set) {
		for (Combination a : set) if (a.equals(this)) return true;
		return false;
	}

	/** if this combination is AB, and in the set there is A, I return true */
	public boolean isContainedInNoMatterTheSize(Collection<Combination> set) {
		for (Combination a : set) if (this.contains(a)) return true;
		return false;
	}
	
	public boolean isContainedIn(Test t) {
		return t.contains(this);
//		Entry<String,String> as = assignments.get(0);
//		for (int i=0, j=0; i<t.getAssignments().size(); i++) {
//			if (t.getAssignments().get(i).getParameter().equals(as.getParameter())) {
//				if (t.getAssignments().get(i).getValue().equals(as.getValue())) {
//					j++;
//					if (j==assignments.size()) return true;
//					else as = assignments.get(j);
//				} else {
//					return false;
//				}
//			}
//		}
//		return false;
//				
//		for (Assignment a : assignments) {
//			boolean found=false;
//			for (Assignment b : t.getAssignments()) if (a.equals(b)) {found=true; break;}
//			if (!found) return false;
//		}
//		return true;
	}
	
	/**
	 * @param list
	 * @param c
	 * @return the first combination in list, that includes (is more general than) c
	 
	Combination isIncluded(Collection<Combination> list, Combination c) {
		for (Combination a : list) if (a.contains(c)){
			return a;
		}
		return null;
	}*/
	
//	@Override
//	public int hashCode() {
//		return //assignments.size(); 
//				this.toString().hashCode();
//	}
//	
}
