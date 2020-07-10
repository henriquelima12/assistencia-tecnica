package Model.bean;


public class Usuario {
    
    private int iduser;
    private String nome;
    private String fone;
    private String login;
    private String senha;
    

    public Usuario() {
    }

    public Usuario(String nome, String fone, String login, String senha ) {       
        this.nome = nome;
        this.fone = fone;
        this.login = login;
        this.senha = senha;
        
    }       

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

   
}
