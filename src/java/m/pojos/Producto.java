package m.pojos;
// Generated 05-19-2016 02:23:46 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Producto generated by hbm2java
 */
@Entity
@Table(name="producto"
    ,schema="public"
)
public class Producto  implements java.io.Serializable {


     private int idproducto;
     private Categoria categoria;
     private String nombreproducto;
     private String detalledeproducto;
     private Set produccions = new HashSet(0);

    public Producto() {
    }

	
    public Producto(int idproducto, String nombreproducto) {
        this.idproducto = idproducto;
        this.nombreproducto = nombreproducto;
    }
    public Producto(int idproducto, Categoria categoria, String nombreproducto, String detalledeproducto, Set produccions) {
       this.idproducto = idproducto;
       this.categoria = categoria;
       this.nombreproducto = nombreproducto;
       this.detalledeproducto = detalledeproducto;
       this.produccions = produccions;
    }
   
     @Id 

    
    @Column(name="idproducto", unique=true, nullable=false)
    public int getIdproducto() {
        return this.idproducto;
    }
    
    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idcategoria")
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
    @Column(name="nombreproducto", nullable=false, length=30)
    public String getNombreproducto() {
        return this.nombreproducto;
    }
    
    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    
    @Column(name="detalledeproducto", length=254)
    public String getDetalledeproducto() {
        return this.detalledeproducto;
    }
    
    public void setDetalledeproducto(String detalledeproducto) {
        this.detalledeproducto = detalledeproducto;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="producto")
    public Set getProduccions() {
        return this.produccions;
    }
    
    public void setProduccions(Set produccions) {
        this.produccions = produccions;
    }




}


