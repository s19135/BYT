package a_Introductory;

class Fibonacci {
	int fib(int n) {
		switch (n) {
			case 0: return 0;
			case 1: return 1;
			default: return (fib(n - 1) + fib(n - 2)); // removed "+1" in formula
		}
	}
}
