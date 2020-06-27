package com.example.rsspratice;

public class Feed_Item {

  // Variables for each of the wigets in the Feed_Item_Layout
  private String FirstNameFeed;
  private String LastNameFeed;
  private String StudentInfoFeed;
  private String StudentGradeFeed;
  private String StudentProfilePicture;


  // Building our custom Constructer.
  public Feed_Item() {

  }


  // Add in a few arguments to the constructor.
  public Feed_Item(String FirstNameConstruct, String LastNameConstrust, String StudentInfoConstrust, String StudentGradeConstrust, String StudentPictureConstrust  )
  {

    // This is equaling all the variables in this class to the consturcters we are passing through.
    this.FirstNameFeed = FirstNameConstruct;
    this.LastNameFeed = LastNameConstrust;
    this.StudentInfoFeed = StudentInfoConstrust;
    this.StudentGradeFeed = StudentGradeConstrust;
    this.StudentProfilePicture = StudentPictureConstrust;
  }


  /*******************************************
  *           Getters & Setters              *
  *                                          *
  *******************************************/


  /*****               Getters                  ******/


  public String getFirstNameFeed() { return FirstNameFeed;}

  public String getLastNameFeed() { return LastNameFeed; }

  public String getStudentInfoFeed() { return StudentInfoFeed; }

  public String getStudentGradeFeed() { return StudentGradeFeed; }

  public String getStudentPicture() { return StudentProfilePicture; }

  /*****               Setters                  ******/

  public void setFirstNameFeed(String FirstNameFeed) {this.FirstNameFeed = FirstNameFeed;}

  public void setLastNameFeed(String lastNameFeed) { this.LastNameFeed = lastNameFeed;  }

  public void setStudentInfoFeed(String studentInfoFeed) { this.StudentInfoFeed = studentInfoFeed; }

  public void setStudentGradeFeed(String studentGradeFeed) { this.StudentGradeFeed = studentGradeFeed; }

 public void setStudentPicture(String StudentPicture) { this.StudentProfilePicture = StudentPicture; }



} // End of Class
