package views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/viewsJsp/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getPathInfo().substring(1);

        String view;
        switch (action) {
        case "themes":
            ThemesView themesView = new ThemesView();
            request.setAttribute(action, themesView);
            view = action;
            break;
        case "addTheme":
            AddThemeView addThemeView= new AddThemeView();
            request.setAttribute(action, addThemeView);
            view = action;
            break;
        case "votesView":
            VotesView votesView= new VotesView();
            request.setAttribute(action, votesView);
            view = action;
            break;
        default:
            view = "home";
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo().substring(1);
        String view = "home";
//        switch (action) {
//        case "persona":
//            Persona persona = new Persona();
//            persona.setId(Integer.valueOf(request.getParameter("id")));
//            persona.setNombre(request.getParameter("nombre"));
//            persona.setRol(request.getParameter("rol"));
//            PersonaView personaView = new PersonaView();
//            personaView.setPersona(persona);
//            request.setAttribute(action, personaView);
//            view = personaView.process();
//            break;
//        case "rol":
//            RolView rolView = new RolView();
//            rolView.setRol(request.getParameter("rol"));
//            request.setAttribute(action, rolView);
//            view = rolView.process();
//            break;
//        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

}
