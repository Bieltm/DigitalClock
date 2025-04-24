import acm.graphics.GCanvas;

public class Group {
	private Bar[] stick;
	/*
	Construeix un grup en la caixa indicada per groupBox,
	formada per tantes barres com elements tingui la taula sizes.
	La taula sizes conté el nombre de leds que tenen cadascuna de les barres.
	Les barres estan disposades, una damunt de l'altra, verticalment.
	L'ordre dels sizes es correspon a les mides de les barres de dalt cap avall.
	*/
	public Group (int[] sizes, Box groupBox) {
		Box[] boxes = groupBox.distributeVertically(sizes.length);
		stick = new Bar[sizes.length];
		for (int i = 0; i < sizes.length; i++) {
			stick[i] = new Bar(sizes[i], boxes[i]);
		}
	}

	/* Afegeix totes les barres que formen el grup al canvas gCanvas.
	*/
	public void addToGCanvas (GCanvas gCanvas) {
		for (int i = 0; i < stick.length; i++) {
			stick[i].addToGCanvas(gCanvas);
		}
	}

	/*
	Mostra, en cadascuna de les barres del grup, el valor corresponent de la taula values.
	L'ordre dels elements a la taula values és de baix cap amunt.
	D'aquesta manera, si voleu mostrar el valor d'un número a partir de les seves xifres, la xifra corresponent a les unitats estarà en la posició 0 del vector values.
	*/
	public void render (int[] values) {
		for (int i = 0; i < stick.length; i++) {
			stick[i].render(values[values.length-i-1]);
		}
	}
}
