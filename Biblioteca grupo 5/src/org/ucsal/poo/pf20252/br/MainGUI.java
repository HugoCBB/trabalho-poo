package src.org.ucsal.poo.pf20252.br;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import src.org.ucsal.poo.pf20252.br.pais.Usuario;
import src.org.ucsal.poo.pf20252.br.pais.Livro;
import javax.swing.table.DefaultTableModel;

public class MainGUI extends JFrame {

    private GerenciadorBiblioteca gerenciador;

    public MainGUI() {
        super("Gerenciador de Biblioteca UCSAL");
        this.gerenciador = new GerenciadorBiblioteca();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centraliza a janela

        // Configuração do painel principal com BorderLayout
        setLayout(new BorderLayout());

        // Criação do painel de abas (JTabbedPane)
        JTabbedPane tabbedPane = new JTabbedPane();

        // Adicionar abas
        tabbedPane.addTab("Cadastrar Usuário", criarPainelCadastrarUsuario());
        tabbedPane.addTab("Cadastrar Livro", criarPainelCadastrarLivro());
        tabbedPane.addTab("Empréstimo", criarPainelEmprestimo());
        tabbedPane.addTab("Devolução", criarPainelDevolucao());
        tabbedPane.addTab("Listar", criarPainelListagem());

        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel criarPainelCadastrarUsuario() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField(20);
        JLabel lblTipo = new JLabel("Tipo:");
        String[] tipos = {"ALUNO", "PROFESSOR"};
        JComboBox<String> cmbTipo = new JComboBox<>(tipos);
        JButton btnCadastrar = new JButton("Cadastrar");
        JTextArea txtResultado = new JTextArea(5, 30);
        txtResultado.setEditable(false);
        JScrollPane scrollResultado = new JScrollPane(txtResultado);

        // Ação do botão
        btnCadastrar.addActionListener(e -> {
            try {
                String nome = txtNome.getText().trim();
                String tipo = (String) cmbTipo.getSelectedItem();

                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "O nome não pode ser vazio.", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Usuario novoUsuario = gerenciador.cadastrarUsuario(nome, tipo);
                txtResultado.setText("Usuário cadastrado com sucesso!\n");
                txtResultado.append("Nome: " + novoUsuario.getNome() + "\n");
                txtResultado.append("Tipo: " + novoUsuario.getTipo() + "\n");
                txtResultado.append("Matrícula: " + novoUsuario.getMatricula() + "\n");

                txtNome.setText(""); // Limpa o campo
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Layout
        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblNome, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(txtNome, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblTipo, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(cmbTipo, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; panel.add(btnCadastrar, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; panel.add(scrollResultado, gbc);

        return panel;
    }

    private JPanel criarPainelCadastrarLivro() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes
        JLabel lblAutor = new JLabel("Autor:");
        JTextField txtAutor = new JTextField(20);
        JLabel lblTitulo = new JLabel("Título:");
        JTextField txtTitulo = new JTextField(20);
        JLabel lblISBN = new JLabel("ISBN:");
        JTextField txtISBN = new JTextField(20);
        JLabel lblAno = new JLabel("Ano:");
        JTextField txtAno = new JTextField(20);
        JLabel lblValor = new JLabel("Valor:");
        JTextField txtValor = new JTextField(20);
        JButton btnCadastrar = new JButton("Cadastrar");
        JTextArea txtResultado = new JTextArea(5, 30);
        txtResultado.setEditable(false);
        JScrollPane scrollResultado = new JScrollPane(txtResultado);

        // Ação do botão
        btnCadastrar.addActionListener(e -> {
            try {
                String autor = txtAutor.getText().trim();
                String titulo = txtTitulo.getText().trim();
                int isbn = Integer.parseInt(txtISBN.getText().trim());
                int ano = Integer.parseInt(txtAno.getText().trim());
                double valor = Double.parseDouble(txtValor.getText().trim());

                if (autor.isEmpty() || titulo.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Autor e Título não podem ser vazios.", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Livro novoLivro = gerenciador.cadastrarLivro(autor, titulo, isbn, ano, valor);
                txtResultado.setText("Livro cadastrado com sucesso!\n");
                txtResultado.append("Título: " + novoLivro.getTitulo() + "\n");
                txtResultado.append("ISBN: " + novoLivro.getIsbn() + "\n");

                txtAutor.setText("");
                txtTitulo.setText("");
                txtISBN.setText("");
                txtAno.setText("");
                txtValor.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ISBN, Ano e Valor devem ser números válidos.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar livro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Layout
        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblAutor, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(txtAutor, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblTitulo, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(txtTitulo, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(lblISBN, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(txtISBN, gbc);
        gbc.gridx = 0; gbc.gridy = 3; panel.add(lblAno, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(txtAno, gbc);
        gbc.gridx = 0; gbc.gridy = 4; panel.add(lblValor, gbc);
        gbc.gridx = 1; gbc.gridy = 4; panel.add(txtValor, gbc);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; panel.add(btnCadastrar, gbc);
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2; panel.add(scrollResultado, gbc);

        return panel;
    }

    private JPanel criarPainelEmprestimo() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes
        JLabel lblMatricula = new JLabel("Matrícula do Usuário:");
        JTextField txtMatricula = new JTextField(20);
        JLabel lblISBN = new JLabel("ISBN do Livro:");
        JTextField txtISBN = new JTextField(20);
        JLabel lblDias = new JLabel("Dias de Empréstimo:");
        JTextField txtDias = new JTextField(20);
        JButton btnEmprestar = new JButton("Emprestar");
        JTextArea txtResultado = new JTextArea(5, 30);
        txtResultado.setEditable(false);
        JScrollPane scrollResultado = new JScrollPane(txtResultado);

        // Ação do botão
        btnEmprestar.addActionListener(e -> {
            try {
                int matricula = Integer.parseInt(txtMatricula.getText().trim());
                int isbn = Integer.parseInt(txtISBN.getText().trim());
                int dias = Integer.parseInt(txtDias.getText().trim());

                if (gerenciador.emprestarLivro(matricula, isbn, dias)) {
                    txtResultado.setText("Livro emprestado com sucesso!\n");
                    txtResultado.append("Usuário: " + gerenciador.buscarUsuarioPorMatricula(matricula).getNome() + "\n");
                    txtResultado.append("Livro: " + gerenciador.buscarLivroPorISBN(isbn).getTitulo() + "\n");
                } else {
                    txtResultado.setText("Falha no empréstimo. Verifique se o usuário/livro existe ou se o livro já está emprestado.\n");
                }

                txtMatricula.setText("");
                txtISBN.setText("");
                txtDias.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Matrícula, ISBN e Dias devem ser números válidos.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao realizar empréstimo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Layout
        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblMatricula, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(txtMatricula, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblISBN, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(txtISBN, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(lblDias, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(txtDias, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; panel.add(btnEmprestar, gbc);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; panel.add(scrollResultado, gbc);

        return panel;
    }

    private JPanel criarPainelDevolucao() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes
        JLabel lblISBN = new JLabel("ISBN do Livro:");
        JTextField txtISBN = new JTextField(20);
        JLabel lblDiasPassados = new JLabel("Dias Passados:");
        JTextField txtDiasPassados = new JTextField(20);
        JButton btnDevolver = new JButton("Devolver");
        JTextArea txtResultado = new JTextArea(5, 30);
        txtResultado.setEditable(false);
        JScrollPane scrollResultado = new JScrollPane(txtResultado);

        // Ação do botão
        btnDevolver.addActionListener(e -> {
            try {
                int isbn = Integer.parseInt(txtISBN.getText().trim());
                int diasPassados = Integer.parseInt(txtDiasPassados.getText().trim());

                double multa = gerenciador.devolverLivro(isbn, diasPassados);

                if (multa == -1) {
                    txtResultado.setText("Falha na devolução. Verifique se o livro existe ou se está emprestado.\n");
                } else {
                    Livro livro = gerenciador.buscarLivroPorISBN(isbn);
                    txtResultado.setText("Livro devolvido com sucesso!\n");
                    txtResultado.append("Livro: " + livro.getTitulo() + "\n");
                    if (multa > 0) {
                        txtResultado.append(String.format("Multa aplicada: R$ %.2f\n", multa));
                    } else {
                        txtResultado.append("Devolvido sem multa.\n");
                    }
                }

                txtISBN.setText("");
                txtDiasPassados.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ISBN e Dias Passados devem ser números válidos.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao realizar devolução: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Layout
        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblISBN, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(txtISBN, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblDiasPassados, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(txtDiasPassados, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; panel.add(btnDevolver, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; panel.add(scrollResultado, gbc);

        return panel;
    }

    private JPanel criarPainelListagem() {
        JPanel panel = new JPanel(new BorderLayout());
        JTabbedPane listTabbedPane = new JTabbedPane();

        // Tabela de Usuários
        String[] colunasUsuario = {"Matrícula", "Nome", "Tipo"};
        JTable tabelaUsuario = new JTable(new Object[0][0], colunasUsuario);
        JScrollPane scrollUsuario = new JScrollPane(tabelaUsuario);
        listTabbedPane.addTab("Usuários", scrollUsuario);

        // Tabela de Livros
        String[] colunasLivro = {"ISBN", "Título", "Autor", "Emprestado"};
        JTable tabelaLivro = new JTable(new Object[0][0], colunasLivro);
        JScrollPane scrollLivro = new JScrollPane(tabelaLivro);
        listTabbedPane.addTab("Livros", scrollLivro);

        JButton btnAtualizar = new JButton("Atualizar Listas");
        btnAtualizar.addActionListener(e -> {
            // Atualizar Tabela de Usuários
            List<Usuario> usuarios = gerenciador.getUsuarios();
            Object[][] dadosUsuario = new Object[usuarios.size()][3];
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario u = usuarios.get(i);
                dadosUsuario[i][0] = u.getMatricula();
                dadosUsuario[i][1] = u.getNome();
                dadosUsuario[i][2] = u.getTipo();
            }
            tabelaUsuario.setModel(new DefaultTableModel(dadosUsuario, colunasUsuario));

            // Atualizar Tabela de Livros
            List<Livro> livros = gerenciador.getLivros();
            Object[][] dadosLivro = new Object[livros.size()][4];
            for (int i = 0; i < livros.size(); i++) {
                Livro l = livros.get(i);
                dadosLivro[i][0] = l.getIsbn();
                dadosLivro[i][1] = l.getTitulo();
                dadosLivro[i][2] = l.getAutor();
                dadosLivro[i][3] = l.isEmprestado() ? "Sim" : "Não";
            }
            tabelaLivro.setModel(new DefaultTableModel(dadosLivro, colunasLivro));
        });

        panel.add(listTabbedPane, BorderLayout.CENTER);
        panel.add(btnAtualizar, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        // Garante que a GUI seja executada na Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new MainGUI().setVisible(true);
        });
    }
}
