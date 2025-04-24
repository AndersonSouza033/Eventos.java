import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuParticipanteOrganizador extends JFrame {
    public MenuParticipanteOrganizador() {
        setTitle("Menu - Dados do Participante");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(4, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnCadastrarParticipante = new JButton("Cadastrar novo participante");
        JButton btnListarParticipantes = new JButton("Visualizar lista de participantes");
        JButton btnExcluirParticipante = new JButton("Excluir participante");
        JButton btnVoltar = new JButton("Voltar");

        btnCadastrarParticipante.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Função para cadastrar participante");
        });
        btnListarParticipantes.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Função para listar participantes");
        });
        btnExcluirParticipante.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Função para excluir participante");
        });
        btnVoltar.addActionListener((ActionEvent e) -> {
            new MenuOrganizador().setVisible(true);
            dispose();
        });
        painel.add(btnCadastrarParticipante);
        painel.add(btnListarParticipantes);
        painel.add(btnExcluirParticipante);
        painel.add(btnVoltar);
        add(painel);
    }
}
