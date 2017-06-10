import java.util.*;

public class GraphStructure {
	private static ArrayList<Vertex> vertex = new ArrayList<Vertex>();
	
	/**
	 * Carga la data (Usuarios y Gustos) en el grafo
	 * @param data
	 */
	public static void loadGraphStructure (ArrayStructure data) {
		
		for (int i = 0; i < data.size(); i++) {
			String[] userAndPreferences = filterData(data.get(i));
			
			for (int j = 0; j < userAndPreferences.length ; j++) {
				if(j == 0) { // Primera posicion es el ID de Usuario
					addUser(userAndPreferences[j]);
				}
				else {
					addPreference(userAndPreferences[j]);
				}
			}
		}
	}
	
	public static void addPreference (String pref) {
		Vertex preference = new Vertex(pref, "preference");
		
		//TODO Check sino existe la preferencia.
		vertex.add(preference);
	}
	
	public static void addUser(String userId) {
		Vertex user = new Vertex(userId, "user");
		
		vertex.add(user);
	}
	
	/**
	 * Dado un usuario, devuelve una lista de usuarios que tienen mas de un gusto en comun
	 * @param userId
	 * @return
	 */
	public static ArrayList<String> getUsersWithSamePreference (String userId) {
		ArrayList<String> answer = new ArrayList<String>();
		
		return answer;
	}
	
	/**
	 * Devuelve el gusto que mas le gusta a todos los usuarios
	 * @return
	 */
	public static String getMostRepeatedPreference() {
	return "";	
	}
	
	/**
	 * Dado un usuario, devuelve aquella que tenga gustos más lejanos a él.
	 * @param userId
	 * @return
	 */
	public static String getUserWithDifferentPreferences (String userId) {
		
		
		return "";
	}
	
	public static void printGraph() {
		for (int i = 0; i < 50; i++) {
			System.out.println(vertex.get(i).toString());
			System.out.println();
		}
	}
	
	//**********************************************************************
	
	private static String[] filterData (String line) {
		//Recibe String ej: "354353 Tenis Futbol"
				
		String SplitBy = " ";
		
		String[] items = line.split(SplitBy);
		
		return items;
	}
	
	//********************************Main for test***********************************
	public static void main(String[] args) {
		ArrayStructure arr;
		
		arr = CSVReader.CSVReaderArray("datasets/dataset_500000.csv");
		
		GraphStructure.loadGraphStructure(arr);
		
		GraphStructure.printGraph();
	}
}
