
public class ListStructure {
	Node first;
	int index = 0;

	public ListStructure () {
		first = null;
	}
	
	/**
	 * 
	 */

	public void addAllBegining(ListStructure ls){
		for (int i = 0; i < ls.size(); i++) {
			addBegining(ls.get(i));
		}
	}
	
	/**
	 * 
	 */
	
	public void addAllEnd(ListStructure ls){
		for (int i = 0; i < ls.size(); i++) {
			addEnd(ls.get(i));
		}
	}
	
	/**
	 * Agrega un Nodo al principio de la lista
	 * @param n
	 */
	public void addBegining (String s) {
		Node tmp =  new Node(s);
		tmp.setNext(first);
		first = tmp;
		index++;
	}

	/**
	 * Agrega un Nodo al final de la lista
	 * @param n
	 */
	public void addEnd (String n) {
		Node actualNode = first;

		if(actualNode == null) {
			first = new Node(n);
		}
		else {
			while(actualNode.getNext() != null) {
				actualNode = actualNode.getNext();
			}		
			actualNode.setNext(new Node(n));	
		}
		index++;	
	}

	/**
	 * Retorna el tamano de la lista vinculada	
	 * @return
	 */
	public int size() {
		return index;
	}

	/**
	 * Cuando primero es igual a null la lista esta vacia
	 * @return
	 */
	public boolean isEmpty () {
		return first == null;
	}

	@Override
	/**
	 * Recorre la lista vinculada y guarda en 's' cada valor de cada Nodo
	 */
	public String toString(){
		Node actualNode = first;
		String s = "";
		while (actualNode != null) {
			s += actualNode.getValue();
			s += " ";
			actualNode = actualNode.getNext();
		}
		return s;
	}

	/**
	 * Recorre la lista vinculada y retorna el valor de un Nodo en una determinada posicion
	 * @param pos
	 * @return
	 */
	public String get(int pos){
		String resp = "";  
		
		Node nodoActual = first;
		while (nodoActual != null) {
			if (pos == 0) {
				resp = nodoActual.getValue();
				return resp;
			}
			nodoActual = nodoActual.getNext();
			pos --;
		}
		return resp;
	}

	/**
	 * Elimina un Nodo es una determianda pos de la lista vinculada
	 * @param pos
	 * @return
	 */
	public boolean delete(int pos){		
		
		//Cuando solo tiene un elemento
		if(pos == 0) {
			first = first.getNext();
			index--;
		}		

		Node actualNode = first;
		
		while(actualNode != null && pos > 0){
			if (pos == 1) {
				Node temp = actualNode.getNext();
				actualNode.setNext(temp.getNext());
				index--;
				return true;
			}
			pos --;
			actualNode = actualNode.getNext();
		}	
		return false;
	}


	public boolean contains (String s) {
		Node nodoActual = first;

		while(nodoActual != null) {
			if (nodoActual.getValue().equals(s)) {
				return true;
			}
			else {
				nodoActual = nodoActual.getNext();
			}
		}

		return false;
	}

	//***************Private Class - Node********************************************************************************
	private class Node {
		private String value;	
		private Node next;

		public Node (String v) {
			value = v;
		}


		/**
		 * Get valor
		 * @return
		 */
		public String getValue() {
			return value;
		}

		public void setNext(Node n) {
			next = n;
		}

		public Node getNext() {
			return next;
		}
	}

}