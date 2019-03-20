# KeyTaker
Simple library allowing performing any action(s) after user writes specified word(s) on his keyboard (even outside the app).
Uses JNativeHook library

## Usage example

Simuate "HEY!" writing after user writes "print";

```java
String triggerWord = "print";
ActionPerformer actionPerformer = new ActionPerformer();
actionPerformer.addAction(triggerWord, (word) -> {
  try {
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_H);
		robot.keyPress(KeyEvent.VK_E);
	  robot.keyPress(KeyEvent.VK_Y);
		robot.keyPress(KeyEvent.VK_EXCLAMATION_MARK);
	}catch (AWTException e) {
		  e.printStackTrace();
	}
});
		
KeyTakerListener listener = new KeyTakerListener(actionPerformer);
listener.startListening();

```

## Used technologies
* Java 8
* JNativeHook
* Maven

