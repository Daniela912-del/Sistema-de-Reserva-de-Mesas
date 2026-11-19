import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaPrincipal extends JFrame {

    private JPanel painel = new JPanel(new GridBagLayout());

    private JTextField txtNome = new JTextField(20);

    private JSpinner spPessoas =
            new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));

    private JSpinner spData =
            new JSpinner(new SpinnerDateModel());

    private JComboBox<String> cbTipoMesa =
            new JComboBox<>(
                    new String[]{
                            "Padrão",
                            "Família",
                            "VIP"
                    }
            );

    private JComboBox<String> cbHorario =
            new JComboBox<>(
                    new String[]{
                            "18:00",
                            "18:30",
                            "19:00",
                            "19:30",
                            "20:00",
                            "20:30",
                            "21:00",
                            "21:30",
                            "22:00"
                    }
            );

    private JButton btnReservar =
            new JButton("Reservar Mesa");

    private JButton btnCancelar =
            new JButton("Cancelar Reserva");

    public TelaPrincipal() {

        setTitle("Sistema de Reserva de Mesas");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color fundo = new Color(44, 62, 80);
        Color verde = new Color(46, 204, 113);
        Color vermelho = new Color(231, 76, 60);

        painel.setBackground(fundo);

        JLabel titulo =
                new JLabel("SISTEMA DE RESERVA DE MESAS");

        titulo.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        titulo.setForeground(Color.WHITE);

        JLabel lblNome = new JLabel("Nome:");
        JLabel lblPessoas = new JLabel("Quantidade de Pessoas:");
        JLabel lblTipoMesa = new JLabel("Tipo de Mesa:");
        JLabel lblData = new JLabel("Data:");
        JLabel lblHorario = new JLabel("Horário:");

        JLabel[] labels = {
                lblNome,
                lblPessoas,
                lblTipoMesa,
                lblData,
                lblHorario
        };

        for (JLabel label : labels) {
            label.setForeground(Color.WHITE);
            label.setFont(
                    new Font("Arial", Font.BOLD, 14)
            );
        }

        JSpinner.DateEditor editor =
                new JSpinner.DateEditor(
                        spData,
                        "dd/MM/yyyy"
                );

        spData.setEditor(editor);

        btnReservar.setBackground(verde);
        btnReservar.setForeground(Color.WHITE);
        btnReservar.setFocusPainted(false);

        btnCancelar.setBackground(vermelho);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        painel.add(titulo, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(lblNome, gbc);

        gbc.gridx = 1;
        painel.add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(lblPessoas, gbc);

        gbc.gridx = 1;
        painel.add(spPessoas, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(lblTipoMesa, gbc);

        gbc.gridx = 1;
        painel.add(cbTipoMesa, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        painel.add(lblData, gbc);

        gbc.gridx = 1;
        painel.add(spData, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        painel.add(lblHorario, gbc);

        gbc.gridx = 1;
        painel.add(cbHorario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        painel.add(btnReservar, gbc);

        gbc.gridx = 1;
        painel.add(btnCancelar, gbc);

        btnReservar.addActionListener(e -> {

            String nome =
                    txtNome.getText().trim();

            if (nome.isBlank()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Informe o nome do cliente.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int pessoas =
                    (Integer) spPessoas.getValue();

            String tipoMesa =
                    cbTipoMesa.getSelectedItem().toString();

            Date dataSelecionada =
                    (Date) spData.getValue();

            String data =
                    new SimpleDateFormat("dd/MM/yyyy")
                            .format(dataSelecionada);

            String horario =
                    cbHorario.getSelectedItem().toString();

            JOptionPane.showMessageDialog(
                    this,
                    "✅ Reserva realizada com sucesso!\n\n" +
                            "📋 DETALHES DA RESERVA\n\n" +
                            "👤 Cliente: " + nome +
                            "\n👥 Pessoas: " + pessoas +
                            "\n🍽 Mesa: " + tipoMesa +
                            "\n📅 Data: " + data +
                            "\n🕒 Horário: " + horario +
                            "\n\nObrigado pela preferência!\n" +
                            "Esperamos por você. 🍽️",
                    "Reserva Confirmada",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        btnCancelar.addActionListener(e -> {

            txtNome.setText("");
            spPessoas.setValue(1);
            cbTipoMesa.setSelectedIndex(0);
            cbHorario.setSelectedIndex(0);
            spData.setValue(new Date());

            JOptionPane.showMessageDialog(
                    this,
                    "❌ Reserva cancelada.\n\n" +
                            "Esperamos recebê-lo em breve.",
                    "Reserva Cancelada",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        add(painel);

        setVisible(true);
    }
}