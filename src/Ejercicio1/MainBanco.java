package Ejercicio1;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainBanco {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc = "1";
        Interfaces repo = new Servicio();
        Scanner s = new Scanner(System.in);
        while (!opc.equals("6")){
            System.out.println("\"Menu: \n digita '1' para registrarte \n digita '2' para consultar todas las cuentas \n digita '3' para ingresar dinero a tu cuenta \n digita '4' para transferir dinero \n digita '5' para eliminar cuenta \n digita '6' para salir");
            opc = s.next();
            if (opc.equals("1")) {
                System.out.println("REGISTRARSE");
                System.out.println("Numero de cuenta:");
                Integer numerCuenta = Integer.valueOf(s.next());
                System.out.println("Nombre de la persona");
                String name = s.next();
                System.out.println("cedula:");
                Integer cedu = Integer.valueOf(s.next());
                repo.save(new DTO(numerCuenta, name, +0, cedu));
            } else if (opc.equals("2")) {
                System.out.println("CONSULTAR CUENTAS");
                List<DTO> cuenta = repo.findAll();
                if (!cuenta.isEmpty()){
                    cuenta.forEach(System.out::println);
                } else {
                    System.out.println("No hay registros");
                }

            } else if (opc.equals("3")) {
                System.out.println("INGRESAR DINERO");
                System.out.println("Ingresa el numero de la cuenta:");
                int nc = Integer.parseInt(s.next());
                boolean busqueda = repo.findById(nc) == null;
                if (!busqueda){
                    System.out.println("Ingrese la cantidad de dinero a transferir");
                    int dinero = Integer.parseInt(s.next());
                    Integer nuevoSaldo = repo.findById(nc).getSaldo() + dinero;
                    String name = repo.findById(nc).getUsuario();
                    Integer cedu = repo.findById(nc).getCedula();
                    repo.update(new DTO(nc, name, nuevoSaldo, cedu));
                    System.out.println("Ha transferido exitosamente $" + dinero);
                } else {
                    System.out.println("Cuenta no encontrada");
                }
            } else if (opc.equals("4")) {
                System.out.println("TRANSFERIR DE CUENTA A CUENTA");
                System.out.println("Ingrese el numero de la primer cuenta");
                int id1 = Integer.parseInt(s.next());
                String name1 = repo.findById(id1).getUsuario();
                Integer cedu1 = repo.findById(id1).getCedula();
                System.out.println("Ingrese el numero de la segunda cuenta");
                int id2 = Integer.parseInt(s.next());
                String name2 = repo.findById(id2).getUsuario();
                Integer cedu2 = repo.findById(id2).getCedula();
                System.out.println("Ingrese el valor a transferir");
                int saldo = Integer.parseInt(s.next());
                if (repo.findById(id1).getSaldo() >= saldo){
                    Integer resta = repo.findById(id1).getSaldo() - saldo;
                    Integer suma = repo.findById(id2).getSaldo() + saldo;
                    repo.update(new DTO(id1, name1, resta, cedu1));
                    repo.update(new DTO(id2, name2, suma, cedu2));
                    System.out.println("Se ha transferido exitosamente $" + saldo + " a la cuenta" + id2 + "desde la cuenta" + id1);
                } else {
                    System.out.println("No tienes saldo suficiente para realizar la transferencia  ");
                }

            } else if (opc.equals("5")) {
                System.out.println("ELIMINAR");
                System.out.println("Ingresa el numero de la cuenta a la que deseas eliminar");
                int cuentica = s.nextInt();
                repo.delete(repo.findById(cuentica));
                repo.findAll().forEach(System.out::println);
            } else if (opc.equals("6")) {
                opc = "6";
            }
        }
    }
}
