package lab11_1;

public class BubbleSort implements Strategy {

	@Override
	public void sort(Phone[] phones) {
		boolean troca = true;
        Phone aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < phones.length - 1; i++) {
                if (phones[i].getPrice() > phones[i + 1].getPrice()) {
                    aux = phones[i];
                    phones[i] = phones[i + 1];
                    phones[i + 1] = aux;
                    troca = true;
                }
            }
        }
	}	
}
