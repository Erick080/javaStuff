import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
  
public class T1 
{
//obtendo a data atual de consulta:
public static int DiaAtual()
{
Date hoje = new Date();
Calendar cal = Calendar.getInstance();
cal.setTime(hoje);
int Dia = cal.get(Calendar.DAY_OF_MONTH);
return Dia;
}
public static int MesAtual()
{
Date hoje = new Date();
Calendar cal = Calendar.getInstance();
cal.setTime(hoje);
int Mes = cal.get(Calendar.MONTH);
int mescorrigido = Mes + 1; // o calendario deste metodo começa em 0, então somei 1 ao mes
return mescorrigido;
}
public static int AnoAtual()
{
Date hoje = new Date();
Calendar cal = Calendar.getInstance();
cal.setTime(hoje);
int Ano = cal.get(Calendar.YEAR);
return Ano;
}
//menu 
public static int menu(){
Scanner input = new Scanner(System.in);
System.out.println("Menu de opções: " +"\n" + " [1] - Descubra quantos dias,horas e minutos voce ja viveu"+
         "\n" + " [2] - Descubra o dia da semana de seu nascimento" + "\n" + " [3] - Saia do programa ");
int opcao = input.nextInt();
return opcao;
}



// métodos do exercício 1
public static int diasmeses(int ano,int mes) // verifica quantos dias o mes tem
{
    int aux = 0;
    switch (mes){
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            aux = 31;
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            aux = 30;
            break;
        case 2:
            if (ano%4 == 0 && ano % 100 != 0 || ano == 2000){
                aux = 29;
                break;
            } else{
                aux = 28;
                break;
            }
            }
            return aux;
    }
// ver quantos dias o usuário ja viveu
    public static int ex1 (int ano,int AnoAtual, int mes,int MesAtual, int dia, int DiaAtual)
{
        int contdias = 0;
        int contmes = 1;  // para começar a contar os meses por janeiro
        int contano = ano;
        int bissexto = 0;
        int diffano = (AnoAtual - ano) - 1;
         while (contano < AnoAtual){ // calcular a quantidade de anos bissextos no intervalo de anos
            if (contano%4 == 0 && contano % 100 !=0 || contano == 2000){
                    bissexto = bissexto + 1;
            }
            contano = contano + 1;
        }   
        contdias = (365 * diffano) + bissexto; // calculo a quantidade de dias passados até o ano presente
        if (contmes != MesAtual){  // calculo a quantidade de dias passados até o mes presente
            switch (diasmeses(ano,contmes)){
            case 31:
            contdias = contdias + 31;
            contmes = contmes + 1;
            break;
            case 30:
            contdias = contdias + 30;
            contmes = contmes + 1;
            break;
            case 29:
            contdias = contdias + 29;
            contmes = contmes + 1;
            break;
            case 28:
            contdias = contdias + 28;
            contmes = contmes + 1; 
            break;
            default:
                System.out.println("ERRO");
            }
        }
        if (contmes == MesAtual){ // ao chegar no mes do aniversario, eu somo os dias totais com quantos faltam
            contdias = contdias + dia;
    }
    return contdias;
    }
   


// verifica se é o aniversário do usuário (exercicio 2)
public static String ex2(int dianasc,int DiaAtual,int mesnasc, int MesAtual)
{
    String aux = "";
    if (dianasc == DiaAtual && mesnasc == MesAtual){aux = "*****Hoje é seu aniversário!*****";}
    if (mesnasc > MesAtual) {aux = "*****Seu aniversário será em " + (mesnasc - MesAtual) + "meses*****";}
    if (mesnasc == MesAtual && dianasc > DiaAtual) {aux = "*****Voce fará aniversário este mes, em " + (DiaAtual - dianasc) + "dias*****"; }
    if (mesnasc < MesAtual) {aux = "*****Voce já fez aniversário este ano, " + (MesAtual - mesnasc) + "meses atrás*****";}
    if (dianasc < DiaAtual && mesnasc == MesAtual) {aux = "*****Voce já fez aniversario este mes, " + (dianasc - DiaAtual) + "dias atrás*****";}
    return aux;
}  
// método do exercício 3:
public static int calculo(int ano,int mes, int dia) 
    {
        int aux = 0;
        // método p/ conferir a primeira tabela dos meses (passo 3)
        if (mes == 1 || mes == 10){aux = 0;}
        if (mes == 5) {aux = 1;}
        if (mes == 8) {aux = 2;}
        if (mes == 2 || mes == 3 || mes == 4 || mes == 11) {aux = 3;}
        if (mes == 6) {aux = 4;}
        if (mes == 9 || mes == 12) {aux = 5;}
        if (mes == 4 || mes == 7) {aux = 6;}
        int a = ano - 1900; // passo 1 
        int b = a/4; // passo 2
      if (ano%4==0 && ano %400 == 0 && ano%100!=0 && dia <=29 && mes <=2) {b = (a/4) - 1;}// para ver se o ano é bissexto
      else {b = a/4;}
        int D = dia - 1; // passo 4, 
        int resto = (a + b + aux + D)%7;
      return resto;
        }
// método principal:
public static void main(String [] args)
{
    // obtendo a data de nascimento:
    
    Scanner input = new Scanner(System.in);
    System.out.println("\fDigite o dia do mes que voce nasceu: ");
    int dianasc = input.nextInt();
    while (1>dianasc || dianasc > 31) {
    System.out.println("Digite um dia válido: ");
    dianasc = input.nextInt();
    }
    System.out.println("Digite o mes que voce nasceu (em numero): ");
    int mesnasc = input.nextInt();
    while (1 > mesnasc || mesnasc > 12) {
    System.out.println("Digite um mes valido: ");
    mesnasc = input.nextInt();
    }
    System.out.println("Digite o ano que voce nasceu: ");
    int anonasc = input.nextInt();
    while (1900 > anonasc || anonasc > AnoAtual()){
    System.out.println("Digite um ano válido: ");
    anonasc = input.nextInt();
    }
    // diz se é o aniversário do usuário ou não (ex2)
    System.out.println(ex2(dianasc,DiaAtual(),mesnasc,MesAtual()));
    
    // Menu:
    while (true){
    int opcao = menu();
    if (opcao == 3) {break;}
            switch (opcao)
    {
        case 1: // exercício 1
            int dias = ex1(anonasc,AnoAtual(),mesnasc,MesAtual(),dianasc,DiaAtual()); // dias vividos
            System.out.println("Digite as horas de seu nascimento (sem min): ");
            int horasN = input.nextInt();
            System.out.println("Digite os minutos de seu nascimento: ");
            int minutosN = input.nextInt();
            int horasT = (dias*24) - horasN;
            int minutosT = (dias*1440) - (horasN/60 + minutosN);
            System.out.println("Voce ja viveu" + dias + " dias, " + horasT + " horas e " + minutosT + " minutos.");
            break;
        case 2: // exercício 3
            int resposta = calculo(anonasc,mesnasc,dianasc);
            switch (resposta){ // obtendo o resultado da última tabela do ex3
            case 0:
                System.out.println("Segunda-feira");
                break;
            case 1:
                System.out.println("Terça-feira");
                break;
            case 2:
                System.out.println("Quarta-feira");
                break;
            case 3:
                System.out.println("Quinta-feira");
                break;
            case 4:
                System.out.println("Sexta-feira");
                break;
            case 5:
                System.out.println("Sábado");
                break;
            case 6:
                System.out.println("Domingo");
            }
            break;
    }


} 
}
}
