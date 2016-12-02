/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwtj.util.Jfilehelpers;

import java.util.Date;
import java.util.Objects;
import org.coury.jfilehelpers.annotations.FieldAlign;
import org.coury.jfilehelpers.annotations.FieldConverter;
import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;
import org.coury.jfilehelpers.enums.AlignMode;
import org.coury.jfilehelpers.enums.ConverterKind;
import org.coury.jfilehelpers.enums.FixedMode;

/**
 *
 * @author Junior
 */
@FixedLengthRecord(fixedMode = FixedMode.AllowMoreChars)
public class Linha9RetornoBradesco {
    
    @FieldFixedLength(1)
    private String IDReg;
    @FieldFixedLength(16)
    private String DadosIgnorados1;
    @FieldFixedLength(8)
    private String QuantidadeDeTitulosEmCobranca;
    //@FieldConverter(converter = ConverterKind.Double, format = ".")
    @FieldFixedLength(14)
    private String ValorTotalEmCobranca;

    public String getIDReg() {
        return IDReg;
    }

    public void setIDReg(String IDReg) {
        this.IDReg = IDReg;
    }

    public String getDadosIgnorados1() {
        return DadosIgnorados1;
    }

    public void setDadosIgnorados1(String DadosIgnorados1) {
        this.DadosIgnorados1 = DadosIgnorados1;
    }

    public String getQuantidadeDeTitulosEmCobranca() {
        return QuantidadeDeTitulosEmCobranca;
    }

    public void setQuantidadeDeTitulosEmCobranca(String QuantidadeDeTitulosEmCobranca) {
        this.QuantidadeDeTitulosEmCobranca = QuantidadeDeTitulosEmCobranca;
    }

    public String getValorTotalEmCobranca() {
        return ValorTotalEmCobranca;
    }

    public void setValorTotalEmCobranca(String ValorTotalEmCobranca) {
        this.ValorTotalEmCobranca = ValorTotalEmCobranca;
    }

    
    
}
