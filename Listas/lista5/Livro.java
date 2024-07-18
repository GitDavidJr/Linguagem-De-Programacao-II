//Esulamento de dados típicos de livro
public class Livro {
// atributos
private String titulo; // título
private String autores; // lista de autores separados por vírgula
private int edicao; // número de edição (inteiro igual ou superior a 1)
private int ano; // ano de edição (inteiro positivo de 4 dígitos)
// método construtor
public Livro(String titulo, String autores, int edicao, int ano) {
this.titulo = titulo;
this.autores = autores;
this.edicao = edicao;
this.ano = ano;
}
// métodos getters e setters
public String getTitulo() {
return titulo;
}
public void setTitulo(String titulo) {
this.titulo = titulo;
}
public String getAutores() {
return autores;
}
public void setAutores(String autores) {
this.autores = autores;
}
public int getEdicao() {
return edicao;
}
public void setEdicao(int edicao) {
this.edicao = edicao;
}
public int getAno() {
return ano;
}
public void setAno(int ano) {
this.ano = ano;
}
// retorno de descrição de livro considerando-se seu estado atual
@Override
public String toString() {
return "Livro [titulo=" + titulo + ", autores=" + autores + ", edicao=" + edicao +
", ano=" + ano + "]";
}
}