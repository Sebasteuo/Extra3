/**
 * Esta clase contiene los metodos necesarios para la creacion del arbol binario de busqueda, así como los recorridos, diferencia, etc.
 * @author Sebastian Alba 
 * @author Randal Mendez
 * @author David Pereira
 *
 */
public class ArbolBusquedaBinaria {
	
	/**
	 *  Método Main se crea una instancia de un árbol binario. Donde se obtiene el recorrido Inorden,preorden,postorden, con el
	 *  elemento eliminado y la diferencia.
	 * @param args
	 */

	public static void main(String[] args) {

		// Aca se crea un Arbol de busqueda binaria
		Nodos rootNode = CrearArbolBinario();

		System.out.println("Arbol Binario en recorrido In-Orden:");
		inOrder(rootNode);
		System.out.println();
		int NodoaEliminar = 40; //ACA SE DEBE ESTABLECER EL NODO QUE SE DESEA ELIMINAR, en este caso pusimos 40.
		Nodos rootNodeRes = eliminar(rootNode, NodoaEliminar);
		System.out.println("Arbol sin el elemento " + NodoaEliminar + " eliminado:");
		inOrder(rootNodeRes);
		System.out.println();
		System.out.println("Recorrido Pre-Orden:");
		preOrder(rootNodeRes);
		System.out.println();
		System.out.println("Recorrido Post-Orden:");
		postOrder(rootNodeRes);
		System.out.println();
		calcularDiferencia(rootNode);

	}
	/**
	 * Este metodo obtiene el elemento menor
	 * @param root
	 * @return
	 */
	// Metodo que obtiene el menor elemento
	public static Nodos elementoMenor(Nodos root) {
		if (root.left == null)
			return root;
		else {
			return elementoMenor(root.left);
		}
	}
	/**
	 * Este metodo se encarga de eliminar el nodo en el arbol, validando si existe, si es la raiz, si es mayor o menor a la raiz.
	 * @param root
	 * @param value
	 * @return
	 */
	public static Nodos eliminar(Nodos root, int value) {
		if (root == null)
			return null;
		if (root.data > value) {
			root.left = eliminar(root.left, value);
		} else if (root.data < value) {
			root.right = eliminar(root.right, value);

		} else {
			// Verifica Si el nodo a eliminar tiene ambos hijos, se conecta el padre de nodo al nodo más 
			// a la izquierda (mínimo) del subárbol derecho o al nodo derecha (máximo) del subárbol izquierdo.
			if (root.left != null && root.right != null) {
				Nodos temp = root;
				// Busca el elemento menor de la derecha
				Nodos minNodeForRight = elementoMenor(temp.right);
				// Remplaza el nodo current con el nodo menor del sub-arbol derecho
				root.data = minNodeForRight.data;
				// Borra el nodo menor del sub-arbol derecho
				eliminar(root.right, minNodeForRight.data);

			}
			// verifica Si el nodo a ser borrado tiene solo un hijo izquierdo. Se conecta el 
			//padre del nodo eliminado directamente al elemento secundario del nodo eliminado.
			else if (root.left != null) {
				root = root.left;
			}
			// Verifica si el nodo a ser borrado tiene solo un hijo a la derecha
			//Se conecta el padre del nodo eliminado directamente al elemento secundario del nodo eliminado.
			else if (root.right != null) {
				root = root.right;
			}
			// Verifica si el nodo a ser borrado no tiene hijos, solo se busca el nodo y se hace nulo.
			else
				root = null;
		}
		return root;
	}
	/**
	 * Este metodo se encarga de insertar, valida que no haya repetidos. Ademas verifica si debe irse por el subarbol izq o der.
	 * @param root
	 * @param nodoaInsertar
	 * @return
	 */
	public static Nodos Insertar(Nodos root, Nodos nodoaInsertar) {
		if (root == null) {
			root = nodoaInsertar;
			return root;
		}

		if (root.data > nodoaInsertar.data) {
			if (root.left == null)
				root.left = nodoaInsertar;
			else
				Insertar(root.left, nodoaInsertar);
		} else if (root.data < nodoaInsertar.data)
			if (root.right == null)
				root.right = nodoaInsertar;
			else
				Insertar(root.right, nodoaInsertar);
		return root;
	}
	/**
	 * Este metodo recorre el arbol en Inorden, es decir primero el subarbol izquierdo, luego la raiz y por ultimo el subarbol derecho.
	 * @param root
	 */
	public static void inOrder(Nodos root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	/**
	 * Este metodo recorre el arbol en preOrden, es decir primero la raiz, luego el subarbol izquierdo y por ultimo el subarbol derecho
	 * @param root
	 */
	public static void preOrder(Nodos root) {
		if (root != null) {
			System.out.print(root.data + " ");
			inOrder(root.left);
			inOrder(root.right);
		}

	}
	/**
	 * Este metodo recorre el arbol en PostOrden, es decir primero el subarbol izquierdo, luego el subarbol derecho y por ultimo la raiz
	 * @param root
	 */
	public static void postOrder(Nodos root) {
		if (root != null) {
			inOrder(root.left);
			inOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
	/**
	 * EN este metodo se crea el arbol binario, agregando los nodos que se quiere tener.
	 * @return
	 */
	public static Nodos CrearArbolBinario() {
		Nodos rootNode = new Nodos(40);
		Nodos node20 = new Nodos(20);
		Nodos node10 = new Nodos(10);
		Nodos node30 = new Nodos(30);
		
		
		
		Insertar(null, rootNode);
		Insertar(rootNode, node20);
		Insertar(rootNode, node10);
		Insertar(rootNode, node30);
		Insertar(rootNode, node30);

		return rootNode;
	}
	/**
	 * Este metodo se encarga de calcular la diferencia del nodo Mayor menos el nodo Menor.
	 * @param arbol
	 */
	public static void calcularDiferencia(Nodos arbol) {
		Nodos auxMax = arbol;
		Nodos auxMin = arbol;
		int diferencia = 0;
		while (auxMax.right != null) {
			auxMax = auxMax.right;
		}
		while (auxMin.left != null) {
			auxMin = auxMin.left;
		}
		diferencia = auxMax.data - auxMin.data;
		System.out.println("La diferencia entre el nodo Mayor y el menos es de: " + diferencia);
	}

}
