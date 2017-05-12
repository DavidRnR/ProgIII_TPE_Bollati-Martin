
public class ListEndApp {
	public static void main(String[] args) {
		//****************List agregando al final********************************
		ListStructure listEnd = new ListStructure();
		
		listEnd = CSVReader.CSVReaderListEnd("datasets/dataset_500000.csv");
				
		//***********************************************************************
	}
	
	/**
	 * Metodo que guarda los tiempos de busqueda de un String en otra List | Ultilizando Add al final
	 * @param base
	 * @param toFind
	 * @return
	 */
	public static ListStructure searchResults(ListStructure base, ListStructure toFind){
		ListStructure result = new ListStructure();

		for (int i = 0; i < toFind.size(); i++) {
			long timeStart = System.currentTimeMillis();
			if (base.contains(toFind.get(i))) {
				long timeNow = System.currentTimeMillis();
				result.addEnd(toFind.get(i) + " encontrado en " + (timeNow - timeStart) + " ms");
			}else{
				long timeNow = System.currentTimeMillis();
				result.addEnd(toFind.get(i) + " no encontrado " + (timeNow - timeStart) + " ms");
			}
		}
		return result;
	} 
	
	//TODO Metodo de Insertar y tomar tiempos.
}
