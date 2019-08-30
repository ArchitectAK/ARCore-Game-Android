package dev.ankit.arcore_demo

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.sceneform.ux.ArFragment

class MainActivity : AppCompatActivity() {

    private lateinit var arFragment: ArFragment

    private lateinit var scoreboard: ScoreboardView

    private var gameHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arFragment = supportFragmentManager.findFragmentById(R.id.ux_fragment) as ArFragment

    }

    private fun failHit() {
        scoreboard.score -= 50
        scoreboard.life -= 1
        if (scoreboard.life <= 0) {
            // Game over
            gameHandler.removeCallbacksAndMessages(null)
        }
    }
}