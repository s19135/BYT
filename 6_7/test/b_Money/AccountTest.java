package b_Money;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));
		SweBank.deposit("Alice", new Money(1000000, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		testAccount.addTimedPayment("pay1", 55, 55, new Money(12345, SEK), SweBank, "Alice");
		Assert.assertTrue(testAccount.timedPaymentExists("pay1"));
		testAccount.removeTimedPayment("pay1");
		assertFalse(testAccount.timedPaymentExists("pay1"));
	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("pay2", 55, 0, new Money(12345, SEK), SweBank, "Alice");
		Assert.assertTrue(testAccount.timedPaymentExists("pay2"));
		testAccount.tick();
		Assert.assertEquals(new Money(10000000 - 12345, SEK), testAccount.getBalance());
		Assert.assertEquals(new Money(1000000 + 12345, SEK).getAmount(), SweBank.getBalance("Alice"));
		testAccount.removeTimedPayment("pay2");
		Assert.assertFalse(testAccount.timedPaymentExists("pay2"));
	}

	@Test
	public void testAddWithdraw() {
		testAccount.withdraw(new Money(12345, SEK));
		Assert.assertEquals(new Money(10000000 - 12345, SEK), testAccount.getBalance());
	}

	@Test
	public void testGetBalance() {
		assertEquals(new Money(10000000, SEK), testAccount.getBalance());
	}
}
