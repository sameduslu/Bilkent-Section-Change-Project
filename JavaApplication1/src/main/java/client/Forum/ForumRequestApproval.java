package client.Forum;

public class ForumRequestApproval {
    private String forumRequestId;
    private String acceptorId;

    public ForumRequestApproval(String forumRequestId, String acceptorId) {
        this.forumRequestId = forumRequestId;
        this.acceptorId = acceptorId;
    }

    public String getForumRequestId() {
        return forumRequestId;
    }

    public String getAcceptorId() {
        return acceptorId;
    }
}
