package Model.dao;

import Connection.ConnectionFactory;
import Model.bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.TelaPrincipal;



public class UsuarioDAO {
    
    public boolean checklogin(String login, String senha){
         Connection con = ConnectionFactory.getConnection();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         boolean check = false;
         
        try {
            stmt = con.prepareStatement("SELECT * FROM usuarios where login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
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
   
    
 
    public void adicionar(Usuario usuario){
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;       
        
        String sql = "INSERT INTO usuarios(nome, fone, login, senha) VALUES(? ,?, ?, ?)";
        
        try {
            stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1,usuario.getNome());
            stmt.setString(2,usuario.getFone());
            stmt.setString(3,usuario.getLogin());
            stmt.setString(4,usuario.getSenha());
            
            
          
            
            stmt.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            System.err.println("Erro ao cadastrar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }     
    }
    
    public List<Usuario> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuarios");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();
                                
              
                usuario.setNome(rs.getString("nome"));
                usuario.setFone(rs.getString("fone"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                
                
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return usuarios;

    }
    public List<Usuario> readForDesc(String desc) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuarios WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();
                
                              
                usuario.setNome(rs.getString("nome"));
                usuario.setFone(rs.getString("fone"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                
                
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return usuarios;

    }
    
    public void atualizar(Usuario usuario){
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;       
        
        String sql = "UPDATE usuarios SET nome = ?, fone = ?, login = ?, senha = ?  WHERE nome = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1,usuario.getNome());
            stmt.setString(2,usuario.getFone());
            stmt.setString(3,usuario.getLogin());
            stmt.setString(4,usuario.getSenha());         
            stmt.setString(5, usuario.getNome());
           
            
            stmt.executeUpdate();  
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }     
    }
    public void deletar(Usuario usuario){
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;       
        
        String sql = "DELETE FROM usuarios WHERE nome = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1, usuario.getNome());
            
            stmt.executeUpdate();  
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }     
    }

    public Iterable<Usuario> read(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
