package apac2PSPBrunoLuisVazquezPais;

import apac2PSPBrunoLuisVazquezPais.Miel;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

class Abeja implements Runnable{ // Puede que tengamos que añadir aquí alguna cosa

    private Integer x=100,y=100;

    private Integer incx=3,incy=3;
    private Integer storedX=0, storedY=0;
    private Integer screenX, screenY;
    private Miel panal;
    
    
    // Constructores

    Abeja(){
        // Constructor vacío (en principi no se utilizará)
        screenX=100;
        screenY=100;
    }
    Abeja(Integer x, Integer y, Miel panal){
        // TO-DO
        // Constructor: tenend en cuetna que x e y son
        // las dimensiones de la ventana.
        // La posición de la Abeja se obtendrá aleatoriamente
        // dentro de la ventana.
        
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    // TO-DO: Crear el método que se invoque cuando se cree el hilo de la Abeja.
    // Este método deberá:
    // 1. Comprobar si se ha llegado a algun borde de la pantalla
    //    para cambiar la dirección de vuelo.
    //
    // 2. Mover la Abeja
    //
    // 3. Realizar una pequeña pausa (20 ms por ejemplo)
    // 
    // 4. Con una probabilidad del 1% producir Miel.
    //
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Método para dibuijar la Abeja
    public void drawMe(GraphicsContext gc){
        Image image = new Image(getClass().getResourceAsStream("bee.png"));
        gc.drawImage(image,x, y);
    }

    
}

