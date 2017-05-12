import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {

	public static void writeFromArray(ArrayStructure arr, String fileName) {
		BufferedWriter bw = null;
		try {
			File file = new File("datasets/" + fileName + ".csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			for (int i = 0; i < arr.size(); i++) {
				String contenidoLinea = arr.get(i);
				bw.write(contenidoLinea);
				bw.newLine();				
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
	}

	
	public static void writeFromList(ListStructure list, String fileName) {
		BufferedWriter bw = null;
		try {
			File file = new File("datasets/" + fileName + ".csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			for (int i = 0; i < list.size(); i++) {
				String contenidoLinea = list.get(i);
				bw.write(contenidoLinea);
				bw.newLine();				
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
	}
}