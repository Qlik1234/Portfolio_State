package de.hrw.adswen.portfolio_state;

public class Warenkorb implements ShopState  {

	public ShopState doAction(OnlineShop onlineShop) {

		if(onlineShop.getShopAktivitaet() == Const.PROD_ENTFERNEN)
		{
			if (onlineShop.getAnzahlProdukte() > 0)
			{
				onlineShop.setAnzahlProdukte(onlineShop.getAnzahlProdukte()-1);
			}
			onlineShop.setShopAktivitaet(Const.ZUM_WARENKORB);
			return new WarenkorbAktualisieren();
		}
		else if(onlineShop.getShopAktivitaet() == Const.PROD_SUCHEN)
		{
			return new ProdSuche();
		}
		else if(onlineShop.getShopAktivitaet() == Const.ZUR_KASSE)
		{
			return new Kasse();
		}
		else
		{
			return this;
		}
	}
}
