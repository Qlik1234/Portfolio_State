package de.hrw.adswen.portfolio_state;

public class Kasse implements ShopState 
{

	public ShopState doAction(OnlineShop onlineShop) 
	{

		if(onlineShop.getShopAktivitaet() == Const.ZUM_WARENKORB)
		{
			return new Warenkorb();
		}
		else if(onlineShop.getShopAktivitaet() == Const.KAUF_ABSCHLUSS)
		{
			return this;
		}
		else
		{
			return this;
		}
	}
}
