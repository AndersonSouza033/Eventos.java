import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MenuParticipante extends JFrame {

    private Participante participante;

    public MenuParticipante(Participante participante) {
        this.participante = participante;

        setTitle("Menu - Participante");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(5, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnVerEventos = new JButton("Ver eventos disponíveis");
        JButton btnInscreverEvento = new JButton("Inscrever em eventos");
        JButton btnCancelarInscricao = new JButton("Cancelar inscrição");
        JButton btnEditarDados = new JButton("Editar meus dados");
        JButton btnVoltar = new JButton("Voltar ao menu principal");

        btnVerEventos.addActionListener((ActionEvent e) -> listarEventos());
        btnInscreverEvento.addActionListener((ActionEvent e) -> inscreverEvento());
        btnCancelarInscricao.addActionListener((ActionEvent e) -> cancelarInscricao());
        btnEditarDados.addActionListener((ActionEvent e) -> editarDados());
        btnVoltar.addActionListener((ActionEvent e) -> voltarMenuPrincipal());

        painel.add(btnVerEventos);
        painel.add(btnInscreverEvento);
        painel.add(btnCancelarInscricao);
        painel.add(btnEditarDados);
        painel.add(btnVoltar);

        add(painel);
    }

    private void listarEventos() {
        List<Evento> eventos = BancoDeDados.getEventos();
        if (eventos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há eventos disponíveis.");
            return;
        }

        StringBuilder eventosStr = new StringBuilder("Eventos disponíveis:\n");
        for (Evento evento : eventos) {
            eventosStr.append(evento.getNome()).append("\n");
        }

        JOptionPane.showMessageDialog(this, eventosStr.toString());
    }

    private void inscreverEvento() {
        String nomeEvento = JOptionPane.showInputDialog(this, "Digite o nome do evento para se inscrever:");
        Evento eventoEscolhido = null;

        for (Evento evento : BancoDeDados.getEventos()) {
            if (evento.getNome().equalsIgnoreCase(nomeEvento)) {
                eventoEscolhido = evento;
                break;
            }
        }

        if (eventoEscolhido != null) {
            eventoEscolhido.adicionarParticipante(participante);
            JOptionPane.showMessageDialog(this, "Você foi inscrito no evento: " + eventoEscolhido.getNome());
        } else {
            JOptionPane.showMessageDialog(this, "Evento não encontrado.");
        }
    }

    private void cancelarInscricao() {
        String nomeEvento = JOptionPane.showInputDialog(this, "Digite o nome do evento para cancelar a inscrição:");
        Evento eventoEscolhido = null;

        for (Evento evento : BancoDeDados.getEventos()) {
            if (evento.getNome().equalsIgnoreCase(nomeEvento)) {
                eventoEscolhido = evento;
                break;
            }
        }

        if (eventoEscolhido != null && eventoEscolhido.removerParticipante(participante)) {
            JOptionPane.showMessageDialog(this, "Você foi removido do evento: " + eventoEscolhido.getNome());
        } else {
            JOptionPane.showMessageDialog(this, "Você não está inscrito nesse evento.");
        }
    }

    private void editarDados() {
        String novoNome = JOptionPane.showInputDialog(this, "Digite seu novo nome:");
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            participante.setNome(novoNome);
            JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Nome inválido.");
        }
    }

    private void voltarMenuPrincipal() {
        new TelaInicial().setVisible(true);
        dispose();
    }
}
