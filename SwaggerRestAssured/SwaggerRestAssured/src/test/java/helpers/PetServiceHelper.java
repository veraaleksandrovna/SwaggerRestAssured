package helpers;
import constants.Endpoints;
import model.PetPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PetServiceHelper {

    public PetServiceHelper(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.useRelaxedHTTPSValidation();
    }

    public Response AddNewPet(){
        PetPojo pet = new PetPojo();
        pet.setId(10);
        pet.setName("Rabbit");
        pet.setStatus("available");

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .header("Content-type", "application/json")
                .log().all()
                .when()
                .body(pet)
                .post(Endpoints.AddNew_Pet)
                .andReturn();

        return response;

    }

    public Response FindPetById (Integer id )
    {
     Response response = RestAssured.given().log().all()
            .header("Content-type", "application/json")
            .contentType(ContentType.JSON)
            .pathParam("petId",id)
            .when().get(Endpoints.FindById_pet)
            .andReturn();

     return response;
    }


}
