
public class ListBeginingApp {
	public static void main(String[] args) {

		//****************List agregando Principio*******************************
		ListStructure listBegin = new ListStructure();
		
		listBegin = CSVReader.CSVReaderListBegining("datasets/dataset_500000.csv");

		//TODO AddAll() for List Structure
		//		listBegin.addAll(CSVReader.CSVReaderArray("datasets/dataset_insert_10000.csv"));
		
		ListStructure listSearch;
		ListStructure listSearchResults;
		
		listSearch = CSVReader.CSVReaderListBegining("datasets/dataset_busqueda_10000.csv");
		listSearchResults = ListBeginingApp.searchResults(listBegin, listSearch);
		
		CSVWriter.writeFromList(listSearchResults, "salida_busqueda_listBegining");
		
		
		//***********************************************************************
	}
	public static ListStructure searchResults(ListStructure base, ListStructure toFind){
		ListStructure result = new ListStructure();

		for (int i = 0; i < toFind.size(); i++) {
			long timeStart = System.currentTimeMillis();
			if (base.contains(toFind.get(i))) {
				long timeNow = System.currentTimeMillis();
				result.addBegining(toFind.get(i) + " encontrado en " + (timeNow - timeStart) + " ms");
			}else{
				long timeNow = System.currentTimeMillis();
				result.addBegining(toFind.get(i) + " no encontrado " + (timeNow - timeStart) + " ms");
			}
		}
		return result;
	} 

}
