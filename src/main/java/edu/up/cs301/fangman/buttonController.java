package edu.up.cs301.fangman;
import android.view.View;
import android.widget.CompoundButton;

public class buttonController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    private FangManSurfaceView fangman;
    private ButtonModel model;

    public buttonController(FangManSurfaceView view){

        fangman = view;
        model = fangman.getModel();
    }

    public void onClick(View view){


        if(model.numRightGuesses >= fangman.length || model.numWrongGuesses == model.numFeatures){
            model.isGameOver = true;
        }

        if(model.inWord){
            model.numRightGuesses ++;

        }

        if(!model.inWord){
            model.numWrongGuesses ++;
            fangman.invalidate();
        }

    }


    public void onCheckedChanged(CompoundButton button, boolean b){

    }
}
