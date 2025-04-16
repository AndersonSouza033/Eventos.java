import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TelaLoginOrganizador extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoSenha;

    public TelaLoginOrganizador() {
        setTitle("Login - Organizador");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel labelUsuario = new JLabel("Usuário:");
        JLabel labelSenha = new JLabel("Senha:");

        campoUsuario = new JTextField();
        campoSenha = new JPasswordField();

        JButton btnEntrar = new JButton("Entrar");
        JButton btnVoltar = new JButton("Voltar");

        btnEntrar.addActionListener((ActionEvent e) -> fazerLogin());
        btnVoltar.addActionListener((ActionEvent e) -> {
            new TelaInicial().setVisible(true);
            dispose();
        });

        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        painel.add(labelUsuario);
        painel.add(campoUsuario);
        painel.add(labelSenha);
        painel.add(campoSenha);
        painel.add(btnEntrar);
        painel.add(btnVoltar);

        add(painel);
    }

    private void fazerLogin() {
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());

        if (usuario.equals("admin") && senha.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
            new MenuOrganizador().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.");
        }
    }
}