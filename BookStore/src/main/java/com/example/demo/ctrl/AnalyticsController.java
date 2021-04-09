package com.example.demo.ctrl;


import com.example.demo.beans.AnnomizedReport;
import com.example.demo.beans.MonthBookSale;
import com.example.demo.beans.TopBook;
import com.example.demo.dao.ProductOrderItemDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/*
    Controller to handle analytics mappings
    used for admins
*/
@RestController
@RequestMapping("/analytics")
public class AnalyticsController {


    @Autowired
    ProductOrderItemDAO pd;


    @Autowired
    AnalyticsService as;

    @Autowired
    UserDAO ud;


    //get all sales in a given year
    @GetMapping("/year/{year}")
    public Map<String,List<MonthBookSale>> generateMonthlyReport(@PathVariable int year) throws SQLException {
        return as.getMonthlyBookSales(year);

    }


    //get all sales in year 2021 by month (default)
    @GetMapping("/monthly/all")
    public Map<String,List<MonthBookSale>> generateMonthlyReport() throws SQLException {
        return as.getMonthlyBookSales(2021);

    }


    //get top 10 sold books
    @GetMapping("/top10")
    public List<TopBook> analytics(){

        return pd.getTopTenSoldBooks();
    }

    //generate annomized user report
    @GetMapping("/user/report")
    public List<AnnomizedReport> anonymizedReport(){
        return ud.getUserReport();
    }
}
