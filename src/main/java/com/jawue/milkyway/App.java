package com.jawue.milkyway;

import codedraw.CodeDraw;
import codedraw.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class App {
  static List<GuiObject> guiObjects = new ArrayList<>();
  static List<GuiObject> bufferGuiObjects = new ArrayList<>();


  public static void main(String[] args) {
    // Instantiates a new CodeDraw window with the size of 600x600 pixel
    CodeDraw cd = new CodeDraw();

    GuiObject clickButton = new Button(50.0, 200.0, 100.0, 200.22, "press me", new ButtonStyle()) {
      @Override
      public void executeMouseClickEvent() {
        GuiObject label = new Label(400.0, 100.0, 100.0, 200.0, "I got clicked");
      }
    };

    GuiObject musicButton = new Button(400.00, 400.0, 100.0, 150.0, "play music", new ButtonStyle()) {
      @Override
      public void executeMouseClickEvent() {
        String musicPath = "/home/jan/Documents/projects/milkyway/src/main/resources/testMusic.wav";

        try {

          AudioInputStream audio = AudioSystem.getAudioInputStream(new File(musicPath));
          Clip clip = AudioSystem.getClip();
          clip.open(audio);
          clip.start();

        } catch (Exception e) {
          e.printStackTrace();
        }

      }

    };
    Button testiBus = new Button(0.0, 0.0, 40.0, 50.0, "ig bi dr testibus", new ButtonStyle());
    System.out.println(clickButton);
    guiObjects.add(musicButton);


    Button tester = new Button(0.0, 0.0, 40.0, 50.0, "ig bi dr tester", new ButtonStyle()) {
      public void executeMouseClickEvent() {
        if (clickButton.isEnabled()) {
          clickButton.setEnabled(false);
        } else {
          clickButton.setEnabled(true);
        }
      }
    };

    EventHandler event = new EventHandler();

    Grid board = new Grid();
    guiObjects.add(board);
    while (!cd.isClosed()) {
      //guiObjects.addAll(bufferGuiObjects);
      //bufferGuiObjects = new ArrayList<>();
      event.getEvent(cd);
      for (GuiObject guiObject : guiObjects) {
        guiObject.draw(cd);
      }
      cd.show(16);
      cd.clear();
    }
  }
}
