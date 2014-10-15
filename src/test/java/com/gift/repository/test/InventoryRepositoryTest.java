package com.gift.repository.test;

import com.gift.registry.app.conf.ConnectionConfig;
import com.gift.registry.domain.Address;
import com.gift.registry.domain.Customer;
import com.gift.registry.domain.Details;
import com.gift.registry.domain.Inventory;
import com.gift.registry.domain.Invoice;
import com.gift.registry.domain.Product;
import com.gift.registry.domain.Sales;
import com.gift.registry.repository.InventoryRepository;
import com.gift.registry.repository.ProductRepository;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.*;

public class InventoryRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private InventoryRepository inventoryRepository;
    private ProductRepository productRepository;
           
    public InventoryRepositoryTest() {
    }
    
    @Test
    public void createInventory() {
        inventoryRepository = ctx.getBean(InventoryRepository.class);
        productRepository = ctx.getBean(ProductRepository.class);
        
        Sales sales = new Sales.Builder().salesNumber(111).amntSold(10).total(250).build();
        
        ArrayList totalSales = new ArrayList();
        totalSales.add(sales);
        
        Address address = new Address();
        address.setHouse_number(3);
        address.setStreet_address("145 Main Road");
        address.setSuburb("CBD - Cape Town");
        
        Details details = new Details();
        details.setFirstname("Paul");
        details.setLastname("Peterson");
        details.setContactnumber("021 558 4251");
        
        Customer customer = new Customer.Builder().customer_id("cust001").address(address).details(details).build();
        
     //   customerRepository.save(customer);
                
        ArrayList customers = new ArrayList();
        customers.add(customer);
        
        Product product = new Product.Builder().productname("Russell Hobbs Kettle").quantity(2).price(699).colour("Grey")
                .build();
        
        productRepository.save(product);
        
        Invoice invoice = new Invoice.Builder().invoice_date(new Date()).invoice_number("invoice001").build();
       
        ArrayList invoices = new ArrayList();
        invoices.add(invoice);    
        
      //  invoiceRepository.save(invoices);
                
        Inventory inventory = new Inventory.Builder().requestedAmnt((long)6).purchasedAmnt((long)4).remainingAmnt((long)2)
                .sales(totalSales).customers(customers).invoices(invoices).product(product).build();
        
        inventoryRepository.save(inventory);
        
        id = inventory.getId();
        Assert.assertNotNull(inventory);
    }
    
    @Test(dependsOnMethods = "createInventory", enabled = false)
    public void readInventory() {
        inventoryRepository = ctx.getBean(InventoryRepository.class);
        Inventory inventory = inventoryRepository.findOne(id);
        
        Assert.assertEquals(inventory.getPurchasedAmnt(), "4");
        System.out.println("Inventory: Purchaed Amount: " + inventory.getPurchasedAmnt());
    }
    
    @Test(dependsOnMethods = "readInventory", enabled = false)
    public void updateInventory(){
        inventoryRepository = ctx.getBean(InventoryRepository.class);
        Inventory inventory = inventoryRepository.findOne(id);
        
        Inventory updatedInventory = new Inventory.Builder().inventory(inventory).requestedAmnt((long)8)
                .purchasedAmnt((long)4).remainingAmnt((long)4)
                .build();
        
        inventoryRepository.save(updatedInventory);
        
        Inventory newInventory = inventoryRepository.findOne(id);
        
        System.out.println("New updated Inventory: " + newInventory);
        
        Assert.assertEquals(newInventory.getRemainingAmnt(), "4");
     } 
    
    @Test(priority = 4, dependsOnMethods = "updateInventory", enabled = false)
    public void deleteInventory(){
        inventoryRepository = ctx.getBean(InventoryRepository.class);
        Inventory inventory = inventoryRepository.findOne(id);
        
        inventoryRepository.delete(inventory);
        Inventory deletedInventory = inventoryRepository.findOne(id);

        Assert.assertNull(deletedInventory);
        System.out.println("Deleted Inventory: " + deletedInventory);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
