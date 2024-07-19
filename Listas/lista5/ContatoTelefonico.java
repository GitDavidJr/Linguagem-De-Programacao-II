// Encapsulamento de dados típicos de contato telefônico
public class ContatoTelefonico {
    // constantes para fins de indicação de categorias de contatos
    public static final int FAMILIAR = 0;
    public static final int PROFISSIONAL = 1;
    public static final int OUTROS = 2;
    
    // atributos
    private String nome;         // primeiro nome
    private String sobrenome;    // sobrenome
    private String email;        // endereço de e-mail
    private int codigoPais;      // código telefônico de país
    private String telefone;     // número telefônico
    private int categoria;       // categoria (familiar, profissional ou outros)
    
    // método construtor
    public ContatoTelefonico(String nome, String sobrenome, String email, int codigoPais,
                             String telefone, int categoria) throws IllegalArgumentException {
       // se categoria não corresponder a alguma das constantes definidas anteriormente...
       if (categoria != FAMILIAR && categoria != PROFISSIONAL && categoria != OUTROS) {
          // lançamento de exceção
          throw new IllegalArgumentException("Tipo de contato inválido!");         
       }
       
       this.nome = nome;
       this.sobrenome = sobrenome;
       this.email = email;
       this.codigoPais = codigoPais;
       this.telefone = telefone;
       this.categoria = categoria;
    }
    // métodos getters e setters
    public String getNome() {
       return nome;
    }
    public void setNome(String nome) {
       this.nome = nome;
    }
    public String getSobrenome() {
       return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
       this.sobrenome = sobrenome;
    }
    public String getEmail() {
       return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getCodigoPais() {
       return codigoPais;
    }
    public void setCodigoPais(int codigoPais) {
       this.codigoPais = codigoPais;
    }
    public String getTelefone() {
       return telefone;
    }
    public void setTelefone(String telefone) {
       this.telefone = telefone;
    }
    public int getCategoria() {
       return categoria;
    }
    public void setCategoria(int categoria) {
       this.categoria = categoria;
    }
    // retorno de descrição de contato telefônico considerando-se seu estado atual
    @Override
    public String toString() {
       return "ContatoTelefonico [nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", codigoPais=" + codigoPais + ", telefone=" + telefone + ", categoria=" + categoria + "]";
    }
 }