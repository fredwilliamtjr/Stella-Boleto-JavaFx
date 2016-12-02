///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.fwtj.util.stellaboleto;
//
//import br.com.caelum.stella.boleto.Banco;
//import br.com.caelum.stella.boleto.Beneficiario;
//import br.com.caelum.stella.boleto.Boleto;
//import br.com.caelum.stella.boleto.Datas;
//import br.com.caelum.stella.boleto.Endereco;
//import br.com.caelum.stella.boleto.Pagador;
//import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
///**
// *
// * @author Junior
// */
//public class EmitirBoleto {
//
//    Calendar dataEmissao = Calendar.getInstance();
//
//    public void bancoDoBrasil(
//            String nomePagdor, String documentoPagador, String logradouroPagador, String bairroPagador, String cepPagador, String cidadePagador,
//            String ufPagador, String valorBoleto, int diaVencimento, int mesVencimento, int anoVencimento) throws FileNotFoundException, IOException {
//
//        Datas datas = Datas.novasDatas()
//                .comDocumento(dataEmissao.get(Calendar.DAY_OF_MONTH), dataEmissao.get(Calendar.MONTH) + 1, dataEmissao.get(Calendar.YEAR))
//                .comProcessamento(dataEmissao.get(Calendar.DAY_OF_MONTH), dataEmissao.get(Calendar.MONTH) + 1, dataEmissao.get(Calendar.YEAR))
//                .comVencimento(diaVencimento, mesVencimento, anoVencimento);
//
//        Endereco enderecoBeneficiario = Endereco.novoEndereco()
//                .comLogradouro("Av das Empresas, 555")
//                .comBairro("Bairro Grande")
//                .comCep("01234-555")
//                .comCidade("São Paulo")
//                .comUf("SP");
//
//        //Quem emite o boleto
//        Beneficiario beneficiario = Beneficiario.novoBeneficiario()
//                .comNomeBeneficiario("Fulano de Tal")
//                .comAgencia("1824").comDigitoAgencia("4")
//                .comCodigoBeneficiario("76000")
//                .comDigitoCodigoBeneficiario("5")
//                .comNumeroConvenio("1207113")
//                .comCarteira("18")
//                .comEndereco(enderecoBeneficiario)
//                .comNossoNumero("9000206");
//
//        Endereco enderecoPagador = Endereco.novoEndereco()
//                .comLogradouro(logradouroPagador)
//                .comBairro(bairroPagador)
//                .comCep(cepPagador)
//                .comCidade(cidadePagador)
//                .comUf(ufPagador);
//
//        //Quem paga o boleto
//        Pagador pagador = Pagador.novoPagador()
//                .comNome(nomePagdor)
//                .comDocumento(documentoPagador)
//                .comEndereco(enderecoPagador);
//
//        Banco banco = new br.com.caelum.stella.boleto.bancos.BancoDoBrasil();
//
//        Boleto boleto = Boleto.novoBoleto()
//                .comBanco(banco)
//                .comDatas(datas)
//                .comBeneficiario(beneficiario)
//                .comPagador(pagador)
//                .comValorBoleto(valorBoleto)
//                .comNumeroDoDocumento("1234")
//                .comInstrucoes("instrucao 1", "instrucao 2")
//                .comLocaisDePagamento("local 1", "local 2");
//
//        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);
//
//        byte[] geraPDF = gerador.geraPDF();
//
//        SimpleDateFormat horaFormatada = new SimpleDateFormat("HHmmss");
//
//        File file = new File("Boleto-BancoDoBrasil-" + nomePagdor.replace(" ", "") + "-GeradoAs-" + horaFormatada.format(new Date()) + ".pdf");
//        OutputStream outputStream = new FileOutputStream(file);
//        outputStream.write(geraPDF);
//        outputStream.flush();
//        outputStream.close();
//        System.err.println("Terminou a gravação do arquivo do metodo Boleto do Banco do Brasil");
//    }
//
//    public void itau(
//            String nomePagdor, String documentoPagador, String logradouroPagador, String bairroPagador, String cepPagador, String cidadePagador,
//            String ufPagador, String valorBoleto, int diaVencimento, int mesVencimento, int anoVencimento) throws FileNotFoundException, IOException {
//
//        Datas datas = Datas.novasDatas()
//                .comDocumento(dataEmissao.get(Calendar.DAY_OF_MONTH), dataEmissao.get(Calendar.MONTH) + 1, dataEmissao.get(Calendar.YEAR))
//                .comProcessamento(dataEmissao.get(Calendar.DAY_OF_MONTH), dataEmissao.get(Calendar.MONTH) + 1, dataEmissao.get(Calendar.YEAR))
//                .comVencimento(diaVencimento, mesVencimento, anoVencimento);
//
//        Endereco enderecoBeneficiario = Endereco.novoEndereco()
//                .comLogradouro("Av das Empresas, 555")
//                .comBairro("Bairro Grande")
//                .comCep("01234-555")
//                .comCidade("São Paulo")
//                .comUf("SP");
//
//        //Quem emite o boleto
//        Beneficiario beneficiario = Beneficiario.novoBeneficiario()
//                .comNomeBeneficiario("Fulano de Tal")
//                .comAgencia("1824").comDigitoAgencia("4")
//                .comCodigoBeneficiario("76000")
//                .comDigitoCodigoBeneficiario("5")
//                .comNumeroConvenio("1207113")
//                .comCarteira("18")
//                .comEndereco(enderecoBeneficiario)
//                .comNossoNumero("9000206")
//                .comDigitoNossoNumero("1");
//
//        Endereco enderecoPagador = Endereco.novoEndereco()
//                .comLogradouro(logradouroPagador)
//                .comBairro(bairroPagador)
//                .comCep(cepPagador)
//                .comCidade(cidadePagador)
//                .comUf(ufPagador);
//
//        //Quem paga o boleto
//        Pagador pagador = Pagador.novoPagador()
//                .comNome(nomePagdor)
//                .comDocumento(documentoPagador)
//                .comEndereco(enderecoPagador);
//
//        Banco banco = new br.com.caelum.stella.boleto.bancos.Itau();
//
//        Boleto boleto = Boleto.novoBoleto()
//                .comBanco(banco)
//                .comDatas(datas)
//                .comBeneficiario(beneficiario)
//                .comPagador(pagador)
//                .comValorBoleto(valorBoleto)
//                .comNumeroDoDocumento("1234")
//                .comInstrucoes("instrucao 1", "instrucao 2")
//                .comLocaisDePagamento("local 1", "local 2");
//
//        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);
//
//        byte[] geraPNG = gerador.geraPNG();
//
//        SimpleDateFormat horaFormatada = new SimpleDateFormat("HHmmss");
//        
//        File file = new File("Boleto-Itau-" + nomePagdor.replace(" ", "") + "-GeradoAs-" + horaFormatada.format(new Date()) + ".png");
//        OutputStream outputStream = new FileOutputStream(file);
//        outputStream.write(geraPNG);
//        outputStream.flush();
//        outputStream.close();
//        System.err.println("Terminou a gravação do arquivo do metodo Boleto do Banco Itaú");
//    }
//
//    public void bradesco(
//            String nomePagdor, String documentoPagador, String logradouroPagador, String bairroPagador, String cepPagador, String cidadePagador,
//            String ufPagador, String valorBoleto, int diaVencimento, int mesVencimento, int anoVencimento) throws FileNotFoundException, IOException {
//
//        Datas datas = Datas.novasDatas()
//                .comDocumento(dataEmissao.get(Calendar.DAY_OF_MONTH), dataEmissao.get(Calendar.MONTH) + 1, dataEmissao.get(Calendar.YEAR))
//                .comProcessamento(dataEmissao.get(Calendar.DAY_OF_MONTH), dataEmissao.get(Calendar.MONTH) + 1, dataEmissao.get(Calendar.YEAR))
//                .comVencimento(diaVencimento, mesVencimento, anoVencimento);
//
//        Endereco enderecoBeneficiario = Endereco.novoEndereco()
//                .comLogradouro("Av das Empresas, 555")
//                .comBairro("Bairro Grande")
//                .comCep("01234-555")
//                .comCidade("São Paulo")
//                .comUf("SP");
//
//        //Quem emite o boleto
//        Beneficiario beneficiario = Beneficiario.novoBeneficiario()
//                .comNomeBeneficiario("Fulano de Tal")
//                .comAgencia("1824").comDigitoAgencia("4")
//                .comCodigoBeneficiario("76000")
//                .comDigitoCodigoBeneficiario("5")
//                .comNumeroConvenio("1207113")
//                .comCarteira("18")
//                .comEndereco(enderecoBeneficiario)
//                .comNossoNumero("9000206");
//
//        Endereco enderecoPagador = Endereco.novoEndereco()
//                .comLogradouro(logradouroPagador)
//                .comBairro(bairroPagador)
//                .comCep(cepPagador)
//                .comCidade(cidadePagador)
//                .comUf(ufPagador);
//
//        //Quem paga o boleto
//        Pagador pagador = Pagador.novoPagador()
//                .comNome(nomePagdor)
//                .comDocumento(documentoPagador)
//                .comEndereco(enderecoPagador);
//
//        Banco banco = new br.com.caelum.stella.boleto.bancos.Bradesco();
//
//        Boleto boleto = Boleto.novoBoleto()
//                .comBanco(banco)
//                .comDatas(datas)
//                .comBeneficiario(beneficiario)
//                .comPagador(pagador)
//                .comValorBoleto(valorBoleto)
//                .comNumeroDoDocumento("1234")
//                .comInstrucoes("instrucao 1", "instrucao 2")
//                .comLocaisDePagamento("local 1", "local 2");
//
//        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);
//
//        byte[] geraPDF = gerador.geraPDF();
//
//        SimpleDateFormat horaFormatada = new SimpleDateFormat("HHmmss");
//        
//        File file = new File("Boleto-Bradesco-" + nomePagdor.replace(" ", "") + "-GeradoAs-" + horaFormatada.format(new Date()) + ".pdf");
//        OutputStream outputStream = new FileOutputStream(file);
//        outputStream.write(geraPDF);
//        outputStream.flush();
//        outputStream.close();
//        System.err.println("Terminou a gravação do arquivo do metodo Boleto do Banco Bradesco");
//    }
//    
//    
//}
