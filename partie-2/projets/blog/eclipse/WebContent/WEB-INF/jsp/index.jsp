<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<%@ taglib tagdir="/WEB-INF/tags/widget" prefix="widget"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html dir="ltr" xmlns="http://www.w3.org/1999/xhtml" >
	<head>
		<widget:head />
	</head>
	<body>
		<div id="outer-wrapper">
			<div id="wrap2">
				<widget:header />
				<div id="content-wrapper">
					<div id="crosscol-wrapper" style="text-align: center"><div class="crosscol section" id="crosscol"></div></div>
					<div id="body_top">
						<div id="body_end">
						<div id="main-wrapper">
							<div class="main section" id="main">
								<div class="widget Blog" id="Blog1">
									<div class="blog-posts hfeed">
										<c:forEach var="post" items="${posts}">
											<widget:billet post="${post}" />
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
						<div id="sidebar-wrapper">
							<div class="sidebar section" id="sidebar">
								<widget:tags />
								
								<widget:archives />
							</div>
						</div>
						<!-- spacer for skins that want sidebar and main to be the same height-->
						<div class="clear">&nbsp;</div>
						</div>
					</div>
				</div>
				<!-- end content-wrapper -->
				<widget:footer />
			</div>
		</div>
		<!-- end outer-wrapper -->
	</body>
</html>