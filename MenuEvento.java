import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuEvento extends JFrame {

    public MenuEvento() {
        setTitle("Menu - Dados do Evento");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(9, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnCriarEvento = new JButton("Criar novo evento");
        JButton btnListarEventos = new JButton("Visualizar todos os eventos");
        JButton btnEditarEvento = new JButton("Editar informações de um evento");
        JButton btnCancelarEvento = new JButton("Cancelar evento existente");
        JButton btnExcluirEvento = new JButton("Excluir evento");
        JButton btnCadastrarCantor = new JButton("Cadastrar cantor no evento");
        JButton btnCancelarCantor = new JButton("Cancelar cantor no evento");
        JButton btnVoltar = new JButton("Voltar");

        btnCriarEvento.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Função para criar evento");
        });

        btnListarEventos.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Função para listar eventos");
        });

        btnEditarEvento.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Função para editar evento");
        });

        btnCancelarEvento.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Função para cancelar evento");
        });

        btnExcluirEvento.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Função para excluir evento");
        });

        btnCadastrarCantor.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Função para cadastrar cantor no evento");
        });

        btnCancelarCantor.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Função para cancelar cantor no evento");
        });

        btnVoltar.addActionListener((ActionEvent e) -> {
            new MenuOrganizador().setVisible(true);
            dispose();
        });

        painel.add(btnCriarEvento);
        painel.add(btnListarEventos);
        painel.add(btnEditarEvento);
        painel.add(btnCancelarEvento);
        painel.add(btnExcluirEvento);
        painel.add(btnCadastrarCantor);
        painel.add(btnCancelarCantor);
        painel.add(btnVoltar);

        add(painel);
    }
}
