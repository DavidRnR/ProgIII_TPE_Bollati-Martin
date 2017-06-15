import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GraphStructure {
	private ArrayList<Vertex> users = new ArrayList<Vertex>();
	private ArrayList<Vertex> prefs = new ArrayList<Vertex>(); 
	private int userIndex = 0;
	private HashMap<String, Integer> mapUser = new HashMap<String, Integer>();

	
	/**
	 * Recibe un path de un archivo csv y carga el grafo con los datos
	 * @param path
	 */
	public void loadGraph(String path) {
		
		 String line = "";
	        String cvsSplitBy = ";";

	        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	        	br.readLine();
	            while ((line = br.readLine()) != null) {

	            	String[] items = line.split(cvsSplitBy);
	
	                loadGraphStructure(items);	
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public Vertex addPreference (String pref) {
		for (int i = 0; i < prefs.size(); i++) {
			if(prefs.get(i).getName().equals(pref)){
				return prefs.get(i); 
			}			
		}
		Vertex preference = new Vertex(pref, "preference");
		prefs.add(preference);			
		return preference;
	}
	
	public Vertex addUser(String userId) {
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
	public ArrayList<String> getUsersWithMoreThanOneCommonPreference (String userId) {
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
	private boolean hasAtLeastTwoCommonPrefs(ArrayList<Vertex> arr1, ArrayList<Vertex> arr2){
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
	public String getMostRepeatedPreference() {
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
	public String getUserWithDifferentPreferences (String userId) {
		int pos = mapUser.get(userId);

		ArrayList<Vertex> userPrefs = users.get(pos).getAdjacents();
		String answer = "";
		int currentQuant = userPrefs.size();
		
		for (int i = 0; i < users.size(); i++) {
			int times = hasXTimesPreference(userPrefs, users.get(i).getAdjacents(), currentQuant);
	
			if (times == currentQuant) {
				answer = users.get(i).getName();
			}else if(times < currentQuant && times != -1){
				currentQuant = times;
				
				answer = users.get(i).getName();
			}
		}
		
		return answer;
	}
	
	/**
	 * Dados dos ArrayList de Vertex(Adyacentes) y una cantidad actual de casos repetidos,
	 * si el resultado es menor que el considerado actualmente, devuelve el valor actualizado. Sino -1.
	 * @param arr1
	 * @param arr2
	 * @param quant
	 * @return
	 */
	private int hasXTimesPreference(ArrayList<Vertex> arr1, ArrayList<Vertex> arr2, int quant){
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

	
	//**********************************************************************
	
	/**
	 * Carga la data (Usuarios y Gustos) en el grafo
	 * @param data
	 */
	private void loadGraphStructure (String[] userAndPreferences) {
		
		    userAndPreferences = checkPreferences(userAndPreferences);
		    
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
	
	/**
	 * Checkea si los gustos de un usuario no estan repetidos
	 * @param arr
	 * @return
	 */
	private static String[] checkPreferences(String[] arr){
    	
    	ListStructure ls = new ListStructure();
    	for (int i = 0; i < arr.length; i++) {
			if(!ls.contains(arr[i])){
				ls.addEnd(arr[i]);
			}
		}
    	
    	arr = new String[ls.size()];
    	
    	for (int i = 0; i < ls.size(); i++) {
			arr[i] = ls.get(i);
		}
    	return arr;
    } 
}
