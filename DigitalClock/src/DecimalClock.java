import acm.graphics.GCanvas;

public class DecimalClock {
	private static int NUM_DECIMALS = 3;
	private static int NUM_DIGITS = 2;
	DecimalNumber[] decnum= new DecimalNumber[NUM_DECIMALS];
	/* Construeix un rellotge que usa tres nombres decimals per a indicar hores, minuts i segons i el col·loca en la caixa indicada per dcBox.
	*/
	public DecimalClock (Box dcBox) {
		Box[] boxes = dcBox.distributeHorizontally(NUM_DECIMALS);
		for (int i = 0; i < NUM_DECIMALS; i++) {
			this.decnum[i] = new DecimalNumber(NUM_DIGITS, boxes[i]);
		}
	}

	/* Afegeix els tres números al canvas indicat per gCanvas.
	*/
	public void addToGCanvas (GCanvas gCanvas) {
		for (int i = 0; i < NUM_DECIMALS; i++) {
			this.decnum[i].addToGCanvas(gCanvas);
		}
	}
	/* Mostra l'hora indicada.
	*/
	public void render (int hours, int minutes, int seconds) {
		//guardo al array les dades en el ordre que vull que es guardi al decnum.
		int[] numbers = { hours, minutes, seconds };
		for (int i = 0; i < NUM_DECIMALS; i++) {
			this.decnum[i].render(numbers[i]);
		}
	}

}
