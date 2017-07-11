package br.com.alura.ed;

import java.util.Arrays;

public class Vetor {

	private Aluno[] alunos = new Aluno[100];
	private int totalDeElementos = 0;
	
	/**
	 * Esse método será responsável por redimensionar o vetor quando for necessário.
	 * Quando a capacidade do vetor chegar no limite, será criado um novo vetor
	 * com o dobro do tamanho anterior e passado todos os valores existentes para
	 * o novo vetor, assumindo este como o vetor principal
	 */
	private void garanteEspaco() {
		if (this.totalDeElementos == alunos.length) {
			Aluno[] novoVetor = new Aluno[this.totalDeElementos*2];
			for (int i = 0; i < this.totalDeElementos; i++) {
				novoVetor[i] = this.alunos[i];
			}
			
			this.alunos = novoVetor;
		}
	}
	
	/**
	 * Como sabemos a próxima posição livre no array com a propriedade totalDeElementos,
	 * para inserir um novo elemento, basta inserirmos nessa posição e, logo após, incrementá-la
	 * 
	 * @param aluno
	 */
	public void adiciona(Aluno aluno) {
		this.garanteEspaco();
		
		alunos[this.totalDeElementos] = aluno;
		this.totalDeElementos++;
	}
	
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.totalDeElementos;
	}
	
	/**
	 * Para adicionar em uma posição específica, deve ser deslocado todos os valores
	 * da esquerda para a direita, da posição passada em diante. Dessa forma, será
	 * liberado um espaço no vetor, onde será adicionado o novo elemento
	 * 
	 * @param aluno
	 * @param posição
	 */
	public void adiciona(Aluno aluno, int posicao) {
		this.garanteEspaco();
		
		if (!posicaoValida(posicao)) {
			throw new IllegalArgumentException("posição inválida!");
		}
		
		for (int i = this.totalDeElementos-1; i >= posicao; i--) {
			this.alunos[i+1] = this.alunos[i];
		}
		
		this.alunos[posicao] = aluno;
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeElementos;
	}
	
	/**
	 * Retorna valor do vetor de elementos de acordo com a posição passadao,
	 * se for uma posição válida
	 * 
	 * @param posicao
	 * @return
	 */
	public Aluno pega(int posicao) {
		
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("posição inválida!");
		}
		
		return alunos[posicao];
	}
	
	/**
	 * Para remover um valor do vetor, é preciso deslocar os elementos existentes na direita
	 * para a esquerda, a partir da posição a ser removida, sobrepondo os valores.
	 * 
	 * Importante lembrar que no último elemento do vetor, deve ser atribuido o valor null,
	 * senão o vetor terá o último valor válido repitido
	 * 
	 * @param posicao
	 */
	public void remove(int posicao) {
		
		for (int i = posicao; i < this.totalDeElementos; i++) {
			this.alunos[i] = this.alunos[i+1];
		}
		
		this.totalDeElementos--;
	}
	
	/**
	 * Esse método irá varrer o vetor, valor a valor, em busca do Elemento passado.
	 * Utilizando a boa prática de implementação do equals na modelagem do Aluno,
	 * a comparação de objetos é eficiente. Mas, não foi implementado o hashCode, por enquanto.
	 * 
	 * @param aluno
	 * @return
	 */
	public boolean contem(Aluno aluno) {
		
		for (int i = 0; i < this.totalDeElementos; i++) {
			if (aluno.equals(alunos[i])) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Retorna o tamanho ocupado do vetor até o momento
	 * 
	 * @return
	 */
	public int tamanho() {
		return this.totalDeElementos;
	}
	
	/**
	 * Retorna todos os elementos do vetor printando em uma linha, separados por vírgula
	 * 
	 */
	public String toString() {
		return Arrays.toString(alunos);
	}
}
