import java.util.Scanner;

public class pascal{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o numero de colunas  ");
        int row = scanner.nextInt();

        int[][]array = new int[row][row];
        // i = linha j = coluna

        for(int i = 0;i<row;i++){ //itera entre as linhas
            array[i][0] = 1; //sempre inicia a prox linha com 1
            System.out.print(array[i][0]);
            

            for(int j = 1; j <= i;j++){ //itera entre as colunas
                int soma = 0;
                for(int k = i-1 ;k>=0;k--){ //realiza a soma vertical
                    soma += array[k][j-1];
                }
                array[i][j] = soma;
                System.out.print(array[i][j]);
            }
            System.out.println("");
        }

}}
