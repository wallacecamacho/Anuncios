package br.com.anuncios.model;
// Generated 13/03/2012 23:00:23 by Hibernate Tools 3.4.0.CR1


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;



/**
 * Uf generated by hbm2java
 */
@Entity
@Table(name="uf", catalog="saogoncaloanuncios",uniqueConstraints = @UniqueConstraint(columnNames = "idUf"))
public class Uf  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = -1468046604997277072L;
	private String idUf;
    private String descricao;
    private List<Cidade> cidades = new ArrayList<Cidade>(0);

    public Uf() {
    }

	
    public Uf(String idUf) {
        this.idUf = idUf;
    }
    public Uf(String idUf, String descricao, List<Cidade> cidades) {
       this.idUf = idUf;
       this.descricao = descricao;
       this.cidades = cidades;
    }
   
     @Id     
    @Column(name="idUf", unique=true, nullable=false, length=2)
    @NotNull
    @Length(max=2)
    public String getIdUf() {
        return this.idUf;
    }
    
    public void setIdUf(String idUf) {
        this.idUf = idUf;
    }

    
    @Column(name="descricao", length=50)
    @Length(max=50)
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="uf")
    public List<Cidade> getCidades() {
        return this.cidades;
    }
    
    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }




}


