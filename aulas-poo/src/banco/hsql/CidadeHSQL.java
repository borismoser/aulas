package banco.hsql;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import cidades.Cidade;

public class CidadeHSQL {

	public static void main(String[] args) throws SQLException, IOException {

		dbMetaData();

		gerarCidades();
/*
		cidadesHabitantesUF();

		cidadesMaisPopulosasUF();

		cidadeMenosPopulosasUF();

		populacoesTotais();

		proporcaoMascFem();

		proporcaoFemMasc();
*/
//		listarCidades();

	}

	private static void dbMetaData() {
		try (Connection conn = ConexaoHSQL.conexao()) {
			DatabaseMetaData md = conn.getMetaData();
			System.out.println("Banco : " + md.getDatabaseProductName() + " " + md.getDatabaseProductVersion());
			System.out.println("Driver: " + md.getDriverName() + ". Versão: " + md.getDriverVersion());
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void proporcaoFemMasc() {
		System.out.println("\nPopulações feminina / masculina:");
		String sql = "select nome, uf estado, 1.00000*popfem/popmasc AS ratio from cidades order by ratio desc limit 10";
		try (JdbcRowSet rs = ConexaoHSQL.executarSQL(sql)) {
			while (rs.next()) {
				System.out.printf("%23s %1.5f %n", rs.getString("nome") + "/" + rs.getString("estado"),
						rs.getFloat("ratio"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void proporcaoMascFem() {
		System.out.println("\nPopulações masculina / feminina:");
		String sql = "select nome, uf, 1.00000*popmasc/popfem as ratio from cidades order by ratio desc limit 10";
		try (JdbcRowSet rs = ConexaoHSQL.executarSQL(sql)) {
			while (rs.next()) {
				System.out.printf("%25s %1.5f %n", rs.getString(1) + "/" + rs.getString(2), rs.getDouble("ratio"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void populacoesTotais() {
		System.out.println("\nPopulações totais:");
		String sql = "select sum(c.poptotal), sum(c.popmasc), sum(c.popfem) from cidades c";
		try (JdbcRowSet rs = ConexaoHSQL.executarSQL(sql)) {
			while (rs.next()) {
				System.out.printf("%,15d habitantes%n%,15d homens%n%,15d mulheres%n", rs.getInt(1), rs.getInt(2),
						rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void cidadeMenosPopulosasUF() {
		System.out.println("\nCidades menos populosas por UF:");
		String sql = "select a.uf, a.nome, a.poptotal from cidades a, "
				+ "(select min(poptotal) total, uf from cidades group by uf) b "
				+ "where a.uf=b.uf and a.poptotal=b.total order by 3 desc";
		try (JdbcRowSet rs = ConexaoHSQL.executarSQL(sql)) {
			while (rs.next()) {
				System.out.printf("%-26s: %,12d habitantes.%n", rs.getString(2) + "/" + rs.getString(1), rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void cidadesMaisPopulosasUF() {
		System.out.println("\nCidades mais populosas por UF:");
		String sql = "select a.uf, a.nome, a.poptotal from cidades a, "
				+ "(select max(poptotal) total, uf from cidades group by uf) b "
				+ "where a.uf=b.uf and a.poptotal=b.total order by 3 desc";
		try (JdbcRowSet rs = ConexaoHSQL.executarSQL(sql)) {
			while (rs.next()) {
				System.out.printf("%-18s: %,12d habitantes.%n", rs.getString(2) + "/" + rs.getString(1), rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void cidadesHabitantesUF() {
		System.out.println("UF  Cidades    Habitantes");
		System.out.println("--  -------    ----------");
		String sql = "select uf, count(nome), sum(poptotal) from cidades group by uf order by uf";
		try (JdbcRowSet rs = ConexaoHSQL.executarSQL(sql)) {
			while (rs.next()) {
				System.out.printf("%s %,8d  %,12d%n", rs.getString(1), rs.getInt(2), rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void listarCidades() {
		System.out.println("  Id UF Cidade                            Habitantes");
		System.out.println("---- -- ------                            ----------");
		String sql = "select * from cidades order by uf, nome";
		try (JdbcRowSet rs = ConexaoHSQL.executarSQL(sql)) {
			while (rs.next()) {
				System.out.printf("%4d %s %-30s  %,12d%n", rs.getInt("idcidade"), rs.getString("uf"),
						rs.getString("nome"), rs.getInt("poptotal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static List<Cidade> lerCidades() throws IOException {
		String csv = "./src/banco/população.CSV";
		List<Cidade> cidades = new ArrayList<>();
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(csv), StandardCharsets.ISO_8859_1)) {
			String linha = reader.readLine(); // ignorar cabeçalho
			while ((linha = reader.readLine()) != null) {
				String[] palavras = linha.split(";");
				cidades.add(new Cidade(palavras));
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		return cidades;
	}

	private static void gerarCidades() throws SQLException, IOException {

		String sql;
		try (Connection conn = ConexaoHSQL.conexao()) {

			Statement stmt = conn.createStatement();

			sql = "drop table if exists cidades";
			stmt.executeUpdate(sql);

			sql = "create table cidades (idcidade integer primary key, uf varchar(2), " + //
					"nome varchar(50), poptotal integer, popmasc integer, popfem integer)";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			throw e;
		}

		sql = "insert into cidades (idcidade, uf, nome, poptotal, popmasc, popfem) values (?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConexaoHSQL.conexao(); //
				PreparedStatement ps = conn.prepareStatement(sql)) {

			conn.setAutoCommit(false);
			List<Cidade> cidades;
			try {
				cidades = lerCidades();
				int i = 0;
				for (Cidade c : cidades) {
					ps.setInt(1, i++);
					ps.setString(2, c.getUf());
					ps.setString(3, c.getNome());
					ps.setInt(4, c.getPopTotal());
					ps.setInt(5, c.getPopMasc());
					ps.setInt(6, c.getPopFem());
					ps.execute();
				}
				conn.commit();

			} catch (SQLException e) {
				conn.rollback();
				throw e;
			} catch (IOException e) {
				throw e;
			} finally {
				conn.setAutoCommit(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
