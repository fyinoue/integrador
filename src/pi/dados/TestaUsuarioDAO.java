package pi.dados;

import java.util.List;
import pi.entidades.Usuario;

public class TestaUsuarioDAO {
    public static void main(String[] args) throws DadosException{
        UsuarioDAO dao = new UsuarioDAO();
        
        List<Usuario> lista = dao.listar();
        for(Usuario usuario : lista){
            System.out.println(usuario);
        }
        
        Usuario novo = new Usuario();
        novo.setLogin("matheus5437");
        novo.setSenha("10111998");
        novo.setId_usuario(2);
        
//        dao.inserir(novo);
        
        Usuario consulta = dao.consultar(2);
        System.out.println("----------------------");
        System.out.println(consulta);
        
//        dao.excluir(consulta);
        
//        dao.alterar(novo);
        
    }
}
