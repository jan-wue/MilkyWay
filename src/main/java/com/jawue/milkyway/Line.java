package com.jawue.milkyway;


import codedraw.CodeDraw;

public class Line extends GuiObject {
  private Double xStart;
  private Double xEnd;
  private Double yStart;
  private Double yEnd;

  public Line(Double xStart, Double xEnd, Double yStart, Double yEnd) {
    this.xStart = xStart;
    this.xEnd = xEnd;
    this.yStart = yStart;
    this.yEnd = yEnd;
  }

  public void draw(CodeDraw cd) {
    cd.drawLine(this.xStart, this.yStart, this.xEnd, this.yEnd);
  }
}


