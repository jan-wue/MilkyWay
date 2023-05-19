package com.jawue.milkyway;

import java.awt.*;

public class ButtonStyle {
  private Color normalEdgeColor;
  private Color normalFillColor;
  private Color normalTextColor;
  private Color hoveredEdgeColor;
  private Color hoveredFillColor;
  private Color hoveredTextColor;
  private Color clickedEdgeColor;
  private Color clickedFillColor;
  private Color clickedTextColor;

  public ButtonStyle() {
   this(Color.black, Color.WHITE, Color.BLACK, Color.GRAY, Color.BLUE, Color.WHITE, Color.YELLOW, Color.GREEN, Color.RED );
  }

  public ButtonStyle(Color normalEdgeColor, Color normalFillColor, Color normalTextColor, Color hoveredEdgeColor, Color hoveredFillColor, Color hoveredTextColor, Color clickedEdgeColor, Color clickedFillColor, Color clickedTextColor) {
    this.normalEdgeColor = normalEdgeColor;
    this.normalFillColor = normalFillColor;
    this.normalTextColor = normalTextColor;
    this.hoveredEdgeColor = hoveredEdgeColor;
    this.hoveredFillColor = hoveredFillColor;
    this.hoveredTextColor = hoveredTextColor;
    this.clickedEdgeColor = clickedEdgeColor;
    this.clickedFillColor = clickedFillColor;
    this.clickedTextColor = clickedTextColor;
  }

  public Color getNormalEdgeColor() {
    return normalEdgeColor;
  }

  public void setNormalEdgeColor(Color normalEdgeColor) {
    this.normalEdgeColor = normalEdgeColor;
  }

  public Color getNormalFillColor() {
    return normalFillColor;
  }

  public void setNormalFillColor(Color normalFillColor) {
    this.normalFillColor = normalFillColor;
  }

  public Color getNormalTextColor() {
    return normalTextColor;
  }

  public void setNormalTextColor(Color normalTextColor) {
    this.normalTextColor = normalTextColor;
  }

  public Color getHoveredEdgeColor() {
    return hoveredEdgeColor;
  }

  public void setHoveredEdgeColor(Color hoveredEdgeColor) {
    this.hoveredEdgeColor = hoveredEdgeColor;
  }

  public Color getHoveredFillColor() {
    return hoveredFillColor;
  }

  public void setHoveredFillColor(Color hoveredFillColor) {
    this.hoveredFillColor = hoveredFillColor;
  }

  public Color getHoveredTextColor() {
    return hoveredTextColor;
  }

  public void setHoveredTextColor(Color hoveredTextColor) {
    this.hoveredTextColor = hoveredTextColor;
  }

  public Color getClickedEdgeColor() {
    return clickedEdgeColor;
  }

  public void setClickedEdgeColor(Color clickedEdgeColor) {
    this.clickedEdgeColor = clickedEdgeColor;
  }

  public Color getClickedFillColor() {
    return clickedFillColor;
  }

  public void setClickedFillColor(Color clickedFillColor) {
    this.clickedFillColor = clickedFillColor;
  }

  public Color getClickedTextColor() {
    return clickedTextColor;
  }

  public void setClickedTextColor(Color clickedTextColor) {
    this.clickedTextColor = clickedTextColor;
  }
}
