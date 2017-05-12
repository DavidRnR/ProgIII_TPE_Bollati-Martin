
public class ArrayApp {

	public static void main(String[] args) {

		//**************Array*********************************************
		ArrayStructure arr;
		ArrayStructure arrSearch;
		ArrayStructure arrSearchResults;
			
		arr = CSVReader.CSVReaderArray("datasets/dataset_500000.csv");
		arr.addAll(CSVReader.CSVReaderArray("datasets/dataset_insert_10000.csv"));
		
		arrSearch = CSVReader.CSVReaderArray("datasets/dataset_busqueda_10000.csv");
		arrSearchResults = ArrayApp.searchResults(arr, arrSearch);
		
		CSVWriter.writeFromArray(arrSearchResults, "salida_busqueda_array");
//		CSVWriter.writeFromArray(arr);
		
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
			long timeStart = System.currentTimeMillis();
			if (base.contains(toFind.get(i))) {
				long timeNow = System.currentTimeMillis();
				result.add(toFind.get(i) + " encontrado en " + (timeNow - timeStart) + " ms");
			}else{
				long timeNow = System.currentTimeMillis();
				result.add(toFind.get(i) + " no encontrado " + (timeNow - timeStart) + " ms");
			}
		}
		return result;
	} 
	
	//TODO Al insertar un CSV en otro se deben grabar los tiempos.
//	public static ArrayStructure insertResults(ArrayStructure base, ArrayStructure toInsert){
//		ArrayStructure result = new ArrayStructure();
//
//		for (int i = 0; i < toInsert.size(); i++) {
//			long timeStart = System.currentTimeMillis();
//			long timeNow = System.currentTimeMillis();
//			result.add(toInsert.get(i) + " insertado en " + (timeNow - timeStart) + " ms");		
//		}
//		return result;
//	} 
}
