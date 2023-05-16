package com.jawue.milkyway;

import codedraw.CodeDraw;
import codedraw.Event;

import java.awt.*;

public abstract class GuiObject {
  private Double x;
  private Double y;
  private Double width;
  private Double height;
  private String text;
  private ButtonState buttonState;

  public ButtonState getButtonState() {
    return buttonState;
  }

  public Double getX() {
    return x;
  }

  public Double getY() {
    return y;
  }

  public Double getWidth() {
    return width;
  }

  public Double getHeight() {
    return height;
  }

  public String getText() {
    return text;
  }

  public void setX(Double x) {
    this.x = x;
  }

  public void setY(Double y) {
    this.y = y;
  }

  public void setWidth(Double width) {
    this.width = width;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public void setButtonState(ButtonState buttonState) {
    this.buttonState = buttonState;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void draw(CodeDraw cd) {

  }


  public void executeMouseClickEvent() {

  }

  public void executeMouseMoveEvent() {

  }
  public void fillRectangle(Color cd, Color color) {

  }

  public  void fillRectangle(CodeDraw cd, Color color) {

  }

  public void handleEvent(Integer mouseX, Integer mouseY, Event event) {

  }
}