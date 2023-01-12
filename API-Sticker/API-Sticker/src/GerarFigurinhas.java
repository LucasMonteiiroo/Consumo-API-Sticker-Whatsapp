import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;

public class GerarFigurinhas {

  public void cria() throws Exception {

    // leitura da imagem
    BufferedImage ImagemOriginal = ImageIO.read(new File("entrada/filmeMaior.jpg"));

    // cira nova imagem em memoria com transparencia e um tamanho novo
    int largura = ImagemOriginal.getWidth();
    int altura = ImagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar a imagem original para a nova imagem, em memoria
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(ImagemOriginal, 0, 0, null);

    // configurar a fonte
    var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setColor(Color.CYAN);
    graphics.setFont(fonte);

    // escrever uma frase na nova imagem
    graphics.drawString("BomDemais", 100, novaAltura - 100);

    // escrever a imagem em um arquivo
    ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
  }

}
