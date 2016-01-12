package br.com.nery.touchfeedback;

import android.graphics.Color;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTest {
    @Test
    public void colorAlpha_isCorrect() throws Exception {
        //TODO implement MOCKITO
        assertEquals(Bindings.getColorWithAlpha(Color.RED, 0.75f), 3);
    }
}