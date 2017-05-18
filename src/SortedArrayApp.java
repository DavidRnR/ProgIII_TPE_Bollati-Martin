
public class SortedArrayApp {

	public static void main(String[] args) {
	
		//**************Array*********************************************
				ArrayStructure arr;
				
				ArrayStructure arrInsert;
				ArrayStructure arrInsertResults;
				
				ArrayStructure arrSearch;
				ArrayStructure arrSearchResults;

				arr = CSVReader.CSVReaderArraySorted("datasets/test_dataset_10.csv");
				
				arrInsert = CSVReader.CSVReaderArraySorted("datasets/dataset_insert_10000.csv");
				arrInsertResults = ArrayApp.insertResults(arr, arrInsert);
				CSVWriter.writeFromArray(arrInsertResults, "salida_insert_array_sorted_test");
	}

}
