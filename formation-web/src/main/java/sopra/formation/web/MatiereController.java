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

import sopra.formation.model.Matiere;
import sopra.formation.repository.IMatiereRepository;

@WebServlet(urlPatterns = "/matiere", loadOnStartup = 1)
public class MatiereController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClassPathXmlApplicationContext context;
	private IMatiereRepository matiereRepo;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page") != null ? request.getParameter("page") : "list";

		// ETAPE 1 : Analyse de l'URL entrante
		
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
		this.matiereRepo = this.context.getBean(IMatiereRepository.class);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ETAPE 2 : Récuperation des données
		List<Matiere> matieres = this.matiereRepo.findAll();
		
		// ETAPE 3 : Renseigner le Model (le panier de données)
		request.setAttribute("exemple", "ma chaine bidon pour vous montrer le passage d'attribut");
		request.setAttribute("mesMatieres", matieres);
		
		// ETAPE 4 : Forward vers la View (on continue vers la présentation en JSP)
		ServletContext sc = request.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/views/matiere/list.jsp");
		rd.forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/matiere/form.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		
		Optional<Matiere> opt = this.matiereRepo.findById(id);
		
		Matiere matiere = null;
		if(opt.isPresent()) {
			matiere = opt.get();
		} 
		
		request.setAttribute("maMatiere", matiere);
		
		request.getRequestDispatcher("/WEB-INF/views/matiere/form.jsp").forward(request, response);
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
