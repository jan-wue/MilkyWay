package com.jawue.milkyway;

import codedraw.CodeDraw;
import codedraw.MouseClickEvent;
import codedraw.MouseMoveEvent;
import codedraw.WindowCloseEvent;

public class EventHandler  {
  CloseHandler closeHandler;
  public void handleEvents(CodeDraw cd) {
    for (var e : cd.getEventScanner()) {
      for (GuiObject guiObject : App.guiObjects) {
          if(e instanceof MouseMoveEvent) {
            MouseMoveEvent event = (MouseMoveEvent) e;
            if (guiObject.isEnabled()) {
              guiObject.handleEvent(event.getX(), event.getY(), event);
            }
          }
          if(e instanceof MouseClickEvent) {
            if (guiObject.isEnabled()) {
              MouseClickEvent event = (MouseClickEvent) e;
              guiObject.handleEvent(event.getX(), event.getY(), event);
            }
          }
          if(e instanceof WindowCloseEvent) {
            if(closeHandler != null) {
              closeHandler.handleCloseEvent((WindowCloseEvent) e);
            }
          }

      }
    }

  }
  public void onClose(CloseHandler closeHandler) {
    this.closeHandler = closeHandler;
  }
}
