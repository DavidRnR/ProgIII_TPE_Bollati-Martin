
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
}
