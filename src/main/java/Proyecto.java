import model.AppointmentManager;
import model.EmployeeManager;
import utils.Lector;

public class Proyecto {
    public static void main(String[] args) {

        AppointmentManager mngAppointment = new AppointmentManager();
        EmployeeManager mngEmployee = new EmployeeManager();

        Menu menu = new Menu();
        boolean ejecute = true;

        while (ejecute) {
            menu.printMenuOptions();

            switch (Lector.readOption("Por favor, ingresa un número válido.")) {
                case 1:
                    mngAppointment.createNewAppointment();
                    break;
                case 2:
                    mngAppointment.displayAppointments();
                    break;
                case 3:
                    mngEmployee.createNewEmployee();
                    break;
                case 4:
                    mngEmployee.deleteEmployee();
                    break;
                case 5:
                    mngEmployee.displayEmployees();
                    break;
                case 6:
                    ejecuteSubMenuPrint(menu, mngEmployee, mngAppointment);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    ejecute = false;
                    break;
                default:
                    System.out.println("Opción no válida, por favor selecciona una opción del 1 al " + menu.getTotalOptions() + ".");
            }
            System.out.println();
        }
    }

    private static void ejecuteSubMenuPrint(Menu menu, EmployeeManager mngEmployee, AppointmentManager mngAppointment) {

        boolean ejecute = true;

        while (ejecute) {
            menu.showSubmenuPrint();

            switch (Lector.readOption("Por favor, ingresa un número válido.")) {
                case 1:
                    mngEmployee.printEmployees();
                    break;
                case 2:
                    mngEmployee.loadInformation();
                    break;
                case 3:
                    mngAppointment.printAppointments();
                    break;
                case 4:
                    mngAppointment.loadInformation();
                    break;
                case 5:
                    System.out.println("Regresando al menú principal..");
                    ejecute = false;
                    break;
                default:
                    System.out.println("Opción no válida, por favor selecciona una opción del 1 al " + menu.getOptionSubmenuPrint() + ".");
            }
            System.out.println();
        }
    }
}
