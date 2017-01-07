package com.coremedia.coredining.handlers;

import com.coremedia.cap.common.IdHelper;
import com.coremedia.cap.content.Content;
import com.coremedia.cap.content.ContentRepository;
import com.coremedia.coredining.contentbeans.Linkable;
import com.coremedia.coredining.contentbeans.LinkableImpl;
import com.coremedia.coredining.contentbeans.Site;
import com.coremedia.coredining.contentbeans.Topic;
import com.coremedia.objectserver.beans.ContentBeanFactory;
import com.coremedia.objectserver.web.HandlerHelper;
import com.coremedia.objectserver.web.links.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RequestMapping
@Link
public class OptimizedContentHandler {
  
  private static final String URI_PATTERN = "/cms/{site}/{currentTopicPath:.+}/{id}/{title:.+}.{extension}";
  private static final String EXTENSION_FOR_DEFAULT_VIEW = "html";
  
  // === HANDLER METHODS ===
  
  @RequestMapping(URI_PATTERN)
  public ModelAndView handleContent(@PathVariable("id") LinkableImpl self,
                                    @PathVariable("site") String siteSegment,
                                    @PathVariable("currentTopicPath") List<String> currentTopicPath,
                                    @PathVariable("title") String title,
                                    @PathVariable("extension") String extension) {
    
    // (1)	resolve the current topic
    Site site = resolveCurrentSite(siteSegment);
    Topic currentTopic = resolveCurrentTopic(site, currentTopicPath);

    // (2)	check if the bean 'self' and the currentTopic are not null.
    if (self==null || currentTopic==null) {
      return HandlerHelper.notFound();
    }

    // (3) 	compute the 'view'
    String view = (EXTENSION_FOR_DEFAULT_VIEW.equals(extension)) ? null : extension;

    // (4)	create a ModelAndView
    ModelAndView modelAndView = HandlerHelper.createModelWithView(self, view);

    // (5)	add the current topic to the ModelAndView;
    modelAndView.addObject(CustomContentHandler.ATTRIBUTE_CURRENT_TOPIC, currentTopic);

    return modelAndView;
  }
  
  @Link(type=LinkableImpl.class, uri=URI_PATTERN)
  public Map<String, Object> buildLink(LinkableImpl target,
                                 String view,
                                 HttpServletRequest request) {
    Map<String, Object> variables;
	Topic currentTopic;
	Site currentSite;
	StringBuilder currentTopicPath;
	int numericalContentId;
	String extension;
	
    // ///////////////////////////////////////////////////////
	// TODO: Your code starts here...
	//
	// (1) 	get current topic from page scoped variables or home topics...
	//	   	You can use the already prepared utility method 'resolveCurrentTopic(Linkable, HttpServletRequest)'.
	//	   	Have a look to this method and see how the page scope variable 'currentTopic' is accessed.
	// (2)  use the current topic from step (1) to find the current site.
    //      Use the already prepared method 'resolveCurrentSite(Topic)' for this task. That method
    //      Have a look at the implementation of that method and compare the code with the content type model 
    //      of Core.Dining.	
	// (3) 	build currentTopicPath
	//		Simply iterate over the pathElements of the current topic and add the titles
	//		of the pathElements as segments to StringBuilder currentTopicPath. 
	//		Keep in mind: the current topic is not included within its pathElements
	//		so you need to add it manually at the end of the currentTopicPath.
	// (4) 	get numerical content id of target.
	//		Use the IdHelper.parseContentId().
	// (5) 	get the title from the target.
	// (6) 	calculate the extension
	//		The extension should be the view parameter. If no view parameter is
	//		provided, use the EXTENSION_FOR_DEFAULT_VIEW (="html") instead.
	// (7)  Finally: create a new HashMap and fill it with the variables, used in the URI pattern.
	//        "site" -> currentSite.getTitle()
    //        "currentTopicPath" -> currentTopicPath.toString()
	//        "id" -> numericalContentId
	//        "title" -> target.getTitle()
	//        "extension" -> extension
	//
	// ///////////////////////////////////////////////////////

    // build and expand the URI and finally encode it.
    return variables;
	
  }
  
   
  // === UTILITY METHODS ===
  
