//imprime um vetor de inteiros
public void imprimeVetorInt(int[] vetor)
    {   
         System.out.print("\n");
        for(int i = 0; i<vetor.length;i++)
        {
            System.out.print("|"+vetor[i]);
        }
        System.out.print("|\n");
            
    }
    
//imprime um vetor de doubles   
public void imprimeVetorDouble(double[] vetor)
    {   
         System.out.print("\n");
        for(int i = 0; i<vetor.length;i++)
        {
            System.out.print("|"+vetor[i]);
        }
        System.out.print("|\n");
            
    }
    
//retorna o maior valor em um vetor de inteiros   
public int maiorVetorInt(int[] vetor)
    {   
        int maior = vetor[0];
        for(int i = 1; i<vetor.length;i++)
        {
            if(vetor[i]>maior)
            {
                maior = vetor[i];
            }
        }
        return maior;
            
    }
    
  //retorna o maior valor em um vetor de doubles
public double maiorVetorDouble(double[] vetor)
    {   
        double maior = vetor[0];
        for(int i = 1; i<vetor.length;i++)
        {
            if(vetor[i]>maior)
            {
                maior = vetor[i];
            }
        }
        return maior;
            
    }
    
//retorna o menor valor em um vetor de inteiros   
public int menorVetorInt(int[] vetor)
    {   
        int menor = vetor[0];
        for(int i = 1; i<vetor.length;i++)
        {
            if(vetor[i]<menor)
            {
                menor = vetor[i];
            }
        }
        return menor;
            
    }
   
//retorna o menor valor em um vetor de doubles
public double menorVetorDouble(double[] vetor)
    {   
        double menor = vetor[0];
        for(int i = 1; i<vetor.length;i++)
        {
            if(vetor[i]<menor)
            {
                menor = vetor[i];
            }
        }
        return menor;
            
    }
    
    //ordena um vetor de inteiros (crescente)
public int[] ordenaVetorInt(int[] vetor)
    {   
        int aux = 0;
        boolean troca = false;
        do{
            troca = false;
            for(int i = 0; i<vetor.length-1;i++)
            {
                if(vetor[i]>vetor[i+1])
                {
                    aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    troca = true;
                }
            }
        }while(troca);
        return vetor;
            
    }
    
   //ordena um vetor de doubles (crescente)
public double[] ordenaVetorDouble(double[] vetor)
    {   
        double aux = 0;
        boolean troca = false;
        do{
            troca = false;
            for(int i = 0; i<vetor.length-1;i++)
            {
                if(vetor[i]>vetor[i+1])
                {
                    aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    troca = true;
                }
            }
        }while(troca);
        return vetor;
            
    }
    
    //multiplica os elementos de um vetor de ints por um int
    public int[] multiplicaVetorInt(int[] vetor, int num)
    {   
        for(int i = 0; i<vetor.length;i++)
        {
            vetor[i]=vetor[i]*num;
        }
        
        return vetor;
            
    }
    
   //multiplica os elementos de um vetor de doubles por um double
public double[] multiplicaVetorDouble(double[] vetor, double num)
    {   
        for(int i = 0; i<vetor.length;i++)
        {
            vetor[i]=vetor[i]*num;
        }
        
        return vetor;
            
    }
    
    //soma os elementos de dois vetores int
public int[] somaVetorInt(int[] vetor1, int[] vetor2)
    {   
        
        
        if(vetor1.length<vetor2.length)
        {
            int[] aux = vetor1;
            vetor1 =vetor2;
            vetor2=aux;
        }
        
        
        for(int i = 0; i<vetor1.length;i++)
        {
            vetor1[i]=vetor1[i] + vetor2[i];
        }
        
        return vetor1;
            
    }
    
   //soma os elementos de dois vetores double
public double[] somaVetorDouble(double[] vetor1, double[] vetor2)
    {   
        
        
        if(vetor1.length<vetor2.length)
        {
            double[] aux = vetor1;
            vetor1 =vetor2;
            vetor2=aux;
        }
        
        
        for(int i = 0; i<vetor1.length;i++)
        {
            vetor1[i]=vetor1[i] + vetor2[i];
        }
        
        return vetor1;
            
  
    }
//multiplica os elementos de dois vetores int e gera num vetor **nao e produto escalar
  public int[] produtoVetorInt(int[] vetor1, int[] vetor2)
    {   
        
        
        if(vetor1.length<vetor2.length)
        {
            int[] aux = vetor1;
            vetor1 =vetor2;
            vetor2=aux;
        }
        
        
        for(int i = 0; i<vetor1.length;i++)
        {
            vetor1[i]=vetor1[i]*vetor2[i];
        }
        
        return vetor1;
            
    }
    
    
