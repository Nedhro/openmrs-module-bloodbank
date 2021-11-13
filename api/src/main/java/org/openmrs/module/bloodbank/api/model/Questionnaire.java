package org.openmrs.module.bloodbank.api.model;

import org.openmrs.module.bloodbank.api.model.enums.Gender;

public class Questionnaire extends BaseModel {

  private Integer qid;

  private String question;

  private Gender concernFor;

  public Questionnaire() {}

  public Questionnaire(Integer qid, String question, Gender concernFor) {
    this.qid = qid;
    this.question = question;
    this.concernFor = concernFor;
  }

  public Integer getQid() {
    return qid;
  }

  public void setQid(Integer qid) {
    this.qid = qid;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public Gender getConcernFor() {
    return concernFor;
  }

  public void setConcernFor(Gender concernFor) {
    this.concernFor = concernFor;
  }
}
