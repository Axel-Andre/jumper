package fr.iutlens.mmi.jumper;

import android.graphics.Canvas;

import fr.iutlens.mmi.jumper.utils.SpriteSheet;

/**
 * Created by saad.alami on 16/03/18.
 */

class Fond {
    private final SpriteSheet sprite;

    public Fond(int sprite_id) {
        sprite = SpriteSheet.get(sprite_id);
    }

    public void paint(Canvas canvas, int height) {
       canvas.save();

       float scale = (1f*height)/sprite.h;
       canvas.scale(scale,scale);

        sprite.paint(canvas,0,0,0);
        sprite.paint(canvas,1,sprite.w,0);

       canvas.restore();
    }
}
