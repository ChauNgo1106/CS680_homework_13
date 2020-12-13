package edu.umb.cs680.hw13.ImprovedObservable_OPTIONAL;

public interface CustomObserver <T> {
	public void update(CustomObservable<T> o, T event);
}
