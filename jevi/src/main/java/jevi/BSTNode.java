package jevi;

public class BSTNode {
	protected String data;
    protected BSTNode left, right;

    public BSTNode() 
    {
        left = null;
        right = null;
    }

    public BSTNode(String data)
    {
        this(data,null,null);
    }

    public BSTNode(String data, BSTNode lt, BSTNode rt) 
    {
        this.data = data; 
        left = lt; 
        right = rt;
    }
}
