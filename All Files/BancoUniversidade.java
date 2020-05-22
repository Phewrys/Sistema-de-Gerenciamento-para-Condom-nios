package banco_universidade;

import java.sql.*;
import com.sun.java_cup.internal.runtime.Symbol;
import java.util.Scanner;

public class BancoUniversidade {

	public static Connection conexao = null;
	
	public BancoUniversidade() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public Connection setConnection() throws SQLException {
		String host = "10.27.159.214:5432";
		String database = "bd_aula";
		String url = "jdbc:postgresql://" + host + "/" + database;
		String user = "aluno1";
		String password = "aluno1";
		conexao = DriverManager.getConnection(url, user, password);
		return conexao;
	}

public static void main(String[] args) throws SQLException {		
		Scanner entrada = new Scanner(System.in);
		BancoUniversidade teste = new BancoUniversidade();
		teste.setConnection();
		int opcao = 0;
		
		System.out.println("--------------------------------- CONDOMINIO ----------------------------------------");
		System.out.println("| - Digite o número da consulta desejada e em seguida pressione [Enter]             |");
		System.out.println("|	                                                                                |");
		System.out.println("| [01] - Listar a quantidade de funcionarios por cargo.                             |");
		System.out.println("| [02] - Informe a soma, média, mínimo e máximo salário de funcionario.             |");
		System.out.println("| [03] - Listar nome, cargo e bairro dos funcionarios que são porteiros.            |");
		System.out.println("| [04] - Listar nome e sobrenome de todos os moradores que tem o sobrenome iniciado |");
		System.out.println("|        com a letra S.                                                             |");
		System.out.println("| [05] - Relacione as tabelas pessoa e morador com o comando using no atributo cpf. |");
		System.out.println("| [06] - Liste o nome e sobrenome de todas as pessoas que são funcinarios.          |");
		System.out.println("| [07] - Listar nome e sobrenome das pessoas que naceram depois de 01/01/1980.      |");
		System.out.println("|        Ordenado de forma crescente.                                               |");
		System.out.println("| [08] - Liste os salários dos funcionarios que possuem salário maior que R$1.000.  |");
		System.out.println("| [09] - Listar nome e sobrenome das pessoas que naceram entre 01/01/1970 e         |");
		System.out.println("|        01/01/1980.                                                                |");
		System.out.println("| [10] - Liste o CPF e o nome de todos os funcionários separados por " - ".         |");
		System.out.println("| [11] - Informe a quantidade de funcionarios que recebem salário menor que R$1.000.|");
		System.out.println("| [12] - Liste o nome de todos os moradores que moram no bloco 1.                   |");
		System.out.println("| [13] - Liste o nome de todos os funcionarios em que o primeiro nome contém exata- |");
		System.out.println("|        mente 7 caracteres.                                                        |");
		System.out.println("| [14] - Liste o nome e sobrenome de todos os moradores do bloco 4, apartamento 10. |");
		System.out.println("| [15] - Liste o nome de todos os funcionarios que são zeladores.                   |");
		System.out.println("|                                                                                   |");
		System.out.println("|            -  Para fechar o programa digite 0 e pressione [Enter] -               |");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println();
		System.out.print (" Número da consulta: ");
		opcao= entrada.nextInt();
		
		while (opcao != 0){
			switch( opcao )
			{
			    case 1:
			    		teste.consulta1(conexao);
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    case 2:
			    		teste.consulta2(conexao);
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    case 3:
			    		teste.consulta3(conexao); 
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    case 4:
			    		teste.consulta4(conexao);
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    case 5:
			    		teste.consulta5(conexao);
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    case 6:
			    		teste.consulta6(conexao);
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    case 7:
			    		teste.consulta7(conexao);
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    case 8:
			    		teste.consulta8(conexao); 
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    case 9:
			    		teste.consulta9(conexao);
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    case 10:
			    		teste.consulta10(conexao);
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    case 11:
			    		teste.consulta11(conexao);
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    case 12:
			    		teste.consulta12(conexao);
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    case 13:
			    		teste.consulta13(conexao);
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    case 14:
			    		teste.consulta14(conexao);
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    case 15:
			    		teste.consulta15(conexao);
			    		System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			    default:
			            System.out.println("Erro! Consulta Inválida");
			            System.out.print (" Digite o número da consulta: ");
			    		opcao= entrada.nextInt();
			            break;
			}

		}
		System.out.println("Programa Finalizado com sucesso!");
	}

