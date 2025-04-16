import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaCadastroParticipante extends JFrame {

    private JTextField campoNome;
    private JTextField campoEmail;
    private JPasswordField campoSenha;

    public TelaCadastroParticipante() {
        setTitle("Cadastro - Participante");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 250);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelNome = new JLabel("Nome:");
        JLabel labelEmail = new JLabel("E-mail:");
        JLabel labelSenha = new JLabel("Senha:");

        campoNome = new JTextField();
        campoEmail = new JTextField();
        campoSenha = new JPasswordField();

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnVoltar = new JButton("Voltar");

        btnCadastrar.addActionListener((ActionEvent e) -> cadastrarParticipante());
        btnVoltar.addActionListener((ActionEvent e) -> voltarMenuPrincipal());

        painel.add(labelNome);
        painel.add(campoNome);
        painel.add(labelEmail);
        painel.add(campoEmail);
        painel.add(labelSenha);
        painel.add(campoSenha);
        painel.add(btnCadastrar);
        painel.add(btnVoltar);

        add(painel);
    }

    private void cadastrarParticipante() {
        String nome = campoNome.getText();
        String email = campoEmail.getText();
        String senha = new String(campoSenha.getPassword());

        // Verificando se o participante já está cadastrado
        for (Participante p : BancoDeDados.getParticipantes()) {
            if (p.getEmail().equalsIgnoreCase(email)) {
                JOptionPane.showMessageDialog(this, "Este e-mail já está cadastrado.");
                return;
            }
        }

        // Adicionando novo participante
        Participante novoParticipante = new Participante(nome, email, senha);
        BancoDeDados.getParticipantes().add(novoParticipante);

        JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
        new TelaLoginParticipante().setVisible(true);
        dispose();
    }

    private void voltarMenuPrincipal() {
        new TelaInicial().setVisible(true);
        dispose();
    }
}