package VendasDeRefresco;

public class Fabricante {

    private String nome = null;
    private String COE;
    private int anoFundacao;
    private Refresco refresco;

    public Fabricante(String nome, String COE, int anoFundacao) {

        this.anoFundacao = anoFundacao;
        this.COE = COE;
        this.nome = nome;

    }

    public String getInfoFabrica(){

        return "\nNome do Fabricante: "+this.nome+"\nCOE: "+this.COE+"\nAno de Fundação: "+this.anoFundacao;
    }


}