    public void consulta1(Connection conexao) throws SQLException {
		String sql = "SELECT count(cpf), cargo "
				   + "FROM universidade.funcionario GROUP BY cargo";
		Statement comando = conexao.createStatement();
		System.out.println("--------------------------- Consulta 1 ----------------------------------");		
        ResultSet resultado = comando.executeQuery(sql);
		ResultSetMetaData rsm = resultado.getMetaData();
		for (int i = 1; i <= rsm.getColumnCount(); i++) {
			System.out.print(rsm.getColumnName(i) + "\t\t");
		}
		System.out.println();
		
		while (resultado.next()) {
			for (int i = 1; i <= rsm.getColumnCount(); i++) {
				String campo = resultado.getString(i);
				System.out.print(campo + "\t\t\t");
			}
			System.out.println();
		}
		comando.close();
	}

    public void consulta2(Connection conexao) throws SQLException {
	    String sql =  "SELECT sum(f.salario), avg(f.salario), min(f.salario), max(f.salario)\r\n" + 
			    "FROM universidade.pessoa AS p INNER JOIN universidade.funcionario AS f \r\n" + 
			    "	ON(p.cpf=f.cpf)";
	    Statement comando = conexao.createStatement();
	    System.out.println("--------------------------- Consulta 2 ----------------------------------");
	    ResultSet resultado = comando.executeQuery(sql);
	    ResultSetMetaData rsm = resultado.getMetaData();
	    for (int i = 1; i <= rsm.getColumnCount(); i++) {
		    System.out.print(rsm.getColumnName(i) + "\t\t");
	    }
	    
	    System.out.println();
	    
	    while (resultado.next()) {
		    for (int i = 1; i <= rsm.getColumnCount(); i++) {
			    String campo = resultado.getString(i);
			    System.out.print(campo + "\t\t\t");
		    }
		    System.out.println();
	    }
	    comando.close();
    }

	public void consulta3(Connection conexao) throws SQLException {
		String sql = "SELECT p.primeiro_nome, f.cargo, f.bairro\r\n" + 
				"FROM universidade.funcionario AS f NATURAL JOIN universidade.pessoa AS p\r\n" + 
				"WHERE f.cargo = 'PORTEIRO'";
		Statement comando = conexao.createStatement();
		System.out.println("--------------------------- Consulta 3 ----------------------------------");		
		ResultSet resultado = comando.executeQuery(sql);
		ResultSetMetaData rsm = resultado.getMetaData();
		for (int i = 1; i <= rsm.getColumnCount(); i++) {
			System.out.print(rsm.getColumnName(i) + "\t\t");
		}
		
		System.out.println();
		
		while (resultado.next()) {
			for (int i = 1; i <= rsm.getColumnCount(); i++) {
				String campo = resultado.getString(i);
				System.out.print(campo + "\t\t\t");
			}
			System.out.println();
		}
		comando.close();
	}

	public void consulta4(Connection conexao) throws SQLException {
		String sql = "SELECT p.primeiro_nome, p.sobrenome\r\n" + 
				"FROM universidade.pessoa AS p INNER JOIN universidade.morador AS m\r\n" + 
				"ON (p.cpf=m.cpf) WHERE p.sobrenome LIKE 'S%'";
		Statement comando = conexao.createStatement();
		System.out.println("--------------------------- Consulta 4 ----------------------------------");		
		ResultSet resultado = comando.executeQuery(sql);
		ResultSetMetaData rsm = resultado.getMetaData();
		for (int i = 1; i <= rsm.getColumnCount(); i++) {
			System.out.print(rsm.getColumnName(i) + "\t\t");
		}
		
		System.out.println();
		
		while (resultado.next()) {
			for (int i = 1; i <= rsm.getColumnCount(); i++) {
				String campo = resultado.getString(i);
				System.out.print(campo + "\t\t\t");
			}
			System.out.println();
		}
		comando.close();
	}

