<%@ tag body-content="empty" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>

<%@ attribute name="post" required="true" rtexprvalue="true" type="java.lang.Object" description="The post to display" %>

<div class="date-outer">
	<h2 class="date-header"><span><fmt:formatDate value="${post.date}" pattern="EEEE dd MMMM yyyy" /></span></h2>
	<div class="date-posts">
		<div class="post-outer">
			<div class="post hentry uncustomized-post-template">
				<h3 class="post-title entry-title"><a href="/${post.slug}">${fn:escapeXml(post.title)}</a></h3>
				<div class="post-header"><div class="post-header-line-1"></div></div>
				<div class="post-body entry-content">
					${fn:escapeXml(post.text)}
					<div style="clear: both;"></div>
				</div>
				<div class="post-footer">
					<div class="post-footer-line post-footer-line-1">
						<span class="post-author vcard">
							Posté par <span class="fn">${fn:escapeXml(post.author)}</span>
						</span>
						<span class="post-timestamp"> à <fmt:formatDate value="${post.date}" pattern="H:mm" />
						</span>
						<c:if test="${not (post.commentCount eq 0)}">
							<span class="post-comment-link">
								<a class="comment-link" href="" onclick="">${post.commentCount} commentaires</a>
							</span>
						</c:if>
					<div class="post-share-buttons"></div>
					</div>
					<div class="post-footer-line post-footer-line-2">
						<span class="post-labels"> Tags:
							<c:forEach var="tag" items="${post.tags}">
								<a href="" rel="tag">${tag}</a>
							</c:forEach>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>