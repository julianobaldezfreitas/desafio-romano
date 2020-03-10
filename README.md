# Desafio JAVA

###### Desenvolvedor: [Juliano Freitas](https://www.linkedin.com/in/juliano-freitas-55807924/)

###### Descrição do desafio: [Coding Dojo](http://codingdojo.org/kata/RomanNumerals/)

## Solução
###### Tabela de apoio

A base da solução desenvolvida tem como apoia a tabela abaixo. É o mapeamento das equivalências entre números arábicos e romanos. Com base nesta tabela é possível transformar os números de 1 a 3000. 

Além do mapeamento dos principais algarismos também temos a indicação se o algarismo romano correspondente é formado por uma subtração. Esta informação é importante no momento de transformar algarismos romanos em arábicos.

Exemplos de algarismos romanos formados por subtração:

 ```
 IV - 1-5  = 4
 IX - 1-10 = 9
 ```

| Arábico | Romano | Subtração |
|---------|--------|-----------|
| 1000    | M      |  NÃO      |
| 900     | CM     |  SIM      |
| 500     | D      |  NÃO      |
| 400     | CD     |  SIM      |
| 100     | C      |  NÃO      |
| 90      | XC     |  SIM      |
| 50      | L      |  NÃO      |
| 40      | XL     |  SIM      |
| 10      | X      |  NÃO      |
| 9       | IX     |  SIM      |
| 5       | V      |  NÃO      |
| 4       | IX     |  SIM      |
| 1       | I      |  NÃO      |

Ver classe **TabelaConversaoEnum.java**.

###### Transformação de número arábico para romano - Parte I

A seguir um exemplo do algoritmo de conversão.

**Arábico = 2428**

0. Percorrer a lista de número arábicos da tabela acima na ordem que é apresentada (**1000 até 1**).
1. Dividir o número arábico por cada elemento da lista e pegar o resultado da parte inteira da divisão.
> 2248 / 1000 = **2**,428
2. Multiplicar o item corrente da lista pela parte inteira da divisão
> 1000 * 2 = **2000**
3. Subtrair o valor pelo número de entrada
> 2428 - 2000 = **428**
4. Para o valor do elemento da lista (1000) pegar seu caractere correspondente em romanos e concatenar pela parte inteira da divisão (item 2).
> M * 2 = **MM**
6. Repetir para cada elemento da lista (item 1)

| Nro  | Lista| Passo 1     | Passo 2             | Passo 3               | Passo 4                |
|------|------|-------------|---------------------|-----------------------|------------------------|
| 2428 | 1000 | = **2**,428 | 1000 * 2 = **2000** | 2428 - 2000 = **428** | M * 2 = **MM**         |
| 428  | 900  | = **0**,44  | -                   | -                     | -                      |
| 428  | 500  | = **0**,856 | -                   | -                     | -                      |
| 428  | 400  | = **1**,07  | 400 * 1 = **400**   | 428 - 400 = **28**    | CD * 1 = MM**CD**      |
| 28   | 100  | = **0**,28  | -                   | -                     | -                      |
| 28   | 90   | = **0**,31  | -                   | -                     | -                      |
| 28   | 50   | = **0**,56  | -                   | -                     | -                      |
| 28   | 40   | = **0**.7   | -                   | -                     | -                      |
| 28   | 10   | = **2**,8   | 10 * 2 = **20**     | 28 - 20 = **8**       | X * 2 = MMCD**XX**     |
| 8    | 9    | = **0**,88  | -                   | -                     | -        |
| 8    | 5    | = **1**,6   | 5 * 1 = **5**       | 8 - 5 = **3**         | V * 1 = MMCDXX**V**    |
| 3    | 4    |= **0**,75   | -                   | -                     | -                      |
| 3    | 1    | = **3**     | 1 * 3 = 3           | 3 - 3  = **0**        | I * 3 = MMCDXXV**III** |

###### Transformação de número romano para arábico - Parte II

A seguir um exemplo do algoritmo de conversão.

**Romano = MMCDXXVIII**

