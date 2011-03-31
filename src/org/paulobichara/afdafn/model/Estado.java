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

package org.paulobichara.afdafn.model;

public class Estado {

  private String rotulo;
  private String tipo;

  public Estado(String r, String t) {
    rotulo = r;
    tipo = t;
  }

  public void setTipo(String t) {
    tipo = t;
  }

  public String getRotulo() {
    return rotulo;
  }

  public String getTipo() {
    return tipo;
  }

}
