package edu.up.cs301.fangman;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

public class buttonController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    private FangManSurfaceView fangman;
    private ButtonModel model;

    public buttonController(FangManSurfaceView view){

        fangman = view;
        model = fangman.getModel();
    }


    public void onClick(View view){
        Button b = (Button)view;
        String guessedString = b.getText().toString();
        model.guessedChar = guessedString.charAt(0);

        for(int i = 0; i < fangman.length; i++){
            if(model.chosenWord[i] == model.guessedChar){
                model.inWord = true;
                model.numRightGuesses ++;
                model.blanks[i] = true;
                Log.i("guess:" ,"right");
            }

            else{
                model.inWord = false;
                model.numWrongGuesses ++;
                Log.i("guess:", "right");
            }

        }

        if(model.numWrongGuesses == model.numFeatures){
            model.isGameOver = true;
        }

        fangman.invalidate();

    }

    public void onCheckedChanged(CompoundButton button, boolean b){

    }
}
