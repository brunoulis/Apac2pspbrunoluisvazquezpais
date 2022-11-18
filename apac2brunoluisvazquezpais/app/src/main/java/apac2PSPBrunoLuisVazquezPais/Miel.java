package apac2PSPBrunoLuisVazquezPais;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

class Posicion {
    int x;
    int y;

    Posicion() {
        x = 0;
        y = 0;
    }

    Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class Miel {

    protected List<Posicion> Panal;
    int cantidad;

    Miel(int cantidad) {
        // cantidad indicarà la cantidad de miel
        // que habrá simultáneamente en el canal.

        this.cantidad = cantidad;
        Panal = new ArrayList<Posicion>();

    }

    public Posicion[] getPositions() {

        return this.Panal.toArray(new Posicion[Panal.size()]);
    }

    public synchronized Boolean PanalDisponible() {

        return (this.Panal.size() < this.cantidad);
    }

    public synchronized Boolean MielDisponible() {
        return (this.Panal.size() > 0);
    }

    // To-Do: Implementación del método Produce(int x, int y)
    public synchronized void Produce(int x, int y) {
        if (PanalDisponible()) {
            Panal.add(new Posicion(x, y));
        }

    }

    // To-Do: Implementación del método Recolecta(int x, int y).
    public synchronized void Recolecta(int x, int y) {
        if (MielDisponible()) {
            for (int i = 0; i < Panal.size(); i++) {
                if ((x >= Panal.get(i).getX() - 5) && (x <= Panal.get(i).getX() + 5) && (y >= Panal.get(i).getY() - 5)
                        && (y <= Panal.get(i).getY() + 5)) {
                    Panal.remove(i);
                }
            }
        }

    }

    // Método para dibujar el panal
    public void drawMe(GraphicsContext gc) {
        Image image = new Image(getClass().getResourceAsStream("mel.png"));

        Posicion[] pos = getPositions();

        for (int i = 0; i < pos.length; i++) {
            gc.drawImage(image, pos[i].getX(), pos[i].getY());
        }

    }
}
