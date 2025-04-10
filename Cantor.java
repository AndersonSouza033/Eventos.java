// Definindo meus atributos da classe dos cantores!
public class Cantor{
    private String nomeCantor;
    private String emailCantor;
    private String idadeCantor;
    private String telefoneCantor;
    private boolean ativoCantor;
    
    public Cantor(String nomeCantor, String emailCantor, String idadeCantor, String telefoneCantor, boolean ativoCantor){
        this.nomeCantor = nomeCantor;
        this.emailCantor = emailCantor;
        this.idadeCantor = idadeCantor;
        this.telefoneCantor = telefoneCantor;
        this.ativoCantor = true;
    }
    @Override
    public String toString() {
        return "Nome: " + nomeCantor +
            "\nE-mail: " + emailCantor +
            "\nIdade: " + idadeCantor +
            "\nTelefone: " + telefoneCantor +
            "\nAtivo: " + ativoCantor ;       
    }
}

