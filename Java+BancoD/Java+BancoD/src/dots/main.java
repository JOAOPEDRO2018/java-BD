
package dots;

import model.Fornecedor;
import model.FornecedorBD;

public class main {
     public static void main(String[] args){
         ConexaoBD link = new ConexaoBD();
         link.conectarComDB();
         Fornecedor fo = new Fornecedor(45,"latislau");
         
         FornecedorBD f = new FornecedorBD();
         f.cadastrarfornecedor(fo);
         //f.excluirFornecedor(fo); 
         f.setIdReferencia(45);
         fo.setNome("josoares");
         f.editarFornecedor(fo);
     }
}
