<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

		<!-- Search Bar -->
		<form action="${path }/stock/search?query=${param.query }">
			<div class="row uniform">
				<div class="9u 12u$(small)">
					<input type="text" name="query" placeholder="Code or Name" />
				</div>
				<div class="3u$ 12u$(small)">
					<input type="submit" value="Search" class="fit" />
				</div>
			</div>
		</form>