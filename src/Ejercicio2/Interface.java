package Ejercicio2;

import java.io.IOException;
import java.util.List;

public interface Interface {
    DTO findById(int id);
    List<DTO> findAll() throws IOException, ClassNotFoundException;
    void save (DTO reserva) throws IOException;
    void update (DTO reserva) throws IOException;
    void delete (DTO reserva) throws IOException;
}
