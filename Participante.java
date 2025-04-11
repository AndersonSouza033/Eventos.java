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

    // Construtor do participante!
    public Participante(String nomeParticipante, String emailParticipante, String senhaParticipante,
        String telefoneParticipante, int idadeParticipante, LocalDate nascimentoParticipante, List<Evento> eventoEscolhido) {
        this.nomeParticipante = nomeParticipante;
        this.emailParticipante = emailParticipante;
        this.senhaParticipante = senhaParticipante;
        this.telefoneParticipante = telefoneParticipante;
        this.idadeParticipante = idadeParticipante;
        this.nascimentoParticipante = nascimentoParticipante;
        this.eventoEscolhido = eventoEscolhido;
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
