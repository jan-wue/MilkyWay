package com.jawue;

import codedraw.CodeDraw;
import codedraw.Palette;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App {
  static List<GuiObject> guiObjects = new ArrayList<>();
  static List<GuiObject> bufferGuiObjects = new ArrayList<>();


  public static void main(String[] args) {
    // Instantiates a new CodeDraw window with the size of 600x600 pixel
    CodeDraw cd = new CodeDraw();

    GuiObject clickButton = new Button(cd, 50.0, 200.0, 100.0, 200.22, "press me") {
      @Override
      public void executeMouseClickEvent() {
        GuiObject label = new Label(400.0, 100.0, 100.0, 200.0, "I got clicked");
        bufferGuiObjects.add(label);
      }
      public void executeMouseMoveEvent() {

      }


    };

    GuiObject musicButton = new Button(cd, 400.00, 400.0, 100.0,  150.0, "play music") {
      @Override
      public void executeMouseClickEvent() {
        String musicPath = "/home/jan/Documents/projects/milkyway/src/main/resources/testMusic.wav";

        try {

          AudioInputStream audio = AudioSystem.getAudioInputStream(new File(musicPath));
          Clip clip = AudioSystem.getClip() ;
          clip.open(audio);
          clip.start();

        } catch(Exception e) {
          e.printStackTrace();
        }

      }
      public void executeMouseMoveEvent() {
        this.fillRectangle(cd);
      }
    };
    System.out.println(clickButton);
    guiObjects.add(musicButton);

        guiObjects.add(clickButton);
      EventHandler event = new EventHandler();
    while (!cd.isClosed()) {
      guiObjects.addAll(bufferGuiObjects);
      bufferGuiObjects = new ArrayList<>();
      event.getEvent(cd);
      for(GuiObject guiObject : guiObjects) {
        guiObject.draw(cd);
      }
      cd.show(16);
      cd.clear();
    }
  }
}
