package br.com.alura.ed;

public class Aluno {

	private String nome;

	public Aluno(String nome) {
		this.nome = nome;
	}
			
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object obj) {
		Aluno outroAluno = (Aluno) obj;
		
		return outroAluno.getNome().equals(this.getNome());
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
}
