package edu.up.cs301.fangman;

import android.app.Activity;
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

        fillLetters();

    }

    //fills the alphabet array with each letter of the alphabet
    public void fillLetters(){
        letters[0] = 'A';
        letters[1] = 'B';
        letters[2] = 'C';
        letters[3] = 'D';
        letters[4] = 'E';
        letters[5] = 'F';
        letters[6] = 'G';
        letters[7] = 'H';
        letters[8] = 'I';
        letters[9] = 'J';
        letters[10] = 'K';
        letters[11] = 'L';
        letters[12] = 'M';
        letters[13] = 'N';
        letters[14] = 'O';
        letters[15] = 'P';
        letters[16] = 'Q';
        letters[17] = 'R';
        letters[18] = 'S';
        letters[19] = 'T';
        letters[20] = 'U';
        letters[21] = 'V';
        letters[22] = 'W';
        letters[23] = 'X';
        letters[24] = 'Y';
        letters[25] = 'Z';
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

    public void onClick() {

    }
}



