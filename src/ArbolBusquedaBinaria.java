public class ArbolBusquedaBinaria {
	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
 
		TreeNode(int data) {
			this.data = data;
		}
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
			// Verifica Si el nodo a eliminar tiene ambos hijos 
			if (root.left != null && root.right != null) {
				TreeNode temp = root;
				// Busca el elemento menor de la derecha
				TreeNode minNodeForRight = elementoMenor(temp.right);
				// Remplaza el nodo current con el nodo menor del subárbol derecho
				root.data = minNodeForRight.data;
				// Borra el nodo menor del subárbol derecho 
				eliminar(root.right, minNodeForRight.data);
 
			}
			// verifica Si el nodo a ser borrado tiene solo un hijo izquierdo
			else if (root.left != null) {
				root = root.left;
			}
			// Verifica si el nodo a ser borrado tiene solo un hijo a la derecha
			else if (root.right != null) {
				root = root.right;
			}
			// Verifica si el nodo a ser borrado no tiene hijos
			else
				root = null;
		}
		return root;
	}
 
	public static TreeNode insert(TreeNode root, TreeNode nodeToBeInserted) {
		if (root == null) {
			root = nodeToBeInserted;
			return root;
		}
 
		if (root.data > nodeToBeInserted.data) {
			if (root.left == null)
				root.left = nodeToBeInserted;
			else
				insert(root.left, nodeToBeInserted);
		} else if (root.data < nodeToBeInserted.data)
			if (root.right == null)
				root.right = nodeToBeInserted;
			else
				insert(root.right, nodeToBeInserted);
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
		if( root != null) {
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
 
	public static void main(String[] args) {
 
		// Acá se crea un árbol de búsqueda binaria
		TreeNode rootNode = createBinarySearchTree();
 
		System.out.println("Árbol Binario");
		inOrder(rootNode);
		System.out.println();
		int NodoaEliminar = 40;
		TreeNode rootNodeRes = eliminar(rootNode, NodoaEliminar);
		System.out.println("Árbol sin el elemento " + NodoaEliminar + " eliminado");
		inOrder(rootNodeRes);
		

	}
 
	public static TreeNode createBinarySearchTree() {
		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);
		TreeNode node5 = new TreeNode(5);
		TreeNode node13 = new TreeNode(13);
		TreeNode node55 = new TreeNode(55);
 
		insert(null, rootNode);
		insert(rootNode, node20);
		insert(rootNode, node10);
		insert(rootNode, node30);
		insert(rootNode, node60);
		insert(rootNode, node50);
		insert(rootNode, node70);
		insert(rootNode, node5);
		insert(rootNode, node13);
		insert(rootNode, node55);
		insert(rootNode, node13);
		return rootNode;
	}
}