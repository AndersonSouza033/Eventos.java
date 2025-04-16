import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuCantor extends JFrame {

    public MenuCantor() {
        setTitle("Menu - Dados do Cantor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(5, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnCadastrarCantor = new JButton("Cadastrar novo cantor");
        JButton btnListarCantores = new JButton("Visualizar lista de cantores");
        JButton btnEditarCantor = new JButton("Editar informações de cantores");
        JButton btnExcluirCantor = new JButton("Excluir cantor");
        JButton btnVoltar = new JButton("Voltar");

        btnCadastrarCantor.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Função para cadastrar cantor");
        });

        btnListarCantores.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Função para listar cantores");
        });

        btnEditarCantor.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Função para editar cantor");
        });

        btnExcluirCantor.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Função para excluir cantor");
        });

        btnVoltar.addActionListener((ActionEvent e) -> {
            new MenuOrganizador().setVisible(true);
            dispose();
        });

        painel.add(btnCadastrarCantor);
        painel.add(btnListarCantores);
        painel.add(btnEditarCantor);
        painel.add(btnExcluirCantor);
        painel.add(btnVoltar);

        add(painel);
    }
}
