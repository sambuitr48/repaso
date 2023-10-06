package Ejercicio1;

import java.io.IOException;
import java.util.List;

public interface Interfaces {
    DTO findById (int id);
    List<DTO> findAll() throws IOException, ClassNotFoundException;
    void save (DTO cuenta) throws IOException;
    void update (DTO cuenta) throws IOException;
    void delete (DTO cuenta) throws IOException;
}
