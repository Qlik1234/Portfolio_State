package de.hrw.adswen.portfolio_state;

public class ProdSuche implements ShopState 
{

	public ShopState doAction(OnlineShop onlineShop) 
	{
		
		if(onlineShop.getShopAktivitaet() == Const.PROD_HINZUFUEGEN)
		{
			onlineShop.setAnzahlProdukte(onlineShop.getAnzahlProdukte()+1);
			onlineShop.setShopAktivitaet(Const.PROD_SUCHEN);
			return new WarenkorbAktualisieren();
		}
		else if(onlineShop.getShopAktivitaet() == Const.ZUM_WARENKORB)
		{
			return new Warenkorb();
		}
		else
		{
			return this;
		}
	}
}
