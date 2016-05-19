import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.text.html.MinimalHTMLWriter;

public class Programa {
	public static void main(String[] args) {

		String arquivo = "C://Users//Jordi Ribeiro//Documents//entrada.txt";

		try {
			System.setIn(new FileInputStream(new File(arquivo)));
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encrontrado");
		}

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(new Locale("en", "US"));
		sc.useLocale(Locale.ENGLISH);

		// tipos dos vetores
		String nome[], telefone[];
		int i, N, tipo[], minutos[], j, pos, divide1 = 0, somaMinutos = 0, qtd = 0;
		double valorConta[], plano[][], receitaTotal, m, media2 = 0, mediaMinutos;

		System.err.println("\t\t\tSeja Bem Vindo !");
		// Mensagem de Inicio
		System.out.println("\n");
		System.out.println("Digite a Quantidade de Clientes que deseja preencher :");
		N = sc.nextInt();

		// Mensagem para Preencher tabela (ATENÇÃO PROGRAMADO USE O TAB TAMBEM
		// !)
		System.out.println();
		System.err.println(
				"ATENÇÃO : Para preencher a tabela presione a tecla TAB de seu teclado de uma celula para outra");
		System.out.println();

		// Instanciando os vetores
		nome = new String[N];
		telefone = new String[N];
		tipo = new int[N];
		minutos = new int[N];
		valorConta = new double[N];
		plano = new double[3][2];

		// Matriz com preços dos Planos
		System.out.println();
		System.out.println("Tabela de preços");
		for (i = 0; i < 3; i++) {
			System.out.println("Valor do  " + (i + 1) + "º plano");
			plano[i][0] = sc.nextDouble();
			System.out.println("Exedente do  " + (i + 1) + "º plano");
			plano[i][1] = sc.nextDouble();
		}

		System.out.println("\t\t\t\t |Clientes|");
		System.out.println();

		// Ler os dados

		for (i = 0; i < N; i++) {
			sc.nextLine();
			System.out.println("|Nome|");
			nome[i] = sc.nextLine();
			System.out.println("|Telefone|");
			telefone[i] = sc.next();
			System.out.println("|Tipo|");
			tipo[i] = sc.nextInt();
			System.out.println("|Minutos|");
			minutos[i] = sc.nextInt();

		}

		// Calcular o exedente
		for (i = 0; i < N; i++) {
			if (minutos[i] <= 90) {
				valorConta[i] = plano[tipo[i]][0];
			} else {
				valorConta[i] = plano[tipo[i]][0] + (minutos[i] - 90) * plano[tipo[i]][1];
			}

		}
		System.out.println();
		System.err.println("\t\t\tTabela Preenchida");
		System.out.println();

		// imprimir os vetores em forma de tabela
		System.out.println("Nome\t\tTelefone\t\tTipo\t\tMinutos\t\tValor da Conta");
		System.out.println();
		for (i = 0; i < N; i++) {
			System.out.println("" + nome[i] + "\t\t" + telefone[i] + "\t\t" + tipo[i] + "\t\t" + minutos[i] + "\t\t"
					+ valorConta[i]);
		}
		System.out.println();
		System.out.println();

		// receitaTotal
		receitaTotal = 0;
		for (i = 0; i < N; i++) {
			receitaTotal += valorConta[i];
		}
		System.out.println("Receita Total =" + receitaTotal);

		// Nome e telefone do cliente do qual a conta foi mais barata
		m = valorConta[0];
		pos = 0;
		for (i = 0; i < N; i++) {
			if (m > valorConta[i]) {
				m = valorConta[i];
				pos = i;
			}
		}
		System.out.println("O nome do cliente é " + nome[pos] + " Telefone : " + telefone[pos]);

		// Média de minutos consumidos por clientes de conta tipo 1.

		for (i = 0; i < N; i++) {
			if (tipo[i] == 1) {
				somaMinutos += minutos[i];
				divide1++;
			}
		}
		mediaMinutos = (double) somaMinutos / divide1;
		System.out.println("Média de minutos consumidos por clientes de conta tipo 1 =" + mediaMinutos);

		// Nomes e telefones dos clientes que não consumiram minutos excedentes.
		System.out.println("Nomes e telefones dos clientes que não consumiram minutos excedentes");
		for (i = 0; i < N; i++) {
			if (minutos[i] <= 90) {

				System.out.println("Nome : " + nome[i]);
				System.out.println("Telefone : " + telefone[i]);
			}
		}

		// A quantidade de clientes que consumiu acima de 120 minutos.
		System.out.println("A quantidade de clientes que consumiu acima de 120 minutos. ");
		for (i = 0; i < N; i++) {
			if (minutos[i] >= 120) {
				qtd++;
			}

		}
		System.out.println("A quantidade foi = " + qtd);

		qtd = 0;
		// A porcentagem de clientes que possuem conta tipo 2, em relação ao
		// total de clientes.
		System.out.println("A porcentagem de clientes que possuem conta tipo 2, em relação ao total de clientes. ");
		for (i = 0; i < N; i++) {
			if (tipo[i] == 2) {
				qtd++;
			}
		}

		media2 = (double) (qtd * 100) / N;
		System.out.println("A porcentagem é de " + media2 + "%");

	}
}
