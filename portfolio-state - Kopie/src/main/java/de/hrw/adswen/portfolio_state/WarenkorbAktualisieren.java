package de.hrw.adswen.portfolio_state;

public class WarenkorbAktualisieren implements ShopState {

	public ShopState doAction(OnlineShop onlineShop) {

		System.out.println( "Anzahl der Produkte im Warenkorb:" + onlineShop.getAnzahlProdukte() + "\n");
	
		if(onlineShop.getShopAktivitaet() == Const.PROD_SUCHEN)
		{
			return new ProdSuche();
		}
		else if(onlineShop.getShopAktivitaet() == Const.ZUM_WARENKORB)
		{
			return new Warenkorb();
		}
		else
		{	
			// default case
			return new ProdSuche();
		}
	}
}
