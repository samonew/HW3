package edu.up.cs301.fangman;

        import android.app.Dialog;
        import android.content.Context;
        import android.content.res.Resources;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Path;
        import android.graphics.RectF;
        import android.util.AttributeSet;
        import android.util.Log;
        import android.view.SurfaceView;
        import android.widget.TextView;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Random;

        import static android.graphics.Path.Direction.CW;

/**
 * SurfaceView for playing "Fang Man" game.
 *
 * @author **** Samone Watkins ****
 * @author Steven R. Vegdahl
 * @version **** February 10, 2020 ****
 */

public class FangManSurfaceView extends SurfaceView {

    // the array of many English words, from which one is picked. This is
    // read in from a resource file.
    private ButtonModel model = new ButtonModel();
    private static String[] words;
    public int length;


    // constructor, modeled after superclass constructor
    public FangManSurfaceView(Context context) {
        super(context);
        init(context);
    }

    // constructor, modeled after superclass constructor
    public FangManSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    // constructor, modeled after superclass constructor
    public FangManSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * Common constructor code -- initializes instance variables
     * @param context the context object, from the activity
     */
    private void init(Context context) {

        // read the words from the resource file
        if (words == null) {
            words = readWordsFromResourceFile(context);
        }
    }

    /**
     * method that draws the image for our view
     *
     * @param c the canvas on which to draw
     */
    @Override
    public void onDraw(Canvas c) {

        //dummy variables for the canvas height and width
        int height = c.getHeight();
        int width = c.getWidth();

        //variable to base the dimensions of everything on
        int r = width / 10;
        int x = width / 2 + 100;
        int y = height / 2;
        int length = model.chosenWord.length;
        int linex = 300;

        // draw a random word from our list onto the Canvas
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        p.setTextSize(120);
        p.setStyle(Paint.Style.STROKE);

        Path path = new Path();

        //sets a paint object for the features (named background which is confusing)
        Paint background = new Paint();
        background.setColor(Color.BLACK);
        background.setTextSize((float)120);
        background.setStyle(Paint.Style.STROKE);

        //checks to see if the blanks array has any true values. If it does then draw the letter guessed
        for(int i = 0; i < length; i++){
            if(!model.blanks[i]){
                c.drawLine((float)linex, (float)900, (float)linex+50, (float)900, background);
                linex += 110;
            }
            else{
                c.drawText(model.chosenWord, i, 1, (float)linex, (float)900, background);
                linex += 100;
            }
        }

        //draws features according to the number of wrong guesses
        if(model.numWrongGuesses == 1){
            drawFace( c,x, y, r, p);
        }
        if(model.numWrongGuesses == 2){
            drawFace(c, x, y, r, p);
            drawEye(c,x - 50,y - 40,r/3, background);
        }
        if(model.numWrongGuesses == 3){
            drawFace(c, x, y, r, p);
            drawEye(c,x - 50,y - 40,r/3, background);
            drawEye(c, x + 50, y - 40, r / 3, background);
        }
        if(model.numWrongGuesses == 4){
            drawFace(c, x, y, r, p);
            drawEye(c,x - 50,y - 40,r/3, background);
            drawEye(c, x + 50, y - 40, r / 3, background);
            drawMouth(c, x, y, r / 8, background);
        }
        if(model.numWrongGuesses == 5){
            drawFace(c, x, y, r, p);
            drawEye(c,x - 50,y - 40,r/3, background);
            drawEye(c, x + 50, y - 40, r / 3, background);
            drawMouth(c, x, y, r / 8, background);
            drawNose(c, x, y, background);
        }


        int lines = 300;
        if(model.isGameOver){

            if(model.numWrongGuesses == 5){
                c.drawText("You lose! Play again", x - 400, y - 200, p);
            }
            else if(model.numRightGuesses == model.chosenWord.length) {
                c.drawText("Congradulations you win!", x - 400, y - 200, p);
            }

            for(int j = 0; j < model.chosenWord.length; j++){
                c.drawText(model.chosenWord, j, 1, lines, 900, background );
                lines += 110;
            }
        }
    }

    //getter method for the button model
    public ButtonModel getModel(){
        return model;
    }


    //methods that draw features of the fangMan
    public void drawFace(Canvas canvas, float x, float y, float r, Paint p){
        canvas.drawCircle(x, y, r, p);
    }

    public void drawEye(Canvas canvas, float x, float y, float r, Paint p){
        canvas.drawCircle(x, y, r, p);
        canvas.drawCircle(x, y, r/3, p);
    }

    public void drawMouth(Canvas canvas, float x, float y, float r, Paint p){
        canvas.drawCircle(x, y, r , p);
        //RectF r = new RectF(x - 50, y, x + 50, y - 50);
        //canvas.drawArc( r, 90, 180, false, p);
    }

    public void drawNose(Canvas canvas, float x, float y, Paint p){
        //canvas.drawOval(x - 25, y - 20, x + 25, y + 25, p);
        RectF rect = new RectF(x - 25, y + 50, x + 25, y + 150);
        canvas.drawArc(rect, 180, 180, true, p);

    }

    public void drawEar(Canvas canvas, float x, float y, boolean b, Paint p){

        float q;

        if(b){
            q = x + 100;
        }
        else{
            q = x - 100;
        }

        RectF rect = new RectF(q, y, x , y - 300);
        canvas.drawArc(rect, 270, 180, true, p);
        canvas.drawArc(rect, 90, 180, true, p);

        RectF r = new RectF(q + 15, y, x, y + 2);
        canvas.drawArc(rect, 90, 180, true, p);
    }

    //getter method for the array of the words
    public String[] getWords(){
        return words;
    }

    /**
     * reads list of game-words from the resource file
     *
     * @param context the context object
     * @return the array of words
     */
    private String[] readWordsFromResourceFile(Context context) {

        // create input reader for the word file
        InputStream is = context.getResources().openRawResource(R.raw.word_list);
        InputStreamReader ir = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(ir);

        // create array-list for holding the words
        ArrayList<String> lines = new ArrayList<String>();

        // read each line as a word; add each to the array-list
        try {
            for (;;) {
                String line = br.readLine();
                if (line == null) break;
                lines.add(line.trim());
            }
            br.close();
        } catch (IOException e) {
        }
        if (lines.size() == 0) {
            // if we did not get any words, put a dummy "word" in
            lines.add("ERROR READING FILE");
        }

        // return the array-version of the word
        return lines.toArray(new String[0]);
    }
}
