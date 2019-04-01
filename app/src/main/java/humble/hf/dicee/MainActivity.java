package humble.hf.dicee;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.stream.Stream;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int i;

    // Sound Constants
    private final int NR_OF_SIMULTANEOUS_SOUNDS = 1;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int NO_LOOP = 0;
    private final int PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

    //member var
    private SoundPool mSoundPool;
    private int mDiceSoundID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creates soundpool on startup
        mSoundPool = new SoundPool(NR_OF_SIMULTANEOUS_SOUNDS, AudioManager.STREAM_MUSIC, 0);

        //Loads and get ID to identify sounds
        mDiceSoundID = mSoundPool.load(getApplicationContext(),R.raw.dicesound, 1);


        //sets up button for rolling the dice
         Button rollButton = (Button) findViewById(R.id.rollButton);
        //sets up button for life counter
         Button lifeButton = (Button) findViewById(R.id.lifebutton);

        //links images to java via xml
        final ImageView leftDice = (ImageView) findViewById(R.id.image_leftDice);

        final ImageView rightDice = (ImageView) findViewById(R.id.image_rightDice);

        final ImageView lifeLeft = (ImageView) findViewById(R.id.lifeDie);
        //arrays with images used in app
        final int [] diceArray = {R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        final int [] lifeArray = {R.drawable.dice6,
                R.drawable.dice5,
                R.drawable.dice4,
                R.drawable.dice3,
                R.drawable.dice2,
                R.drawable.dice1
        };
        //
        rollButton.setSoundEffectsEnabled(false);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Sound", "sound play");
                mSoundPool.play(mDiceSoundID,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,NORMAL_PLAY_RATE);
                Log.d("Dicee", "Ze button is good");
                Random randomNumberGenrator = new Random();
                int number = randomNumberGenrator.nextInt(6);
                Log.d("Dicee"  , "Number is: " +number);
                leftDice.setImageResource(diceArray[number]);
                number = randomNumberGenrator.nextInt(6);
                rightDice.setImageResource(diceArray[number]);
                Log.d("Dicee" , "App has ran " +number);
            }


        });
        lifeButton.setSoundEffectsEnabled(false);
        lifeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Dicee" , "Life button sends DATA " );

               // for(int i = 0; i <lifeArray.length; i++)
               //     Log.d("Dicee" , "for loop iteration" + lifeArray[i]);

                lifeLeft.setImageResource(lifeArray[i]);
                Log.d("Dicee" , "Test for my counter"  );
                i++;

                if(i==6){
                    i =0;
                }

            }
        });
    }
}
