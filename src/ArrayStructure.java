
public class ArrayStructure {
	private String[] arr = new String[10000];
	private int index = 0;
	
	/**
	 * Agregar un string
	 * @param s
	 */
	public void add(String s){
		if(arr.length > index){
			arr[index] = s;
			index++;			
		}else{
			extendArray();
			add(s);
		}
	}
	
	/**
	 * 
	 * @param array
	 */
	
	public void addAll(ArrayStructure array){
		for (int i = 0; i < array.size(); i++) {
			add(array.get(i));
		}
	}
	
	/**
	 * Obtener un valor del arreglo (arr) por pos
	 * @param i
	 * @return
	 */
	public String get(int i){
		if(arr[i] != null){
			return arr[i]; 
		}else{
			return null;
		}
	}
	
	/**
	 * Obtener tamaño del arreglo
	 * @return
	 */
	public int size(){
		return index;
	}
	
	/**
	 * Extender el tamaño del arreglo si está lleno
	 */
	private void extendArray(){
		String[] newArray = new String[arr.length*2];
		for (int i = 0; i < arr.length; i++) {
			newArray[i] = arr[i];
		}
		arr = newArray;
	}
	
	public boolean contains(String value){
		for (int i = 0; i < index; i++) {
			if(value.equals(get(i)))
				return true;
		}
		return false;
	}
}
