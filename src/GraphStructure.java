import java.util.*;

public class GraphStructure {
	private static ArrayList<Vertex> users = new ArrayList<Vertex>();
	private static ArrayList<Vertex> prefs = new ArrayList<Vertex>(); 
	static int userIndex = 0;
	private static HashMap<String, Integer> mapUser = new HashMap<String, Integer>();
	
	/**
	 * Carga la data (Usuarios y Gustos) en el grafo
	 * @param data
	 */
	public static void loadGraphStructure (ArrayStructure data) {
		
		for (int i = 1; i < data.size(); i++) { // i=1 para saltar la primer linea DNI, nombre
			String[] userAndPreferences = filterData(data.get(i));
			Vertex user = null;
			for (int j = 0; j < userAndPreferences.length ; j++) {
				if(j == 0) { // Primera posicion es el ID de Usuario
					user = addUser(userAndPreferences[j]);
				}
				else {
					Vertex pref = addPreference(userAndPreferences[j]);
						user.addAdjacent(pref);
						pref.addAdjacent(user);						
				}
			}
		}
	}
	
	public static Vertex addPreference (String pref) {
		for (int i = 0; i < prefs.size(); i++) {
			if(prefs.get(i).getName().equals(pref)){
				return prefs.get(i); 
			}			
		}
		Vertex preference = new Vertex(pref, "preference");
		prefs.add(preference);			
		return preference;
	}
	
	public static Vertex addUser(String userId) {
		Vertex user = new Vertex(userId, "user");
		users.add(user);
		mapUser.put(userId, userIndex);
		userIndex ++;
		return user;
	}
	
	/**
	 * Dado un usuario, devuelve una lista de usuarios que tienen mas de un gusto en comun
	 * @param userId
	 * @return
	 */
	public static ArrayList<String> getUsersWithMoreThanOneCommonPreference (String userId) {
		int pos = mapUser.get(userId);
		ArrayList<String> answer = new ArrayList<String>(); 
		ArrayList<Vertex> userPrefs = users.get(pos).getAdjacents();
		for (int i = 0; i < users.size(); i++) {
			ArrayList<Vertex> currentUserPrefs = users.get(i).getAdjacents();
			if(hasAtLeastTwoCommonPrefs(userPrefs, currentUserPrefs)){
				answer.add(users.get(i).getName());
			}
			
		}
		
		return answer;
	}
	private static boolean hasAtLeastTwoCommonPrefs(ArrayList<Vertex> arr1, ArrayList<Vertex> arr2){
		int cont = 0;
		for (int i = 0; i < arr1.size() && cont < 2; i++) {
			for (int j = 0; j < arr2.size() && cont < 2; j++) {
				if(arr1.get(i).getName().equals(arr2.get(j).getName())){
					cont++;
				}
			}
		}
		return cont == 2;
	}
	/**
	 * Devuelve el gusto que mas le gusta a todos los usuarios
	 * @return
	 */
	public static String getMostRepeatedPreference() {
		int temp = 0;
		String name = "";
		for (int i = 0; i < prefs.size(); i++) {
			if(temp < prefs.get(i).getAdjacents().size()){
				temp = prefs.get(i).getAdjacents().size();
				name = prefs.get(i).toString();
			}
		}
	return name;	
	}
	
	/**
	 * Dado un usuario, devuelve aquella que tenga gustos más lejanos a él.
	 * @param userId
	 * @return
	 */
	public static String getUserWithDifferentPreferences (String userId) {
		int pos = mapUser.get(userId);
		ArrayList<Vertex> userPrefs = users.get(pos).getAdjacents();
		String answer = "";
		int currentQuant = userPrefs.size();
		
		for (int i = 0; i < users.size(); i++) {
			int times = hasXTimesPreference(userPrefs, users.get(i).getAdjacents(), currentQuant);
			if (times == currentQuant) {
				answer = users.get(i).getName();
			}else if(times < currentQuant){
				currentQuant = times;
				
				answer = users.get(i).getName();
			}
		}
		
		return answer;
	}
	
	private static int hasXTimesPreference(ArrayList<Vertex> arr1, ArrayList<Vertex> arr2, int quant){
		int cont = 0;
		for (int i = 0; i < arr1.size(); i++) {
			for (int j = 0; j < arr2.size(); j++) {
				if(arr1.get(i).getName().equals(arr2.get(j).getName())){
					cont++;
					if (cont > quant) {
						return -1;
					}
				}
			}
		}
		return cont;
	}
	
	public static void printGraph() {
		for (int i = 0; i < 50; i++) {
			System.out.println(users.get(i).toString());
			ArrayList<Vertex> temp = users.get(i).getAdjacents();
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(temp.get(j) + " ");
			}
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
		
		//GraphStructure.printGraph();
		
		//System.out.println(getUsersWithMoreThanOneCommonPreference("28058462"));
		
		//System.out.println(GraphStructure.getMostRepeatedPreference());
		
		System.out.println(getUserWithDifferentPreferences("99102287"));
	}//Rally;Jockey;Kitesurf;Paracaidismo;Sky
}
