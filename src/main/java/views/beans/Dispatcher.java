package views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.daos.DaoFactory;
import models.daos.jpa.DaoJpaFactory;
import models.utils.Studies;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/viewsJsp/";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DaoFactory.setFactory(new DaoJpaFactory());
		String action = request.getPathInfo().substring(1);

		String view;
		switch (action) {
		case "themes":
			ThemesView themesView = new ThemesView();
			request.setAttribute(action, themesView);
			view = action;
			break;
		case "addTheme":
			AddThemeView addThemeView = new AddThemeView();
			request.setAttribute(action, addThemeView);
			view = action;
			break;
		case "deleteTheme":
			DeleteThemeView deleteThemeView = new DeleteThemeView();
			deleteThemeView.setId(Integer.parseInt(request.getParameter("id")));
			deleteThemeView.update();
			request.setAttribute(action, deleteThemeView);
			view = action;
			break;
		case "vote":
			VoteView voteView = new VoteView();
			voteView.setId(Integer.parseInt(request.getParameter("id")));
			voteView.update();
			request.setAttribute(action, voteView);
			view = action;
			break;
		case "votes":
			VotesView votesView = new VotesView();
			request.setAttribute(action, votesView);
			view = action;
			break;
		default:
			view = "home";
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DaoFactory.setFactory(new DaoJpaFactory());
		String action = request.getPathInfo().substring(1);
		String view = "home";
		switch (action) {
		case "themes":
			ThemesView themesView = new ThemesView();
			request.setAttribute(action, themesView);
			view = action;
			break;
		case "addTheme":
			AddThemeView addThemeView = new AddThemeView();
			addThemeView.setName(request.getParameter("name"));
			addThemeView.setQuestion(request.getParameter("question"));
			request.setAttribute(action, addThemeView);
			view = addThemeView.process();
			break;
		case "deleteTheme":
			DeleteThemeView deleteThemeView = new DeleteThemeView();
			deleteThemeView.setId(Integer.valueOf(request.getParameter("id")));
			deleteThemeView.setAuth(request.getParameter("auth"));
			request.setAttribute(action, deleteThemeView);
			view = deleteThemeView.process();
			break;
		case "vote":
			VoteView voteView = new VoteView();
			voteView.setIp(this.getRemoteAddr(request));
			voteView.setRating(Double.valueOf(request.getParameter("rating")));
			voteView.setStudies(Studies.valueOf(request.getParameter("studies")));
			voteView.setId(Integer.valueOf(request.getParameter("id")));
			voteView.update();
			request.setAttribute(action, voteView);
			view = voteView.process();
			break;
		case "votes":
			VotesView votesView = new VotesView();
			request.setAttribute(action, votesView);
			view = action;
			break;
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);
	}
	
	private String getRemoteAddr(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
		    ipAddress = request.getRemoteAddr();
		}
		return ipAddress;
	}

}