//multiplica os elementos de dois vetores double
public double[] produtoVetorDouble(double[] vetor1, double[] vetor2)
    {   
        
        
        if(vetor1.length<vetor2.length)
        {
            double[] aux = vetor1;
            vetor1 =vetor2;
            vetor2=aux;
        }
        
        
        for(int i = 0; i<vetor1.length;i++)
        {
            vetor1[i]=vetor1[i]*vetor2[i];
        }
        
        return vetor1;
            
    }
    
   //faz a uniao entre dois vetores de numeros inteiros, assumindo que elementos nao repetem dentro dos próprios vetores (podem repetir entre (termo comum) os vetores)
public int[] uniaoVetorInt(int[] vetor1, int[] vetor2)
    {   
        int count  = 0;
        int[] temp = new int[vetor2.length]; // vetor temporário para receber os termos no vetor 2 que nao estao no vetor 1
        int tempIndex = 0;
        
        int tamanho1 = vetor1.length;
        int tamanho2 = vetor2.length;
        
        boolean unico = true;
        for (int i = 0; i<tamanho2; i++) //verifica quantos elementos repetidos existem entre os vetores e coloca os nao repetidos do vetor 2 em um vetor temporário
        {
            for(int j= 0; j<tamanho1; j++)
            {
                
                if(vetor2[i]==vetor1[j]) // checamos cada termo do vetor 2 com todos os termos do vetor1
                {
                    count++;
                    unico = false; // o termo do vetor2 existe no vetor1
                }
            }
            if(unico)// se o termo do vetor 2 nao existe no vetor 1...
            {
             temp[tempIndex]=vetor2[i];// ...entao ele é colocado em um vetor temporario
             tempIndex++;   
            }
            unico = true;
        }
        
        int[] vetor3 = new int[tamanho1 + tamanho2 - count]; //declara o vetor que receberatodos os termos com o tamanho correto
        for(int i = 0; i<tamanho1; i++)// colocando os termos do vetor 1 no novo vetor
        {
            vetor3[i]=vetor1[i];
        }
        for(int i = 0; i<(tamanho2-count); i++)// colocando os termos nao repetidos do vetor 2 no novo vetor
        {
            vetor3[tamanho1+i]=temp[i];
        }
        return vetor3;
        
    }
    
//faz a uniao entre dois vetores de numeros double, assumindo que elementos nao repetem dentro dos próprios vetores (podem repetir entre (termo comum) os vetores)   
public double[] uniaoVetorDouble(double[] vetor1, double[] vetor2)
    {   
        int count  = 0;
        double[] temp = new double[vetor2.length]; // vetor temporário para receber os termos no vetor 2 que nao estao no vetor 1
        int tempIndex = 0;
        
        int tamanho1 = vetor1.length;
        int tamanho2 = vetor2.length;
        
        boolean unico = true;
        for (int i = 0; i<tamanho2; i++) //verifica quantos elementos repetidos existem entre os vetores e coloca os nao repetidos do vetor 2 em um vetor temporário
        {
            for(int j= 0; j<tamanho1; j++)
            {
                
                if(vetor2[i]==vetor1[j]) // checamos cada termo do vetor 2 com todos os termos do vetor1
                {
                    count++;
                    unico = false; // o termo do vetor2 existe no vetor1
                }
            }
            if(unico)// se o termo do vetor 2 nao existe no vetor 1...
            {
             temp[tempIndex]=vetor2[i];// ...entao ele é colocado em um vetor temporario
             tempIndex++;   
            }
            unico = true;
        }
        
        double[] vetor3 = new double[tamanho1 + tamanho2 - count]; //declara o vetor que receberatodos os termos com o tamanho correto
        for(int i = 0; i<tamanho1; i++)// colocando os termos do vetor 1 no novo vetor
        {
            vetor3[i]=vetor1[i];
        }
        for(int i = 0; i<(tamanho2-count); i++)// colocando os termos nao repetidos do vetor 2 no novo vetor
        {
            vetor3[tamanho1+i]=temp[i];
        }
        return vetor3;
        
    }
// faz a intersecao entre dois vetores int, sendo que os vetores nao possuim termos repetidos internamente
public int[] interVetorInt(int[] vetor1, int[] vetor2)
    {
        int[] temp = new int[vetor1.length]; // vetor temporario para mater as variaveis, seu tamanho precisa ser maior do que o menor vetor (aqui escolhemos arbitrariamente um dos vetores)
        int tempIndex = 0;
        
        for (int i =0; i<vetor1.length; i++)
        {
            for(int j = 0; j<vetor2.length;j++)
            {
                if(vetor1[i] == vetor2[j])
                {
                    temp[tempIndex]=vetor1[i]; //coloca os valores comuns nos dois vetores no vetor temporario
                    tempIndex++;
                    break;
                }
            }
        }
        
        int[] vetor3 = new int[tempIndex]; // vetor a ser retornado, do tamanho certo
        
        for(int i =0; i<tempIndex;i++)
        {
            vetor3[i]=temp[i];
        }
        return vetor3;
        
    }
    
