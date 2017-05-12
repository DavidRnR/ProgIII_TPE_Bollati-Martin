
public class ArrayApp {

	public static void main(String[] args) {

		//**************Array*********************************************
		ArrayStructure arr;
		
		ArrayStructure arrInsert;
		ArrayStructure arrInsertResults;
		
		ArrayStructure arrSearch;
		ArrayStructure arrSearchResults;
			
		arr = CSVReader.CSVReaderArray("datasets/dataset_3000000.csv");
		
		arrInsert = CSVReader.CSVReaderArray("datasets/dataset_insert_10000.csv");
		arrInsertResults = ArrayApp.insertResults(arr, arrInsert);
		
		CSVWriter.writeFromArray(arrInsertResults, "salida_insert_array_3000000");
		
		arrSearch = CSVReader.CSVReaderArray("datasets/dataset_busqueda_10000.csv");
		arrSearchResults = ArrayApp.searchResults(arr, arrSearch);
		
		CSVWriter.writeFromArray(arrSearchResults, "salida_busqueda_array_3000000");
		
		//*****************************************************************		
	}
	/**
	 * Toma de tiempos de busqueda de String de un arreglo.	
	 * @param base
	 * @param toFind
	 * @return
	 */
	public static ArrayStructure searchResults(ArrayStructure base, ArrayStructure toFind){
		ArrayStructure result = new ArrayStructure();

		for (int i = 0; i < toFind.size(); i++) {
			long timeStart = System.nanoTime();
			if (base.contains(toFind.get(i))) {
				long timeNow = System.nanoTime();
				result.add(toFind.get(i) + " encontrado en " + (timeNow - timeStart) + " ns");
			}else{
				long timeNow = System.nanoTime();
				result.add(toFind.get(i) + " no encontrado " + (timeNow - timeStart) + " ns");
			}
		}
		return result;
	} 
	
	/**
	 * Toma de tiempos de insercion de Strings en un arreglo.	
	 * @param base
	 * @param toInsert
	 * @return
	 */
	public static ArrayStructure insertResults(ArrayStructure base, ArrayStructure toInsert){
		ArrayStructure result = new ArrayStructure();

		for (int i = 0; i < toInsert.size(); i++) {
			long timeStart = System.nanoTime();
			base.add(toInsert.get(i));
			long timeNow = System.nanoTime();
			result.add(toInsert.get(i) + " insertado en " + (timeNow - timeStart) + " ns");		
		}
		return result;
	} 
}
