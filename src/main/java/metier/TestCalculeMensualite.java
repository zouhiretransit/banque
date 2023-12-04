package metier;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalculeMensualite {
	private ICreditMetier metier;

	@Before
	public void setUp() throws Exception {
		metier=new CreditMetierImp();
	}

	@Test
	public void testCalculerMensualitéCredit() {
		double capital=200000;
		int duree=240;
		double taux=4.5;
		double resultatAttendu= 1265.2987;
		double resCalcule=metier.calculerMensualitéCredit(capital, taux, duree);
		assertEquals(resultatAttendu, resCalcule, 0.0001);
	}

}
