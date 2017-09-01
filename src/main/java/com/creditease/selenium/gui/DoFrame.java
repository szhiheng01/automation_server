package com.creditease.selenium.gui;

import javax.swing.*;

/**
 * @author songzhiheng
 * @version V1.0
 * @Description: TODO
 * @date 2017/8/31 下午2:59
 */

public class DoFrame extends JFrame{

    private static final int FRAME_WIGHT = 800;
    private static final int FRAME_HIGH = 700;
    private static final int FRAME_X= 400;
    private static final int FRAME_Y= 100;

    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setTitle("Automation");
        jFrame.setBounds(FRAME_X,FRAME_Y,FRAME_WIGHT,FRAME_HIGH);
        jFrame.setVisible(true);


    }

}
