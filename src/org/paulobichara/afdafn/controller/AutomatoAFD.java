/*
   Copyright 2011 Paulo Augusto Dacach Bichara

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package org.paulobichara.afdafn.controller;
import java.util.ArrayList;

import org.paulobichara.afdafn.model.Estado;
import org.paulobichara.afdafn.model.Simbolo;

public class AutomatoAFD {

  private ArrayList estados;
  private ArrayList estadosAFN;
  private ArrayList transicoesAFN;
  private ArrayList transicoes;
  private ArrayList alfabeto;

  public AutomatoAFD(Estado inicialAFN, ArrayList alfAFN, ArrayList transAFN) {
  ArrayList estInic = new ArrayList();
    estados = new ArrayList();
    estInic.add(inicialAFN);
    estados.add(estInic);
    transicoes = new ArrayList();
    alfabeto = alfAFN;
    transicoesAFN = transAFN;
  }

  public void transformarAFNAFD() {
    ArrayList estadoAFD;
    for (int i = 0; i < estados.size(); i++) {
      estadoAFD = (ArrayList)estados.get(i);
      for (int j = 0; j < alfabeto.size(); j++) {
        calculaProximoEstado(estadoAFD, ((Simbolo)alfabeto.get(j)).getSimbolo());
      }
    }
  }

  public boolean comparaArrays(ArrayList array1, ArrayList array2) {
    boolean igualArray = true, igualEstado = false;
    Estado est1, est2;
    if (array1.size() != array2.size()) {
      return false;
    } else {
      for (int i = 0; ((i < array1.size()) && (igualArray != false)); i++) {
        est1 = (Estado)array1.get(i);
        for (int j = 0; ((j < array2.size()) && (igualEstado != true)); j++) {
          est2 = (Estado)array2.get(j);
          if (est1.getRotulo().equals(est2.getRotulo())) {
            igualEstado = true;
          }
        }
        if (igualEstado == false) {
          igualArray = false;
        } else {
          igualEstado = false;
        }
      }
      return igualArray;
    }
  }

  public void calculaProximoEstado(ArrayList origem, String simbolo) {
    ArrayList transics = new ArrayList(), destino = new ArrayList();
    Estado est;
    ArrayList trans;
    boolean achou = false;
    for (int i = 0; i < origem.size(); i++) {
      est = (Estado)origem.get(i);
      trans = (ArrayList)achaTransicoes(est, simbolo);
      for (int j = 0; j < trans.size(); j++) {
        if (checaElementoArray(destino,  ((TransicaoAFN)trans.get(j)).getDestino()) != true) {
          destino.add( ( (TransicaoAFN) trans.get(j)).getDestino());
        }
      }
    }
    for (int i = 0; ((i < estados.size()) && (achou != true)); i++) {
      if (comparaArrays(destino, (ArrayList)estados.get(i)) == true) {
        achou = true;
      }
    }
    if (achou == false) {
      estados.add(destino);
    }
    if (destino.size() != 0) {
      Simbolo sim = buscaSimbolo(simbolo);
      TransicaoAFD transic = new TransicaoAFD(origem, destino, sim);
      transicoes.add(transic);
    }

  }

  public boolean checaElementoArray(ArrayList estadoAFD, Estado estado) {
    boolean achou = false;
    for (int i = 0; ((i < estadoAFD.size()) && (achou != true)); i++) {
      if (estado.getRotulo().equals(((Estado)estadoAFD.get(i)).getRotulo())) {
        achou = true;
      }
    }
    return achou;
  }

  public ArrayList achaTransicoes(Estado est, String simbolo) {
      ArrayList trans = new ArrayList();
      TransicaoAFN transAFN;
      for (int i = 0; i < transicoesAFN.size(); i++) {
        transAFN = (TransicaoAFN)transicoesAFN.get(i);
        if ((transAFN.getOrigem().getRotulo().equals(est.getRotulo())) && (transAFN.getSimbolo().getSimbolo().equals(simbolo))) {
          trans.add(transAFN);
        }
      }
      return trans;
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

  public ArrayList getEstados() {
    return estados;
  }

  public ArrayList getTransicoes() {
    return transicoes;
  }

}
