package fr.utbm.vi51.project.eurock.tree;

public abstract class Node<D, N extends Node<D,N>> {

	protected N[] children;
	D data;
	public D getData() { return data; }
	public void setData(D da) { data = da; }
	public abstract void add(N node);
	public abstract int getCount();
}
