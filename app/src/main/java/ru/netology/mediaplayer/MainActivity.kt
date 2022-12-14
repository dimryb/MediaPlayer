package ru.netology.mediaplayer

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val observer = MediaLifecycleObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(observer)

        findViewById<Button>(R.id.play).setOnClickListener {
            observer.apply {
                mediaPlayer?.setDataSource(
                    "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"
                )
            }.play()
        }
    }
}