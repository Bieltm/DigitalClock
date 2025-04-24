import acm.graphics.GCanvas;

public class LedsClock {
	//el valor de NUM_GROUPS m'el donen al enunciat
	private static int NUM_GROUPS = 3;

	//el valor de LED_SIZE el dono per suposat, ja que tractant de un rellotje, seran dades de 2 unitats, ex: 09:19 (2 i 2).
	private static int LED_SIZE = 2;

	//el hours_size, es el maxim de valors que pot tenir un rellotje al donar la hora, doncs el max seria 23 hores.
	//3 = {0, 1, 2} || 10 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
	private static int[] hours_size = {3, 10};

	//el minutes_size es igual a el seconds_size, per tant ho faig tot directament amb el minutes_size.
	//el qual tracta de el maxim de num de minuts que seria 59 minuts.
	//6 = {0, 1, 2, 3, 4, 5} || 10 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
	private static int[] minutes_size = {6, 10};

	Group[] ledGroups = new Group[NUM_GROUPS];
	/* Construeix un rellotge que usa tres grups de barres de leds per a indicar hores, minuts i segons i el col·loca en la caixa indicada per lcBox.
	*/
	public LedsClock (Box lcBox) {
		Box[] boxes = lcBox.distributeVertically(NUM_GROUPS);
		for (int i = 0; i < NUM_GROUPS; i++) {
			//en cas de que i==0, vol dir que esta tractant de la hora, per tant es treball amb el tamany hours_size
			if (i == 0){
				this.ledGroups[i] = new Group(hours_size, boxes[i]);
			} else {
				//en altre cas, es tracta amb el tamany de munutes_size
				this.ledGroups[i] = new Group(minutes_size, boxes[i]);
			}
		}
	}

	/* Afegeix els grups de barres de leds al canvas gCanvas.
	*/
	public void addToGCanvas (GCanvas gCanvas) {
		for (int i = 0; i < NUM_GROUPS; i++) {
			this.ledGroups[i].addToGCanvas(gCanvas);
		}
	}

	/* Mostra l'hora indicada.
	*/
	public void render (int hours, int minutes, int seconds) {
		//guardo les dades de hora, minuts i segons en un array per poder aplicar-ho en un for
		int[] d = {hours, minutes, seconds};
		for (int i = 0; i < NUM_GROUPS; i++) {
			//aplico el splitdigits a les dades dintre del array per a convertirles en array i que es pugui aplicar al render
			this.ledGroups[i].render(splitDigits(d[i], LED_SIZE));
		}
	}
	//He creat una funció que converteixi un int a un int[], ex: 23 --> {3, 2}
	public static int[] splitDigits(int number, int size) {
		int[] digits = new int[size];
		String numStr = String.format("%0" + size + "d", number); // afegeix zeros davant si cal
		for (int i = 0; i < size; i++) {
			digits[size - 1 - i] = numStr.charAt(i) - '0';
		}
		return digits;
	}



}
