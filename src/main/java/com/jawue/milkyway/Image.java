package com.jawue.milkyway;

public class Image extends GuiObject {

  private Double x;
  private Double y;
  private Double width;
  private Double height;
  private String playerChar;

  public Image( String name, Double x, Double y, Double width, Double height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.playerChar = name;
  }

  @Override
  public Double getX() {
    return x;
  }

  @Override
  public void setX(Double x) {
    this.x = x;
  }

  @Override
  public Double getY() {
    return y;
  }

  @Override
  public void setY(Double y) {
    this.y = y;
  }

  @Override
  public Double getWidth() {
    return width;
  }

  @Override
  public void setWidth(Double width) {
    this.width = width;
  }

  @Override
  public Double getHeight() {
    return height;
  }

  @Override
  public void setHeight(Double height) {
    this.height = height;
  }

  public String getPlayerChar() {
    return playerChar;
  }
}
