package com.coremedia.coredining.studio.rest;

import com.coremedia.cap.common.CapConnection;
import com.coremedia.cap.common.IdHelper;
import com.coremedia.cap.content.Content;
import org.springframework.beans.factory.annotation.Required;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Produces(MediaType.APPLICATION_JSON)
@Path("referrers")
public class ReferrersResource {

  private CapConnection connection;

  @Required
  public void setConnection(CapConnection connection) {
    this.connection = connection;
  }

  @GET
  @Path("/{id:\\d+}/all")
  public List<Content> getAllReferrers(@PathParam("id") String id) {
    List<Content> result = new ArrayList<Content>();
    Content content = connection.getContentRepository().getContent(id);
    if (content!=null) {
      result.addAll(content.getReferrers());
    }
    return new ArrayList<Content>(result);
  }
}
