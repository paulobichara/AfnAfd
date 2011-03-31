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
