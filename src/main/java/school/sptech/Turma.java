package school.sptech;

public class Turma {
    private String nome;
    private Double mensalidade;
    private Integer qtdAluno = 0;
    private Boolean ativa = true;

    public Boolean getAtiva(){
        return ativa;
    }

    public Integer getQtdAluno(){
        return qtdAluno;
    }

    public String getNome(){
        return nome;
    }

    public Double getMensalidade(){
        return mensalidade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Turma(String nome, Double mensalidade){
        this.nome = nome;
        this.mensalidade = mensalidade;
    }

    public void matricular(Integer qtd){
        if (qtd != null && qtd > 0 && ativa == true){
            qtdAluno += qtd;
        }
    }

    public Integer cancelar(Integer qtd){
        if (qtd == null || qtd <= 0 || qtd >= qtdAluno || ativa == false){
            return null;
        } else {
            qtdAluno -= qtd;
            return qtd;
        }
    }

    public Integer desativar(){
        if (ativa == false){
            return null;
        } else {
            int totalAlunos = qtdAluno;
            ativa = false;
            qtdAluno = 0;
            return totalAlunos;
        }
    }

    public void transferir(Turma destino, Integer qtdATransferir){
        if (destino != null && destino.ativa == true && qtdATransferir != null && qtdATransferir > 0 && qtdAluno > qtdATransferir && ativa == true){
            destino.qtdAluno = qtdAluno;
            qtdAluno -= qtdATransferir;
        }
    }

    public Boolean reajustarMensalidade(Double reajuste){
        if (reajuste == null || reajuste <= 0){
            return false;
        } else {
            mensalidade = mensalidade * (1 + reajuste);
            return true;
        }
    }



}

