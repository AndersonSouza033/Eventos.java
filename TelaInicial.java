import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

    public TelaInicial() {
        setTitle("Rolézinho Eventos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnOrganizador = new JButton("Entrar como Organizador");
        JButton btnParticipante = new JButton("Entrar como Participante");
        JButton btnCadastrar = new JButton("Cadastrar Participante");
        JButton btnSair = new JButton("Sair");

        btnOrganizador.addActionListener(e -> {
            new TelaLoginOrganizador().setVisible(true);
            dispose();
        });

        btnParticipante.addActionListener(e -> {
            new TelaLoginParticipante().setVisible(true);
            dispose();
        });

        btnCadastrar.addActionListener(e -> {
            new TelaCadastroParticipante().setVisible(true);
            dispose();
        });

        btnSair.addActionListener((ActionEvent e) -> System.exit(0));

        painel.add(btnOrganizador);
        painel.add(btnParticipante);
        painel.add(btnCadastrar);
        painel.add(btnSair);

        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaInicial().setVisible(true));
    }
}