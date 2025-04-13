import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    // Criando as listas necessárias para armazenar os dados de cada classe!
    private static List<Evento> eventos = new ArrayList<>();
    private static List<Cantor> cantores = new ArrayList<>();
    private static List<Participante> participantes = new ArrayList<>();
    
    // Participante de teste para login
    static {
        participantes.add(new Participante("Anderson Souza", "andersonsouzapcb@gmail.com", "1234","9999-9999", 20, LocalDate.of(2004, 1, 1), new ArrayList<Evento>()));
    }

    public static List<Evento> getEventos() {
        return eventos;
    }

    public static List<Cantor> getCantores() {
        return cantores;
    }

    public static List<Participante> getParticipantes() {
        return participantes;
    }

    public static void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }
    
    public static void adicionarCantor(Cantor cantor) {
        cantores.add(cantor);
    }
    
    public static void adicionarParticipante(Participante participante) {
        participantes.add(participante);
    }
    
    public static Participante buscarParticipantePorEmail(String email) {
        for (Participante p : participantes) {
            if (p.getEmail().equalsIgnoreCase(email)) {
                return p;
            }
        }
        return null;
    }
    

}
