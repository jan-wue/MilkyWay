package com.jawue.milkyway;

import codedraw.CodeDraw;
import codedraw.Event;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Grid extends GuiObject {
  Double x = 50.00;
  Double y = 50.0;
  Double width = 900.0;
  Double height = 300.0;
  private final Double MARGIN = 20.00;
  List<GuiObject> buttonList1 = new ArrayList<>();
  List<GuiObject> buttonList2 = new ArrayList<>();
  List<GuiObject> buttonList3 = new ArrayList<>();
  List<GuiObject> layouts = new ArrayList<>();
  ButtonStyle buttonStyle = new ButtonStyle(Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.BLUE, Color.BLACK, Color.WHITE, Color.YELLOW, Color.BLACK);
  private List<com.jawue.milkyway.Image> images = new ArrayList<>();

  private String pathToXImage = "/home/jan/Documents/projects/milkyway/src/main/resources/text126.png";

  private String pathToOImage = "/home/jan/Documents/projects/milkyway/src/main/resources/text126.png";
  String[][] board = new String[3][3];


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
    createAndDrawLines(cd);
    for (GuiObject layout : layouts) {
      layout.draw(cd);
    }
    createImagesAndAddToList();
    for (com.jawue.milkyway.Image image : images) {
      codedraw.Image cdImage;
      if (image.getPlayerChar().equals("X")) {
        cdImage = codedraw.Image.fromFile(pathToXImage);
      } else {
        cdImage = codedraw.Image.fromFile(pathToOImage);
      }
      cd.drawImage(image.getX(), image.getY(), image.getWidth(), image.getHeight(), cdImage);
    }
  }

  @Override

  public void handleEvent(Integer mouseX, Integer mouseY, Event event) {
    for (GuiObject layout : layouts) {
      layout.handleEvent(mouseX, mouseY, event);
    }
  }

  public void createLayouts() {
    double y = this.y;
    double distanceBetweenLayouts = 10;
    List<GuiObject> buttonList = buttonList1;
    for (int i = 0; i < 3; i++) {
      if (i == 1) {
        y = this.y + this.height / 3 + distanceBetweenLayouts;
        buttonList = buttonList2;
      }
      if (i == 2) {
        y = this.y + (this.height / 3 * 2) + distanceBetweenLayouts * 2;
        buttonList = buttonList3;
      }
      Layout layout = new Layout(buttonList, this.width / 3, this.height / 3, this.x, y);
      layouts.add(layout);
    }
  }

  public void createButtons() {
    for (int i = 1; i <= 9; i++) {
      Button button = new Button("button" + String.valueOf(i), 0.0, 0.0, 0.0, 0.0, "", this.buttonStyle) {

        @Override
        public void executeMouseClickEvent() {
          com.jawue.milkyway.Image playerCharImage = new com.jawue.milkyway.Image(this.getButtonName(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
          images.add(playerCharImage);
        }
      };
      if (i <= 3) {
        buttonList1.add(button);
      } else if (i <= 6) {
        buttonList2.add(button);
      } else {
        buttonList3.add(button);
      }
    }
  }

  public void createAndDrawLines(CodeDraw cd) {
    double buttonWidth = buttonList1.get(0).getWidth();
    double xStart = this.x + buttonWidth + MARGIN + MARGIN / 2;
    double xEnd = xStart;
    double yStart = this.y - 10;
    double yEnd = yStart + this.height + 30;

    Line line1Vertical = new Line(xStart, xEnd, yStart, yEnd);
    line1Vertical.draw(cd);

    xStart = this.x + MARGIN * 2.5 + 2 * buttonWidth;
    xEnd = xStart;

    Line line2Vertical = new Line(xStart, xEnd, yStart, yEnd);
    line2Vertical.draw(cd);

    xStart = MARGIN + this.x;
    xEnd = xStart + buttonWidth * 3 + 3 * MARGIN;
    double buttonHeight = buttonList1.get(0).getHeight();
    yStart = this.y + 5 + buttonHeight;
    yEnd = yStart;

    Line lineHorizontal1 = new Line(xStart, xEnd, yStart, yEnd);
    lineHorizontal1.draw(cd);

    yStart = this.y + 15 + buttonHeight * 2;
    yEnd = yStart;

    Line lineHorizontal2 = new Line(xStart, xEnd, yStart, yEnd);
    lineHorizontal2.draw(cd);
  }

  public void createImagesAndAddToList() {
    List<GuiObject> buttonList = buttonList1;
    for (int i = 0; i < board.length; i++) {
      if (i == 1) {
        buttonList = buttonList2;
      }
      if (i == 2) {
        buttonList = buttonList3;
      }

      for (int j = 0; j < board[i].length; j++) {
        Button button = (Button) buttonList.get(j);
        board[i][j] = "X";
        if (board[i][j].equals("O")) {
          com.jawue.milkyway.Image image = new com.jawue.milkyway.Image("O", button.getX(), button.getY(), button.getWidth(), button.getHeight());
          this.images.add(image);
        } else if (board[i][j].equals("X")) {
          com.jawue.milkyway.Image image = new com.jawue.milkyway.Image("X", button.getX(), button.getY(), button.getWidth(), button.getHeight());
          this.images.add(image);
        }

      }

    }

  }


}



