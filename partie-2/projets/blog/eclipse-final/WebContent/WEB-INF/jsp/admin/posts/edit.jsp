<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags/widget" prefix="widget"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html dir="ltr" xmlns="http://www.w3.org/1999/xhtml" >
	<head>
		<widget:head />
		<style type="text/css">
			input {
				float:right;
			}
			
			input.submit {
				float:none;
			}
			
			textarea {
				float:right;
			}
			
			p {
				clear:both;
			}
			
			p.center {
				text-align: center;
			}
			
			.error {
				color: red;
			}
			
			.inputError {
				border-color: red;
			}
		</style>
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
								<a rel="tag" href="/admin/posts">Tous les billets</a>
								<br/><br/>
								<form:form commandName="post" action="editer">
									<form:errors />
									<fieldset>
										<form:hidden path="id" />
										<p>
											<label for="date">Date</label>
											<form:input id="path" path="date" cssErrorClass="inputError"/>
											<form:errors path="date" cssClass="error" />
										</p>
										<p>
											<label for="author">Author</label>
											<form:input id="author" path="author" cssErrorClass="inputError"/>
											<form:errors path="author" cssClass="error" />
										</p>
										<p>
											<label for="slug">Slug</label>
											<form:errors path="slug" cssClass="error" cssErrorClass="inputError"/>
											<form:input id="slug" path="slug" size="80"/>
										</p>
										<p>
											<label for="title">Titre</label>
											<form:errors path="title" cssClass="error" cssErrorClass="inputError"/>
											<form:input id="title" path="title" size="80"/>
										</p>
										<p>
											<label for="text">Texte</label>
											<form:errors path="text" cssClass="error" cssErrorClass="inputError"/>
											<form:textarea id="text" path="text" cols="60" rows="10"  />
										</p>
										<p>
											<label for="tags">Tags</label>
											<form:errors path="tags" cssClass="error" cssErrorClass="inputError"/>
											<form:input id="tags" path="tags" size="40"/>
										</p>
										<p class="center">
											<input type="submit" class="submit" value="Sauver" />
										</p>
									</fieldset>
								</form:form>
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