// faz a interseccoao entre dois vetores double, sendo que os vetores nao possuim termos repetidos internamente    
public double[] interVetorDouble(double[] vetor1, double[] vetor2)
    {
        double[] temp = new double[vetor1.length]; // vetor temporario para mater as variaveis, seu tamanho precisa ser maior do que o menor vetor (aqui escolhemos arbitrariamente um dos vetores)
        int tempIndex = 0;
        
        for (int i =0; i<vetor1.length; i++)
        {
            for(int j = 0; j<vetor2.length;j++)
            {
                if(vetor1[i] == vetor2[j])
                {
                    temp[tempIndex]=vetor1[i]; //coloca os valores comuns nos dois vetores no vetor temporario
                    tempIndex++;
                    break;
                }
            }
        }
        
        double[] vetor3 = new double[tempIndex]; // vetor a ser retornado, do tamanho certo
        
        for(int i =0; i<tempIndex;i++)
        {
            vetor3[i]=temp[i];
        }
        return vetor3;
        
    }
    
//retorna o produto escala de dois vetores inteiros com mesmo tamanho, e 0 se os vetores tem tamanho diferente   
public int produtoEscalarInt(int[] vetor1, int[] vetor2)
    {   
        if(vetor1.length!=vetor2.length)
        {
            return 0;
        }
        int produto=0;
        for (int i =0; i<vetor1.length; i++)
        {
            produto+=vetor1[i]*vetor2[i];
        }
        return produto;
        
    }
    
//retorna o produto escala de dois vetores double com mesmo tamanho, e 0 se os vetores tem tamanho diferente   
public double produtoEscalarInt(double[] vetor1, double[] vetor2)
    {   
        if(vetor1.length!=vetor2.length)
        {
            return 0;
        }
        double produto=0;
        for (int i =0; i<vetor1.length; i++)
        {
            produto+=vetor1[i]*vetor2[i];
        }
        return produto;
        
    }
    
    
     // soma todos os elementos de um vetor de inteiros  
    public int somaTotalVetorInt(int[] vetor)
    {   
        int total = 0;
        for( int i = 0 ; i<vetor.length;i++)
        {
            total+=vetor[i];
        }
        return total;
    }
    
// soma todos os elementos de um vetor de inteiros   
public double somaTotalVetorDouble(double[] vetor)
    {   
        double total = 0;
        for( int i = 0 ; i<vetor.length;i++)
        {
            total+=vetor[i];
        }
        return total;
    }

// ----- MATRIZES------

public void imprimeMatrizInt(int[][] matriz)
    {
        for (int i = 0; i<matriz.length;i++)
        {
            System.out.print("\n");
            for(int j= 0; j<matriz[i].length;j++)
            {
                System.out.print("|"+matriz[i][j]);
            }
            System.out.print("|");
        }
        
    }
    public void imprimeMatrizDouble(double[][] matriz)
    {
        for (int i = 0; i<matriz.length;i++)
        {
            System.out.print("\n");
            for(int j= 0; j<matriz[i].length;j++)
            {
                System.out.print("|"+matriz[i][j]);
            }
            System.out.print("|");
        }
        
    }

//imprime a diagonal principal de uma matriz quadrada de inteiros  e retorna um vetor com estes termos
public int[] diagonalInt(int[][] matriz)
    {   
        int[] diag = new int[matriz.length];
        System.out.print("\n|");
        for(int i = 0; i<matriz.length;i++)
        {
            diag[i]=matriz[i][i];
            System.out.print("|"+matriz[i][i]+"|");
        }
        System.out.print("|");
        return diag;
    }
    
//imprime a diagonal principal de uma matriz quadrada de doubles e retorna um vetor com estes termos   
public double[] diagonalInt(double[][] matriz)
    {   
        double[] diag = new double[matriz.length];
        System.out.print("\n|");
        for(int i = 0; i<matriz.length;i++)
        {
            diag[i]=matriz[i][i];
            System.out.print("|"+matriz[i][i]+"|");
        }
        System.out.print("|");
        return diag;
    }
    
