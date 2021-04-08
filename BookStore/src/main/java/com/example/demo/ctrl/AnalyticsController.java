package com.example.demo.ctrl;


import com.example.demo.beans.*;
import com.example.demo.dao.BookDAO;
import com.example.demo.dao.ProductOrderDAO;
import com.example.demo.dao.ProductOrderItemDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {


    @Autowired
    ProductOrderItemDAO pd;


    @Autowired
    AnalyticsService as;

    @Autowired
    UserDAO ud;

    @GetMapping("/year/{year}")
    public Map<String,List<MonthBookSale>> generateMonthlyReport(@PathVariable int year) throws SQLException {
        return as.getMonthlyBookSales(year);

    }

    @GetMapping("/monthly/all")
    public Map<String,List<MonthBookSale>> generateMonthlyReport() throws SQLException {
        return as.getMonthlyBookSales(2021);

    }

    @GetMapping("/top10")
    public List<TopBook> analytics(){

        return pd.getTopTenSoldBooks();
    }

    @GetMapping("/user/report")
    public List<AnnomizedReport> anonymizedReport(){
        return ud.getUserReport();
    }
}
