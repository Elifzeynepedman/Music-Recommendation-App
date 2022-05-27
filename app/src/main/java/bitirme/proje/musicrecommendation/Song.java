package bitirme.proje.musicrecommendation;

import android.media.MediaPlayer;
import android.util.Log;



//UPDATE FINAL REPORT
public class Song {

    String[] songNames = new String[30];
    String[] songArtist = new String[30];
    String[] songURL = new String[30];
    String[] songImage = new String[30];
    String[] songMood = new String[30];
    String[] songDuration = new String[30];



    public void songInitialize(){

        //songs between 0 and 9 are angry

        songNames[0] = "Therefore I Am";
        songArtist[0] = "Billie Eillish";
        songURL[0] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Billie%20Eilish%20-%20Therefore%20I%20Am%20(Official%20Lyric%20Video).mp3?alt=media&token=551d3566-42ca-4203-ad14-dfaf1127204f";
        songImage[0] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/therefore.jfif?alt=media&token=798d9dcc-78f5-455a-b017-00fe24924192";
        songMood[0] = "angry";
        songDuration[0] = "2:53";

        songNames[1] = "Before He Cheats";
        songArtist[1] = "Carrie Underwood";
        songURL[1] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Carrie%20Underwood%20-%20Before%20He%20Cheats%20(Official%20Video).mp3?alt=media&token=50985e65-c7c2-4f80-87e7-1e81dff3fd7e";
        songImage[1] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/before%20he.jfif?alt=media&token=855ecd68-2cba-4b03-bb01-0ca286568a10";
        songMood[1] = "angry";
        songDuration[1] = "3:18";

        songNames[2] = "FU";
        songArtist[2] = "Miley Cyrus";
        songURL[2] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/FU.mp3?alt=media&token=41a0213f-48d6-441f-b31b-859dd4bbde64";
        songImage[2] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/FU.jfif?alt=media&token=50aeb619-67aa-4cdf-951a-4719dea1f5bd";
        songMood[2] = "angry";
        songDuration[2] = "3:49";

        songNames[3] = "abcdefu";
        songArtist[3] = "GAYLE";
        songURL[3] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/GAYLE%20-%20abcdefu%20(Official%20Music%20Video).mp3?alt=media&token=3322fb8a-032b-4159-9a20-0bb0f16faf79";
        songImage[3] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/abcdfe.png?alt=media&token=355fe11d-ad51-4901-8b78-eab2d374d703";
        songMood[3] = "angry";
        songDuration[3] = "2:57";

        songNames[4] = "Nightmare";
        songArtist[4] = "Halsey";
        songURL[4] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Halsey%20-%20Nightmare.mp3?alt=media&token=e187562a-074f-45df-831c-b592b5b0d0ae";
        songImage[4] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/nightmare.jfif?alt=media&token=ddbee1bb-8bce-4094-a8c6-ff72c4bbb344";
        songMood[4] = "angry";
        songDuration[4] = "4:03";

        songNames[5] = "In The End";
        songArtist[5] = "Linkin Park";
        songURL[5] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/In%20The%20End%20%5BOfficial%20HD%20Music%20Video%5D%20-%20Linkin%20Park.mp3?alt=media&token=6dd0f7ad-9794-4ed0-a727-4d6417ca88c7";
        songImage[5] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/in%20the%20end.jfif?alt=media&token=2a735616-defb-46aa-8bf9-1e4a874489fc";
        songMood[5] = "angry";
        songDuration[5] = "3:38";

        songNames[6] = "Numb";
        songArtist[6] = "Linkin Park";
        songURL[6] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Numb%20%5BOfficial%20Music%20Video%5D%20-%20Linkin%20Park.mp3?alt=media&token=3cfd161a-3b6a-44e3-820d-ff2315b7a3ff";
        songImage[6] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/numb.jfif?alt=media&token=e696c7e9-ee7f-4834-a828-28a399b1d0ee";
        songMood[6] = "angry";
        songDuration[6] = "3:06";

        songNames[7] = "So What";
        songArtist[7] = "P!nk";
        songURL[7] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/P!nk%20-%20So%20What.mp3?alt=media&token=8c194827-967b-46ed-8485-e273aa32cc5b";
        songImage[7] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/so%20whar.jfif?alt=media&token=00a97f52-a455-4aa1-9167-5ff2db0538c1";
        songMood[7] = "angry";
        songDuration[7] = "3:45";

        songNames[8] = "FEEL NOTHING";
        songArtist[8] = "The Plot In You";
        songURL[8] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/The%20Plot%20In%20You%20-%20FEEL%20NOTHING%20(Official%20Music%20Video).mp3?alt=media&token=8755e4b9-6e33-4f70-90a3-af7ca4fd5cb9";
        songImage[8] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/download.jfif?alt=media&token=0702fcfa-05b9-4f69-9259-bf09b7db183c";
        songMood[8] = "angry";
        songDuration[8] = "4:08";

        songNames[9] = "Sweet But Psycho";
        songArtist[9] = "Ava Max";
        songURL[9] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Ava%20Max%20-%20Sweet%20but%20Psycho%20(Lyrics).mp3?alt=media&token=345d13c2-2560-41d6-b8da-0656b3e24a27";
        songImage[9] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sweet.jfif?alt=media&token=73793f1b-9caf-48b4-8c18-be87d3de567c";
        songMood[9] = "angry";
        songDuration[9] = "3:07";


        //songs between 10 and 19 are happy

        songNames[10] = "Shower";
        songArtist[10] = "Becky G";
        songURL[10] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2FBecky%20G%20-%20Shower%20(Audio).mp3?alt=media&token=25169e89-e160-4895-b19d-0df10c2fcbd3";
        songImage[10] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2Fbg%20-%20Copy.jfif?alt=media&token=cc03e05d-89a3-42d2-8c90-4208810bbeb9";
        songMood[10] = "happy";
        songDuration[10] = "3:28";

        songNames[11] = "CAN'T STOP THE FEELING";
        songArtist[11] = "Justin Timberlake";
        songURL[11] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2FCAN'T%20STOP%20THE%20FEELING!%20-%20Justin%20Timberlake%20(Lyrics)%20.mp3?alt=media&token=7240c4cc-152d-4c23-85eb-157eb67a1628";
        songImage[11] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2Fcant%20stop%20the%20feelingjfif%20-%20Copy.jfif?alt=media&token=f9550f6c-07a6-4302-a4da-122663604613";
        songMood[11] = "happy";
        songDuration[11] = "3:59";

        songNames[12] = "Tongue Tied";
        songArtist[12] = "Grouplove";
        songURL[12] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2FGrouplove%20-%20Tongue%20Tied%20%5BOFFICIAL%20VIDEO%5D.mp3?alt=media&token=e0fcc163-1947-4e80-b082-3abeeec6ad58";
        songImage[12] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2FTongue%20tied.jfif?alt=media&token=cd5900dc-525a-4daa-b0a0-4c35ef59abbf";
        songMood[12] = "happy";
        songDuration[12] = "4:14";

        songNames[13] = "Last Friday Night";
        songArtist[13] = "Katy Perry";
        songURL[13] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2FKaty%20Perry%20-%20Last%20Friday%20Night%20-%20Audio.mp3?alt=media&token=171a7884-1c00-43fb-9cab-93dc1dbb4e17";
        songImage[13] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2Flfnjfif.jfif?alt=media&token=d471645f-84b0-4f5b-945b-76dc653e7461";
        songMood[13] = "happy";
        songDuration[13] = "4:02";

        songNames[14] = "Classic";
        songArtist[14] = "MKTO";
        songURL[14] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2FMKTO%20-%20Classic%20(Lyrics).mp3?alt=media&token=b2f3113d-6991-4dc5-893d-de786333be6c";
        songImage[14] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2Fmkto.jfif?alt=media&token=aef8b265-09f2-4d6d-b233-b65638f3de63";
        songMood[14] = "happy";
        songDuration[14] = "2:53";

        songNames[15] = "Sugar";
        songArtist[15] = "Maroon 5";
        songURL[15] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2FMaroon%205%20-%20Sugar%20(Official%20Music%20Video).mp3?alt=media&token=73337cf1-2f69-43fa-bef0-02b887d92278";
        songImage[15] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2Fsugar.jfif?alt=media&token=35337878-090c-4f5a-820d-de7b1b5d0759";
        songMood[15] = "happy";
        songDuration[15] = "5:01";

        songNames[16] = "Happy";
        songArtist[16] = "Pharrell Williams";
        songURL[16] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2FPharrell%20Williams%20-%20Happy%20(Video).mp3?alt=media&token=6e941471-e7cb-4a99-8eda-5ca0fc225381";
        songImage[16] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2Fhappy%20-%20Copy.jfif?alt=media&token=891e7af1-4476-4a0f-95a0-efcd9e3813df";
        songMood[16] = "happy";
        songDuration[16] = "4:00";

        songNames[17] = "Don't Stop The Music";
        songArtist[17] = "Rihanna";
        songURL[17] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2FRihanna%20-%20Don't%20Stop%20The%20Music%20(Lyrics).mp3?alt=media&token=fec17feb-bb0c-4b72-928b-16d2293d98cf";
        songImage[17] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2Fdont%20stop%20the%20music%20-%20Copy.jfif?alt=media&token=8864a7d7-0f87-42b2-a678-f8495bf6bb31";
        songMood[17] = "happy";
        songDuration[17] = "4:26";

        songNames[18] = "Hey, Soul Sister";
        songArtist[18] = "Train";
        songURL[18] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2FTrain%20-%20Hey%2C%20Soul%20Sister%20(Official%20Video).mp3?alt=media&token=2e1aa22b-cf6a-4a31-bd0a-4065aa51a1e9";
        songImage[18] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2Fbey%20soul%20-%20Copy.jfif?alt=media&token=694918d6-9058-4386-bb81-af94fdf6e997";
        songMood[18] = "happy";
        songDuration[18] = "3:37";

        songNames[19] = "DJ Got Us Falling In Love";
        songArtist[19] = "Usher ft. Pitbull";
        songURL[19] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2FUsher%20Ft.Pitbull%20-%20Dj%20Got%20Us%20Falling%20In%20Love%20(Audio).mp3?alt=media&token=864e1182-98a1-4e6d-824f-cc86ef5a5c81";
        songImage[19] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/Happy%20Songs%2Fusher.jfif?alt=media&token=fe9cd18d-65f3-45e6-a956-3bc8a3c2e578";
        songMood[19] = "happy";
        songDuration[19] = "3:40";



        //songs between 20 and 29 are sad

        songNames[20] = "7 Years";
        songArtist[20] = "Lukas Graham";
        songURL[20] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2F7%20Years-%20Lukas%20Graham%20(Audio).mp3?alt=media&token=b0dea6a0-20b8-4b2c-ae04-f8b8e996917f";
        songImage[20] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2Fdownload.jfif?alt=media&token=ff417314-657d-4db5-8924-7118d9a9461e";
        songMood[20] = "sad";
        songDuration[20] = "3:53";

        songNames[21] = "Six Feet Under";
        songArtist[21] = "Billie Eillish";
        songURL[21] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2FBillie%20Eilish%20-%20Six%20Feet%20Under%20(Lyrics).mp3?alt=media&token=23a31a82-ba50-4724-ab64-f923f8b20db2";
        songImage[21] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2Fdownload%20(1).jfif?alt=media&token=fa614b6f-015b-423a-b87d-b6f746d0d861";
        songMood[21] = "sad";
        songDuration[21] = "3:07";

        songNames[22] = "Lovely";
        songArtist[22] = "Billie Eilish ft. Khalid";
        songURL[22] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2FBillie%20Eilish%2C%20Khalid%20-%20lovely.mp3?alt=media&token=19f7ffee-023e-4d7e-b3ef-a583556cd341";
        songImage[22] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2Fdownload%20(2).jfif?alt=media&token=10314dd2-80f8-47a1-9964-d10cb7a336d8";
        songMood[22] = "sad";
        songDuration[22] = "3:20";

        songNames[23] = "Yellow";
        songArtist[23] = "Coldplay";
        songURL[23] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2FColdplay%20-%20Yellow%20(Official%20Video).mp3?alt=media&token=579d0ff3-cbf4-4c88-86cc-00486df128b9";
        songImage[23] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2Fdownload%20(3).jfif?alt=media&token=c2c889be-501a-40dc-93ee-dd748c6f7234";
        songMood[23] = "sad";
        songDuration[23] = "4:32";

        songNames[24] = "The A Team";
        songArtist[24] = "Ed Sheeran";
        songURL[24] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2FEd%20Sheeran%20-%20The%20A%20team%20(audio).mp3?alt=media&token=8b61bedd-ed1d-4860-a7ce-82bd79ff9e4c";
        songImage[24] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2Fdownload%20(4).jfif?alt=media&token=71e60cd1-c208-40ad-ba23-3e855952112e";
        songMood[24] = "sad";
        songDuration[24] = "4:18";

        songNames[25] = "Someone You Loved";
        songArtist[25] = "Lewis Capaldi";
        songURL[25] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2FLewis%20Capaldi%20-%20Someone%20You%20Loved%20(Lyrics).mp3?alt=media&token=24a7ef1b-9765-46b7-b38e-21b1c04b0a6e";
        songImage[25] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2Fdownload%20(5).jfif?alt=media&token=5c548918-a04c-497b-abc2-74cb5c90894a";
        songMood[25] = "sad";
        songDuration[25] = "3:01";

        songNames[26] = "See You Again";
        songArtist[26] = "Wiz Khalifa ft. Charlie Puth";
        songURL[26] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2FSee%20You%20Again%20(feat.%20Charlie%20Puth).mp3?alt=media&token=fcfa3a87-5fd3-458c-b52d-42893a7ac90d";
        songImage[26] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2Fdownload%20(6).jfif?alt=media&token=5c261a39-5dff-47c5-97a2-25c4910ec7a8";
        songMood[26] = "sad";
        songDuration[26] = "3:49";

        songNames[27] = "Someone Like You";
        songArtist[27] = "Adele";
        songURL[27] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2FSomeone%20Like%20You%20-%20Adele%20(Lyrics)%20%F0%9F%8E%B5.mp3?alt=media&token=7c621ce0-44c8-4e94-a8c9-d08b422656a2";
        songImage[27] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2Fdownload%20(7).jfif?alt=media&token=946c4d0e-f5ef-4c76-a048-5df6d8b4e3e0";
        songMood[27] = "sad";
        songDuration[27] = "4:49";

        songNames[28] = "Apologize";
        songArtist[28] = "Timbaland ft. OneRepublic ";
        songURL[28] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2FTimbaland%20-%20Apologize%20ft.%20OneRepublic.mp3?alt=media&token=736e2036-1226-4121-a969-960bfe644d92";
        songImage[28] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2Fdownload%20(8).jfif?alt=media&token=85e2de32-4cdb-4065-b06a-55c99dd5b2b7";
        songMood[28] = "sad";
        songDuration[28] = "3:08";

        songNames[29] = "Unsteady";
        songArtist[29] = "X Ambassadors";
        songURL[29] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2FX%20Ambassadors%20-%20Unsteady.mp3?alt=media&token=4b644f4f-d6e4-41bb-afe6-028e074ebbfe";
        songImage[29] = "https://firebasestorage.googleapis.com/v0/b/musicrecommendation-a57f0.appspot.com/o/sad%20Songs%2Fdownload%20(9).jfif?alt=media&token=282ea7af-7592-49f1-925a-e18e36f63d44";
        songMood[29] = "sad";
        songDuration[29] = "3:26";


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

    public String getSongDuration(int i) {
        songInitialize();
        return songDuration[i];
    }

    public String getPlaylistName(int i){
        songInitialize();
        if(i == 1)
            return "Angry Playlist";
        else if(i == 2)
            return "Happy Playlist";
        else if(i == 3)
            return "Sad Playlist";
        else if(i == 4)
            return "Neutral Playlist";
        return "what";
    }

    public int searchForSong(CharSequence search){
        boolean count = false;
        int songIndex = 0;
        for(int i = 0; i < songNames.length; i++)
        {
            if(songNames[i].equals(search))
            {
                count = true;
                songIndex = i;
                break;
            }
        }
        if(count)
        {
            return songIndex;
        }
        else
        {
            Log.d("myTag", "Could not get the index of the song.");
        }
        return 0;
    }

}

