public class Principal {

    public static void main(String[] args) {

        //Instanciamos los tanques, con los diferentes constructores
        Tanque t1 = new Tanque();
        Tanque t2 = new Tanque(2, 2);
        Tanque t3 = new Tanque(4, 6, 'O');

        //Mostramos la informacion de los tanques
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        //Realizamos diferentes funciones de los tanques
        t1.avanzar();
        t2.girar('S');
        t3.girar();

        System.out.println("Moviendo tanques....................");

        //Volvemos a mostrar la informacion de los tanques
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }

}
