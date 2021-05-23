package com.pp.servlet.user;

import com.pp.pojo.Price;
import com.pp.service.impl.PriceService;
import com.pp.utils.Json;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showPrice")
public class priceServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Integer id= Integer.valueOf(req.getParameter("id"));
        System.out.println(id);
        PriceService priceService = new PriceService();
        List<Price> price=priceService.showType(id);

//        JSONObject json= Json.receivePost(req);
//        System.out.println(json);

        JSONObject jsonObject=new JSONObject() ;
        PrintWriter out = resp.getWriter(); //响应流
//        for(Price p:price) {
//            out.println(p.getId() + " " + p.getType() + " " + p.getPrice());
//            out.println("<br>");
//        }
        if(id!=null){
            for(Price p:price){
                jsonObject.put("price",JSONObject.fromObject(p));
                out.write(jsonObject.toString());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
