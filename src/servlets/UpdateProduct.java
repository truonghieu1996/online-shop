package servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ImplCategory;
import dao.ImplProduct;
import models.Category;
import models.Product;

@WebServlet("/update_product")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SAVE_DIRECTORY = "resource/upload";

	public UpdateProduct() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int idProduct = Integer.valueOf(request.getParameter("id"));
		ImplCategory category = new ImplCategory();
		List<Category> list = null;
		try {
			list = category.getListCategory();
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", e.toString());
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/error.jsp").forward(request,
					response);
		}
		request.setAttribute("listCategory", list);
		ImplProduct implProduct = new ImplProduct();
		Product product = null;
		try {
			product = implProduct.getProductById(idProduct);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", e.toString());
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/error.jsp").forward(request,
					response);
		}
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/page/admin/update_product.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String fileName = "";
		int idProduct = Integer.valueOf(request.getParameter("idProduct"));
		int idCategory = Integer.valueOf(request.getParameter("idCategory"));
		String nameProduct = request.getParameter("nameProduct");
		double priceProduct = Double.valueOf(request.getParameter("priceProduct"));
		String description = request.getParameter("descriptionProduct");
		int amount = Integer.valueOf(request.getParameter("amountProduct"));
		ImplProduct implProduct = new ImplProduct();
		try {
			// Gets absolute path to root directory of web app.
			String appPath = request.getServletContext().getRealPath("");
			appPath = appPath.replace('\\', '/');

			// The directory to save uploaded file
			String fullSavePath = null;
			if (appPath.endsWith("/")) {
				fullSavePath = appPath + SAVE_DIRECTORY;
			} else {
				fullSavePath = appPath + "/" + SAVE_DIRECTORY;
			}

			// Creates the save directory if it does not exists
			File fileSaveDir = new File(fullSavePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			// Part list (multi files).
			for (Part part : request.getParts()) {
				if (extractFileName(part) != null) {
					fileName = extractFileName(part);
					System.out.println(fileName);
					if (fileName.length() > 0 && idCategory != 0 && !"".equals(nameProduct) && priceProduct != 0
							&& !"".equals(description)) {
						String filePath = fullSavePath + File.separator + fileName;
						System.out.println("Write attachment to file: " + filePath);
						try {
							if (implProduct.Update(idProduct, idCategory, nameProduct, priceProduct, description,
									fileName, amount) > 0) {
								part.write(filePath);
								response.sendRedirect("mn_product");
							}
						} catch (SQLException e) {
							e.printStackTrace();
							request.setAttribute("message", e.toString());
							request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/error.jsp")
									.forward(request, response);
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", e.toString());
			request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/error.jsp").forward(request,
					response);
		}
		if ("".equals(fileName)) {
			try {
				if (implProduct.UpdateOutFile(idProduct, idCategory, nameProduct, priceProduct, description,
						amount) > 0) {
					response.sendRedirect("mn_product");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("message", e.toString());
				request.getServletContext().getRequestDispatcher("/WEB-INF/page/admin/error.jsp").forward(request,
						response);
			}
		}
	}

	public String extractFileName(Part part) {

		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
				clientFileName = clientFileName.replace("\\", "/");
				int i = clientFileName.lastIndexOf('/');
				return clientFileName.substring(i + 1);
			}
		}
		return null;
	}
}
