/**
 * Escreva uma descrição da classe Main aqui.
 * 
 * @author (Sabrina Velasque e João Bergallo) 
 * @version (11/2022)
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CadastroDinossauro {
    Dinossauro[] cadastroDinossauros = new Dinossauro[50];

    //Modificamos o metodo cadastroDinossauro pois estava dando erro, mantivemos o original comentado abaixo

    public void cadastroDinossauro(String nomeRaca, int tipo, int categoria, double peso){
        for(int i = 0; i < cadastroDinossauros.length; i++) {//esse for vai percorrer o array e irá colocar o dinossauro na primeira posição que estiver vazia
            if (cadastroDinossauros[i] != null) { //isso verifica se há dinossauro cadastrado na posição
            } else {
                cadastroDinossauros[i]= new Dinossauro(i, nomeRaca, tipo, categoria, peso );
                System.out.println("\nDinossauro cadastrado com sucesso!\n");
                System.out.println(cadastroDinossauros[i]);
                break;
            }
        }
    }

    /* Metodo sora

    public CadastroDinossauro() {
    cadastroDinossauros = new Dinossauro[50];
    proximaPosicao = -1; //evitar “out of range” nos metodos
    }

    public boolean adicionarDinossauro(Dinossauro dino) {
    if (proximaPosicao + 1 < cadastroDinossauros.length) { //pq comeca com -1
    proximaPosicao++;
    cadastroDinossauros[proximaPosicao] = dino;
    return true;
    } else {
    return false;
    }
    }
     */

    public Dinossauro pesquisarDinossauro(int id) {
        //Trocamos o proximaPosição pelo cadastroDinossauro.length com ajuda do Willian pois estava acusando um erro que não estavamos conseguindo resolver. Ao trocar p lenght o código rodou sem erros
        for (int i = 0; i < cadastroDinossauros.length; i++) {
            if (cadastroDinossauros[i] != null) {
                if (cadastroDinossauros[i].getIdDinossauro() == id) {
                    return cadastroDinossauros[i];
                }
            }
        }
        return null;
    }

    //diminuimos as linhas de codico porque o ID está sendo gerado automaticamente, de forma que o dinossauro de id 1, vai estar na posição 1 do array, então quando mandar excluir o cadastroDinossauro[id] ele vai excluir na posição do ID
    public void removerDinossauro(int id) {
        if (id >= cadastroDinossauros.length){
            System.out.println("\nID inválido! Entre com um ID de 0 até 49.\n");
        }else {
            cadastroDinossauros[id] = null;// torna a posição nula, libera para outro dino
            System.out.println("\nDinossauro removido com sucesso!\n");
        }
    }

    public void quantidadePorTipo(int tipo) {
        int pp = 0;
        int mp = 0;
        int gp = 0;

        switch (tipo) { //pega o tipo que veio por parametro e compara para ver se é carnivoro ou herbivoro
            case 1: {
                    System.out.println("Carnívoro: ");
                    for (int i = 0; i < cadastroDinossauros.length; i++) {
                        if (cadastroDinossauros[i] != null && cadastroDinossauros[i].getTipo() == tipo) { // verifica se a posição não é nula para evitar erro e se o tipo é carnivoro
                            int categoria = cadastroDinossauros[i].getCategoria(); // recebe a categoria desta posição e soma no switch
                            switch (categoria) { 
                                case 1:
                                    pp++;
                                    break;

                                case 2:
                                    mp++;
                                    break;

                                case 3:
                                    gp++;
                                    break;
                            }
                        }
                    }
                    System.out.println("pp: " + pp + "\nmp: " + mp + "\ngp: " + gp + "\n");
                    break;
                }

            case 2: {
                    System.out.println("Herbivoro: ");
                    //ocorre o mesmo que em cima, porém verificando quando for herbivoro
                    for (int i = 0; i < cadastroDinossauros.length; i++) {
                        if (cadastroDinossauros[i] != null && cadastroDinossauros[i].getTipo() == tipo) {
                            int categoria = cadastroDinossauros[i].getCategoria();
                            switch (categoria) {
                                case 1:
                                    pp++;
                                    break;

                                case 2:
                                    mp++;
                                    break;

                                case 3:
                                    gp++;
                                    break;

                            }
                        }
                    }
                    System.out.println("pp: " + pp + "\nmp: " + mp + "\ngp: " + gp + "\n");
                    break;
                }

            default: 
                System.out.print("\nOpção inválida.\n");
                break;
        }
    }

    public void pesoPesado(int tipo, int categoria) {
        double peso = 0;
        int idPesado = 99;

        for (int i = 0; i < cadastroDinossauros.length; i++) {
            if (cadastroDinossauros[i] != null && cadastroDinossauros[i].getPeso() > peso && cadastroDinossauros[i].getTipo() == tipo && cadastroDinossauros[i].getCategoria() == categoria) { //verifica o peso, e armazena na varivavel o id e o peso do mais pesado
                idPesado = cadastroDinossauros[i].getIdDinossauro(); //guarda o id do mais pesado
                peso = cadastroDinossauros[i].getPeso(); // guarda o peso para comparação
            }
        }
        if(idPesado == 99){
            System.out.println("Nenhum dinossauro encontrado para esse tipo e essa categoria de peso.");
        }else{
            System.out.println("\nO dinossauro mais pesado do tipo " + tipo + " e da categoria de peso " + categoria + " é o: " + cadastroDinossauros[idPesado] + "\n"); //printa o dino mais pesado
        }
    }

    public void qntCarneMensal() {
        double pp = 0;
        double mp = 0;
        double gp = 0;

        for (int i = 0; i < cadastroDinossauros.length; i++) {
            if(cadastroDinossauros[i] != null) {
                if (cadastroDinossauros[i].getTipo() == 1 /*Carnivoro*/ && cadastroDinossauros[i].getCategoria() == 1 /*Pequeno porte*/) {
                    pp = pp + (cadastroDinossauros[i].getPeso() * 0.1);
                } else if (cadastroDinossauros[i].getTipo() == 1 /*Carnivoro*/ && cadastroDinossauros[i].getCategoria() == 2 /*Medio porte*/) {
                    mp = mp + (cadastroDinossauros[i].getPeso() * 0.15);
                } else if (cadastroDinossauros[i].getTipo() == 1 /*Carnivoro*/ && cadastroDinossauros[i].getCategoria() == 3 /*Grande porte*/) {
                    gp = gp + (cadastroDinossauros[i].getPeso() * 0.2);
                }
            }
        }
        double total = (pp + mp + gp) * 30; //calculo total de carne para todos, durante 30 dias

        System.out.println("\nTotal de carne para o mês é: " + total + "\n");
    }

    public void pesquisarTodosDinossauros(){
        for (int i = 0; i < cadastroDinossauros.length; i++) {
            if(cadastroDinossauros[i] != null){ //verifica se tem dinossauro na posição
                System.out.println(cadastroDinossauros[i].toString()); //se tiver dinossauro ele chama o dinossauro da posição e com o .toString ele mostra os dados do objeto
            }else {
                System.out.println("Nenhum dinossauro cadastrado no ID: " + i); //caso não tenha dinossauro, ele mostra o id disponível
            }
        }
    }

    public boolean tempoDeFuga(double velocidadeDino, double dinoBunker, double humanoBunker){
        double velocidadeHumano = 20;

        double tempoDino = dinoBunker / velocidadeDino; //tempo que o dinossauro leva para chegar no bunker
        double tempoHumano = humanoBunker / velocidadeHumano; //tempo que o humano leva para chegar no bunker

        if (tempoHumano < tempoDino){
            return true; //se o humano chega no bunker em menos tempo que o dinossauro, retorna true
        }else {
            return false; //se levar o mesmo tempo ou mais, retorna false e morre
        }
    }

    public String zonasPerigosas() { //metodo que retorna as zonas onde se concentram mais dinossauros carnívoros, com ajuda do Willian
        Random random = new Random(); //para instanciar o random

        int[][] parque = new int[150][150]; //matriz do parque
        int quantidadeDinossauroSul = 0; //contador de dinossauro
        int quantidadeDinossauroNorte = 0;

        for (int i = 0; i < 150; i++) { //criarmos esse for com a ajuda do Willian para "preencher" as posições e assim conseguirmos identificar quais estão estão vazias
            for (int j = 0; j < 150; j++) {
                parque[i][j] = -1; //então quando for diferente de -1 vai estar preenchida com algum dinossauro
            }
        }

        int linha;
        int coluna;

        for (int i = 0; i < cadastroDinossauros.length; i++) { //verifica quantos dinossauros tem
            if (cadastroDinossauros[i] != null) {
                linha = random.nextInt(150); //o metodo random usamos para escolher uma posição aleatória para os dinossauros
                coluna = random.nextInt(150);

                parque[linha][coluna] = cadastroDinossauros[i].getIdDinossauro(); //adiciona o dinossauro na posição LICO
            }
        }

        for (int i = 75; i < 150; i++) { //verifica os dinossauros na região Sul da matriz/parque ->linha
            for (int j = 0; j < 150; j++) { //coluna
                if (parque[i][j] != -1) {
                    if(pesquisarDinossauro(parque[i][j]) != null && pesquisarDinossauro(parque[i][j]).getTipo() == 1){//verifica se o dinossauro na posição não é nulo e se ele é do tipo carnívoro
                        quantidadeDinossauroSul ++;
                    }
                }
            }
        }

        for (int i = 0; i < 75; i++) {//verifica os dinossauros na região Norte da matriz/parque ->linha
            for (int j = 0; j < 150; j++) {//coluna
                if (parque[i][j] != -1) {
                    if(pesquisarDinossauro(parque[i][j]) != null && pesquisarDinossauro(parque[i][j]).getTipo() == 1){
                        quantidadeDinossauroNorte ++;
                    }
                }
            }
        }

        if (quantidadeDinossauroNorte > quantidadeDinossauroSul){ //realiza a comparação de norte e sul
            return "A zona norte é a mais perigosa!";
        }else if (quantidadeDinossauroSul > quantidadeDinossauroNorte){
            return "A zona sul é a mais perigosa!";
        }else {
            return "Os dinossauros carnívoros estão distribuidos igualmente pelo parque.";
        }

    }

    public void dinoComMaisVogais(String[] nomesDinos) {
        int maiorQntVogais = 0;
        int qntVogais = 0;
        ArrayList<String> dinoComMaisvogais = new ArrayList<>(); //cria um arrayList que vai ser usado para armazenar o ou os dinossauros com mais vogais

        for (int i = 0; i < cadastroDinossauros.length; i++) {
            if (cadastroDinossauros[i] != null) {
                String nome = cadastroDinossauros[i].getNomeRaca();
                System.out.println("Raça: " + nome);
                qntVogais = 0; //esta nesse local para evitar que ele fique somando no for e de um falso resultado.
                for (int j = 0; j < nome.length(); j++) {
                    if (nome.charAt(j) == 'a' || nome.charAt(j) == 'e' || nome.charAt(j) == 'i' || nome.charAt(j) == 'o' || nome.charAt(j) == 'u') {
                        qntVogais++;
                    } else {
                    }
                }
                if (qntVogais > maiorQntVogais) {//compara a quantidade de vogais da palavra com a palavra que tem maior numero de vogais
                    maiorQntVogais = qntVogais;//armazena caso a quantidade de vogais de uma palvra tenha sido maior que a anterior
                    dinoComMaisvogais.removeAll(dinoComMaisvogais); // caso a palavra tenha sido maior que o anterior ele limpa a lista
                    dinoComMaisvogais.add(cadastroDinossauros[i].getNomeRaca()); //adiciona o nome com maior quantidade de vogais que o anterior
                } else if (qntVogais == maiorQntVogais) {//compara se as palavras possuem a mesma quantidade de vogais
                    dinoComMaisvogais.add(cadastroDinossauros[i].getNomeRaca()); //se sim, ele adiciona junto na lista para printar as duas (empate)
                }
            }
        }
        Collections.sort(dinoComMaisvogais);//metodo da classe collections para ordenar o array de forma crescente, ideia do willian para nos auxiliar a printar aqueles com quantidade de vogais iguais em ordem alfabética

        System.out.println("A raça de dinossauro com maior quantidade de vogais é " + dinoComMaisvogais);
    }
}