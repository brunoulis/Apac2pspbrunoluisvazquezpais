import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

class Player {  // Quizá tengamos que añadir algo más aquí...

    private Integer x = 100, y = 100;
    private Integer screenX, screenY;
    private Miel panal;
    private String direccion;

    // Constructores

    Player() {
        screenX = 100;
        screenY = 100;
        direccion = "RIGHT";
    }

    Player(Miel panal) {
        screenX = 100;
        screenY = 100;
        direccion = "RIGHT";
        this.panal=panal;
    }

    Player(Integer x, Integer y, Miel panal) {
        screenX = x;
        screenY = y;
        this.panal = panal;
        this.x = 100 + (int) (java.lang.Math.random() * screenX - 100);
        this.y = 100 + (int) (java.lang.Math.random() * screenY - 100);
        direccion = "RIGHT";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    // TONO-DO: Crear el método que se invoque cuando creamos el hilo del jugador.
    // 
    // Este método deberá:
    // 1. mover el jugador según la dirección que este tenga.
    // 2. Hacer una pequeña pausa en el thread (10 ms por ejemplo)
    // 3. Detectar si ha llegado a la miel, y consumirla.


    public void drawMe(GraphicsContext gc) {
        Image image=null;
        if (direccion=="LEFT") image = new Image(getClass().getResourceAsStream("apicultor.png"));
        else image = new Image(getClass().getResourceAsStream("apicultorD.png"));
        gc.drawImage(image, x, y, 40, 65);

    }
}
