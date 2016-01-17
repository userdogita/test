package pl.com.bottega.ecommerce.sales.domain.productscatalog;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class ProductDataTest {

	String name1;
	String name2;
	Id id1;
	Id id2;
	Date date1;
	Money money1;
	Money money2;

	@Before
	public void setUp() throws Exception {
		name1 = "Prod1";
		name2 = "Prod2";
		id1 = Id.generate();
		id2 = Id.generate();
		date1 = new java.util.Date();
		money1 = new Money(9.99);
		money1 = new Money(99.99);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDiffNames() {
		ProductData productData1 = new ProductData(id1, money1, name1,
				ProductType.STANDARD, date1);
		ProductData productData2 = new ProductData(id1, money1, name2,
				ProductType.STANDARD, date1);

		assertFalse(productData1.equals(productData2));
	}

	@Test
	public void testDiffId() {
		ProductData productData1 = new ProductData(id1, money1, name1,
				ProductType.STANDARD, date1);
		ProductData productData2 = new ProductData(id2, money1, name1,
				ProductType.STANDARD, date1);

		assertFalse(productData1.equals(productData2));
	}

	@Test
	public void testDiffMoney() {
		ProductData productData1 = new ProductData(id1, money1, name1,
				ProductType.STANDARD, date1);
		ProductData productData2 = new ProductData(id1, money2, name1,
				ProductType.STANDARD, date1);

		assertFalse(productData1.equals(productData2));
	}

	@Test
	public void testTheSameAttributes() {
		ProductData productData1 = new ProductData(id1, money1, name1,
				ProductType.STANDARD, date1);
		ProductData productData2 = new ProductData(id1, money1, name1,
				ProductType.STANDARD, date1);

		assertTrue(productData1.equals(productData2));
	}

	@Test
	public void testDiffClass() {
		ProductData productData1 = new ProductData(Id.generate(), money1,
				name1, ProductType.STANDARD, date1);
		Object productData2 = new Object();

		assertFalse(productData1.equals(productData2));
	}

	@Test
	public void testTheSameObject() {
		ProductData productData1 = new ProductData(id1, money1, name1,
				ProductType.STANDARD, date1);

		assertTrue(productData1.equals(productData1));
	}

	@Test
	public final void testNullObject() {
		ProductData productData1 = new ProductData(id1, money1, name1,
				ProductType.STANDARD, date1);

		assertFalse(productData1.equals(null));
	}
}
