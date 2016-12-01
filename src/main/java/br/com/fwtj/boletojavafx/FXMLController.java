package br.com.fwtj.boletojavafx;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import util.MaskTextField;

public class FXMLController implements Initializable {

    @FXML
    private TextField nome;

    @FXML
    private MaskTextField documento;

    @FXML
    private MaskTextField valor;

    @FXML
    private TextField logradouro;

    @FXML
    private TextField bairro;

    @FXML
    private MaskTextField cep;

    @FXML
    private TextField cidade;

    @FXML
    private ComboBox uf;

    @FXML
    private DatePicker vencimento;

    @FXML
    private CheckBox itau;

    @FXML
    private CheckBox brasil;

    @FXML
    private Text status;

    @FXML
    private void botaoEmitir(ActionEvent event) throws FileNotFoundException, IOException {

        EmitirBoleto boleto = new EmitirBoleto();

        String opcao = "";

        if (vencimento.getValue() == null) {
            opcao = "0";
        }

        if (!itau.isSelected() && !brasil.isSelected()) {
            opcao = "1";
        }

        if (nome.getText().isEmpty() || documento.getText().isEmpty() || valor.getText().isEmpty()
                || logradouro.getText().isEmpty() || bairro.getText().isEmpty()
                || cep.getText().isEmpty() || cidade.getText().isEmpty() || uf.getSelectionModel().getSelectedItem().toString().isEmpty()) {
            opcao = "2";
        }

        switch (opcao) {

            case "0":
                status.setText("Nenhum Data Selecionada");
                break;

            case "1":
                status.setText("Nenhum Banco Selecionado");
                break;

            case "2":
                status.setText("Existe campo sem dados");
                break;

            default:
                if (itau.isSelected()) {
                    boleto.itau(
                            nome.getText(), documento.getText(), logradouro.getText(),
                            bairro.getText(), cep.getText(), cidade.getText(), uf.getSelectionModel().getSelectedItem().toString(), valor.getText(),
                            vencimento.getValue().getDayOfMonth(), vencimento.getValue().getMonthValue(),
                            vencimento.getValue().getYear());
                    status.setText("Boleto Itau Emitido");
                    System.err.println("Terminou a execução do metodo Boleto do Banco Itaú");

                }
                if (brasil.isSelected()) {
                    boleto.bancoDoBrasil(
                            nome.getText(), documento.getText(), logradouro.getText(),
                            bairro.getText(), cep.getText(), cidade.getText(), uf.getSelectionModel().getSelectedItem().toString(), valor.getText(),
                            vencimento.getValue().getDayOfMonth(), vencimento.getValue().getMonthValue(),
                            vencimento.getValue().getYear());
                    status.setText("Boleto Banco do Brasil Emitido");
                    System.err.println("Terminou a execução do metodo Boleto do Banco do Brasil");
                }

        }

    }

    @FXML
    private void menuSair(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        valor.setMask("N!.NN");
        cep.setMask("NNNNNNNN");
        documento.setMask("N!");
        
        ObservableList items = uf.getItems();
        items.add("AC");
        items.add("AL");
        items.add("AP");
        items.add("AM");
        items.add("BA");
        items.add("CE");
        items.add("ES");
        items.add("GO");
        items.add("MA");
        items.add("MT");
        items.add("MS");
        items.add("MG");
        items.add("PR");
        items.add("PB");
        items.add("PA");
        items.add("PE");
        items.add("PI");
        items.add("RJ");
        items.add("RN");
        items.add("RS");
        items.add("RO");
        items.add("RR");
        items.add("SC");
        items.add("SE");
        items.add("SP");
        items.add("TO");
        uf.setItems(items);
        
        
        


























        

    }

}
