package com.example.semesterprojectm_10_assignment;

public class Feed_Item {

  private String FirstNameFeed;
  private String DateFeed;
  private String Char_Post_Feed;
  private String Char_PictureFeed;

  // Building custom Constructer.
  public Feed_Item() {

  }



  public Feed_Item(String FirstName_Construct, String Date_Construct, String Char_Post_Construct, String CharPicture_Construct)
  {

    // This is equaling all the variables in this class to the consturcters we are passing through.
    this.FirstNameFeed = FirstName_Construct;
    this.DateFeed = Date_Construct;
    this.Char_Post_Feed = Char_Post_Construct;
    this.Char_PictureFeed = CharPicture_Construct;
  }

  /********************************************
   *           Getters                        *
   *                                          *
   *******************************************/

  public String getFirstNameFeed() { return FirstNameFeed; }


  public String getDateFeed() { return DateFeed; }


  public String getChar_Post_Feed() { return Char_Post_Feed; }


  public String getChar_PictureFeed() { return Char_PictureFeed; }


  /*******************************************
   *           Setters                        *
   *                                          *
   *******************************************/

  public void setFirstNameFeed(String firstNameFeed) { FirstNameFeed = firstNameFeed; }

  public void setDateFeed(String dateFeed) { DateFeed = dateFeed; }

  public void setChar_Post_Feed(String char_Post_Feed) { Char_Post_Feed = char_Post_Feed; }

  public void setChar_PictureFeed(String char_PictureFeed) { Char_PictureFeed = char_PictureFeed; }
}
