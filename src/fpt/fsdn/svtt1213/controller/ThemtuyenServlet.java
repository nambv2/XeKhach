package fpt.fsdn.svtt1213.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.fsdn.svtt1213.model.bean.TuyenDuong;
import fpt.fsdn.svtt1213.model.bo.DanhsachtuyenduongBO;
import fpt.fsdn.svtt1213.model.bo.ThemtuyenBO;
import fpt.fsdn.svtt1213.model.dao.ThemtuyenDAO;
import fpt.fsdn.svtt1213.utility.Security;

public class ThemtuyenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String maTuyen = request.getParameter("maTuyen");
		String noiDi = request.getParameter("noiDi");
		String noiDen = request.getParameter("noiDen");

		if (maTuyen != null && noiDi != null && noiDen != null) {
			ThemtuyenBO themtuyenBO = new ThemtuyenBO();
			ThemtuyenDAO themtuyenDAO = new ThemtuyenDAO();
			maTuyen = maTuyen.trim();
			noiDi = noiDi.trim();
			noiDen = noiDen.trim();
			String thongbao1 = "kohople";
			String thongbao2 = "kohople";
			String thongbao3 = "kohople";
			String thongbao4 = "trungten";
			String thongbao5 = "trungten";
			String thongbao6 = "trungten";
			if (noiDi.trim().equals(noiDen.trim())) {
				request.setAttribute("thongbao6", thongbao6);
				request.setAttribute("maTuyen",
						Security.stringToHTMLString(maTuyen));
				request.setAttribute("noiDen",
						Security.stringToHTMLString(noiDen));
				request.setAttribute("noiDi",
						Security.stringToHTMLString(noiDi));
				RequestDispatcher rd = request
						.getRequestDispatcher("admin/themtuyen.jsp");
				rd.forward(request, response);
			} else {
				if (themtuyenBO.kTraMaTuyen(maTuyen) == false) {
					if (themtuyenBO.kTraNoiDiDen(noiDi.trim(), noiDen.trim())) {
						request.setAttribute("thongbao5", thongbao5);
						request.setAttribute("maTuyen",
								Security.stringToHTMLString(maTuyen));
						request.setAttribute("noiDen",
								Security.stringToHTMLString(noiDen));
						request.setAttribute("noiDi",
								Security.stringToHTMLString(noiDi));
						RequestDispatcher rd = request
								.getRequestDispatcher("admin/themtuyen.jsp");
						rd.forward(request, response);
					} else {
						if (themtuyenBO.validateId(maTuyen) == true) {
							if (themtuyenBO.validateNoiDiDen(noiDi) == true) {
								if (themtuyenBO.validateNoiDiDen(noiDen) == true) {
									TuyenDuong td = new TuyenDuong();
									td.setMaTuyen(maTuyen);
									td.setNoiDi(noiDi);
									td.setNoiDen(noiDen);
									themtuyenBO.themTuyen(td);

									ArrayList<TuyenDuong> data = new ArrayList<TuyenDuong>();
									DanhsachtuyenduongBO danhsachtuyenduongBO = new DanhsachtuyenduongBO();
									data = danhsachtuyenduongBO.getDatabase();
									request.setAttribute("data", data);
									RequestDispatcher rd = request
											.getRequestDispatcher("admin/danhsachtuyen.jsp");
									rd.forward(request, response);
								} else {
									request.setAttribute("maTuyen", Security
											.stringToHTMLString(maTuyen));
									request.setAttribute("noiDen",
											Security.stringToHTMLString(noiDen));
									request.setAttribute("noiDi",
											Security.stringToHTMLString(noiDi));
									request.setAttribute("thongbao3", thongbao1);
									RequestDispatcher rd = request
											.getRequestDispatcher("admin/themtuyen.jsp");
									rd.forward(request, response);
								}
							} else {
								if ((themtuyenBO.validateNoiDiDen(noiDen) == false)) {
									request.setAttribute("maTuyen", Security
											.stringToHTMLString(maTuyen));
									request.setAttribute("noiDen",
											Security.stringToHTMLString(noiDen));
									request.setAttribute("noiDi",
											Security.stringToHTMLString(noiDi));
									request.setAttribute("thongbao2", thongbao2);
									request.setAttribute("thongbao3", thongbao3);
									RequestDispatcher rd = request
											.getRequestDispatcher("admin/themtuyen.jsp");
									rd.forward(request, response);
								} else {
									request.setAttribute("maTuyen", Security
											.stringToHTMLString(maTuyen));
									request.setAttribute("noiDen",
											Security.stringToHTMLString(noiDen));
									request.setAttribute("noiDi",
											Security.stringToHTMLString(noiDi));
									request.setAttribute("thongbao2", thongbao2);
									RequestDispatcher rd = request
											.getRequestDispatcher("admin/themtuyen.jsp");
									rd.forward(request, response);
								}

							}

						}

						else {
							if ((themtuyenBO.validateNoiDiDen(noiDi) == false)
									&& (themtuyenBO.validateNoiDiDen(noiDen) == false)) {
								request.setAttribute("maTuyen",
										Security.stringToHTMLString(maTuyen));
								request.setAttribute("noiDen",
										Security.stringToHTMLString(noiDen));
								request.setAttribute("noiDi",
										Security.stringToHTMLString(noiDi));
								request.setAttribute("thongbao3", thongbao3);
								request.setAttribute("thongbao2", thongbao2);
								request.setAttribute("thongbao1", thongbao1);
								RequestDispatcher rd = request
										.getRequestDispatcher("admin/themtuyen.jsp");
								rd.forward(request, response);
							} else if ((themtuyenBO.validateNoiDiDen(noiDen) == false)) {
								request.setAttribute("maTuyen",
										Security.stringToHTMLString(maTuyen));
								request.setAttribute("noiDen",
										Security.stringToHTMLString(noiDen));
								request.setAttribute("noiDi",
										Security.stringToHTMLString(noiDi));
								request.setAttribute("thongbao3", thongbao3);
								request.setAttribute("thongbao1", thongbao1);
								RequestDispatcher rd = request
										.getRequestDispatcher("admin/themtuyen.jsp");
								rd.forward(request, response);
							} else {
								request.setAttribute("thongbao1", thongbao1);
								request.setAttribute("maTuyen",
										Security.stringToHTMLString(maTuyen));
								request.setAttribute("noiDen",
										Security.stringToHTMLString(noiDen));
								request.setAttribute("noiDi",
										Security.stringToHTMLString(noiDi));
								RequestDispatcher rd = request
										.getRequestDispatcher("admin/themtuyen.jsp");
								rd.forward(request, response);
							}
						}
					}

				} else {
					request.setAttribute("thongbao4", thongbao4);
					request.setAttribute("maTuyen",
							Security.stringToHTMLString(maTuyen));
					request.setAttribute("noiDen",
							Security.stringToHTMLString(noiDen));
					request.setAttribute("noiDi",
							Security.stringToHTMLString(noiDi));
					RequestDispatcher rd = request
							.getRequestDispatcher("admin/themtuyen.jsp");
					rd.forward(request, response);
				}
			}
		}

		else {
			response.sendRedirect("DanhsachtuyenServlet");
		}

	}

}
