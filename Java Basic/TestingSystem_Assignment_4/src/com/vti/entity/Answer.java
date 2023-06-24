package com.vti.entity;

public class Answer {
	private byte id;
	private String content;
	private Question questionID;
	private boolean isCorrect;
	
	public Answer() {
		
	}

	public Answer(byte id, String content, Question questionID, boolean isCorrect) {
		this.id = id;
		this.content = content;
		this.questionID = questionID;
		this.isCorrect = isCorrect;
	}

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Question getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Question questionID) {
		this.questionID = questionID;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}
