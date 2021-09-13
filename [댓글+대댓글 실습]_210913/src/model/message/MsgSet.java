package model.message;

import java.util.ArrayList;

import model.reply.ReplyVO;

public class MsgSet {
	
	private MessageVO msg = new MessageVO();
	private	ArrayList<ReplyVO> reply_List = new ArrayList<ReplyVO>();
	
	public MessageVO getMsg() {
		return msg;
	}
	public void setMsg(MessageVO msg) {
		this.msg = msg;
	}
	public ArrayList<ReplyVO> getReply_List() {
		return reply_List;
	}
	public void setReply_List(ArrayList<ReplyVO> reply_List) {
		this.reply_List = reply_List;
	}
	@Override
	public String toString() {
		return "MsgSet [msg=" + msg + ", reply_List=" + reply_List + "]";
	}
	
	
	
}
