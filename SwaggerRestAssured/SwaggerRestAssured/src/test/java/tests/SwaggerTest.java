package tests;

import helpers.PetServiceHelper;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwaggerTest {
    private PetServiceHelper petServiceHelper;

    @BeforeClass
    public void init(){
        petServiceHelper = new PetServiceHelper();
    }

    @Test
    public void AddingPetPostTest() {
        String id = petServiceHelper.AddNewPet().jsonPath().getString("id");
        System.out.println(id);
        Assertions.assertEquals(200,HttpStatus.SC_OK);
    }

    @Test
    public void FindPetGetTest() {
        petServiceHelper.FindPetById(10);
        Assertions.assertEquals(200,HttpStatus.SC_OK);

    }


}
