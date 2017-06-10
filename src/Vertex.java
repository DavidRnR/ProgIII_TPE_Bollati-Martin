import java.util.*;

public class Vertex {
	private String name;
	private String type;
	ArrayList<Vertex> adjacents = new ArrayList<Vertex>();
	
	public Vertex (String _name, String _type) {
		name = _name;
		type = _type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Vertex> getAdjacents() {
		return adjacents;
	}
	
	/**
	 * Agrega un adyacente al Vertice.
	 * @param adj
	 */
	public void addAdjacent(Vertex adj) {
		adjacents.add(adj);
	}
	
	@Override
	public String toString() {
		String answer = name + " "+ type;
		return answer;
	}
}
