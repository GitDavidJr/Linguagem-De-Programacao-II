package Listas.Lista6;

import java.io.Serializable;
public class Pessoa implements Comparable<Pessoa>, Serializable {
   private static final long serialVersionUID = 1L;
   
   private String nome;
   private String sobreNome;
   private int idade;
   
   public Pessoa(String nome, String sobreNome, int idade) {
      this.nome = nome;
      this.sobreNome = sobreNome;
      this.idade = idade;
   }
   public String getNome() {
      return nome;
   }
   
   public String getSobreNome() {
      return sobreNome;
   }
      
   public int getIdade() {
      return idade;
   }
   
   // retorno de nome completo (nome + sobrenome)
   public String getNomeCompleto() {
      return nome + " " + sobreNome;
   }
   
   // comparação com outro objeto com base nos respectivos nomes completos
   public int compareTo(Pessoa outraPessoa) {
      return getNomeCompleto().compareTo(outraPessoa.getNomeCompleto());
   }
   
}