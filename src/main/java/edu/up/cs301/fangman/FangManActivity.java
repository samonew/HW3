package edu.up.cs301.fangman;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

import static edu.up.cs301.fangman.FangManSurfaceView.getChosenWord;

/**
 * activity class for the Fang Man game
 *
 * @author **** Samone Watkins ****
 * @author **** February 10, 2020 ****
 *
 */
public class FangManActivity extends Activity {

    private char[] letters = new char[25];


    /**
     * standard 'onCreate' method
     *
     * @param savedInstanceState saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // invoke superclass constructor
        super.onCreate(savedInstanceState);

        // load layout
        setContentView(R.layout.activity_fang_man);


        FangManSurfaceView fangMan = findViewById(R.id.main_view);
                //new FangManSurfaceView(context);

        buttonController controller = new buttonController(fangMan);

        //initialized all of the alphabet buttons
        Button A = findViewById(R.id.button1);
        Button B = findViewById(R.id.button2);
        Button C = findViewById(R.id.button3);
        Button D = findViewById(R.id.button4);
        Button E = findViewById(R.id.button5);
        Button F = findViewById(R.id.button6);
        Button G = findViewById(R.id.button7);
        Button H = findViewById(R.id.button8);
        Button I = findViewById(R.id.button9);
        Button J = findViewById(R.id.button10);
        Button K = findViewById(R.id.button11);
        Button L = findViewById(R.id.button12);
        Button M = findViewById(R.id.button13);
        Button N = findViewById(R.id.button14);
        Button O = findViewById(R.id.button15);
        Button P = findViewById(R.id.button16);
        Button Q = findViewById(R.id.button17);
        Button buttonR = findViewById(R.id.button18);
        Button S = findViewById(R.id.button19);
        Button T = findViewById(R.id.button20);
        Button U = findViewById(R.id.button21);
        Button V = findViewById(R.id.button22);
        Button W = findViewById(R.id.button23);
        Button X = findViewById(R.id.button24);
        Button Y = findViewById(R.id.button25);
        Button Z = findViewById(R.id.button26);

    }




    /**
     * standard create-options menu method
     *
     * @param menu the menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_fang_man, menu);
        return true;
    }

    /**
     * standard callback method for menu-item selection
     *
     * @param item the item selected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}



