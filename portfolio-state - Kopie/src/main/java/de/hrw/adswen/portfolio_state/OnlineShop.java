package de.hrw.adswen.portfolio_state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class OnlineShop {

	private ShopState actualState;
	private int anzahlProdukte;
	private String shopAktivitaet;

	/* Defaultzustand ProdSuche im Konstruktor setzen */
    public OnlineShop(){

    	actualState = new ProdSuche();

    	setAnzahlProdukte(0);
    	setShopAktivitaet(Const.PROD_SUCHEN);
    	System.out.println( "OnlineShop started ...\n" );
    	System.out.println( "Shop State: " + this.getActualState().getClass().getName().substring(30) + "\n");
    }
	
/* Getter zum Holen des aktuellen Zustands. */
	public ShopState getActualState() {
		return actualState;
	}
	
/* Setter zum Setzen des aktuellen Zustands. */
	public void setActualState(ShopState actualState) {
		this.actualState = actualState;
	}

	/* Getter zum Holen der Anzahl der Produkte. */
	public int getAnzahlProdukte() {
		return anzahlProdukte;
	}
	
/* Setter zum Setzen der Anzahl der Produkte. */
	public void setAnzahlProdukte(int anzahlProdukte) {
		this.anzahlProdukte = anzahlProdukte;
	}

	public String getShopAktivitaet() {
		return shopAktivitaet;
	}

	public void setShopAktivitaet(String shopAktivitaet) {
		this.shopAktivitaet = shopAktivitaet;
	}
	
	public void act() throws IOException 
	{
		while (true)
		{
		  if ( this.getActualState().getClass().getName() != WarenkorbAktualisieren.class.getName())
		  {

			System.out.println( " ~ MENUE - Shop Aktivitaet ~ ");
			System.out.println( " --------------------------- ");
			System.out.println( " 1: ProduktSuchen");
			System.out.println( " 2: ProduktHinzufuegen");
			System.out.println( " 3: ProduktEntfernen");
			System.out.println( " 4: ZumWarenkorb");
			System.out.println( " 5: ZurKasse");
			System.out.println( " 6: KaufAbschluss");
			System.out.println( " --------------------------- \n");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String input = in.readLine();
			
			
			switch (Integer.parseInt(input))
			{
				case 1: this.setShopAktivitaet(Const.PROD_SUCHEN);
				break;
				
				case 2: this.setShopAktivitaet(Const.PROD_HINZUFUEGEN);
				break;
				
				case 3: this.setShopAktivitaet(Const.PROD_ENTFERNEN);
				break;
				
				case 4: this.setShopAktivitaet(Const.ZUM_WARENKORB);
				break;

				case 5: this.setShopAktivitaet(Const.ZUR_KASSE);
				break;
				
				case 6: this.setShopAktivitaet(Const.KAUF_ABSCHLUSS);
				break;
				
				default: /* Do nothing ... */
				break;
			}
			
		  }
			
			actualState = actualState.doAction(this);
			System.out.println( "Shop State: " + this.getActualState().getClass().getName().substring(30) + "\n");
		}
	}
	
}


