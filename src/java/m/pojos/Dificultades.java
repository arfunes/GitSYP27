package m.pojos;
// Generated 05-19-2016 02:23:46 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Dificultades generated by hbm2java
 */
@Entity
@Table(name="dificultades"
    ,schema="public"
)
public class Dificultades  implements java.io.Serializable {


     private int iddificultad;
     private Persona persona;
     private String enproduccion;
     private String enventa;

    public Dificultades() {
    }

	
    public Dificultades(int iddificultad) {
        this.iddificultad = iddificultad;
    }
    public Dificultades(int iddificultad, Persona persona, String enproduccion, String enventa) {
       this.iddificultad = iddificultad;
       this.persona = persona;
       this.enproduccion = enproduccion;
       this.enventa = enventa;
    }
   
     @Id 

    
    @Column(name="iddificultad", unique=true, nullable=false)
    public int getIddificultad() {
        return this.iddificultad;
    }
    
    public void setIddificultad(int iddificultad) {
        this.iddificultad = iddificultad;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idpersona")
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
    @Column(name="enproduccion", length=254)
    public String getEnproduccion() {
        return this.enproduccion;
    }
    
    public void setEnproduccion(String enproduccion) {
        this.enproduccion = enproduccion;
    }

    
    @Column(name="enventa", length=254)
    public String getEnventa() {
        return this.enventa;
    }
    
    public void setEnventa(String enventa) {
        this.enventa = enventa;
    }




}


