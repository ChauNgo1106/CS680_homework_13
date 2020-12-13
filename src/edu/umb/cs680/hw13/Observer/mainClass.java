package edu.umb.cs680.hw13.Observer;

public class mainClass {

	public static void main(String[] args) {
		
		//Stock Quote
		StockQuoteObservable so = new StockQuoteObservable();
		PiechartObserver po = new PiechartObserver(so);
		
		so.addStock("IBM", 199.12F);
		so.addStock("Google", 249.48F);
		so.addStock("Facebook", 341.21F);
		
		System.out.println();
		System.out.println("**************************Observer**************************");
		System.out.println();
		
		so.changeQuote("IBM", 199.12F);
		System.out.println();
		so.changeQuote("IBM", 375.12F);
		System.out.println();
		
		
		//DJJA
		DJJAQuoteObservable djja = new DJJAQuoteObservable(0F);
		PiechartObserver po1 = new PiechartObserver(djja);
		
		djja.changeQuote(200.1F);
		System.out.println();
		djja.changeQuote(212.0F);
	}

}
