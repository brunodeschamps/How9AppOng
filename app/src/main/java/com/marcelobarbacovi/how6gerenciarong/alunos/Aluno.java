package com.marcelobarbacovi.how6gerenciarong.alunos;

public class Aluno {
  // atributos da classe aluno
    private  int id;
    private String nome;
    private String responsavel;
    private String telefone;
    private String endereco;
    private String observao;

    // metodos  para inserir e recuperar dados dos atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getObservao() {
        return observao;
    }

    public void setObservao(String observao) {
        this.observao = observao;
    }
}
