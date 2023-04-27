package com.jawue;

import codedraw.*;
import codedraw.Event;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Button extends GuiObject {
  private Double x;
  private Double y;
  private Double width;
  private Double height;
  private String text;
  private ButtonState buttonState;


  public Button(CodeDraw cd, Double x, Double y, Double width, Double height, String text) {

    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.text = text;
  }

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

  @Override
  public void setX(Double x) {
    this.x = x;
  }

  @Override
  public void setY(Double y) {
    this.y = y;
  }

  @Override
  public void setWidth(Double width) {
    this.width = width;
  }

  @Override
  public void setHeight(Double height) {
    this.height = height;
  }

  @Override
  public void setText(String text) {
    this.text = text;
  }

  public void setButtonState(ButtonState buttonState) {
    this.buttonState = buttonState;
  }

  @Override
  public void draw(CodeDraw cd) {
    cd.drawRectangle(this.x, this.y, this.width, this.height);
    TextFormat format = cd.getTextFormat();
    format.setBold(true);
    if(buttonState == ButtonState.ClICKED) {
      fillRectangle(cd);
    } else if(buttonState == ButtonState.HOVERED) {
      cd.setColor(Color.blue);
      fillRectangle(Color.blue);
    }
    cd.drawText(x + 10, y + 20, this.text);

  }


  @Override
  public void executeMouseClickEvent() {


  }



  @Override
  public void fillRectangle(CodeDraw cd, Color color) {
    cd.setColor(color);
    cd.fillRectangle(this.x, this.y, this.width, this.height);
    cd.setColor(color );
  }

  @Override
  public void handleEvent(Integer mouseX, Integer mouseY, Event event) {

    boolean isEventInsideButton = mouseX <= (this.x + this.width) && mouseX >= this.x && mouseY <= this.y + this.height && mouseY >= this.y;
    while(isEventInsideButton) {
      if (event.getClass() == MouseClickEvent.class) {
        setButtonState(ButtonState.ClICKED);
      } else if (event.getClass() == MouseMoveEvent.class) {
        setButtonState(ButtonState.HOVERED);
      }


      if (this.buttonState == ButtonState.ClICKED) {
        this.executeMouseClickEvent();
      } else if (this.buttonState == ButtonState.HOVERED) {
        executeMouseMoveEvent();
      }
    }

  }


}
