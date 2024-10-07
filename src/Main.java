import java.util.Scanner;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        int resp = 0;

        SingletonEstoque estoque = SingletonEstoque.criarEstoque();

        /*Produto prod =  new Produto("esponja", "1234", 32,10);
        Produto prod2 = new Produto("vrido", "4321", 300, 432);
        Produto prod3 =  new Produto("Pá", "3200", 2,100);
        Produto prod4 = new Produto("Balas", "2547", 3000, 1.5);
        Produto prod5 =  new Produto("Melancia", "9865", 10,15);
        Produto prod6 = new Produto("Carne", "2222", 11, 10000);
        estoque.AddProduto(prod);
        estoque.AddProduto(prod2);
        estoque.AddProduto(prod3);
        estoque.AddProduto(prod4);
        estoque.AddProduto(prod5);
        estoque.AddProduto(prod6);*/

        Cliente cliente = new Cliente(123456789, "Joao", 32503200, "rua irma dulce");
        SinglentonCadastros cadastros = SinglentonCadastros.criarCadastro();
        cadastros.AddCliente(cliente);

        Facade fachada = new Facade();
        SubFacade fachadinha = fachada.Subfacade();

       /* Memento memento = estoque.CriarBackup();//esse varaivel memento vai ter que ser colocada no facade
        memento.FazerBackup();
        memento.RecuperaBackup();
*/
        do{
            System.out.println("  __  __                              _   _          _                 _                               ____      \n" +
                " |  \\/  |  ___   _ _   __   __ _   __| | (_)  _ _   | |_    ___     __| |  ___     ___  ___   _  _    |_  /  ___ \n" +
                " | |\\/| | / -_) | '_| / _| / _` | / _` | | | | ' \\  | ' \\  / _ \\   / _` | / _ \\   (_-< / -_) | || |    / /  / -_)\n" +
                " |_|  |_| \\___| |_|   \\__| \\__,_| \\__,_| |_| |_||_| |_||_| \\___/   \\__,_| \\___/   /__/ \\___|  \\_,_|   /___| \\___| V3.00.13.14\n\n");
            System.out.println("BEM VINDO!!");
            System.out.println("///----//-------------------------COMANDOS-------------------------//----///");

            System.out.println("(1)-Realizar Uma Venda\n(2)-Ir para o Sub-Sistema\n(0)-Para sair do programa");
            resp = sc.nextInt();
            switch(resp){
                case(1):{
                    fachada.RealizarVenda();
                    break;
                }
                case(2):{
                    System.out.println("///----//-------------------------Sub-Sistema-------------------------//----///");
                    System.out.println("(1)-Cadastrar um Produto\n(2)-Cadastrar um Cliente\n(3)-Verificar Estoque\n(4)-Verificar Cadastros\n(5)-Criar Backup do estoque\n(6)-Restaurar backup do estoque\n(7)-Exportar Backup\n(8)-Importar Backup");
                    int resp1 = sc.nextInt();
                    switch (resp1){
                        case(1):{
                            fachadinha.CadastrarProduto();
                            break;
                        }
                        case(2):{
                            fachadinha.CadastrarCliente();
                            break;
                        }
                        case(3):{
                            fachadinha.VerificarEstoque();
                            break;
                        }
                        case(4):{
                            fachadinha.VerificarCadastros();
                            break;
                        }
                        case(5):{
                            fachadinha.CriarBackup();
                            break;
                        }
                        case(6):{
                            fachadinha.RestaurarEstoque();
                            break;
                        }
                        case(7):{
                            fachadinha.FazerBackupBin();
                            break;
                        }
                        case(8):{
                            fachadinha.RestaurarBackupBin();
                            break;
                        }
                    }
                    break;
                }
            }
        }while(resp!=0);



         /*memento.RecuperaBackup();
          memento.restore();
        System.out.println(estoque.VerificacaoDoEstoque());*/

    }
}