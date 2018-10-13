import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GipfelTest {

	@Test
	public void testSome() {
		int[] hs = new int[] {2, 1, 2, 5, 4, 3, 4, 6, 5, 6};
		assertEquals(2, Gipfel.findeGroessteErhebung(hs));
		
		hs = new int[] {2, 1, 2, 5, 4, 3, 6, 5, 6};
		assertEquals(2, Gipfel.findeGroessteErhebung(hs));
		
		// Gipfel hat keine linke Talsohle, d.h. keine Erhebung
		hs = new int[] { 1, 7, 1, 3 };
		assertEquals(0, Gipfel.findeGroessteErhebung(hs));
		
		hs = new int[] { 4, 3, 7, 5, 2, 3 };
		assertEquals(4, Gipfel.findeGroessteErhebung(hs));
		
		// TODO: mehr Tests schreiben!
	}
	
}
