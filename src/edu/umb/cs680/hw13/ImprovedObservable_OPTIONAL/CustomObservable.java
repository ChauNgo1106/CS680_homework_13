package edu.umb.cs680.hw13.ImprovedObservable_OPTIONAL;

public interface CustomObservable<T> {
	public void addObserver(CustomObserver<T> o);
	public void removeObserver(CustomObserver<T> o);
	public void notifyObserver(T event);
}
