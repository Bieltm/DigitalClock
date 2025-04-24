import acm.graphics.GCanvas;

public class DecimalNumber {
	private DecimalDigit[] digits;

	/* Construeix un número decimal format per numDigits dígits.
	El número ocuparà l'espai indicat per dnBox. Els dígits estan disposats, un al costat de l'altre, de forma horitzontal.
	*/
	public DecimalNumber (int numDigits, Box dnBox) {
		Box[] boxes= dnBox.distributeHorizontally(numDigits);
		this.digits = new DecimalDigit[numDigits];
		for (int i = 0; i < numDigits; i++) {
			this.digits[i] = new DecimalDigit(boxes[i]);
		}
	}

	/* Afegeix els dígits al canvas indicat per gCanvas.
	*/
	public void addToGCanvas (GCanvas gCanvas) {
		for (int i = 0; i < this.digits.length; i++) {
			this.digits[i].addToGCanvas(gCanvas);
		}
	}

	/* Mostra el número indicat per number usant els diferents dígits de què consta el número.
	*/
	public void render (int number) {
		//Converteixo el int en array, per a que el render pugui tractar amb cada dada unitat per unitat.
		// 264 = {2, 6, 4}
		int[] numbers = new int[this.digits.length];
		int carry = 0;
		numbers[digits.length-1] = number;
		for (int i = digits.length - 1; i >= 0; i--) {
			numbers[i]=numbers[i]+carry;
			carry=0;
			while (numbers[i] >= 10){
				carry++;
				numbers[i]-=10;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			this.digits[i].render(numbers[i]);
		}
	}

}
