import javax.swing.*;
import java.awt.*;

public class TelaParticipante extends JFrame {

    public TelaParticipante() {
        setTitle("Menu Participante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(4, 1, 10, 10));

        painel.add(new JLabel("Menu Participante", SwingConstants.CENTER));
        painel.add(new JButton("Cadastrar como Participante"));
        painel.add(new JButton("Ver eventos disponíveis"));
        JButton btnVoltar = new JButton("Voltar");

        painel.add(btnVoltar);
        add(painel);

        btnVoltar.addActionListener(e -> {
            dispose();
            new TelaPrincipal();
        });

        setVisible(true);
    }
}
