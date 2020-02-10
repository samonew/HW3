package edu.up.cs301.fangman;
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

        for(int i = 0; i < fangman.length; i++){

        }

        if(model.numWrongGuesses == model.numFeatures){
            model.isGameOver = true;
        }

        if(!model.inWord){
            model.numWrongGuesses ++;
            fangman.invalidate();
        }

    }


    public void onCheckedChanged(CompoundButton button, boolean b){

    }
}
