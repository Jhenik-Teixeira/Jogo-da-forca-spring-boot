package br.edu.ifpi.jogodaforca.models;
import jakarta.persistence.*;

@Entity
public class Palavra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String palavra;

    @Column(nullable = false, length = 255)
    private String dica;

<<<<<<< HEAD
    public Palavra() {
    }

    public Palavra(String palavra, String dica) {
        this.palavra = palavra;
        this.dica = dica;
    }
    
=======
    public Palavra(){
    }
    public Palavra(long id, String palavra){
        
    }

>>>>>>> 382be9d36e0f88aea6bedf5ad9d81432c5638cd3
    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }
}
