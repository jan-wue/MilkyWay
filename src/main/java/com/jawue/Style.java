package com.jawue;

import java.awt.*;

public class Style {

  private Color normalState;
  private Color clickedState;

  private Color hoveredState;


  public Style(Color normalState, Color clickedState, Color hoveredState) {
    this.normalState = normalState;
    this.clickedState = clickedState;
    this.hoveredState = hoveredState;
  }

  public Color getNormalState() {
    return normalState;
  }

  public Color getClickedState() {
    return clickedState;
  }

  public Color getHoveredState() {
    return hoveredState;
  }

  public void setNormalState(Color normalState) {
    this.normalState = normalState;
  }

  public void setClickedState(Color clickedState) {
    this.clickedState = clickedState;
  }

  public void setHoveredState(Color hoveredState) {
    this.hoveredState = hoveredState;
  }
}