//imprime a diagonal secundaria de uma matriz quadrada de inteiros  e retorna um vetor com estes termos   
public int[] secundariaInt(int[][] matriz)
    {   
        int[] diag = new int[matriz.length];
        System.out.print("\n|");
        for(int i = 0; i<matriz.length;i++)
        {
            diag[i]=matriz[i][matriz[i].length-i-1];
            System.out.print("|"+matriz[i][matriz[i].length-i-1]+"|");
        }
        System.out.print("|");
        return diag;
    }
    
//imprime a diagonal secundaria de uma matriz quadrada de inteiros  e retorna um vetor com estes termos  
public double[] secundariaDouble(double[][] matriz)
    {   
        double[] diag = new double[matriz.length];
        System.out.print("\n|");
        for(int i = 0; i<matriz.length;i++)
        {
            diag[i]=matriz[i][matriz[i].length-i-1];
            System.out.print("|"+matriz[i][matriz[i].length-i-1]+"|");
        }
        System.out.print("|");
        return diag;
    }

//checa se uma matriz é diagonal (int)
public boolean matrizDiagonalInt(int[][] matriz)
    {   
        for (int i = 0; i<matriz.length;i++)
        {
            for(int j= 0; j<matriz[i].length;j++)
            {
                if(i!=j)
                {
                    if(matriz[i][j]!=0)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    //checa se uma matriz é diagonal (double)
public boolean matrizDiagonalDouble(double[][] matriz)
    {   
        for (int i = 0; i<matriz.length;i++)
        {
            for(int j= 0; j<matriz[i].length;j++)
            {
                if(i!=j)
                {
                    if(matriz[i][j]!=0)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
//checa se uma matriz é uma matriz unidade (int)    
public boolean matrizUnidadeInt(int[][] matriz)
    {   
        for (int i = 0; i<matriz.length;i++)
        {
            for(int j= 0; j<matriz[i].length;j++)
            {
                if(i==j)
                {
                    if(matriz[i][j]!=1)
                    {
                        return false;
                    }
                }
                else if (matriz[i][j]!=0)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
//checa se uma matriz é uma matriz unidade (double)    
public boolean matrizUnidadeDouble(double[][] matriz)
    {   
        for (int i = 0; i<matriz.length;i++)
        {
            for(int j= 0; j<matriz[i].length;j++)
            {
                if(i==j)
                {
                    if(matriz[i][j]!=1)
                    {
                        return false;
                    }
                }
                else if (matriz[i][j]!=0)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
//retorna true se a matriz tem mais de 50% dos elementos iguais a zero
public boolean matrizEsparsaInt(int[][] matriz)
    {   
        
        double count = 0;
        for (int i = 0; i<matriz.length;i++)
        {
            for(int j= 0; j<matriz[i].length;j++)
            {
                
                if(matriz[i][j]==0)
                {
                    count+=1.0;
                }
                
            }
        }
        if(count/(matriz.length*matriz[0].length)>0.5)
        {
            return true;
        }
        return false;
    }
    
//retorna true se a matriz (retangular) tem mais de 50% dos elementos iguais a zero   
public boolean matrizEsparsaDouble(double[][] matriz)
    {   
        double count = 0;
        for (int i = 0; i<matriz.length;i++)
        {
            for(int j= 0; j<matriz[i].length;j++)
            {
                
                if(matriz[i][j]==0)
                {
                    count+=1.0;
                }
                
            }
        }
        if(count/(matriz.length*matriz[0].length)>0.5)
        {
            return true;
        }
        return false;
    }
//soma os elementos de duas matrizes de mesmo tamanho (int)
public int[][] somaMatrizInt(int[][] matriz1, int[][] matriz2)
    {   
        for(int i =0; i<matriz1.length;i++)
        {
            matriz1[i]=somaVetorInt(matriz1[i],matriz2[i]);
        }
        return matriz1;
    }
    
//soma os elementos de duas matrizes de mesmo tamanho (double)   
public double[][] somaMatrizDouble(double[][] matriz1, double[][] matriz2)
    {   
        for(int i =0; i<matriz1.length;i++)
        {
            matriz1[i]=somaVetorDouble(matriz1[i],matriz2[i]);
        }
        return matriz1;
    }
    
    //multiplica os elementos de duas matrizes de mesmo tamanho (int)
    public int[][] produtoMatrizInt(int[][] matriz1, int[][] matriz2)
    {   
        for(int i =0; i<matriz1.length;i++)
        {
            matriz1[i]=produtoVetorInt(matriz1[i],matriz2[i]);
        }
        return matriz1;
    }
    
//soma os elementos de duas matrizes de mesmo tamanho (double)   
public double[][] produtoMatrizDouble(double[][] matriz1, double[][] matriz2)
    {   
        for(int i =0; i<matriz1.length;i++)
        {
            matriz1[i]=produtoVetorDouble(matriz1[i],matriz2[i]);
        }
        return matriz1;
    }
    


