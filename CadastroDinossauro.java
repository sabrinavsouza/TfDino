import java.util.Arrays;

public class CadastroDinossauro {
    Dinossauro[] cadastroDinossauros = new Dinossauro[50];
    
    //Modifiquei o metodo cadastroDinossauro pois estava dando erro, mantive o original comentado
    
    public void cadastroDinossauro(String nomeRaca, int tipo, int categoria, double peso){
        //esse for vai percorrer o array e irá colocar o dinossauro na primeira posição que estiver vazia
        for(int i = 0; i < cadastroDinossauros.length; i++) {
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
        //Troquei o proximaPosição pelo cadastroDinossauro.length porque fica melhor na minha logica
        // Percorre todo o array e vai mostrar aquele que for o ID igual ao pesquisado
        for (int i = 0; i < cadastroDinossauros.length; i++) {
            if (cadastroDinossauros[i] != null) { 
                if (cadastroDinossauros[i].getIdDinossauro() == id) {
                    return cadastroDinossauros[i];
                }
            }
        }
        return null;
    }

    //diminui as linhas de codico poque o ID está sendo gerado automaticamente, de forma que o dinossauro de id 1, vai estar na posição 1 do array, então quando mandar excluir o cadastroDinossauro[id] ele vai excluir na posição do ID
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
        int idPesado = 0;

        for (int i = 0; i < cadastroDinossauros.length; i++) {
            if (cadastroDinossauros[i] != null && cadastroDinossauros[i].getPeso() > peso && cadastroDinossauros[i].getCategoria() == categoria) { //verifica o peso, e armazena na varivavel o id e o peso do mais pesado
                idPesado = cadastroDinossauros[i].getIdDinossauro(); //guarda o id do mais pesado
                peso = cadastroDinossauros[i].getPeso(); // guarda o peso para comparação
            }
        }
        System.out.println("\nO dinossauro mais pesado da categoria " + categoria + " é o: " + cadastroDinossauros[idPesado] + "\n"); //printa o dino mais pesado
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

    /*

    public String zonasPerigosas() {
    String zona;
    int parque [][] = new int[150][150];


    return zona;
    }
     */

    public void dinoComMaisVogais(String[] nomesDinos) {

        String[] nomesDinosOrdenada = new String[50];
        int qntVogaisI = 0;
        int qntVogaisJ = 0;

        for (int i = 0; i < nomesDinos.length; i++){
            for (int j = 0; j < nomesDinos.length; j++){

                if (nomesDinos[i] != null && nomesDinos[j] != null){

                    for (int k = 0; k < nomesDinos[i].length(); k++ ){
                        if (nomesDinos[i].charAt(k) == 'a' || nomesDinos[i].charAt(k) == 'e' || nomesDinos[i].charAt(k) == 'i' || nomesDinos[i].charAt(k) == 'o' || nomesDinos[i].charAt(k) == 'u') {
                            qntVogaisI++;
                        }
                    }

                    for (int k = 0; k < nomesDinos[j].length(); k++ ){
                        if (nomesDinos[j].charAt(k) == 'a' || nomesDinos[j].charAt(k) == 'e' || nomesDinos[j].charAt(k) == 'i' || nomesDinos[j].charAt(k) == 'o' || nomesDinos[j].charAt(k) == 'u') {
                            qntVogaisJ++;
                        }
                    }
                }
            }
        }
    }
}

