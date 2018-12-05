/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorio;

import java.sql.Connection;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Juninho
 */
public class VisualizaRelatorioSaida {
     private Connection conn;
    
    public VisualizaRelatorioSaida() throws Exception{
        try{
            this.conn = ConexaoRel.getConnection();
            
        }catch (Exception e){
            throw new Exception("Erro: \n" +e.getMessage());
        }
    }
    
    public void visualizar(){
        try {
            String arquivo = System.getProperty("user.dir") + "\\src\\Relatorio\\relatorioSaida.jasper";
            JasperPrint jp = JasperFillManager.fillReport(arquivo, null, conn);
            JasperViewer.viewReport(jp, false);
        }catch (JRException e){
            e.printStackTrace();
        }finally{
            try{
                if (!conn.isClosed()){
                    conn.close();
                }
            }catch(SQLException ex){}
        }
    }
}
