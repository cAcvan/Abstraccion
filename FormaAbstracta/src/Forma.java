import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public  abstract class Forma implements Comparable<Rectangulo> {
    private int numLados;

    public Forma(int lados){
        this.numLados=lados;
    }

    public int getNumLados() {
        return numLados;
    }

    public abstract int getArea();

    public abstract int getPerimeter();
}

class Rectangulo extends Forma implements Redimensionable{
    private int alto;
    private int ancho;

    public Rectangulo(int alto, int ancho) {
        super(4);
        this.alto=alto;
        this.ancho=ancho;
    }

    @Override
    public int getArea() {
        return alto*ancho;
    }

    @Override
    public int getPerimeter() {
        return (alto*2)+(ancho*2);
    }

    @Override
    public void redimensionar(int x) {
        this.alto=x;
    }

    @Override
    public int compareTo(Rectangulo o) {
        if(alto*ancho>o.alto*o.ancho){
            return 1;
        }
        if(alto*ancho<o.alto*o.ancho){
            return -1;
        } else{
            return 0;
        }
    }
}

class Triangulo extends Forma{
    private int ancho;
    private int alto;

    public Triangulo(int alto, int ancho){
        super(3);
        this.alto=alto;
        this.ancho=ancho;
    }

    @Override
    public int getArea(){
        return (alto*ancho)/2;
    }

    @Override
    public int getPerimeter() {
        return ancho*3;
    }

    @Override
    public int compareTo(Rectangulo o) {
        return 0;
    }
}

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cont=0, alto, ancho;
        Rectangulo array[] = new Rectangulo[10];


        System.out.println("Ahora ingresarás 10 alturas y 10 anchuras para ordenar los rectángulos según su area: ");
        do{
            System.out.println("Ingresa la altura: ");
            alto = sc.nextInt();
            System.out.println("Ingresa el ancho: ");
            ancho = sc.nextInt();

            Rectangulo r = new Rectangulo(alto,ancho);
            array[cont]=r;

            System.out.println(cont+1 + "º rectángulo creado.");

            cont++;
        }while(cont<10);

        System.out.println("Ahora vamos a ordenar los rectángulos.");

        ArrayList<Rectangulo> lista = new ArrayList<Rectangulo>();

        for(int i=0;i<10;i++)
            lista.add(array[i]);

        Collections.sort(lista);

        for(Rectangulo r: lista){
            System.out.println("Área: " + r.getArea());
        }
    }
}
