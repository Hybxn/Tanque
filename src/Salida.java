import java.awt.desktop.SystemEventListener;

public class Salida {

    public static void printTanques(Tanque[] tanques) {
        for (Tanque tanque : tanques) {
            System.out.println(tanque);
        }
    }
}
