package com.jawue.milkyway;

import codedraw.CodeDraw;
import codedraw.MouseClickEvent;
import codedraw.MouseMoveEvent;

public class EventHandler {
  public void getEvent(CodeDraw cd) {
    for (var e : cd.getEventScanner()) {
      for (GuiObject guiObject : App.guiObjects) {
        switch (e) {
          case MouseMoveEvent a -> {
            if (guiObject.isEnabled()) {
              guiObject.handleEvent(a.getX(), a.getY(), a);
            }
          }
          case MouseClickEvent a -> {
            if (guiObject.isEnabled()) {
              guiObject.handleEvent(a.getX(), a.getY(), a);
            }
          }


          default -> {
          }
        }
      }
    }

  }
}
