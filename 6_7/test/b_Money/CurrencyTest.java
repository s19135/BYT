package b_Money;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		Assert.assertEquals("SEK",SEK.getName());
		Assert.assertEquals("DKK",DKK.getName());
		Assert.assertEquals("EUR",EUR.getName());
	}
	
	@Test
	public void testGetRate() {
		Assert.assertEquals(0.15,SEK.getRate(),0.0001);
	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(0.16);
		DKK.setRate(0.21);
		Assert.assertNotEquals(0.15,SEK.getRate(),0.0001);
		Assert.assertEquals(0.16,SEK.getRate(),0.0001);
		Assert.assertNotEquals(0.20,DKK.getRate(),0.0001);
		Assert.assertEquals(0.21,DKK.getRate(),0.0001);
	}
	
	@Test
	public void testGlobalValue() {
		Assert.assertEquals((int)(12345*SEK.getRate()), (int)SEK.universalValue(12345));
		Assert.assertEquals((int)(12345*DKK.getRate()), (int)DKK.universalValue(12345));
	}
	
	@Test
	public void testValueInThisCurrency() {
		Assert.assertEquals(123450, (int) SEK.valueInThisCurrency(12345, EUR));
		Assert.assertEquals(92587, (int) DKK.valueInThisCurrency(12345, EUR));
	}
}
