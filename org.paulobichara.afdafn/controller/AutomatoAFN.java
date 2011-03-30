package controller;
import java.util.*;

import model.Estado;
import model.Simbolo;

public class AutomatoAFN {

  private ArrayList estados; //sempre o primeiro estado do ArrayList eh o inicial
  private ArrayList transicoes;
  private ArrayList alfabeto;
  private AutomatoAFD automatoAFD;

  public AutomatoAFN() {
    estados = new ArrayList();
    transicoes = new ArrayList();
    alfabeto = new ArrayList();
  }

  public void criarEstados(int numEsts) {
    Estado e;
    int i;
    for (i = 1; i <= numEsts; i++) {
      if ((i-1) == 0) {
        e = new Estado("Q" + (i-1), "Inicial");
      } else {
        e = new Estado("Q" + (i - 1), "Normal");
      }
      estados.add(e);
    }
  }

  public Estado buscaEstado(String rotulo) {
    int i = -1;
    Estado est = null;
    do {
      i++;
    } while ((i < estados.size()) && (((Estado)estados.get(i)).getRotulo().equals(rotulo) == false));
    if (i < estados.size()) {
      est = (Estado)estados.get(i);
    }
    return est;
  }

  public Simbolo buscaSimbolo(String simb) {
    int i = -1;
    Simbolo simbolo = null;
    do {
      i++;
    } while ((i < alfabeto.size()) && (((Simbolo)alfabeto.get(i)).getSimbolo().equals(simb) == false));
    if (i < alfabeto.size()) {
      simbolo = (Simbolo)alfabeto.get(i);
    }
    return simbolo;
  }


  public TransicaoAFN buscaTransicao(Estado origem, Estado destino, String simb) {
    String rotOrig, rotOrig2, rotDest, rotDest2, simbolo, simbolo2;
    TransicaoAFN trans = null;
    int i = 0;
    boolean achou = false;

    rotOrig2 = origem.getRotulo();
    rotDest2 = destino.getRotulo();
    simbolo2 = simb;
    for (i = 0; ((i < transicoes.size()) & (achou != true)); i++) {
      trans = (TransicaoAFN) transicoes.get(i);
      rotOrig = trans.getOrigem().getRotulo();
      rotDest = trans.getDestino().getRotulo();
      simbolo = trans.getSimbolo().getSimbolo();
      if ((rotOrig2.equals(rotOrig)) && (rotDest2.equals(rotDest)) && (simbolo2.equals(simbolo))) {
        achou = true;
      }
    }
    if (achou) {
      return trans;
    } else {
      return null;
    }
  }


  public boolean addTransicao(String rotuloOrig, String rotuloDest, String simb) {
    Estado origem, destino;
    Simbolo simbolo;
    TransicaoAFN t;

    origem = buscaEstado(rotuloOrig);
    destino = buscaEstado(rotuloDest);
    simbolo = buscaSimbolo(simb);
    if (buscaTransicao(origem, destino, simb) == null) {
      t = new TransicaoAFN(origem, destino, simbolo);
      transicoes.add(t);
      return true;
    } else {
      return false;
    }
  }

  public boolean checaSimbolo(String simb) {
    int i;
    Simbolo simbolo = null;
    boolean achou = false;

    for (i = 0; i < alfabeto.size(); i++) {
      simbolo = (Simbolo)alfabeto.get(i);
      if (simbolo.getSimbolo().equals(simb)) {
        achou = true;
      }
    }
    return achou;
  }

  public void transformarAFD() {
    Estado estInic;
    estInic = (Estado)estados.get(0);
    automatoAFD = new AutomatoAFD(estInic, alfabeto, transicoes);
    automatoAFD.transformarAFNAFD();
  }

  public ArrayList getTransicoes() {
    return transicoes;
  }

  public void addSimbolo(String simb) {
    Simbolo simbolo = new Simbolo(simb);
    alfabeto.add(simbolo);
  }

  public void setEstadoFinal(String rotulo) {
    Estado est;

    est = buscaEstado(rotulo);
    est.setTipo("Final");
  }

  public ArrayList getAlfabeto() {
    return alfabeto;
  }

  public ArrayList getEstados() {
    return estados;
  }

  public ArrayList getEstadosAFD() {
    return automatoAFD.getEstados();
  }

  public ArrayList getTransicoesAFD() {
    return automatoAFD.getTransicoes();
  }

}


