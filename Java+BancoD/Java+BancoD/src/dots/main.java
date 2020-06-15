
package dots;

import model.Fornecedor;
import model.FornecedorBD;
import model.Produtos;
import model.produtosBD;

public class main {
     public static void main(String[] args){
         ConexaoBD link = new ConexaoBD();
         link.conectarComDB();
         Fornecedor fo = new Fornecedor(4,"latislu", "senha");         
         FornecedorBD f = new FornecedorBD();
         Produtos po = new Produtos(10, "carne", 20.0,fo);
         produtosBD p = new produtosBD();
         f.excluirFornecedor(fo);
         f.cadastrarfornecedor(fo);
         p.addProduto(po);
         
         
         
          
         
     }
}
