package myProject;

public interface IHand extends Iterable<ICard>{
	public void add(ICard card);
	public void remove(ICard card);
	public int size();
	
	

}
