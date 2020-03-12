package net.chrisrichardson.eventstore.javaexamples.banking.commonauth.model;

/**
 * Created by Main on 17.02.2016.
 */
public class SuccessResponse {

  private String message;

  public SuccessResponse() {
  }

  public SuccessResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
