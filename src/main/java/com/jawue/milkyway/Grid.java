package com.jawue.milkyway;

import codedraw.CodeDraw;
import codedraw.Event;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Grid extends GuiObject {
  Double x = 50.00;
  Double y = 50.0;
  Double width = 900.0;
  Double height = 300.0;
  List<GuiObject> buttonList1 = new ArrayList<>();
  List<GuiObject> buttonList2 = new ArrayList<>();
  List<GuiObject> buttonList3 = new ArrayList<>();
  List<GuiObject> layouts = new ArrayList<>();
  ButtonStyle buttonStyle = new ButtonStyle(Color.black, Color.WHITE, Color.BLACK, Color.WHITE, Color.BLUE, Color.BLACK, Color.WHITE, Color.YELLOW, Color.BLACK);




  public Grid() {
    this(50.0, 50.0, 900.0, 300.0);
  }

  public Grid(Double x, Double y, Double width, Double height) {

    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    createButtons();
    createLayouts();
  }

  public void draw(CodeDraw cd) {
    for(GuiObject layout : layouts) {
      layout.draw(cd);
    }
  }

  @Override

  public void handleEvent(Integer mouseX, Integer mouseY, Event event) {
    for(GuiObject layout : layouts) {
      layout.handleEvent(mouseX, mouseY, event);
    }
  }

  public void createLayouts() {
    double y = this.y;
    List<GuiObject> buttonList = buttonList1;
    for (int i = 0; i < 3; i++) {
      if (i == 1) {
        y = this.y + this.height / 3;
        buttonList = buttonList2;
      }
      if (i == 2) {
        y = this.y + this.height / 3 * 2;
        buttonList = buttonList3;
      }
      Layout layout = new Layout(buttonList, this.width / 3, this.height / 3, this.x, y);
      layouts.add(layout);
    }
  }

  public void createButtons() {
    for (int i = 0; i < 9; i++) {
      Button button = new Button(0.0, 0.0, 0.0, 0.0, "", this.buttonStyle);
      if (i < 3) {
        buttonList1.add(button);
      } else if (i < 6) {
        buttonList2.add(button);
      } else {
        buttonList3.add(button);
      }
    }
  }
    public void drawLines(CodeDraw cd) {

    }



}
