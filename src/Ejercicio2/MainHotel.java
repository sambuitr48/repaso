package Ejercicio2;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MainHotel {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc = "1";
        Interface repo = new Servicio();
        Scanner s = new Scanner(System.in);

        while (!opc.equals("6")) {
            System.out.println("""
                    Menu:\s
                     digita '1' para hacer una reserva\s
                     digita '2' para Consultar las reservas\s
                     digita '3' para Editar reserva \s
                     digita '4' para Eliminar reserva\s
                     digita '5' para consultar cantidad de huespedes\s
                     digita '6' para Salir""");
            opc = s.next();

            if (opc.equals("1")) {
                System.out.println("Reserva");
                System.out.println("Ingresa tu numero de cedula");
                int id = Integer.parseInt(s.next());
                System.out.println("ingrese su nombre");
                String name = s.next();
                System.out.println("Ingrese su pais de residencia:");
                String pais = s.next();
                System.out.println("Cuantas personas hospedarán la habitación?");
                int numPersonas = Integer.parseInt(s.next());
                System.out.println("Cuantos dias se van a hospedar?");
                Integer dias = Integer.valueOf(s.next());
                System.out.println("Traes mascota?");
                String pet = s.next();
                System.out.println("Fumas?");
                String fuma = s.next();
                System.out.println("selecciona el Tipo de habitacion: \n 1.Individual(2 personas) \n 2.Doble(4 personas) \n 3.Familiar(6 personas & mascota)");
                int hab = Integer.parseInt(s.next());

                if (hab == 1 && numPersonas <= 2 && Objects.equals(pet, "no")) {
                    String tipHab = "Individual";
                    repo.save(new DTO(id, tipHab, name, pais, numPersonas, dias, pet, fuma));
                    System.out.println("Reserva existente: " + repo.findById(id));
                } else if ((hab == 2) && (numPersonas <= 4) && Objects.equals(pet, "no")) {
                    String tipHab = "Doble";
                    repo.save(new DTO(id, tipHab, name, pais, numPersonas, dias, pet, fuma));
                    System.out.println("Reserva existente: " + repo.findById(id));
                } else if (hab == 3 && numPersonas <= 6) {
                    String tipHab = "Familiar";
                    repo.save(new DTO(id, tipHab, name, pais, numPersonas, dias, pet, fuma));
                    System.out.println("Reserva existente: " + repo.findById(id));
                } else {
                    System.out.println("Reserva invalida, ingresa datos validos");
                }
            } else if (opc.equals("2")) {
                System.out.println("~~~MOSTRAR RESERVAS~~~");
                List<DTO> reservas = repo.findAll();
                if (!reservas.isEmpty()) {
                    reservas.forEach(System.out::println);
                } else {
                    System.out.println("No hay reservas");
                }
            } else if (opc.equals("3")) {
                System.out.println("~~~EDITAR RESERVAS~~~");
                System.out.println("Ingrese el numero de cedula");
                int id = Integer.parseInt(s.next());
                boolean busqueda = repo.findById(id) == null;
                if (!busqueda) {
                    System.out.println("Cual es tu nombre?");
                    String name = s.next();
                    System.out.println("Ingresa tu pais de origen:");
                    String pais = s.next();
                    System.out.println("Cuantas personas son?");
                    int numPersonas = Integer.parseInt(s.next());
                    System.out.println("Cuantos dias se van a hospedar?");
                    Integer dias = Integer.valueOf(s.next());
                    System.out.println("Traes mascota?");
                    String pet = s.next();
                    System.out.println("Fumas?");
                    String fuma = s.next();
                    System.out.println("Tipo de habitacion: \n 1.Individual(2 personas) \n 2.Doble(4 personas) \n 3.Familiar(6 personas & mascota)");
                    int hab = Integer.parseInt(s.next());

                    if (hab == 1 && numPersonas <= 2 && Objects.equals(pet, "no")) {
                        String tipHab = "Individual";
                        repo.update(new DTO(id, tipHab, name, pais, numPersonas, dias, pet, fuma));
                        System.out.println("Reserva existente: " + repo.findById(id));
                    } else if ((hab == 2) && (numPersonas <= 4) && Objects.equals(pet, "no")) {
                        String tipHab = "Doble";
                        repo.update(new DTO(id, tipHab, name, pais, numPersonas, dias, pet, fuma));
                        System.out.println("Reserva existente: " + repo.findById(id));
                    } else if (hab == 3 && numPersonas <= 6) {
                        String tipHab = "Familiar";
                        repo.update(new DTO(id, tipHab, name, pais, numPersonas, dias, pet, fuma));
                        System.out.println("Reserva existente: " + repo.findById(id));
                    } else {
                        System.out.println("Reserva invalida, ingrese bien los datos");
                    }
                } else {
                    System.out.println("Registro no encontrado");
                }
            } else if (opc.equals("4")) {
                System.out.println("~~~ELIMINAR RESERVA~~~");
                System.out.println("Ingresa el numero de cedula: ");
                int id = Integer.parseInt(s.next());
                boolean busqueda = repo.findById(id) == null;
                if (!busqueda) {
                    System.out.println("Se eliminará la siguiente reserva:\n " + repo.findById(id));
                    repo.delete(repo.findById(id));
                    System.out.println("Reserva eliminada exitosamente");
                } else {
                    System.out.println("Reserva no encontrada");
                }
            } else if (opc.equals("5")) {
                int huespedestot = repo.findAll().stream().mapToInt(DTO::getNumberOfPerson).sum();
                System.out.println("En el hotel se encuentran " + huespedestot + " Huespedes");
            } else if (opc.equals("6")) {
                opc = "6";
            }
        }
    }
}

