
public class ArrayStructure {
	private String[] arr = new String[10000];
	private int index = 0;
	
	public void add(String s){
		if(arr.length > index){
			arr[index] = s;
			index++;			
		}else{
			extendArray();
			add(s);
		}
	}
	
	public String get(int i){
		if(arr[i] != null){
			return arr[i]; 
		}else{
			return null;
		}
	}
	
	public int size(){
		return index;
	}
	
	private void extendArray(){
		String[] newArray = new String[arr.length*2];
		for (int i = 0; i < arr.length; i++) {
			newArray[i] = arr[i];
		}
		arr = newArray;
	}
}
