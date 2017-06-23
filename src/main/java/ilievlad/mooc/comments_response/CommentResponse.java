package ilievlad.mooc.comments_response;

import ilievlad.mooc.comments.model.Comments;

/**
 * Created by Vlad on 23/06/2017.
 */
public class CommentResponse {

    private String username;
    private String type;
    private Comments comments;

    public CommentResponse() {

    }

    public CommentResponse(String username, String type, Comments comments) {
        this.username = username;
        this.type = type;
        this.comments = comments;
    }

    public CommentResponse(String username, String type) {
        this.username = username;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }
}
