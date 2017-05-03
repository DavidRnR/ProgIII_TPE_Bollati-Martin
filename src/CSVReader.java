import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
	
	public static ArrayStructure CSVReaderArray(String path){
		ArrayStructure arr = new ArrayStructure();
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy); 
                arr.add(items[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return arr;
	}
	
	public static ListStructure CSVReaderListBegining(String path){
		ListStructure list = new ListStructure();
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy); 
                list.addBegining(items[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return list;
	}
	
	public static ListStructure CSVReaderListEnd(String path){
		ListStructure list = new ListStructure();
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy); 
                list.addEnd(items[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return list;
	}

    public static void main(String[] args) {
		ArrayStructure arr = new ArrayStructure();
		
		arr = CSVReader.CSVReaderArray("datasets/dataset_500000.csv");
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}

    }
    
}