package b_Money;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
	private Currency SEK, DKK;
	private Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		Assert.assertEquals("SweBank", SweBank.getName());
		Assert.assertEquals("Nordea", Nordea.getName());
	}

	@Test
	public void testGetCurrency() {
		Assert.assertEquals(DKK, DanskeBank.getCurrency());
		Assert.assertEquals(SEK, Nordea.getCurrency());
	}


	@Test
	public void testOpenAccount() throws AccountDoesNotExistException, AccountExistsException {
		Nordea.openAccount("Denys");
		Nordea.deposit("Denys", new Money(12345, SEK));
		Assert.assertEquals(12345, (int)Nordea.getBalance("Denys"));
		try {
			Nordea.openAccount("Bob");
		} catch (AccountExistsException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(12345, SEK));
		Assert.assertEquals(12345, (int) SweBank.getBalance("Ulrika"));

		Nordea.deposit("Bob", new Money(12345, SEK));
		Assert.assertEquals(12345, (int) Nordea.getBalance("Bob"));
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(12345, SEK));
		SweBank.withdraw("Ulrika", new Money(345, SEK));
		Assert.assertEquals(12345 - 345, (int) SweBank.getBalance("Ulrika"));

		Nordea.deposit("Bob", new Money(12345, SEK));
		Nordea.withdraw("Bob", new Money(345, SEK));
		Assert.assertEquals(12345 - 345, (int) Nordea.getBalance("Bob"));
	}

	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(12345, SEK));
		Assert.assertEquals(12345, (int) SweBank.getBalance("Ulrika"));

		Nordea.deposit("Bob", new Money(12345, SEK));
		Assert.assertEquals(12345, (int) Nordea.getBalance("Bob"));
	}

	@Test
	public void testTransfer() throws AccountDoesNotExistException, AccountExistsException {
		Nordea.deposit("Bob", new Money(12345, SEK));
		Nordea.openAccount("Denys");
		Nordea.transfer("Bob", "Denys", new Money(345, SEK));
		Assert.assertEquals(12000, (int) Nordea.getBalance("Bob"));
		Assert.assertEquals(345, (int) Nordea.getBalance("Denys"));
		Nordea.deposit("Bob", new Money(345, SEK));
		Nordea.transfer("Bob", SweBank, "Ulrika", new Money(345, SEK));
		Assert.assertEquals(12000, (int) Nordea.getBalance("Bob"));
		Assert.assertEquals(345, (int) SweBank.getBalance("Ulrika"));
	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(12345, SEK));
		SweBank.addTimedPayment("Ulrika", "pay3", 55, 0, new Money(345, SEK), Nordea, "Bob");
		SweBank.tick();
		Assert.assertEquals(new Money(12000, SEK).getAmount(), SweBank.getBalance("Ulrika"));
		Assert.assertEquals(new Money(345, SEK).getAmount(), Nordea.getBalance("Bob"));
	}
}
