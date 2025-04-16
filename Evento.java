// Importando as bibliotecas necessárias!
import java.util.ArrayList;
import java.util.List;

// Definindo meus atributos da classe dos eventos!
public class Evento {
  private String nomeEvento;
  private String codigoEvento;
  private String descricaoEvento;
  private String dataEvento;
  private String localEvento;
  private int capacidadeEvento;
  private boolean ativoEvento;
  private List<Cantor> cantorEscolhido;
  private List<Participante> participantes = new ArrayList<>();

  // Criando método construtor!
  public Evento(String nomeEvento, String codigoEvento, String descricaoEvento, String dataEvento, String localEvento, int capacidadeEvento, boolean ativoEvento, List<Cantor> cantorEscolhido, List<Participante> panticipantes){
    this.nomeEvento = nomeEvento;
    this.codigoEvento = codigoEvento;
    this.descricaoEvento = descricaoEvento;
    this.dataEvento = dataEvento;
    this.localEvento = localEvento;
    this.capacidadeEvento = capacidadeEvento;
    this.ativoEvento = ativoEvento;
    this.cantorEscolhido = cantorEscolhido;
    this.participantes = new ArrayList<>();
  }

  public Evento(String nomeEvento2, String codigoEvento2, String descricaoEvento2, String dataEvento2,
      String localEvento2, int capacidadeEvento2, boolean ativoEvento2, List<Cantor> cantoresSelecionados) {
    //TODO Auto-generated constructor stub
  }

  // Criando Getters (Ler)!
  public String getNome(){
    return nomeEvento;
  }

  public List<Cantor> getCantores(){
    return cantorEscolhido;
  }
  
  public List<Cantor> getCantoresEscolhidos() {
    return this.cantorEscolhido;
}
    
  // Método para editar o evento!
  public void editarEvento(String nomeEvento, String codigoEvento, String descricaoEvento, String dataEvento, String localEvento, int capacidadeEvento) {
    this.nomeEvento = nomeEvento;
    this.codigoEvento = codigoEvento;
    this.descricaoEvento = descricaoEvento;
    this.dataEvento = dataEvento;
    this.localEvento = localEvento;
    this.capacidadeEvento = capacidadeEvento;
  }
    
  // Método para cancelar o evento!
  public void cancelarEvento(){
    this.ativoEvento = false;
  }
    
  // Método para listar!
  @Override
  public String toString() {
    return "Nome: " + nomeEvento +
      "\nCódigo: " + codigoEvento +
      "\nDescrição: " + descricaoEvento +
      "\nData: " + dataEvento +
      "\nLocal: " + localEvento +
      "\nCapacidade: " + capacidadeEvento +
      "\nStatus: " + (ativoEvento ? "Ativo" : "Cancelado") +
      "\nStatus; " + cantorEscolhido +
      "------------------------------------------";
    }

  public void adicionarParticipante(Participante participante) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'adicionarParticipante'");
  }

  public boolean removerParticipante(Participante participante) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removerParticipante'");
  }
}