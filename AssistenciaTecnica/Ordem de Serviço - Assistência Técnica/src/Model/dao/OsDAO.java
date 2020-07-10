/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Connection.ConnectionFactory;
import Model.bean.OS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author teonilia
 */
public class OsDAO {
    
    public void adicionar(OS os){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;       
        
        String sql = "INSERT INTO os(tipo, situacao, equipamento, defeito, servico, tecnico, valor, nomecli) VALUES(? ,?, ?, ?, ?, ?, ?, ?)";
        
         try {
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, os.getTipo());
            stmt.setString(2, os.getSituacao());
            stmt.setString(3,os.getEquipamento());
            stmt.setString(4,os.getDefeito());
            stmt.setString(5,os.getServico());
            stmt.setString(6,os.getTecnico());
            stmt.setInt(7,os.getValor());
            stmt.setString(8, os.getNomecli());
            
           
            
            
            stmt.executeUpdate(); 
            
        } catch (SQLException ex) {
            System.err.println("Erro ao cadastrar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }     
    }
    public List<OS> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<OS> os = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM os");
            rs = stmt.executeQuery();

            while (rs.next()) {

                OS ordem = new OS();
                                
               
                ordem.setOs((rs.getInt("ordem_servico")));
                ordem.setTipo((rs.getString("tipo")));
                ordem.setSituacao((rs.getString("situacao")));
                ordem.setEquipamento(rs.getString("equipamento"));
                ordem.setDefeito(rs.getString("defeito"));
                ordem.setServico(rs.getString("servico"));
                ordem.setTecnico(rs.getString("tecnico"));
                ordem.setValor(rs.getInt("valor"));
                ordem.setNomecli(rs.getString("nomecli"));
                
              
                
                os.add(ordem);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return os;

    }
    public List<OS> readForDesc(String desc) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<OS> os = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM os WHERE nomecli LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                OS ordem = new OS();
                                
               
                ordem.setOs((rs.getInt("ordem_servico")));
                ordem.setTipo((rs.getString("tipo")));
                ordem.setSituacao((rs.getString("situacao")));
                ordem.setEquipamento(rs.getString("equipamento"));
                ordem.setDefeito(rs.getString("defeito"));
                ordem.setServico(rs.getString("servico"));
                ordem.setTecnico(rs.getString("tecnico"));
                ordem.setValor(rs.getInt("valor"));
                ordem.setNomecli(rs.getString("nomecli"));
               
                
                os.add(ordem);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return os;

    }
    public void atualizar(OS os){
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;       
        
        String sql = "UPDATE os SET tipo = ?, situacao = ?, equipamento = ?, defeito = ?, servico = ?, tecnico = ?, valor = ?, nomecli = ?  WHERE ordem_servico = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, os.getTipo());
            stmt.setString(2, os.getSituacao());
            stmt.setString(3,os.getEquipamento());
            stmt.setString(4,os.getDefeito());
            stmt.setString(5,os.getServico());
            stmt.setString(6,os.getTecnico());
            stmt.setInt(7,os.getValor());
            stmt.setString(8, os.getNomecli());
            stmt.setInt(9, os.getOs());
            
            stmt.executeUpdate();  
            
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }     
    }
       public void deletar(OS os){
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;       
        
        String sql = "DELETE FROM os WHERE ordem_servico = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            
            
            stmt.setInt(1, os.getOs());
            
            stmt.executeUpdate();  
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }     
    }

        
}