    public void consulta5(Connection conexao) throws SQLException {
		String sql = "SELECT * "
				   + "FROM universidade.pessoa JOIN universidade.morador using (cpf)";
		Statement comando = conexao.createStatement();
		System.out.println("--------------------------- Consulta 5 ----------------------------------");		
        ResultSet resultado = comando.executeQuery(sql);
		ResultSetMetaData rsm = resultado.getMetaData();
		for (int i = 1; i <= rsm.getColumnCount(); i++) {
			System.out.print(rsm.getColumnName(i) + "\t\t");
		}
		System.out.println();
		
		while (resultado.next()) {
			for (int i = 1; i <= rsm.getColumnCount(); i++) {
				String campo = resultado.getString(i);
				System.out.print(campo + "\t\t\t");
			}
			System.out.println();
		}
		comando.close();
	}

	public void consulta6(Connection conexao) throws SQLException {
		String sql = "SELECT p.primeiro_nome, p.sobrenome\r\n" + 
				"FROM universidade.pessoa AS p RIGHT OUTER JOIN universidade.funcionario AS f\r\n" + 
				"ON (p.cpf = f.cpf)";
		Statement comando = conexao.createStatement();
		System.out.println("--------------------------- Consulta 6 ----------------------------------");		
		ResultSet resultado = comando.executeQuery(sql);
		ResultSetMetaData rsm = resultado.getMetaData();
		for (int i = 1; i <= rsm.getColumnCount(); i++) {
			System.out.print(rsm.getColumnName(i) + "\t\t");
		}
		
		System.out.println();
		
		while (resultado.next()) {
			for (int i = 1; i <= rsm.getColumnCount(); i++) {
				String campo = resultado.getString(i);
				System.out.print(campo + "\t\t\t");
			}
			System.out.println();
		}
		comando.close();
	}

	public void consulta7(Connection conexao) throws SQLException {
		String sql = "SELECT p.primeiro_nome, p.sobrenome\r\n" + 
				"FROM universidade.pessoa AS p WHERE p.data_nascimento > '01-01-1980'\r\n" + 
				"ORDER BY p.primeiro_nome ASC";
		Statement comando = conexao.createStatement();
		System.out.println("--------------------------- Consulta 7 ----------------------------------");		
		ResultSet resultado = comando.executeQuery(sql);
		ResultSetMetaData rsm = resultado.getMetaData();
		for (int i = 1; i <= rsm.getColumnCount(); i++) {
			System.out.print(rsm.getColumnName(i) + "\t\t");
		}
		
		System.out.println();
		
		while (resultado.next()) {
			for (int i = 1; i <= rsm.getColumnCount(); i++) {
				String campo = resultado.getString(i);
				System.out.print(campo + "\t\t\t");
			}
			System.out.println();
		}
		comando.close();
	}

	public void consulta8(Connection conexao) throws SQLException {
		String sql = "SELECT f.salario\r\n" + 
				"FROM universidade.funcionario AS f GROUP BY f.salario\r\n" + 
				"HAVING f.salario > 1000";
		Statement comando = conexao.createStatement();
		System.out.println("--------------------------- Consulta 8 ----------------------------------");		
		ResultSet resultado = comando.executeQuery(sql);
		ResultSetMetaData rsm = resultado.getMetaData();
		for (int i = 1; i <= rsm.getColumnCount(); i++) {
			System.out.print(rsm.getColumnName(i) + "\t\t");
		}
		
		System.out.println();
		
		while (resultado.next()) {
			for (int i = 1; i <= rsm.getColumnCount(); i++) {
				String campo = resultado.getString(i);
				System.out.print(campo + "\t\t\t");
			}
			System.out.println();
		}
		comando.close();
	}

