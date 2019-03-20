package com.zuhlke.command;

import com.zuhlke.model.Canvas;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DrawLineTest {

    private Canvas canvas;
    private DrawLine subject;
    private String br;
    private String ans;

    @BeforeEach
    void setUp() {
        canvas = new Canvas(20, 4);
        subject = new DrawLine();
        br = System.getProperty("line.separator");
        ans = br +
                "----------------------" + br +
                "|                    |" + br +
                "|xxxxxx              |" + br +
                "|                    |" + br +
                "|                    |" + br +
                "----------------------" + br;

    }

    @Test
    void drawLineImageTest() {
        String command = "L 1 2 6 2";

        //prepare to redirect output
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        try {
            canvas = subject.execute(command.split(" "), canvas);
            canvas.print();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ans, os.toString());
    }

    @Test
    void drawLineInReverseImageTest() {
        Canvas testCanvas = new Canvas(20, 4);
        String command = "L 6 2 1 2";

        //prepare to redirect output
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        try {
            canvas = subject.execute(command.split(" "), testCanvas);
            canvas.print();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertEquals(ans, os.toString());
    }

    @AfterEach
    void tearDown() {
        //Restore normal output
        System.setOut(System.out);
    }
}