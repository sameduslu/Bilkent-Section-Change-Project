package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity;

public class ForumRequestApproval {
    private String forumRequestId;
    private String acceptorId;

    public String getForumRequestId() {
        return forumRequestId;
    }

    public void setForumRequestId(String forumRequestId) {
        this.forumRequestId = forumRequestId;
    }

    public String getAcceptorId() {
        return acceptorId;
    }

    public void setAcceptorId(String acceptorId) {
        this.acceptorId = acceptorId;
    }
}
