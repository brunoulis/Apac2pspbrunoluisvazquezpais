package apac2PSPBrunoLuisVazquezPais;

import apac2PSPBrunoLuisVazquezPais.Miel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

class Abeja implements Runnable { // Puede que tengamos que añadir aquí alguna cosa
    // Posición de la abeja que modificaremos en el constructor
    private Integer x = 100, y = 100;
    // Posición inicial de la abeja
    private Integer incx = 3, incy = 3;
    private Integer storedX = 0, storedY = 0;
    // Tamaño de la ventana
    private Integer screenX, screenY;
    // Panal de la abeja
    private Miel panal;

    // Constructores

    Abeja() {
        // Constructor vacío (en principi no se utilizará)
        screenX = 100;
        screenY = 100;
    }

    Abeja(Integer screenX, Integer screenY, Miel panal) {
        // TO-DO
        // Constructor: tenend en cuetna que x e y son
        // las dimensiones de la ventana.
        // La posición de la Abeja se obtendrá aleatoriamente
        // dentro de la ventana.
        this.screenX = screenX;
        this.screenY = screenY;
        this.panal = panal;
        x = incx + (int) (Math.random() * (screenX - incx));
        y = incy + (int) (Math.random() * (screenY - incy));

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // TO-DO: Crear el método que se invoque cuando se cree el hilo de la Abeja.
    // Este método deberá:
    // 1. Comprobar si se ha llegado a algun borde de la pantalla
    // para cambiar la dirección de vuelo.
    //
    // 2. Mover la Abeja
    //
    // 3. Realizar una pequeña pausa (20 ms por ejemplo)
    //
    // 4. Con una probabilidad del 1% producir Miel.
    //
    @Override
    public void run() {
        while (true) {
            if (x <= 0) {
                incx = +incx;
            }
            if (x >= screenX) {
                incx = -incx;
            }

            if (y <= 0) {
                incy = +incy;
            }
            if (y >= screenY) {
                incy = -incy;
            }

            if (x > screenX)
                incx = -(3 + (int) (java.lang.Math.random() * 4));
            if (y > screenY)
                incy = -(3 + (int) (java.lang.Math.random() * 4));
            x += incx;
            y += incy;
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                System.out.println("Error en el hilo de la abeja");
            }
            // 4. Con una probabilidad del 1% producir Miel.
            if (Math.random() < 0.01) {
                panal.Produce(getX(), getY());
            }
        }
    }

    // Método para dibuijar la Abeja
    public void drawMe(GraphicsContext gc) {
        Image image = new Image(getClass().getResourceAsStream("bee.png"));
        gc.drawImage(image, x, y);
    }

}
