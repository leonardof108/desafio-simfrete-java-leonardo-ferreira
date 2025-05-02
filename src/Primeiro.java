import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Primeiro {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("entrada1.txt"));

        Map<String, int[]> faixaCepPorCidade = new HashMap<String, int[]>();

        String linha = br.readLine();

        // lendo até encontrar linha com "--"
        while (!linha.equals("--")) {
            String[] partes = linha.split(",");

            String cidade = partes[0]; // nome da cidade
            int inicio = Integer.parseInt(partes[1]); // começo do CEP
            int fim = Integer.parseInt(partes[2]); // fim do CEP

            faixaCepPorCidade.put(cidade, new int[]{inicio, fim});

            linha = br.readLine(); // próxima linha
        }

        // lê o próximo cep
        String cepLinha = br.readLine();
        int cep = Integer.parseInt(cepLinha);

        boolean achou = false;

        for (String cidade : faixaCepPorCidade.keySet()) {
            int[] faixa = faixaCepPorCidade.get(cidade);
            int inicio = faixa[0];
            int fim = faixa[1];

            if (cep >= inicio && cep <= fim) {
                System.out.println(cidade); // imprime a cidade
                achou = true;
                break;
            }
        }

        if (achou == false) {
            System.out.println("CEP não encontrado em nenhuma faixa."); // se não encontrou
        }

        br.close(); // fecha o arquivo
    }
}
