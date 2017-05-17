
public class ListBeginingApp {
	public static void main(String[] args) {

		//****************List agregando Principio*******************************
		ListStructure list;
		
		ListStructure listInsert;
		ListStructure listInsertResults;
		
		ListStructure listSearch;
		ListStructure listSearchResults;
		long timeStartInsert = System.nanoTime();
		list = CSVReader.CSVReaderListBegining("datasets/dataset_3000000.csv");
		
		listInsert = CSVReader.CSVReaderListBegining("datasets/dataset_insert_10000.csv");
		listInsertResults = ListBeginingApp.insertResults(list, listInsert);
		
		CSVWriter.writeFromList(listInsertResults, "salida_insert_list_begining_3010000");
		long timeEndInsert = System.nanoTime();
		long totalInsert = timeEndInsert - timeStartInsert;
		System.out.println("Tiempo total de Insert ListStructure ingresando al principio: " + totalInsert + "ns");
		
		long timeStartSearch = System.nanoTime();
		listSearch = CSVReader.CSVReaderListBegining("datasets/dataset_busqueda_10000.csv");
		listSearchResults = ListBeginingApp.searchResults(list, listSearch);
		
		CSVWriter.writeFromList(listSearchResults, "salida_busqueda_list_begining_3000000");
		long timeEndSearch = System.nanoTime();
		long totalSearch = timeEndSearch - timeStartSearch;
		System.out.println("Tiempo total de Busqueda ListStructure Begining: " + totalSearch + "ns");
		System.out.println("Promedio: "+((totalInsert+totalSearch)/2)+"ns");
		
		//***********************************************************************
	}
	
	/**
	 *  Metodo que guarda los tiempos de busqueda de un String en otra List | Ultilizando Add al principio	
	 * @param base
	 * @param toFind
	 * @return
	 */
	public static ListStructure searchResults(ListStructure base, ListStructure toFind){
		ListStructure result = new ListStructure();

		for (int i = 0; i < toFind.size(); i++) {
			long timeStart = System.nanoTime();
			if (base.contains(toFind.get(i))) {
				long timeNow = System.nanoTime();
				result.addBegining(toFind.get(i) + " encontrado en " + (timeNow - timeStart) + " ns");
			}else{
				long timeNow = System.nanoTime();
				result.addBegining(toFind.get(i) + " no encontrado " + (timeNow - timeStart) + " ns");
			}
		}
		return result;
	} 
	

	/**
	 * Toma de tiempos de insercion de Strings en una List |Add al principio.	
	 * @param base
	 * @param toInsert
	 * @return
	 */
	public static ListStructure insertResults(ListStructure base, ListStructure toInsert){
		ListStructure result = new ListStructure();

		for (int i = 0; i < toInsert.size(); i++) {
			long timeStart = System.nanoTime();
			base.addBegining(toInsert.get(i));
			long timeNow = System.nanoTime();
			result.addBegining(toInsert.get(i) + " insertado en " + (timeNow - timeStart) + " ns");		
		}
		return result;
	} 

}
