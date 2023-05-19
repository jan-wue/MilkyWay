package com.jawue.milkyway;

import codedraw.Event;
import codedraw.*;

import java.awt.*;

public class Button extends GuiObject {
  private Double x;
  private Double y;
  private Double width;
  private Double height;
  private String text;
  private ButtonState buttonState = ButtonState.NORMAL;

  private ButtonStyle buttonStyle;


  public Button(Double x, Double y, Double width, Double height, String text, ButtonStyle buttonStyle) {

    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.text = text;
    this.buttonStyle = buttonStyle;
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
    Color edgeColor = buttonStyle.getNormalEdgeColor();
    Color fillColor = buttonStyle.getNormalFillColor();
    Color textColor = buttonStyle.getNormalTextColor();

    if (buttonState == ButtonState.ClICKED) {
      edgeColor = buttonStyle.getClickedEdgeColor();
      fillColor = buttonStyle.getClickedFillColor();
      textColor = buttonStyle.getClickedTextColor();
    } else if (buttonState == ButtonState.HOVERED) {
      edgeColor = buttonStyle.getHoveredEdgeColor();
      fillColor = buttonStyle.getHoveredFillColor();
      textColor = buttonStyle.getHoveredTextColor();

    }
    cd.setColor(fillColor);
    cd.fillRectangle(this.x, this.y, this.width, this.height);
    cd.setColor(edgeColor);
    cd.drawRectangle(this.x, this.y, this.width, this.height);
    cd.setColor(textColor);
    cd.drawText(x + 10, y + 20, this.text);

  }


  @Override
  public void executeMouseClickEvent() {


  }


  @Override
  public void handleEvent(Integer mouseX, Integer mouseY, Event event) {

    boolean isEventInsideButton = mouseX <= (this.x + this.width) && mouseX >= this.x && mouseY <= this.y + this.height && mouseY >= this.y;
    if (isEventInsideButton) {
      if (event.getClass() == MouseClickEvent.class) {
        setButtonState(ButtonState.ClICKED);
      } else if (event.getClass() == MouseMoveEvent.class) {
        setButtonState(ButtonState.HOVERED);
      }
    } else { // isEventInsideButton !=
      buttonState = ButtonState.NORMAL;
    }

    if (this.buttonState == ButtonState.ClICKED) {
      this.executeMouseClickEvent();
    } else if (this.buttonState == ButtonState.HOVERED) {
      executeMouseMoveEvent();
    }


  }

}
