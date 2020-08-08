package lista01;

public class Ex18 {

	public static void main(String[] args) {
		for (int i = 1; i <= 30; i++) {
			System.out.printf("% ,26d (%d!)%n", fat(i), i);
			if (i == 20) {
				System.out.printf("% ,26d (máx)%n", Long.MAX_VALUE);
			}
		}
	}

	private static long fat(int n) {
		long f = 1L;
		for (; n > 1; n--) {
			f *= n;
		}
		return f;
	}

}
