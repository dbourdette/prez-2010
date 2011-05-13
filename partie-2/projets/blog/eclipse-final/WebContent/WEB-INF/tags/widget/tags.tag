<%@ tag body-content="empty" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>

<div class="widget Label" id="Label1">
	<h2>Tags</h2>
	<div class="widget-content list-label-widget-content">
		<ul>
			<c:forEach var="tag" items="${tags}" end="5">
		   		<li><a dir="ltr" href="/recherche?tag=${fn:escapeXml(tag.name)}">${fn:escapeXml(tag.name)}</a> <span dir="ltr">(${tag.count})</span></li>
		   	</c:forEach>
		</ul>
		<div class="clear"></div>
	</div>
</div>