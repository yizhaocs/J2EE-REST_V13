package org.koushik.javabrains.messenger13.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger13.model.Comment;
import org.koushik.javabrains.messenger13.service.CommentService;

@Path("/") // Note: The class level @Path annotation is optional for sub resources.
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	private CommentService commentService = new CommentService();

	// http://localhost:8080/messenger12/webapi/messages/2/comments
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}

	// http://localhost:8080/messenger12/webapi/messages/2/comments
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}

	// http://localhost:8080/messenger12/webapi/messages/2/comments/1
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long id, Comment comment) {
		comment.setId(id);
		return commentService.updateComment(messageId, comment);
	}

	// http://localhost:8080/messenger12/webapi/messages/2/comments/1
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		commentService.removeComment(messageId, commentId);
	}

	// http://localhost:8080/messenger12/webapi/messages/2/comments/1
	@GET
	@Path("/{commentId}")
	public Comment getMessage(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return commentService.getComment(messageId, commentId);
	}
	
	
//	// http://localhost:8080/messenger12/webapi/messages/2/comments
//	// http://localhost:8080/messenger12/webapi/messages/3/comments
//	@GET
//	public String test(){
//		return "new sub resource";
//	}
	
	
	// http://localhost:8080/messenger12/webapi/messages/2/comments/12
//	@GET
//	@Path("/{commentId}")
//	public String test2(@PathParam("messageId") long messageID, @PathParam("commentId") long commentID){
//		return "Method to return commment ID: " + commentID + " for message " + messageID;
//	}
	
//	// http://localhost:8080/messenger12/webapi/messages/2/comments/12
//	@GET
//	@Path("/{commentId}")
//	public String test2(@PathParam("commentId") long commentID){
//		return "Method to return commment ID: " + commentID;
//	}
}
