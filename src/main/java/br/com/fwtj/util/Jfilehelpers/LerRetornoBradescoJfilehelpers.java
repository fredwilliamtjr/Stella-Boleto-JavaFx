/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwtj.util.Jfilehelpers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.coury.jfilehelpers.engines.FileHelperEngine;
import org.coury.jfilehelpers.masterdetail.MasterDetailEngine;
import org.coury.jfilehelpers.masterdetail.MasterDetailSelector;
import org.coury.jfilehelpers.masterdetail.MasterDetails;
import org.coury.jfilehelpers.masterdetail.RecordAction;

/**
 *
 * @author Junior
 */
public class LerRetornoBradescoJfilehelpers {

    public Linha0RetornoBradesco lerLinha0() throws IOException {
        FileHelperEngine<Linha0RetornoBradesco> engineLinha0 = new FileHelperEngine<>(Linha0RetornoBradesco.class);
        return engineLinha0.readFile("CB071000.RET").get(0);
    }

    public List<Linha1RetornoBradesco> lerLinha1() throws IOException {

        FileHelperEngine<Linha1RetornoBradesco> engineLinha1 = new FileHelperEngine<>(Linha1RetornoBradesco.class);
        
        List<Linha1RetornoBradesco> listaLinha1RetornoBradesco = new ArrayList<>();
        
        List<Linha1RetornoBradesco> listaLinha1RetornoBradescoTemporaria = engineLinha1.readFile("CB071000.RET");
        for (Linha1RetornoBradesco linha1RetornoBradescoFor : listaLinha1RetornoBradescoTemporaria) {
            if (linha1RetornoBradescoFor.getIDReg().equals("1")) {
                listaLinha1RetornoBradesco.add(linha1RetornoBradescoFor);
            }
        }
        return listaLinha1RetornoBradesco;
    }

    public Linha9RetornoBradesco lerLinha9() throws IOException {
        FileHelperEngine<Linha9RetornoBradesco> engineLinha9 = new FileHelperEngine<>(Linha9RetornoBradesco.class);
        List<Linha9RetornoBradesco> lista = engineLinha9.readFile("CB071000.RET");
        return lista.get(lista.size());
    }

    public void lerRetornoBradescoMasterDetail() throws IOException {

        MasterDetailSelector masterDetailSelector = new MasterDetailSelector() {
            @Override
            public RecordAction getRecordAction(String recordString) {
                if (recordString.startsWith("0")) {
                    return RecordAction.Master;
                }
                if (recordString.startsWith("1")) {
                    return RecordAction.Detail;
                } else {
                    return RecordAction.Skip;
                }
            }
        };

        MasterDetailEngine masterDetailEngine = new MasterDetailEngine(Linha0RetornoBradesco.class, Linha1RetornoBradesco.class, masterDetailSelector);

        List<MasterDetails<Linha0RetornoBradesco, Linha1RetornoBradesco>> readFile = masterDetailEngine.readFile("CB071000.RET");

        for (MasterDetails<Linha0RetornoBradesco, Linha1RetornoBradesco> masterDetails : readFile) {
            Linha0RetornoBradesco master = masterDetails.getMaster();
            System.out.println("Tipo : " + master.getLiteralRetorno());
            System.out.println("Data : " + master.getDataDoCredito());
            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");
            for (Linha1RetornoBradesco item : masterDetails.getDetails()) {
                System.out.println("Nosso Numero    : " + item.getNossoNumeroComDigito());
                System.out.println("Data Ocorrencia : " + item.getDataDaOcorrencia());
                System.out.println("Valor           : " + item.getValor());
                System.out.println("---------------------------------------------");
            }

        }

    }

}
