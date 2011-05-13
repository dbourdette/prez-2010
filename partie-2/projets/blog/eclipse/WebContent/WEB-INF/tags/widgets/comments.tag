<%@ tag body-content="empty" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<%@ taglib tagdir="/WEB-INF/tags/widget" prefix="widget"%>

<%@ attribute name="post" required="true" rtexprvalue="true" type="java.lang.Object" description="The post to display" %>

<div id="comments" class="comments">
	<h4>${post.commentCount} commentaires:</h4>
	<div id="Blog1_comments-block-wrapper">
		<dl id="comments-block" class="avatar-comment-indent">
			<widget:comment />
		</dl>
	</div>
	<div class="comment-form">
		<a name="comment-form"></a>
		<h4 id="comment-post-message">Ajouter un commentaire</h4>
		<form action="/${post.slug}/comments" method="post">
			<fieldset>
				<textarea rows="10" cols="65" name="text"></textarea>
				<input type="submit" value="Envoyer" />
			</fieldset>
		</form>
	</div>
</div>