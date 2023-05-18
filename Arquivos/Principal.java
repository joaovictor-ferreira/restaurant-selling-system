import java.util.Scanner;

// Classe destinada a execução do programa
public class Principal {
    public static void main(String[] args) {

        // Objeto que possibilita a entrada dos dados via teclado
        Scanner entrada = new Scanner(System.in);

        // Objeto usado para o pedido do cliente
        Pedido pedido = new Pedido();

        // Declaração da escolha do menu principal por parte do usuário
        String escolhaPrincipal;

        // Estrutura de repetição para possibilitar várias escolhas por parte do usuário
        do {

            // Exibindo o menu principal
            System.out.println("\nMenu Principal" +
                               "\n1 - Fazer Pedido" +
                               "\n0 - Sair");
            System.out.printf("Digite sua opção: ");
            escolhaPrincipal = entrada.nextLine();

            // Estrutura de decisao para agir de acordo com a opção escolhida pelo usuário
            switch (escolhaPrincipal){

                case "1":

                    // Chamando o método para iniciar o pedido
                    pedido.registrarPedido();
                    pedido.exibirNotaFiscal();
                    pedido.receberValor();
                    break;
                default:

                    // Estrutura de decisao para saber se não foi digitado a opção de saida
                    if (!escolhaPrincipal.equals("0")){

                        System.out.println("\nOpção inválida");
                    }
            }

        } while (!escolhaPrincipal.equals("0"));

        System.out.println("\nPrograma Finalizado\n");
    }
}