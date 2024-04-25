import java.util.HashMap;
import java.util.Map;

public class Ubicacion {
    private int id;
    private String descripcion;
    Map<String, Integer> exits;

    public Ubicacion(int id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
        this.exits = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }

    public void setExits(Map<String, Integer> exits) {
        this.exits = exits;
    }

    public void addExit(String direccion, int idUbicacion){
        exits.put(direccion, idUbicacion);
    }
}
