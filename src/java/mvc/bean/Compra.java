/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.bean;

import java.util.Calendar;

/**
 *
 * @author Aluno
 */
public class Compra {

    /**
     * @return the cod_compra
     */
    public int getCod_compra() {
        return cod_compra;
    }

    /**
     * @param cod_compra the cod_compra to set
     */
    public void setCod_compra(int cod_compra) {
        this.cod_compra = cod_compra;
    }

    /**
     * @return the data_compra
     */
    public Calendar getData_compra() {
        return data_compra;
    }

    /**
     * @param data_compra the data_compra to set
     */
    public void setData_compra(Calendar data_compra) {
        this.data_compra = data_compra;
    }

    /**
     * @return the status_cod_compra
     */
    public int getStatus_cod_compra() {
        return status_cod_compra;
    }

    /**
     * @param status_cod_compra the status_cod_compra to set
     */
    public void setStatus_cod_compra(int status_cod_compra) {
        this.status_cod_compra = status_cod_compra;
    }

    /**
     * @return the tipo_pagto_cod_tipo_pagto
     */
    public int getTipo_pagto_cod_tipo_pagto() {
        return tipo_pagto_cod_tipo_pagto;
    }

    /**
     * @param tipo_pagto_cod_tipo_pagto the tipo_pagto_cod_tipo_pagto to set
     */
    public void setTipo_pagto_cod_tipo_pagto(int tipo_pagto_cod_tipo_pagto) {
        this.tipo_pagto_cod_tipo_pagto = tipo_pagto_cod_tipo_pagto;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    private int cod_compra;
    private Calendar data_compra;
    private int status_cod_compra;
    private int tipo_pagto_cod_tipo_pagto;
    private Cliente cliente;
    
    
    
}
