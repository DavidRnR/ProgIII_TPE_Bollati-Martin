import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
	
	/**
	 * Leer CSV utilizabndo estructura de arreglo
	 * @param path
	 * @return
	 */
	public static ArrayStructure CSVReaderArray(String path){
		ArrayStructure arr = new ArrayStructure();
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            while ((line = br.readLine()) != null) {

            	String[] items = line.split(cvsSplitBy);
                items = checkPreferences(items);
                String aux = "";
                for (int i = 0; i < items.length; i++) {
                	aux += items[i] + " ";
				}
                arr.add(aux);	
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return arr;
	}
	
	/**
	 * Leer CSV utilizando una estructura Lista vinculada, agregando nodo al principio
	 * @param path
	 * @return
	 */
	public static ListStructure CSVReaderListBegining(String path){
		ListStructure list = new ListStructure();
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy);
                items = checkPreferences(items);
                String aux = "";
                for (int i = 0; i < items.length; i++) {
                	aux += items[i] + " ";
				}
                list.addBegining(aux);					
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return list;
	}
	
	/**
	 * Leer CSV utilizando una estructura Lista vinculada, agregando nodo al final
	 * @param path
	 * @return
	 */
	public static ListStructure CSVReaderListEnd(String path){	
		ListStructure list = new ListStructure();
        String line = "";
        String cvsSplitBy = ";";
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

        	while ((line = br.readLine()) != null) {

        		String[] items = line.split(cvsSplitBy);
                items = checkPreferences(items);
                String aux = "";
                for (int i = 0; i < items.length; i++) {
                	aux += items[i] + " ";
				}
                list.addEnd(aux);	 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return list;
	}
	
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