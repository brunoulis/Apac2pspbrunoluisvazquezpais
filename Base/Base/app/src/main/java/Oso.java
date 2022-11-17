import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

class Oso { // Quizás tengamos que añadir algo aquí

    private Integer x = 100, y = 100;
    private Integer screenX, screenY;
    private Miel panal;
    private Boolean isEating = false;

    // Constructores

    Oso() {
        screenX = 100;
        screenY = 100;
    }

    Oso(Integer x, Integer y, Miel panal) {
        // TO-DO
        // Constructor: tened en cuenta que x e y son las
        // dimensiones de la ventana 
        // La posición del oso se obtendrá aleatoriamente
        // dentro de esta vantana.

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Boolean isRunning() {
        return !isEating;
    }

    // TO-DO: Crear el método que se invoque cuando creemos el hilo del oso

    // Este método deberá:

    // 1. Obtener la porción de miel del panal que tiene más cerca
    //
    // 2. Mover el oso hacia la posición
    //
    // 3. Hacer una pequeña pausa en el thread (10 ms por ejemplo)
    // 
    // 4. Detectar si ha llegado a la miel, y consumirla
    // si es así. Para consumirla, además de modificar el panal,
    // hará una pausa de 2 segundos, tiempos durante el cual su estado
    // será isEating=true (es decir, ponemos el estado isEating=true, hacemos la
    // pausa de 2s y restauramos el estado a isEating=false)


    // Método para dibujar al oso
    public void drawMe(GraphicsContext gc) {

        Image image;
        if (isRunning())
            image = new Image(getClass().getResourceAsStream("os.png"));
        else
        image = new Image(getClass().getResourceAsStream("osMenjant.png"));
            
        gc.drawImage(image, x, y);

    }
}
