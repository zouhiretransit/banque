package metier;

public class TestMetier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreditMetierImp cr1=new CreditMetierImp();
		double capital=200000;
		int duree=240;
		double taux=4.5;
		double m=cr1.calculerMensualitéCredit(capital, taux, duree);
		System.out.println(m);
		

	}

}
