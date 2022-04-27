public class formulas
{
    // calcular área do quadrado
    public static double AreaDoQuadrado(double lado)
    {
        return lado*lado;
    }
    // calcular perímetro do quadrado
    public static double PerimetroDoQuadrado(double lado)
    {
        return lado * 4;
    }
    // calcular área do retângulo
    public static double AreaDoRetangulo (double altura,double lado)
    {
        return lado*altura;
    } 
    // calcular perímetro do retângulo
    public static double PerimetroDoRetangulo (double altura, double lado)
    {
        return (lado*2) + (altura*2);
    }
    // calcular área do triângulo
    public static double AreaDoTriangulo (double base, double altura)
    {
        return (base*altura)/2;
    }
    //calcular perímetro do triângulo
    public static double PerimetroDoTriangulo (double base,double hip,
    double catetoadj)
    {
        return base + hip + catetoadj;
    }
    //calcular área do círculo
    public static double AreaDoCirculo (double raio)
    {
        return Math.PI * Math.pow(raio,2);
    }
    // calcular perímetro do círculo
    public static double PerimetroDoCirculo (double raio)
    {
        return 2 * Math.PI * raio;
    }
    // calcular volume da esfera
    public static double VolumeDaEsfera (double raio)
    {
        return (4 * Math.PI * Math.pow(raio,3))/ 3;
    }
    // calcular área lateral da esfera
    public static double AreaLateralDaEsfera (double raio)
    {
        return 4 * Math.PI * Math.pow(raio,2);
    }
    // calcular volume do cubo
    public static double VolumeDoCubo (double lado)
    {
        return Math.pow(lado,3);
    }
    // calcular área lateral do cubo
    public static double AreaLateralDoCubo (double lado)
    {
        return 4 * Math.pow (lado,2);
    }
    // calcular volume do paralelepípedo
    public static double VolumeDoParalelepipedo(double altura, double largura,
    double comprimento)
    {
        return altura * largura * comprimento;
    }
    // calcular área lateral do paralelepípedo
    public static double AreaLateralDoParalelepipedo (double base, 
    double largura, double altura)
    {
        return 2 * ((base*altura) + (largura*altura));
    }
    // calcular volume do cone
    public static double VolumeDoCone (double raio, double altura)
    {
        return (Math.PI * Math.pow(raio,2) * altura) / 3;
    }
    // calcular área lateral do cone
    public static  double AreaLateralDoCone (double raio, double geratriz)
    {
        return Math.PI * raio * geratriz;
    }
    // volume do cilindro
    public static double VolumeDoCilindro (double raio, double altura)
    {
        return Math.PI * Math.pow(raio,2) * altura;
    }
    // area lateral do cilindro
    public static double AreaLateralDoCilindro (double raio, double altura)
    {
        return (2 * Math.PI) * raio * altura;
    }
    // volume da piramide
    public static double VolumeDaPiramide (double areabase, double altura)
    {
        return (areabase * altura)/3;
    }
    // area lateral da piramide (hexagonal)
    public static double AreaLateralDaPiramide (double base, double altura)
    {
        return 6 * ((base * altura)/2);
    }

    // metodo para trocar valores entre duas variavies
    public static void troca (int a, int b)
    {
        int aux = 0;
        aux = a;
        a = b;
        b = aux;
    }

    // metodo para máximo divisor comum, a >= b
    public static int maxdc (int a, int b)
    {
        int resto = 0;
        while(b != 0)
        {
            resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }
    // metodo para minimo multiplo comum, a >= b

    public static int mmc (int a, int b)
    {
        int cont = 1;
        int resultado = 999999;
        while (true)
        {
            if ((a * cont)%b == 0){resultado = 0;break;}
            else{cont = cont + 1;}

        }
        return a*cont;
    }

    // metodo para ver a soma dos divisores de um numero

    public static int sdivisores(int num)
    {
        int contador = num;
        int soma = 0;
        while(contador != 0)
        {
            if (num % contador == 0){soma = soma + contador;}
            contador = contador - 1;

        }

        return soma;
    }
    // metodo para ver se o número é primo

    public static boolean primo (int num)
    {
        int contador = num;
        int soma = 0;
        while (contador != 0)
        {
            if (num % contador == 0) {soma = soma + contador;}
            contador = contador - 1;
        }
        if (soma == num + 1){return true;}
        else{return false;}
    }

    //metodo para ver maior numero entre 3
    public static int maior3 (int a, int b, int c)
    {
        int r = 0;
        while (true)
        {
            if (a == b)
            {if (a > c) {r = a;break;} else{r = c;break;}}
            if (a == c)
            {if (a>c) {r = a;break;}else {r = c; break;}} 
            if (b == c)
            {if (b>c) {r=b;break;}else {r = c;break;}}
            if (a == b && b == c)
            {r = a;break;}
            else
            {if (a > b && a > c) {r = a;break;};
                if (b > a && b > c) {r = b;break;};
                if (c > a && c > b) {r = c;break;};}
        }
        return r;
    }
    //metodo para decompor horas em minutos 
    public static int horasmin (int a)
    {
        int r = 60 * a;
        return r;
    }
    //metodo para decompor horas em segundos
    public static int horasec (int a)
    {
        int min = 60 * a;
        int sec = 60 * min;
        return sec;
    }
    //metodo para calcular baskara (b+delta)
    public static double baskara1 (double a, double b, double c)
    {
        double r = (-b + (Math.sqrt(Math.pow(b,2) - (4 * a * c)))) / 2 * a;
        return r;
    }
    //metodo para calcular baskara (b-delta)
    public static double baskara2 (double a, double b, double c)
    {
        double r = (-b - (Math.sqrt(Math.pow(b,2) - (4 * a * c)))) / 2 * a;
        return r;
    }
}
