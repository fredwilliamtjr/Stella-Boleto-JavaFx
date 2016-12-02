/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwtj.boletojavafx;


import br.com.fwtj.util.Jfilehelpers.LerRetornoBradescoJfilehelpers;
import br.com.fwtj.util.Jfilehelpers.Linha1RetornoBradesco;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author Junior
 */
public class FXMLConfiguracaoController implements Initializable {
    
    @FXML
    private TableView tabela;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void botaoImportar(ActionEvent event) throws IOException {
        LerRetornoBradescoJfilehelpers retornoBradesco = new LerRetornoBradescoJfilehelpers();
        List<Linha1RetornoBradesco> Lista = retornoBradesco.lerLinha1();
        
        TableColumn colunaNossoNumeroComDigito = new TableColumn<>("Nosso Numero Com Digito");
        TableColumn colunaDataDaOcorrencia = new TableColumn<>("Data Da Ocorrencia");
        TableColumn colunaValor = new TableColumn<>("Valor");
        colunaValor.setStyle("-fx-alignment: CENTER-RIGHT;");
        
        colunaNossoNumeroComDigito.setCellValueFactory(new PropertyValueFactory<>("NossoNumeroComDigito"));
        colunaDataDaOcorrencia.setCellValueFactory(new PropertyValueFactory<>("DataDaOcorrencia"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
        
        tabela.setItems(FXCollections.observableArrayList(Lista));
        tabela.getColumns().addAll(colunaNossoNumeroComDigito, colunaDataDaOcorrencia, colunaValor);
    }

}
