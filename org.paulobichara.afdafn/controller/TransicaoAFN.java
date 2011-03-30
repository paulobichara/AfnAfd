package controller;

import model.Estado;
import model.Simbolo;

public class TransicaoAFN {

  private Estado estOrigem;
  private Estado estDestino;
  private Simbolo simbolo;

  public TransicaoAFN(Estado origem, Estado destino, Simbolo simb) {
    estOrigem = origem;
    estDestino = destino;
    simbolo = simb;
  }

  public Estado getOrigem() {
    return estOrigem;
  }

  public Estado getDestino() {
    return estDestino;
  }

  public Simbolo getSimbolo() {
    return simbolo;
  }

}
