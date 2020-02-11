package edu.up.cs301.fangman;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

/**
 * activity class for the Fang Man game
 *
 * @author **** Samone Watkins ****
 * @author **** February 10, 2020 ****
 *
 */
public class FangManActivity extends Activity {

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
        buttonController controller = new buttonController(fangMan);
        Random ran = new Random();
        int id = ran.nextInt(fangMan.getWords().length);


        //turns the word into an array of characters
        fangMan.getModel().chosenWord = fangMan.getWords()[id].toCharArray();
        fangMan.getModel().blanks = new boolean[fangMan.getModel().chosenWord.length];
        for(int i = 0; i < fangMan.getModel().chosenWord.length; i++){
            fangMan.getModel().blanks[i] = false;
        }

        //displays the chosen word in logcat info
        Log.i("chosen word: ", fangMan.getWords()[id]);


        //initialized all of the alphabet buttons
        Button A = findViewById(R.id.button1);
        A.setOnClickListener(controller);
        Button B = findViewById(R.id.button2);
        B.setOnClickListener(controller);
        Button C = findViewById(R.id.button3);
        C.setOnClickListener(controller);
        Button D = findViewById(R.id.button4);
        D.setOnClickListener(controller);
        Button E = findViewById(R.id.button5);
        E.setOnClickListener(controller);
        Button F = findViewById(R.id.button6);
        F.setOnClickListener(controller);
        Button G = findViewById(R.id.button7);
        G.setOnClickListener(controller);
        Button H = findViewById(R.id.button8);
        H.setOnClickListener(controller);
        Button I = findViewById(R.id.button9);
        I.setOnClickListener(controller);
        Button J = findViewById(R.id.button10);
        J.setOnClickListener(controller);
        Button K = findViewById(R.id.button11);
        K.setOnClickListener(controller);
        Button L = findViewById(R.id.button12);
        L.setOnClickListener(controller);
        Button M = findViewById(R.id.button13);
        M.setOnClickListener(controller);
        Button N = findViewById(R.id.button14);
        N.setOnClickListener(controller);
        Button O = findViewById(R.id.button15);
        O.setOnClickListener(controller);
        Button P = findViewById(R.id.button16);
        P.setOnClickListener(controller);
        Button Q = findViewById(R.id.button17);
        Q.setOnClickListener(controller);
        Button buttonR = findViewById(R.id.button18);
        buttonR.setOnClickListener(controller);
        Button S = findViewById(R.id.button19);
        S.setOnClickListener(controller);
        Button T = findViewById(R.id.button20);
        T.setOnClickListener(controller);
        Button U = findViewById(R.id.button21);
        U.setOnClickListener(controller);
        Button V = findViewById(R.id.button22);
        V.setOnClickListener(controller);
        Button W = findViewById(R.id.button23);
        W.setOnClickListener(controller);
        Button X = findViewById(R.id.button24);
        X.setOnClickListener(controller);
        Button Y = findViewById(R.id.button25);
        Y.setOnClickListener(controller);
        Button Z = findViewById(R.id.button26);
        Z.setOnClickListener(controller);

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