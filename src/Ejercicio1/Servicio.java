package Ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Servicio implements Interfaces{
    private List<DTO> cuentas;
    public Servicio() throws IOException, ClassNotFoundException {
        cuentas = new ArrayList<>();
    }

    @Override
    public DTO findById(int id) {
        return cuentas.stream()
                .filter(cuenta ->cuenta.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<DTO> findAll() throws IOException, ClassNotFoundException {
        cuentas = (List<DTO>) ObjectoSerializable.readObjectFromFile("cuentas.ax");
        return cuentas;
    }

    @Override
    public void save(DTO cuenta) throws IOException {
        cuentas.add(cuenta);
        ObjectoSerializable.writeObjectToFile(cuentas, "cuentas.ax");
    }

    @Override
    public void update(DTO cuenta) throws IOException {
        DTO cuentaVieja = findById(cuenta.getId());
        if (cuentaVieja != null){
            cuentas.remove(cuentaVieja);
            cuentas.add(cuenta);
            ObjectoSerializable.writeObjectToFile(cuentas, "cuentas.ax");
        }
    }

    @Override
    public void delete(DTO cuenta) throws IOException {
        cuentas.remove(cuenta);
        ObjectoSerializable.writeObjectToFile(cuentas, "cuentas.ax");
    }
}