  /**
   * Use this helper method when implementing the method {@code buildLink()}.
   * 
   * The topic in question is the page scoped variable ${currentTopic}, which is
   * accessible as request attribute with name "currentTopic".
   * 
   * In case that the target is a topic, we will return the target itself.
   * In the worst case, the first homeTopic of the linkable is choosen.
   * 
   * @param target
   *          the target attribute of <cm:link>
   * @param request
   *          the request objects, containing all page scope variables.
   * @return the current topic
   */
  protected Topic resolveCurrentTopic(Linkable target, HttpServletRequest request) {
    Topic currentTopic = null;
    if (target instanceof Topic) {
      currentTopic = (Topic) target;
    } else {
      currentTopic = (Topic) request.getAttribute(CustomContentHandler.ATTRIBUTE_CURRENT_TOPIC);
    }
    if (currentTopic==null && !target.getHomeTopic().isEmpty()) {
      currentTopic = target.getHomeTopic().get(0);
    }
    return currentTopic;
  }
  

  /**
   * This helper method resolves the Site object for the given navigation context
   * 'currentTopic'.
   * 
   * 
   * @param currentTopic
   * @return
   */
  protected Site resolveCurrentSite(Topic currentTopic) {
	TopicImpl rootTopic = (TopicImpl) currentTopic.getRootTopic();
	Set<Content> sites = rootTopic.getContent().getReferrersWithDescriptor("Site", "root");
    return (sites.isEmpty()) ? null : (Site) contentBeanFactory.createBeanFor(sites.iterator().next());
  }
  

  /**
   * Use this helper method when implementing the method {@code handleContent()}.
   * 
   * This method tries to look-up the current topic by its URL segments, starting from the configured root topic.
   *
   * @param currentTopicPath
   * @return the current topic if lookup was successful, 
   *         otherwise null.
   */
  protected Topic resolveCurrentTopic(Site site, List<String> currentTopicPath) {
    if (site==null) return null;
    Topic currentTopic = null;
    List<? extends Topic> topics = site.getRoot();

    for (String title : currentTopicPath) {
      currentTopic = getTopicByTitle(title, topics);
      if (currentTopic == null) {
        break; // sorry... the URL is invalid
      }
      topics = currentTopic.getSubTopics();
    }
    return currentTopic;
  }

  protected Site resolveCurrentSite(String segment) {
    for (Site s : getSites()) {
      if (segment.equalsIgnoreCase(s.getTitle())) {
        return s;
      }
    }
    return null;
  }
  
  private Topic getTopicByTitle(String title, List<? extends Topic> topics) {
    for (Topic t : topics) {
      if (title.equals(t.getTitle())) {
        return t;
      }
    }
    return null; // sorry, no topic found...
  }


  /**
   * Returns the list of sites which is found within the given site folder.
   *
   * @return a list of site objects
   */
  protected List<? extends Site> getSites() {
    Content root = getSiteFolder();
    Set<Content> siteDocuments = findSites(root);
    return getContentBeanFactory().createBeansFor(new ArrayList<Content>(siteDocuments));
  }

  /**
   * This method searches the given folder for Site documents.
   * If the given folder contains Site documents, the documents are returned.
   * Otherwise this method will recursively search in the subfolders of these folders.
   *
   * @param folder
   * @return
   */
  private Set<Content> findSites(Content folder) {
    if(folder.getPathArcs().size()>4) {
      // don't go too deep into folder hierarchy
      return Collections.emptySet();
    }
    Set<Content> sites = folder.getChildrenWithType("Site");
    if (sites.isEmpty()) {
      // check sub-folders for site documents...
      sites = new HashSet<Content>();
      for (Content subFolder : folder.getSubfolders()) {
        Set<Content> sitesFoundInSubFolder = findSites(subFolder);
        sites.addAll(sitesFoundInSubFolder);
      }
      return sites;
    }
    else {
      return sites;
    }
  }

  protected Content getSiteFolder() {
    return getContentRepository().getChild(siteFolder);
  }

  // === Configuration ===

  
  public void setContentBeanFactory(ContentBeanFactory contentBeanFactory) {
	  this.contentBeanFactory = contentBeanFactory;
  }
  
  public ContentBeanFactory getContentBeanFactory() {
	  return contentBeanFactory;
  }
  
  public void setContentRepository(ContentRepository contentRepository) {
	  this.contentRepository = contentRepository;
  }
  
  public ContentRepository getContentRepository() {
	  return contentRepository;
  }

  public void setSiteFolder(String siteFolder) {
	  this.siteFolder = siteFolder;
  }
  
  // === Attributes ===
  
  private ContentBeanFactory contentBeanFactory;
  private ContentRepository contentRepository;  
  private String siteFolder = "/Sites/Core.Dining";
  private Topic rootTopic = null;
}