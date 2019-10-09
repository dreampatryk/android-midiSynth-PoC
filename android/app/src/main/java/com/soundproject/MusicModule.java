package com.soundproject;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.util.ArrayMap;
import android.util.SparseArray;
import org.billthefarmer.mididriver.MidiDriver;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.soundproject.midi.synth.SynthEngine;

public class MusicModule extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;
    private SynthEngine synthEngine;

    public MusicModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
        reactContext = reactContext;
    }

    @ReactMethod
    public void init(){
        synthEngine = new SynthEngine();
        synthEngine.start();
    }

    @ReactMethod
    public void playNote(final Callback callback, int note){
        synthEngine.noteOn(1, note, 100);
    }

    @ReactMethod
    public void stopNote(){
        synthEngine.allNotesOff();
    }

    @NonNull
    @Override
    public String getName() {
        return "MusicModule";
    }
}
