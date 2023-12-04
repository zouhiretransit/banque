package metier;

public class CreditMetierImp implements ICreditMetier {

	@Override
	public double calculerMensualitéCredit(double capital, double taux, int duree) {
		double t=taux/100;
		double t1=capital*t/12;
		double t2=1-Math.pow(1+t/12, -duree);
		return t1/t2;
	}
	

}
