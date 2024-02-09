import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Estudiante implements Comparable<Estudiante>{
    private String nombre;
    private int altura;
    private int edad;

    public Estudiante(String nombre, int altura, int edad){
        this.nombre=nombre;
        this.altura=altura;
        this.edad=edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAltura() {
        return altura;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public int compareTo(Estudiante o) {
        if(altura>o.altura)
            return 1;
        if(altura<o.altura)
            return -1;
        else if(edad>o.edad)
            return 1;
        if(edad<o.edad)
            return 0;
        else
            return 0;
    }
}

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Estudiante> lista = new ArrayList<Estudiante>();

        int cont=0, altura, edad;
        String nombre;

        System.out.println("Ahora ingresarás el nombre, altura y edad de 10 estudiantes para después ser ordenador por altura y edad.");

        do{
            System.out.println("Ingresa el nombre del " + (cont+1) + "º estudiante: ");
            nombre = sc.next();
            System.out.println("Ingresa la altura del " + (cont+1) + "º estudiante: ");
            altura = sc.nextInt();
            System.out.println("Ingresa la edad del " + (cont+1) + "º estudiante: ");
            edad = sc.nextInt();

            Estudiante e = new Estudiante(nombre,altura,edad);

            lista.add(e);

            cont++;
        }while(cont<4);

        Collections.sort(lista);
        Collections.reverse(lista);

        for(Estudiante e: lista)
            System.out.println("Nombre: " + e.getNombre() + " Altura: " + e.getAltura() + " Edad: " + e.getEdad());

    }
}
