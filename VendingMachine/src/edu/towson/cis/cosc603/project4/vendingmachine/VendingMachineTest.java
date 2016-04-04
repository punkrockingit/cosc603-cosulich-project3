package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * @author William Cosulich
 * This is the class for testing the vending machine class 
 */
public class VendingMachineTest {
	private static VendingMachine vendingMachine = null;
	private static VendingMachineItem ItemA = null;
	private static VendingMachineItem ItemB = null;
	private static VendingMachineItem ItemC = null;
	private static VendingMachineItem ItemD = null;
	private VendingMachineException machineException;
	
	/*
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		vendingMachine = new VendingMachine();
		ItemA = new VendingMachineItem("Snickers", 1);
		ItemB = new VendingMachineItem("Sun Chips", 1);
		ItemC = new VendingMachineItem("Milky Way", 1);
		ItemD = new VendingMachineItem("Crumb Cake", 1.5);		
	}
	
	/**
	 * This tests that the addItem() method has the correct input.
	 */
	@Test
	public void testAddItem() {
		
		vendingMachine.addItem(ItemA, "A");
		assertTrue((Arrays.asList(vendingMachine.itemArray[0]).contains(ItemA)));
		
		vendingMachine.addItem(ItemB, "B");
		assertTrue((Arrays.asList(vendingMachine.itemArray[1]).contains(ItemB)));
		
		vendingMachine.addItem(ItemC, "C");
		assertTrue((Arrays.asList(vendingMachine.itemArray[2]).contains(ItemC)));

		vendingMachine.addItem(ItemD, "D");
		assertTrue((Arrays.asList(vendingMachine.itemArray[3]).contains(ItemD)));

	}
	
	/*
	 * This tests the addItem() method for the case where the add item is already occupied slot.
	 */
	@Test
	public void testAddItemOccupied(){
		vendingMachine.addItem(ItemD, "D");
		assertTrue((Arrays.asList(vendingMachine.itemArray[3]).contains(ItemD)));
	}
	
	/*
	 * This tests the removeItem() method with good input.
	 */	
	@Test
	public void testRemoveItem() {
		vendingMachine.addItem(ItemA, "A");
		assertSame(ItemA, vendingMachine.removeItem("A"));
	}
	
	
	/** 
	 * This tests the removeItem() method for the case to remove the item from empty slot. 
	 */	
	@Test (expected = VendingMachineException.class)
	public void testRemoveItemEmptySlot() {
		assertSame(machineException, vendingMachine.removeItem("B"));
	}

	
	/**
	 * This tests the insertMoney() method with amount >= 0
	 */
	@Test
	public void testInsertMoney() {
		vendingMachine.insertMoney(0);
		assertEquals(0, vendingMachine.getBalance(), 0.0);
		vendingMachine.insertMoney(1.5);
		assertEquals(1.5, vendingMachine.getBalance(), 0.0);
		vendingMachine.insertMoney(1.5);
		assertEquals(3.0, vendingMachine.getBalance(), 0.0);
	}
	
	/*
	 * This tests the insertMoney() method with amount < 0
	 */
	@Test (expected = VendingMachineException.class)
	public void testInsertMoneyInvalidAmount() {
		vendingMachine.insertMoney(-1);
	}
	
	/*
	 * This tests the makePurchase() method with good input.
	 */
	@Test
	public void testMakePurchase() {
		vendingMachine.addItem(ItemA, "A");
		vendingMachine.insertMoney(1.5);
		assertEquals(true,vendingMachine.makePurchase("A"));
	}
	
	/*
	 * This tests the makePurchase() method for code of empty slot
	 */
	@Test
	public void testMakePurchaseEmptySlot() {
		vendingMachine.insertMoney(1.5);
		assertEquals(false,vendingMachine.makePurchase("B"));
	}
	
	
	/*
	 * This tests the makePurchase() method for code of empty slot
	 */
	@Test
	public void testMakePurchaseInSufficientBalance() {
		vendingMachine.insertMoney(1.5);
		assertEquals(false,vendingMachine.makePurchase("C"));
	}
	
	/*
	 * This tests the getBalance() method
	 */
	@Test
	public void testGetBalance(){
		vendingMachine.insertMoney(1.5);
		assertEquals(1.5, vendingMachine.getBalance(),0.0);
	}
	
	/*
	 * This tests the getBalance() method with bad input 
	 */  
	@Test
	public void testGetBalanceBadInput(){
		vendingMachine.insertMoney(1.5);
		assertFalse(vendingMachine.getBalance() == 3.0);
	}
	 
	
	/*
	 * This tests the returnChange() method 
	 */
	@Test
	public void testReturnChange() {
		vendingMachine.addItem(ItemD, "D");
		vendingMachine.insertMoney(1.5);
		vendingMachine.makePurchase("D");
		assertEquals(0.0, vendingMachine.returnChange(),0.0);
	}
	
	/*
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		vendingMachine = null;
		ItemA = null;
		ItemB = null;
		ItemC = null;
		ItemD = null;
	}

}
