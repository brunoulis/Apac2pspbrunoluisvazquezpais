import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

// Nuestra aplicación derivará de la clase Application
// por ser una aplicación JavaFX
public class App extends Application {

    // Establecemos las dimensiones del canvas (àrea de dibujo)
    public static final int W = 800;
    public static final int H = 600;

    // Establecemos los atributos de clase aplicación: número
    // de abejas, osos y tamaño del panal
    private int num_abejas;
    private int tamanyo_panal;
    private int num_osos;

    // Y los hilos correspondientes a cada tipo de objeto
    // Podéis reemplazar los vectores por listas, si lo deseáis
    // Nota: Las abejas hacen de hilos productores
    // y los osos y el jugador de consumidores
    // El objeto compartido será el panal
    private Thread[] ListaThreadsAbejas;
    private Thread[] ListaThreadsOsos;
    private Abeja[] ListaAbejas;
    private Oso[] ListaOsos;
    private Player player;
    private Thread threadPlayer;

    private Miel panal;

    public void init() {
        // Método para inicializar la aplicación
        // Leemos los parámetros
        List<String> args = getParameters().getRaw();

        // Para establecer el número de abejas, osos y 
        // el tamaño del panal
        this.num_abejas = Integer.parseInt(args.get(0));
        this.num_osos = Integer.parseInt(args.get(1));
        this.tamanyo_panal = Integer.parseInt(args.get(2));

        try {
            // TO-DO

            // - Declarar un vector o lista de hilos para las abejas,
            // otro para los osos, así como un nuevo hilo para el jugador.

            // Creamos un objeto compartido (panal) de tipo Miel, 
            // de la longitud indicada per el tamaño del panal.
            panal = new Miel(this.tamanyo_panal);

            // Creamos el jugador
            player = new Player(panal);

            // TO-DO
            // - Creación de los threads para las abejas
            // - Creación de los threads para los osos
            // - Creación del thread para el jugador

            // TO-DO
            // - Arrancamos los threads de las abejas
            // - Arrancamos los threads de lps osos
            // - Arrancamos el thread del jugador

        } catch (Exception e) {

        }

    }

    @Override
    public void start(Stage stage) {

        // Aqui se inicia el bucle infinito de la animación (bucle de juego)
        // Define un Timeline para generar la animación (AnimationTimer)

        DoubleProperty x = new SimpleDoubleProperty();
        DoubleProperty y = new SimpleDoubleProperty();

        Timeline Timeline = new Timeline(new KeyFrame(Duration.seconds(0), new KeyValue(x, 0), new KeyValue(y, 0)),
                new KeyFrame(Duration.seconds(3), new KeyValue(x, W - 20), new KeyValue(y, H - 20)));
        Timeline.setAutoReverse(true);
        Timeline.setCycleCount(Timeline.INDEFINITE);

        // Aqui genera el canvas (lienzo), sobre el que pintaremos
        // los diferentes elementos del juego

        final Canvas canvas = new Canvas(W, H);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    // Cogemos el contexto gráfico
                    GraphicsContext gc = canvas.getGraphicsContext2D();
                    // Aqui limpiamos la pantalla
                    gc.setFill(Color.BEIGE); // Color de fondo de la pantalla
                    gc.fillRect(0, 0, W, H); // Para borrar la pantalla

                    
                    // Y ahora dibujamos cada elemento
                    for (int i = 0; i < num_osos; i++) {
                        // TO-DO: Eliminamos este comentario para dibujar los osos
                        // ListaOsos[i].drawMe(gc);
                    }
                    
                    for (int i = 0; i < num_abejas; i++) {
                        // TO-DO: Eliminar este comentario para dibujar las abejas
                        // ListaAbejas[i].drawMe(gc);
                    }

                    // TO-DO:
                    // Eliminar comentarios cuando tengamos panal y jugador a punto
                    // panal.drawMe(gc);
                    // player.drawMe(gc);

                    //
                    // Si deseamos dibujar más cosas, deberíamos hacerlo aquí
                    //
                    
                } catch (Exception e) {
                    System.out.println("Excepción: " + e.getMessage());
                }

            }
        };

        // Creamos la escena a partir del Canvas
        Scene scene = new Scene(new Group(canvas));
        // Añadimos la escena al Stage
        stage.setScene(scene);
        // Detectamos la pulsasción de las teclas
        scene.setOnKeyPressed(event -> {
            String codeString = event.getCode().toString();
            // System.out.println(codeString);
            player.setDireccion(codeString);
        });

        stage.show();

        timer.start();
        Timeline.play();

        ;
    }

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Sintaxis incorrecta\n Sintaxis: java App nº_abejas nº_osos tamanyo_panal");
            System.exit(0);
        }
        launch(args);

    }

}
