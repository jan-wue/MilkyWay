# MilkyWay 

## Introduction 
MilkyWay is a graphical user interface library which is based on codedraw and is written in java. With MilkyWay you can draw your own labels, buttons, layouts, text and images. All these objects extend the superclass GuiObject. 

### Buttons

First create a button `Button musicButton = new Buton(400.00, 400.0, 100.0, 150.0, "play music", new ButtonStyle())` 
this button has a x cordinate by 400 and a y cordinate by 400 the width of the button is 100 and the height 150 the new ButtonStyle is a style object which you can customize in order to change the color of the button. A button has three states normal, hovered and clicked each of these states has its own border, text and fill color. 

#### Handle button events

create an anonymous class of your button and override the executeMouseClickEvent method for example: 

```
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
      
```
in order to draw the button the user has to add the button to the static ArrayList guiObjects.
`App.guiObjects.add(musicButton);`
if you run the main method following content will be displayed: 
![Alt text](src/main/resources/images/milkyway.png?raw=true "Title")

### Label
A label is a rectangle wich can display text. 
createing a label object for instance: 
`GuiObject label = new Label(x, y, width, height, text);`
like all Guiobjects the label class has a draw method wich will draw the label with help of the codedraw object cd : 
```
public void draw(CodeDraw cd) {
    
    cd.drawRectangle(this.x, this.y, this.width, this.height);
    cd.drawText(this.x + 5, this.y + 20, this.text);
  }
``` 

### Layout 
A layout takes a list of guiobjects and alignes the objects horizontally
```
List<GuiObject> buttonList = new ArrayList<>(Arrays.asList(new Button("button1"), new Button("button2"), new Button("button3")));
    Layout layout = new Layout(buttonList, 450.0, 100.0, 20.0, 200.0);
    App.guiObjects.add(layout);
```
[Alt text](src/main/resources/images/layout.png?raw=true "Layout")


### Text 
It is fairly easy to write text with milkyway use the method createText of the Text class: 
```
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
  ```

### CodeDraw 
In order to use milkyway you should read the readme of codedraw https://github.com/Krassnig/CodeDraw 









