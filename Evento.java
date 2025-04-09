// Definindo meus atributos da classe dos eventos!
public class Evento {
    private String nomeEvento;
    private String codigoEvento;
    private String descricaoEvento;
    private String dataEvento;
    private String localEvento;
    private int capacidadeEvento;
    private boolean ativoEvento;
    
    public Evento(String nomeEvento, String codigoEvento, String descricaoEvento, String dataEvento, String localEvento, int capacidadeEvento, boolean ativoEvento) {
        this.nomeEvento = nomeEvento;
        this.codigoEvento = codigoEvento;
        this.descricaoEvento = descricaoEvento;
        this.dataEvento = dataEvento;
        this.localEvento = localEvento;
        this.capacidadeEvento = capacidadeEvento;
        this.ativoEvento = true;
    }
    
    // Método para editar o evento!
    public void editar(String nomeEvento, String codigoEvento, String descricaoEvento, String dataEvento, String localEvento, int capacidadeEvento) {
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
    @Override
    public String toString() {
        return "Nome: " + nomeEvento +
               "\nCódigo: " + codigoEvento +
               "\nDescrição: " + descricaoEvento +
               "\nData: " + dataEvento +
               "\nLocal: " + localEvento +
               "\nCapacidade: " + capacidadeEvento +
               "\nStatus: " + (ativoEvento ? "Ativo" : "Cancelado");
    }
}