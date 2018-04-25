public class ArbolBusquedaBinaria {

	public static void main(String[] args) {
		 
		// Acá se crea un árbol de búsqueda binaria
		TreeNode rootNode = CrearArbolBinario();
 
		System.out.println("Árbol Binario en recorrido In-Orden");
		inOrder(rootNode);
		System.out.println();
		int NodoaEliminar = 40;
		TreeNode rootNodeRes = eliminar(rootNode, NodoaEliminar);
		System.out.println("Árbol sin el elemento " + NodoaEliminar + " eliminado");
		inOrder(rootNodeRes);
		System.out.println();
		System.out.println("Recorrido Pre-Orden" );
		preOrder(rootNodeRes);
		System.out.println();
		System.out.println("Recorrido Post-Orden" );
		postOrder(rootNodeRes);
		
		

	}
	// Método que obtiene el menor elemento
	public static TreeNode elementoMenor(TreeNode root) {
		if (root.left == null)
			return root;
		else {
			return elementoMenor(root.left);
		}
	}

	public static TreeNode eliminar(TreeNode root, int value) {
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
				TreeNode temp = root;
				// Busca el elemento menor de la derecha
				TreeNode minNodeForRight = elementoMenor(temp.right);
				// Remplaza el nodo current con el nodo menor del sub-arbol derecho
				root.data = minNodeForRight.data;
				// Borra el nodo menor del subárbol derecho
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

	public static TreeNode Insertar(TreeNode root, TreeNode nodoaInsertar) {
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

	public static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public static void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			inOrder(root.left);
			inOrder(root.right);
		}

	}

	public static void postOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			inOrder(root.right);
			System.out.print(root.data + " ");
		}
	}


	public static TreeNode CrearArbolBinario() {
		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);

		Insertar(null, rootNode);
		Insertar(rootNode, node20);
		Insertar(rootNode, node10);
		Insertar(rootNode, node30);

		return rootNode;
	}


}
