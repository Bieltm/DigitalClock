import acm.graphics.GCanvas;

public class Bar {
    private Led[] led;
    /* Construeix una barra en la caixa indicada per barBox, formada per size leds de la mateixa mida col·locats horitzontalment.
     */
    public Bar (int size, Box barBox) {
        Box[] boxes = barBox.distributeHorizontally(size);
        this.led = new Led[size];
        for (int i = 0; i < size; i++) {
            //Ho he guardat al [size-i-1] per a que vagi en direcció de dreta a esquerra
            this.led[i] = new Led(boxes[size-i-1]);
        }
    }
    /* Afegeix tots els leds que formen la barra al canvas gCanvas.
     */
    public void addToGCanvas (GCanvas gCanvas) {
        for (int i = 0; i < led.length; i++) {
            led[i].addToGCanvas(gCanvas);
        }
    }
    /* Il·lumina el led indicat per value en la barra​, comptant des de 0 de dreta a esquerra.
     */
    public void render (int value) {
        for (int i = 0; i < led.length; i++) {
            //esta apagat i en cas de que i == value, s'engega
            if (i == value) {
                led[i].on();
            } else {
                led[i].off();
            }
        }
    }

}
