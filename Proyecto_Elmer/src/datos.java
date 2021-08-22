
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.JOptionPane;


/*
En esta clase se hacen las funciones de comparación entre la selección de un jugador y el otro
también se escriben los resultados en el archivo de texto
 */
public class datos {

    private static String nombre1, nombre2, pais1, pais2, op1, op2;//variables para almacenar los datos de nombre, pais y escogencia
    private static int iten, iten2, ronda, resul1, result2;//variables de tipo entero para manejar los índices y la ronda
    File archivo; //para poder manipular el archivo
    FileWriter escribir;//para poder llenar los datos
    PrintWriter reglon;//para agregar un nuevo reglon con información

    public datos() {
    }

    public static String getNombre1() {
        return nombre1;
    }

    public static void setNombre1(String aNombre1) {
        nombre1 = aNombre1;
    }

    public static String getNombre2() {
        return nombre2;
    }

    public static void setNombre2(String aNombre2) {
        nombre2 = aNombre2;
    }

    public static String getPais1() {
        return pais1;
    }

    public static void setPais1(String aPais1) {
        pais1 = aPais1;
    }

    public static String getPais2() {
        return pais2;
    }

    public static void setPais2(String aPais2) {
        pais2 = aPais2;
    }

    public static String getOp1() {
        return op1;
    }

    public static void setOp1(String aOp1) {
        op1 = aOp1;
    }

    public static String getOp2() {
        return op2;
    }

    public static void setOp2(String aOp2) {
        op2 = aOp2;
    }

    public static int getRonda() {
        return ronda;
    }

    public static void setRonda(int aRonda) {
        ronda = aRonda;
    }

    public static int getResul1() {
        return resul1;
    }

    public static void setResul1(int aResul1) {
        resul1 = aResul1;
    }

    public static int getResult2() {
        return result2;
    }

    public static void setResult2(int aResult2) {
        result2 = aResult2;
    }

    void partida() {//función partida

        Juega1 j1 = new Juega1();

        if (ronda <= 5) {//si la ronda es menor o igual que 5 se muestra la ventana de juego 

            j1.setVisible(true);

        } else {
            try {
                archivo = new File("RECORDS.txt");
                escribir = new FileWriter(archivo, true);
                reglon = new PrintWriter(escribir);
                if (resul1 > result2) {// se escribe quien es el ganador según los resulados
                    reglon.println("El gran GANADOR es: " + nombre1 + " con el puntaje de " + resul1 + " contra " + result2 + " de " + nombre2 + "\n\n\n");
                    System.out.println("El gran GANADOR es: " + nombre1 + " con el puntaje de " + resul1 + " contra " + result2 + " de " + nombre2 + "\n\n\n");
                } else if (resul1 < result2) {
                    reglon.println("El gran GANADOR es: " + nombre2 + " con el puntaje de " + result2 + " contra " + resul1 + " de " + nombre1 + "\n\n\n");
                    System.out.println("El gran GANADOR es: " + nombre2 + " con el puntaje de " + result2 + " contra " + resul1 + " de " + nombre1 + "\n\n\n");
                } else {
                    reglon.println("Se dio un EMPATE entre " + nombre1 + " y " + nombre2 + " con el puntaje de " + resul1 + "\n\n\n");
                    System.out.println("Se dio un EMPATE entre " + nombre1 + " y " + nombre2 + " con el puntaje de " + resul1 + "\n\n\n");

                }
                reglon.close();
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
            }

            principal ver = new principal();
            ver.setVisible(true);
            //}
        }
    }

    void comparar() {//funcion para determinar quien gana a quien

        switch (getIten()) {

            case 0:
                juega1_piedra();//si se escogio piedra se inicializa la comparación a las  3posibles respuestas
                break;
            case 1:
                juega1_papel();//si se escogio papel se inicializa la comparación a las 3posibles respuestas
                break;
            case 2:
                juega1_tijera();//si se escogio tijera se inicializa la comparación para las 3 posibles respuestas
                break;
        }

    }

    void juega1_piedra() {

        switch (getIten2()) {

            case 0:
                resul1 = resul1 + 5;
                result2 = result2 + 5;
                muestraDatos();

                break;
            case 1:
                resul1 = resul1 + 0;
                result2 = result2 + 15;
                muestraDatos();
                break;
            case 2:
                resul1 = resul1 + 15;
                result2 = result2 + 0;
                muestraDatos();
                break;

        }

    }

    void juega1_papel() {

        switch (getIten2()) {

            case 0:
                resul1 = resul1 + 15;
                result2 = result2 + 0;
                muestraDatos();

                break;
            case 1:
                resul1 = resul1 + 5;
                result2 = result2 + 5;
                muestraDatos();
                break;
            case 2:
                resul1 = resul1 + 0;
                result2 = result2 + 15;
                muestraDatos();
                break;

        }

    }

    void juega1_tijera() {

        switch (getIten2()) {

            case 0:
                resul1 = resul1 + 0;
                result2 = result2 + 15;
                muestraDatos();
                break;
            case 1:
                resul1 = resul1 + 15;
                result2 = result2 + 0;
                muestraDatos();
                break;
            case 2:
                resul1 = resul1 + 5;
                result2 = result2 + 5;
                muestraDatos();
                break;

        }

    }

    void muestraDatos() {//función para cerar el arhivo en caso de que no exista, así co tambien almacenar los datos de cada escogenia

        archivo = new File("RECORDS.txt");
        if (!archivo.exists()) {

            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                reglon = new PrintWriter(escribir);

                reglon.println("En la Ronda " + ronda + "\nEl Jugador " + nombre1 + "     Del país " + pais1 + "    selecionó   " + op1 + "  puntaje " + resul1
                        + "\nEl Jugador " + nombre2 + "     Del país " + pais2 + "    seleccionó " + op2 + "  puntaje " + result2 + "\n\n");

                reglon.close();
                escribir.close();

            } catch (IOException ex) {
                Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("En la Ronda " + ronda + "\nEl Jugador " + nombre1 + "     Del país " + pais1 + "    selecionó   " + op1 + "  puntaje " + resul1
                    + "\nEl Jugador " + nombre2 + "     Del país " + pais2 + "    seleccionó " + op2 + "  puntaje " + result2 + "\n\n");

        } else {
            try {

                escribir = new FileWriter(archivo, true);
                reglon = new PrintWriter(escribir);

                reglon.println("En la Ronda " + ronda + "\nEl Jugador " + nombre1 + "     Del país " + pais1 + "    selecionó   " + op1 + "  puntaje " + resul1
                        + "\nEl Jugador " + nombre2 + "     Del país " + pais2 + "    seleccionó " + op2 + "  puntaje " + result2 + "\n\n");

                if (ronda == 6) {

                } else {
                    reglon.close();
                    escribir.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("En la Ronda " + ronda + "\nEl Jugador " + nombre1 + "     Del país " + pais1 + "    selecionó   " + op1 + "  puntaje " + resul1
                    + "\nEl Jugador " + nombre2 + "     Del país " + pais2 + "    seleccionó " + op2 + "  puntaje " + result2 + "\n\n");
        }

    }

  
    public static int getIten() {
        return iten;
    }

    public static void setIten(int aIten) {
        iten = aIten;
    }

    public static int getIten2() {
        return iten2;
    }

    public static void setIten2(int aIten2) {
        iten2 = aIten2;
    }
}
