package outros;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class DataHora {
	public static void main(String[] args) {

		dataLocal();

		horaLocal();

		dataHoraLocal();

		zonedDateTime();

		instantPeriodDuration();

		cronometro(100_000_000);

	}

	private static void instantPeriodDuration() {

		// Instant representa um momento no tempo, em UTC.

		Instant ins = Instant.now();
		System.out.println(ins);
		// Exibindo o Instant no timezone atual
		System.out.println(ins.atZone(ZonedDateTime.now().getZone()));
		System.out.println();

		// Period representa uma quantidade de tempo em termos de anos, meses e dias.

		LocalDate d1 = LocalDate.parse("2018-05-02");
		LocalDate d2 = LocalDate.parse("2019-11-21");

		long dias = Period.between(d1, d2).getDays();
		System.out.println("Quantidade de dias no período: " + d1 + " e " + d2 + ": " + dias);

		dias = ChronoUnit.DAYS.between(d1, d2);
		System.out.println("Dias transcorridos entre " + d1 + " e " + d2 + ": " + dias);
		System.out.println();

		// Duration representa uma quantidade de tempo
		// em termos de segundos e nanossegundos.

		LocalTime t1 = LocalTime.parse("18:30:40");
		LocalTime t2 = LocalTime.parse("21:49:55");

		long duracao = Duration.between(t1, t2).getSeconds();
		System.out.println("Quantidade de segundos no intervalo: " + t1 + " e " + t2 + ": " + duracao);

		duracao = ChronoUnit.SECONDS.between(t1, t2);
		System.out.println("Segundos transcorridos entre " + t1 + " e " + t2 + ": " + dias);
		System.out.println();

	}

	private static void zonedDateTime() {

		// TimeZone disponíveis
		Set<String> zids = ZoneId.getAvailableZoneIds();
		System.out.println(zids.size());
		System.out.println(zids);

		// Instanciando um timezone
		ZoneId asiaTokyo = ZoneId.of("Asia/Tokyo");
		System.out.println(asiaTokyo);

		// Obtendo a hora do Brasil em seu respectivo timezone
		ZonedDateTime brasil = ZonedDateTime.now();
		System.out.println("Brasil: " + brasil);

		// Obtendo a hora correspondente no fuso de Tóquio
		ZonedDateTime japao = ZonedDateTime.ofInstant(brasil.toInstant(), asiaTokyo);
		System.out.println("Japão : " + japao);
		// Outra forma
		japao = brasil.withZoneSameInstant(asiaTokyo);
		System.out.println("Japão : " + japao);
		System.out.println();

	}

	private static void dataHoraLocal() {

		// Combinação de data e hora
		LocalDateTime ldt;

		ldt = LocalDateTime.parse("2018-05-02T18:30");
		System.out.println(ldt);
		ldt = LocalDateTime.of(2018, 05, 02, 18, 30);
		System.out.println(ldt);

		ldt = LocalDateTime.now();
		System.out.println("Hoje/Agora: " + ldt);
		ldt = LocalDate.parse("2018-05-02").atStartOfDay();
		System.out.println("Início do dia: " + ldt);
		System.out.println("Fim do dia: " + ldt.plusDays(1).minusNanos(1));
		System.out.println(ldt);
		System.out.println();

	}

	private static void horaLocal() {

		// Hora sem data
		LocalTime lt;

		lt = LocalTime.parse("18:30:40");
		System.out.println(lt);
		lt = LocalTime.of(18, 30, 40);
		System.out.println(lt);
		System.out.println();

		lt = LocalTime.now();
		System.out.println("Agora: " + lt);
		System.out.println("Hora: " + lt.getHour());
		System.out.println("Minuto: " + lt.getMinute());
		System.out.println("Segundo: " + lt.getSecond());
		System.out.println("Nano: " + lt.getNano());
		System.out.println("Daqui a 3 horas: " + lt.plusHours(3));
		System.out.println("Daqui a 3,5 horas: " + lt.plusHours(3).plusMinutes(30));
		System.out.println("Maior hora: " + LocalTime.MAX);
		System.out.println("Menor hora: " + LocalTime.MIN);
		System.out.println("Meia-noite: " + LocalTime.MIDNIGHT);
		System.out.println("Meio-dia: " + LocalTime.NOON);
		System.out.println();
	}

	private static void dataLocal() {

		// Data no formato YYYY-MM-DD, sem fuso horário.
		LocalDate ld;

		ld = LocalDate.parse("2018-05-02");
		System.out.println(ld);
		ld = LocalDate.of(2018, 5, 2);
		System.out.println(ld);
		ld = LocalDate.of(2018, Month.MAY, 2);
		LocalDate.ofYearDay(2020, 1);
		System.out.println(ld);
		ld = LocalDate.now();
		System.out.println();

		System.out.println("Hoje: " + ld);
		System.out.println("Dia do mês: " + ld.getDayOfMonth());
		System.out.println("Dia do ano: " + ld.getDayOfYear());
		System.out.println("Dia da semana: " + ld.getDayOfWeek());
		System.out.println("Mês: " + ld.getMonthValue());
		System.out.println("Ano: " + ld.getYear());
		System.out.println("Este ano é bissexto? " + ld.isLeapYear());
		System.out.println("Amanhã: " + ld.plusDays(1));
		System.out.println("Mesmo dia, mês passado: " + ld.minusMonths(1));
		System.out.println("Mesmo dia, ano que vem: " + ld.plus(1, ChronoUnit.YEARS));
		boolean anterior = LocalDate.parse("2018-05-02").isBefore(LocalDate.parse("2016-01-01"));
		System.out.println("2018-05-02 é anterior a 2016-01-01? " + anterior);
		boolean posterior = LocalDate.parse("2018-05-02").isAfter(LocalDate.parse("2016-01-01"));
		System.out.println("2018-05-02 é posterior a 2016-01-01? " + posterior);
		ld = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("Primeiro dia do mês atual: " + ld);
		System.out.println();
	}

	private static void cronometro(int tamanho) {
		System.out.printf("Cronometrando a execução de um laço com %,d de repetições:%n", tamanho);
		System.out.println(Instant.now());
		Instant inicio = Instant.now();
		int[] x = new int[tamanho];
		for (int i = 0; i < tamanho; i++) {
			x[i] = i;
		}
		Instant fim = Instant.now();
		System.out.println(Instant.now());
		long duracao = Duration.between(inicio, fim).toMillis();
		System.out.printf("%,d milissegundos decorridos.%n%n", duracao);
	}
}
