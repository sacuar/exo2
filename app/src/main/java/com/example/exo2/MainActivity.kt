package com.example.exo2

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.util.Util
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.DefaultDataSourceFactory
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.exoplayer.offline.DownloadHelper.createMediaSource
import androidx.media3.exoplayer.source.ConcatenatingMediaSource
import androidx.media3.exoplayer.source.MediaLoadData
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView
import net.bjoernpetersen.m3u.M3uParser
import net.bjoernpetersen.m3u.model.M3uEntry
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import javax.sql.DataSource

class MainActivity : AppCompatActivity() {

        private lateinit var player: ExoPlayer
        private lateinit var playerView:PlayerView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            playerView = findViewById(R.id.player_view)

            // Create an ExoPlayer instance
            player = ExoPlayer.Builder(this).build()

            // create a media item.
            val mediaItem = MediaItem.Builder()
                .setUri("https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4")
                .setMimeType(MimeTypes.APPLICATION_MP4)
                .build()

            // Create a media source and pass the media item
            val mediaSource = ProgressiveMediaSource.Factory(
                DefaultDataSource.Factory(this) // <- context
            )
                .createMediaSource(mediaItem)

            // Build the media item.
         //   val mediaItem = MediaItem.fromUri(videoUri)
// Set the media item to be played.
            player.setMediaItem(mediaItem)
// Prepare the player.
            player.prepare()
// Start the playback.
            player.play()

        }


    }
