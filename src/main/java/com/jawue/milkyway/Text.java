package com.jawue.milkyway;

import codedraw.CodeDraw;
import codedraw.TextFormat;

public class Text extends GuiObject {



  public void createText(CodeDraw cd, Double x, Double y,  String text, Boolean setBold, Boolean setItalic) {
    TextFormat format = new TextFormat();
    if(setItalic){
     format.setItalic(true);
    }
    if(setBold){
      format.setBold(true);
    }
    cd.drawText(x, y, text);
  }
}
