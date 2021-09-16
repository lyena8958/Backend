package model.message;

import java.util.ArrayList;

import model.reply.ReplyVO;

public class MsgSet {
	
	private MessageVO msg = new MessageVO();
	private ArrayList<ReplyVO> replyList = new ArrayList<ReplyVO>();
	
	public MessageVO getMsg() {
		return msg;
	}
	public void setMsg(MessageVO msg) {
		this.msg = msg;
	}
	public ArrayList<ReplyVO> getReplyList() {
		return replyList;
	}
	public void setReplyList(ArrayList<ReplyVO> replyList) {
		this.replyList = replyList;
	}
	
	
	
	
}
