public class Tanque {

    //Atributos de clase
    private static final int MULTIPLICADOR = 11; //Se utilizara como multiplicador a la hora de crear un numero al azar para la posicion del tanque.
    private static final String DIRECCIONES = "NESO";//Se utilizara para comprobar que la orientacion del tanque es correcta.

    //Atributos
    private int fila;
    private int columna;
    private char direccion;

    //Constructores
    public Tanque() { //Constructor sin parametros de entrada
        setFila((int) (Math.random() * MULTIPLICADOR));
        setColumna((int) (Math.random() * MULTIPLICADOR));
        setDireccion('N');
    }

    public Tanque(int fila, int columna) {//Constructor con la fila y columna como parametros de entrada
        setFila(fila);
        setColumna(columna);
        setDireccion('N');
    }

    public Tanque(int fila, int columna, char direccion) {//Constructor con la fila, columna y direccion como parametros de entrada
        setFila(fila);
        setColumna(columna);
        setDireccion(direccion);
    }

    //Getter & Setter de fila
    public int getFila() {
        return fila;
    }

    private void setFila(int fila) {
        assert fila >= 0 && fila < MULTIPLICADOR
                : String.format("La fila debe ser mayor o igual que 0 y menor o igual que 10 (valor introducido -> %d)", fila);
        this.fila = fila;
    }

    //Getter & Setter de columna
    public int getColumna() {
        return columna;
    }

    private void setColumna(int columna) {
        assert columna >= 0 && columna < MULTIPLICADOR
                : String.format("La columna debe ser mayor o igual que 0 y menor o igual que 10 (valor introducido -> %d)", columna);
        this.columna = columna;
    }

    //Getter & Setter de direccion
    public char getDireccion() {
        return direccion;
    }

    public void setDireccion(char direccion) {
        assert DIRECCIONES.indexOf(direccion) >= 0
                : String.format("Debe introducir una direccion valida, N-> Norte, S-> Sur, E-> Este, O-> Oeste (valor introducido -> %c)", direccion);
        this.direccion = direccion;
    }

    //Metodo toString
    @Override
    public String toString() {
        return String.format("Posicion del tanque: F%d, C%d, orientacion: %c", getFila(), getColumna(), getDireccion());
    }

    //Funcionalidades del tanque

    public void avanzar(int distancia) {//Metodo que avanza el tanque x casillas hacia donde este mirando el tanque
        assert distancia >= 0 && distancia < 11 :
                String.format("La distancia no puede ser menor que 0 ni mayor que 10, (valor introducido %d)", distancia);

        if (getDireccion() == 'N')
            setFila(getFila() - distancia);
        else if (getDireccion() == 'S')
            setFila(getFila() + distancia);
        else if (getDireccion() == 'E')
            setColumna(getColumna() + distancia);
        else if (getDireccion() == 'O')
            setColumna(getColumna() - distancia);
    }

    public void avanzar() {//Metodo que avanza el tanque una casilla hacia donde este mirando
        avanzar(1);
    }

    public void girar() {
        if (DIRECCIONES.indexOf(getDireccion()) < DIRECCIONES.length() - 1) //Comprobamos si el tanque NO esta orientado al oeste (O)
            setDireccion(DIRECCIONES.charAt(DIRECCIONES.indexOf(getDireccion() + 1)));//Le asignamos la siguiente direccion en sentido de las agujas del reloj
        else//Si esta orientado al oeste (O)
            setDireccion(DIRECCIONES.charAt(0));//Le asignamos la direccion al norte (N)
    }

    public void girar(char direccion) {
        switch (direccion){
            case 'N':
                assert (getDireccion() != 'N') : "La direccion del tanque ya apuntaba al norte!";
                setDireccion(direccion);
                break;
            case 'S':
                assert (getDireccion() != 'S') : "La direccion del tanque ya apuntaba al sur!";
                setDireccion(direccion);
                break;
            case 'E':
                assert (getDireccion() != 'E') : "La direccion del tanque ya apuntaba al este!";
                setDireccion(direccion);
                break;
            case 'O':
                assert (getDireccion() != 'O') : "La direccion del tanque ya apuntaba al oeste!";
                setDireccion(direccion);
                break;
            default:
                System.err.println("HA OCURRIDO UN ERROR CON LAS DIRECCIONES at Tanques.java");
        }
    }
}
