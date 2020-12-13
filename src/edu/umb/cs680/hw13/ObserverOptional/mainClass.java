package edu.umb.cs680.hw13.ObserverOptional;

public class mainClass {

	public static void main(String[] args) {
		StockQuoteCustomObservable so = new StockQuoteCustomObservable();
		PieChartObserver po = new PieChartObserver(so);

		so.addStock("IBM", 199.12F);
		so.addStock("Google", 249.48F);
		so.addStock("Facebook", 341.21F);

		so.changeQuote("IBM", 133.45F);
		so.changeQuote("IBM", 154.45F);
		so.changeQuote("Google", 244.19F);

		DJJAQuoteCustomObservable djja = new DJJAQuoteCustomObservable();

		PieChartObserver po1 = new PieChartObserver(djja);

		djja.changeQuote(3.42F);
		djja.changeQuote(10.21F);

	}

}
