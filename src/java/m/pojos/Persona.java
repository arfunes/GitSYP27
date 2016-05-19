package m.pojos;
// Generated 05-19-2016 02:23:46 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Persona generated by hbm2java
 */
@Entity
@Table(name="persona"
    ,schema="public"
)
public class Persona  implements java.io.Serializable {


     private int idpersona;
     private Zona zona;
     private String nombre;
     private int edad;
     private Boolean sexo;
     private Double ingresosanuales;
     private Integer lugardeventa;
     private Set usuarios = new HashSet(0);
     private Set produccions = new HashSet(0);
     private Set dificultadeses = new HashSet(0);

    public Persona() {
    }

	
    public Persona(int idpersona, String nombre, int edad) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.edad = edad;
    }
    public Persona(int idpersona, Zona zona, String nombre, int edad, Boolean sexo, Double ingresosanuales, Integer lugardeventa, Set usuarios, Set produccions, Set dificultadeses) {
       this.idpersona = idpersona;
       this.zona = zona;
       this.nombre = nombre;
       this.edad = edad;
       this.sexo = sexo;
       this.ingresosanuales = ingresosanuales;
       this.lugardeventa = lugardeventa;
       this.usuarios = usuarios;
       this.produccions = produccions;
       this.dificultadeses = dificultadeses;
    }
   
     @Id 

    
    @Column(name="idpersona", unique=true, nullable=false)
    public int getIdpersona() {
        return this.idpersona;
    }
    
    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idzona")
    public Zona getZona() {
        return this.zona;
    }
    
    public void setZona(Zona zona) {
        this.zona = zona;
    }

    
    @Column(name="nombre", nullable=false, length=254)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="edad", nullable=false)
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    @Column(name="sexo")
    public Boolean getSexo() {
        return this.sexo;
    }
    
    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    
    @Column(name="ingresosanuales", precision=17, scale=17)
    public Double getIngresosanuales() {
        return this.ingresosanuales;
    }
    
    public void setIngresosanuales(Double ingresosanuales) {
        this.ingresosanuales = ingresosanuales;
    }

    
    @Column(name="lugardeventa")
    public Integer getLugardeventa() {
        return this.lugardeventa;
    }
    
    public void setLugardeventa(Integer lugardeventa) {
        this.lugardeventa = lugardeventa;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="personas")
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="realiza", schema="public", joinColumns = { 
        @JoinColumn(name="idpersona", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="idproduccion", nullable=false, updatable=false) })
    public Set getProduccions() {
        return this.produccions;
    }
    
    public void setProduccions(Set produccions) {
        this.produccions = produccions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="persona")
    public Set getDificultadeses() {
        return this.dificultadeses;
    }
    
    public void setDificultadeses(Set dificultadeses) {
        this.dificultadeses = dificultadeses;
    }




}


