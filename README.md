# Desafio do processo seletivo da Simfrete feito em Java


## Instruções e premissas

- O código desenvolvido deve ser escrito totalmente pelo candidato; a cópia de código da internet
  e o uso de inteligência artificial generativa são desqualificadores imediatos.
- Os critérios de avaliação das soluções são, em ordem: corretude,
  clareza, velocidade de execução, e uso de memória.
 

## Desafios

Usando a sua linguagem de programação preferida solucione os seguintes desafios:

### Parte 1
Crie um programa que lê de um arquivo uma lista de cidades e as faixas de CEP que as compõe,
e responde a qual cidade um CEP pertence.

O arquivo de entrada é composto por linhas com um nome de cidade, um CEP inicial, e
um CEP final separados por vírgula, então uma linha com dois traços "--" e por fim
um CEP. O seu programa então deve responder o nome da cidade ao qual esse CEP pertence.

### Parte 2
Crie um programa que lê de um arquivo uma lista de nomes de cidades
adjacentes e o custo de transporte entre elas, e calcula o
menor custo entre duas cidades não adjacentes.


O arquivo de entrada é composto por linhas com um nome de cidade, um CEP inicial, e
um CEP final separados por vírgula, então uma linha com dois traços "--".
Seguidos de linhas com dois nomes de cidade e um número representando o custo
de transportar uma mercadoria da primeira cidade até a segunda, então uma linha com
dois traços "--". Finalmente deve receber uma linha com dois CEPs.
O seu program deve então responder com a rota mais barata para transportar
uma mercadoria entre o primeiro e o segundo CEP dá ultima linha da entrada, e
o custo total desta rota.


## ▶️ Como Executar

### Compilar:

```bash
javac Primeiro.java
javac Segundo.java
```

### Executar:

```bash
java Primeiro
java Segundo
```

Os arquivos `entrada1.txt` ou `entrada2.txt` devem estar no mesmo diretório com o formato certo.

---

## Notas adicionais

Desafios durante o desafio:

Manipulação de arquivos: Ler arquivos linha por linha usando BufferedReader, e quando parar a leitura no separador (--).

Organização: Como armazenar as faixas de CEP e as conexões entre cidades. Após estudar exemplos e documentação, decidi usar HashMap e listas aninhadas.

Implementação de Dijkstra: Estudei lógica de tutoriais e pseudocódigos. Foi desafiador lidar com a PriorityQueue em Java.

## Fonter consultadas durante o desafio:

Stack Overflow (solução de erros de compilação)

Tutoriais no YouTube e na internet

Documentação oficial do Java

---

[Java Read File: Complete Guide with Examples](https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line)\
[Java HashMap](https://www.w3schools.com/java/java_hashmap.asp)\
[Dijkstra’s shortest path algorithm in Java using PriorityQueue](https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue)\
[Dijkstra Shortest Path Algorithm in Java](https://www.baeldung.com/java-dijkstra)\
[Shortest Path | Dijkstra's Algorithm Explained and Implemented in Java | Graph Theory | Geekific](https://www.youtube.com/watch?v=BuvKtCh0SKk)\


---

## Sobre Mim

Sou um desenvolvedor em início de carreira, focado em desenvolvimento Java backend. Agradeço a oportunidade de realizar este desafio e estou aberto a qualquer sugestão ou feedback!
