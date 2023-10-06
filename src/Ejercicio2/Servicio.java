package Ejercicio2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Servicio implements Interface {
    private List<DTO> reservas;
    public Servicio() {
        reservas = new ArrayList<>();
    }

    @Override
    public DTO findById(int id) {
        return reservas.stream()
                .filter(reservasDTO -> reservasDTO.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<DTO> findAll() throws IOException, ClassNotFoundException {
        reservas = (List<DTO>) ObjectoSerializable.readObjectFromFile("reservas.ax");
        return reservas;
    }

    @Override
    public void save(DTO reserva) throws IOException {
        reservas.add(reserva);
        ObjectoSerializable.writeObjectToFile(reservas, "reservas.ax");
    }

    @Override
    public void update(DTO reserva) throws IOException {
        DTO oldReserva = findById(reserva.getId());
        if (oldReserva != null){
            reservas.remove(oldReserva);
            reservas.add(reserva);
            ObjectoSerializable.writeObjectToFile(reservas, "reservas.ax");
        }

    }

    @Override
    public void delete(DTO reserva) throws IOException {
        reservas.remove(reserva);
        ObjectoSerializable.writeObjectToFile(reservas, "reservas.ax");
    }
}
