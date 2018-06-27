/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.bean;

/**
 *
 * @author Aluno
 */
public class Curriculo {

    /**
     * @return the id_curriculo
     */
    public int getId_curriculo() {
        return id_curriculo;
    }

    /**
     * @param id_curriculo the id_curriculo to set
     */
    public void setId_curriculo(int id_curriculo) {
        this.id_curriculo = id_curriculo;
    }

    /**
     * @return the curriculo_arquivo
     */
    public String getCurriculo_arquivo() {
        return curriculo_arquivo;
    }

    /**
     * @param curriculo_arquivo the curriculo_arquivo to set
     */
    public void setCurriculo_arquivo(String curriculo_arquivo) {
        this.curriculo_arquivo = curriculo_arquivo;
    }

    /**
     * @return the curriculo_path
     */
    public String getCurriculo_path() {
        return curriculo_path;
    }

    /**
     * @param curriculo_path the curriculo_path to set
     */
    public void setCurriculo_path(String curriculo_path) {
        this.curriculo_path = curriculo_path;
    }

    /**
     * @return the candidato_nome
     */
    public String getCandidato_nome() {
        return candidato_nome;
    }

    /**
     * @param candidato_nome the candidato_nome to set
     */
    public void setCandidato_nome(String candidato_nome) {
        this.candidato_nome = candidato_nome;
    }

    /**
     * @return the candidato_email
     */
    public String getCandidato_email() {
        return candidato_email;
    }

    /**
     * @param candidato_email the candidato_email to set
     */
    public void setCandidato_email(String candidato_email) {
        this.candidato_email = candidato_email;
    }
    private int id_curriculo;    
    private String curriculo_arquivo;
    private String curriculo_path;    
    private String candidato_nome;
    private String candidato_email;

}
