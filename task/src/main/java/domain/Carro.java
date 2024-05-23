package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_CARRO")
public class Carro {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NOME", length = 20, nullable = false, unique = true)
    private String nome;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "CATEGORIA", length = 10, nullable = false)
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "id_marca_fk",
    foreignKey = @ForeignKey(name = "fk_marca_carro"),
    referencedColumnName = "id", nullable = false)
    private Marca marca;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "TB_CARRO_ACESSORIO",
            joinColumns = {@JoinColumn(name = "id_carro_fk")},
            inverseJoinColumns = {@JoinColumn(name = "id_acessorio_fk")})
    private List<Acessorio> acessorios = new ArrayList<>();

    public Carro(){
        this.acessorios = new ArrayList<Acessorio>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public void addAcessorio(Acessorio acessorio) {
        this.acessorios.add(acessorio);
    }
}
