package tr.edu.bilkent.cs.cs102.registerplusplus.server.entity;

public class ForumRequestApproval {
    private ForumRequest forumRequest;
    private String acceptorId;

    public ForumRequestApproval(ForumRequest forumRequest, String acceptorId) {
        this.forumRequest = forumRequest;
        this.acceptorId = acceptorId;
    }

    public ForumRequest getForumRequest() {
        return forumRequest;
    }

    public void setForumRequest(ForumRequest forumRequest) {
        this.forumRequest = forumRequest;
    }

    public String getAcceptorId() {
        return acceptorId;
    }

    public void setAcceptorId(String acceptorId) {
        this.acceptorId = acceptorId;
    }
}
