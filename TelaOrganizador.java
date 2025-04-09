import javax.swing.*;
import java.awt.*;

public class TelaOrganizador extends JFrame {

    public TelaOrganizador() {
        setTitle("Menu Organizador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(8, 1, 10, 10));

        painel.add(new JLabel("Menu Organizador", SwingConstants.CENTER));
        painel.add(new JButton("Criar novo evento"));
        painel.add(new JButton("Listar eventos"));
        painel.add(new JButton("Editar evento"));
        painel.add(new JButton("Cancelar evento"));
        painel.add(new JButton("Cadastrar cantor"));
        painel.add(new JButton("Cadastrar participante"));
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
