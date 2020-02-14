package edu.up.cs301.fangman;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

public class buttonController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    private FangManSurfaceView fangman;
    private ButtonModel model;
    private FangManActivity activity = new FangManActivity();

    public buttonController(FangManSurfaceView view){

        fangman = view;
        model = fangman.getModel();
    }


    //method called when a button is clicked
    public void onClick(View view){

        //gets the character of the button that called the onClick() method and assigns that character
        //to model.guessedChar
        Button b = (Button)view;
        String guessedString = b.getText().toString();
        model.guessedChar = guessedString.charAt(0);

        model.inWord = false;
        //loops through the chosen word array to see if the character is in the array
        //if so then increase the number of right guesses, if not then increase the number of wrong guesses
        //either way invalidate and redraw after checking if there's still more wrong moves to be made
        for(int i = 0; i < model.chosenWord.length; i++){
            if(model.chosenWord[i] == model.guessedChar){
                model.inWord = true;
                model.numRightGuesses ++;
                model.blanks[i] = true;
                Log.i("guess:" ,"right");
            }

            else{

                Log.i("guess:", "wrong");
            }
        }

        if(!model.inWord){
            model.numWrongGuesses++;
        }

        if(model.numWrongGuesses == model.numFeatures){
            model.isGameOver = true;
        }
        if(model.numRightGuesses == model.chosenWord.length){
            model.isGameOver = true;
        }
        if(model.numRightGuesses > model.chosenWord.length || model.numWrongGuesses > model.numFeatures){
            activity.recreate();
        }

        fangman.invalidate();

    }

    public void onCheckedChanged(CompoundButton button, boolean b){

    }
}
