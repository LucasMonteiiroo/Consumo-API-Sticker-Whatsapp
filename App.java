import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.net.URL;

public class App {
  public static void main(String[] args) throws Exception {

    // fazer uma conexão HTTP e buscar os top 250 filmes
    String url = "https://imdb-api.com/en/API/Top250Movies/k_dyfy5fen";
    URI endereco = URI.create(url);
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(endereco).GET().build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    String body = response.body();

    // consumir somente os dados que interessam (titulo, poster, classificação)
    var parser = new JsonParser();
    List<Map<String, String>> ListaDeFilmes = parser.parse(body);

    // codigo para listar a quantidade - System.out.println(ListaDeFilmes.size());
    // codigo para listar o primeiro - System.out.println(ListaDeFilmes.get(0));

    // exibir e manipular os dados
    var gerardora = new GerarFigurinhas();
    for (Map<String, String> filme : ListaDeFilmes) {

      String urlImagem = filme.get("image");
      String titulo = filme.get("title");

      InputStream inputStream = new URL(urlImagem).openStream();
      String nomeArquivo = titulo + ".png";

      gerardora.cria(inputStream, nomeArquivo);

      System.out.println(titulo);
      System.out.println();

    }
  }
}
