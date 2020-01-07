package www.project.bean;

import java.time.LocalDate;

public class Messages {

	private int sender;
	private int receiver;
	private String msg;
	private LocalDate timestamp;

	public Messages(int sender, int receiver, String msg, LocalDate timestamp) {
		this.sender = sender;
		this.receiver = receiver;
		this.msg = msg;
		this.timestamp = timestamp;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
}
