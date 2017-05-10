
public class Main {
 
    public static void main(String[] args) {
//		ArrayStructure arr = new ArrayStructure();
//		
//		long startTime = System.currentTimeMillis();
//		
//		arr = CSVReader.CSVReaderArray("datasets/dataset_3000000.csv");
//		
//		long endTime = System.currentTimeMillis();
//		System.out.println("Tiempo de lectura de 3000000 líneas - ArrayStructure "+(endTime - startTime) + " ms");
		//for (int i = 0; i < arr.size(); i++) {
			//System.out.println(arr.get(i));
		//}

//		ListStructure listBegin = new ListStructure();
		ListStructure listEnd = new ListStructure();
		
//		
//		
//		for (int i = 0; i < 100; i++) {
//			System.out.println(listBegin.get(i));
//		}
		
		long startTime = System.currentTimeMillis();
		
//		listBegin = CSVReader.CSVReaderListBegining("datasets/dataset_500000.csv");		
		listEnd = CSVReader.CSVReaderListEnd("datasets/dataset_500000.csv");
		long endTime = System.currentTimeMillis();
		System.out.println("Tiempo de lectura de 500000 líneas - ListStructure - Insertando al final "+(endTime - startTime) + " ms");
    }
    
}
