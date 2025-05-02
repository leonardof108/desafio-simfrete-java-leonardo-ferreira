import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Segundo {

    // classe para representar ligação entre cidades
    static class Aresta {
        String destino;
        double custo;

        Aresta(String destino, double custo) {
            this.destino = destino;
            this.custo = custo;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("entrada2.txt"));

        Map<String, int[]> faixaCepPorCidade = new HashMap<String, int[]>();

        String linha = br.readLine();

        // lê as faixas de CEP
        while (!linha.equals("--")) {
            String[] partes = linha.split(",");

            String cidade = partes[0];
            int inicio = Integer.parseInt(partes[1]);
            int fim = Integer.parseInt(partes[2]);

            faixaCepPorCidade.put(cidade, new int[]{inicio, fim});

            linha = br.readLine();
        }

        Map<String, List<Aresta>> grafo = new HashMap<String, List<Aresta>>();

        linha = br.readLine();

        // lê as conexões entre cidades
        while (!linha.equals("--")) {
            String[] partes = linha.split(",");

            String origem = partes[0];
            String destino = partes[1];
            double custo = Double.parseDouble(partes[2]);

            if (!grafo.containsKey(origem)) {
                grafo.put(origem, new ArrayList<Aresta>());
            }
            if (!grafo.containsKey(destino)) {
                grafo.put(destino, new ArrayList<Aresta>());
            }

            grafo.get(origem).add(new Aresta(destino, custo));
            grafo.get(destino).add(new Aresta(origem, custo)); // grafo bidirecional

            linha = br.readLine();
        }

        // pega os ceps da última linha
        String[] ceps = br.readLine().split(",");
        int cepOrigem = Integer.parseInt(ceps[0]);
        int cepDestino = Integer.parseInt(ceps[1]);

        String cidadeOrigem = buscarCidade(faixaCepPorCidade, cepOrigem);
        String cidadeDestino = buscarCidade(faixaCepPorCidade, cepDestino);

        if (cidadeOrigem == null || cidadeDestino == null) {
            System.out.println("Alguma cidade não foi encontrada.");
            return;
        }

        // Dijkstra
        Map<String, Double> dist = new HashMap<String, Double>();
        Map<String, String> anterior = new HashMap<String, String>();
        PriorityQueue<String> fila = new PriorityQueue<String>(new Comparator<String>() {
            public int compare(String a, String b) {
                return Double.compare(dist.get(a), dist.get(b));
            }
        });

        for (String c : grafo.keySet()) {
            dist.put(c, Double.POSITIVE_INFINITY);
        }

        dist.put(cidadeOrigem, 0.0);
        fila.add(cidadeOrigem);

        while (!fila.isEmpty()) {
            String atual = fila.poll();

            List<Aresta> vizinhos = grafo.get(atual);
            if (vizinhos != null) {
                for (Aresta aresta : vizinhos) {
                    double novaDist = dist.get(atual) + aresta.custo;
                    if (novaDist < dist.get(aresta.destino)) {
                        dist.put(aresta.destino, novaDist);
                        anterior.put(aresta.destino, atual);

                        fila.remove(aresta.destino);
                        fila.add(aresta.destino);
                    }
                }
            }
        }

        // imprime o caminho
        if (!dist.containsKey(cidadeDestino) || dist.get(cidadeDestino) == Double.POSITIVE_INFINITY) {
            System.out.println("Não há caminho possível.");
        } else {
            List<String> caminho = new ArrayList<String>();
            String atual = cidadeDestino;
            while (atual != null) {
                caminho.add(atual);
                atual = anterior.get(atual);
            }

            Collections.reverse(caminho);
            System.out.println("Rota: " + String.join(" -> ", caminho));
            System.out.printf("Custo total: %.2f\n", dist.get(cidadeDestino));
        }

        br.close(); // fecha o buffer
    }

    public static String buscarCidade(Map<String, int[]> mapa, int cep) {
        for (String cidade : mapa.keySet()) {
            int[] faixa = mapa.get(cidade);
            if (cep >= faixa[0] && cep <= faixa[1]) {
                return cidade;
            }
        }
        return null;
    }
}
