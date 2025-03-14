package uniandes.edu.co.proyecto.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import uniandes.edu.co.proyecto.modelo.enums.Parentesco;
import uniandes.edu.co.proyecto.modelo.enums.TipoAfiliado;
import uniandes.edu.co.proyecto.modelo.enums.TipoDoc;

import java.util.Date;

@Entity
@Table(name = "Beneficiarios")
public class Beneficiario extends Afiliado {

    private Parentesco parentesco;

    @ManyToOne
    private Afiliado contribuyente;

    public Beneficiario(TipoDoc tipoDoc, Long numDoc, String nombre, Date fechaNacimiento, String direccion, Long telefono, TipoAfiliado tipoAfiliado, Parentesco parentesco) {
        super(tipoDoc, numDoc, nombre, fechaNacimiento, direccion, telefono, tipoAfiliado);
        this.parentesco = parentesco;
    }

    public Beneficiario() {
        super();
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }
}
