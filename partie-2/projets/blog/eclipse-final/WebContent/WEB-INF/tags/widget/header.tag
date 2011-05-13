<%@ tag body-content="empty" pageEncoding="UTF-8" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="header-wrapper">
	<div id="top_rss"><a href="/rss"><img alt="rss" src="/static/images/button_rss.png"></a></div>
	<div id="menu">
		<div id="mainmenu">
			<ul>
			   <li class="first current_page_item"><a title="Home" href="/">Home</a></li>
			   	<sec:authorize access="isAuthenticated()">
					<li class="current_page_item"><a title="Logout" href="/logout">Logout</a></li>
				</sec:authorize>
			</ul>
		</div>
	</div>
	<div class="header section" id="header">
		<div class="widget Header" id="Header1">
			<div id="header-inner">
				<div class="titlewrapper">
					<h1 class="title"><a href="/">Titre blog</a></h1>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="twitter"><a href="http://twitter.com/twitterid"><img alt="twitter" src="/static/images/button_twitter.png"></a></div>
<div id="board">
	<div id="twitter_box">
		<ul id="twitter_update_list">Suivez moi sur twitter :)</ul>
	</div>
	<div id="main_search">
		<form action="/recherche" id="searchform_top" method="get">
			<div><input id="searchform_top_text" name="query" onclick="this.value=&quot;&quot;;" type="text" value="Rechercher..."> <input id="gosearch" src="/static/images/button_go.gif" type="image"></div>
		</form>
	</div>
</div>