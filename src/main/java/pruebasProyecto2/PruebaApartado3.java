package pruebasProyecto2;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import businessLogic.BLFactory;
import domain.User;
import gui.WindowTable;

public class PruebaApartado3{
	public static void main(String[] args) {
		try {
			int isLocal = 1;
			BLFacade blFacade = (new BLFactory()).getBusinessLogicFactory(isLocal);
			User user = blFacade.getUser("MaiteUrreta");
			WindowTable vt = new WindowTable(user);
			vt.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}