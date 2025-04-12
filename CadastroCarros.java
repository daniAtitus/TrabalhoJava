import java.util.Scanner;

public class CadastroCarros {
    public static void main(String[] args) {

        //criação de dois vetores em java
        String[] nomesCarros = new String[5];
        Integer[] valoresCombustivel = new Integer[5];
        //criação de um atributo do tipo scanner, o parametro recebe dados padrão do teclado
        Scanner lerTeclado = new Scanner(System.in);
        //variavel para o controle do loop
        boolean verfica = true;

        while (verfica) {
            //Menu
            System.out.println("""
                    Menu:
                    1 - Cadastrar Carros
                    2 - Exibir Carros Cadastrados
                    3 - Carro que mais gastou
                    4 - Mostrar total gasto com combustivel
                    5 - Consumo medio por carro
                    0 - Sair
                    """);
            //Ler teclado é um objeto da classe scanner, o NextInt e o metodo do scanner que le o valor inteiro digitado
            int menu = lerTeclado.nextInt();
            //Nextiline é usado para a quebra de linha
            lerTeclado.nextLine();

            switch (menu) {
                case 1:
                    //o atributo carroCadastro é usado para controle do loop
                    boolean carroCadastrado = false;
                    //um loop para procurar um espaço vazio, percorre o array em busca de um valor nulo
                    for (int i = 0; i < nomesCarros.length; i++) {
                        if (nomesCarros[i] == null) {
                            //no cadastro ele pede os dados, nomesCarros[i] é usado para acessr o indice correto do vetor
                            // como se fosse i =0, i = 1, e assim por diante
                            System.out.print("Digite o modelo do carro: ");
                            nomesCarros[i] = lerTeclado.nextLine();
                            System.out.print("Digite o gasto com combustível (em número): ");
                            valoresCombustivel[i] = lerTeclado.nextInt();
                            lerTeclado.nextLine();
                            System.out.println("Carro cadastrado com sucesso!");
                            carroCadastrado = true;
                            break;
                        }
                    }//se carroCadastro continuar como false significa que o loop rodou ate o final
                    if (!carroCadastrado) {
                        System.out.println("Todos os espaços para carros estão preenchidos!");
                    }
                    break;

                case 2:
                    System.out.println("Carros cadastrados: ");

                    boolean carrosExistem = false;
                    //verifica se cada posição esta vazia
                    //quando encontra pelo menos 1 carro, carrosExistem vira true
                    for (int i = 0; i < nomesCarros.length; i++) {
                        if (nomesCarros[i] != null) {
                            System.out.println("Carro: " + nomesCarros[i] + " - Gasto com combustível: " + valoresCombustivel[i]);
                            carrosExistem = true;
                        }
                    }//carrosExistem permanece false para evitar que caia na condicional mesmo existindo carros
                    if (!carrosExistem) {
                        System.out.println("Nenhum carro cadastrado.");
                    }
                    break;

                case 3:
                    //guarda o maior valor encontrado
                    int maiorGasto = 0;
                    //armazena o nome do carro
                    String carroMaiorGasto = null;
                    //verifica se existem carros cadastrados
                    boolean temCarros = false;
                    //percorre a lista valoresCombustiveis verifica se a posição atual é diferente de nulo, se for nulo significa que estaria vazia
                    //e não entraria na condicional e tambem se a lista de valores combustivel for maior que zero
                    //se ambas as condição forem verdadeiras atualiza o valor maiorGasto e armazena o nome do caro correspondente
                    for (int i = 0; i < valoresCombustivel.length; i++) {
                        if (valoresCombustivel[i] != null && valoresCombustivel[i] > maiorGasto) {
                            // maiorGasto recebe o valor do indice percorrido de valoresCombustivel
                            maiorGasto = valoresCombustivel[i];
                            carroMaiorGasto = nomesCarros[i];
                            temCarros = true;
                        }
                    }
                    //se temCarros for igual a true exibe o os valores e se carros for igual a false ele entre no else
                    if (temCarros) {
                        System.out.println("O carro que mais gastou foi: " + carroMaiorGasto + " com gasto de " + maiorGasto);
                    } else {
                        System.out.println("Nenhum carro cadastrado.");
                    }
                    break;

                case 4:
                    //armazena a soma acumulada dos gastos
                    int gastoTotalCombustivel = 0;
                    //atributo usado como forma de controle
                    boolean temValores = false;

                    //percorre o array de valoresCombustivel e acessa o valor do indice do array,
                    //onde ele verifica se é diferente de nulo
                    for(int i = 0; i < valoresCombustivel.length; i++) {
                        if (valoresCombustivel[i] != null) {
                            gastoTotalCombustivel += valoresCombustivel[i];
                            temValores = true;
                        }
                    }
                    //se for true mostra os valores
                    if (temValores) {
                        System.out.println("Total gasto com combustível: " + gastoTotalCombustivel);
                    } else {
                        System.out.println("Nenhum gasto registrado.");
                    }
                    break;

                case 5:
                    //armazena o valor total
                    int somaGastos = 0;
                    int quantidadeCarros = 0;
                    //acessa os valores de cada indice de valores combutivel
                    for (int i = 0; i < valoresCombustivel.length; i++) {
                        //verifica se valoresCombustivel não está vazio
                        if (valoresCombustivel[i] != null) {
                            //valor total
                            somaGastos += valoresCombustivel[i];
                            quantidadeCarros++;
                        }
                    }
                    //calculo e exibição de media
                    if (quantidadeCarros > 0) {
                        double consumoMedio = (double) somaGastos / quantidadeCarros;
                        System.out.printf("O consumo médio dos carros é: %.2f%n", consumoMedio);
                    } else {
                        System.out.println("Nenhum carro cadastrado.");
                    }
                    break;

                case 0:
                    verfica = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}