package clases;

public class Post {
    private int id; //ruta la imagen
    private String descripcion;



    public Post(int id, String descripcion) {
        this.id = id;// ruta de la imagen
        this.descripcion = descripcion;

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
}
