package Entidades;

public class AlvoPreto extends Alvo{

	public AlvoPreto(int posX, int posY) {
		super(posX, posY);
	}

        @Override
	public boolean acerta(int tiroX, int tiroY) {
		if (tiroX == getPosX() && tiroY == getPosY()){
			Alvo.setQuantADestruir(Alvo.getQuantADestruir()- 1);
			return true;
		}else {
			return false;
		}
	}

}
