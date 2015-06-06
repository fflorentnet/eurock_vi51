package fr.utbm.vi51.project.eurock.tree;


public abstract class Tree<D, N extends Node<D,N>> {
	protected N root;
	public N getRoot() { return root; }
	public void setRoot(N r) { root = r;}
	public void addNode(N node) { root.add(node); }
}
