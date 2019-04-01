package sopra.formation.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.formation.model.Civilite;
import sopra.formation.model.Formateur;
import sopra.formation.model.Personne;
import sopra.formation.repository.IPersonneRepository;

@WebServlet(urlPatterns = "/formateur", loadOnStartup = 1)
public class FormateurController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClassPathXmlApplicationContext context;
	private IPersonneRepository personneRepo;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page") != null ? request.getParameter("page") : "list";

		if (page.contentEquals("list")) {
			list(request, response);
		} else if (page.contentEquals("add")) {
			add(request, response);
		} else if (page.contentEquals("edit")) {
			edit(request, response);
		} else if (page.contentEquals("save")) {
			save(request, response);
		} else if (page.contentEquals("remove")) {
			remove(request, response);
		} else if (page.contentEquals("cancel")) {
			cancel(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.context = (ClassPathXmlApplicationContext) config.getServletContext().getAttribute("spring");
		this.personneRepo = this.context.getBean(IPersonneRepository.class);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Formateur> formateurs = this.personneRepo.findAllFormateur();

		request.setAttribute("formateurs", formateurs);

		ServletContext sc = request.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/views/formateur/list.jsp");
		rd.forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("civilites", Civilite.values());
		
		request.getRequestDispatcher("/WEB-INF/views/formateur/form.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));

		Optional<Personne> opt = this.personneRepo.findById(id);

		Formateur formateur = null;
		if (opt.isPresent()) {
			formateur = (Formateur) opt.get();
		}

		request.setAttribute("civilites", Civilite.values());
		request.setAttribute("formateur", formateur);

		request.getRequestDispatcher("/WEB-INF/views/formateur/form.jsp").forward(request, response);
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
