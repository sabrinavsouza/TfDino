/**
 * Escreva uma descrição da classe Main aqui.
 * 
 * @author (Sabrina Velasque e João Bergallo) 
 * @version (11/2022)
 */
import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        System.out.print("\f");
        menu(); //isso chama o menu assim que abrir a classe main
    }

    private static void menu() {
        int option = 99; // inicia o option em 99 para não dar conflito com as opções do menu

        CadastroDinossauro cadastroDinossauro = new CadastroDinossauro();

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n|----------------- Escolha uma opção --------------------|");
            System.out.println("| 1 - Adicionar dinossauro                               |");
            System.out.println("| 2 - Pesquisar dinossauro por ID                        |");
            System.out.println("| 3 - Verificar quantidade de dinossauro por tipo        |");
            System.out.println("| 4 - Verificar dinossauro mais pesado                   |");
            System.out.println("| 5 - Verificar quantidade de carne para os carnívoros   |");
            System.out.println("| 6 - Remover dinossauro pelo ID                         |");
            System.out.println("| 7 - Tempo de fuga                                      |");
            System.out.println("| 8 - Zonas perigosas do parque                          |");
            System.out.println("| 9 - Relatório dos nomes de dinossauros com mais vogais |");
            System.out.println("| 10- Pesquisar todos os dinossauros                     |");
            System.out.println("| 0 - Sair                                               |");
            System.out.println("|________________________________________________________|");

            String opt = scanner.next();

            if(opt.equals("0") || opt.equals("1") || opt.equals("2") || opt.equals("3") || opt.equals("4") || opt.equals("5") || opt.equals("6") || opt.equals("7") || opt.equals("8") || opt.equals("9") || opt.equals("10")){
                option = Integer.parseInt(opt);
            }else{
                System.out.println("Opção invalida. Tente novamente.");
                menu();
            }

            switch (option) {
                case 1: //opção que chama o método que cria o dinossauro
                    System.out.println("------------- CRIAÇÃO DE DINOSSAURO -------------");
                    
                    System.out.println("Entre com o tipo do dinossauro (1 - carnívoro / 2 - herbívoro):");
                    int tipo = scanner.nextInt();
                    if (tipo != 1 && tipo != 2){
                        System.out.println ("Opção inválida. Inicie o cadastro novamente.");
                        menu();
                    }
                    
                    System.out.println("Entre com o tamanho do dinossauro (1 - PP / 2 - MP / 3 - GP):"); //mudamos o 'categoria' para 'tamanho' quando o usuario interage para ficar menos confuso
                    int categoria = scanner.nextInt();
                    if (categoria != 1 && categoria != 2 && categoria != 3){
                        System.out.println ("Opção inválida. Inicie o cadastro novamente.");
                        menu();
                    }
                    
                    System.out.println("Entre com o peso do dinossauro:");
                    double peso = scanner.nextInt();

                    System.out.println("Entre com a raça do dinossauro:");
                    String nomeRaca = scanner.next();

                    //decidimos não pedir o ID pois achamos que colocar o ID automaticamente tornaria uma experiência melhor para o usuário
                    cadastroDinossauro.cadastroDinossauro(nomeRaca, tipo, categoria, peso);
                    break;

                case 2: //opção que pesquisa o dinossauro por id
                    System.out.println("Pesquisar dinossauro por ID: ");
                    System.out.println("Entre com o ID: ");
                    int idDinossauro = scanner.nextInt();
                    Dinossauro dino = cadastroDinossauro.pesquisarDinossauro(idDinossauro);
                    if (dino != null){
                        System.out.println(dino.toString());
                    }else{
                        System.out.println("Não há dinossauro cadastrado com esse ID");
                    }
                    break;

                case 3: //pesquisa quantos dinossauros do tipo carnivoro e herbivoros há cadastrado
                    System.out.println("Qual tipo voce quer pesquisar? (1 - carnívoro / 2 - herbívoro");
                    tipo = scanner.nextInt();
                    cadastroDinossauro.quantidadePorTipo(tipo);
                    break;

                case 4: //pesquisa o tamanho dos dinossauros por tipo de alimentação
                    System.out.println("Qual tipo você quer pesquisar? (1 - carnívoro / 2 - herbívoro)");
                    tipo = scanner.nextInt();
                    System.out.println("Qual tamanho você quer pesquisar? (1 - PP / 2 - MP / 3 - GP)");
                    categoria = scanner.nextInt();
                    cadastroDinossauro.pesoPesado(tipo, categoria);
                    break;

                case 5: //opção para ver o cálculo de carne necessária ao mês para os dinossauros carnívoros cadastrados até o momento
                    cadastroDinossauro.qntCarneMensal();
                    break;

                case 6: //opção para remover um dinossauro através do seu id
                    System.out.println("Digite o ID do dinossauro que quer remover: ");
                    idDinossauro = scanner.nextInt();
                    cadastroDinossauro.removerDinossauro(idDinossauro);
                    break;

                case 7: //pesquisa para saber o tempo necessário para uma eventual fuga
                    System.out.println("Digite a velocidade média do dinossauro: ");
                    double velocidadeDino = scanner.nextDouble();

                    System.out.println("Digite a distância entre o dinossauro e o bunker: ");
                    double dinoBunker = scanner.nextDouble();

                    System.out.println("Digite a distância do humano até o bunker: ");
                    double humanoBunker = scanner.nextDouble();

                    if(cadastroDinossauro.tempoDeFuga(velocidadeDino, dinoBunker, humanoBunker) == false){
                        System.out.println("Infelizmente, você morre!\n");
                    }else{
                        System.out.println("Dá tempo!\n");
                    }
                    break;

                case 8: //informa a zona mais perigosa do parque, baseada no local onde os carnívoros estão alocados
                    System.out.println(cadastroDinossauro.zonasPerigosas());
                    break;

                case 9:// informa o dinossauro que tenha a raça com mais vogais, e caso tenha empate, printa em ordem alfabética
                    String nomesDinos[] = new String[50];
                    for (int i = 0; i < cadastroDinossauro.cadastroDinossauros.length; i++){
                        if(cadastroDinossauro.cadastroDinossauros[i] != null){
                            nomesDinos[i] = cadastroDinossauro.cadastroDinossauros[i].getNomeRaca();
                        }

                    }
                    cadastroDinossauro.dinoComMaisVogais(nomesDinos);
                    break;

                case 10: //informa todos os dinossauros cadastrados e os id disponíveis
                    System.out.println("\nPesquisando todos os dinossauros..\n");
                    cadastroDinossauro.pesquisarTodosDinossauros();
                    break;

                case 0: //sai da aplicação e zera os id.
                    System.out.print("Programa encerrado!");
                    option = 0;
                    break;
            }

        } while (option != 0);//garante que o menu ficará executavel, enquanto a opção não for zero

    }
}
