package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.validadores.BigDecimalParser;

public class NFNotaInfoItemImpostoCOFINSAliquota extends NFBase {

    @Element(name = "CST", required = true)
    private String codigoSituacaoTributaria;

    @Element(name = "vBC", required = true)
    private String valorBaseCalulo;

    @Element(name = "pCOFINS", required = true)
    private String percentualAliquota;

    @Element(name = "vCOFINS", required = true)
    private String valor;

    public NFNotaInfoItemImpostoCOFINSAliquota() {
        this.codigoSituacaoTributaria = null;
        this.valorBaseCalulo = null;
        this.percentualAliquota = null;
        this.valor = null;
    }

    public NFNotaInfoSituacaoTributariaCOFINS getSituacaoTributaria() {
        return NFNotaInfoSituacaoTributariaCOFINS.valueOfCodigo(this.codigoSituacaoTributaria);
    }

    public void setSituacaoTributaria(final NFNotaInfoSituacaoTributariaCOFINS situacaoTributaria) {
        this.codigoSituacaoTributaria = situacaoTributaria.getCodigo();
    }

    public BigDecimal getValorBaseCalulo() {
        return new BigDecimal(this.valorBaseCalulo);
    }

    public void setValorBaseCalulo(final BigDecimal valorBaseCalulo) {
        this.valorBaseCalulo = BigDecimalParser.tamanho15Com2CasasDecimais(valorBaseCalulo);
    }

    public BigDecimal getPercentualAliquota() {
        return new BigDecimal(this.percentualAliquota);
    }

    public void setPercentualAliquota(final BigDecimal aliquota) {
        this.percentualAliquota = BigDecimalParser.tamanho5Com2CasasDecimais(aliquota);
    }

    public BigDecimal getValor() {
        return new BigDecimal(this.valor);
    }

    public void setValor(final BigDecimal valor) {
        this.valor = BigDecimalParser.tamanho15Com2CasasDecimais(valor);
    }
}