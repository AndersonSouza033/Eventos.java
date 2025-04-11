// Definindo meus atributos da classe dos cantores!
public class Cantor{
  private String nomeCantor;
  private String emailCantor;
  private String idadeCantor;
  private String telefoneCantor;
  private boolean ativoCantor;
    
    
  // Método construtor!
  public Cantor(String nomeCantor, String emailCantor, String idadeCantor, String telefoneCantor, boolean ativoCantor){
    this.nomeCantor = nomeCantor;
    this.emailCantor = emailCantor;
    this.idadeCantor = idadeCantor;
    this.telefoneCantor = telefoneCantor;
    this.ativoCantor = true;
  }
    
  // Método editar cantor!
  public void editarCantor(String nomeCantor, String emailCantor, String idadeCantor, String telefoneCantor){
    this.nomeCantor = nomeCantor;
    this.emailCantor = emailCantor;
    this.idadeCantor = idadeCantor;
    this.telefoneCantor = telefoneCantor;
    }
      
  // Método para listar!
  @Override
  public String toString() {
    return "Nome: " + nomeCantor +
      "\nE-mail: " + emailCantor +
      "\nIdade: " + idadeCantor +
      "\nTelefone: " + telefoneCantor +
      "\nAtivo: " + ativoCantor ;       
    }
}
