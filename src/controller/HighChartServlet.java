package controller;

import health.model.HealthDiaryService;
import health.model.HealthDiaryVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import register.model.MemberVO;

@WebServlet(urlPatterns = { "/json.view" })
public class HighChartServlet extends HttpServlet {
	private HealthDiaryService service;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HTTP Method=" + request.getMethod());
		service = new HealthDiaryService();
		// 接收資料
		HttpSession session = request.getSession();
		// MemberVO memberVo = (MemberVO)session.getAttribute("user");

		// 轉換資料
		// int memberNo = memberVo.getMemberNo();
		String temp1 = request.getParameter("id");
		String year = request.getParameter("year");
		String month = request.getParameter("month");

		int yearSelect = 0;
		if (year != null && year.trim().length() != 0) {
			yearSelect = Integer.parseInt(year);
		}

		int monthSelect = 0;
		if (month != null && month.trim().length() != 0) {
			monthSelect = Integer.parseInt(month);
		}

		// 呼叫Model
		List<HealthDiaryVO> list = service.gethighChart(Integer.parseInt(temp1), yearSelect, monthSelect);
		JsonArrayBuilder builder = Json.createArrayBuilder();
		JsonArrayBuilder weight = Json.createArrayBuilder();
		JsonArrayBuilder bmi = Json.createArrayBuilder();
		JsonArrayBuilder waistline = Json.createArrayBuilder();
		JsonArrayBuilder array = null;

		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		DecimalFormat df = new DecimalFormat("##.00");

		for (HealthDiaryVO vo : list) {
			array = Json.createArrayBuilder();
			array.add(Integer.parseInt(sdf.format(vo.getDate()))-1);
			array.add(Double.parseDouble(df.format(vo.getWeight())));
			weight.add(array);
		}
		for (HealthDiaryVO vo : list) {
			array = Json.createArrayBuilder();
			array.add(Integer.parseInt(sdf.format(vo.getDate()))-1);
			array.add(Double.parseDouble(df.format(vo.getWaistline())));
			waistline.add(array);
		}
		for (HealthDiaryVO vo : list) {
			array = Json.createArrayBuilder();
			array.add(Integer.parseInt(sdf.format(vo.getDate()))-1);
			array.add(Double.parseDouble(df.format((vo.getHeight()*vo.getHeight()/100)/vo.getWeight())));
			bmi.add(array);
		}
		
		JsonObject obj = Json.createObjectBuilder()
				.add("weight", weight)
				.add("BMI", bmi)
				.add("waistline", waistline)
				.build();
		builder.add(obj);
		String output = builder.build().toString();
		System.out.println(output);

		// 根據Model執行結果...
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(output);
		out.close();
	}

}
