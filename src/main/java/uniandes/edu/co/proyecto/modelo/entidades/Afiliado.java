package uniandes.edu.co.proyecto.modelo.entidades;

import jakarta.persistence.*;
import uniandes.edu.co.proyecto.modelo.enums.TipoAfiliado;
import uniandes.edu.co.proyecto.modelo.enums.TipoDoc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Afiliados")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_afiliado")
@DiscriminatorValue(value = "contribuyente")
public class Afiliado {

    @Enumerated(value = EnumType.STRING)
    TipoDoc tipoDoc;

    @Id
    private Long numDoc;

    private String nombre;
    private Date fechaNacimiento;
    private String direccion;
    private Long telefono;

    @OneToMany(mappedBy = "contribuyente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Beneficiario> beneficiarios;

    @ManyToOne
    private EPS eps;

    @OneToMany(mappedBy = "afiliado")
    private List<PrestacionServicioIPS> prestaciones = new ArrayList<>();

    @OneToMany(mappedBy = "afiliado")
    private List<Orden> ordenes = new ArrayList<>();

    @OneToMany(mappedBy = "afiliado")
    private List<CitaServicioIPS> citas = new ArrayList<>();

    public Afiliado(TipoDoc tipoDoc, Long numDoc, String nombre, Date fechaNacimiento, String direccion, Long telefono, TipoAfiliado tipoAfiliado) {
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Afiliado() {
    }

    public TipoDoc getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDoc tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public Long getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(Long numDoc) {
        this.numDoc = numDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public List<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(List<Beneficiario> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public EPS getEps() {
        return eps;
    }

    public void setEps(EPS eps) {
        this.eps = eps;
    }

    public List<PrestacionServicioIPS> getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(List<PrestacionServicioIPS> prestaciones) {
        this.prestaciones = prestaciones;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public List<CitaServicioIPS> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaServicioIPS> citas) {
        this.citas = citas;
    }
}
