package com.victorlopez.tema08.Ejercicio3;

public class Alumno {
    private int nia;//Variable que almacena el nia del alumno

    /**
     * Método que convierte a String todos los atributos de la clase
     * @return Devolvemos el String
     */
    @Override
    public String toString() {
        return "Alumno{" +
                "nia=" + nia +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", grupo='" + grupo + '\'' +
                ", telefono=" + telefono +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }

    /**
     * Método para asignar el número de alumnos
     */
    public static void decrementoAlumnos() {
        Alumno.nAlumnos = Alumno.nAlumnos - 1;
    }

    private String nombre;//Variable que almacena el nombre del alumno
    private String apellidos;//Variable que almacena los apellidos del alumno
    private String grupo;//Variable que almacena el grupo del alumno
    private int telefono;//Variable que almacena el tfno del alumno
    private String fechaNacimiento;//Variable que almacena la fecha de nacimiento del alumno
    private static int nAlumnos;//Variable que almacena el número de alumnos

    /**
     * Constructor de la clase alumno
     * @param nia atributo que almacena el nia
     * @param nombre atributo que almacena el nombre
     * @param apellidos atributo que almacena los apellidos
     * @param grupo atributo que almacena el grupo
     * @param telefono atributo que almacena el telefono
     * @param fechaNacimiento atributo que almacena la fecha de nacimiento
     */
    public Alumno(int nia, String nombre, String apellidos, String grupo, int telefono, String fechaNacimiento) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.grupo = grupo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        nAlumnos++;
    }

    /**
     * Método para obtener el NIA
     * @return devuelve un entero que es el nia
     */
    public int getNia() {
        return nia;
    }

    /**
     * Método para obtener el nombre
     * @return devuelve un String que es el nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método para obtener los apellidos
     * @return devuelve un String que son los apellidos
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * Método para obtener el grupo
     * @return devuelve un String que es el grupo
     */
    public String getGrupo() {
        return grupo;
    }
    /**
     * Método para obtener el número de teléfono
     * @return devuelve un entero que es el telefono
     */
    public int getTelefono() {
        return telefono;
    }
    /**
     * Método para obtener la fecha de nacimiento
     * @return devuelve un String que es la fecha de nacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    /**
     * Método para obtener el número de alumnos
     * @return devuelve un entero que son el num de alumnos
     */
    public static int getnAlumnos() {
        return nAlumnos;
    }

    /**
     * Método para definir el telefono
     * @param telefono telefono final
     */
    public void setTelefono(int telefono) {

        this.telefono = telefono;
    }
    /**
     * Método para definir el grupo
     * @param grupo grupo final
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    /**
     * Método para definir el nombre
     * @param nombre nombre final
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método para definir los apellifos
     * @param apellidos apellidos finales
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
