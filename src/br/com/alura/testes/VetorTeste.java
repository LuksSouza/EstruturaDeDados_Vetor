package br.com.alura.testes;

import br.com.alura.ed.Aluno;
import br.com.alura.ed.Vetor;

public class VetorTeste {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Joao");
		Aluno a2 = new Aluno("Pedro");
		Aluno a3 = new Aluno("Jaime");
		Aluno a4 = new Aluno("Zé");
		Aluno a5 = new Aluno("Roberto");
		Aluno a6 = new Aluno("Juca");
		Aluno a7 = new Aluno("Tião");
		
		Vetor vetor = new Vetor();
		
		vetor.adiciona(a1);
		vetor.adiciona(a2);
		vetor.adiciona(a3);
		vetor.adiciona(a4);
		vetor.adiciona(a5);
		vetor.adiciona(a6);
		vetor.adiciona(a7);
		
		System.out.println(vetor.toString());
		
		//Testando método pega()
		System.out.println("O método pega() deve retornar Pedro na posição 1: " + vetor.pega(1));
		
		//Testando método remove(posição)
		System.out.println("O método remove(posicao) deve remover o aluno Pedro:");
		vetor.remove(1);
		System.out.println(vetor.toString());
		
		//Testando método adiciona(aluno, posicao)
		vetor.adiciona(new Aluno("Cabritao"), 2);
		System.out.println(vetor.toString());
	}
}
