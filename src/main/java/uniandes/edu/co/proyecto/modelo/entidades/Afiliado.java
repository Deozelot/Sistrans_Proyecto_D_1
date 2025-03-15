package uniandes.edu.co.proyecto.modelo.entidades;

import jakarta.persistence.*;
import uniandes.edu.co.proyecto.modelo.enums.TipoAfiliado;
import uniandes.edu.co.proyecto.modelo.enums.TipoDoc;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Afiliados")
public class Afiliado {

    @Enumerated(value = EnumType.STRING)
    TipoDoc tipoDoc;

    @Id
    private Long numDoc;

    private String nombre;
    private Date fechaNacimiento;
    private String direccion;
    private Long telefono;

    @Enumerated(value = EnumType.STRING)
    TipoAfiliado tipoAfiliado;

    @OneToMany(mappedBy = "contribuyente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Beneficiario> beneficiarios;

    @ManyToOne
    private EPS eps;

    @OneToMany(mappedBy = "afiliado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrestacionServicioEps> prestaciones;

    @OneToMany(mappedBy = "afiliado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orden> ordenes;

    @OneToMany(mappedBy = "afiliado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CitaServicioIPS> citas;

    public Afiliado(TipoDoc tipoDoc, Long numDoc, String nombre, Date fechaNacimiento, String direccion, Long telefono, TipoAfiliado tipoAfiliado) {
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoAfiliado = tipoAfiliado;
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

    public TipoAfiliado getTipoAfiliado() {
        return tipoAfiliado;
    }

    public void setTipoAfiliado(TipoAfiliado tipoAfiliado) {
        this.tipoAfiliado = tipoAfiliado;
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

    public List<PrestacionServicioEps> getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(List<PrestacionServicioEps> prestaciones) {
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
