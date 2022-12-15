package ru.netology.mediaplayer

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val observer = MediaLifecycleObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(observer)

        val videoView = findViewById<VideoView>(R.id.videoView)

        findViewById<Button>(R.id.play).setOnClickListener {
            videoView.apply {
                setMediaController(MediaController(this@MainActivity))
                setVideoURI(
                    Uri.parse("https://archive.org/download/BigBuckBunny1280x720Stereo/big_buck_bunny_720_stereo.mp4")
                )
                setOnPreparedListener {
                    start()
                }
                setOnCompletionListener {
                    stopPlayback()
                }
            }
        }
    }
}