package fr.iutlens.mmi.ninjajumper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import fr.iutlens.mmi.ninjajumper.utils.AccelerationProxy;

/***
 * Crédits image : https://pixabay.com/fr/lapin-dessin-animé-jeu-élément-1582176/
 *
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    private AccelerationProxy proxy;
    private GameView game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // On récupère la vue du jeu
        game = findViewById(R.id.gameView);
        TextView score = findViewById(R.id.textView);

        // On configure le jeu pour recevoir les changements d'orientation
        proxy = new AccelerationProxy(this, game);

        game.setTextViewScore(score);
        game.setViewPerdu(findViewById(R.id.buttonJouer),findViewById(R.id.textViewMort));
    }


    @Override
    protected void onResume() {
        super.onResume();
        proxy.resume(); // On relance l'accéléromètre
    }

    @Override
    protected void onPause() {
        super.onPause();
        proxy.pause(); // On mets en pause l'accéléromètre
    }

    public void rejouer(View view) {
/*        TextView score = findViewById(R.id.textView);
        game.setTextViewScore(score);*/
        game.rejouer();
    }
}
