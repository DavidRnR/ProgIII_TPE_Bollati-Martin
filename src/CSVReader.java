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
                arr.add(items[0]);
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
                list.addBegining(items[0]);
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
                list.addEnd(items[0]);  
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return list;
	}
	
    
}