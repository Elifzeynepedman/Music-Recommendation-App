package bitirme.proje.musicrecommendation;

import android.media.MediaPlayer;
import android.util.Log;

public class Song {

    String[] songNames = new String[30];
    String[] songArtist = new String[30];
    String[] songURL = new String[30];
    String[] songImage = new String[30];
    String[] songMood = new String[30];


    public void songInitialize(){
        songNames[0] = "Can't Stop The Feeling";
        songArtist[0] = "Justin Timberlake";
        songURL[0] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2FCAN'T%20STOP%20THE%20FEELING!%20-%20Justin%20Timberlake%20(Lyrics)%20.mp3?alt=media&token=7240c4cc-152d-4c23-85eb-157eb67a1628";
        songImage[0] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2Fcant%20stop%20the%20feelingjfif%20-%20Copy.jfif?alt=media&token=f9550f6c-07a6-4302-a4da-122663604613";
        songMood[0] = "happy";

        songNames[1] = "Happy";
        songArtist[1] = "Pharrell Williams";
        songURL[1] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2FPharrell%20Williams%20-%20Happy%20(Video).mp3?alt=media&token=6e941471-e7cb-4a99-8eda-5ca0fc225381";
        songImage[1] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2Fhappy%20-%20Copy.jfif?alt=media&token=891e7af1-4476-4a0f-95a0-efcd9e3813df";
        songMood[1] = "happy";

        songNames[2] = "Therefore I Am";
        songArtist[2] = "Billie Eillish";
        songURL[2] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Billie%20Eilish%20-%20Therefore%20I%20Am%20(Official%20Lyric%20Video).mp3?alt=media&token=551d3566-42ca-4203-ad14-dfaf1127204f";
        songImage[2] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/therefore.jfif?alt=media&token=798d9dcc-78f5-455a-b017-00fe24924192";
        songMood[2] = "angry";

        songNames[3] = "Before He Cheats";
        songArtist[3] = "Carrie Underwood";
        songURL[3] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Carrie%20Underwood%20-%20Before%20He%20Cheats%20(Official%20Video).mp3?alt=media&token=50985e65-c7c2-4f80-87e7-1e81dff3fd7e";
        songImage[3] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/before%20he.jfif?alt=media&token=855ecd68-2cba-4b03-bb01-0ca286568a10";
        songMood[3] = "angry";

        songNames[4] = "FU";
        songArtist[4] = "Miley Cyrus";
        songURL[4] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/FU.mp3?alt=media&token=41a0213f-48d6-441f-b31b-859dd4bbde64";
        songImage[4] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/FU.jfif?alt=media&token=50aeb619-67aa-4cdf-951a-4719dea1f5bd";
        songMood[4] = "angry";
    }

    public String getSongNames(int i) {
        songInitialize();
        return songNames[i];
    }

    public String getSongArtist(int i) {
        songInitialize();
        return songArtist[i];
    }

    public String getSongURL(int i) {
        songInitialize();
        return songURL[i];
    }

    public String getSongImage(int i) {
        songInitialize();
        return songImage[i];
    }

    public String getSongMood(int i) {
        songInitialize();
        return songMood[i];
    }
}

