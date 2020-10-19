package com.farleydeftones.cursomc.domain.enums;

public enum TipoCliente {
    PESSOAFISICA(1,"Pessoa fisica"),
    PESSOAJURIDICA(2,"Pessoa juridica");

    private int cod;
    private String descricao;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private TipoCliente(int cod, String descricao){
        this.cod=cod;
        this.descricao=descricao;
    }
    public static TipoCliente toEnum(Integer codigo){
        if(codigo==null){
            return null;
        }
        for(TipoCliente tipoCliente:TipoCliente.values()){
            if(codigo==tipoCliente.getCod()){
                return tipoCliente;
            }
        }
        throw new IllegalArgumentException("codigo invalido");
    }
}
