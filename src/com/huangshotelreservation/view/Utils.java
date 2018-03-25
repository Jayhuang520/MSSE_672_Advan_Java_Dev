package com.huangshotelreservation.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Utils {
    /**
     * Centers the window
     * In the case of the frame size is bigger than
     * the screen, just set the framesize to the screen
     * size.
     * 
     *Else,center the screen.
     * @param comp Component
     */
    public static void centerWindow(Component comp) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    Dimension frameSize = comp.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    comp.setLocation( (screenSize.width - frameSize.width) / 2,
                     (screenSize.height - frameSize.height) / 2);
  }
}
