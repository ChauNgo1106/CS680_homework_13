package edu.umb.cs680.hw13.ObserverOptional;

public interface CustomObservable {
	public void addObserver(CustomObserver o);
	public void removeObserver(CustomObserver o);
	public void notifyObserver(Object arg);
}
