package pi.dados;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import pi.entidades.Documento;

public class TestaDocumentoDAO {

    public static void main(String[] args) throws DadosException {
        DocumentoDAO dao = new DocumentoDAO();

        List<Documento> lista = dao.listar();
        for (Documento documento : lista) {
            System.out.println(documento);
        }

        Documento novo = new Documento();
        novo.setTitulo("Q Projeto Legal, Kappa");
        novo.setLocal("Disneylândia");
        novo.setData("10/04/2037");
        novo.setHorario("10:45");
        novo.setAssunto("Passar no PI");
        novo.setClassificacao(5);
        novo.setEncaminhamento("Professor Cícero");
        
        dao.inserir(novo);
        
        Documento consulta = dao.consultar(1);
        System.out.println("----------------------");
        System.out.println(consulta);
        
//        dao.excluir(consulta);

    }
}
