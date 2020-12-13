package edu.umb.cs680.hw13.Multicast;

public class PieChartObserver implements DJJAQuoteObserver, StockQuoteObserver {

	private StockQuoteObservable sqo;
	private DJJAQuoteObservable djjaqo;

	public PieChartObserver(StockQuoteObservable sqo) {
		this.sqo = sqo;
		sqo.addObserver(this);
	}

	public PieChartObserver(DJJAQuoteObservable djjaqo) {
		this.djjaqo = djjaqo;
		djjaqo.addObserver(this);
	}

	@Override
	public void updateStock(StockEvent se) {
		sqo.printStockPrice();
		System.out.println("***********************Drawing Pie Chart for Stock Quote*********************** ");
	}

	@Override
	public void updateDJJA(DJJAEvent djja) {
		djjaqo.printQuote();
		System.out.println("***********************Drawing Pie Chart for DJJA*********************** ");

	}

}
