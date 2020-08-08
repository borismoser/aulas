package lista01;

public class Ex23 {

	public static void main(String[] args) {
		
		double areaVerde = 2100000.0;
		double txVerde = 1.1 / 100;
		double areaNegra = 1650000.0;
		double txNegra = 0.85 / 100;
		int anos = 0;
		
		while (areaVerde >= areaNegra) {
			//areaVerde = areaVerde - (areaVerde * txVerde);
			//areaNegra = areaNegra - (areaNegra * txNegra);
			areaVerde *= 1 - txVerde;
			areaNegra *= 1 - txNegra;
			anos++;
		}
		System.out.printf("Em %d anos a área da floresta Verde será menor que a área da floresta Negra.", anos);
	}

}
