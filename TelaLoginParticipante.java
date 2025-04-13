import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaLoginParticipante extends JFrame {

    private JTextField campoEmail;
    private JPasswordField campoSenha;

    public TelaLoginParticipante() {
        setTitle("Login - Participante");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(3, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelEmail = new JLabel("E-mail:");
        JLabel labelSenha = new JLabel("Senha:");

        campoEmail = new JTextField();
        campoSenha = new JPasswordField();

        JButton btnEntrar = new JButton("Entrar");
        JButton btnVoltar = new JButton("Voltar");

        btnEntrar.addActionListener((ActionEvent e) -> fazerLogin());
        btnVoltar.addActionListener((ActionEvent e) -> {
            new TelaInicial().setVisible(true);
            dispose();
        });

        painel.add(labelEmail);
        painel.add(campoEmail);
        painel.add(labelSenha);
        painel.add(campoSenha);
        painel.add(btnEntrar);
        painel.add(btnVoltar);

        add(painel);
    }

    private void fazerLogin() {
        String email = campoEmail.getText();
        String senha = new String(campoSenha.getPassword());

        for (Participante p : BancoDeDados.getParticipantes()) {
            if (p.getEmail().equalsIgnoreCase(email) && p.getSenha().equals(senha)) {
                JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
                new MenuParticipante(p).setVisible(true);
                dispose();
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "E-mail ou senha incorretos.");
    }
}
