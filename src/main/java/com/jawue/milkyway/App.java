package com.jawue.milkyway;

import codedraw.CodeDraw;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class App {
  public static List<GuiObject> guiObjects = new ArrayList<>();
  public static List<GuiObject> bufferGuiObjects = new ArrayList<>();
  public CodeDraw cd = new CodeDraw();

  public EventHandler event = new EventHandler();

  public static void main(String[] args) {
    App app = new App();
    app.run();
  }
  public void run() {
    // Instantiates a new CodeDraw window with the size of 600x600 pixel


   /* GuiObject clickButton = new Button(50.0, 200.0, 100.0, 200.22, "press me", new ButtonStyle()) {
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


    Button tester = new Button(20.0, 50.0, 40.0, 50.0, "ig bi dr tester", new ButtonStyle()) {
      public void executeMouseClickEvent() {
        if (clickButton.isEnabled()) {
          clickButton.setEnabled(false);
        } else {
          clickButton.setEnabled(true);
        }
      }
    };
    App.guiObjects.add(musicButton);
    App.guiObjects.clear();
    List<GuiObject> buttonList = new ArrayList<>(Arrays.asList(new Button("button1"), new Button("button2"), new Button("button3")));
    Layout layout = new Layout(buttonList, 450.0, 100.0, 20.0, 200.0);
    App.guiObjects.add(layout);

    while (true) {
     draw();
    }
  }

 List<GuiObject> buttonList = new ArrayList<>(Arrays.asList(new Button("button1"), new Button("button2"), new Button("button3")));
  Layout layout = new Layout(buttonList, 250.0, 250.0, 300.0, 400.0);
  */

    public void draw () {
      event.handleEvents(cd);
      for (GuiObject guiObject : guiObjects) {
        guiObject.draw(cd);
      }
      cd.show(16);
      cd.clear();


    }
  }

}
