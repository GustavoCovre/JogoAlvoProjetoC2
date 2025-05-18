package Entidades;

public abstract class Alvo {
	protected static int quantADestruir=3;
	protected int posX;
	protected int posY;
	
	public Alvo(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	public static int getQuantADestruir() {
		return quantADestruir;
	}

	public static void setQuantADestruir(int quantADestruir) {
		Alvo.quantADestruir = quantADestruir;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public boolean igual(Alvo outro){
		return (this.posX == outro.posX && this.posY == outro.posY);
	}

	@Override
	public String toString() {
		 return "Alvo em (" + posX + ", " + posY + ")";
	}
	
	public abstract boolean acerta(int tiroX, int tiroY);

}
