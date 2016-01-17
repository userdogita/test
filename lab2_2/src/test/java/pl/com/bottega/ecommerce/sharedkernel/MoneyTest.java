package pl.com.bottega.ecommerce.sharedkernel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {

	Money money1;
	Money money11;
	Money money2;
	String money2_S;
	Money money_sum;
	BigDecimal mul;
	Money money_mul;
	Currency currency1;
	Currency currency2;
	Money money2_US;

	@Before
	public void setUp() throws Exception {
		currency1 = Currency.getInstance("EUR");
		currency2 = Currency.getInstance(Locale.UK);
		money1 = new Money(new BigDecimal("9.99"), currency1);
		money11 = new Money(new BigDecimal("9.99"), currency1);
		money2 = new Money(new BigDecimal("10.01"), currency1);
		money2_S = new String("10,01 EUR");
		money2_US = new Money(new BigDecimal("10.01"), currency2);
		money_sum = new Money(new BigDecimal("20.00"), currency1);
		mul = new BigDecimal("2.00");
		money_mul = new Money(new BigDecimal("19.98"), currency1);
	}

	@Test
	public final void testAdd() {
		assertEquals(money_sum, money1.add(money2));
	}

	@Test
	public final void testMul() {
		assertEquals(money_mul, money1.multiplyBy(mul));
	}

	@Test(expected = IllegalArgumentException.class)
	public final void testForIllegalArgumentException() {
		money1.add(money2_US);
	}

	@Test
	public final void testToString() {
		assertEquals(money2_S, money2.toString());
	}

	@Test
	public final void testToStringDiffCurrency() {
		assertNotEquals(money2_S, money2_US.toString());
	}

	@Test
	public final void testLessThan() {
		assertTrue(money1.lessThan(money2));
		assertFalse(money_sum.lessThan(money2));
		assertFalse(money1.lessThan(money1));
	}

	@Test
	public final void testLessOrEquals() {
		assertTrue(money1.lessOrEquals(money2));
		assertTrue(money1.lessOrEquals(money1));
		assertFalse(money_sum.lessOrEquals(money2));
	}

	@Test
	public final void testGreatherThan() {
		assertFalse(money1.greaterThan(money2));
		assertTrue(money_sum.greaterThan(money2));
		assertFalse(money1.greaterThan(money1));
	}

	@Test
	public void testEquals() {
		assertTrue(money1.equals(money11));
		assertFalse(money1.equals(money2));
		assertFalse(money2.equals(money2_US));
	}

	@Test
	public void testEqualsDiffClass() {
		assertFalse(money1.equals(new Object()));
	}

	@Test
	public void testEqualsTheSameObject() {
		assertTrue(money1.equals(money1));
	}

	@Test
	public void testEqualsNull() {
		assertFalse(money1.equals(null));
	}

}
