// Importando as bibliotecas necessárias!
import java.time.LocalDate;
import java.util.List;

// Definindo meus atributos da classe dos participantes!
public class Participante {
  private String nomeParticipante;
  private String emailParticipante;
  private String senhaParticipante;
  private String telefoneParticipante;
  private int idadeParticipante;
  private LocalDate nascimentoParticipante;
  private List<Evento> eventoEscolhido;

  // Método construtor!
  public Participante(String nomeParticipante, String emailParticipante, String senhaParticipante, String telefoneParticipante, int idadeParticipante, LocalDate nascimentoParticipante, List<Evento> eventoEscolhido) {
    this.nomeParticipante = nomeParticipante;
    this.emailParticipante = emailParticipante;
    this.senhaParticipante = senhaParticipante;
    this.telefoneParticipante = telefoneParticipante;
    this.idadeParticipante = idadeParticipante;
    this.nascimentoParticipante = nascimentoParticipante;
    this.eventoEscolhido = eventoEscolhido;
  }

  // Método para editar participante!
  public void editarParticipante(String nomeParticipante, String senhaParticipante, String telefoneParticipante, int idadeParticipante, LocalDate nascimentoParticipante){
    this.nomeParticipante = nomeParticipante;
    this.senhaParticipante = senhaParticipante;
    this.telefoneParticipante = telefoneParticipante;
    this.idadeParticipante = idadeParticipante;
    this.nascimentoParticipante = nascimentoParticipante;
  }

  // Criando Getters (Ler)!
  public String getSenha(){
    return senhaParticipante;
  }
    
  public String getEmail() {
    return emailParticipante;
  }

  public String getNome() {
    return nomeParticipante;
  }

  public List<Evento> getEventosEscolhidos() {
    return eventoEscolhido;
  }

  // Criando Setters (Alterar)!
  public void setNome(String nome) {
    this.nomeParticipante = nome;
  }

  public void setTelefone(String telefone) {
    this.telefoneParticipante = telefone;
  }

  public void setSenha(String senha) {
    this.senhaParticipante = senha;
  }

  // Método para exibir os dados do participante!
  @Override
  public String toString() {
    return "Nome: " + nomeParticipante +
    "\nE-mail: " + emailParticipante +
    "\nTelefone: " + telefoneParticipante +
    "\nIdade: " + idadeParticipante +
    "\nData de Nascimento: " + nascimentoParticipante;
  }
}
