package edu.up.cs301.fangman;

        import android.content.Context;
        import android.content.res.Resources;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Path;
        import android.util.AttributeSet;
        import android.util.Log;
        import android.view.SurfaceView;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Random;

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
    public static char[] chosenWord;
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

        int height = c.getHeight();
        int width = c.getWidth();


        int r = width / 3 + 100;
        int x = width / 2 + 100;
        int y = height / 2;

        // draw a random word from our list onto the Canvas
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        p.setTextSize(120);


        Random ran = new Random();
        int id = ran.nextInt(words.length);

        //turns the word into an array of characters
        chosenWord= words[id].toCharArray();

        //displays the chosen word in logcat info
        Log.i("chosen word: ",words[id]);


        length = chosenWord.length;

        for(int i = 0; i < chosenWord.length; i ++){

        }



    }

    //getter method for the button model
    public ButtonModel getModel(){
        return model;
    }

    //getter method for the chosenword array
    public static char[] getChosenWord() {

        return chosenWord;
    }

    //methods that draw features of the fangMan
    public void drawFace(Canvas canvas, float x, float y, float r, Paint p){
        canvas.drawCircle(x, y, r, p);
    }

    public void drawEye(Canvas canvas, float x, float y, float r, Paint p){
        canvas.drawCircle(x, y, r, p);
        canvas.drawCircle(x, y, r/3, p);
    }

    public void drawMouth(Path p, float x, float y){
        p.moveTo(x,y);

    }

    public void drawNose(){

    }

    public void drawEar(){

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
