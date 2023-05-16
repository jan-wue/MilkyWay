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
  private ButtonState buttonState;
  private Color normalColor;
  private Color hoveredColor;
  private Color clickedColor;


  public Button(Double x, Double y, Double width, Double height, String text, Color normalColor, Color hoveredColor, Color clickedColor) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.text = text;
    this.buttonState = buttonState;
    this.normalColor = normalColor;
    this.hoveredColor = hoveredColor;
    this.clickedColor = clickedColor;
  }

  public Color getNormalColor() {
    return normalColor;
  }

  public Color getHoveredColor() {
    return hoveredColor;
  }

  public Color getClickedColor() {
    return clickedColor;
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

  public void setNormalColor(Color normalColor) {
    this.normalColor = normalColor;
  }

  public void setHoveredColor(Color hoveredColor) {
    this.hoveredColor = hoveredColor;
  }

  public void setClickedColor(Color clickedColor) {
    this.clickedColor = clickedColor;
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
      fillRectangle(cd, this.getClickedColor());
    } else if(buttonState == ButtonState.HOVERED) {
      cd.setColor(this.getHoveredColor());
      fillRectangle(cd, this.getHoveredColor());
      cd.setColor(Color.black);
      cd.drawText(x + 10, y + 20, this.text);

    } else if (buttonState == ButtonState.NORMAL) {
      cd.setColor(this.getNormalColor());
      cd.drawRectangle(this.x, this.y, this.width, this.height);

    }
    cd.drawText(x + 10, y + 20, this.text);
    cd.drawRectangle(this.x, this.y, this.width, this.height);
     format = cd.getTextFormat();

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
   if(isEventInsideButton) {
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