	public void consulta9(Connection conexao) throws SQLException {
		String sql = "SELECT p.primeiro_nome, p.sobrenome\r\n" + 
				"FROM universidade.pessoa AS p\r\n" + 
				"WHERE data_nascimento BETWEEN '01-01-1970' AND '01-01-1980'";
		Statement comando = conexao.createStatement();
		System.out.println("--------------------------- Consulta 9 ----------------------------------");		
		ResultSet resultado = comando.executeQuery(sql);
		ResultSetMetaData rsm = resultado.getMetaData();
		for (int i = 1; i <= rsm.getColumnCount(); i++) {
			System.out.print(rsm.getColumnName(i) + "\t\t");
		}
		
		System.out.println();
		
		while (resultado.next()) {
			for (int i = 1; i <= rsm.getColumnCount(); i++) {
				String campo = resultado.getString(i);
				System.out.print(campo + "\t\t\t");
			}
			System.out.println();
		}
		comando.close();
	}

	public void consulta10(Connection conexao) throws SQLException {
		String sql = "SELECT f.cpf || '-' || p.primeiro_nome\r\n" + 
				"universidade.pessoa AS p\r\n" + 
				"JOIN universidade.funcionario AS f ON (p.cpf = f.cpf)";
		Statement comando = conexao.createStatement();
		System.out.println("--------------------------- Consulta 10 ----------------------------------");		
		ResultSet resultado = comando.executeQuery(sql);
		ResultSetMetaData rsm = resultado.getMetaData();
		for (int i = 1; i <= rsm.getColumnCount(); i++) {
			System.out.print(rsm.getColumnName(i) + "\t\t");
		}
		
		System.out.println();
		
		while (resultado.next()) {
			for (int i = 1; i <= rsm.getColumnCount(); i++) {
				String campo = resultado.getString(i);
				System.out.print(campo + "\t\t\t");
			}
			System.out.println();
		}
		comando.close();
	}

	public void consulta11(Connection conexao) throws SQLException {
		String sql = "SELECT count(p.cpf)\r\n" + 
			    "FROM universidade.pessoa AS p INNER JOIN universidade.funcionario AS f\r\n" + 
			    "ON (p.cpf = f.cpf) WHERE p.cpf IN \r\n" + 
			    "      (SELECT cpf\r\n" + 
			    "       FROM universidade.funcionario AS f\r\n" + 
			    "       WHERE f.salario < 1000)";
		Statement comando = conexao.createStatement();
		System.out.println("--------------------------- Consulta 11 ----------------------------------");		
		ResultSet resultado = comando.executeQuery(sql);
		ResultSetMetaData rsm = resultado.getMetaData();
		for (int i = 1; i <= rsm.getColumnCount(); i++) {
			System.out.print(rsm.getColumnName(i) + "\t\t");
		}
		
		System.out.println();
		
		while (resultado.next()) {
			for (int i = 1; i <= rsm.getColumnCount(); i++) {
				String campo = resultado.getString(i);
				System.out.print(campo + "\t\t\t");
			}
			System.out.println();
		}
		comando.close();
	}

    public void consulta12(Connection conexao) throws SQLException {
	    String sql = "SELECT p.primeiro_nome\r\n" + 
			    "FROM universidade.pessoa AS p INNER JOIN universidade.morador AS m\r\n" + 
			    "ON (p.cpf = m.cpf) WHERE p.cpf IN \r\n" + 
			    "      (SELECT cpf\r\n" + 
			    "       FROM universidade.morador AS m\r\n" + 
			    "       WHERE m.numero_do_bloco = 1)";
	    Statement comando = conexao.createStatement();
	    System.out.println("--------------------------- Consulta 12 ----------------------------------");	
	    ResultSet resultado = comando.executeQuery(sql);
	    ResultSetMetaData rsm = resultado.getMetaData();
	    for (int i = 1; i <= rsm.getColumnCount(); i++) {
		    System.out.print(rsm.getColumnName(i) + "\t\t");
	    }
	    
	    System.out.println();
	    
	    while (resultado.next()) {
		    for (int i = 1; i <= rsm.getColumnCount(); i++) {
			    String campo = resultado.getString(i);
			    System.out.print(campo + "\t\t\t");
		    }
		    System.out.println();
	    }
	    comando.close();
    }

