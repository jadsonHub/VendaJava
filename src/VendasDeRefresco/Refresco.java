package VendasDeRefresco;


public class Refresco {

    private double precoUnitario;
    private String sabor;
    private char tamanho;
    private boolean contemAcucar;
    private Fabricante fabricante;
    public static final String sabores [] = {"tamarindo","Limão","Groselha"};


    public Refresco(String sabor, char tamanho, boolean contemAcucar, Fabricante fabricante){
        this.contemAcucar = contemAcucar;
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.fabricante = fabricante;
        setPrecoUnitario(this.tamanho,this.contemAcucar);

    }

    public void  setPrecoUnitario(char tamanho, boolean contemAcucar) {

        this.precoUnitario =2.5;

        if(tamanho == 'P')  {

            if(contemAcucar == true) {
                this.precoUnitario+=0.50;
            }else{
                this.precoUnitario =2.5;
            }
        }else if(tamanho == 'M') {
            this.precoUnitario+=0.50;
            if(contemAcucar == true){
                this.precoUnitario+=.50;
            }
        }else if (tamanho == 'G'){
            this.precoUnitario+=1.0;

            if(contemAcucar == true) {
                this.precoUnitario+=0.50;
            }
        }
    }

    public double getPrecoUnitario() {

        return precoUnitario;
    }

    public String getInfoRefresco(){
        return"\nSabor: "+this.sabor+"\nTamanho: "+this.tamanho+"\nContem Açucar: "+this.contemAcucar+"\nPreço R$: "+this.precoUnitario+"\nInformaçoês da Fabrica: "+fabricante.getInfoFabrica();
    }

}
