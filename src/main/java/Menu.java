public class Menu {

    private final int totalOptions = 7;
    private final int optionSubmenuPrint = 5;

    public int getTotalOptions() {
        return totalOptions;
    }

    public int getOptionSubmenuPrint() { return optionSubmenuPrint; }

    private String getMessageOption(short option) {
        switch (option){
            case 1:
                return "1. Agendar cita/procedimiento";
            case 2:
                return "2. Ver citas/procedimientos agendados";
            case 3:
                return "3. Dar de alta empleado";
            case 4:
                return "4. Eliminar empleado";
            case 5:
                return "5. Ver lista de empleados";
            case 6:
                return "6. Guardar/cargar información";
            case 7:
                return "7. Salir";
            default:
                return "La opción seleccionada no existe, vuelva a intentar.";
        }
    }

    public void printMenuOptions() {

        System.out.println("========= SELECCIONA UNA OPCIÓN =========");
        for(int i = 0; i < totalOptions; i++){
            System.out.println(getMessageOption((short) (i + 1)));
        }
        System.out.println();
    }

    public void showSubmenuPrint() {

        System.out.println("========= MENÚ DE GUARDA Y CARGA =========");
        for(int i = 0; i < optionSubmenuPrint; i++){
            System.out.println(getMessageOptionSubmenuPrint((short) (i + 1)));
        }
        System.out.println();
    }

    private String getMessageOptionSubmenuPrint(short option) {
        switch (option){
            case 1:
                return "1. Guardar empleados";
            case 2:
                return "2. Cargar empleados";
            case 3:
                return "3. Guardar citas";
            case 4:
                return "4. Cargar citas";
            case 5:
                return "5. Regresar";
            default:
                return "La opción seleccionada no existe, vuelva a intentar.";
        }
    }
}
