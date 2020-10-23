package clases;

public class Tip {
    private int id; //ruta de la imagen
    private String titulo;
    private String contenidoTip;

    public Tip(int id, String titulo, String contenidoTip) {
        this.id = id;
        this.titulo = titulo;
        this.contenidoTip = contenidoTip;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public String getContenidoTip() {

        return contenidoTip;
    }

    public void setContenidoTip(String contenidoTip) {

        this.contenidoTip = contenidoTip;
    }
}
