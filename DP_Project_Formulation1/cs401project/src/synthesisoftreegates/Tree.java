package synthesisoftreegates;

public class Tree{
	
private Tree left;
private Tree right;
private float delay;

public Tree(float delay){
	this.delay=delay;
	this.left=null;
	this.right=null;
}

public Tree(float delay,Tree left,Tree right){
	this.delay=delay;
	this.left=left;
	this.right=right;
}

public Tree getLeft(){
	return left;
}

public Tree getRight(){
	return right;
}

public float getValue(){
	return delay;
}

public void setLeft(Tree newLeft){
	left=newLeft;	
}

public void setRight(Tree newRight){
	right=newRight;	
}

public void setValue(float newDelay){
	delay=newDelay;	
}
}