0. Percorrer a lista de número romanos da tabela de apoio acima na ordem que é apresentada (**M até I**).
1. Se o item da lista for encontrado nos caracteres do número romano informado então conta o número de ocorrências deste caractere. 
> M -> **MM** CDXXVIII -> 2x
2. Pega o número arábico correspondente ao caractere romano na tabela de apoio e multiplica pelo número de ocorrências encontradas.
> M(1000) -> 1000 * 2 = **2000**
3. Caso o romano tenha encontrado ocorrências do caractere no número informado e se o item da lista for formado por subtração guardar em uma lista separada.
> M(NAO)
4. Após percorrer todos os itens da lista de números romanos da tabela de apoio (item 0), percorre a lista de itens formados por subtração (item 3) pegando o valor correspondente em arábico e diminui do total encontrado no item 2 .

| Romano    | Arábico |Passo 1   | Passo 2             | Passo 3     | Passo 4 |
|-----------|-------- |----------|-------------------- |-------------|---------|
| MMCDXXVIII| M       | M -> 2x  | 2 * 1000 = **2000** | NÃO         |         | 
| MMCDXXVIII| CM      | -        |                     | NÃO         |         |
| MMCDXXVIII| D       | D -> 1x  | 500 * 1 = **500**   | NÃO         |         |
| MMCDXXVIII| CD      | CD -> 1x | 400 * 1 = **400**   | CD = C(100) + D (500) = 600 |         |
| MMCDXXVIII| C       | C -> 1x  | 100 * 1 = **100**   | NÃO         |         |
| MMCDXXVIII| XC      | -        | -                   | NÃO         |         |
| MMCDXXVIII| L       | -        | -                   | NÃO         |         |
| MMCDXXVIII| XL      | -        | -                   | NÃO         |         |
| MMCDXXVIII| X       | X -> 2x  | 10 * 2 = **20**     | NÃO         |         |
| MMCDXXVIII| IX      | -        | -                   | NÃO         |         |
| MMCDXXVIII| V       | V -> 1x  | 5 * 1 = **5**       | NÃO         |         |
| MMCDXXVIII| IV      | -        | -                   | NÃO         |         |
| MMCDXXVIII| I       | I -> 3x  | 3 * 1 = **3**       | NÃO         |         |
| -         | -       | **Total**| **3028**            |  **600**    | 3028 - 600 = **2428**  |

## Para executar


```

```

## Testes unitários

Relatório local de cobertura de código dos testes unitários pode ser executado localmente.
Acessível na pasta **target\site\jacoco**.

 ``` 
 mvn test ou mvn install 
 ```
 
Relatório local de cobertura de código dos testes unitários pode ser executado localmente.
Acessível na pasta **target\site\cobertura**.

 ``` 
 mvn cobertura:cobertura  
 ```


## Outras notas:

**Integração Contínua** 
 
[Travis](https://travis-ci.org)
 
[![Build Status](https://travis-ci.org/julianobaldezfreitas/desafio-romano.svg?branch=master)](https://travis-ci.org/julianobaldezfreitas/desafio-romano)
 
**Qualidade do código**
 
[Análise estática do código - Code Inspector](https://www.code-inspector.com/)

https://frontend.code-inspector.com/public/project/5022/desafio-romano/dashboard

[![Code Quality](https://www.code-inspector.com/project/5022/score/svg)](https://frontend.code-inspector.com/public/project/5022/desafio-romano/dashboard)
 
[![Code Quality](https://www.code-inspector.com/project/5022/status/svg)](https://frontend.code-inspector.com/public/project/5022/desafio-romano/dashboard)
 

**Cobertura de Código:**  
 
[CodeCov](https://codecov.io)

[![codecov](https://codecov.io/gh/julianobaldezfreitas/desafio-romano/branch/master/graph/badge.svg)](https://codecov.io/gh/julianobaldezfreitas/desafio-romano)

- Foi utilizado o plugIn FindBugs localmente no Eclipse para análise estática de código. Nenhuma issue reportada.

