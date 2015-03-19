package views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.daos.DaoFactory;
import models.daos.jpa.DaoJpaFactory;

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

}
