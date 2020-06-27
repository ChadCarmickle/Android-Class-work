package com.example.finalv2;

import android.util.Log;

public class Feed_Item {

  private String ArtistName;
  private String SongName;
  private String URL;

  private String Artist;
  private String Song_Constructor;


  // custom Constructor.
  public Feed_Item() {

  }

  public Feed_Item(String ArtistName, String SongName, String URL) {
    this.URL = URL;
    this.ArtistName = ArtistName;
    this.SongName = SongName;
  }

  public String getArtistName() {
    return ArtistName;
  }

  public String getSongName() {
    return SongName;
  }

  public String getURL() {
    return URL;
  }

  public void setArtistName(String artistName) {
    ArtistName = artistName;
  }

  public void setSongName(String songName) {
    SongName = songName;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }
}


