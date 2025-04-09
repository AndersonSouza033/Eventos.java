import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPrincipal extends JFrame {
    // Constantes para login
    private static final String USUARIO_ORGANIZADOR = "admin";
    private static final String SENHA_ORGANIZADOR = "1234";

    public TelaPrincipal() {
        setTitle("Rolézinho Eventos");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Painel com os botões
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel titulo = new JLabel("Bem-vindo ao Rolézinho Eventos", JLabel.CENTER);
        painel.add(titulo);

        JButton btnOrganizador = new JButton("Entrar como Organizador");
        JButton btnParticipante = new JButton("Entrar como Participante");
        JButton btnSair = new JButton("Sair");

        painel.add(btnOrganizador);
        painel.add(btnParticipante);
        painel.add(btnSair);

        add(painel);

        // Ação do botão organizador
        btnOrganizador.addActionListener(e -> fazerLoginOrganizador());

        // Ação do botão participante
        btnParticipante.addActionListener(e -> fazerLoginParticipante());

        // Ação do botão sair
        btnSair.addActionListener(e -> System.exit(0));
    }

    private void fazerLoginOrganizador() {
        JTextField campoUsuario = new JTextField();
        JPasswordField campoSenha = new JPasswordField();
        Object[] campos = {
            "Usuário:", campoUsuario,
            "Senha:", campoSenha
        };

        int opcao = JOptionPane.showConfirmDialog(this, campos, "Login Organizador", JOptionPane.OK_CANCEL_OPTION);
        if (opcao == JOptionPane.OK_OPTION) {
            String usuario = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());

            if (usuario.equals(USUARIO_ORGANIZADOR) && senha.equals(SENHA_ORGANIZADOR)) {
                JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
                abrirMenuOrganizador();
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void fazerLoginParticipante() {
        String email = JOptionPane.showInputDialog(this, "Digite seu e-mail:");

        if (email != null && !email.trim().isEmpty()) {
            // Simulando login com lista de participantes
            boolean encontrado = false;
            for (Participante p : SistemaEventos.getParticipantes()) {
                if (p.getEmail().equalsIgnoreCase(email)) {
                    JOptionPane.showMessageDialog(this, "Login realizado! Bem-vindo, " + p.getNome());
                    abrirMenuParticipante();
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "E-mail não encontrado. Cadastre-se primeiro.");
            }
        }
    }

    // Apenas exemplos para abrir outros menus
    private void abrirMenuOrganizador() {
        JOptionPane.showMessageDialog(this, "Abriria o menu do organizador aqui.");
    }

    private void abrirMenuParticipante() {
        JOptionPane.showMessageDialog(this, "Abriria o menu do participante aqui.");
    }

    public static void main(String[] args) {
        // Populando a lista de participantes para simular login
        SistemaEventos.prepararParticipantesTeste(); // Função para testes

        SwingUtilities.invokeLater(() -> {
            TelaPrincipal tela = new TelaPrincipal();
            tela.setVisible(true);
        });
    }
}
