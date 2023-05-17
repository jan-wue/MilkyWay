package com.jawue.milkyway;

import codedraw.CodeDraw;

import java.util.ArrayList;
import java.util.List;

public class Layout extends GuiObject {
  List<GuiObject> guiObjects = new ArrayList<>();
  Double x;
  Double y;
  Double width;
  Double height;


  public Layout() {
  }

  public Layout(List<GuiObject> guiObjects, Double width, Double height,Double x, Double y ) {
    this.guiObjects = guiObjects;
    this.width = width;
    this.height = height;
    this.x = x;
    this.y = y;
  }

  public void addGuiObjects(GuiObject guiObject) {
    this.guiObjects.add(guiObject);
  }

  public void draw(CodeDraw codeDraw) {
    this.setSeizeOfGuiObjects();
    for (GuiObject guiObject : this.guiObjects) {
      guiObject.draw(codeDraw);
    }
  }

  public void setSeizeOfGuiObjects() {
    double margin = 20;
    double guiX = this.x + margin;
    double guyY = this.y;
    Double numberOfGuiObjects = (double) guiObjects.size();
    for(GuiObject guiObject : guiObjects) {
      guiObject.setX(guiX);
      guiObject.setWidth(this.width / numberOfGuiObjects);
      guiX += guiObject.getWidth() + margin;
      guiObject.setHeight(this.height - 10.0);
      guiObject.setY(guyY);
    }

  }


}
