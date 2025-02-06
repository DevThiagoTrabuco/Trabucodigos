import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int codigo = 1;
        boolean quit = false;
        ArrayList<Lanche> lanches = new ArrayList<>();
        
        while(!quit){
            System.out.println("""
                               1 - Cadastrar lanche
                               2 - Listar lanches
                               3 - Comprar lanche
                               4 - Sair""");
            int op = Integer.parseInt(System.console().readLine());
            switch(op){
                case 1 -> {
                    System.out.println("Nome do lanche:");
                    String nome = System.console().readLine();
                    System.out.println("Preço:");
                    double preco = Double.parseDouble(System.console().readLine());
                    System.out.println("URL da imagem:");
                    String img_url = System.console().readLine();
                    /* Apenas nome e formato da imagem (Ex: burguer.jpeg)
                    Imagens na pasta:
                     burguer.jpeg
                     x-bacon.jpeg
                     refrigerante.jpeg
                     cana.jpeg
                     batata.jpeg
                     hotdog.jpeg
                     */
                    try {
                        Path origem = Paths.get("Trabucodigos/Java/Desenvolvimento_de_sistemas/Atividade_Lanche/origem/" + img_url).toAbsolutePath();
                        Path destino = Paths.get("Trabucodigos/Java/Desenvolvimento_de_sistemas/Atividade_Lanche/destino/" + img_url).toAbsolutePath();
                        Files.move(origem, destino, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        System.out.println("Erro ao mover imagem: " + e.getMessage());
                        break;
                    }
                    lanches.add(new Lanche(nome, preco, img_url, codigo++));
                    System.out.println("Lanche cadastrado com sucesso\n");
                }
                case 2 -> {
                    System.out.println("--------------------------------------\n CÓDIGO\tNOME\t\tPRECO\n--------------------------------------");
                    for(Lanche l : lanches){
                        System.out.println(l.getCodigo() + "\t\t" + l.getNome() + "\t\t" + l.getPreco() + "\n");
                    }
                }
                case 3 -> {
                    System.out.println("Digite o código do lanche:");
                    int cod = Integer.parseInt(System.console().readLine());
                    System.out.println("Digite a quantidade:");
                    int qtd = Integer.parseInt(System.console().readLine());
                    for(Lanche l : lanches){
                        if(l.getCodigo() == cod){
                            double valor = l.getPreco() * qtd;
                            String total = String.format("%.2f", valor);
                            System.out.println("Total: R$ " + total);
                            break;
                        }
                    }
                }
                case 4 -> quit = true;
            }
        }
    }
}