
public class SortedArrayApp {

	public static void main(String[] args) {

		//**************Array*********************************************
		ArrayStructure arr;

		ArrayStructure arrToSearch;
		ArrayStructure arrResults;

		long timeStartInsertSorted = System.nanoTime();
		arr = CSVReader.CSVReaderArraySorted("datasets/dataset_500000.csv");
		long timeEndInsertSorted = System.nanoTime();
		
		System.out.println("Tiempo de insertado ordenado: " + (timeEndInsertSorted - timeStartInsertSorted) );
		
		arrToSearch = CSVReader.CSVReaderArray("datasets/dataset_insert_10000.csv");
		
		long timeStartBinarySearch = System.nanoTime();
		arrResults = searchResult(arr, arrToSearch);
		long timeEndBinarySearch = System.nanoTime();
		
		System.out.println("Tiempo de busqueda binaria: " + (timeEndBinarySearch - timeStartBinarySearch));
		CSVWriter.writeFromArray(arrResults, "salida_busqueda_binaria_array_sorted_500000");
		
	}
	
	/**
	 * Devuelve un arreglo con resultados de una busqueda sobre otro arreglo
	 * @param base
	 * @param toSearch
	 * @return
	 */
	public static ArrayStructure searchResult (ArrayStructure base, ArrayStructure toSearch) {
		ArrayStructure result = new ArrayStructure();
		
		for (int i = 0; i < toSearch.size(); i++) {
			if (binarySearch(base, getId(toSearch.get(i)))) {
				result.add(toSearch.get(i) + "true");
			}
			else {
				result.add(toSearch.get(i) + "false");
			}
		}
		return result;
	}
	/**
	 * Busqueda binaria de un int (dni) en un arreglo ordenado
	 * @param arr
	 * @param dato
	 * @return
	 */
	private static boolean binarySearch(ArrayStructure arr, int data){ 

		int center,inf = 0, sup = arr.size()-1;

		while(inf<=sup){ 

			center= (sup+inf)/2; 
			int dni = getId(arr.get(center)); // Get ID parsed
			
			if( dni == data) 
				return true; 
			else if(data < dni){ 
				sup = center-1; 
			} 
			else { 
				inf = center+1;
			} 
		} 
		return false; 
	}

	/**
	 * Get id de una arreglo de String
	 * @param data
	 * @return
	 */
	private static int getId (String data) {
		
		//Obtener Strings de data separados por un espacio
		String[] items = data.split(" ");

		try {
			return Integer.parseInt(items[0]);
		} catch (Exception e) {
			// handle exception
			return -1;
		}
	}

}
