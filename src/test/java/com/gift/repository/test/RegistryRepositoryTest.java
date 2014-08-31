package com.gift.repository.test;


import com.gift.registry.app.conf.ConnectionConfig;
import com.gift.registry.domain.Registry;
import com.gift.registry.repository.RegistryRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegistryRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private RegistryRepository registryRepository;
    
    public RegistryRepositoryTest() {
    }
    
    @Test
    public void createRegistry() {
        registryRepository = ctx.getBean(RegistryRepository.class);
        
        Registry registry = new Registry.Builder().occasion_id(1).product_id(2).quantity(2).build();
        
        registryRepository.save(registry);
        id = registry.getId();
        Assert.assertNotNull(registry);
    }
    
    @Test(priority = 2, dependsOnMethods = "createRegistry", enabled = true)
    public void readRegistry() {
        registryRepository = ctx.getBean(RegistryRepository.class);
        Registry registry = registryRepository.findOne(id);
        
        Assert.assertEquals(registry.getProduct_id(), 2);
        System.out.println("Product id: " + registry.getProduct_id());
    }
    
    @Test(priority = 3, dependsOnMethods = "readRegistry", enabled = true)
     private void updateRegistry(){
        registryRepository = ctx.getBean(RegistryRepository.class);
        Registry registry = registryRepository.findOne(id);
     
        Registry updatedRegistry = new Registry.Builder().registry(registry).occasion_id(1).product_id(2).quantity(2).build();
        
        registryRepository.save(updatedRegistry);
        
        Registry newRegistry = registryRepository.findOne(id);
        System.out.println("New Registry: " + newRegistry);
        
        Assert.assertEquals(newRegistry.getProduct_id(), 1);
     }
     
    @Test(priority = 4, dependsOnMethods = "updateRegistry", enabled = true)
    public void deleteRegistry(){
        registryRepository = ctx.getBean(RegistryRepository.class);
        Registry registry = registryRepository.findOne(id);
        
        registryRepository.delete(registry);
        Registry deletedRegistry = registryRepository.findOne(id);

        Assert.assertNull(deletedRegistry);
        System.out.println("Deleted Registry: " + deletedRegistry);
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
