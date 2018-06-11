package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Reimbursement;
import pojos.User;
import service.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/data")
public class LoadDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Reimbursement> data = new ArrayList<Reimbursement>();

        HttpSession session = req.getSession(false);
        int id = (int) session.getAttribute("userId");
        int role = (int) session.getAttribute("userRoleId");

        ReimbursementService rs = new ReimbursementService();
        ObjectMapper mapper = new ObjectMapper();

        data = rs.getData(id, role);
        System.out.println(data.toString());
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");

        String outJSON = mapper.writeValueAsString(data);
        System.out.println(outJSON);
        out.write(outJSON);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int id = (int) session.getAttribute("userId");

        Stream<String> text = req.getReader().lines();
        String json = text.collect(Collectors.joining("")).toString();

        ObjectMapper mapper = new ObjectMapper();
        Reimbursement r = mapper.readValue(json, Reimbursement.class);

        ReimbursementService rs = new ReimbursementService();
        rs.addReimbursement(id, r.getAmount(), r.getDescription(), r.getType_id());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("In doPut");
        HttpSession session = req.getSession(false);

        Stream<String> text = req.getReader().lines();
        String json = text.collect(Collectors.joining("")).toString();

        ObjectMapper mapper = new ObjectMapper();
        Reimbursement r = mapper.readValue(json, Reimbursement.class);

        ReimbursementService rs = new ReimbursementService();
//        rs.updateReimbursement(id, status);

        Reimbursement temp = rs.getByReimbId(r.getId());
        temp.setStatus_id(r.getStatus_id());


        int userId = (int) session.getAttribute("userId");
        System.out.println("Session UserID: "+userId);

        //
        temp.setResolver_id(userId);
        rs.updateReimbursement(r.getId(), r.getStatus_id(), r.getResolver_id());
        System.out.println("ID: "+r.getId()+" STATUS: "+r.getStatus_id()+" RESOLVER ID: "+r.getResolver_id());
        //
    }

    protected void setReimbInSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ReimbursementService rs = new ReimbursementService();
        ObjectMapper mapper = new ObjectMapper();
        Stream<String> text = req.getReader().lines();
        String json = text.collect(Collectors.joining("")).toString();
        Reimbursement r = mapper.readValue(json, Reimbursement.class);

        r = rs.getByReimbId(r.getId());
        if(r != null) {
            HttpSession session = req.getSession(false);
            session.setAttribute("reimbId", r.getId());
            session.setAttribute("reimbStatusId", r.getStatus_id());
            session.setAttribute("resolverId", r.getResolver_id());
        }

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");

        String outJSON = mapper.writeValueAsString(r);
        out.write(outJSON);
    }

}