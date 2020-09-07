package de.hrw.adswen.portfolio_state;


import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;



public class shopTest {
	
	OnlineShop onlineShop;
	
	@Before
	public void setUp()
	{
		onlineShop  = new OnlineShop();
	}	
	
	@Test 
	public void testState_ProdSuche()
	{
		System.out.println( "testState_ProdSuche");
		System.out.println( "--------------------------");
		onlineShop.setShopAktivitaet(Const.PROD_SUCHEN);
		System.out.println( "State Transition: " + onlineShop.getShopAktivitaet());
		
		onlineShop.setActualState( onlineShop.getActualState().doAction(onlineShop) );

		System.out.println( "Shop State: " + onlineShop.getActualState().getClass().getName().substring(30) + "\n");
		assertTrue(onlineShop.getActualState().getClass().getName() == ProdSuche.class.getName());		
	}
	

	@Test 
	public void testState_Warenkorbaktualisieren_ProduktHinzufuegen()
	{
		System.out.println( "testState_Warenkorbaktualisieren_ProduktHinzufuegen");
		System.out.println( "--------------------------");
		onlineShop.setShopAktivitaet(Const.PROD_HINZUFUEGEN);
		onlineShop.setActualState( onlineShop.getActualState().doAction(onlineShop) );

		System.out.println( "State Transition: " + onlineShop.getShopAktivitaet());
		System.out.println( "Shop State: " + onlineShop.getActualState().getClass().getName().substring(30) + "\n");
		assertTrue(onlineShop.getActualState().getClass().getName() == WarenkorbAktualisieren.class.getName());
		
		onlineShop.setActualState( onlineShop.getActualState().doAction(onlineShop) );

		System.out.println( "State Transition: " + onlineShop.getShopAktivitaet());
		System.out.println( "Shop State: " + onlineShop.getActualState().getClass().getName().substring(30) + "\n");
		assertTrue(onlineShop.getActualState().getClass().getName() == ProdSuche.class.getName());
	}
	
	@Test 
	public void testState_Warenkorb()
	{
		System.out.println( "testState_Warenkorb");
		System.out.println( "--------------------------");
		onlineShop.setShopAktivitaet(Const.ZUM_WARENKORB);
		onlineShop.setActualState( onlineShop.getActualState().doAction(onlineShop) );
		System.out.println( "State Transition: " + onlineShop.getShopAktivitaet());
		
		System.out.println( "Shop State: " + onlineShop.getActualState().getClass().getName().substring(30) + "\n");
		assertTrue(onlineShop.getActualState().getClass().getName() == Warenkorb.class.getName());
	}

	@Test 
	public void testState_Warenkorbaktualisieren_ProduktEntfernen()
	{
		System.out.println( "testState_Warenkorbaktualisieren_ProduktEntfernen");
		System.out.println( "--------------------------");
		onlineShop.setShopAktivitaet(Const.ZUM_WARENKORB);
		onlineShop.setActualState( onlineShop.getActualState().doAction(onlineShop) );
		System.out.println( "Shop State: " + onlineShop.getActualState().getClass().getName().substring(30) + "\n");
		assertTrue(onlineShop.getActualState().getClass().getName() == Warenkorb.class.getName());
		
		onlineShop.setShopAktivitaet(Const.PROD_ENTFERNEN);
		onlineShop.setActualState( onlineShop.getActualState().doAction(onlineShop) );

		System.out.println( "Shop State: " + onlineShop.getActualState().getClass().getName().substring(30) + "\n");
		assertTrue(onlineShop.getActualState().getClass().getName() == WarenkorbAktualisieren.class.getName());
		
		onlineShop.setActualState( onlineShop.getActualState().doAction(onlineShop) );

		System.out.println( "State Transition: " + onlineShop.getShopAktivitaet());
		System.out.println( "Shop State: " + onlineShop.getActualState().getClass().getName().substring(30) + "\n");
		assertTrue(onlineShop.getActualState().getClass().getName() == Warenkorb.class.getName());
	}

	
	@Test 
	public void testState_Kasse()
	{
		System.out.println( "testState_Kasse");
		System.out.println( "--------------------------");
		onlineShop.setShopAktivitaet(Const.ZUM_WARENKORB);
		System.out.println( "State Transition: " + onlineShop.getShopAktivitaet());
	
		onlineShop.setActualState( onlineShop.getActualState().doAction(onlineShop) );
		System.out.println( "Shop State: " + onlineShop.getActualState().getClass().getName().substring(30) + "\n");
		assertTrue(onlineShop.getActualState().getClass().getName() == Warenkorb.class.getName());
		
		
		onlineShop.setShopAktivitaet(Const.ZUR_KASSE);
		System.out.println( "State Transition: " + onlineShop.getShopAktivitaet());
		onlineShop.setActualState( onlineShop.getActualState().doAction(onlineShop) );

		System.out.println( "Shop State: " + onlineShop.getActualState().getClass().getName().substring(30) + "\n");
		assertTrue(onlineShop.getActualState().getClass().getName() == Kasse.class.getName());
	}
	
}


