public class Libro {

    private String titulo;
    private String autor;
    private int anioPublicacion;
    private int paginas;
    private float precio;

    public Libro() {
    }

    public Libro(String titulo, String autor, int anioPublicacion, int paginas, float precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.paginas = paginas;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getanioPublicacion() {
        return anioPublicacion;
    }

    public int getpaginas() {
        return paginas;
    }

    public float getPrecio() {
        return precio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}    
