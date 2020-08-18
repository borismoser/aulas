package outros;

import java.util.Arrays;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(isIPv4Address("64.233.161.00"));
		int[] arr = { 1, 2, 2 };
		//System.out.println(counter(arr, 3));
		//System.out.println(quasePalindromo("abccfg"));
		System.out.println(numMaisPopular(arr, arr.length));
	}

	private static int numMaisPopular(int[] numeros, int tamanho) {
		Arrays.sort(numeros);
		int num = numeros[0];
		int maior = 1, qt=1;
		for (int i=1; i<tamanho; i++) {
			if (numeros[i] == numeros[i-1]) {
				qt++;
				if (qt > maior) {
					num = numeros[i];
					maior = qt;
				}
			} else {
				qt = 1;
			}
		}
		return num;
	}
	
	private static boolean quasePalindromo(String palavra) {
		if (palavra == null || palavra.length() <= 1) {
			return true;
		}
		String p1, p2;
		p1 = palavra.substring(0, palavra.length() / 2);
		if (palavra.length() % 2 == 0) {
			p2 = palavra.substring(palavra.length() / 2);
		} else {
			p2 = palavra.substring((palavra.length() / 2)+1);
		}
		p2 = (new StringBuilder(p2)).reverse().toString();
		if (p1.equals(p2)) {
			return true;
		}
		int dif = 0;
		for (int i=0; i<p1.length(); i++) {
			if (p1.charAt(i) != p2.charAt(i)) {
				dif++;
				if (dif > 1) return false;
			}
		}
		return true;
	}
	
	private static double avgDistance(int x1, int y1, int x2, int y2, int x3, int y3) {
		int a = Math.abs(x1-x2);
		int b = Math.abs(y1-y2);
		double c = Math.sqrt(Math.pow(a, b));
		a = Math.abs(x1-x3);
		b = Math.abs(y1-y3);
		double d = Math.sqrt(Math.pow(a, b));
		a = Math.abs(x3-x2);
		b = Math.abs(y3-y2);
		double e = Math.sqrt(Math.pow(a, b));
		return (c+d+e)/3.0;
	}
	
	
	private static long counter(int[] elements, int key) {
		return Arrays.stream(elements).boxed().filter(e -> e.equals(key)).count();
	}
	
	private static int count(int[] elements, int key) {
		int x = 0;
		for (int n : elements) {
			if (n == key) {
				x++;
			}
		}
		return x;
	}
	
	private static boolean isIPv4Address(String inputString) {
	    String[] parts = inputString.split("\\.");
	    if (parts.length != 4) return false;
	    System.out.println(Arrays.toString(parts));
	    for (int i=0; i < 4; i++) {
	        if (parts[i].isEmpty()) return false;
	        try {
	            Integer.parseInt(parts[i]);
	        } catch (NumberFormatException e) {
	            return false;
	        }
	        if (Integer.valueOf(parts[i]) == 0) { 
	        	if (parts[i].length() > 1) return false;
	        }
	        if (Integer.valueOf(parts[i]) < 0 || Integer.valueOf(parts[i]) > 255) return false;
	    }
	    return true;
	}
}
