import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> reservas = new ArrayList<>();

        while (true) {

            String nome = JOptionPane.showInputDialog("Nome do cliente:");

            int pessoas = Integer.parseInt(
                    JOptionPane.showInputDialog("Quantidade de pessoas:")
            );

            String data = JOptionPane.showInputDialog(
                    "Data da reserva (dd/MM/yyyy):"
            );

            String horario = JOptionPane.showInputDialog(
                    "Horário da reserva (HH:mm):"
            );

            String tipoMesa;
            double valor;

            if (pessoas >= 1 && pessoas <= 4) {
                tipoMesa = "Padrão";
                valor = 80.00;

            } else if (pessoas <= 8) {
                tipoMesa = "Família";
                valor = 150.00;

            } else if (pessoas <= 12) {
                tipoMesa = "VIP";
                valor = 250.00;

            } else {
                tipoMesa = "Indisponível";
                valor = 0.00;
            }

            String reserva =
                    "Cliente: " + nome +
                            "\nPessoas: " + pessoas +
                            "\nData: " + data +
                            "\nHorário: " + horario +
                            "\nMesa: " + tipoMesa +
                            "\nValor: R$ " + valor;

            reservas.add(reserva);

            int opcao = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja cadastrar outra reserva?",
                    "Nova Reserva",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcao != JOptionPane.YES_OPTION) {
                break;
            }
        }

        StringBuilder resumo = new StringBuilder();
        resumo.append("===== TODAS AS RESERVAS =====\n\n");

        for (int i = 0; i < reservas.size(); i++) {
            resumo.append("Reserva ")
                    .append(i + 1)
                    .append("\n")
                    .append(reservas.get(i))
                    .append("\n\n");
        }

        JOptionPane.showMessageDialog(null, resumo.toString());

        System.exit(0);
    }
}