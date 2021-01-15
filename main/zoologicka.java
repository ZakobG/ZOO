import java.util.HashMap;

@Path("anims")
@Produces(MediaType.APPLICATION_JSON)
public class zoologicka {

    static HashMap<Integer, HashMap<String, String>> animals = new HashMap<>();
    static Integer index = 0;

    @GET
    public Response getAnims(){
        return Response.ok(animals).build();
    }
    @GET
    @Path("{index}")
    public Response getAnim(@PathParam("index") Integer index) {
        if(index != null && anims.get(index) != null){
            return Response.ok(anims.get(index)).build();
        } else {
            return Response.ok("NOTHING FOUND MATE").build();
        }
    }
    @POST
    public Response giveBirthToAnAnimal(@FormParam("name") String name, @FormParam("age") String age) {
        if(name != null && age != null ){
            HashMap<String,String> newAnim = new HashMap<>();
            newAnim.put("name", name);
            newAnim.put("age", age);
            anims.put(index, newAnim);
            index++;
            return Response.ok(animals).build();
        } else {
            return Response.ok("WE WANT NAME & AGE").build();
        }
    }
    @DELETE
    @Path("{index}")
    public Response slaughterAnim(@PathParam("index") Integer index) {
        if(index != null){
            anims.remove(index);
        }
        return Response.ok(anims).build();
    }
}