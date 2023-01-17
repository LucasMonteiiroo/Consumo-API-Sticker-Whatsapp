import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
//import java.net.URL;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;

public class GerarFigurinhas {

  public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

    // leitura da imagem
    // InputStream inputStream = new FileInputStream(new
    // File("entrada/filmeMaior"));
    // File("entrada/filmeMaior.jpg"));
    // InputStream inputStream = new
    // URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
    // .openStream();
    BufferedImage ImagemOriginal = ImageIO.read(inputStream);

    // cira nova imagem em memoria com transparencia e um tamanho novo
    int largura = ImagemOriginal.getWidth();
    int altura = ImagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar a imagem original para a nova imagem, em memoria
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(ImagemOriginal, 0, 0, null);

    // configurar a fonte
    var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 24);
    graphics.setColor(Color.CYAN);
    graphics.setFont(fonte);

    // escrever uma frase na nova imagem
    graphics.drawString("BomDemais", 100, novaAltura - 100);

    // escrever a imagem em um arquivo
    ImageIO.write(novaImagem, "png", new File(nomeArquivo));
  }

}