    public void consulta13(Connection conexao) throws SQLException {
	    String sql = "SELECT p.primeiro_nome\r\n" + 
			    "FROM universidade.pessoa AS p INNER JOIN universidade.funcionario AS f\r\n" + 
			    "ON (p.cpf = f.cpf) WHERE p.cpf IN \r\n" + 
			    "      (SELECT cpf \r\n" + 
			    "       FROM universidade.pessoa AS p NATURAL JOIN universidade.funcionario AS f\r\n" + 
			    "       WHERE CHAR_LENGTH(p.primeiro_nome) = 7)";
	    Statement comando = conexao.createStatement();
	    System.out.println("--------------------------- Consulta 13 ----------------------------------");	
	    ResultSet resultado = comando.executeQuery(sql);
	    ResultSetMetaData rsm = resultado.getMetaData();
	    for (int i = 1; i <= rsm.getColumnCount(); i++) {
		    System.out.print(rsm.getColumnName(i) + "\t\t");
	    }
	    
	    System.out.println();
	    
	    while (resultado.next()) {
		    for (int i = 1; i <= rsm.getColumnCount(); i++) {
			    String campo = resultado.getString(i);
			    System.out.print(campo + "\t\t\t");
		    }
		    System.out.println();
	    }
	    comando.close();
    }

    public void consulta14(Connection conexao) throws SQLException {
	    String sql = "SELECT p.primeiro_nome, p.sobrenome\r\n" + 
			    "FROM universidade.pessoa AS p RIGHT OUTER JOIN universidade.morador AS m ON (p.cpf = m.cpf)\r\n" + 
			    "WHERE p.cpf IN \r\n" + 
			    "       (SELECT cpf FROM universidade.pessoa AS p\r\n" + 
			    "        NATURAL JOIN universidade.morador AS m WHERE m.numero_do_bloco = 4\r\n" + 
			    "        AND m.numero_do_apartamento = 10)";
	    Statement comando = conexao.createStatement();
	    System.out.println("--------------------------- Consulta 14 ----------------------------------");	
	    ResultSet resultado = comando.executeQuery(sql);
	    ResultSetMetaData rsm = resultado.getMetaData();
	    for (int i = 1; i <= rsm.getColumnCount(); i++) {
		    System.out.print(rsm.getColumnName(i) + "\t\t");
	    }
	    
	    System.out.println();
	    
	    while (resultado.next()) {
		    for (int i = 1; i <= rsm.getColumnCount(); i++) {
			    String campo = resultado.getString(i);
			    System.out.print(campo + "\t\t\t");
		    }
		    System.out.println();
	    }
	    comando.close();
    }

    public void consulta15(Connection conexao) throws SQLException {
	    String sql = "SELECT p.primeiro_nome \r\n" + 
			    "FROM universidade.pessoa AS p\r\n" + 
			    "WHERE p.cpf\r\n" + 
			    "IN (SELECT cpf \r\n" + 
			    "    FROM universidade.funcionario AS f\r\n" + 
			    "    WHERE f.cargo LIKE 'Z%')";
	    Statement comando = conexao.createStatement();
	    System.out.println("--------------------------- Consulta 15 ----------------------------------");	
	    ResultSet resultado = comando.executeQuery(sql);
	    ResultSetMetaData rsm = resultado.getMetaData();
	    for (int i = 1; i <= rsm.getColumnCount(); i++) {
		    System.out.print(rsm.getColumnName(i) + "\t\t");
	    }
	    
	    System.out.println();
	    
	    while (resultado.next()) {
		    for (int i = 1; i <= rsm.getColumnCount(); i++) {
			    String campo = resultado.getString(i);
			    System.out.print(campo + "\t\t\t");
		    }
		    System.out.println();
	    }
	    comando.close();
    }
}
