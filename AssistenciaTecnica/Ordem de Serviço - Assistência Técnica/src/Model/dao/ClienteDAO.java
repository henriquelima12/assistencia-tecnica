package Model.dao;

import Connection.ConnectionFactory;
import Model.bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class ClienteDAO {
    
    public boolean checklogin(String nomecli, String cpf){
         Connection con = ConnectionFactory.getConnection();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         boolean check = false;
         
        try {
            stmt = con.prepareStatement("SELECT * FROM clientes where nomecli = ? and cpf = ?");
            stmt.setString(1, nomecli);
            stmt.setString(2, cpf);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
            check = true;
           
               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }
            

    
    public void adicionar(Cliente clientes){
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;       
        
        String sql = "INSERT INTO clientes(nomecli, endcli, cpf, emailcli) VALUES(? ,?, ?, ?)";
        
        try {
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1,clientes.getNomecli());
            stmt.setString(2,clientes.getEndcli());
            stmt.setString(3,clientes.getCpf());
            stmt.setString(4,clientes.getEmailcli());
           
            
            
            stmt.executeUpdate(); 
            
        } catch (SQLException ex) {
            System.err.println("Erro ao cadastrar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }     
    }
    
    public List<Cliente> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();
                                
                cliente.setNomecli(rs.getString("nomecli"));
                cliente.setEndcli(rs.getString("endcli"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmailcli(rs.getString("emailcli"));
              
                
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;

    }
    public List<Cliente> readForDesc(String desc) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes WHERE nomecli LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();
                                
                cliente.setNomecli(rs.getString("nomecli"));
                cliente.setEndcli(rs.getString("endcli"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmailcli(rs.getString("emailcli"));
               
                
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;

    }
    
    public void atualizar(Cliente cliente){
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;       
        
        String sql = "UPDATE clientes SET nomecli = ?, endcli = ?, cpf = ?, emailcli = ? WHERE nomecli = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1,cliente.getNomecli());
            stmt.setString(2,cliente.getEndcli());
            stmt.setString(3,cliente.getCpf());
            stmt.setString(4,cliente.getEmailcli());        
            stmt.setString(5,cliente.getNomecli());
            
            stmt.executeUpdate();  
            
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }     
    }
    public void deletar(Cliente cliente){
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;       
        
        String sql = "DELETE FROM clientes  WHERE nomecli = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1, cliente.getNomecli());
            
            stmt.executeUpdate();  
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }     
    }
    
    
}

