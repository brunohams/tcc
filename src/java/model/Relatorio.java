package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity(name = "tb_relatorio")
public class Relatorio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataRelatorio;
    @Column(name = "totalVendas", nullable = false)
    private float totalVendas;
    @Column(name = "qtdClientes", nullable = false)
    private int qtdClientes;
    @Column(name = "qtdClientesNovos", nullable = false)
    private int qtdClientesNovos;
    @Column(name = "maisVendidas", nullable = false)
    private List maisVendidas;
    @Column(name = "menosVendidas", nullable = false)
    private List menosVendidas;

    public Relatorio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataRelatorio() {
        return dataRelatorio;
    }

    public void setDataRelatorio(Calendar dataRelatorio) {
        this.dataRelatorio = dataRelatorio;
    }

    public float getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(float totalVendas) {
        this.totalVendas = totalVendas;
    }

    public int getQtdClientes() {
        return qtdClientes;
    }

    public void setQtdClientes(int qtdClientes) {
        this.qtdClientes = qtdClientes;
    }

    public int getQtdClientesNovos() {
        return qtdClientesNovos;
    }

    public void setQtdClientesNovos(int qtdClientesNovos) {
        this.qtdClientesNovos = qtdClientesNovos;
    }

    public List getMaisVendidas() {
        return maisVendidas;
    }

    public void setMaisVendidas(List maisVendidas) {
        this.maisVendidas = maisVendidas;
    }

    public List getMenosVendidas() {
        return menosVendidas;
    }

    public void setMenosVendidas(List menosVendidas) {
        this.menosVendidas = menosVendidas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Relatorio other = (Relatorio) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
