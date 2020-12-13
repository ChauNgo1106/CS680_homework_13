package edu.umb.cs680.hw13.Observer;

import static org.junit.jupiter.api.Assertions.*;


import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StockTest {
	public static StockQuoteObservable so;
	public static PiechartObserver po;
	public static DJJAQuoteObservable djja;
	// Pie Chart is same as 3DChart or Table, the difference is in the way each
	// Chart's representation for the data.
	public static PiechartObserver po1;

	@BeforeAll
	public static void setUp() {
		// Stock Quote
		so = new StockQuoteObservable();
		po = new PiechartObserver(so);

		so.addStock("IBM", 199.12F);
		so.addStock("Google", 249.48F);
		so.addStock("Facebook", 341.21F);

		// DJJA
		djja = new DJJAQuoteObservable(0);
		po1 = new PiechartObserver(djja);
	}

	@Test
	public void testStocksAtBeginning() {
		assertTrue(so instanceof Observable);
		assertTrue(po instanceof Observer);
		assertTrue(djja instanceof Observable);
		assertTrue(po1 instanceof Observer);

	}

	@Test
	public void changeStockPriceGoolge() {
		float priceBeforeChange = 249.48F;
		assertEquals(priceBeforeChange, so.getMap().get("Google"));
		// change the price not adding more elements in HashMap
		assertEquals(so.getMap().size(), 3);

		so.changeQuote("Google", 241.00F);
		assertEquals(so.getMap().get("Google"), 241.00F);
		assertEquals(so.getMap().size(), 3);

		so.changeQuote("Google", 251.00F);
		assertEquals(so.getMap().get("Google"), 251.00F);
		assertEquals(so.getMap().size(), 3);

	}

	@Test
	public void changeStockPriceIBM() {
		float priceBeforeChange = 199.12F;
		assertEquals(priceBeforeChange, so.getMap().get("IBM"));
		assertEquals(so.getMap().size(), 3);

		so.changeQuote("IBM", 217.21F);
		assertEquals(so.getMap().get("IBM"), 217.21F);
		assertEquals(so.getMap().size(), 3);

	}

	@Test
	public void changeStockPriceFacebook() {
		float priceBeforeChange = 341.21F;
		assertEquals(priceBeforeChange, so.getMap().get("Facebook"));
		assertEquals(so.getMap().size(), 3);

		so.changeQuote("Facebook", 298.00F);
		assertEquals(so.getMap().get("Facebook"), 298.00F);
		assertEquals(so.getMap().size(), 3);

	}

	@Test
	public void changeDJJA() {
		float priceBeforeChange = 0F;
		assertEquals(priceBeforeChange, djja.getQuote());
		

		djja.changeQuote(298.00F);
		assertEquals(djja.getQuote(), 298.00F);

	}

}
