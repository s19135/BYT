package b_Money;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	private Currency SEK, DKK, NOK, EUR;
	private Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		Assert.assertEquals(10000,SEK100.getAmount(),0.0001);
		Assert.assertEquals(1000,EUR10.getAmount(),0.0001);
	}

	@Test
	public void testGetCurrency() {
		Assert.assertEquals(SEK,SEK100.getCurrency());
		Assert.assertEquals(EUR,EUR10.getCurrency());
	}

	@Test
	public void testToString() {
		Assert.assertEquals("Amount: 100.0, in currency: [SEK].", SEK100.toString());
		Assert.assertEquals("Amount: 10.0, in currency: [EUR].", EUR10.toString());

	}

	@Test
	public void testGlobalValue() {
		Assert.assertEquals(SEK.universalValue(10000), SEK100.universalValue());
		Assert.assertEquals(EUR.universalValue(1000), EUR10.universalValue());
	}

	@Test
	public void testEqualsMoney() {
		Assert.assertTrue(SEK100.equals(EUR10));
		Assert.assertFalse(SEK100.equals(SEK200));
	}

	@Test
	public void testAdd() {
		Assert.assertEquals(new Money(20000,SEK),SEK100.add(EUR10));
		Assert.assertEquals(new Money(3000,EUR),EUR10.add(EUR20));
	}

	@Test
	public void testSub() {
		Assert.assertEquals(new Money(10000,SEK),SEK200.sub(SEK100));
		Assert.assertEquals(new Money(1000,EUR),EUR20.sub(EUR10));
	}

	@Test
	public void testIsZero() {
		Assert.assertTrue(new Money(0,SEK).isZero());
		Assert.assertTrue(new Money(0,EUR).isZero());
	}

	@Test
	public void testNegate() {
		Assert.assertEquals(new Money(-10000,SEK),SEK100.negate());
		Assert.assertEquals(new Money(-1000,EUR),EUR10.negate());
	}

	@Test
	public void testCompareTo() {
		Assert.assertTrue(EUR20.compareTo(SEK100) > 0);
		Assert.assertTrue(SEK100.compareTo(EUR20) < 0);
		Assert.assertEquals(0, SEK200.compareTo(EUR20));
		Assert.assertEquals(0, SEK0.compareTo(EUR0));
	}
}
