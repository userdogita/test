package pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class IdTest {

	Id id_null;
	Id id1;
	Id id1_copy ;
	Id id2;
	Object id3;
	Id id4;
	
	@Before
	public void setUp() throws Exception {
		id_null = null;
		id1 = Id.generate();
		id1_copy = id1;
		id2 = Id.generate();
		id3 = new Object();
		id4 = new Id(id1.getId());
		
	}


	@Test
	public final void testTheSameObject() {
		assertTrue(id1.equals(id1_copy));
	}
	
	@Test
	public final void testNullObject() {
		assertFalse(id1.equals(id_null));
	}
	
	@Test
	public final void testDiffClass() {
		assertFalse(id1.equals(id3));
	}
	
	@Test
	public final void testDiffId() {
		assertFalse(id1.equals(id2));
	}
	
	@Test
	public final void testDiffObiectTheSameId() {
		assertTrue(id1.equals(id4));
	}
	
	

}
