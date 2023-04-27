package com.jawue;

import codedraw.CodeDraw;
import codedraw.MouseClickEvent;
import codedraw.MouseMoveEvent;

public class EventHandler {
  public void getEvent(CodeDraw cd) {
    for (var e : cd.getEventScanner()) {
      switch (e) {
        case MouseMoveEvent a -> {
          for (GuiObject button : App.guiObjects) {
            button.handleEvent(a.getX(), a.getY(), a);
          }
        }
        case MouseClickEvent a -> {
          for (GuiObject button : App.guiObjects) {
            button.handleEvent(a.getX(), a.getY(), a);
         }
        }

        default -> {
        }
      }
    }

  }
}
