package com.jawue;

import codedraw.CodeDraw;
import codedraw.Event;
import codedraw.MouseClickEvent;
import codedraw.MouseMoveEvent;

import java.awt.*;

public class Label extends GuiObject {


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

  public void setText(String text) {
    this.text = text;
  }

  public void setButtonState(ButtonState buttonState) {
    this.buttonState = buttonState;
  }

  public Label(Double x, Double y, Double width, Double height, String text) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.text = text;
  }

  @Override
  public void draw(CodeDraw cd) {
    cd.setColor(Color.cyan);
    cd.drawRectangle(this.x, this.y, this.width, this.height);
    cd.drawText(this.x + 5, this.y + 20, this.text);

  }

  @Override
  public void executeMouseClickEvent() {

  }

  @Override
  public void executeMouseMoveEvent() {

  }

  @Override
  public void fillRectangle(CodeDraw cd, Color color) {
    cd.setColor(color);
    cd.fillRectangle(this.x, this.y, this.width, this.height);
    cd.setColor(Color.white);
  }
  @Override

  public void handleEvent(Integer mouseX, Integer mouseY, Event event) {

    boolean isEventInsideButton = mouseX <= (this.x + this.width) && mouseX >= this.x && mouseY <= this.y + this.height && mouseY >= this.y;
    if(isEventInsideButton) {
      if (event.getClass() == MouseClickEvent.class) {
        setButtonState(ButtonState.ClICKED);
      } else if (event.getClass() == MouseMoveEvent.class) {
        setButtonState(ButtonState.HOVERED);
      }
    }

    if (this.buttonState == ButtonState.ClICKED) {
      this.executeMouseClickEvent();
    } else if (this.buttonState == ButtonState.HOVERED) {
      executeMouseMoveEvent();
    }


  }

}
