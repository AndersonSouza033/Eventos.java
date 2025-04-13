import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuOrganizador extends JFrame {

    public MenuOrganizador() {
        setTitle("Menu - Organizador");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(4, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnEventos = new JButton("Dados do Evento");
        JButton btnCantores = new JButton("Dados do Cantor");
        JButton btnParticipantes = new JButton("Dados do Participante");
        JButton btnVoltar = new JButton("Voltar ao menu principal");

        btnEventos.addActionListener((ActionEvent e) -> {
            new MenuEvento().setVisible(true);
            dispose();
        });

        btnCantores.addActionListener((ActionEvent e) -> {
            new MenuCantor().setVisible(true);
            dispose();
        });

        btnParticipantes.addActionListener((ActionEvent e) -> {
            new MenuParticipanteOrganizador().setVisible(true);
            dispose();
        });

        btnVoltar.addActionListener((ActionEvent e) -> {
            new TelaInicial().setVisible(true);
            dispose();
        });

        painel.add(btnEventos);
        painel.add(btnCantores);
        painel.add(btnParticipantes);
        painel.add(btnVoltar);

        add(painel);
    }
}
