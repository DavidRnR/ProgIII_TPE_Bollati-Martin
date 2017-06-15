
public class GraphApp {
	//********************************Main for test***********************************
		public static void main(String[] args) {
				
			GraphStructure graph = new GraphStructure();
			
			graph.loadGraph("datasets/dataset_3000000.csv");
					
			System.out.println(graph.getUsersWithMoreThanOneCommonPreference("28058462"));
			
			System.out.println(graph.getMostRepeatedPreference());
			
			System.out.println(graph.getUserWithDifferentPreferences("99102287"));
		}
}
