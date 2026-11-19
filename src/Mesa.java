public class Mesa implements Reservavel {

    private int numero;
    private boolean reservada;
    public  Mesa(int numero) {
        this.numero = numero;
        this.reservada = false;
    }

    @Override
    public void reservar() {
        this.reservada = true;
    }

    @Override
    public void cancelarReserva() {
        this.reservada = false;
    }

    @Override
    public boolean verificarDisponibilidade() {
        return !this.reservada;
    }
}
