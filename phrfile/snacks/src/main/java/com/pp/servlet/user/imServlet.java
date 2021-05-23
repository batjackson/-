package com.pp.servlet.user;

import com.pp.pojo.Im;
import com.pp.service.impl.ImService;

import jakarta.servlet.annotation.WebServlet;
import net.sf.json.JSONObject;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showIm")
public class imServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Integer id= Integer.valueOf(req.getParameter("id"));
        System.out.println(id);
        ImService imService = new ImService();
        List<Im> im=imService.showIm(id);

        JSONObject jsonObject=new JSONObject() ;
        PrintWriter out = resp.getWriter();

        if(id!=null){
            for(Im i:im){
                jsonObject.put("Im",JSONObject.fromObject(i));
                out.write(jsonObject.toString());
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
