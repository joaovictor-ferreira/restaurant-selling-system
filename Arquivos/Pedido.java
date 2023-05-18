import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedido {

    // Atributos da classe Pedido
    private String nomeCliente;
    private double valorPedido;
    private double valorTaxaServico;
    private List<Item> itens = new ArrayList<>();

    // Método responsável por iniciar o pedido e registrar os itens do mesmo
    public void registrarPedido(){

        // Objeto que possibilita a entrada dos dados via teclado
        Scanner entrada = new Scanner(System.in);

        // Entrada do nome do cliente
        System.out.printf("Digite o nome do cliente: ");
        this.nomeCliente = entrada.nextLine();

        // Declaração da variável que armazena se o cliente irá continuar o pedido
        String escolhaItemAtual;

        // Estrutura de repetição para possibilitar o cliente escolhar vários itens
        do {

            // Exibir o cardápio e a entrada da escolha do item atual
            System.out.println("\nCARDÁPIO" +
                    "\n1 - Feijoada (R$ 18,00)" +
                    "\n2 - Lasanha (R$ 15,00)" +
                    "\n3 - Parmegiana (R$ 22,00)" +
                    "\n4 - Tambaqui (R$ 24,00)" +
                    "\n5 - Refrigerante Lata (R$ 5,00)" +
                    "\n6 - Água (R$ 2,50)" +
                    "\n0 - Finalizar Pedido");
            System.out.printf("Escolha o item: ");
            escolhaItemAtual = entrada.nextLine();

            // Estrutura de decisão para construção cadastro do item de acordo a opção escolhida acima
            switch (escolhaItemAtual){

                case "1":

                    itens.add(new Item("Feijoada", 18));
                    this.valorPedido += 18;
                    break;
                case "2":

                    itens.add(new Item("Lasanha", 15));
                    this.valorPedido += 15;
                    break;
                case "3":

                    itens.add(new Item("Parmegiana", 22));
                    this.valorPedido += 22;
                    break;
                case "4":

                    itens.add(new Item("Tambaqui", 24));
                    this.valorPedido += 24;
                    break;
                case "5":

                    itens.add(new Item("Refrigerante Lata", 5));
                    this.valorPedido += 5;
                    break;
                case "6":

                    itens.add(new Item("Água", 2.5));
                    this.valorPedido += 2.5;
                    break;
                default:

                    // Estrutura de decisão para verificar se a opção não é a de retorno
                    if (!escolhaItemAtual.equals("0")) {

                        System.out.println("\nItem não existente");
                    }
            }

        } while (!escolhaItemAtual.equals("0"));

        // Calculo da taxa de serviço
        this.valorTaxaServico = getValorPedido() * 0.1;
    }

    // Método responsável por exibir a nota fiscal
    public void exibirNotaFiscal(){

        System.out.println("\nNOTA FISCAL");

        // Estrutura de repetição para exibir as informações de cada item do pedido
        for (int i = 0; i < this.itens.size(); i++) {

            System.out.println(this.itens.get(i).informarItem());
        }

        // Exibindo a taxa de serviço (10%)
        System.out.println("Taxa de serviço (10%): R$ " + this.getValorTaxaServico());

        // Exibindo o valor total do pedido
        System.out.println("Valor total: R$ " + (getValorPedido() + getValorTaxaServico()));
    }

    // Método responsável por receber o valor do cliente e retornar o valor do troco
    public void receberValor(){

        // Objeto que possibilita a entrada dos dados via teclado
        Scanner entrada = new Scanner(System.in);

        // Entrada do valor do cliente
        System.out.printf("Digite o valor dado pelo cliente: R$ ");
        double valorClienteAtual = entrada.nextDouble();
        entrada.nextLine();

        // Exibindo o valor do troco
        System.out.println("Valor do troco: R$ " + (valorClienteAtual - (this.valorPedido + this.valorTaxaServico)));
    }

    // Getters
    public double getValorPedido() {

        return valorPedido;
    }

    public double getValorTaxaServico() {

        return valorTaxaServico;
    }

    public String getNomeCliente() {

        return nomeCliente;
    }
}
