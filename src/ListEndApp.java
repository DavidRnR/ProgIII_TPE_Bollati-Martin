
public class ListEndApp {
	public static void main(String[] args) {
		//****************List agregando al final********************************
		ListStructure listEnd = new ListStructure();
		long startTime = System.currentTimeMillis();
		listEnd = CSVReader.CSVReaderListEnd("datasets/dataset_500000.csv");
		long endTime = System.currentTimeMillis();		
		System.out.println("Tiempo de lectura de 500000 líneas - ListStructure - Insertando al final "+(endTime - startTime) + " ms");
		//***********************************************************************
	}
}
