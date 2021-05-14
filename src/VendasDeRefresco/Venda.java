package VendasDeRefresco;
import java.util.ArrayList;

public class Venda {

    private double precoFinal;
    private Refresco refresco;
    private ArrayList <Refresco> listDeRefrescos;
    private Fabricante fabricante;

    public Venda(){

        this.listDeRefrescos = new ArrayList();
        this.precoFinal = 0.0;
    }

    public void adicionarItem(Refresco ref){

        this.listDeRefrescos.add(ref);
    }

    public double getPrecoFinal() {

        int i = 0;
        double precoUnitario [] = new double[listDeRefrescos.size()];
        double valorFinal = 0;

        while (i < listDeRefrescos.size()){
            precoUnitario[i] = this.listDeRefrescos.get(i).getPrecoUnitario();
            valorFinal = precoUnitario[i] + valorFinal;
            i++;
        }
        this.precoFinal = valorFinal;
        return this.precoFinal;
    }

    public String getItens(){

        String itens [] = new String[listDeRefrescos.size()];
        String itensFinal= "";
        int i=0;
        while (i < listDeRefrescos.size()){
            itens[i] = this.listDeRefrescos.get(i).getInfoRefresco();
            itensFinal = itens[i] + "\n"+ itensFinal;
            i++;
        }
        return itensFinal;
    }
}
