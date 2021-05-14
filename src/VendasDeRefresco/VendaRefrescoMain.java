package VendasDeRefresco;

import java.util.Scanner;

public class VendaRefrescoMain {


    public static void main(String[] args) {

        char inicio ='C';
        int MAX = 10;
        int i = 0;
        int contadorFabrica = 0;
        int contadorVenda = 0;
        boolean contemAcucar = false;
        char tamanho = 'x';
        String sabor = "";

        String opcao = "";

        Scanner ler = new Scanner(System.in);
        Fabricante f[] = new Fabricante[MAX];
        Refresco r [] = new Refresco[MAX];
        Venda v = new Venda();

        while (inicio !='X'){
            System.out.println("Bem vindo!\nEscolha uma opção:\n1-Cadastrar Fabrica\n2-Comprar Refresco\n3-Sair:\nOpção:");
            int op = ler.nextInt();
            switch (op){
                case 1:
                    clearBuffer(ler);

                    do{

                        System.out.println("\tCadastrar Fabrica\n");
                        System.out.println("Informe o nome da fabrica:");
                        String nomeFabrica = ler.nextLine();

                        System.out.println("Informe o COE:");
                        String COE = ler.nextLine();

                        System.out.println("Informe o ano de fundação:");
                        int anoFundacao=ler.nextInt();

                        f[i] = new Fabricante(nomeFabrica, COE, anoFundacao);
                        i++;

                        contadorFabrica = i;
                        clearBuffer(ler);

                        System.out.println("Cadastro realizado com Sucesso!\nDeseja cadastrar uma nova Fabrica? S/N");
                        opcao = ler.nextLine();

                        if(opcao.equalsIgnoreCase("S")){
                            opcao = "";
                        }
                    }while ( !opcao.equalsIgnoreCase("N"));
                    break;
                case 2:

                    do {

                        System.out.println("\nLista de fabricantes:\n");

                        for (int j = 0; j < contadorFabrica; j++) {
                            System.out.println(f[j].getInfoFabrica() + "\nID:" + j + "\n================================");
                            contadorVenda++;
                        }

                        clearBuffer(ler);
                        System.out.println("Informe a ID da fabrica que deseja:");
                        int idFabrica = ler.nextInt();

                        if (f[idFabrica].getInfoFabrica().equalsIgnoreCase(f[idFabrica].getInfoFabrica())) {
                            clearBuffer(ler);

                            System.out.println("Informe o sabor do refresco:");
                            sabor = ler.nextLine();
                            char acucar = 'X';
                            while(acucar !='S' && acucar != 's' && acucar != 'N' && acucar != 'n'){
                                System.out.println("Com açucar ? S/N");
                                acucar = ler.next().charAt(0);
                            }
                            if (acucar == 'S' || acucar == 's') {
                                contemAcucar = true;
                            } else {
                                contemAcucar = false;
                            }
                            tamanho = 'c';
                            while (tamanho != 'M' && tamanho != 'm' && tamanho != 'P' && tamanho != 'p' && tamanho != 'G' && tamanho != 'g') {

                                System.out.println("Informe o tamnho: G (GRANDE), M (MÈDIO), P(PEQUENO)");
                                tamanho = ler.next().charAt(0);

                                if (tamanho == 'P' || tamanho == 'p') {
                                    tamanho = 'P';
                                } else if (tamanho == 'M' || tamanho == 'm') {
                                    tamanho = 'M';
                                } else if (tamanho == 'G' || tamanho == 'g') {
                                    tamanho = 'G';
                                }
                            }
                        }
                        r[contadorVenda] = new Refresco(sabor, tamanho, contemAcucar, f[idFabrica]);
                        v.adicionarItem(r[contadorVenda]);
                        char voltar = 'S';
                        while (voltar != 'N' && voltar == 'S') {

                            System.out.println("Deseja fazer uma nova compra ? S/N");
                            voltar = ler.next().charAt(0);

                            if (voltar == 'S' || voltar == 's') {
                                opcao = "";
                            }else{
                                System.out.println(v.getItens());
                                System.out.println("\nTotal Final:"+v.getPrecoFinal()+"\nCompra finalizada com sucesso!\n");
                                opcao = "N";
                            }
                        }
                    }while (!opcao.equalsIgnoreCase("N"));
                    break;
                case 3:
                    System.out.println("Obrigado por utilizar nossos serviços ! XD\nFinalizando......");
                    inicio = 'X';
                    break;
                default: System.out.println("Opção invalida!");break;
            }
        }
    }
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}