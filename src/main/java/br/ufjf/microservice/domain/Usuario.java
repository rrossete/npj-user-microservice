package br.ufjf.microservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String telefone;
    private String celular;
    private Integer cargaHoraria;

    @Column(unique = true)
    private String oab;
    @Column(unique = true)
    private String matricula;
    private boolean ativo;


    private Timestamp dt_criacao;


    private Timestamp dt_exclusao;


    private Integer idSetor;
    private Integer idColaborador;// id de uma tabela fora do serviço
    private Integer idEndereco;// id de uma tabela fora do serviço

    public Usuario() {
    }

    public Usuario(String nome, String telefone, String celular, Integer cargaHoraria, String oab, String matricula, boolean ativo,Timestamp dt_criacao, Timestamp dt_exclusao, Integer idSetor, Integer idColaborador, Integer idEndereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
        this.cargaHoraria = cargaHoraria;
        this.oab = oab;
        this.matricula = matricula;
        this.ativo = ativo;
        this.dt_criacao = dt_criacao;
        this.dt_exclusao = dt_exclusao;
        this.idSetor = idSetor;
        this.idColaborador = idColaborador;
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", oab='" + oab + '\'' +
                ", matricula='" + matricula + '\'' +
                ", ativo=" + ativo +
                ", dt_criacao=" + dt_criacao +
                ", dt_exclusao=" + dt_exclusao +
                ", idSetor=" + idSetor +
                ", idColaborador=" + idColaborador +
                ", idEndereco=" + idEndereco +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getOab() {
        return oab;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(Timestamp dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public Date getDt_exclusao() {
        return dt_exclusao;
    }

    public void setDt_exclusao(Timestamp dt_exclusao) {
        this.dt_exclusao = dt_exclusao;
    }

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }
}
