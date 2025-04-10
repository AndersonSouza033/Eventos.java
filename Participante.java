// Importando as bibliotecas necessárias!
import java.time.LocalDate;

// Definindo meus atributos da classe dos participantes!
public class Participante {
    private String nomeParticipante;
    private String emailParticipante;
    private String senhaParticipante;
    private String telefoneParticipante;
    private int idadeParticipante;
    private LocalDate nascimentoParticipante;

    // Construtor do participante!
    public Participante(String nomeParticipante, String emailParticipante, String senhaParticipante,
        String telefoneParticipante, int idadeParticipante, LocalDate nascimentoParticipante) {
        this.nomeParticipante = nomeParticipante;
        this.emailParticipante = emailParticipante;
        this.senhaParticipante = senhaParticipante;
        this.telefoneParticipante = telefoneParticipante;
        this.idadeParticipante = idadeParticipante;
        this.nascimentoParticipante = nascimentoParticipante;
    }

    // Criando Getters (Ler)!
    public String getSenhap(){
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
