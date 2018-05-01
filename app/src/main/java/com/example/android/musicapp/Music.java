package com.example.android.musicapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Music implements Parcelable {
    private String mSongTitle;
    private String mArtistName;
    private int mAlbumImage;
    private int mFile;


    public Music(String songName, String ArtistName, int Albumart, int songFile) {
        mSongTitle = songName;
        mArtistName = ArtistName;
        mAlbumImage = Albumart;
        mFile = songFile;
    }


    protected Music(Parcel in) {
        mSongTitle = in.readString();
        mArtistName = in.readString();
        mAlbumImage = in.readInt();
        mFile = in.readInt();
    }

    public static final Creator<Music> CREATOR = new Creator<Music>() {
        @Override
        public Music createFromParcel(Parcel in) {
            return new Music(in);
        }

        @Override
        public Music[] newArray(int size) {
            return new Music[size];
        }
    };

    public String getsongName() {
        return mSongTitle;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public int getAlbumart() {
        return mAlbumImage;
    }

    public int songFile() {
        return mFile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSongTitle);
        dest.writeString(mArtistName);
        dest.writeInt(mAlbumImage);
        dest.writeInt(mFile);
    }
}
