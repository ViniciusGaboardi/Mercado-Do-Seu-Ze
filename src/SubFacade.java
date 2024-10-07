import javax.swing.*;
import java.util.Scanner;
public class SubFacade {
    Scanner sc = new Scanner(System.in);
    private Memento meme;
    private SingletonEstoque estoque;
    private SinglentonCadastros cadastros;

    public SubFacade(){
        meme = new Memento();
        estoque = SingletonEstoque.criarEstoque();
        cadastros = SinglentonCadastros.criarCadastro();
    }
    public void CadastrarProduto(){
        System.out.println("//------------// Cadastro de Produto //------------// ");
        System.out.println("Nome do produto:");
        String nome = sc.nextLine();
        System.out.println("Codigo(ID) do produto:");
        String id = sc.nextLine();
        System.out.println("Quantidade em estoque:");
        int quantidade = sc.nextInt();
        System.out.println("Valor do Produto:");
        double preco = sc.nextDouble();
        estoque.AddProduto(new Produto(nome, id, quantidade, preco));
        System.out.println(" //------------// Produto Cadastrado e estocado com sucesso //------------// ");
        sc.nextLine();
    }
    public void CadastrarCliente(){
        System.out.println("//------------// Cadastro de Cliente //------------// ");
        System.out.println("Nome do cliente:");
        String nome = sc.nextLine();
        System.out.println("CPF:");
        int cpf = sc.nextInt();
        sc.nextLine();
        System.out.println("Endereço:");
        String endereco = sc.nextLine();
        System.out.println("Telefone:");
        int telefone = sc.nextInt();
        cadastros.AddCliente(new Cliente(cpf, nome, telefone, endereco));
        System.out.println("//------------// Cliente Cadastrado com sucesso //------------// ");
    }
    public void VerificarEstoque(){
        estoque.VerificacaoDoEstoque();
        System.out.println("\nDeseja adicionar a uma quantidade no estoque \n(1)-SIM\n(2)-NAO");
        int resp = sc.nextInt();
        sc.nextLine();
        if(resp == 1){
            System.out.println("Digite o ID do produto e quantidade que sera adicionada ao estoque ");
            String id = sc.nextLine();
            int quant = sc.nextInt();
            if(estoque.ExisteProduto(id)){
                estoque.Repor(id, quant);
            }else{
                System.out.println("Desculpe, produto nao consta no estoque :( ");
            }
        }else{
            System.out.println("//------------// Verificação do estoque concluida //------------// ");
        }
    }
    public void VerificarCadastros(){
        cadastros.VerificacaoDosCadastros();
    }
    public void RestaurarBackupBin(){//ein espera nao acabei o arquivo
        meme.RecuperaBackupBin();
        System.out.println("//------------// Estoque Importado //------------// ");
    }
    public void FazerBackupBin(){//ein espera nao acabei o arquivo
        meme.FazerBackupBin();
        System.out.println("//------------// Estoque Exportado //------------// ");
    }
    public void RestaurarEstoque(){
        if(meme != null){
            meme.restore();
        }else{
            System.out.println("Nao a estoque salvo, tente recuperar o backup");
        }
        System.out.println("//------------// Estoque Restaurado //------------// ");
    }
    public void CriarBackup(){
        meme = estoque.CriarBackup();
        System.out.println("//------------// Estoque Salvo //------------// ");
    }
}
