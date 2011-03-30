package org.paulobichara.afdafn.controller;
import java.util.ArrayList;

import org.paulobichara.afdafn.model.Simbolo;

public class TransicaoAFD {

  private ArrayList estOrigem;
  private ArrayList estDestino;
  private Simbolo simbolo;

  public TransicaoAFD(ArrayList origem, ArrayList destino, Simbolo simb) {
    estOrigem = origem;
    estDestino = destino;
    simbolo = simb;
  }

  public ArrayList getOrigem() {
    return estOrigem;
  }

  public ArrayList getDestino() {
    return estDestino;
  }

  public Simbolo getSimbolo() {
    return simbolo;
  }
}
