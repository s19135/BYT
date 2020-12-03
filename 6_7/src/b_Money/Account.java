package b_Money;

import java.util.Hashtable;

public class Account {
	private Money content;
	private Hashtable<String, TimedPayment> timedpayments = new Hashtable<String, TimedPayment>();

	Account(String name, Currency currency) {
		this.content = new Money(0, currency);
	}

	/**
	 * Add a timed payment
	 * @param id Id of timed payment
	 * @param interval Number of ticks between payments
	 * @param next Number of ticks till first payment
	 * @param amount Amount of Money to transfer each payment
	 * @param toBank Bank where receiving account resides
	 * @param toAccount Id of receiving account
	 */
	public void addTimedPayment(String id, Integer interval, Integer next, Money amount, Bank toBank, String toAccount) {
		TimedPayment tp = new TimedPayment(interval, next, amount, this, toBank, toAccount);
		timedpayments.put(id, tp);
	}
	
	/**
	 * Remove a timed payment
	 * @param id Id of timed payment to remove
	 */
	public void removeTimedPayment(String id) {
		timedpayments.remove(id);
	}
	
	/**
	 * Check if a timed payment exists
	 * @param id Id of timed payment to check for
	 */
	public boolean timedPaymentExists(String id) {
		return timedpayments.containsKey(id);
	}

	/**
	 * A time unit passes in the system
	 */
	public void tick() {
		for (TimedPayment tp : timedpayments.values()) {
			tp.tick(); // removed second tick
		}
	}
	
	/**
	 * Deposit money to the account
	 * @param money Money to deposit.
	 */
	public void deposit(Money money) {
		content = content.add(money);
	}
	
	/**
	 * Withdraw money from the account
	 * @param money Money to withdraw.
	 */
	public void withdraw(Money money) {
		content = content.sub(money);
	}

	/**
	 * Get balance of account
	 * @return Amount of Money currently on account
	 */
	public Money getBalance() {
		return content;
	}

	/* Everything below belongs to the private inner class, TimedPayment */
	private class TimedPayment {
		private int interval, next;
		private Account fromAccount;
		private Money amount;
		private Bank toBank;
		private String toAccount;
		
		TimedPayment(Integer interval, Integer next, Money amount, Account fromAccount, Bank toBank, String toAccount) {
			this.interval = interval;
			this.next = next;
			this.amount = amount;
			this.fromAccount = fromAccount;
			this.toBank = toBank;
			this.toAccount = toAccount;
		}

		public Boolean tick() {
			if (next == 0) {
				next = interval;

				fromAccount.withdraw(amount);
				try {
					toBank.deposit(toAccount, amount);
				}
				catch (AccountDoesNotExistException e) {
					fromAccount.deposit(amount);
				}
				return true;
			}
			else {
				next--;
				return false;
			}
		}
	}
}
