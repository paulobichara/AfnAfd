package model;

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
