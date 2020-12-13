package edu.umb.cs680.hw13.Multicast;

public class mainClass {

	public static void main(String[] args) {
		StockQuoteObservable so = new StockQuoteObservable();
		PieChartObserver po = new PieChartObserver(so);
		
		so.addStock("IBM", 199.12F);
		so.addStock("Google", 249.48F);
		so.addStock("Facebook", 341.21F);
		System.out.println();
		System.out.println("**************************Multicast**************************");
		System.out.println();
		so.changeQuote("IBM", 133.45F);
		so.changeQuote("IBM", 154.45F);
		
		DJJAQuoteObservable djja = new DJJAQuoteObservable();

		PieChartObserver po1 = new PieChartObserver(djja);

		djja.changeQuote(3.42F);
		djja.changeQuote(10.11F);

	}

}
