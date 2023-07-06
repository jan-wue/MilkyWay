package com.jawue.milkyway;

import codedraw.WindowCloseEvent;
import jdk.jfr.Event;

@FunctionalInterface
public interface CloseHandler {

  public void handleCloseEvent(WindowCloseEvent e);
}
